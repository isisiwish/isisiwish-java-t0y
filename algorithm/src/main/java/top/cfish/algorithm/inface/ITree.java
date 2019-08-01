package top.cfish.algorithm.inface;

/**
 * @author: isisiwish
 * @date: 2019/8/1
 * @time: 15:22
 */
public interface ITree<T>
{
    int getSize();
    
    boolean isEmpty();
    
    boolean contains(T e);
    
    int getHeight();
}
