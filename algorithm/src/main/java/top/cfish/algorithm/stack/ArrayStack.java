package top.cfish.algorithm.stack;

import top.cfish.algorithm.array.ArrayList;
import top.cfish.algorithm.inface.IStack;

/**
 * @author: isisiwish
 * @date: 2018/8/28
 * @time: 15:26
 */
public class ArrayStack<T extends Comparable<T>> implements IStack<T>
{
    private ArrayList<T> arrayList;
    
    public ArrayStack()
    {
        arrayList = new ArrayList<>();
    }
    
    public ArrayStack(int initCapacity)
    {
        arrayList = new ArrayList<>(initCapacity);
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
    public void push(T e)
    {
        arrayList.addLast(e);
    }
    
    @Override
    public T pop()
    {
        return arrayList.removeLast();
    }
    
    @Override
    public T peek()
    {
        return arrayList.get(arrayList.getSize() - 1);
    }
    
    @Override
    public T top()
    {
        return peek();
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("ArrayStack: size=%d, capacity=%d, ", arrayList.getSize(), arrayList.getCapacity()));
        if (arrayList.isEmpty())
        {
            sb.append("[]");
            return sb.toString();
        }
        
        sb.append("[");
        for (int i = 0; i < arrayList.getSize(); i++)
        {
            sb.append(arrayList.get(i));
            if (i != arrayList.getSize() - 1)
            {
                sb.append(", ");
            }
        }
        sb.append("] <--top");
        return sb.toString();
    }
    
    @Override
    public void clear()
    {
        while (!isEmpty())
        {
            pop();
        }
    }
}
