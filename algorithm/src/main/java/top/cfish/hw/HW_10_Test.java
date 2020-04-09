package top.cfish.hw;

/**
 * @author: isisiwish
 * @date: 2019/12/11
 * @time: 23:54
 */
public class HW_10_Test {

    public static boolean isEmpty(String str) {
        return ((str == null) || (str.length() == 0));
    }

    // 分别向左右扩展，返回扩展后的字符串
    private static String expand(String s, int left, int right) {
        int len = s.length();
        while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (left + 1 >= right - left) {
            return "";
        }
        return s.substring(left + 1, right);
    }

    // 求最长回文子串
    public static String longPalindromeString(String str) {
        if (isEmpty(str)) {
            return "";
        }

        int len = str.length();
        if (len <= 1) {
            return str;
        }

        String longest = "";
        for (int i = 0; i < len - 1; i++) {
            // 奇数
            String p = expand(str, i, i);
            if (p.length() > longest.length()) {
                longest = p;
            }

            // 偶数
            String s = expand(str, i, i + 1);
            if (s.length() > longest.length()) {
                longest = s;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        // String str = "abcdcbx";
        // String str = "baabaax";
        String str = "abbbc";
        System.out.println(longPalindromeString(str));
    }
}
