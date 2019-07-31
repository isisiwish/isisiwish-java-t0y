package top.cfish.thread.sync;

import lombok.extern.slf4j.Slf4j;
import top.cfish.utils.TimeUtil;

/**
 * @author: isisiwish
 * @date: 2019/1/22
 * @time: 15:40
 */
@Slf4j
public class SynchronizedRunnable implements Runnable
{
    @Override
    public void run()
    {
        String threadName = Thread.currentThread().getName();
        
        if (threadName.startsWith("A"))
        {
            async();
        }
        else if (threadName.startsWith("B"))
        {
            syncObjectBlock();
        }
        else if (threadName.startsWith("C"))
        {
            syncObjectMethod();
        }
        else if (threadName.startsWith("D"))
        {
            syncClassBlock();
        }
        else if (threadName.startsWith("E"))
        {
            syncClassMethod();
        }
    }
    
    /**
     * 异步方法
     */
    private void async()
    {
        try
        {
            log.info(Thread.currentThread().getName() + "_async_start : " + TimeUtil.getTimeNow());
            Thread.sleep(1000);
            log.info(Thread.currentThread().getName() + "_async_end : " + TimeUtil.getTimeNow());
        }
        catch (InterruptedException e)
        {
            log.error("", e);
        }
    }
    
    /**
     * synchronized代码块，修饰对象synchronized(this/Object)
     */
    private void syncObjectBlock()
    {
        log.info(Thread.currentThread().getName() + "_syncObjectBlock : " + TimeUtil.getTimeNow());
        synchronized (this)
        {
            try
            {
                log.info(Thread.currentThread().getName() + "_syncObjectBlock_start : " + TimeUtil.getTimeNow());
                Thread.sleep(1000);
                log.info(Thread.currentThread().getName() + "_syncObjectBlock_end : " + TimeUtil.getTimeNow());
            }
            catch (InterruptedException e)
            {
                log.error("", e);
            }
        }
    }
    
    /**
     * synchronized修饰成员方法
     */
    private synchronized void syncObjectMethod()
    {
        log.info(Thread.currentThread().getName() + "_syncObjectMethod : " + TimeUtil.getTimeNow());
        try
        {
            log.info(Thread.currentThread().getName() + "_syncObjectMethod_start : " + TimeUtil.getTimeNow());
            Thread.sleep(1000);
            log.info(Thread.currentThread().getName() + "_syncObjectMethod_end : " + TimeUtil.getTimeNow());
        }
        catch (InterruptedException e)
        {
            log.error("", e);
        }
    }
    
    /**
     * synchronized代码块，修饰类对象synchronized(Class)
     */
    private void syncClassBlock()
    {
        log.info(Thread.currentThread().getName() + "_syncClassBlock : " + TimeUtil.getTimeNow());
        synchronized (SynchronizedRunnable.class)
        {
            try
            {
                log.info(Thread.currentThread().getName() + "_syncClassBlock_start : " + TimeUtil.getTimeNow());
                Thread.sleep(1000);
                log.info(Thread.currentThread().getName() + "_syncClassBlock_end : " + TimeUtil.getTimeNow());
            }
            catch (InterruptedException e)
            {
                log.error("", e);
            }
        }
    }
    
    /**
     * synchronized修饰静态方法
     */
    private synchronized static void syncClassMethod()
    {
        log.info(Thread.currentThread().getName() + "_syncClassMethod : " + TimeUtil.getTimeNow());
        try
        {
            log.info(Thread.currentThread().getName() + "_syncClassMethod_start : " + TimeUtil.getTimeNow());
            Thread.sleep(1000);
            log.info(Thread.currentThread().getName() + "_syncClassMethod_end : " + TimeUtil.getTimeNow());
        }
        catch (InterruptedException e)
        {
            log.error("", e);
        }
    }
}
