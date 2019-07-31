package top.cfish.algorithm.queue;

import lombok.extern.slf4j.Slf4j;
import top.cfish.algorithm.inface.IQueue;

/**
 * @author: isisiwish
 * @date: 2018/8/28
 * @time: 20:14
 * 无法自增空间的循环队列
 * 队列满，丢弃入队元素
 */

@Slf4j
public class LoopQueue<T> implements IQueue<T>
{
    private static final int DEFAULT_CAPACITY = 10;
    
    protected T[] data;
    
    protected int head;
    protected int tail;
    
    // 不使用size，代码复杂度会提高
    protected int size;
    
    public LoopQueue(int initCapacity)
    {
        if (initCapacity > 0)
        {
            // 冗余空间，用于判断队列满
            data = (T[])new Object[initCapacity + 1];
            head = 0;
            tail = 0;
            size = 0;
        }
        else
        {
            throw new IllegalArgumentException("initCapacity Error : " + initCapacity);
        }
    }
    
    public LoopQueue()
    {
        this(DEFAULT_CAPACITY);
    }
    
    public int getCapacity()
    {
        // 不计算冗余空间
        return data.length - 1;
    }
    
    @Override
    public int getSize()
    {
        return size;
    }
    
    @Override
    public boolean isEmpty()
    {
        return head == tail;
    }
    
    public boolean isFull()
    {
        return (tail + 1) % data.length == head;
    }
    
    @Override
    public T getHead()
    {
        if (isEmpty())
        {
            throw new IllegalArgumentException("Queue is empty");
        }
        return data[head];
    }
    
    @Override
    public void clear()
    {
        if (!isEmpty())
        {
            for (int i = head; i != tail; i = (i + 1) % data.length)
            {
                data[i] = null;
            }
        }
        head = 0;
        tail = 0;
        size = 0;
    }
    
    @Override
    public void enqueue(T e)
    {
        if (e == null)
        {
            throw new NullPointerException();
        }
        
        if (isFull())
        {
            log.debug("LoopQueue is full");
            return;
        }
        
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }
    
    @Override
    public T dequeue()
    {
        if (isEmpty())
        {
            throw new IllegalArgumentException("Queue is empty");
        }
        
        T rs = data[head];
        // GC
        data[head] = null;
        head = (head + 1) % data.length;
        size--;
        
        return rs;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("YuLoopQueue: size=%d, capacity=%d, ", size, getCapacity()));
        if (isEmpty())
        {
            sb.append("[]");
            return sb.toString();
        }
        
        sb.append("head [");
        for (int i = head; i != tail; i = (i + 1) % data.length)
        {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail)
            {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        
        return sb.toString();
    }
}
