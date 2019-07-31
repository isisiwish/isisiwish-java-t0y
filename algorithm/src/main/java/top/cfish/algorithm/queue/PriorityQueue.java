package top.cfish.algorithm.queue;

import top.cfish.algorithm.heap.MaxHeap;
import top.cfish.algorithm.inface.IQueue;

/**
 * @author: isisiwish
 * @date: 2018/9/11
 * @time: 8:21
 */
public class PriorityQueue<T extends Comparable<T>> implements IQueue<T>
{
    private MaxHeap<T> maxHeap;
    
    public PriorityQueue()
    {
        maxHeap = new MaxHeap<>();
    }
    
    @Override
    public boolean isEmpty()
    {
        return maxHeap.isEmpty();
    }
    
    @Override
    public int getSize()
    {
        return maxHeap.getSize();
    }
    
    @Override
    public void enqueue(T e)
    {
        maxHeap.add(e);
    }
    
    @Override
    public T dequeue()
    {
        return maxHeap.extractMax();
    }
    
    @Override
    public T getHead()
    {
        return maxHeap.getMax();
    }
    
    @Override
    public void clear()
    {
        maxHeap.clear();
    }
}
