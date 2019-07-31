package top.cfish.testng.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ResourceCDN;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.TestAttribute;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lombok.extern.slf4j.Slf4j;
import org.testng.*;
import org.testng.xml.XmlSuite;
import top.cfish.testng.util.NetUtil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: isisiwish
 * @date: 2019/6/12
 * @time: 15:30
 */
@Slf4j
public class ReporterListenerImpl implements IReporter
{
    private static final String OUTPUT_FOLDER = "./test-output/";
    private static final String FILE_NAME = "report.html";
    
    private ExtentReports extent;
    
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory)
    {
        init(xmlSuites);
        
        boolean createSuiteNode = false;
        if (suites.size() > 1)
        {
            createSuiteNode = true;
        }
        for (ISuite suite : suites)
        {
            Map<String, ISuiteResult> result = suite.getResults();
            
            // 如果suite里面没有任何用例，直接跳过，不在报告里生成
            if (result.size() == 0)
            {
                continue;
            }
            
            // 统计suite下的成功、失败、跳过的总用例数
            int suiteFailSize = 0;
            int suitePassSize = 0;
            int suiteSkipSize = 0;
            ExtentTest suiteTest = null;
            
            // 存在多个suite的情况下，报告中将同一个一个suite的测试结果归为一类，创建一级节点
            if (createSuiteNode)
            {
                suiteTest = extent.createTest(suite.getName()).assignCategory(suite.getName());
            }
            
            boolean createSuiteResultNode = false;
            if (result.size() > 1)
            {
                createSuiteResultNode = true;
            }
            for (ISuiteResult r : result.values())
            {
                ExtentTest resultNode;
                ITestContext context = r.getTestContext();
                if (createSuiteResultNode)
                {
                    // 没有创建suite的情况下，将在SuiteResult的创建为一级节点，否则创建为suite的一个子节点
                    if (null == suiteTest)
                    {
                        resultNode = extent.createTest(r.getTestContext().getName());
                    }
                    else
                    {
                        resultNode = suiteTest.createNode(r.getTestContext().getName());
                    }
                }
                else
                {
                    resultNode = suiteTest;
                }
                
                if (resultNode != null)
                {
                    resultNode.getModel().setName(suite.getName() + " : " + r.getTestContext().getName());
                    
                    if (resultNode.getModel().hasCategory())
                    {
                        resultNode.assignCategory(r.getTestContext().getName());
                    }
                    else
                    {
                        resultNode.assignCategory(suite.getName(), r.getTestContext().getName());
                    }
                    resultNode.getModel().setStartTime(r.getTestContext().getStartDate());
                    resultNode.getModel().setEndTime(r.getTestContext().getEndDate());
                    
                    // 统计SuiteResult下的数据
                    int passSize = r.getTestContext().getPassedTests().size();
                    int failSize = r.getTestContext().getFailedTests().size();
                    int skipSize = r.getTestContext().getSkippedTests().size();
                    suitePassSize += passSize;
                    suiteFailSize += failSize;
                    suiteSkipSize += skipSize;
                    if (failSize > 0)
                    {
                        resultNode.getModel().setStatus(Status.FAIL);
                    }
                    resultNode.getModel().setDescription(String.format("Pass: %s ; Fail: %s ; Skip: %s ;", passSize, failSize, skipSize));
                }
                buildTestNodes(resultNode, context.getFailedTests(), Status.FAIL);
                buildTestNodes(resultNode, context.getSkippedTests(), Status.SKIP);
                buildTestNodes(resultNode, context.getPassedTests(), Status.PASS);
            }
            
            if (suiteTest != null)
            {
                suiteTest.getModel().setDescription(String.format("Pass: %s ; Fail: %s ; Skip: %s ;", suitePassSize, suiteFailSize, suiteSkipSize));
                if (suiteFailSize > 0)
                {
                    suiteTest.getModel().setStatus(Status.FAIL);
                }
            }
        }
        
        extent.flush();
    }
    
    private void init(List<XmlSuite> xmlSuites)
    {
        String reportTitle = "";
        try
        {
            StringBuffer sb = new StringBuffer();
            for (XmlSuite suite : xmlSuites)
            {
                sb.append(suite.getName());
                sb.append(":");
            }
            reportTitle = sb.substring(0, sb.length() - 1).toString() + "report";
        }
        catch (Exception e)
        {
            log.error("TestNG配置文件缺少suite", e);
            reportTitle = "report";
        }
        
        File reportDir = new File(OUTPUT_FOLDER);
        if (!reportDir.exists() && !reportDir.isDirectory())
        {
            reportDir.mkdir();
        }
        
        String date = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(OUTPUT_FOLDER + date + "-" + FILE_NAME);
        
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setEncoding("UTF-8");
        htmlReporter.config().setTimeStampFormat("yyyy-MM-dd HH:mm:ss");
        htmlReporter.config().setCSS(".node.level-1  ul{ display:none;} .node.level-1.active ul{display:block;}");
        htmlReporter.config().setDocumentTitle(reportTitle);
        htmlReporter.config().setReportName(reportTitle);
        htmlReporter.config().setResourceCDN(ResourceCDN.EXTENTREPORTS);
        htmlReporter.setAppendExisting(false);
        
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);
        extent.setSystemInfo("Java version", System.getProperty("java.version"));
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("IP", NetUtil.getLocalIp());
    }
    
    private void buildTestNodes(ExtentTest extenttest, IResultMap tests, Status status)
    {
        // 存在父节点时，获取父节点的标签
        String[] categories = new String[0];
        if (extenttest != null)
        {
            List<TestAttribute> categoryList = extenttest.getModel().getCategoryContext().getAll();
            categories = new String[categoryList.size()];
            for (int index = 0; index < categoryList.size(); index++)
            {
                categories[index] = categoryList.get(index).getName();
            }
        }
        
        ExtentTest test = null;
        
        if (tests.size() > 0)
        {
            // 调整用例排序，按时间排序
            Set<ITestResult> treeSet = new TreeSet<ITestResult>(new Comparator<ITestResult>()
            {
                @Override
                public int compare(ITestResult o1, ITestResult o2)
                {
                    return o1.getStartMillis() < o2.getStartMillis() ? -1 : 1;
                }
            });
            
            treeSet.addAll(tests.getAllResults());
            for (ITestResult result : treeSet)
            {
                Object[] parameters = result.getParameters();
                String name = "";
                // 如果有参数，则使用参数的toString组合代替报告中的name
                for (Object param : parameters)
                {
                    name += param.toString();
                }
                if (name.length() > 0)
                {
                    if (name.length() > 50)
                    {
                        name = name.substring(0, 49) + "...";
                    }
                }
                else
                {
                    name = result.getMethod().getMethodName();
                }
                if (extenttest == null)
                {
                    test = extent.createTest(name);
                }
                else
                {
                    // 作为子节点进行创建时，设置同父节点的标签一致，便于报告检索。
                    test = extenttest.createNode(name).assignCategory(categories);
                }
                for (String group : result.getMethod().getGroups())
                {
                    test.assignCategory(group);
                }
                
                List<String> outputList = Reporter.getOutput(result);
                for (String output : outputList)
                {
                    // 将用例的log输出报告中
                    test.debug(output);
                }
                if (result.getThrowable() != null)
                {
                    test.log(status, result.getThrowable());
                }
                else
                {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }
                
                test.getModel().setStartTime(getTime(result.getStartMillis()));
                test.getModel().setEndTime(getTime(result.getEndMillis()));
            }
        }
    }
    
    private Date getTime(long millis)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}
