package top.cfish.algorithm.set;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import top.cfish.utils.FileUtil;

import java.util.ArrayList;

/**
 * @author: isisiwish
 * @date: 2018/9/4
 * @time: 15:37
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BSTreeSetTest
{
    //BSTreeSet
    
    @Test
    public void add()
    {
    }
    
    @Test
    public void contains()
    {
    }
    
    @Test
    public void getSize()
    {
    }
    
    @Test
    public void isEmpty()
    {
    }
    
    @Test
    public void remove()
    {
    }
    
    public static void main(String[] args)
    {
        
        System.out.println("Pride and Prejudice");
        
        ArrayList<String> words1 = new ArrayList<>();
        if (FileUtil.readFile("D:\\JavaCode\\me\\algorithm-memo\\src\\test\\resources\\pride-and-prejudice.txt", words1))
        {
            System.out.println("Total words: " + words1.size());
    
            BSTreeSet<String> set1 = new BSTreeSet<>();
            for (String word : words1)
            {
                set1.add(word);
            }
            System.out.println("Total different words: " + set1.getSize());
        }
        
        System.out.println();
        
        
        System.out.println("A Tale of Two Cities");
        
        ArrayList<String> words2 = new ArrayList<>();
        if (FileUtil.readFile("D:\\JavaCode\\me\\algorithm-memo\\src\\test\\resources\\a-tale-of-two-cities.txt", words2))
        {
            System.out.println("Total words: " + words2.size());
    
            BSTreeSet<String> set2 = new BSTreeSet<>();
            for (String word : words2)
            {
                set2.add(word);
            }
            System.out.println("Total different words: " + set2.getSize());
        }
    }
    
}
