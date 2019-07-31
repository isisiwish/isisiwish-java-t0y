package top.cfish.algorithm.sort.advance;

import org.junit.Assert;
import org.junit.Test;
import top.cfish.utils.SortUtil;

import static org.junit.Assert.*;

/**
 * @author: isisiwish
 * @date: 2018/9/18
 * @time: 10:54
 */
public class MegerSortNRTest
{
    @Test
    public void sortTest()
    {
        Integer[] arr = SortUtil.getArrays(1000);
        SortUtil.testSort("top.cfish.algorithm.sort.advance.MegerSortNR", arr);
        SortUtil.printArrays(arr);
        Assert.assertTrue(SortUtil.isSorted(arr));
    }
}
