package top.cfish.algorithm.sort.advance;

import top.cfish.algorithm.sort.basic.InsertionSort;

import java.util.Arrays;

import static top.cfish.utils.SortUtil.compare;

/**
 * @author: isisiwish
 * @date: 2018/9/18
 * @time: 7:59
 */
public class MegerSort
{
    private MegerSort()
    {
    
    }
    
    private static void merge(Comparable[] arr, int l, int mid, int r)
    {
        Comparable[] buff = Arrays.copyOfRange(arr, l, r + 1);
        
        // i指向左半部分的起始索引位置l
        // j指向右半部分起始索引位置mid+1
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++)
        {
            if (i > mid)
            {
                // 如果左半部分元素已经全部处理完毕
                arr[k] = buff[j - l];
                j++;
            }
            else if (j > r)
            {
                // 如果右半部分元素已经全部处理完毕
                arr[k] = buff[i - l];
                i++;
            }
            else if (compare(buff, i - l, j - l) <= 0)
            {
                // 左半部分所指元素 <= 右半部分所指元素
                arr[k] = buff[i - l];
                i++;
            }
            else
            {
                // 左半部分所指元素 > 右半部分所指元素
                arr[k] = buff[j - l];
                j++;
            }
        }
    }
    
    // 对arr[l, r]进行归并排序
    private static void sort(Comparable[] arr, int l, int r)
    {
        //if (l >= r)
        //{
        //    return;
        //}
        // 对于小规模数组, 使用直接插入排序优化归并速度
        if (r - l <= 15)
        {
            InsertionSort.sort(arr, l, r);
            return;
        }
        
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
    
    public static void sort(Comparable[] arr)
    {
        sort(arr, 0, arr.length - 1);
    }
}
