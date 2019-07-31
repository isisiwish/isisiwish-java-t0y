package top.cfish.leetcode.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @author: isisiwish
 * @date: 2018/8/28
 * @time: 16:44
 * No.20
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 */

public class 括号匹配_20
{
    public boolean isValid(String s)
    {
        // YuArrayStack<Character> stack = new YuArrayStack<>();
        // 使用系统Stack提交
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
            {
                stack.push(c);
            }
            else if (c == ')' || c == '}' || c == ']')
            {
                if (stack.isEmpty())
                {
                    return false;
                }
                Character top = stack.pop();
                if (c == ')' && top != '(')
                {
                    return false;
                }
                else if (c == ']' && top != '[')
                {
                    return false;
                }
                else if (c == '}' && top != '{')
                {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    @Test
    public void isValidTest()
    {
        Assert.assertTrue((new 括号匹配_20()).isValid("()"));
        Assert.assertTrue((new 括号匹配_20()).isValid("()[]{}"));
        Assert.assertTrue((new 括号匹配_20()).isValid("{[]}"));
        Assert.assertFalse((new 括号匹配_20()).isValid("(]"));
        Assert.assertFalse((new 括号匹配_20()).isValid("([)]"));
    }
}
