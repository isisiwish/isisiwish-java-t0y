package top.cfish.thread.sync;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: isisiwish
 * @date: 2019/1/23
 * @time: 17:11
 */

@Slf4j
public class ThreadDeadLockTest
{
    private static Object resourceA = new Object();
    private static Object resourceB = new Object();
    
    private static String THREAD_A = "thread-A";
    private static String THREAD_B = "thread-B";
    
    /**
     * "thread-B" #12 prio=5 os_prio=0 tid=0x0000000059861800 nid=0x84a4 waiting for monitor entry [0x000000005a00f000]
     *    java.lang.Thread.State: BLOCKED (on object monitor)
     *         at top.cfish.thread.sync.ThreadDeadLockTest$2.run(ThreadDeadLockTest.java:72)
     *         - waiting to lock <0x00000000d7b90960> (a java.lang.Object)
     *         - locked <0x00000000d7b90970> (a java.lang.Object)
     *         at java.lang.Thread.run(Thread.java:748)
     *
     *    Locked ownable synchronizers:
     *         - None
     *
     * "thread-A" #11 prio=5 os_prio=0 tid=0x0000000059860800 nid=0xb950 waiting for monitor entry [0x000000005a39e000]
     *    java.lang.Thread.State: BLOCKED (on object monitor)
     *         at top.cfish.thread.sync.ThreadDeadLockTest$1.run(ThreadDeadLockTest.java:45)
     *         - waiting to lock <0x00000000d7b90970> (a java.lang.Object)
     *         - locked <0x00000000d7b90960> (a java.lang.Object)
     *         at java.lang.Thread.run(Thread.java:748)
     *
     *    Locked ownable synchronizers:
     *         - None
     */
    public static void mainA(String[] args)
    {
        Thread threadA = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                // A线程先获取A锁
                synchronized (resourceA)
                {
                    log.info("{} get ResourceA", Thread.currentThread());
                    
                    try
                    {
                        // sleep并不释放锁，仍然持有A
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        log.error("", e);
                    }
                    // 不释放A锁，获取B锁，但是B锁被线程B获取，也处于等待A线程的A锁状态，此时出现死锁情况
                    log.info("{} waiting get ResourceB", Thread.currentThread());
                    synchronized (resourceB)
                    {
                        log.info("{} get ResourceB", Thread.currentThread());
                    }
                }
            }
        }, THREAD_A);
        
        Thread threadB = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                synchronized (resourceB)
                {
                    log.info("{} get ResourceB", Thread.currentThread());
                    
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        log.error("", e);
                    }
    
                    log.info("{} waiting get ResourceA", Thread.currentThread());
                    synchronized (resourceA)
                    {
                        log.info("{} get ResourceA", Thread.currentThread());
                    }
                }
            }
        }, THREAD_B);
        
        threadA.start();
        threadB.start();
    }
    
    //线程A全执行完，或者线程B全执行完
    public static void main(String[] args)
    {
        Thread threadA = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                synchronized (resourceA)
                {
                    log.info("{} get ResourceA", Thread.currentThread());
                    
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        log.error("", e);
                    }
    
                    log.info("{} waiting get ResourceB", Thread.currentThread());
                    synchronized (resourceB)
                    {
                        log.info("{} get ResourceB", Thread.currentThread());
                    }
                }
            }
        }, THREAD_A);
        
        Thread threadB = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                synchronized (resourceA)
                {
                    log.info("{} get ResourceB", Thread.currentThread());
                    
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        log.error("", e);
                    }
    
                    log.info("{} waiting get ResourceA", Thread.currentThread());
                    synchronized (resourceB)
                    {
                        log.info("{} get ResourceA", Thread.currentThread());
                    }
                }
            }
        }, THREAD_B);
        
        threadA.start();
        threadB.start();
    }
}
