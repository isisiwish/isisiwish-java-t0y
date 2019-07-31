package top.cfish.bak.ext.concurrency.collection.async.date;

import lombok.extern.slf4j.Slf4j;
import top.cfish.thread.annotation.ThreadNotSafe;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author: isisiwish
 * @date: 2019/1/24
 * @time: 12:59
 */
@Slf4j
@ThreadNotSafe
public class SimpleDateFormatUnsafeDemo
{
    // 请求总数
    public static int clientTotal = 5000;
    
    // 同时并发执行的线程数
    public static int threadTotal = 200;
    
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
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
                    update();
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
    }
    
    private static void update()
    {
        try
        {
            Date parse = simpleDateFormat.parse("2019-01-01");
            log.info("{}", parse);
        }
        catch (Exception e)
        {
            log.error("parse exception", e);
        }
    }
}
