/**
 * @author: isisiwish
 * @date: 2020/6/23 0023
 * @time: 23:23
 */
public class 最后一个单词的长度_058
{
    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        if (split.length != 0) {
            return (split[split.length - 1]).length();
        } else {
            return 0;
        }
    }
}
