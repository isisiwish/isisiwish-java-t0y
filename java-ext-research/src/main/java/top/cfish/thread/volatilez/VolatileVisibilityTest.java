package top.cfish.thread.volatilez;

import lombok.extern.slf4j.Slf4j;
import top.cfish.thread.annotation.ThreadNotSafe;

/**
 * @author: isisiwish
 * @date: 2019/3/1
 * @time: 16:50
 */

@ThreadNotSafe
@Slf4j
public class VolatileVisibilityTest
{
    public static volatile int value = 0;
    
    // volatile只保证内存读写时为真实值，但是无法保证自增操作的原子特性，如果需要保证原子特性，需要使用锁等同步机制
    public static void inc()
    {
        value++;
    }
    
    public static void main(String[] args) throws InterruptedException
    {
        Thread threadA = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 1000; i++)
                {
                    VolatileVisibilityTest.inc();
                    try
                    {
                        Thread.sleep(20);
                    }
                    catch (InterruptedException e)
                    {
                        log.error("", e);
                    }
                }
            }
        });
    
        Thread threadB = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 1000; i++)
                {
                    VolatileVisibilityTest.inc();
                    try
                    {
                        Thread.sleep(30);
                    }
                    catch (InterruptedException e)
                    {
                        log.error("", e);
                    }
                }
            }
        });
        
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        
        log.info("value: {}", value);
    }
}
