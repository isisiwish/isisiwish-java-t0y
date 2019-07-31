package top.cfish.testng.执行顺序;

import org.testng.annotations.Test;


public class CaseOrderTest
{
    @Test(priority = 30)
    public void testMethod1()
    {
        System.out.println("testMethod1");
    }
    
    @Test(priority = 10)
    public void testMethod2()
    {
        System.out.println("testMethod2");
    }
    
    @Test(priority = 20)
    public void testMethod3()
    {
        System.out.println("testMethod3");
    }
    
    @Test
    public void testMethodA()
    {
        System.out.println("testMethodA");
    }
    
    @Test
    public void testMethodB()
    {
        System.out.println("testMethodB");
    }
    
    @Test
    public void testMethodC()
    {
        System.out.println("testMethodC");
    }
}
