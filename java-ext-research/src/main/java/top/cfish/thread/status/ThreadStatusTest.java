package top.cfish.thread.status;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: isisiwish
 * @date: 2019/1/22
 * @time: 13:58
 */

@Slf4j
public class ThreadStatusTest
{
    public enum ThreadState
    {
        /**
         * 新建状态
         * 尚未通过start()启动的状态
         */
        NEW,
        
        /**
         * 可运行状态
         * 是否运行，取决于是否获得CPU分片
         * 逻辑上分为两个子状态RUNNING和READY，相当于获得CPU分片和等待获取CPU分片的状态
         * 逻辑上，通过Thread.yield()可以使当前线程从RUNNING进入READY
         * READY状态的线程，也有一个就绪队列
         */
        RUNNABLE,
        
        /**
         * 线程阻塞状态
         * 等待获得锁，进入同步块，进行执行
         */
        BLOCKED,
        
        /**
         * 线程等待状态
         * 调用Object.wait()、Thread.join()、LockSupport.park()无参方法
         * 可以使得线程处于等待状态，需要其他线程唤醒
         * 1、通过Object.wait()进入等待状态，其他线程可以通过Object.notify()、Object.notifyAll()唤醒
         * 2、通过Thread.join()进入等待状态，需该线程对象执行终止，会被唤醒
         */
        WAITING,
        
        /**
         * 线程等待时间状态
         * 调用
         * Thread.sleep(long millis)、
         * Object.wait(long timeout)、
         * Thread.join(long millis)、
         * LockSupport.parkNanos(long nanos)、
         * LockSupport.parkUntil(long deadline)方法，
         * 可以使得线程处于等待时间状态
         */
        TIMED_WAITING,
        
        /**
         * 线程执行完成状态
         */
        TERMINATED;
    }
    
    public static void main(String[] args) throws InterruptedException
    {
        Object lock = new Object();
        
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                synchronized (lock)
                {
                    try
                    {
                        // 该线程会获得lock对象的锁，通过Thread.sleep()，不会释放锁，所以待测试子线程依然会处于等待锁的状态
                        Thread.sleep(20000);
                    }
                    catch (InterruptedException e)
                    {
                        log.error("", e);
                    }
                    
                }
            }
        }, "anonymous-thread").start();
        
        
        // 1.线程new出后，处于新建状态NEW
        Thread threadObj = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                // 3.通过yield()，让出CPU资源，仍为可执行状态
                Thread.yield();
                log.info("3.当前线程状态: {}", Thread.currentThread().getState());
                
                synchronized (lock)
                {
                    // 4.进入阻塞状态
                    // 该线程被阻塞，被放入锁池，无法打印该状态
                    // 等待OTHER-THREAD超时释放锁，当前测试线程从BLOCKED进入RUNNABLE
                    log.info("4.当前线程状态: {}", Thread.currentThread().getState());
                    
                    try
                    {
                        // 5.进入时间等待状态，等待5000ms后，被唤醒为RUNNABLE
                        // 改线程进入时间等待状态，被放置入等待队列中，无法打印该状态
                        lock.wait(5000);
                        log.info("5.当前线程状态: {}", Thread.currentThread().getState());
                    }
                    catch (InterruptedException e)
                    {
                        log.error("", e);
                    }
                }
            }
        });
        log.info("1.当前线程状态: {}", threadObj.getState());
        
        // 2.调用start()方法后，处于可运行状态RUNNABLE
        threadObj.start();
        log.info("2.当前线程状态: {}", threadObj.getState());
        
        // 6.通过join()方法，让主线程等待子线程结束，子线程处于终止状态
        threadObj.join();
        log.info("6.当前线程状态: {}", threadObj.getState());
        
        // 7.继续对改线程对象调用start()方法，线程状态不会流转，直接抛出IllegalThreadStateException异常
        // 如果需要重新启用线程对象，需要重新new线程对象
        // threadObj.start();
    }
}
