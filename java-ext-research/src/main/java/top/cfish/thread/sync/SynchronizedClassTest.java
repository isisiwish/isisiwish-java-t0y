package top.cfish.thread.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: isisiwish
 * @date: 2019/1/22
 * @time: 13:43
 */
@Slf4j
public class SynchronizedClassTest
{
    // 修饰类
    public static void testA(String name)
    {
        synchronized (SynchronizedClassTest.class)
        {
            for (int i = 0; i < 1000; i++)
            {
                log.info("test1 {} - {}", name, i);
                // 即便使用sleep，不释放类锁，依然会等待循环执行完成，才释放锁
                try
                {
                    Thread.sleep(200);
                }
                catch (InterruptedException e)
                {
                    log.error("", e);
                }
            }
        }
    }
    
    // 修饰静态方法
    public static synchronized void testB(String name)
    {
        for (int i = 0; i < 1000; i++)
        {
            log.info("test2 {} - {}", name, i);
        }
    }
    
    public static void mainA(String[] args)
    {
        // o1和o2都是SynchronizedClassTest类型的对象
        SynchronizedClassTest o1 = new SynchronizedClassTest();
        SynchronizedClassTest o2 = new SynchronizedClassTest();
        
        ExecutorService executorService = Executors.newCachedThreadPool();
        
        // 谁先进入，持有类锁，谁先全部执行完，释放锁；另一线程进入执行
        executorService.execute(()->
        {
            o1.testA("A");
        });
        
        executorService.execute(()->
        {
            o2.testA("B");
        });
        
        executorService.shutdown();
    }
    
    public static void main(String[] args)
    {
        // o1和o2都是SynchronizedClassTest类型的对象
        SynchronizedClassTest o1 = new SynchronizedClassTest();
        SynchronizedClassTest o2 = new SynchronizedClassTest();
        
        ExecutorService executorService = Executors.newCachedThreadPool();
        
        // 谁先进入，持有类锁，谁先全部执行完，释放锁；另一线程进入执行
        executorService.execute(()->
        {
            o1.testB("A");
        });
        
        executorService.execute(()->
        {
            o2.testB("B");
        });
        
        executorService.shutdown();
    }
}
