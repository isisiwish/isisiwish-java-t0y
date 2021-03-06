package top.cfish.sso.util;


import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/**
 /**
 * @author: isisiwish
 * @date: 2019/3/26
 * @time: 18:01
 */
public class RSAUtil
{
    private static Key PRIVATE_KEY;
    private static Key PUBLIC_KEY;
    
    private static final String ALGORITHM = "RSA";
    private static final int KEYSIZE = 1024;
    
    static
    {
        genKeyPair();
    }
    
    /**
     * 生成RSA密钥对
     */
    public static void genKeyPair()
    {
        KeyPairGenerator keyPairGenerator = null;
        try
        {
            keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        keyPairGenerator.initialize(KEYSIZE);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PRIVATE_KEY = keyPair.getPrivate();
        PUBLIC_KEY = keyPair.getPublic();
    }
    
    /**
     * 使用RSA加密字符串
     */
    public static String encode(String src)
    {
        try
        {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, PUBLIC_KEY);
            return Base64.encodeBase64String(cipher.doFinal(src.getBytes()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 使用RSA解密字符串
     */
    public static String decode(String src)
    {
        try
        {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, PRIVATE_KEY);
            return new String(cipher.doFinal(Base64.decodeBase64(src)));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
