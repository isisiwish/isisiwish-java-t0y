package top.cfish.algorithm.tree.trie;

import org.junit.Assert;
import org.junit.Test;
import top.cfish.utils.FileUtil;

import java.util.ArrayList;
import java.util.TreeMap;

import static org.junit.Assert.*;

/**
 * @author: isisiwish
 * @date: 2018/9/7
 * @time: 13:56
 */
public class TrieTest
{
    @Test
    public void mainTest()
    {
        Trie trie = new Trie();
        Assert.assertEquals(0, trie.getSize());
        
        trie.add("apple");
        Assert.assertTrue(trie.contains("apple"));
        Assert.assertFalse(trie.contains("appl"));
        Assert.assertFalse(trie.contains("applee"));
        Assert.assertTrue(trie.isPrefix("app"));
        Assert.assertEquals(1, trie.getSize());
        Assert.assertTrue(trie.search("a..le"));
        Assert.assertTrue(trie.search("app.."));
    }

    @Test
    public void containsTest()
    {
        ArrayList<String> words = new ArrayList<>();
        if (FileUtil.readFile("D:\\JavaCode\\me\\algorithm-memo\\src\\test\\resources\\pride-and-prejudice.txt", words))
        {
            Trie trie = new Trie();
            for (String word : words)
            {
                trie.add(word);
            }
        
            for (String word : words)
            {
                Assert.assertTrue(trie.contains(word));
            }
            Assert.assertTrue(words.size() > trie.getSize() );
        }
    }
    
    @Test
    public void isPrefixTest()
    {
        ArrayList<String> words = new ArrayList<>();
        if (FileUtil.readFile("D:\\JavaCode\\me\\algorithm-memo\\src\\test\\resources\\pride-and-prejudice.txt", words))
        {
            Trie trie = new Trie();
            for (String word : words)
            {
                trie.add(word);
            }
        
            for (String word : words)
            {
                Assert.assertTrue(trie.isPrefix(word));
            }
        }
    }
}
