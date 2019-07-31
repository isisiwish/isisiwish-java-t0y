package top.cfish.bak.ext.thread.extra;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: isisiwish
 * @date: 2019/2/27
 * @time: 15:40
 */

@Slf4j
public class ThreadPoolThreadLocalDemo
{
    static class LocalVariable
    {
        private Long[] a = new Long[1024 * 1024];
    }
    
    // (1)
    final static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>());
    // (2)
    final static ThreadLocal<LocalVariable> localVariable = new ThreadLocal<LocalVariable>();
    
    public static void main(String[] args) throws InterruptedException
    {
        Thread.sleep(2000);
        // (3)
        for (int i = 0; i < 50; ++i)
        {
            poolExecutor.execute(new Runnable()
            {
                public void run()
                {
                    // (4)
                    localVariable.set(new LocalVariable());
                    // (5)
                    log.info("use local varaible");
                    localVariable.remove();
                    
                }
            });
            
            Thread.sleep(1000);
        }
        // (6)
        log.info("pool execute over");
    }
}
