package top.cfish.algorithm.sort.advance;

import static top.cfish.utils.SortUtil.compare;

/**
 * @author: isisiwish
 * @date: 2018/8/28
 * @time: 14:22
 */

public class MegerSortNR
{
    
    
    private MegerSortNR()
    {
    
    }
    
    private static void meger(Comparable[] arr, int gap)
    {
        int len = arr.length;
        Comparable[] buff = new Comparable[len];
        
        int L1 = 0;
        int H1 = L1 + gap - 1;
        int L2 = H1 + 1;
        int H2 = (L2 + gap - 1) < len ? L2 + gap - 1 : len - 1;
        
        int i = 0;
        
        while (L2 < len)
        {
            while (L1 <= H1 && L2 <= H2)
            {
                if (compare(arr, L1, L2) <= 0)
                {
                    buff[i++] = arr[L1++];
                }
                else
                {
                    buff[i++] = arr[L2++];
                }
            }
            while (L1 <= H1)
            {
                buff[i++] = arr[L1++];
            }
            while (L2 <= H2)
            {
                buff[i++] = arr[L2++];
            }
            
            L1 = H2 + 1;
            H1 = L1 + gap - 1;
            L2 = H1 + 1;
            H2 = (L2 + gap - 1) < len ? L2 + gap - 1 : len - 1;
        }
        while (L1 < len)
        {
            buff[i++] = arr[L1++];
        }
        
        for (i = 0; i < len; i++)
        {
            arr[i] = buff[i];
        }
    }
    
    public static void sort(Comparable[] arr)
    {
        int len = arr.length;
        for (int gap = 1; gap < len; gap *= 2)
        {
            meger(arr, gap);
        }
    }
}
