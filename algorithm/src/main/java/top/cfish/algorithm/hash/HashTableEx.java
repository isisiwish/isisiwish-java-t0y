package top.cfish.algorithm.hash;

import java.util.TreeMap;

/**
 * @author: isisiwish
 * @date: 2018/9/10
 * @time: 17:09
 */
public class HashTableEx<K, V> extends HashTable<K, V>
{
    private static final int UPPER_TOL = 10;
    private static final int LOWER_TOL = 2;
    private static final int INIT_CAPACITY = 7;
    
    private int capacityIndex = 0;
    private final int[] capacity = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593, 49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469, 12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};
    
    public HashTableEx()
    {
        this.M = capacity[capacityIndex];
        size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++)
        {
            hashtable[i] = new TreeMap<>();
        }
    }
    
    private void resize(int newM)
    {
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++)
        {
            newHashTable[i] = new TreeMap<>();
        }
        
        int oldM = M;
        this.M = newM;
        for (int i = 0; i < oldM; i++)
        {
            TreeMap<K, V> map = hashtable[i];
            for (K key : map.keySet())
            {
                newHashTable[hash(key)].put(key, map.get(key));
            }
        }
        
        this.hashtable = newHashTable;
    }
    
    @Override
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
            
            if (size >= UPPER_TOL * M && capacityIndex + 1 < capacity.length)
            {
                capacityIndex++;
                resize(capacity[capacityIndex]);
            }
        }
    }
    
    @Override
    public V remove(K key)
    {
        V ret = null;
        TreeMap<K, V> map = hashtable[hash(key)];
        if (map.containsKey(key))
        {
            ret = map.remove(key);
            size--;
            
            if (size < LOWER_TOL * M && capacityIndex - 1 >= 0)
            {
                capacityIndex--;
                resize(capacity[capacityIndex]);
            }
        }
        return ret;
    }
}
