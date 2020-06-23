import java.util.ArrayList;
import java.util.List;

/**
 * @author: isisiwish
 * @date: 2020/6/23 0023
 * @time: 23:45
 */
public class 验证回文串_125 {
    public boolean isPalindrome(String s) {
        List<Character> chars = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (Character.isLetter(ch) || Character.isDigit(ch)) {
                chars.add(Character.toLowerCase(ch));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : chars) {
            stringBuilder.append(character);
        }
        String src = stringBuilder.toString();
        String reverse = stringBuilder.reverse().toString();
        return src.equals(reverse);
    }
}
