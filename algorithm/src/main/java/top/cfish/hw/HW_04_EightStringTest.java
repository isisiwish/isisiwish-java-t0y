package top.cfish.hw;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author: isisiwish
 * @date: 2019/12/2
 * @time: 21:22
 */
public class HW_04_EightStringTest {
    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        if (length == 0) {
            length = 1;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public static String[] getRandomStringArray(int n) {
        Random random = new Random();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            String randomString = getRandomString(random.nextInt(24));
            strings[i] = randomString;
        }
        return strings;
    }

    public static String[] EightString(String[] strings) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : strings) {
            if (str.length() < 8) {
                StringBuilder tmp = new StringBuilder("00000000");
                tmp.replace(0, str.length() - 1, str);
                arrayList.add(tmp.toString());
            } else if (str.length() == 8) {
                arrayList.add(str);
            } else {
                int len = str.length();
                int loop = len / 8;
                int tail = len % 8;
                for (int i = 0; i < loop; i++) {
                    String tmp = str.substring(i*8, (i+1)*8);
                    arrayList.add(tmp);
                }
                StringBuilder tmp = new StringBuilder("00000000");
                String s = str.substring(len-tail);
                tmp.replace(0, s.length() - 1, s);
                arrayList.add(tmp.toString());
            }
        }
        String[] ret = new String[arrayList.size()];
        int index = 0;
        for (String s : arrayList) {
            ret[index] = s;
            index++;
        }
        return ret;
    }

    public static void main(String[] args) {
        String[] randomStringArray = getRandomStringArray(3);
        for (String str : randomStringArray) {
            System.out.println(str);
        }

        System.out.println("########");

        String[] strings = EightString(randomStringArray);
        for (String str : strings) {
            System.out.println(str);
        }
    }
}
