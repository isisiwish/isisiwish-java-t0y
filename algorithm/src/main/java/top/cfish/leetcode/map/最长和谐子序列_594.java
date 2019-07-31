package top.cfish.leetcode.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: isisiwish
 * @date: 2019/1/7
 * @time: 20:45
 * 没通过OJ
 */
public class 最长和谐子序列_594
{
    public static int findLHS(int[] nums)
    {
        if (nums == null || nums.length == 0)
        {
            return 0;
        }
        
        Map<Integer, Integer> numMap = new HashMap<>(nums.length);
        for (int num : nums)
        {
            Integer count = numMap.get(num) != null ? numMap.get(num) : 0;
            numMap.put(num, count + 1);
        }
        int max = 0;
        for (int key : numMap.keySet())
        {
            if (numMap.containsKey(key + 1))
            {
                if ((numMap.get(key) + numMap.get(key + 1)) > max)
                {
                    max = (numMap.get(key) + numMap.get(key + 1));
                }
            }
        }
        return max;
    }
    
    // 1 2 3 5 8 13 21 34
    public static int fib(int n)
    {
        int i1 = 0;
        int i2 = 1;
        int sum = i1 + i2;
        
        for (int i = 0; i < n; i++)
        {
            sum = i1 + i2;
            i1 = i2;
            i2 = sum;
        }
        return sum;
    }
    
    
    public static void main(String[] args)
    {
        //        int[] arr = {1, 3, 2, 2, 5, 2, 3, 7};
        //        int[] arr = {1, 1, 1, 1};
        //        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17};
        //        int rs = findLHS(arr);
        //        System.out.println(rs);
        System.out.println(fib(2));
    }
    
    
}
