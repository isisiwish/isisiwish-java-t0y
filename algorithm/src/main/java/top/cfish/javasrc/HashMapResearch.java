package top.cfish.javasrc;

import java.util.HashMap;

/**
 * @author: isisiwish
 * @date: 2019/7/16
 * @time: 10:36
 */
public class HashMapResearch
{
    public static void main(String[] args)
    {
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");
        map.put("key6", "value6");
        map.put("key7", "value7");
        map.put("key8", "value8");
        map.put("key9", "value9");
        map.put("key10", "value10");
        map.put("key11", "value11");
        map.put("key12", "value12");
        map.put("key13", "value13");
        map.put("key14", "value14");
        map.put("key15", "value15");
        map.put("key16", "value16");
        map.put("key17", "value17");
        map.put("key18", "value18");
        map.put("key", "newValue");
        String key = map.get("key");
        
        map.clear();
    }
    
    
}
