package top.cfish.bak.ext.concurrency.collection.immutable;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import top.cfish.thread.annotation.ThreadSafe;

import java.util.Collections;
import java.util.Map;

/**
 * @author: isisiwish
 * @date: 2019/1/24
 * @time: 21:53
 */
@Slf4j
@ThreadSafe
public class UnmodifiableMapDemo
{
    private static Map<Integer, Integer> map = Maps.newHashMap();
    
    static
    {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        map = Collections.unmodifiableMap(map);
    }
    
    public static void main(String[] args)
    {
        // 对于不可修改对象，抛出UnsupportedOperationException
        map.put(1, 3);
        log.info("{}", map.get(1));
    }
}
