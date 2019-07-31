package top.cfish.leetcode.sort;


import java.util.*;

/**
 * @author: isisiwish
 * @date: 2019/1/7
 * @time: 21:17
 */
public class 最大数_179
{
    public static String largestNumber(int[] nums)
    {
        ArrayList arrayList = new ArrayList();
        
        StringBuilder sb = new StringBuilder();
        for (int num : nums)
        {
            sb.append(String.valueOf(num));
        }
        String str = sb.toString();
        for (int i = 0; i < str.length(); i++)
        {
            arrayList.add(Integer.valueOf(str.charAt(i) - 48));
        }
        Collections.sort(arrayList);
        sb = new StringBuilder();
        for (int i = arrayList.size() - 1; i >= 0; i--)
        {
            sb.append(arrayList.get(i));
        }
        return sb.toString();
    }
    
    public static void main(String[] args)
    {
        //        int[] arr = {3, 30, 34, 5, 9};
        int[] arr = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(arr));
        
        Map<String, String> map = new HashMap<>();
        map.put(null, null);
    }
}
