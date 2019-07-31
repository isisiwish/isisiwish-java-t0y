package top.cfish.jvm.research.JVM_04.extendz;

/**
 * @author: isisiwish
 * @date: 2019/6/10
 * @time: 21:13
 */
public class C
{
    private int i = test();
    private static int j = method();
    
    static
    {
        System.out.print("(1)");
    }
    
    C()
    {
        System.out.print("(2)");
    }
    
    {
        System.out.print("(3)");
    }
    
    public int test()
    {
        System.out.print("(4)");
        return 1;
    }
    
    public static int method()
    {
        System.out.print("(5)");
        return 1;
    }
}
// 1-5-6-10-3-2-4-8-7-9
