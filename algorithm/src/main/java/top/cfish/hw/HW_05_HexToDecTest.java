package top.cfish.hw;

/**
 * @author: isisiwish
 * @date: 2019/12/3
 * @time: 22:13
 */
public class HW_05_HexToDecTest {
    public static int hexToDec(String hex) {
        int sum = 0;

        if (hex.startsWith("0x") || hex.startsWith("0X")) {
            for (int i = 2; i < hex.length(); i++) {
                char ch = hex.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    sum = sum * 16 + ch - '0';
                } else if (ch >= 'A' && ch <= 'Z') {
                    sum = sum * 16 + ch - 'A' + 10;
                } else if (ch >= 'a' && ch <= 'z') {
                    sum = sum * 16 + ch - 'a' + 10;
                } else {
                    return -1;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(hexToDec("0x111"));
    }
}
