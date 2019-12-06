package top.cfish.hw;

/**
 * @author: isisiwish
 * @date: 2019/12/2
 * @time: 20:52
 */
public class HW_02_CharacterCountTest {
    public static int characterCount(String str, char character) {
        int count = 0;
        if ((character >= 'A' && character < 'Z') || (character >= 'a' && character <= 'z') || (character >= '0' && character <= '9')) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == character) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(characterCount("ABC-CBA-AAA-BBB-CCC", 'A'));
    }
}
