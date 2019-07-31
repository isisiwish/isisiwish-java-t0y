package top.cfish.algorithm.queue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: isisiwish
 * @date: 2018/9/18
 * @time: 16:16
 */
public class LinkedListQueueTest
{
    @Test
    public void Test()
    {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++)
        {
            queue.enqueue(i);
            System.out.println(queue);
            
            if (i % 3 == 2)
            {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
