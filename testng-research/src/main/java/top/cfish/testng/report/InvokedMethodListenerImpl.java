package top.cfish.testng.report;

import lombok.extern.slf4j.Slf4j;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

/**
 * @author: isisiwish
 * @date: 2019/6/12
 * @time: 15:28
 *
 * 测试方法被执行前和执行后执行特定的逻辑，有点类似AOP，具体结合CI需求修改
 */
@Slf4j
public class InvokedMethodListenerImpl implements IInvokedMethodListener
{
    private long startTime = 0;
    
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult)
    {
        
        if (method.isTestMethod())
        {
            ITestNGMethod m = method.getTestMethod();
            String methodName = m.getConstructorOrMethod().getName();
            String className = m.getTestClass().getRealClass().getSimpleName();
            
            log.info("[Begin] {}.{}", className, methodName);
        }
    }
    
    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult)
    {
        if (method.isTestMethod())
        {
            ITestNGMethod m = method.getTestMethod();
            String methodName = m.getConstructorOrMethod().getName();
            String className = m.getTestClass().getRealClass().getSimpleName();
            int status = testResult.getStatus();
            
            String statusText = "Unknown";
            switch (status)
            {
                case ITestResult.SUCCESS:
                    statusText = "Passed";
                    break;
                case ITestResult.FAILURE:
                    statusText = "Failed";
                    break;
                case ITestResult.SKIP:
                    statusText = "Skipped";
                    break;
                default:
                    break;
            }
            log.info("[End] {}.{} : {}", className , methodName, statusText);
        }
    }
}
