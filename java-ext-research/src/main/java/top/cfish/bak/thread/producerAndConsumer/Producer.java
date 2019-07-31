package top.cfish.bak.thread.producerAndConsumer;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: isisiwish
 * @date: 2019/1/23
 * @time: 11:18
 */

@Slf4j
public class Producer extends Thread
{
    BlockingQueueLite<String> queue;
    
    public Producer(BlockingQueueLite<String> queue)
    {
        this.queue = queue;
    }
    
    @Override
    public void run()
    {
        int num = 0;
        try
        {
            while (true)
            {
                String task = String.valueOf(num);
                queue.put(task);
                log.info("Producer task " + task);
                num++;
                Thread.sleep((int)(Math.random() * 100));
            }
        }
        catch (InterruptedException e)
        {
            log.error("", e);
        }
    }
}
