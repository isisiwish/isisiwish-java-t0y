package top.cfish.thread.sync;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: isisiwish
 * @date: 2019/1/22
 * @time: 17:03
 */

// TODO 这个不是可重入示例
@Deprecated
@Slf4j
public class SynchronizedReentrantTest
{
    public void syncReentrant()
    {
        synchronized (this)
        {
            log.info("into first block : " + Thread.currentThread().getName());
            synchronized (this)
            {
                log.info("into second block : " + Thread.currentThread().getName());
            }
        }
    }
    
    public static void main(String[] args)
    {
        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                SynchronizedReentrantTest obj = new SynchronizedReentrantTest();
                obj.syncReentrant();
            }
        });
        
        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                SynchronizedReentrantTest obj = new SynchronizedReentrantTest();
                obj.syncReentrant();
            }
        });
        
        Thread t3 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                SynchronizedReentrantTest obj = new SynchronizedReentrantTest();
                obj.syncReentrant();
            }
        });
        
        t1.start();
        t2.start();
        t3.start();
    }
}
