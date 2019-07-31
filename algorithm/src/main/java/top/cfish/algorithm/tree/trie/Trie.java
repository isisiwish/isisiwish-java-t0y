package top.cfish.algorithm.tree.trie;

import java.util.TreeMap;

/**
 * @author: isisiwish
 * @date: 2018/9/5
 * @time: 22:54
 */
public class Trie
{
    private class Node
    {
        public boolean isWord;
        public TreeMap<Character, Node> next;
        
        public Node()
        {
            this(false);
        }
        
        public Node(boolean isWord)
        {
            this.isWord = isWord;
            next = new TreeMap<>();
        }
    }
    
    private Node root;
    private int size;
    
    public Trie()
    {
        root = new Node();
        size = 0;
    }
    
    public int getSize()
    {
        return size;
    }
    
    // 向Trie添加字符串
    public void add(String word)
    {
        if (word == null)
        {
            return;
        }
        
        Node curr = root;
        for (int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if (curr.next.get(c) == null)
            {
                curr.next.put(c, new Node());
            }
            
            curr = curr.next.get(c);
            
        }
        if (!curr.isWord)
        {
            curr.isWord = true;
            size++;
        }
    }
    
    private boolean isMatch(String word, boolean isPrefix)
    {
        if (size == 0 || word == null)
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
    
    private boolean match(Node node, String word, int index)
    {
        if (index == word.length())
        {
            return node.isWord;
        }
        
        char c = word.charAt(index);
        
        if (c != '.')
        {
            if (node.next.get(c) == null)
            {
                return false;
            }
            return match(node.next.get(c), word, index + 1);
        }
        else
        {
            for (char nextChar : node.next.keySet())
            {
                if (match(node.next.get(nextChar), word, index + 1))
                {
                    return true;
                }
            }
            return false;
        }
    }
    
    public boolean search(String word)
    {
        return match(root, word, 0);
    }
}
