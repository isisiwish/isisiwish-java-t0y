package top.cfish.bak.ext.thread.extra;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: isisiwish
 * @date: 2019/2/26
 * @time: 18:47
 */

@Slf4j
public class TestThreadLocal
{
    // (1) 创建线程变量
    public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<String>();
    
    public static void main(String[] args) throws InterruptedException
    {
        Thread.currentThread().setName("thread1");
        // (2) 设置线程变量
        threadLocal.set("String1");
        // (3) 启动子线程
        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                threadLocal.set("String2");
                
                // (4)子线程输出线程变量的值
                log.info(Thread.currentThread().getName() + ":" + threadLocal.get());
                threadLocal.remove();
            }
        }, "thread2");
        
        thread.start();
        
        thread.join();
        // (5)主线程输出线程变量值
        log.info(Thread.currentThread().getName() + ":" + threadLocal.get());
        // (6)main线程清除线程变量
        threadLocal.remove();
    }
}
