package top.cfish.lintcode;

/**
 * @author: isisiwish
 * @date: 2019/1/10
 * @time: 17:26
 * https://www.lintcode.com/problem/a-b-problem/description
 */
public class Solution_0001
{
    static class NumberOverflowException extends Exception
    {
        public NumberOverflowException()
        {
        }
    
        public NumberOverflowException(String message)
        {
            super(message);
        }
    }
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b
     */
    static public int aplusb(int a, int b) throws NumberOverflowException
    {
        int rs = a + b;
        
        // 防止整型运算溢出
        // 参考http://www.cnblogs.com/hackerl/p/5997177.html
        if (a > 0 && b > 0 && rs < 0)
        {
            throw new NumberOverflowException("整数溢出");
        }
        if (a < 0 && b < 0 && rs > 0)
        {
            throw new NumberOverflowException("整数溢出");
        }
        return rs;
    }
    
    public static void main(String[] args) throws Exception
    {
        System.out.println(aplusb(1, 2));
    }
}
