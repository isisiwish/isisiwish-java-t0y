package top.cfish.hw.util;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author: isisiwish
 * @date: 2019/12/6
 * @time: 10:32
 * <p>
 * 1、String类不可改变
 */
public class StringTest {

    @Test
    public void stringConstructorTest() {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        String strA = new String(chars);
        System.out.println(strA);
        Assert.assertEquals("hello", strA);
    }

    @Test
    public void charAtTest() {
        String str = "hello";
        char first = str.charAt(0);
        char last = str.charAt(str.length() - 1);
        Assert.assertEquals('h', first);
        Assert.assertEquals('o', last);

    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void charAtExceptionTest() {
        String str = "hello";
        char ch = str.charAt(100);
        System.out.println(ch);
    }

    @Test
    public void compareToTest() {
        String strA = "hello";
        int rsA = strA.compareTo("hell");
        int rsB = strA.compareTo("hello");
        int rsC = strA.compareTo("helloo");
        int rsD = strA.compareTo("");
        try {
            int rsE = strA.compareTo(null);
        }
        catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }
        Assert.assertTrue(rsA > 0);
        Assert.assertTrue(rsB == 0);
        Assert.assertTrue(rsC < 0);
        Assert.assertTrue(rsD > 0);

        System.out.println(rsA);
        System.out.println(rsB);
        System.out.println(rsC);
        System.out.println(rsD);
    }

    @Test
    public void compareToIgnoreCaseTest() {
        String strA = "hello";
        int rsA = strA.compareToIgnoreCase("Hello");
        int rsB = strA.compareToIgnoreCase("HELlO");
        int rsC = strA.compareToIgnoreCase("helLoo");

        Assert.assertTrue(rsA == 0);
        Assert.assertTrue(rsB == 0);
        Assert.assertTrue(rsC < 0);
    }

    @Test
    public void copyValueOfTest() {
        char[] data = {'h', 'e', 'l', 'l', 'o'};
        String strA = String.copyValueOf(data);
        String strB = String.copyValueOf(data, 1, 2);
        System.out.println(strA);
        System.out.println(strB);

        Assert.assertEquals("hello", strA);
        Assert.assertEquals("el", strB);
    }

    @Test
    public void endsWithTest() {
        String strA = "hello.mp3";
        String strB = "hello.mp3.mp4";
        String suffix = "mp3";

        boolean rsA = strA.endsWith(suffix);
        boolean rsB = strB.endsWith(suffix);
        Assert.assertTrue(rsA);
        Assert.assertFalse(rsB);
    }

    private static void printBytes(byte[] bytes) {
        System.out.println("bytes#######start");
        for (byte b : bytes) {
            System.out.println(b);
        }
        System.out.println("bytes#######end");
    }

    @Test
    public void getBytesTest() {
        String strA = "hello";
        String strB = "你好世界";
        byte[] bytesA = strA.getBytes();
        byte[] bytesB = strB.getBytes();
        printBytes(bytesA);
        printBytes(bytesB);
        try {
            byte[] bytesC = strA.getBytes("UTF-8");
            byte[] bytesD = strB.getBytes("UTF-8");
            byte[] bytesE = strB.getBytes("GBK");
            byte[] bytesF = strB.getBytes("ISO-8859-1");
            printBytes(bytesC);
            printBytes(bytesD);
            printBytes(bytesE);
            printBytes(bytesF);
        } catch (UnsupportedEncodingException e) {
            System.out.println("不支持的字符集");
        }
    }

    @Test
    public void trimTest() {
        String strA = "  hello   world   !   ";
        String rsA = strA.trim();
        System.out.println(rsA);

        String strB = "  ";
        String rsB = strB.trim();
        System.out.println(rsB);
    }

    @Test
    public void valueOfTest() {
        String rs = String.valueOf(10086);
        Assert.assertEquals("10086", rs);
    }

    @Test
    public void toUpperAndLowerCaseTest() {
        String str = "HeLLo@GmAil.CoM";
        String upper = str.toUpperCase();
        System.out.println(upper);

        String upperLocale = str.toUpperCase(Locale.CHINA);
        System.out.println(upperLocale);

        String lower = str.toLowerCase();
        System.out.println(lower);
    }

    @Test
    public void toCharArrayTest() {
        String str = "hello";
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            System.out.println(ch);
        }
    }

    @Test
    public void substringTest() {
        String str = "hello world";
        String substringA = str.substring(1);
        // [1, 3)
        String substringB = str.substring(1, 3);
        System.out.println(substringA);
        System.out.println(substringB);
    }

    @Test
    public void isBlankTest() {
        boolean rs = StringUtils.isBlank("\t \n \f \r");
        System.out.println(rs);
    }

    // 非字符作为分割
    @Test
    public void splitTestA() {
        String str = "hello,,, world! one..two .-three 4";
        String[] split = str.split("[\\W]+");
        System.out.println(split.length);
        for (String s : split) {
            System.out.println(s);
        }
    }

    // 空白字符作为分割，包括空格、制表符、换页符，等价于[\f\n\r\t\v]。
    @Test
    public void splitTestB() {
        String str = "hello,,, world! one..\ttwo .-three 4";
        String[] split = str.split("\\s");
        System.out.println(split.length);
        for (String s : split) {
            System.out.println(s);
        }
    }

    // 数字作为分割
    @Test
    public void splitTestC() {
        String ss = "aa12sas32sasa223sas12as12wqe";
        String[] array = ss.split("[\\d]+");
        System.out.println(Arrays.toString(array));
    }
    // 标准输入
    @Test
    public void inputTest() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入:");
        String str = sc.next();
        System.out.println(str);
    }

    // 逗号分割，多个空格分割
    @Test
    public void splitTestD() {
        String ss = "aa,,sas,,sasa,,,,sasas,,,";
        String[] array = ss.split("[,]+");
        System.out.println(Arrays.toString(array));

        String s2 = "aa  sas sa sa     sas  as  ";
        String[] split = s2.split("[\\s]+");
        System.out.println(Arrays.toString(split));
    }

    // TreeSet测试 最终有序
    @Test
    public void treeSetTest() {
        TreeSet set = new TreeSet();
        set.add(1);
        set.add(3);
        set.add(2);
        System.out.println(set);
    }

    // LinkedHashSet测试 插入有序
    @Test
    public void linkedHashSet() {
        LinkedHashSet set = new LinkedHashSet();
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(3);
        System.out.println(set);
    }

    public static void main(String[] args) {
        String str = "abbbdcdc123";
        Map<Character, Integer> map = new LinkedHashMap();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                } else {
                    map.put(ch, 1);
                }
            }
        }

        // for (Character key : map.keySet()) {
        //     System.out.println(key + "=" + map.get(key));
        // }

        // 将map.entrySet()转换成list
        List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
        // 通过比较器实现排序
        Collections.sort(list,new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for(Map.Entry<Character, Integer> mapping:list){
            System.out.println(mapping.getKey()+"="+mapping.getValue());
        }
    }
}
