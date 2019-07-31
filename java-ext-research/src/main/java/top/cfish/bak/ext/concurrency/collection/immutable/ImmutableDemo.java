package top.cfish.bak.ext.concurrency.collection.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import lombok.extern.slf4j.Slf4j;
import top.cfish.thread.annotation.ThreadSafe;

/**
 * @author: isisiwish
 * @date: 2019/1/24
 * @time: 22:01
 */
@Slf4j
@ThreadSafe
public class ImmutableDemo
{
    private final static ImmutableList<Integer> list = ImmutableList.of(1, 2, 3);
    
    private final static ImmutableSet set = ImmutableSet.copyOf(list);
    
    private final static ImmutableMap<Integer, Integer> mapA = ImmutableMap.of(1, 2, 3, 4);
    
    private final static ImmutableMap<Integer, Integer> mapB = ImmutableMap.<Integer, Integer>builder().put(1, 2).put(3, 4).put(5, 6).build();
    
    public static void main(String[] args)
    {
        // guava框架中的不可变集合框架
        log.info("{}", mapA.get(3));
    }
}
