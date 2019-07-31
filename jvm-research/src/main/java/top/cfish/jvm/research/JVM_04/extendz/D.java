package top.cfish.jvm.research.JVM_04.extendz;

/**
 * @author: isisiwish
 * @date: 2019/6/10
 * @time: 21:13
 */
public class D extends C
{
    private int i = test();
    private static int j = method();
    
    static
    {
        System.out.print("(6)");
    }
    
    D()
    {
        System.out.print("(7)");
    }
    
    {
        System.out.print("(8)");
    }
    
    @Override
    public int test()
    {
        System.out.print("(9)");
        return 1;
    }
    
    public static int method()
    {
        System.out.print("(10)");
        return 1;
    }
    
    public static void main(String[] args)
    {
        D s1 = new D();
        System.out.println();
        D s2 = new D();
    }
}

