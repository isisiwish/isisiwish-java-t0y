package top.cfish.algorithm.tree.trie;

/**
 * @author: isisiwish
 * @date: 2018/9/7
 * @time: 14:15
 */
public class ArrayTrie
{
    private class Node
    {
        public boolean isWord;
        public Node[] next;
        
        public Node(boolean isWord)
        {
            this.isWord = isWord;
            // 256 + 'a'的空间无意义，仅为通过测试代码
            next = new Node[256 + 'a'];
        }
        
        public Node()
        {
            this(false);
        }
    }
    
    private Node root;
    private int size;
    
    public ArrayTrie()
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
        word = word.toLowerCase();
        Node curr = root;
        for (int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if (!Character.isLowerCase(c))
            {
                continue;
            }
            if (curr.next[c - 'a'] == null)
            {
                curr.next[c - 'a'] = new Node();
            }
            curr = curr.next[c - 'a'];
        }
        if (!curr.isWord)
        {
            curr.isWord = true;
            size++;
        }
    }
    
    public boolean contains(String word)
    {
        Node cur = root;
        for (int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if (cur.next[c - 'a'] == null)
            {
                return false;
            }
            cur = cur.next[c - 'a'];
        }
        return cur.isWord;
    }
    
    public static void main(String args[])
    {
        System.out.println(Character.isLowerCase('c'));
        System.out.println(Character.isLowerCase('C'));
        System.out.println(Character.isLowerCase('5'));
        System.out.println(Character.isLowerCase('-'));
    }
}
