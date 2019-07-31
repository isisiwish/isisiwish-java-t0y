package top.cfish.algorithm.sort.basic;

/**
 * @author: isisiwish
 * @date: 2018/8/27
 * @time: 19:10
 */

public class InsertionSort
{
    private InsertionSort()
    {
    
    }
    
    public static void sort(Comparable[] arr)
    {
        sort(arr, 0, arr.length - 1);
    }
    
    // 对arr[l...r]的区间使用InsertionSort排序
    public static void sort(Comparable[] arr, int l, int r)
    {
        for (int i = l + 1; i <= r; i++)
        {
            Comparable tmp = arr[i];
            int j;
            for (j = i - 1; j >= l && arr[j].compareTo(tmp) > 0; j--)
            {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = tmp;
        }
    }
}
