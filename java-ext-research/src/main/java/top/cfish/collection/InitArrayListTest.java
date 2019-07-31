package top.cfish.collection;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author: isisiwish
 * @date: 2019/4/26
 * @time: 15:25
 */

/**
 * 初始化ArrayList的方法
 * https://stackoverflow.com/questions/1005073/initialization-of-an-arraylist-in-one-line
 */
@Slf4j
public class InitArrayListTest
{
    @Test
    public void testArrayListAdd()
    {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("曹操");
        strList.add("刘备");
        strList.add("孙权");
        log.info(JSON.toJSONString(strList));
    }
    
    @Test
    public void testArraysAsList()
    {
        ArrayList<String> strList = new ArrayList<>(Arrays.asList("曹操", "刘备", "孙权"));
        log.info(JSON.toJSONString(strList));
    }
    
    @Test
    public void testAnonymousAdd()
    {
        ArrayList<String> strList = new ArrayList<String>()
        {{
            add("曹操");
            add("刘备");
            add("孙权");
        }};
        log.info(JSON.toJSONString(strList));
    }
    
    @Test
    public void testCollectionsAddAll()
    {
        List<String> strList = new ArrayList<>();
        Collections.addAll(strList,"曹操", "刘备", "孙权");
        log.info(JSON.toJSONString(strList));
    }
    
    @Test
    public void testGuavaLists()
    {
        ArrayList<String> strList = Lists.newArrayList("曹操", "刘备", "孙权");
        log.info(JSON.toJSONString(strList));
    }
    
    @Test
    public void testGuavaImmutableList()
    {
        List<String> strList = ImmutableList.of("曹操", "刘备", "孙权");
        log.info(JSON.toJSONString(strList));
    }
    
    private static ArrayList<String> createArrayList(String... elements)
    {
        // 等价于testArrayListAdd()
        ArrayList<String> list = new ArrayList<>();
        for (String element : elements)
        {
            list.add(element);
        }
        return list;
    }
    
    @Test
    public void testCreateArrayList()
    {
        ArrayList<String> strList = createArrayList("曹操", "刘备", "孙权");
        log.info(JSON.toJSONString(strList));
    }
    
    @Test
    public void testJava8StreamCollectors()
    {
        List<String> strList = Stream.of("曹操", "刘备", "孙权").collect(toList());
        log.info(JSON.toJSONString(strList));
    }
}
