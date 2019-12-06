package top.cfish.hw.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: isisiwih
 * @date: 2019/12/6
 * @time: 21:53
 */
public class IsisiwishStringUtils {
    /**
     * 验证是否为手机号码
     */
    public static boolean isPhone(String phone) {
        Pattern pattern = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    /**
     * 判断是否为邮箱
     */
    public static boolean isEmail(String email) {
        Pattern pattern = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * 得到文件的后缀
     */
    public static String getSuffix(String fileName) {
        String fileOriName = fileName;
        String suffix = fileOriName.substring(fileOriName.lastIndexOf("."), fileOriName.length());
        return suffix;
    }

    /**
     * 取得指定子串在字符串中出现的次数
     *
     * @param str    要扫描的字符串
     * @param subStr 子字符串
     * @return 子串在字符串中出现的次数，如果字符串为null或空""，则返回0
     */
    public static int countMatches(String str, String subStr) {
        if ((str == null) || (str.length() == 0) || (subStr == null) || (subStr.length() == 0)) {
            return 0;
        }

        int count = 0;
        int index = 0;

        while ((index = str.indexOf(subStr, index)) != -1) {
            count++;
            index += subStr.length();
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(isPhone("13991143296"));
    }
}
