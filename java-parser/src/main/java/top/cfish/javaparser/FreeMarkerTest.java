package top.cfish.javaparser;

import com.google.common.collect.Lists;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: isisiwish
 * @date: 2019/7/19
 * @time: 17:19
 */
public class FreeMarkerTest
{
    public static void main(String[] args) throws Exception
    {
        String dir = "E:\\Github\\java-toy\\java-parser\\src\\main\\resources";
        Configuration conf = new Configuration();
        // 加载模板文件(模板的路径)
        conf.setDirectoryForTemplateLoading(new File(dir));
        // 加载模板
        // Template template = conf.getTemplate("/freemarker-php.ftl");
        Template template = conf.getTemplate("/freemarker-php-is-null.ftl");
    
        // 定义数据
        Map map = new HashMap();
        TestInfo testInfo = new TestInfo();
        testInfo.setClassName("DangdangOrdersOuterorderidUpdateTest");
        List<MethodInfo> list = Lists.newArrayList();
        
        MethodInfo methodInfoA = new MethodInfo();
        methodInfoA.setName("case1");
        methodInfoA.setCaseId("1833");
        // methodInfoA.setSdkVersion("1.0");
        methodInfoA.setRequestName("OrdersOuterOrderIdUpdateRequest");
        list.add(methodInfoA);
    
        MethodInfo methodInfoB = new MethodInfo();
        methodInfoB.setName("case2");
        methodInfoB.setCaseId("1835");
        methodInfoB.setSdkVersion("2.0");
        methodInfoB.setRequestName("OrdersOuterOrderIdUpdateRequest");
        list.add(methodInfoB);
        
        testInfo.setMethodList(list);
        
        map.put("TestInfo", testInfo);
        
        // 定义输出
        Writer out = new FileWriter(dir + "/freemarker.php");
        template.process(map, out);
        System.out.println("转换成功");
        
        out.flush();
        out.close();
    }
}
