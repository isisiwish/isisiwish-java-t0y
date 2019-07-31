package top.cfish.algorithm.sort.basic;

/**
 * @author: isisiwish
 * @date: 2018/8/27
 * @time: 19:17
 */

public class ShellSort
{
    private ShellSort()
    {
    
    }
    
    public static void sort(Comparable[] arr)
    {
        int len = arr.length;
        int gap = 1;
        while (gap < len / 3)
        {
            gap = gap * 3 + 1;
        }
        
        while (gap >= 1)
        {
            for (int i = gap; i < len; i++)
            {
                Comparable tmp = arr[i];
                int j;
                for (j = i - gap; j >= 0 && arr[j].compareTo(tmp) > 0; j -= gap)
                {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = tmp;
            }
            gap = gap / 3;
        }
    }
}
