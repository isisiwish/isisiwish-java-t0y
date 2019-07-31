package top.cfish.thread.sync;

/**
 * @author: isisiwish
 * @date: 2019/7/16
 * @time: 17:23
 */
public class ReentrantLockTest
{
    public static void main(String[] args)
    {
        ReentrantLockRunnable o = new ReentrantLockRunnable();
        
        Thread thread1 = new Thread(o);
        Thread thread2 = new Thread(o);
        
        thread1.start();
        thread2.start();
    }
}
