package top.cfish.spider.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

// https://developer.qiniu.com/kodo/sdk/1239/java
@Slf4j
public class QiNiuFileUploadUtil
{
    private static final String ACCESS_KEY;
    
    private static final String SECRET_KEY;

    // 空间地址
    private static final String IMG_BASE_URL;

    // 要上传的空间
    private static final String SERVER_NAME;
    
    // 密钥配置
    private static final Auth auth;
    
    
    // 创建上传对象
    private static UploadManager uploadManager;

    private static Random random = null;
    // 1MB
    private static final int MAX_TMP_KBSIZE = 1024;
    // 128KB
    private static final int CURR_TMP_KBSIZE = 128;

    static
    {
        ACCESS_KEY = PropertiesUtil.getProperty("ACCESS_KEY");
        SECRET_KEY = PropertiesUtil.getProperty("SECRET_KEY");
        SERVER_NAME = PropertiesUtil.getProperty("SERVER_NAME");
        IMG_BASE_URL = PropertiesUtil.getProperty("IMG_BASE_URL");
        
        auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        uploadManager = new UploadManager();
        random = new Random();
    }

    private static String getUpToken()
    {
        return auth.uploadToken(SERVER_NAME);
    }

    private static byte[] getByte(int size)
    {
        byte[] bs = new byte[size];

        for (int i = 0; i < size; i++)
        {
            bs[i] = (byte)random.nextInt();
        }

        return bs;
    }

    public static File createTmpFile(int kbSize) throws IOException
    {
        kbSize = kbSize < MAX_TMP_KBSIZE ? kbSize : MAX_TMP_KBSIZE;
        int size = MAX_TMP_KBSIZE * kbSize;
        byte[] b = getByte(size);
        FileOutputStream fos = null;
        try
        {
            File file = File.createTempFile("isisiwish_" + kbSize + "KB_", ".tmp");
            file.createNewFile();
            fos = new FileOutputStream(file);
            fos.write(b);
            return file;
        }
        finally
        {
            if (fos != null)
            {
                try
                {
                    fos.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    static class PutRet
    {
        private String key;
        private String hash;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }
    }

    public static boolean isConnect()
    {
        try
        {
            File tmpFile = createTmpFile(random.nextInt(CURR_TMP_KBSIZE));
            Response res = uploadManager.put(tmpFile.getPath(), tmpFile.getName(), getUpToken());
            PutRet putRet = new Gson().fromJson(res.bodyString(), PutRet.class);
            QiNiuFileUploadUtil.deleteFile(tmpFile.getName());
            if (tmpFile.getName().equals(putRet.getKey()))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public static String uploadBytes(byte[] bytes, String remoteDstFilePath)
    {
        try
        {
            Response res = uploadManager.put(bytes, remoteDstFilePath, getUpToken());
        }
        catch (QiniuException e)
        {
            log.error("字节内容上传失败 code:{} - {}\n{}",e.response.toString(), e.code(), e);
            return "null";
        }

        String rsUrl = String.format("%s%s", IMG_BASE_URL, remoteDstFilePath);
        return rsUrl;
    }

    public static String uploadFile(String srcFilePath, String remoteDstFilePath)
    {
        try
        {
            Response res = uploadManager.put(srcFilePath, remoteDstFilePath, getUpToken());
        }
        catch (QiniuException e)
        {
            log.error("文件上传失败 code:{} - {}\n{}", e.response.toString(), e.code(), e);
            log.error("{} --> {}", srcFilePath, remoteDstFilePath);
            return "null";
        }
        String rsUrl = String.format("%s%s", IMG_BASE_URL, remoteDstFilePath);
        return rsUrl;
    }

    public static String uploadBytes(byte[] bytes)
    {
        String dstFilePath = UUID.randomUUID().toString() + ".dat";
        try
        {
            Response res = uploadManager.put(bytes, dstFilePath, getUpToken());
        }
        catch (QiniuException e)
        {
            log.error("字节内容上传失败 code:{} - {}\n{}",e.response.toString(), e.code(), e);
            return "null";
        }
        String rsUrl = String.format("%s%s", IMG_BASE_URL, dstFilePath);
        return rsUrl;
    }


    public static String uploadFile(String srcFilePath)
    {
        String dstFilePath = UUID.randomUUID().toString() + srcFilePath.substring(srcFilePath.lastIndexOf("."));
        return QiNiuFileUploadUtil.uploadFile(srcFilePath, dstFilePath);
    }

    public static List<String> uploadFile(List<String> srcFilePathList)
    {
        List<String> rsUrlList = new ArrayList<>();

        for (String srcFilePath : srcFilePathList)
        {
            String rsUrl = QiNiuFileUploadUtil.uploadFile(srcFilePath);
            rsUrlList.add(rsUrl);
        }
        return rsUrlList;
    }


    public static void deleteFile(String srcFilePath)
    {
        BucketManager bucketManager = new BucketManager(auth);
        try
        {
            bucketManager.delete(SERVER_NAME, srcFilePath);
        }
        catch (QiniuException e)
        {
            log.error("删除{}文件失败 code:{} - {}\n{}", srcFilePath, e.response.toString(), e.code(), e);
        }
    }

    public static void main(String args[])
    {
        log.info(String.valueOf(isConnect()));
    }
}
