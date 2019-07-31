package top.cfish.bak.ext.thread.extra;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * @author: isisiwish
 * @date: 2019/2/26
 * @time: 17:41
 */

@Slf4j
public class Main2
{
    private static volatile CountDownLatch countDownLatch = new CountDownLatch(2);
    
    public static void main(String[] args) throws InterruptedException
    {
        Thread threadOne = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                
                try
                {
                    Thread.sleep(1000);
                    log.info("child threadOne over!");
                    throw new RuntimeException("error");
                }
                catch (InterruptedException e)
                {
                    log.error("", e);
                }
                finally
                {
                    countDownLatch.countDown();
                }
            }
        });
        
        Thread threadTwo = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                
                try
                {
                    Thread.sleep(1000);
                    log.info("child threadTwo over!");
                }
                catch (InterruptedException e)
                {
                    log.error("", e);
                }
                finally
                {
                    countDownLatch.countDown();
                }
            }
        });
        
        // 启动子线程
        threadOne.start();
        threadTwo.start();
        
        log.info("wait all child thread over!");
        
        // 等待子线程执行完毕，返回
        countDownLatch.await();
        
        log.info("all child thread over!");
    }
}


