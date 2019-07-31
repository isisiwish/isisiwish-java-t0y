package top.cfish.algorithm.sort.basic;

import static top.cfish.utils.SortUtil.compare;
import static top.cfish.utils.SortUtil.swap;

/**
 * @author: isisiwish
 * @date: 2018/8/27
 * @time: 17:14
 */

public class BubbleSort
{
    private BubbleSort()
    {
    
    }
    
    public static void sortLite(Comparable[] arr)
    {
        int len = arr.length;
        
        for (int i = 0; i < len - 1; i++)
        {
            for (int j = 0; j < len - i - 1; j++)
            {
                if (compare(arr, j, j + 1) > 0)
                {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
    
    public static void sort(Comparable[] arr)
    {
        int len = arr.length;
        boolean swapped = true;
        
        for (int i = 0; i < len - 1 && swapped; i++)
        {
            swapped = false;
            for (int j = 0; j < len - i - 1; j++)
            {
                if (compare(arr, j, j + 1) > 0)
                {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
        }
    }
}
