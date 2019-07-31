package top.cfish.algorithm.tree.trie;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import top.cfish.algorithm.set.BSTreeSet;
import top.cfish.utils.FileUtil;

import java.util.ArrayList;

/**
 * @author: isisiwish
 * @date: 2018/9/7
 * @time: 14:26
 */
@Slf4j
public class ArrayTrieTest
{
    @Test
    public void Test()
    {
        ArrayList<String> words = new ArrayList<>();
        long startTime = 0L;
        long endTime = 0L;
        double time = 0.0;
        
        if (FileUtil.readFile("D:\\JavaCode\\me\\algorithm-memo\\src\\test\\resources\\pride-and-prejudice.txt", words) && FileUtil.readFile("D:\\JavaCode\\me\\algorithm-memo\\src\\test\\resources\\a-tale-of-two-cities.txt", words))
        {
            // Test BSTreeSet
            startTime = System.nanoTime();
            BSTreeSet<String> bsTreeSetet = new BSTreeSet<>();
            for (String word : words)
            {
                bsTreeSetet.add(word);
            }
            for (String word : words)
            {
                bsTreeSetet.contains(word);
            }
            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            log.info("Total different words: {}", bsTreeSetet.getSize());
            log.info("BSTreeSet: {}s", time);
            
            // Test TreeMap Trie
            startTime = System.nanoTime();
            Trie treeMapTrie = new Trie();
            for (String word : words)
            {
                treeMapTrie.add(word);
            }
            for (String word : words)
            {
                treeMapTrie.contains(word);
            }
            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            log.info("Total different words: {}", treeMapTrie.getSize());
            log.info("TreeMap Trie: {}s", time);
            
            // Test HashMap Trie
            startTime = System.nanoTime();
            TrieII hashMapTrie = new TrieII();
            for (String word : words)
            {
                hashMapTrie.add(word);
            }
            for (String word : words)
            {
                hashMapTrie.contains(word);
            }
            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            log.info("Total different words: {}", hashMapTrie.getSize());
            log.info("HashMap Trie: {}s", time);
            
            // Test Array Trie
            startTime = System.nanoTime();
            ArrayTrie arrayTrie = new ArrayTrie();
            for (String word : words)
            {
                arrayTrie.add(word);
            }
            for (String word : words)
            {
                arrayTrie.contains(word);
            }
            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            log.info("Total different words: {}", arrayTrie.getSize());
            log.info("Array Trie: {}s", time);
        }
    }
    
   
}
