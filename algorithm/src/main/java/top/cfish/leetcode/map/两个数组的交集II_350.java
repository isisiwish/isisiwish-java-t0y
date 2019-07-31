package top.cfish.leetcode.map;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author: isisiwish
 * @date: 2018/9/4
 * @time: 22:20
 * No.350
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/description/
 * 使用map
 */
public class 两个数组的交集II_350
{
    public int[] intersect(int[] nums1, int[] nums2)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1)
        {
            if (!map.containsKey(num))
            {
                map.put(num, 1);
            }
            else
            {
                map.put(num, map.get(num) + 1);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2)
        {
            if (map.containsKey(num))
            {
                list.add(num);
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0)
                {
                    map.remove(num);
                }
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
