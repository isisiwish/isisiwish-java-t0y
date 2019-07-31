package top.cfish.algorithm.inface;

/**
 * @author: isisiwish
 * @date: 2018/9/4
 * @time: 17:29
 */
public interface IList<T>
{
    void add(int index, T e);
    
    void addAll(int index, T[] arr);
    
    void remove(T e);
    
    void removeAll(T[] arr);
    
    T get(int index);
    
    void set(int index, T e);
    
    boolean contains(T e);
    
    int indexOf(T e);
    
    boolean isEmpty();
    
    int getSize();
    
    void clear();
    
    T[] toArray();
    
    T[] subList(int start, int end);
}
