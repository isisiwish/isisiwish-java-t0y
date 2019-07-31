package top.cfish.thread.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: isisiwish
 * @date: 2019/1/22
 * @time: 13:28
 */

@Slf4j
public class SynchronizedObjectTest
{
    // 修饰代码块
    public void testA(String name)
    {
        synchronized (this)
        {
            for (int i = 0; i < 10; i++)
            {
                log.info("test{} - {}", name, i);
            }
        }
    }
    
    // 修饰方法
    public synchronized void testB(String name)
    {
        for (int i = 0; i < 10; i++)
        {
            log.info("test{} - {}", name, i);
        }
    }
    
    public static void main(String[] args)
    {
        SynchronizedObjectTest example1 = new SynchronizedObjectTest();
        SynchronizedObjectTest example2 = new SynchronizedObjectTest();
        
        ExecutorService executorService = Executors.newCachedThreadPool();
        
        executorService.execute(()->
        {
            example1.testB("A");
        });
        
        executorService.execute(()->
        {
            example2.testB("B");
        });
        
        executorService.shutdown();
    }
}
