package top.cfish.bak.ext.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: isisiwish
 * @date: 2019/1/22
 * @time: 19:44
 */
@Slf4j
public class ThreadPoolScheduledDemo
{
    public static void main(String[] args)
    {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        
        executorService.scheduleAtFixedRate(new Runnable()
        {
            @Override
            public void run()
            {
                log.warn("schedule run");
            }
        }, 1, 3, TimeUnit.SECONDS);
        // executorService.shutdown();
    }
}
