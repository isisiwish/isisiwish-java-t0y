package top.cfish.bak.ext.thread.extra;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * @author: isisiwish
 * @date: 2019/2/27
 * @time: 11:31
 */

@Slf4j
@Getter
@Setter
public class ThreadLocalMultDemo
{
    final static public ThreadLocal<String> localVariable = new ThreadLocal<>();
    
    public static void main(String[] args)
    {
        ThreadLocalMultDemo demo = new ThreadLocalMultDemo();
        
        Thread threadOne = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                log.info("threadOne A : " + demo.localVariable.get());
                demo.localVariable.set("threadOne local variable");
                log.info("threadOne B : " + demo.localVariable.get());
    
                try
                {
                    Method getMapMethod = demo.localVariable.getClass().getDeclaredMethod("getMap", Thread.class);
                    getMapMethod.setAccessible(true);
                    Object threadLocalMap = getMapMethod.invoke(demo.localVariable, Thread.currentThread());
                    log.info("threadOne C : " + threadLocalMap);
                }
                catch (Exception e)
                {
                    log.error("", e);
                }
            }
        });
        
        Thread threadTwo = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                log.info("threadTwo A : " + demo.localVariable.get());
                demo.localVariable.set("threadTwo local variable");
                log.info("threadTwo B : " + demo.localVariable.get());
    
                try
                {
                    Method getMapMethod = demo.localVariable.getClass().getDeclaredMethod("getMap", Thread.class);
                    getMapMethod.setAccessible(true);
                    Object threadLocalMap = getMapMethod.invoke(demo.localVariable, Thread.currentThread());
                    log.info("threadTwo C : " + threadLocalMap);
                }
                catch (Exception e)
                {
                    log.error("", e);
                }
            }
        });
        
        threadOne.start();
        threadTwo.start();
    }
}
