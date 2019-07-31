package top.cfish.algorithm.inface;

/**
 * @author: isisiwish
 * @date: 2018/9/4
 * @time: 14:52
 */
public interface ISet<T>
{
    int getSize();
    
    boolean isEmpty();
    
    void add(T e);
    
    void remove(T e);
    
    boolean contains(T e);
}
