package top.cfish.algorithm.queue;

import top.cfish.algorithm.inface.IQueue;

/**
 * @author: isisiwish
 * @date: 2018/9/4
 * @time: 22:54
 */
public class LinkedListQueue<T> implements IQueue<T>
{
    @Override
    public void clear()
    {
        while (!isEmpty())
        {
            dequeue();
        }
    }
    
    private class Node
    {
        public T e;
        public Node next;
        
        public Node(T e, Node next)
        {
            this.e = e;
            this.next = next;
        }
        
        public Node(T e)
        {
            this(e, null);
        }
        
        public Node()
        {
            this(null, null);
        }
        
        @Override
        public String toString()
        {
            return e.toString();
        }
    }
    
    private Node head, tail;
    private int size;
    
    public LinkedListQueue()
    {
        head = null;
        tail = null;
        size = 0;
    }
    
    @Override
    public int getSize()
    {
        return size;
    }
    
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    @Override
    public void enqueue(T e)
    {
        if (tail == null)
        {
            tail = new Node(e);
            head = tail;
        }
        else
        {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }
    
    @Override
    public T dequeue()
    {
        if (isEmpty())
        {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null)
        {
            tail = null;
        }
        size--;
        return retNode.e;
    }
    
    @Override
    public T getHead()
    {
        if (isEmpty())
        {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return head.e;
    }
    
    @Override
    public String toString()
    {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        
        Node cur = head;
        while (cur != null)
        {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
}
