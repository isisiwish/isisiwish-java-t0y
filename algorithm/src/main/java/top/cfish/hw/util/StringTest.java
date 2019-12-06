package top.cfish.hw.util;

import org.junit.Assert;
import org.junit.Test;

import javax.xml.transform.Source;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

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
        String substringB = str.substring(1, 3);//[1, 3)
        System.out.println(substringA);
        System.out.println(substringB);
    }
}
