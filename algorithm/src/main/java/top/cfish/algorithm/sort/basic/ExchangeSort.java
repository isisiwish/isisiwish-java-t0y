package top.cfish.algorithm.sort.basic;

import static top.cfish.utils.SortUtil.compare;
import static top.cfish.utils.SortUtil.swap;

/**
 * @author: isisiwish
 * @date: 2018/8/27
 * @time: 17:26
 */

public class ExchangeSort
{
    private ExchangeSort()
    {
    
    }
    
    public static void sort(Comparable[] arr)
    {
        int len = arr.length;
        
        for (int i = 0; i < len - 1; i++)
        {
            for (int j = i + 1; j < len; j++)
            {
                if (compare(arr, i, j) > 0)
                {
                    swap(arr, i, j);
                }
            }
        }
    }
}
