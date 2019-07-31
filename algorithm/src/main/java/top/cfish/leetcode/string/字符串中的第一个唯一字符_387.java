package top.cfish.leetcode.string;

/**
 * @author: isisiwish
 * @date: 2018/9/10
 * @time: 16:47
 * No.387
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/description/
 */
public class 字符串中的第一个唯一字符_387
{
    public int firstUniqChar(String s)
    {
        int[] index = new int[26];
        for (int i = 0; i < s.length(); i++)
        {
            index[s.charAt(i) - 'a']++;
        }
    
        for (int i = 0; i < s.length(); i++)
        {
            if (index[s.charAt(i) - 'a'] == 1)
            {
                return i;
            }
        }
        
        return -1;
    }
}
