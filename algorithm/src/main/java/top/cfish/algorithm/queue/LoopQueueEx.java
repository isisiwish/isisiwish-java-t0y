package top.cfish.algorithm.queue;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: isisiwish
 * @date: 2018/8/28
 * @time: 22:54
 */

@Slf4j
public class LoopQueueEx<T> extends LoopQueue<T>
{
    private static final int DEFAULT_CAPACITY = 10;
    
    public LoopQueueEx(int initCapacity)
    {
        super(initCapacity);
    }
    
    public LoopQueueEx()
    {
        this(DEFAULT_CAPACITY);
    }
    
    private void resize(int newCapacity)
    {
        log.debug("LoopQueue resize called oldSize={} newSize={}", getCapacity(), newCapacity);
        
        T[] newData = (T[])(new Object[newCapacity + 1]);
        for (int i = 0; i < size; i++)
        {
            newData[i] = data[(i + head) % data.length];
        }
        
        data = newData;
        head = 0;
        tail = size;
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
            resize(getCapacity() * 2);
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
        
        if (size < getCapacity() / 4 && getCapacity() / 2 != 0)
        {
            resize(getCapacity() / 2);
        }
        
        return rs;
    }
}
