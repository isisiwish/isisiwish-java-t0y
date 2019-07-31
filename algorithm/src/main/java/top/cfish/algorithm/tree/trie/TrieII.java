package top.cfish.algorithm.tree.trie;

import java.util.HashMap;

/**
 * @author: isisiwish
 * @date: 2018/9/7
 * @time: 14:13
 */
public class TrieII
{
    private class Node
    {
        public boolean isWord;
        public HashMap<Character, Node> next;
        
        public Node(boolean isWord)
        {
            this.isWord = isWord;
            next = new HashMap<>();
        }
        
        public Node()
        {
            this(false);
        }
    }
    
    private Node root;
    private int size;
    
    public TrieII()
    {
        root = new Node();
        size = 0;
    }
    
    public int getSize()
    {
        return size;
    }
    
    public void add(String word)
    {
        Node cur = root;
        for (int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
            {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        
        if (!cur.isWord)
        {
            cur.isWord = true;
            size++;
        }
    }
    
    public boolean contains(String word)
    {
        Node cur = root;
        for (int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
            {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }
}
