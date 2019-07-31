package top.cfish.algorithm.sort.basic;


import static top.cfish.utils.SortUtil.compare;
import static top.cfish.utils.SortUtil.swap;

/**
 * @author: isisiwish
 * @date: 2018/8/27
 * @time: 18:38
 */

public class SelectionSort
{
    private SelectionSort()
    {
    
    }
    
    public static void sort(Comparable[] arr)
    {
        int len = arr.length;
        
        for (int i = 0; i < len - 1; i++)
        {
            int min_index = i;
            for (int j = i + 1; j < len; j++)
            {
                if (compare(arr, min_index, j) > 0)
                {
                    min_index = j;
                }
            }
            if (i != min_index)
            {
                swap(arr, min_index, i);
            }
        }
    }
}
