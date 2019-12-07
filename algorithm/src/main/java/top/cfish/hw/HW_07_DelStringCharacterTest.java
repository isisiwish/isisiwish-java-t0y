package top.cfish.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: isisiwish
 * @date: 2019/12/7
 * @time: 17:10
 */
public class HW_07_DelStringCharacterTest {
    public static void delStringCharacter(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
        // 通过比较器实现排序
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        Integer min = list.get(0).getValue();
        Iterator<Map.Entry<Character, Integer>> iterator = list.iterator();

        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> p = iterator.next();
            if (p.getValue().equals(min)) {
                iterator.remove();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i).getKey());
        }
        String dump = stringBuilder.toString();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (dump.contains(Character.toString(ch))) {
                System.out.print(ch);
            }
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // String str = "abcdd";
        String str = scanner.nextLine();
        delStringCharacter(str);

        // List<String> list = new ArrayList<>();
        // list.add("123");
        // list.add("456");
        // list.add("123");
        // list.remove(0);
        // ArrayList<String> delString = new ArrayList<>();
        // delString.add("123");
        // list.removeAll(delString);
        // System.out.println(list);
    }
}
