package top.cfish.algorithm.queue;

import top.cfish.algorithm.array.ArrayList;
import top.cfish.algorithm.inface.IQueue;

/**
 * @author: isisiwish
 * @date: 2018/8/28
 * @time: 17:14
 */
public class ArrayQueue<T> implements IQueue<T>
{
    private ArrayList<T> arrayList;
    
    public ArrayQueue()
    {
        arrayList = new ArrayList<>();
    }
    
    public ArrayQueue(int capacity)
    {
        arrayList = new ArrayList<>(capacity);
    }
    
    @Override
    public void clear()
    {
        while (!isEmpty())
        {
            dequeue();
        }
    }
    
    @Override
    public boolean isEmpty()
    {
        return arrayList.isEmpty();
    }
    
    @Override
    public int getSize()
    {
        return arrayList.getSize();
    }
    
    @Override
    public void enqueue(T e)
    {
        arrayList.addLast(e);
    }
    
    @Override
    public T dequeue()
    {
        return arrayList.removeFirst();
    }
    
    @Override
    public T getHead()
    {
        return arrayList.get(0);
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("YuArrayQueue: size=%d, capacity=%d, ", arrayList.getSize(), arrayList.getCapacity()));
        if (arrayList.isEmpty())
        {
            sb.append("[]");
            return sb.toString();
        }
        
        sb.append("front [");
        for (int i = 0; i < arrayList.getSize(); i++)
        {
            sb.append(arrayList.get(i));
            if (i != arrayList.getSize() - 1)
            {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
