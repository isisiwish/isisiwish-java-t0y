package top.cfish.algorithm.hash;

import java.util.TreeMap;

/**
 * @author: isisiwish
 * @date: 2018/9/10
 * @time: 16:53
 * 哈希表
 *
 * 说明：
 * 底层使用RB-Tree处理冲突
 */
public class HashTable<K, V>
{
    protected TreeMap<K, V>[] hashtable;
    protected int size;
    protected int M;
    
    public HashTable(int M)
    {
        this.M = M;
        size = 0;
        hashtable = new TreeMap[M];
        
        for (int i = 0; i < M; i++)
        {
            hashtable[i] = new TreeMap<>();
        }
    }
    
    public HashTable()
    {
        this(97);
    }
    
    protected int hash(K key)
    {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    
    public int getSize()
    {
        return size;
    }
    
    public boolean contains(K key)
    {
        return hashtable[hash(key)].containsKey(key);
    }
    
    public V get(K key)
    {
        return hashtable[hash(key)].get(key);
    }
    
    public void add(K key, V value)
    {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (map.containsKey(key))
        {
            map.put(key, value);
        }
        else
        {
            map.put(key, value);
            size++;
        }
    }
    
    public void set(K key, V value)
    {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (!map.containsKey(key))
        {
            throw new IllegalArgumentException(key + " doesn't exist");
        }
        
        map.put(key, value);
    }
    
    public V remove(K key)
    {
        V ret = null;
        TreeMap<K, V> map = hashtable[hash(key)];
        if (map.containsKey(key))
        {
            ret = map.remove(key);
            size--;
        }
        return ret;
    }
}
