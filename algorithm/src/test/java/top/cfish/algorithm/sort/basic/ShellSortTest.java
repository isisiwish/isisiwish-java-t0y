package top.cfish.algorithm.sort.basic;

import org.junit.Assert;
import org.junit.Test;
import top.cfish.utils.SortUtil;

/**
 * @author: isisiwish
 * @date: 2018/9/18
 * @time: 10:07
 */
public class ShellSortTest
{
    @Test
    public void sortTest()
    {
        Integer[] arr = SortUtil.getArrays(1000);
        SortUtil.testSort("top.cfish.algorithm.sort.basic.ShellSort", arr);
        SortUtil.printArrays(arr);
        Assert.assertTrue(SortUtil.isSorted(arr));
    }
}
