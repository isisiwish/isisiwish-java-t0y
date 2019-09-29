package top.cfish.lintcode;

/**
 * @author: isisiwish
 * @date: 2019/1/10
 * @time: 20:45
 * https://www.lintcode.com/problem/trailing-zeros/description
 */
public class Solution_0002 {

    static public long trailingZeros(long n) {
        long sum = 0;
        while (n != 0) {
            sum = sum + n / 5;
            n = n / 5;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeros(5));
    }
}
