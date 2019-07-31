package top.cfish.leetcode.set;

import java.util.TreeSet;

/**
 * @author: isisiwish
 * @date: 2018/9/4
 * @time: 22:22
 * No.804
 * https://leetcode-cn.com/problems/unique-morse-code-words/description/
 * 使用set
 */
public class 唯一摩尔斯密码词_804
{
    public int uniqueMorseRepresentations(String[] words)
    {
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        TreeSet<String> set = new TreeSet<>();
        for (String word : words)
        {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++)
            {
                res.append(codes[word.charAt(i) - 'a']);
            }
            
            set.add(res.toString());
        }
        return set.size();
    }
    
    public static void main(String[] args)
    {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println((new 唯一摩尔斯密码词_804()).uniqueMorseRepresentations(words));
    }
}
