package top.cfish.jvm.research.JVM_04;

/**
 * @author: isisiwish
 * @date: 2019/6/10
 * @time: 21:20
 */
public class LocalTest
{
    // int a;
    //
    // public static void main(String[] args)
    // {
    //     LocalTest localTest = new LocalTest();
    //     System.out.println(localTest.a);
    // }
    
    // public void foo()
    // {
    //     int b;
    //     System.out.println(b);
    // }
    //
    // public static void main(String[] args)
    // {
    //     LocalTest localTest = new LocalTest();
    //     localTest.foo();
    // }
    
    private int a;
    private static int b = 199;
    
    static
    {
        System.out.println("log from static block");
    }
    
    public LocalTest()
    {
        System.out.println("log from constructor block");
    }
    
    {
        System.out.println("log from init block");
    }
    
    public static void main(String[] args)
    {
        LocalTest localTest = new LocalTest();
    }
}
