package top.cfish.leetcode.set;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author: isisiwish
 * @date: 2018/9/7
 * @time: 17:57
 * No.349
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/description/
 */
public class 两个数组的交集_349
{
    public int[] intersection(int[] nums1, int[] nums2)
    {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int num : nums1)
        {
            if (!set.contains(num))
            {
                set.add(num);
            }
        }
        for (int num : nums2)
        {
            if (set.contains(num))
            {
                list.add(num);
                set.remove(num);
            }
        }
        
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
