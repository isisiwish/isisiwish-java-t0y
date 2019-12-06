package top.cfish.hw;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

/**
 * @author: isisiwish
 * @date: 2019/12/2
 * @time: 21:02
 */
public class HW_03_SortAndDumplicateTest {

    public static int[] randomArray(int n) {
        ArrayList<Integer> arrayList = new ArrayList(n);
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int count = random.nextInt();
            arrayList.add(count);
        }
        int[] arr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            arr[i] = arrayList.get(i);
        }
        return arr;
    }

    public static int[] SortAndDumplicate(int[] array) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < array.length; i++) {
            treeSet.add(array[i]);
        }
        treeSet.comparator();
        int index = 0;
        for (int ti : treeSet) {
            array[index] = ti;
            index++;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = randomArray(10);
        SortAndDumplicate(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
