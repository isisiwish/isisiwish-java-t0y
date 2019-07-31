package top.cfish.algorithm.sort.advance;

import top.cfish.algorithm.sort.basic.InsertionSort;

import static top.cfish.utils.SortUtil.swap;

/**
 * @author: isisiwish
 * @date: 2018/8/27
 * @time: 20:30
 */
public class QuickSort
{
    private QuickSort()
    {
    
    }
    
    private static int partition(Comparable[] arr, int low, int high)
    {
        // 在arr[l...r]的范围中, 随机选择一个数值作为枢轴，避免形成O(N^2)
        swap(arr, low, (int)(Math.random() * (high - low + 1)) + low);
        Comparable tmp = arr[low];
        while (low < high)
        {
            while (low < high && tmp.compareTo(arr[high]) <= 0)
            {
                high--;
            }
            arr[low] = arr[high];
            
            while (low < high && tmp.compareTo(arr[low]) >= 0)
            {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = tmp;
        
        return low;
    }
    
    private static void sort(Comparable[] arr, int low, int high)
    {
        if (high - low <= 15)
        {
            InsertionSort.sort(arr, low, high);
            return;
        }
        
        if (low < high)
        {
            int base = partition(arr, low, high);
            sort(arr, low, base - 1);
            sort(arr, base + 1, high);
        }
    }
    
    public static void sort(Comparable[] arr)
    {
        sort(arr, 0, arr.length - 1);
    }
}
