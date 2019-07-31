package top.cfish.bak.ext.concurrency.collection.sync;


import lombok.extern.slf4j.Slf4j;
import top.cfish.thread.annotation.ThreadNotSafe;

import java.util.Vector;

/**
 * @author: isisiwish
 * @date: 2019/1/24
 * @time: 20:21
 */
@Slf4j
@ThreadNotSafe
public class VectorReadWriteDemo
{
    // 迭代过程中，不能修改
    // 两个线程分别修改，Vector也会抛出ArrayIndexOutOfBoundsException
    private static Vector<Integer> vector = new Vector<>();
    
    public static void main(String[] args)
    {
        while (true)
        {
            for (int i = 0; i < 10; i++)
            {
                vector.add(i);
            }
            
            Thread thread1 = new Thread()
            {
                public void run()
                {
                    for (int i = 0; i < vector.size(); i++)
                    {
                        vector.remove(i);
                    }
                }
            };
            
            Thread thread2 = new Thread()
            {
                public void run()
                {
                    for (int i = 0; i < vector.size(); i++)
                    {
                        vector.get(i);
                    }
                }
            };
            thread1.start();
            thread2.start();
        }
    }
}
