package top.cfish.thread.status;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: isisiwish
 * @date: 2019/1/23
 * @time: 16:28
 */

@Slf4j
public class InterruptWaitThreadTest
{
    private static final String THREAD_NAME = "sub-thread";
    
    public static void main(String[] args) throws InterruptedException
    {
        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                log.info("thread name: {}", Thread.currentThread().getName());
                
                try
                {
                    Thread.sleep(10000000);
                }
                catch (InterruptedException e)
                {
                    log.error("", e);
                }
                // 打断sleep线程后，能够继续执行剩余代码
                log.info("thread name: {} interrupted", Thread.currentThread().getName());
            }
        }, THREAD_NAME);
        
        thread.start();
        Thread.sleep(3000);
        
        log.info("begin interrupt sub-thread");
        thread.interrupt();
        log.info("end interrupt sub-thread");
    }
}
