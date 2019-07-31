package top.cfish.algorithm.queue;

import org.junit.Assert;
import org.junit.Test;
import top.cfish.algorithm.inface.IQueue;

import java.util.Random;

/**
 * @author: isisiwish
 * @date: 2018/8/29
 * @time: 11:25
 */
public class LoopQueueExTest
{
    private static double testQueue(IQueue<Integer> queue, int opCount)
    {
        Random random = new Random();
        
        long startTime = System.nanoTime();
        
        for (int i = 0; i < opCount; i++)
        {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        
        for (int i = 0; i < opCount; i++)
        {
            queue.dequeue();
        }
        
        long endTime = System.nanoTime();
        
        return (endTime - startTime) / 1000000000.0;
    }
    
    @Test
    public void queueTest()
    {
        int opCount = 100000;
        
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double arrayQueueTime = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + arrayQueueTime + "s");
        
        LoopQueueEx<Integer> loopQueue = new LoopQueueEx<>();
        double loopQueueTime = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + loopQueueTime + "s");
        
        Assert.assertTrue(arrayQueueTime > loopQueueTime);
    }
    
    @Test
    public void test()
    {
        LoopQueueEx<Integer> queue = new LoopQueueEx<>(3);
        
        for (int i = 0; i < 100; i++)
        {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2)
            {
                queue.dequeue();
                System.out.println(queue);
            }
        }
        queue.clear();
    }
}
