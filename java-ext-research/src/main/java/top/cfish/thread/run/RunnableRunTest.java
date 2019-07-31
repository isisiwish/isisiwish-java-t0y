package top.cfish.thread.run;

/**
 * @author: isisiwish
 * @date: 2019/1/22
 * @time: 9:48
 */

public class RunnableRunTest
{
    public static void main(String[] args)
    {
        MyRunnable runnableA = new MyRunnable("A", "A");
        MyRunnable runnableB = new MyRunnable("B", "B");
        MyRunnable runnableC = new MyRunnable("C", "C");
        
        Thread t1 = new Thread(runnableA);
        Thread t2 = new Thread(runnableB);
        Thread t3 = new Thread(runnableC);
        
        t1.start();
        t2.start();
        t3.start();
    }
}
