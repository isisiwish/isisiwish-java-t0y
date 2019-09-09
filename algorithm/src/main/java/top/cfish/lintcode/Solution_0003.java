package top.cfish.lintcode;

/**
 * @author: isisiwish
 * @date: 2019/1/10
 * @time: 20:49
 */
public class Solution_0003
{
    static public int digitCounts(int k, int n)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++)
        {
            sb.append(String.valueOf(i));
        }
        
        int count = 0;
        String str = sb.toString();
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (ch == k + '0')
            {
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args)
    {
        System.out.println(digitCounts(0, 12));
    }
}

