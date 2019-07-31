package top.cfish.algorithm.heap;

import top.cfish.algorithm.array.ArrayList;

/**
 * @author: isisiwish
 * @date: 2018/9/11
 * @time: 7:32
 */
public class MaxHeap<T extends Comparable<T>>
{
    private ArrayList<T> data;
    
    public MaxHeap(int capacity)
    {
        data = new ArrayList<>(capacity);
    }
    
    public MaxHeap()
    {
        data = new ArrayList<>();
    }
    
    public MaxHeap(T[] arr)
    {
        data = new ArrayList<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--)
        {
            siftDown(i);
        }
    }
    
    public int getSize()
    {
        return data.getSize();
    }
    
    public boolean isEmpty()
    {
        return data.isEmpty();
    }
    
    public void clear()
    {
        data.clear();
    }
    
    /**
     * 根据孩子结点索引返回父亲结点索引
     */
    private int parent(int index)
    {
        if (index <= 0)
        {
            throw new IllegalArgumentException("error index");
        }
        
        return (index - 1) / 2;
    }
    
    /**
     * 根据索引返回左孩子结点索引
     */
    private int leftChild(int index)
    {
        return index * 2 + 1;
    }
    
    /**
     * 根据索引返回右孩子结点索引
     */
    private int rightChild(int index)
    {
        return index * 2 + 2;
    }
    
    public void add(T e)
    {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }
    
    private void siftUp(int k)
    {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0)
        {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }
    
    private void siftDown(int k)
    {
        while (leftChild(k) < data.getSize())
        {
            // data[k]和data[j]交换位置
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0)
            {
                j++;
            }
            
            // data[j]是leftChild和rightChild中的最大值
            if (data.get(k).compareTo(data.get(j)) >= 0)
            {
                break;
            }
            
            data.swap(k, j);
            k = j;
        }
    }
    
    public T getMax()
    {
        if (data.getSize() == 0)
        {
            throw new IllegalArgumentException("heap is empty");
        }
        
        return data.get(0);
    }
    
    /**
     * 取出堆中最大元素-pop
     */
    public T extractMax()
    {
        T ret = getMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }
    
    /**
     * 取出堆中的最大元素，并且替换成元素e
     */
    public T replace(T e)
    {
        T ret = getMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }
}
