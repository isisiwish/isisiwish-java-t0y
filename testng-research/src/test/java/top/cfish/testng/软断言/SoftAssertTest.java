package top.cfish.testng.软断言;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest
{
    @Test
    public void testSoftAssert()
    {
        SoftAssert sa = new SoftAssert();
        System.out.println("测试方法->测试两个数相加");
        int result = 1 + 2;
      
        sa.assertEquals(result, 0);
        System.out.println("Assert 1 执行完成");
      
        sa.assertEquals(result, 3);
        System.out.println("Assert 2 执行完成");
      
        sa.assertAll();
    }
}
