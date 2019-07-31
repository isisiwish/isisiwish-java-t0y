package top.cfish.algorithm.inface;

/**
 * @author: isisiwish
 * @date: 2018/8/28
 * @time: 15:14
 */
public interface IStack<T>
{
    boolean isEmpty();
    
    int getSize();
    
    void push(T e);
    
    T pop();
    
    T top();
    
    T peek();
    
    void clear();
}
