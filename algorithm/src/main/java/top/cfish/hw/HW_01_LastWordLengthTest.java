package top.cfish.hw;

/**
 * @author: isisiwish
 * @date: 2019/12/2
 * @time: 20:42
 * 计算字符串最后一个单词的长度，单词以空格隔开
 */
public class HW_01_LastWordLengthTest {

    public static int lastWordLength(String str) {
        if (null == str || str.length() == 0) {
            return 0;
        }
        String[] sub = str.split(" ");
        int wordCount = sub.length;
        if (wordCount != 0) {
            return sub[wordCount - 1].length();
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(lastWordLength(""));
    }
}
