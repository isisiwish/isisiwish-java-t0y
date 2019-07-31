package top.cfish.algorithm.hash;

import org.junit.Test;
import top.cfish.utils.FileUtil;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author: isisiwish
 * @date: 2018/9/18
 * @time: 16:05
 */
public class HashTableExTest
{
    @Test
    public void Test()
    {
        ArrayList<String> words = new ArrayList<>();
        if (FileUtil.readFile("D:\\JavaCode\\me\\algorithm-memo\\src\\test\\resources\\pride-and-prejudice.txt", words))
        {
            System.out.println("Total words: " + words.size());
        
            long startTime = System.nanoTime();
            HashTableEx<String, Integer> ht = new HashTableEx<>();
            for (String word : words)
            {
                if (ht.contains(word))
                {
                    ht.set(word, ht.get(word) + 1);
                }
                else
                {
                    ht.add(word, 1);
                }
            }
        
            for (String word : words)
            {
                ht.contains(word);
            }
        
            long endTime = System.nanoTime();
        
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("HashTable: " + time + " s");
        }
    }
}
