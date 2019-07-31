package top.cfish.algorithm.stack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: isisiwish
 * @date: 2018/9/18
 * @time: 16:18
 */
public class ArrayStackTest
{
    @Test
    public void Test()
    {
        ArrayStack<Integer> stack = new ArrayStack<>();
        
        for (int i = 0; i < 5; i++)
        {
            stack.push(i);
            System.out.println(stack);
        }
        
        stack.pop();
        System.out.println(stack);
    }
}
