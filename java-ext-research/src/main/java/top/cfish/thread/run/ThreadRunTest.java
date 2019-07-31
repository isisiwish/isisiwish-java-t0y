package top.cfish.thread.run;

/**
 * @author: isisiwish
 * @date: 2019/1/22
 * @time: 9:47
 */

public class ThreadRunTest
{
    public static void main(String[] args)
    {
        MyTheard t1 = new MyTheard("A", "A");
        MyTheard t2 = new MyTheard("B", "B");
        MyTheard t3 = new MyTheard("C", "C");
        
        t1.start();
        t2.start();
        t3.start();
    }
}
