package top.cfish.jvm.research.JVM_04.extendz;

/**
 * @author: isisiwish
 * @date: 2019/6/10
 * @time: 20:55
 */
public class B extends A
{
    public static final String HELLOWORD = "hello word";
    
    static
    {
        System.out.println("B init");
    }
    public B()
    {
        System.out.println("B Instance");
    }
    
    public static void main(String[] args)
    {
        // A a = new B();
        // B[] arr = new B[10];
        System.out.println(B.HELLOWORD);
    }
}
