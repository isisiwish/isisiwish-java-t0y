package top.cfish.thread.sync;

/**
 * @author: isisiwish
 * @date: 2019/1/22
 * @time: 16:49
 */
public class SynchronizedTest
{
    public static void main(String[] args)
    {
        SynchronizedRunnable synchronizedRunnable = new SynchronizedRunnable();
        
        Thread aThread1 = new Thread(synchronizedRunnable, "A_thread_1");
        Thread aThread2 = new Thread(synchronizedRunnable, "A_thread_2");
        
        Thread bThread1 = new Thread(synchronizedRunnable, "B_thread_1");
        Thread bThread2 = new Thread(synchronizedRunnable, "B_thread_2");
        
        Thread cThread1 = new Thread(synchronizedRunnable, "C_thread_1");
        Thread cThread2 = new Thread(synchronizedRunnable, "C_thread_2");
        
        Thread dThread1 = new Thread(synchronizedRunnable, "D_thread_1");
        Thread dThread2 = new Thread(synchronizedRunnable, "D_thread_2");
        
        Thread eThread1 = new Thread(synchronizedRunnable, "E_thread_1");
        Thread eThread2 = new Thread(synchronizedRunnable, "E_thread_2");
        
        // 对于A线程，启动随机，可能晚于其他线程
        // 对A1和A2线程，启动顺序也随机，结束顺序也不同，因为是异步方法，没有同步机制保证时序
        aThread1.start();
        aThread2.start();
        
        // 对于B1和B2线程，启动顺序随机，但是获取锁的线程，会完成start-->end的代码块
        bThread1.start();
        bThread2.start();
        
        // 对于C1和C2线程，启动顺序随机，synchronized修饰的方法
        // 整个方法进行同步，从进入method-->start-->end，锁未释放会一直同步执行
        cThread1.start();
        cThread2.start();
        
        // 同B
        dThread1.start();
        dThread2.start();
        
        // 同C
        eThread1.start();
        eThread2.start();
    }
}
