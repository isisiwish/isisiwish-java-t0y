package top.cfish.algorithm.queue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: isisiwish
 * @date: 2018/9/18
 * @time: 16:17
 */
public class LoopQueueTest
{
    @Test
    public void Test()
    {
        LoopQueue<Integer> queue = new LoopQueue<>(3);
        
        queue.enqueue(0);
        System.out.println(queue);
        queue.enqueue(1);
        System.out.println(queue);
        queue.enqueue(2);
        System.out.println(queue);
        queue.enqueue(3);
        System.out.println(queue);
        
        queue.dequeue();
        System.out.println(queue);
        
        queue.enqueue(4);
        System.out.println(queue);
        queue.enqueue(5);
        System.out.println(queue);
    }
}
