package top.cfish.algorithm.array;

import lombok.extern.slf4j.Slf4j;
import top.cfish.algorithm.inface.ICompare;
import top.cfish.algorithm.inface.IList;
import top.cfish.algorithm.sort.advance.QuickSort;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author: isisiwish
 * @date: 2018/8/21
 * @time: 19:26
 * 自增长顺序表
 * 说明：
 * 1、基础结构，方法尽可能全面
 * 2、getMin、getMax方法不使用Comparable接口，避免影响其他使用ArrayList结构的类；通过泛型比较器接口，对象自行继承实现cmp方法（函数指针）对元素大小进行比较
 */
@Slf4j
public class ArrayList<T> implements IList<T>
{
    private static final int DEFAULT_CAPACITY = 10;
    
    private T[] data;
    private int size;
    
    public ArrayList(int initCapacity)
    {
        if (initCapacity > 0)
        {
            data = (T[])(new Object[initCapacity]);
            size = 0;
        }
        else
        {
            throw new IllegalArgumentException("initCapacity Error : " + initCapacity);
        }
    }
    
    public ArrayList()
    {
        this(DEFAULT_CAPACITY);
    }
    
    public ArrayList(T... srcArr)
    {
        this(srcArr.length);
        // TODO 修改为自己方法实现
        System.arraycopy(srcArr, 0, data, 0, srcArr.length);
        size = srcArr.length;
    }
    
    public void insert(T e, int index)
    {
        add(index, e);
    }
    
    public void addFirst(T e)
    {
        add(0, e);
    }
    
    public void addLast(T e)
    {
        add(size, e);
    }
    
    @Override
    public void add(int index, T e)
    {
        addCheck(index);
        if (isFull())
        {
            resize(data.length * 2);
        }
        for (int i = size - 1; i >= index; i--)
        {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }
    
    @Override
    public void addAll(int index, T[] srcArr)
    {
        addCheck(index);
        if (data.length <= size + srcArr.length)
        {
            resize(data.length * 2 + srcArr.length);
        }
        int gap = srcArr.length;
        // TODO 合并两个循环
        for (int i = size - 1; i >= index; i--)
        {
            data[i + gap] = data[i];
        }
        for (int i = index, j = 0; j < gap; i++, j++)
        {
            data[i] = srcArr[j];
        }
        size += gap;
    }
    
    public T removeFirst()
    {
        return remove(0);
    }
    
    public T removeLast()
    {
        return remove(size - 1);
    }
    
    public T remove(int index)
    {
        getCheck(index);
        T e = data[index];
        for (int i = index; i < size - 1; i++)
        {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        
        // 防止复杂度震荡
        if (size < data.length / 4 && data.length / 2 != 0)
        {
            resize(data.length / 2);
        }
        return e;
    }
    
    @Override
    public void remove(T e)
    {
        removeElement(e);
    }
    
    public boolean removeElement(T e)
    {
        int index = indexOf(e);
        if (index == -1)
        {
            return false;
        }
        remove(index);
        return true;
    }
    
    public void removeAll(T e)
    {
        int r = 0;
        int w = 0;
        for (; r < size; r++)
        {
            if (!e.equals(data[r]))
            {
                data[w] = data[r];
                w++;
            }
        }
        int count = r - w;
        for (; w < size; w++)
        {
            data[w] = null;
        }
        size -= count;
        
        // 防止复杂度震荡
        if (size < data.length / 4 && data.length / 2 != 0)
        {
            resize(data.length / 2);
        }
    }
    
    @Override
    public void removeAll(T[] arr)
    {
        for (T e : arr)
        {
            removeAll(e);
        }
    }
    
    // 删除顺序表中[start, end]范围的数据，返回被删除的数据
    public T[] removeRange(int start, int end)
    {
        subArrayRangeCheck(start, end);
        
        ArrayList<T> removeArr = new ArrayList<>(end - start + 1);
        for (int i = end + 1, j = start; j <= end; i++, j++)
        {
            removeArr.addLast(data[j]);
            data[j] = data[i];
        }
        size -= (end - start + 1);
        
        // 防止复杂度震荡
        if (size < data.length / 4 && data.length / 2 != 0)
        {
            resize(data.length / 2);
        }
        return removeArr.data;
    }
    
    @Override
    public T[] subList(int start, int end)
    {
        subArrayRangeCheck(start, end);
        
        ArrayList<T> subArr = new ArrayList<>(end - start + 1);
        for (int i = start; i <= end; i++)
        {
            subArr.addLast(data[i]);
        }
        return subArr.data;
    }
    
    @Override
    public T get(int index)
    {
        getCheck(index);
        return data[index];
    }
    
    @Override
    public void set(int index, T e)
    {
        getCheck(index);
        data[index] = e;
    }
    
    public int search(T e)
    {
        return indexOf(e);
    }
    
    @Override
    public boolean contains(T e)
    {
        return indexOf(e) != -1;
    }
    
    @Override
    public int indexOf(T e)
    {
        for (int i = 0; i < size; i++)
        {
            if (data[i].equals(e))
            {
                return i;
            }
        }
        return -1;
    }
    
    public int lastIndexOf(T e)
    {
        for (int i = size - 1; i >= 0; i--)
        {
            if (data[i].equals(e))
            {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    public boolean isFull()
    {
        return data.length == size;
    }
    
    public int getCapacity()
    {
        return data.length;
    }
    
    @Override
    public int getSize()
    {
        return size;
    }
    
    public T getMin(ICompare compare)
    {
        if (isEmpty())
        {
            return null;
        }
        T min = data[0];
        for (int i = 1; i < size; i++)
        {
            if (compare.cmp(min, data[i]) > 0)
            {
                min = data[i];
            }
        }
        return min;
    }
    
    public T getMax(ICompare compare)
    {
        if (isEmpty())
        {
            return null;
        }
        T max = data[0];
        for (int i = 1; i < size; i++)
        {
            if (compare.cmp(max, data[i]) < 0)
            {
                max = data[i];
            }
        }
        return max;
    }
    
    public T getFirst()
    {
        if (!isEmpty())
        {
            return data[0];
        }
        else
        {
            return null;
        }
    }
    
    public T getLast()
    {
        if (!isEmpty())
        {
            return data[size - 1];
        }
        else
        {
            return null;
        }
    }
    
    public void fillAll(T value)
    {
        size = data.length;
        for (int i = 0; i < size; i++)
        {
            data[i] = value;
        }
    }
    
    public void reverse()
    {
        T tmp;
        for (int i = 0, j = size - 1; i < j; i++, j--)
        {
            tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
        }
    }
    
    @Override
    public void clear()
    {
        for (int i = 0; i < size; i++)
        {
            data[i] = null;
        }
        size = 0;
    }
    
    public void print(int start, int end)
    {
        subArrayRangeCheck(start, end);
        
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("ArrayList: size=%d, capacity=%d, startIndex=%d, endIndex=%d, ", size, getCapacity(), start, end));
        
        end = end < size ? end : size - 1;
        
        sb.append("[");
        for (int i = start; i <= end; i++)
        {
            sb.append(data[i]);
            if (i != end)
            {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
    
    public void printAll()
    {
        System.out.println(this.toString());
    }
    
    public void swap(int i, int j)
    {
        getCheck(i);
        getCheck(j);
        
        T t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
    
    public void sort()
    {
        QuickSort.sort((Comparable[])data);
    }
    
    private void resize(int newCapacity)
    {
        if (newCapacity < 0 || newCapacity > Integer.MAX_VALUE - 1024)
        {
            throw new IllegalArgumentException("newCapacity Error : " + newCapacity);
        }
        
        log.debug("ArrayList resize called oldSize={} newSize={}", data.length, newCapacity);
        
        T[] newData = (T[])(new Object[newCapacity]);
        // TODO 修改为自己方法实现
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }
    
    private void addCheck(int index)
    {
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }
    
    private void getCheck(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }
    
    private void subArrayRangeCheck(int start, int end)
    {
        if (start < 0 || start > end || end >= size)
        {
            throw new IndexOutOfBoundsException("IndexOutOfBounds Error : size=" + size + "[start, end]=[" + start + ", " + end + "]");
        }
    }
    
    private String outOfBoundsMsg(int index)
    {
        return "IndexOutOfBounds Error : index=" + index + ", size=" + size;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (this == null || o == null)
        {
            return false;
        }
        if (!(o instanceof ArrayList))
        {
            return false;
        }
        
        ArrayList<?> that = (ArrayList<?>)o;
        if (size == 0 && that.size == 0)
        {
            return true;
        }
        return size == that.size && Arrays.equals(data, that.data);
    }
    
    @Override
    public int hashCode()
    {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
    
    @Override
    public T[] toArray()
    {
        T[] newArr = (T[])(new Object[size]);
        for (int i = 0; i < size; i++)
        {
            newArr[i] = data[i];
        }
        return newArr;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("ArrayList: size=%d, capacity=%d, ", size, getCapacity()));
        if (data == null || isEmpty())
        {
            sb.append("[]");
            return sb.toString();
        }
        
        sb.append("[");
        for (int i = 0; i < size; i++)
        {
            sb.append(data[i]);
            if (i != size - 1)
            {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
