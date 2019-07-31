package top.cfish.bak.ext.thread.extra;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: isisiwish
 * @date: 2019/2/27
 * @time: 14:55
 */

@Slf4j
public class InheritableThreadLocalDemo
{
    public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<String>();
    
    public static void main(String[] args)
    {
        threadLocal.set("hello world");
        Thread thread = new Thread(new Runnable()
        {
            public void run()
            {
                log.info("thread:" + threadLocal.get());
            }
        });
        thread.start();
        
        log.info("main:" + threadLocal.get());
    }
}
