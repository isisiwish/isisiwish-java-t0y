import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author: isisiwish
 * @date: 2020/6/23 0023
 * @time: 23:27
 */
public class 二进制求和_067
{
    public String addBinary(String a, String b) {
        BigInteger bigIntegerA = new BigInteger(a, 2);
        BigInteger bigIntegerB = new BigInteger(b, 2);
        BigInteger rs = bigIntegerA.add(bigIntegerB);
        return rs.toString(2);
    }
}
