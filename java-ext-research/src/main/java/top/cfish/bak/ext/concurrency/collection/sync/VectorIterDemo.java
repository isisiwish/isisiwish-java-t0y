package top.cfish.bak.ext.concurrency.collection.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Vector;

/**
 * @author: isisiwish
 * @date: 2019/1/24
 * @time: 20:02
 */
@Slf4j
public class VectorIterDemo
{
    private static void test1(Vector<Integer> v1)
    {
        // 迭代过程中，修改集合元素，抛出ConcurrentModificationException
        for (Integer i : v1)
        {
            if (i.equals(3))
            {
                v1.remove(i);
            }
        }
    }
    
    private static void test2(Vector<Integer> v1)
    {
        // 迭代过程中，修改集合元素，会导致迭代器失效
        // 抛出ConcurrentModificationException
        Iterator<Integer> iterator = v1.iterator();
        while (iterator.hasNext())
        {
            Integer i = iterator.next();
            if (i.equals(3))
            {
                v1.remove(i);
            }
        }
    }
    
    // success
    private static void test3(Vector<Integer> v1)
    {
        for (int i = 0; i < v1.size(); i++)
        {
            if (v1.get(i).equals(3))
            {
                v1.remove(i);
            }
        }
    }
    
    public static void main(String[] args)
    {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        
        test3(vector);
    }
}
