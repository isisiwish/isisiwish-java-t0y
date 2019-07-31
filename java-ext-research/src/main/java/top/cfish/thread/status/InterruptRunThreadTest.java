package top.cfish.thread.status;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: isisiwish
 * @date: 2019/1/23
 * @time: 16:37
 */

@Slf4j
public class InterruptRunThreadTest
{
    private static final String THREAD_NAME = "sub-thread";
    
    public static void main(String[] args) throws InterruptedException
    {
        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                // 子线程为死循环
                for (; ;)
                {
                    log.info("thread name: {}", Thread.currentThread().getName());
                    
                    try
                    {
                        // 给主线程CPU分片，使其能够打断子线程
                        // 打断后，子线捕获一次异常后，继续正常执行
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        log.error("", e);
                    }
                }
            }
        }, THREAD_NAME);
        
        thread.start();
        Thread.sleep(3000);
        
        log.info("begin interrupt sub-thread");
        thread.interrupt();
        log.info("end interrupt sub-thread");
    }
}
