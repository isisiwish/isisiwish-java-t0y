package top.cfish.bak.ext.thread.extra;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: isisiwish
 * @date: 2019/1/23
 * @time: 18:56
 */

@Slf4j
public class ThreadLocalDemo
{
    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();
    
    public static Long getId()
    {
        return requestHolder.get();
    }
    
    public static void add(Long id)
    {
        requestHolder.set(id);
    }
    
    public static void remove()
    {
        requestHolder.remove();
    }
    
    public static void main(String[] args)
    {
        Thread threadOne = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                log.info("threadOne : " + ThreadLocalDemo.getId());
                ThreadLocalDemo.add(10010L);
                log.info("threadOne : " + ThreadLocalDemo.getId());
            }
        });
    
        Thread threadTwo = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                log.info("threadTwo : " + ThreadLocalDemo.getId());
                ThreadLocalDemo.add(10086L);
                log.info("threadTwo : " + ThreadLocalDemo.getId());
            }
        });
    
        
        log.info("threadMain : " + ThreadLocalDemo.getId());
        ThreadLocalDemo.add(10000L);
        log.info("threadMain : " + ThreadLocalDemo.getId());
        
        threadOne.start();
        threadTwo.start();
    }
}
