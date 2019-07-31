package top.cfish.algorithm.stack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: isisiwish
 * @date: 2018/9/18
 * @time: 16:19
 */
public class LinkedListStackTest
{
    @Test
    public void test()
    {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        
        for (int i = 0; i < 5; i++)
        {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
