package top.cfish.thread.status;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: isisiwish
 * @date: 2019/1/22
 * @time: 10:23
 */

@Slf4j
public class ThreadJoinTest
{
    private static void attack() throws InterruptedException
    {
        log.info("fight");
        Thread.currentThread().sleep(3000);
        log.info("current thread is: {}", Thread.currentThread().getName());
    }
    
    // joinTest
    public static void mainA(String[] args) throws InterruptedException
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
        
        // 主线程会等待子线程执行结束
        thread.join();
        log.info("current main thread end: {}", Thread.currentThread().getName());
    }
    
    // noJoinTest
    public static void main(String[] args)
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
        // 主线程执行完成，等待子线程执行完成，JVM进程退出
        // thread.join();
        log.info("current main thread end: {}", Thread.currentThread().getName());
    }
}
