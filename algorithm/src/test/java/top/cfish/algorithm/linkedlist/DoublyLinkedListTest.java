package top.cfish.algorithm.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: isisiwish
 * @date: 2018/9/18
 * @time: 16:08
 */
public class DoublyLinkedListTest
{
    @Test
    public void Test()
    {
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();
    
        for (int i = 0; i < 5; i++)
        {
            linkedList.addFirst(i * 10);
            System.out.println(linkedList);
        }
    
        linkedList.add(2, 666);
        linkedList.addLast(888);
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println(linkedList);
        linkedList.set(0, -10);
        System.out.println(linkedList);
    }
}
