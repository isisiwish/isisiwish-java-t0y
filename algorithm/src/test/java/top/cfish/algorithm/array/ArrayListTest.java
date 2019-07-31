package top.cfish.algorithm.array;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * @author: isisiwish
 * @date: 2018/8/22
 * @time: 15:15
 */
@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArrayListTest
{
    @Test
    public void getCapacityTest()
    {
        ArrayList<Integer> arrayList = new ArrayList(2);
        Assert.assertEquals(arrayList.getCapacity(), 2);
        arrayList.fillAll(10);
        arrayList.addLast(20);
        Assert.assertEquals(arrayList.getCapacity(), 4);
        arrayList.removeFirst();
        arrayList.removeFirst();
        Assert.assertEquals(arrayList.getCapacity(), 1);
    }
    
    @Test
    public void getSizeTest()
    {
        ArrayList<Integer> arrayList = new ArrayList();
        Assert.assertEquals(arrayList.getSize(), 0);
        arrayList.addFirst(10);
        Assert.assertEquals(arrayList.getSize(), 1);
        arrayList.fillAll(10);
        Assert.assertEquals(arrayList.getSize(), 10);
    }
    
    @Test
    public void toStringTest()
    {
        ArrayList<Integer> arrayList = new ArrayList(1, 2, 3, 4, 5);
        Assert.assertNotNull(arrayList.toString());
    }
    
    @Test
    public void addFirstTest()
    {
        ArrayList<Integer> arrayList = new ArrayList(1, 2, 3, 4, 5);
        arrayList.addFirst(0);
        Assert.assertEquals(arrayList.get(0), Integer.valueOf(0));
    }
    
    @Test
    public void addLastTest()
    {
        ArrayList<Integer> arrayList = new ArrayList(1, 2, 3, 4, 5);
        arrayList.addLast(0);
        Assert.assertEquals(arrayList.get(arrayList.getSize() - 1), Integer.valueOf(0));
    }
    
    @Test
    public void printAllTest()
    {
        ArrayList<Integer> arrayList = new ArrayList(1, 2, 3, 4, 5);
        arrayList.printAll();
    }
    
    @Test
    public void printTest()
    {
        ArrayList<Integer> arrayList = new ArrayList(1, 2, 3, 4, 5);
        arrayList.print(1, 3);
    }
    
    @Test
    public void clearTest()
    {
        ArrayList<Integer> arrayList = new ArrayList(1, 2, 3, 4, 5);
        arrayList.clear();
        Assert.assertTrue(arrayList.isEmpty());
    }
    
    @Test
    public void isEmptyTest()
    {
        ArrayList<Integer> arrayList = new ArrayList();
        Assert.assertTrue(arrayList.isEmpty());
        arrayList.addFirst(10);
        Assert.assertFalse(arrayList.isEmpty());
        arrayList.removeLast();
        Assert.assertTrue(arrayList.isEmpty());
    }
    
    @Test
    public void fillAllTest()
    {
        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.fillAll(0);
        Assert.assertEquals(arrayList.getSize(), 10);
    }
    
    @Test
    public void setTest()
    {
        ArrayList<Integer> arrayList = new ArrayList(1, 2, 3, 4, 5);
        arrayList.set(0, 0);
        Assert.assertEquals(arrayList.get(0), Integer.valueOf(0));
    }
    
    @Test
    public void getTest()
    {
        ArrayList<Integer> arrayList = new ArrayList(1, 2, 3, 4, 5);
        Assert.assertEquals(arrayList.get(0), Integer.valueOf(1));
    }
    
    @Test
    public void isFullTest()
    {
        ArrayList<Integer> arrayList = new ArrayList(1, 2, 3, 4, 5);
        Assert.assertTrue(arrayList.isFull());
        
        arrayList = new ArrayList();
        Assert.assertFalse(arrayList.isFull());
        Assert.assertTrue(arrayList.isEmpty());
        arrayList.fillAll(10);
        Assert.assertTrue(arrayList.isFull());
    }
    
    @Test
    public void insertTest()
    {
        ArrayList<Integer> arrayList = new ArrayList(1, 2, 3, 4, 5);
        arrayList.insert(-100, 0);
        Assert.assertFalse(arrayList.isFull());
        Assert.assertEquals(arrayList.get(0), Integer.valueOf(-100));
    }
    
    @Test
    public void addTest()
    {
        ArrayList<Integer> arrayList = new ArrayList(1, 2, 3, 4, 5);
        arrayList.add(-200, 1);
        Assert.assertFalse(arrayList.isFull());
        Assert.assertEquals(arrayList.get(1), Integer.valueOf(-200));
    }
    
    @Test
    public void addAllTest()
    {
        ArrayList<Integer> arrayList = new ArrayList(1, 2, 3, 4, 5);
        arrayList.addAll(arrayList.getSize(), new Integer[]{10, 20, 30});
        Assert.assertEquals(arrayList.getSize(), 8);
        Assert.assertEquals(arrayList.get(arrayList.getSize() - 1), Integer.valueOf(30));
    }
    
    @Test
    public void searchTest()
    {
        ArrayList<Integer> arrayList = new ArrayList(10, 20, 30, 40, 50);
        int rs = arrayList.search(1);
        Assert.assertEquals(rs, -1);
        
        for (int i = 0; i < 5; i++)
        {
            rs = arrayList.search((i + 1) * 10);
            Assert.assertEquals(rs, i);
        }
    }
    
    @Test
    public void containsTest()
    {
        ArrayList<Integer> arrayList = new ArrayList(10, 20, 30, 40, 50);
        Assert.assertTrue(arrayList.contains(20));
        Assert.assertTrue(arrayList.contains(40));
        Assert.assertFalse(arrayList.contains(-10));
    }
    
    @Test
    public void lastIndexOfTest()
    {
        ArrayList<Integer> arrayList = new ArrayList(10, 20, 30, 20, 10);
        int rs = arrayList.lastIndexOf(20);
        Assert.assertEquals(rs, 3);
        rs = arrayList.indexOf(20);
        Assert.assertEquals(rs, 1);
    }
    
    @Test
    public void removeByIndexTest()
    {
        ArrayList<Integer> arrayList = new ArrayList(10, 20, 30, 40, 50);
        Assert.assertEquals(arrayList.get(1), Integer.valueOf(20));
        arrayList.remove(1);
        Assert.assertEquals(arrayList.get(1), Integer.valueOf(30));
        Assert.assertEquals(arrayList.get(0), Integer.valueOf(10));
    }
    
    @Test
    public void removeByElemTest()
    {
        ArrayList<Integer> arrayList = new ArrayList(10, 20, 30, 30, 40);
        arrayList.remove(Integer.valueOf(30));
        Assert.assertEquals(arrayList.get(1), Integer.valueOf(20));
        Assert.assertEquals(arrayList.get(2), Integer.valueOf(30));
        Assert.assertEquals(arrayList.get(3), Integer.valueOf(40));
    }
    
    @Test
    public void removeFirstTest()
    {
        ArrayList<Integer> arrayList = new ArrayList(10, 20, 30, 40, 50);
        Integer rs = arrayList.removeFirst();
        Assert.assertEquals(rs, Integer.valueOf(10));
        Assert.assertEquals(arrayList.get(0), Integer.valueOf(20));
    }
    
    @Test
    public void removeLastTest()
    {
        ArrayList<Integer> arrayList = new ArrayList(10, 20, 30, 40, 50);
        Integer rs = arrayList.removeLast();
        Assert.assertEquals(rs, Integer.valueOf(50));
        Assert.assertEquals(arrayList.get(arrayList.getSize() - 1), Integer.valueOf(40));
    }
    
    @Test
    public void removeRangeTest()
    {
        ArrayList<Integer> arrayList = new ArrayList(10, 20, 30, 40, 50);
        arrayList.addFirst(3);
        arrayList.addFirst(2);
        arrayList.addFirst(1);
        
        Object[] rsArr = arrayList.removeRange(2, 4);
        Assert.assertEquals(arrayList.get(1), Integer.valueOf(2));
        Assert.assertEquals(arrayList.get(2), Integer.valueOf(30));
        Assert.assertEquals(arrayList.get(4), Integer.valueOf(50));
        
        Assert.assertEquals(rsArr[0], Integer.valueOf(3));
        Assert.assertEquals(rsArr[1], Integer.valueOf(10));
        Assert.assertEquals(rsArr[2], Integer.valueOf(20));
    }
    
    @Test
    public void subArrayRangeTest()
    {
        ArrayList<Integer> arrayList = new ArrayList(10, 20, 30, 40, 50);
        Object[] rsArr = arrayList.subList(0, 2);
        
        Assert.assertEquals(arrayList.getSize(), 5);
        Assert.assertEquals(rsArr[0], Integer.valueOf(10));
        Assert.assertEquals(rsArr[1], Integer.valueOf(20));
        Assert.assertEquals(rsArr[2], Integer.valueOf(30));
    }
    
    @Test
    public void equalsTest()
    {
        ArrayList<Integer> arrayListA = new ArrayList(5);
        ArrayList<Integer> arrayListB = new ArrayList(5);
        
        arrayListA.addLast(1);
        arrayListB.addLast(1);
        Assert.assertTrue(arrayListA.equals(arrayListB));
        
        arrayListB.addLast(2);
        Assert.assertFalse(arrayListA.equals(arrayListB));
        arrayListA.clear();
        arrayListB.clear();
        Assert.assertTrue(arrayListA.equals(arrayListB));
    }
    
    @Test
    public void hashCodeTest()
    {
        ArrayList<Integer> arrayListA = new ArrayList(5);
        ArrayList<Integer> arrayListB = new ArrayList(5);
        ArrayList<Integer> arrayListC = new ArrayList();
        arrayListA.addLast(1);
        arrayListB.addLast(1);
        arrayListC.addLast(1);
        
        int hashA = arrayListA.hashCode();
        int hashB = arrayListB.hashCode();
        int hashC = arrayListC.hashCode();
        Assert.assertEquals(hashA, hashB);
        Assert.assertNotEquals(hashA, hashC);
    }
    
    @Test
    public void reverseTest()
    {
        ArrayList<Integer> arrayListA = new ArrayList(10, 20, 30, 40, 50);
        ArrayList<Integer> arrayListB = new ArrayList(50, 40, 30, 20, 10);
        arrayListA.reverse();
        Assert.assertTrue(arrayListA.equals(arrayListB));
    }
    
    @Test
    public void removeAllTest()
    {
        ArrayList<Integer> arrayListA = new ArrayList(10, 20, 10, 30, 40, 50, 10, 10, 60, 10, 70, 10, 80, 10, 90, 100, 10);
        arrayListA.removeAll(10);
        arrayListA.printAll();
        
        arrayListA = new ArrayList(0, 10, 10, 10, 10, 0);
        arrayListA.removeAll(10);
        arrayListA.printAll();
    }
}
