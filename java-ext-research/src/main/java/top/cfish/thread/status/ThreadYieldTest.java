package top.cfish.thread.status;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: isisiwish
 * @date: 2019/1/22
 * @time: 10:35
 */

@Slf4j
public class ThreadYieldTest
{
    /**
     * Thread.yield();
     * 通知线程调度器，当前线程让出CPU资源，但该通知可能不生效
     */
    public static void main(String[] args)
    {
        Runnable runnable = new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 10; i++)
                {
                    log.info("{} - {}", Thread.currentThread().getName(), i);
                    if (i == 5)
                    {
                        Thread.yield();
                    }
                }
            }
        };
        
        Thread t1 = new Thread(runnable, "A");
        Thread t2 = new Thread(runnable, "B");
        t1.start();
        t2.start();
    }
}
