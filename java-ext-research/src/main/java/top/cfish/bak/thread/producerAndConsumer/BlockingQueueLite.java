package top.cfish.bak.thread.producerAndConsumer;

import top.cfish.thread.annotation.ThreadSafe;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: isisiwish
 * @date: 2019/1/23
 * @time: 10:43
 */
@ThreadSafe
public class BlockingQueueLite<T>
{
    private Queue<T> queue = null;
    private int limit;
    
    public BlockingQueueLite(int limit)
    {
        this.limit = limit;
        queue = new ArrayDeque<>(limit);
    }
    
    public synchronized void put(T e) throws InterruptedException
    {
        while (queue.size() == limit)
        {
            wait();
        }
        
        queue.add(e);
        notifyAll();
    }
    
    public synchronized T take() throws InterruptedException
    {
        while (queue.isEmpty())
        {
            wait();
        }
        
        T e = queue.poll();
        notifyAll();
        return e;
    }
}
