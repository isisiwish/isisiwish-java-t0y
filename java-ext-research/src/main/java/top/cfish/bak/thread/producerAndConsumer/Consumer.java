package top.cfish.bak.thread.producerAndConsumer;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: isisiwish
 * @date: 2019/1/23
 * @time: 11:30
 */

@Slf4j
public class Consumer extends Thread
{
    BlockingQueueLite<String> queue;
    
    public Consumer(BlockingQueueLite<String> queue)
    {
        this.queue = queue;
    }
    
    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                String task = queue.take();
                log.info("Consumer task " + task);
                Thread.sleep((int)(Math.random() * 100));
            }
        }
        catch (InterruptedException e)
        {
            log.error("", e);
        }
    }
}

