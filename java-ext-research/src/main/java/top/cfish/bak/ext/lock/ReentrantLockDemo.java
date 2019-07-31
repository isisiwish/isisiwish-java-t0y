package top.cfish.bak.ext.lock;

import lombok.extern.slf4j.Slf4j;
import top.cfish.thread.annotation.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: isisiwish
 * @date: 2019/1/25
 * @time: 10:10
 */
@Slf4j
@ThreadSafe
public class ReentrantLockDemo
{
    // 请求总数
    public static int clientTotal = 5000;
    
    // 同时并发执行的线程数
    public static int threadTotal = 200;
    
    public static int count = 0;
    
    private final static Lock lock = new ReentrantLock();
    
    private static void add()
    {
        lock.lock();
        try
        {
            count++;
        }
        finally
        {
            lock.unlock();
        }
    }
    
    public static void main(String[] args) throws Exception
    {
        ExecutorService executorService = Executors.newCachedThreadPool();
        
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        
        for (int i = 0; i < clientTotal; i++)
        {
            executorService.execute(()->{
                try
                {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                }
                catch (Exception e)
                {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}", count);
    }
}
