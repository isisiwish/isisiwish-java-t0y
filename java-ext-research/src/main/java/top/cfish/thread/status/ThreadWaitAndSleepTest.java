package top.cfish.thread.status;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: isisiwish
 * @date: 2019/1/22
 * @time: 12:22
 */

@Slf4j
public class ThreadWaitAndSleepTest
{
    /**
     * thread A is waitting to get lock
     * thread A get lock
     * thread B is waitting to get lock
     * thread A do wait method
     * thread B get lock
     * thread B is sleeping 10ms
     * thread B is done
     * thread A is done
     */
    public static void mainA(String[] args) throws InterruptedException
    {
        final Object lock = new Object();
        
        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                log.info("thread A is waitting to get lock");
                synchronized (lock)
                {
                    try
                    {
                        log.info("thread A get lock");
                        Thread.sleep(20);
                        log.info("thread A do wait method");
                        // wait()，释放CPU分片，释放锁，使得其他锁池中的阻塞线程，可以执行
                        lock.wait();
                        log.info("thread A is done");
                    }
                    catch (InterruptedException e)
                    {
                        log.error("", e);
                    }
                    
                }
            }
        });
        
        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                log.info("thread B is waitting to get lock");
                synchronized (lock)
                {
                    try
                    {
                        log.info("thread B get lock");
                        log.info("thread B is sleeping 10ms");
                        Thread.sleep(10);
                        lock.notifyAll();
                        Thread.sleep(2000);
                        log.info("thread B is done");
                    }
                    catch (InterruptedException e)
                    {
                        log.error("", e);
                    }
                }
            }
        });
        
        t1.start();
        Thread.sleep(10);
        t2.start();
    }
    
    /**
     * thread A is waitting to get lock
     * thread A get lock
     * thread B is waitting to get lock
     * thread A do wait method
     * thread A is done
     * thread B get lock
     * thread B is sleeping 10ms
     * thread B is done
     */
    public static void main(String[] args) throws InterruptedException
    {
        final Object lock = new Object();
        
        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                log.info("thread A is waitting to get lock");
                synchronized (lock)
                {
                    try
                    {
                        log.info("thread A get lock");
                        Thread.sleep(20);
                        log.info("thread A do wait method");
                        // Thread.sleep()，释放CPU分片，不释放锁
                        // 使得其他锁池中的阻塞线程，依然无法执行，需要等待当前同步代码块执行完成，释放锁，才能从锁池中竞争获得锁资源，继而执行
                        Thread.sleep(3000);
                        log.info("thread A is done");
                    }
                    catch (InterruptedException e)
                    {
                        log.error("", e);
                    }
                    
                }
            }
        });
        
        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                log.info("thread B is waitting to get lock");
                synchronized (lock)
                {
                    try
                    {
                        log.info("thread B get lock");
                        log.info("thread B is sleeping 10ms");
                        Thread.sleep(10);
                        lock.notifyAll();
                        Thread.yield();
                        Thread.sleep(2000);
                        log.info("thread B is done");
                    }
                    catch (InterruptedException e)
                    {
                        log.error("", e);
                    }
                    
                }
            }
        });
        
        t1.start();
        Thread.sleep(10);
        t2.start();
    }
}
