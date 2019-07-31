package top.cfish.algorithm.sort.advance;

import static top.cfish.utils.SortUtil.compare;
import static top.cfish.utils.SortUtil.swap;

/**
 * @author: isisiwish
 * @date: 2018/8/28
 * @time: 15:06
 */

public class HeapSortNR
{
    private HeapSortNR()
    {
    
    }
    
    private static void heapAdjust(Comparable[] arr, int start, int end)
    {
        Comparable tmp = arr[start];
        
        for (int i = 2 * start + 1; i < end; i = 2 * i + 1)
        {
            if (i + 1 < end && compare(arr, i, i + 1) < 0)
            {
                i++;
            }
            if (arr[i].compareTo(tmp) <= 0)
            {
                break;
            }
            arr[start] = arr[i];
            start = i;
        }
        arr[start] = tmp;
    }
    
    public static void sort(Comparable[] arr)
    {
        int len = arr.length;
        
        for (int i = (len - 1) / 2; i >= 0; i--)
        {
            heapAdjust(arr, i, len);
        }
        swap(arr, 0, len - 1);
        
        for (int i = 1; i < len - 1; i++)
        {
            heapAdjust(arr, 0, len - i);
            swap(arr, 0, len - 1 - i);
        }
    }
}
