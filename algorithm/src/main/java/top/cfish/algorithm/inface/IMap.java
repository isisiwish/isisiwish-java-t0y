package top.cfish.algorithm.inface;

/**
 * @author: isisiwish
 * @date: 2018/9/4
 * @time: 15:47
 */
public interface IMap<K, V>
{
    int getSize();
    
    boolean isEmpty();
    
    void add(K key, V value);
    
    V remove(K key);
    
    V get(K key);
    
    void set(K key, V newValue);
    
    boolean contains(K key);
}
