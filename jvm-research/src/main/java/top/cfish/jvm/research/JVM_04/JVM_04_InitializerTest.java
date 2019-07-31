package top.cfish.jvm.research.JVM_04;

/**
 * @author: isisiwish
 * @date: 2019/6/10
 * @time: 20:32
 */
public class JVM_04_InitializerTest
{
    static int a;
    static int b;
    
    static
    {
        a = 1;
        b = 2;
    }
    
    public static void main(String[] args)
    {
        JVM_04_InitializerTest init = new JVM_04_InitializerTest();
    }
}
