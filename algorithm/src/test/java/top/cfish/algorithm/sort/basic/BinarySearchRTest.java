package top.cfish.algorithm.sort.basic;

import org.junit.Assert;
import org.junit.Test;
import top.cfish.utils.SortUtil;

/**
 * @author: isisiwish
 * @date: 2018/9/18
 * @time: 10:10
 */
public class BinarySearchRTest
{
    @Test
    public void findTest()
    {
        Integer[] arr = SortUtil.getArrays(1000);
        SortUtil.testSort("top.cfish.algorithm.sort.basic.BubbleSort", arr);
        SortUtil.printArrays(arr);
        Assert.assertTrue(SortUtil.isSorted(arr));
        
        int i = BinarySearchR.find(arr, 100);
        System.out.println("index : " + i);
        Assert.assertEquals(-1, i);
        
        i = BinarySearchR.find(arr, 73);
        Assert.assertEquals(4, i);
    }
}
