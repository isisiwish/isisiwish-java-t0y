package top.cfish.leetcode.tree.trie;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author: isisiwish
 * @date: 2018/9/7
 * @time: 9:11
 * No.208
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
 */
public class 编写前缀树_208
{
    class Trie
    {
        class Node
        {
            boolean isWord;
            public Map<Character, Node> next;
            
            public Node(boolean isWord)
            {
                this.isWord = isWord;
                this.next = new TreeMap<>();
            }
            
            public Node()
            {
                this(false);
            }
        }
        
        private Node root;
        
        public Trie()
        {
            root = new Node(false);
        }
        
        public void insert(String word)
        {
            Node curr = root;
            for (int i = 0; i < word.length(); i++)
            {
                char c = word.charAt(i);
                if (curr.next.get(c) == null)
                {
                    curr.next.put(c, new Node(false));
                }
                
                curr = curr.next.get(c);
            }
            curr.isWord = true;
        }
        
        private boolean isMatch(String word, boolean isPrefix)
        {
            if (root.next.size() == 0 || word == null)
            {
                return false;
            }
            
            Node curr = root;
            for (int i = 0; i < word.length(); i++)
            {
                char c = word.charAt(i);
                if (curr.next.get(c) == null)
                {
                    return false;
                }
                else
                {
                    curr = curr.next.get(c);
                }
            }
            return isPrefix ? true : curr.isWord;
        }
        
        // 查询单词word是否在Trie中，完全匹配
        public boolean contains(String word)
        {
            return isMatch(word, false);
        }
        
        // 查询是否在Trie中有单词以prefix为前缀
        public boolean isPrefix(String prefix)
        {
            return isMatch(prefix, true);
        }
    }
}
