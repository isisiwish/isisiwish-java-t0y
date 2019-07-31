package top.cfish.thread.run;

/**
 * @author: isisiwish
 * @date: 2019/2/27
 * @time: 17:03
 */

public class ThreadRunAndStartTest
{
    public static void main(String[] args)
    {
        MyRunnable runnableA = new MyRunnable("A", "A");
        MyRunnable runnableB = new MyRunnable("B", "B");
        MyRunnable runnableC = new MyRunnable("C", "C");
    
        Thread t1 = new Thread(runnableA, "thread1");
        Thread t2 = new Thread(runnableB, "thread2");
        Thread t3 = new Thread(runnableC, "thread3");
    
        // 直接run是调用方法，不是通过thread方式执行
        // 串行执行，打印线程名为全部为main
        // t1.run();
        // t2.run();
        // t3.run();
        
        t1.start();
        t2.start();
        t3.start();
    }
}
