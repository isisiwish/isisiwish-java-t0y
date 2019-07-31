package top.cfish.jvm.research.JVM_03;

/**
 * @author: isisiwish
 * @date: 2019/6/10
 * @time: 15:35
 */
public class JVM_03_LoopTest
{
    public static int[] numbers = new int[]{1, 2, 3};
    
    public static void main(String[] args)
    {
        for (int number : numbers)
        {
            System.out.println(number);
        }
    }
}
