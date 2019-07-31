package top.cfish.thread.volatilez;

import lombok.extern.slf4j.Slf4j;
import top.cfish.thread.annotation.ThreadSafe;

/**
 * @author: isisiwish
 * @date: 2019/3/1
 * @time: 17:02
 */

@ThreadSafe
@Slf4j
public class VolatileSafeTest
{
    volatile boolean shutdown;
    
    public void close()
    {
        shutdown = true;
    }
    
    public void dowork()
    {
        // 读，原子操作
        while (!shutdown)
        {
            log.info("safe....");
        }
    }
    
    public static void main(String[] args) throws InterruptedException
    {
        VolatileSafeTest o = new VolatileSafeTest();
        
        Thread threadA = new Thread(new Runnable()
        {
           @Override
           public void run()
           {
               o.dowork();
           }
        });
    
        Thread threadB = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                o.close();
            }
        });
        
        threadA.start();
        Thread.sleep(5000);
        threadB.start();
        log.info("main thread end");
    }
}
