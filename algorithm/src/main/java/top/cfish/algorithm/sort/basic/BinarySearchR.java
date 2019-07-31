package top.cfish.algorithm.sort.basic;

/**
 * @author: isisiwish
 * @date: 2018/9/18
 * @time: 9:16
 */

public class BinarySearchR
{
    private BinarySearchR()
    {
    
    }
    
    private static int find(Comparable[] arr, int low, int high, Comparable target)
    {
        if (low > high)
        {
            return -1;
        }
        
        int mid = low + (high - low) / 2;
        
        if (arr[mid].compareTo(target) > 0)
        {
            return find(arr, low, mid - 1, target);
        }
        else if (arr[mid].compareTo(target) < 0)
        {
            return find(arr, mid + 1, high, target);
        }
        else
        {
            return mid;
        }
    }
    
    public static int find(Comparable[] arr, Comparable target)
    {
        return find(arr, 0, arr.length - 1, target);
    }
}
