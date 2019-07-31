package top.cfish.testng.方法依赖;

import org.testng.annotations.Test;

/**
 * @author: isisiwish
 * @date: 2019/6/13
 * @time: 10:46
 */
public class CaseDependenciesTest
{
    @Test(dependsOnMethods = {"testMethod2"})
    public void testMethod1()
    {
        System.out.println("testMethod1");
    }
    
    @Test(dependsOnMethods = {"testMethod3"})
    public void testMethod2()
    {
        System.out.println("testMethod2");
    }
    
    @Test
    public void testMethod3()
    {
        System.out.println("testMethod3");
    }
}
