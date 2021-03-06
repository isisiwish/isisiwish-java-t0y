package top.cfish.bak.ext.concurrency.atomic;

import lombok.extern.slf4j.Slf4j;
import top.cfish.thread.annotation.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author: isisiwish
 * @date: 2019/1/24
 * @time: 11:27
 */
@Slf4j
@ThreadSafe
public class AtomicBooleanDemo
{
    // 请求总数
    public static int clientTotal = 5000;
    
    // 同时并发执行的线程数
    public static int threadTotal = 200;
    
    private static AtomicBoolean isHappened = new AtomicBoolean(false);
    
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
                    test();
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
        log.info("isHappened:{}", isHappened.get());
    }
    
    private static void test()
    {
        if (isHappened.compareAndSet(false, true))
        {
            log.info("execute");
        }
    }
}
