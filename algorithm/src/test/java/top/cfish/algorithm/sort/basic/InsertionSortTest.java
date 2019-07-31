package top.cfish.algorithm.sort.basic;

import org.junit.Assert;
import org.junit.Test;
import top.cfish.utils.SortUtil;

/**
 * @author: isisiwish
 * @date: 2018/9/18
 * @time: 10:04
 */
public class InsertionSortTest
{
    @Test
    public void sortTest()
    {
        Integer[] arr = SortUtil.getArrays(1000);
        SortUtil.testSort("top.cfish.algorithm.sort.basic.InsertionSort", arr);
        SortUtil.printArrays(arr);
        Assert.assertTrue(SortUtil.isSorted(arr));
    }
    
    @Test
    public void orderSortTest()
    {
        Integer[] arr = SortUtil.generateNearlyOrderedArray(10000, 100);
        SortUtil.testSort("top.cfish.algorithm.sort.basic.InsertionSort", arr);
        Assert.assertTrue(SortUtil.isSorted(arr));
    
        Integer[] brr = SortUtil.generateRandomArray(10000, 0, 3);
        SortUtil.testSort("top.cfish.algorithm.sort.basic.InsertionSort", brr);
        Assert.assertTrue(SortUtil.isSorted(brr));
        
        Integer[] crr = SortUtil.getArrays(10000);
        SortUtil.testSort("top.cfish.algorithm.sort.basic.InsertionSort", crr);
        Assert.assertTrue(SortUtil.isSorted(crr));
    }
    
    @Test
    public void doubleSortTest()
    {
        Double[] arr = {4.4, 3.3, 2.2, 1.1};
        SortUtil.testSort("top.cfish.algorithm.sort.basic.InsertionSort", arr);
        SortUtil.printArrays(arr);
        Assert.assertTrue(SortUtil.isSorted(arr));
    }
    
    @Test
    public void stringSortTest()
    {
        String[] arr = {"USA", "CHINA", "JAPAN", "RUSSIA", "KOREA", "UK"};
        SortUtil.testSort("top.cfish.algorithm.sort.basic.InsertionSort", arr);
        SortUtil.printArrays(arr);
        Assert.assertTrue(SortUtil.isSorted(arr));
    }
    
    @Test
    public void objSortTest()
    {
        Student[] arr = new Student[4];
        arr[0] = new Student("D",90);
        arr[1] = new Student("C",100);
        arr[2] = new Student("B",95);
        arr[3] = new Student("A",95);
        
        SortUtil.testSort("top.cfish.algorithm.sort.basic.InsertionSort", arr);
        SortUtil.printArrays(arr);
        Assert.assertTrue(SortUtil.isSorted(arr));
    }
    
    class Student implements Comparable<Student>
    {
        private String name;
        private int score;
        
        public Student(String name, int score)
        {
            this.name = name;
            this.score = score;
        }
        
        @Override
        public int compareTo(Student that)
        {
            
            if (this.score < that.score)
            {
                return -1;
            }
            else if (this.score > that.score)
            {
                return 1;
            }
            else
            {
                return this.name.compareTo(that.name);
            }
        }
        
        @Override
        public String toString()
        {
            return "Student: " + this.name + " " + Integer.toString(this.score);
        }
    }
}
