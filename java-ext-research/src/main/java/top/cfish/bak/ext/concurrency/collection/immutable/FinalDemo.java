package top.cfish.bak.ext.concurrency.collection.immutable;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import top.cfish.thread.annotation.ThreadNotSafe;

import java.util.Map;

/**
 * @author: isisiwish
 * @date: 2019/1/24
 * @time: 21:41
 */
@Slf4j
@ThreadNotSafe
public class FinalDemo
{
    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer, Integer> map = Maps.newHashMap();
    
    static
    {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }
    
    public static void main(String[] args)
    {
        // 对于final修饰的变量，无法修改
        // a = 2;
        // b = "3";
        // map = Maps.newHashMap();
        
        // map指向无法修改，但是对象内容可以修改
        map.put(1, 3);
        log.info("{}", map.get(1));
    }
}
