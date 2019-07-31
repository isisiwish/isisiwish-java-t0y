package top.cfish.utils;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * @author: isisiwish
 * @date: 2018/8/27
 * @time: 16:24
 */
public class SortUtil
{
    private static final int INIT_ARRAY_LENGTH = 100;
    
    // 设置固定seed，用于生成固定序列的randIntArray，便于进行基本性能比较
    private static final int INIT_SEED = 100;
    
    // 不需要实例化
    private SortUtil()
    {
    
    }
    
    // 生成随机整型数组，每个元素的随机范围为[rangeL, rangeR]
    public static Integer[] generateRandomArray(int len, int rangeL, int rangeR)
    {
        assert (rangeL <= rangeR);
        
        Integer[] arr = new Integer[len];
        
        for (int i = 0; i < len; i++)
        {
            arr[i] = new Integer((int)(Math.random() * (rangeR - rangeL + 1) + rangeL));
        }
        return arr;
    }
    
    /**
     * 生成一个近乎有序的数组，首先生成一个含有[0...n-1]的完全有序数组, 之后对数据随机交换swapTimes
     *
     * @param n
     * @param swapTimes 交换次数
     * @return
     */
    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes)
    {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = new Integer(i);
        }
        
        for (int i = 0; i < swapTimes; i++)
        {
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }
        
        return arr;
    }
    
    private static Integer[] getIntegerArray(int len)
    {
        Integer[] arr = new Integer[len];
        Random random = new Random(INIT_SEED);
        
        for (int i = 0; i < len; i++)
        {
            arr[i] = random.nextInt(len * 10);
        }
        
        return arr;
    }
    
    public static Integer[] getArrays()
    {
        return getIntegerArray(INIT_ARRAY_LENGTH);
    }
    
    public static Integer[] getArrays(int len)
    {
        return getIntegerArray(len);
    }
    
    private static String toString(Object[] arr)
    {
        if (arr == null)
        {
            return "null";
        }
        if (arr.length == 0)
        {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[array - %s] - start\n", arr));
        
        if (arr[0] instanceof Integer)
        {
            int blankCount = String.valueOf(arr.length * 10).length();
            String blankFormat = String.format("%%%dd", blankCount);
            
            for (int i = 0; i < arr.length; i++)
            {
                sb.append(String.format(blankFormat, arr[i]));
                if (i % 5 == 4 || i == arr.length - 1)
                {
                    sb.append("\n");
                }
                else
                {
                    sb.append(", ");
                }
            }
        }
        else
        {
            for (int i = 0; i < arr.length; i++)
            {
                sb.append(arr[i]);
                if (i % 5 == 4 || i == arr.length - 1)
                {
                    sb.append("\n");
                }
                else
                {
                    sb.append(", ");
                }
            }
        }
        sb.append(String.format("[array - %s] - end", arr));
        return sb.toString();
    }
    
    public static void printArrays(Object[] arr)
    {
        System.out.println(SortUtil.toString(arr));
    }
    
    public static int compare(Comparable[] arr, int i, int j)
    {
        if (arr[i].compareTo(arr[j]) > 0)
        {
            return 1;
        }
        else if (arr[i].compareTo(arr[j]) < 0)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
    
    public static void swap(Object[] arr, int i, int j)
    {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    public static boolean isEmpty(Object[] arr)
    {
        return arr == null || arr.length == 0;
    }
    
    public static boolean isSorted(Comparable[] arr)
    {
        return isAscending(arr);
    }
    
    public static boolean isAscending(Comparable[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            if (arr[i].compareTo(arr[i + 1]) > 0)
            {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isDescending(Comparable[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            if (arr[i].compareTo(arr[i + 1]) < 0)
            {
                return false;
            }
        }
        return true;
    }
    
    // 测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
    public static void testSort(String sortClassName, Comparable[] arr)
    {
        // 通过Java的反射机制，通过排序的类名，运行排序函数
        try
        {
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            
            // 通过排序函数的Class对象获得排序方法
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};
            
            long startTime = System.currentTimeMillis();
            
            // 调用排序函数
            sortMethod.invoke(null, params);
            
            long endTime = System.currentTimeMillis();
            
            System.out.println(sortClass.getSimpleName() + " - length:" + arr.length + " - time:" + (endTime - startTime) + "ms");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
