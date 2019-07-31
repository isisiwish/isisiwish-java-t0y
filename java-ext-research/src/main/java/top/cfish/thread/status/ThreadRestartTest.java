package top.cfish.thread.status;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: isisiwish
 * @date: 2019/2/27
 * @time: 19:44
 */

@Slf4j
public class ThreadRestartTest
{
    private static void attack() throws InterruptedException
    {
        log.info("fight");
        Thread.currentThread().sleep(3000);
        log.info("current thread is: {}", Thread.currentThread().getName());
    }
    
    public static void main(String[] args) throws InterruptedException
    {
        log.info("current main thread start: {}", Thread.currentThread().getName());
        Thread thread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    attack();
                }
                catch (InterruptedException e)
                {
                    log.error("", e);
                }
            }
        };
        
        thread.start();
        // 主线程等待子线程结束
        thread.join();
        
        // 继续通过start改变thread状态，会抛出异常
        // 对于进入TERMINATED状态的线程，无法再次start
        thread.start();
        log.info("current main thread end: {}", Thread.currentThread().getName());
    }
}
