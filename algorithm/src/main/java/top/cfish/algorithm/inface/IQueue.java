package top.cfish.algorithm.inface;

/**
 * @author: isisiwish
 * @date: 2018/8/28
 * @time: 17:12
 */
public interface IQueue<T>
{
    /**
     * 判断队列是否为空
     *
     * @return true队列为空、false队列不为空
     */
    boolean isEmpty();
    
    /**
     * 队列元素数量
     *
     * @return 队列元素数量
     */
    int getSize();
    
    /**
     * 元素e入队（队尾）
     *
     * @param e
     */
    void enqueue(T e);
    
    /**
     * 元素出队列（队头）
     *
     * @return 出队元素
     */
    T dequeue();
    
    /**
     * 获取队头元素，但是不出队列
     *
     * @return 队头元素
     */
    T getHead();
    
    /**
     * 清理队列所有元素
     */
    void clear();
}
