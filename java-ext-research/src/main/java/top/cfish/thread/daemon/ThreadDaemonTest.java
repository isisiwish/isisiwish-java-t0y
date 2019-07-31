package top.cfish.thread.daemon;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: isisiwish
 * @date: 2019/1/23
 * @time: 10:45
 */

@Slf4j
public class ThreadDaemonTest
{
    private static final String THREAD_NUM = "sub-thread";
    
    public static void main(String[] args)
    {
        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                log.info(Thread.currentThread().getName());
                try
                {
                    Thread.sleep(200000);
                }
                catch (InterruptedException e)
                {
                    log.info("", e);
                }
                
            }
        }, THREAD_NUM);
        
        // 设置为守护线程
        // 对于守护线程，user执行完成后，JVM进程直接退出，而不会等待守护线程结束
        // 如果注释掉Daemon，则会等待子线程执行完成后，进程退出
        thread.setDaemon(true);
        thread.start();
    
        log.info(Thread.currentThread().getName());
    }
}
