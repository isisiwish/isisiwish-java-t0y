package top.cfish.leetcode.tree.trie;

import java.util.HashMap;

/**
 * @author: isisiwish
 * @date: 2018/9/7
 * @time: 16:17
 * No.211
 * https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/description/
 * todo ness
 */
public class 添加与搜索单词_211
{
    class WordDictionary
    {
        private class Node
        {
            public boolean isWord;
            public HashMap<Character, Node> next;
            
            public Node(boolean isWord)
            {
                this.isWord = isWord;
                this.next = new HashMap<>();
            }
            
            public Node()
            {
                this(false);
            }
        }
        
        private Node root;
        
        public WordDictionary()
        {
            root = new Node();
        }
        
        public void addWord(String word)
        {
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
            }
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
                else
                {
                    return match(node.next.get(c), word, index + 1);
                }
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
}
