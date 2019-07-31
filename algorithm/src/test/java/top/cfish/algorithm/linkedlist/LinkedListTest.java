package top.cfish.algorithm.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: isisiwish
 * @date: 2018/9/10
 * @time: 11:42
 */
public class LinkedListTest
{
    @Test
    public void Test()
    {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 3; i++)
        {
            linkedList.addFirst(i);
            linkedList.addFirst(100);
        }
        linkedList.addFirst(100);
        linkedList.addLast(100);
        linkedList.addLast(100);
        System.out.println(linkedList);
    
        //linkedList.removeAllElement(100);
        linkedList.removeElement(100);
        System.out.println(linkedList);
        
    }
    
    @Test
    public void mainTest()
    {
        LinkedList<Integer> linkedList = new LinkedList<>();
        
        for (int i = 0; i < 5; i++)
        {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.reverse();
        
        linkedList.add(2, 666);
        System.out.println(linkedList);
        
        linkedList.remove(2);
        System.out.println(linkedList);
        
        linkedList.removeFirst();
        System.out.println(linkedList);
        
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
