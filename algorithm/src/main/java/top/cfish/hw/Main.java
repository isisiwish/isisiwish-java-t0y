package top.cfish.hw;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author: isisiwish
 * @date: 2019/12/7 0007
 * @time: 20:58
 */
public class Main
{
    // IO错误返回，题目未给出说明，使用null作为错误返回
    public static final String ERROR_RESULT = null;
    
    /**
     * 检查字符串是否为null或空字符串""
     * @param str
     * @return 空或空字符串返回true；非空字符串返回false
     */
    public static boolean isEmpty(String str)
    {
        return ((str == null) || (str.length() == 0));
    }
    
    /**
     * 检查字符串是否包含非[0,9]字符
     * @param str
     * @return 字符串非空，且只包含[0,9]字符，返回true；否则返回false
     */
    public static boolean isDigitString(String str)
    {
        if (isEmpty(str))
        {
            return false;
        }
        
        for (int i = 0; i < str.length(); i++)
        {
            if (!Character.isDigit(str.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 大整数相乘，输入为二段式的乘数和被乘数，通过空格分隔
     * @param inputString
     * @return 以字符串的形式返回乘积；如果输入格式或内容不正确，方法返回null
     */
    public static String bigMul(String inputString)
    {
        if (isEmpty(inputString))
        {
            // 输入内容为空
            return ERROR_RESULT;
        }
        
        // 通过空格分隔二段式输入
        String[] split = inputString.split(" ");
    
        // 输入格式错误，请用空格作为乘数和被乘数的分隔
        if (split.length == 0 || split.length == 1)
        {
            return ERROR_RESULT;
        }
        else
        {
            // TIPS - 如果输入超过一个分隔，只取前两字段分别作为乘数和被乘数，忽略剩余输入
            String strNumA = split[0];
            String strNumB = split[1];
    
            // 判断两段输入都为数字字符
            if (isDigitString(strNumA) && isDigitString(strNumB))
            {
                // 使用Java提供BigDecimal类进行大数乘法计算
                BigDecimal numberA = new BigDecimal(strNumA);
                BigDecimal numberB = new BigDecimal(strNumB);
                BigDecimal result = numberA.multiply(numberB);
                return result.toString();
            }
        }
        return ERROR_RESULT;
    }
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine())
        {
            String input = in.nextLine();
            System.out.println(bigMul(input));
        }
    }
}
