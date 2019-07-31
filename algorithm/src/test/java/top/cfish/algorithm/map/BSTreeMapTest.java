package top.cfish.algorithm.map;

import org.junit.Test;
import top.cfish.utils.FileUtil;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author: isisiwish
 * @date: 2018/9/18
 * @time: 16:14
 */
public class BSTreeMapTest
{
    @Test
    public void Test()
    {
        System.out.println("Pride and Prejudice");
        
        ArrayList<String> words = new ArrayList<>();
        if (FileUtil.readFile("D:\\JavaCode\\me\\algorithm-memo\\src\\test\\resources\\pride-and-prejudice.txt", words))
        {
            System.out.println("Total words: " + words.size());
            
            BSTreeMap<String, Integer> map = new BSTreeMap<>();
            for (String word : words)
            {
                if (map.contains(word))
                {
                    map.set(word, map.get(word) + 1);
                }
                else
                {
                    map.add(word, 1);
                }
            }
            
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }
        
        System.out.println();
    }
}
