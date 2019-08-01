package top.cfish.sso.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author: isisiwish
 * @date: 2019/3/26
 * @time: 18:01
 */
public class MD5Util
{
    public static String encode(String src)
    {
        return DigestUtils.md5Hex(src);
    }
}
