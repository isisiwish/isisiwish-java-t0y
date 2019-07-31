package top.cfish.jvm.research.JVM_03;

/**
 * @author: isisiwish
 * @date: 2019/6/10
 * @time: 19:56
 */
public class JVM_03_SwitchTest
{
    public static int chooseNear(int i)
    {
        switch (i)
        {
            case 100:
                return 0;
            case 101:
                return 1;
            case 104:
                return 4;
            default:
                return -1;
        }
    }
    
    public static void main (String[]args)
    {
        int i = 101;
        int rs = chooseNear(i);
        System.out.println(rs);
    }
}
