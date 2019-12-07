package top.cfish.hw.util;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: isisiwish
 * @date: 2019/12/7
 * @time: 16:25
 */
public class MapTest {
    public static Map<String, String> map = new LinkedHashMap<String, String>();

    static {
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
        map.put("4", "fore");
        map.put("5", "five");
    }

    // 迭代
    @Test
    public void TestA() {
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }

    @Test
    public void TestB() {
        for (String value : map.values()) {
            System.out.println(value);
        }
    }

    @Test
    public void TestC() {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    @Test
    public void TestD() {
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println(key + " : " + map.get(key));
        }
    }

    @Test
    public void TestE() {
        Iterator<String> it = map.values().iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println(key + " : " + map.get(key));
        }
    }

    @Test
    public void TestF() {
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
