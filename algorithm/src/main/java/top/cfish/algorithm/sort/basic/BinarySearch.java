package top.cfish.algorithm.sort.basic;

/**
 * @author: isisiwish
 * @date: 2018/8/27
 * @time: 19:15
 */

public class BinarySearch
{
    private BinarySearch()
    {
    
    }
    
    public static int find(Comparable[] arr, Comparable target)
    {
        int low = 0;
        int high = arr.length - 1;
        
        while (low <= high)
        {
            // 存在bug，极端情况下整型溢出
            // int mid = (low + high) / 2;
            int mid = low + (high - low) / 2;
            if (arr[mid].compareTo(target) < 0)
            {
                low = mid + 1;
            }
            else if (arr[mid].compareTo(target) > 0)
            {
                high = mid - 1;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }
}
