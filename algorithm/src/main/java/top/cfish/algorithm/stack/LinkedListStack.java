package top.cfish.algorithm.stack;

import top.cfish.algorithm.inface.IStack;
import top.cfish.algorithm.linkedlist.LinkedList;

/**
 * @author: isisiwish
 * @date: 2018/9/4
 * @time: 22:51
 */
public class LinkedListStack<T> implements IStack<T>
{
    private LinkedList<T> list;
    
    public LinkedListStack()
    {
        list = new LinkedList<>();
    }
    
    @Override
    public int getSize()
    {
        return list.getSize();
    }
    
    @Override
    public boolean isEmpty()
    {
        return list.isEmpty();
    }
    
    @Override
    public void push(T e)
    {
        list.addFirst(e);
    }
    
    @Override
    public T pop()
    {
        return list.removeFirst();
    }
    
    @Override
    public T peek()
    {
        return list.getFirst();
    }
    
    @Override
    public void clear()
    {
        while (!isEmpty())
        {
            pop();
        }
    }
    
    @Override
    public T top()
    {
        return peek();
    }
    
    @Override
    public String toString()
    {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }
}
