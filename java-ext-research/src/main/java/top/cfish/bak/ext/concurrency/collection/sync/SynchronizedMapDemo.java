package top.cfish.bak.ext.concurrency.collection.sync;

import lombok.extern.slf4j.Slf4j;
import top.cfish.thread.annotation.ThreadSafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author: isisiwish
 * @date: 2019/1/24
 * @time: 15:34
 */
@Slf4j
@ThreadSafe
public class SynchronizedMapDemo
{
    // 请求总数
    public static int clientTotal = 5000;
    
    // 同时并发执行的线程数
    public static int threadTotal = 200;
    
    private static Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<>());
    
    public static void main(String[] args) throws Exception
    {
        ExecutorService executorService = Executors.newCachedThreadPool();
        
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        
        for (int i = 0; i < clientTotal; i++)
        {
            final int count = i;
            executorService.execute(()->{
                try
                {
                    semaphore.acquire();
                    update(count);
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
        log.info("size:{}", map.size());
    }
    
    private static void update(int i)
    {
        map.put(i, i);
    }
}
