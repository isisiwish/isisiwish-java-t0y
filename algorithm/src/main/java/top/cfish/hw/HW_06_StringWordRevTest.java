package top.cfish.hw;

import java.util.Scanner;

/**
 * @author: isisiwish
 * @date: 2019/12/5
 * @time: 22:01
 */
public class HW_06_StringWordRevTest
{
    public static String stringWordRev(String str)
    {
        StringBuffer sb = new StringBuffer();
        boolean flag = false;
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <='z' || ch >= 'A' && ch <= 'z')
            {
                sb.append(ch);
                flag = true;
            }
            else
            {
                if (flag)
                {
                    sb.append(" ");
                    flag = false;
                }
            }
        }
        String[] strs = sb.toString().split(" ");
        StringBuffer ret = new StringBuffer();
        for (int i = strs.length-1; i >= 0; i--)
        {
            ret.append(strs[i]);
            ret.append(" ");
        }
        return ret.toString();
    }
    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(stringWordRev(input));
    }
}
