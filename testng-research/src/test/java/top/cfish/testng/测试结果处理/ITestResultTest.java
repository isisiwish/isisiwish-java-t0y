package top.cfish.testng.测试结果处理;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * @author: isisiwish
 * @date: 2019/6/13
 * @time: 11:18
 */
public class ITestResultTest
{
    @Test
    public void testMethod1()
    {
        System.out.println("Running -> testMethod1");
        Assert.assertTrue(false);
    }
    
    @Test
    public void testMethod2()
    {
        System.out.println("Running -> testMethod2");
        Assert.assertTrue(true);
    }
    
    @AfterMethod
    public void afterMethod(ITestResult testResult)
    {
        if (testResult.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("ITestResult Failed : " + testResult.getMethod().getMethodName());
        }
        
        if (testResult.getStatus() == ITestResult.SUCCESS)
        {
            System.out.println("ITestResult Successful : " + testResult.getName());
        }
    }
}
