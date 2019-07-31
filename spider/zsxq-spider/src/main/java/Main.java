import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.URLDecoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: isisiwish
 * @date: 2019/6/26
 * @time: 21:30
 */
public class Main
{
    public static List<String> fileIdList = new ArrayList<String>();
    
    public static void main(String[] args)
    {
        // if (args.length == 0)
        // {
        //     System.out.println("\njava -jar xxx.jar zsxq_access_token groupID path");
        //     System.out.println("\nzsxq_access_token is the value of \"zsxq_access_token\"");
        //     System.out.println("\ngroupID is Secret circle ID");
        //     System.out.println("\npath is file download path");
        //
        // }
        // String zsxq_access_token = args[0];
        // String groupID = args[1];
        // String path = args[2];
        
        String zsxq_access_token = "5A0A9C39-6186-DA45-5F2C-EF5921F1AB1A";
        String groupID = "455454142888";
        String path = "c:/xiaomiquan/";
        
        List<String> idList = getFileIdList(zsxq_access_token, groupID, "");
        idList.parallelStream().forEach(fileId->downFileByFileid(zsxq_access_token, fileId, path));
        System.out.println("下载完成,本次共下载" + idList.size() + "个文件");
    }
    
    /**
     * @param zsxq_access_token 圈子Token
     * @param groupID           需下载附件的圈子ID
     * @param end_time          附件最后的时间
     */
    private static List<String> getFileIdList(String zsxq_access_token, String groupID, String end_time)
    {
        
        String url = "https://api.zsxq.com/v1.10/groups/" + groupID + "/topics?count=20";
        String body = getAllTopic(url, zsxq_access_token, end_time);
        JSONArray jsonArray = JSONObject.parseObject(body).getJSONObject("resp_data").getJSONArray("files");
        String temp = JSONObject.parseObject(jsonArray.get(jsonArray.size() - 1).toString()).getJSONObject("file").getString("create_time");
        temp = temp.replaceAll(":", "%3a").replaceAll("\\+", "%2b");
        if (!temp.equals(end_time))
        {
            end_time = temp;
            getFileIdList(zsxq_access_token, groupID, end_time);
        }
        for (Object object : jsonArray)
        {
            String file_id = JSONObject.parseObject(object.toString()).getJSONObject("file").getString("file_id");
            fileIdList.add(file_id);
            //			downFileByFileid(file_id);
        }
        fileIdList = fileIdList.stream().distinct().collect(Collectors.toList());
        return fileIdList;
    }
    
    /**
     * 根据文件ID下载文件
     *
     * @param file_id
     */
    private static void downFileByFileid(String zsxq_access_token, String file_id, String path)
    {
        String url = "https://api.zsxq.com/v1.10/files/" + file_id + "/download_url";
        
        try
        {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("Cookie", "zsxq_access_token=" + zsxq_access_token);
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");
            CloseableHttpResponse response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String body = EntityUtils.toString(entity, "utf-8");
            String download_url = JSONObject.parseObject(body).getJSONObject("resp_data").getString("download_url");
            downFile(download_url, path);
        }
        catch (ClientProtocolException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    private static void downFile(String download_url, String path)
    {
        try
        {
            
            int strStartIndex = download_url.indexOf("attname=");
            int strEndIndex = download_url.indexOf("&");
            String filename = download_url.substring(strStartIndex, strEndIndex).substring("attname=".length());
            filename = URLDecoder.decode(filename, "utf-8");
            
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(download_url);
            CloseableHttpResponse httpclientResponse = httpclient.execute(httpGet);
            
            HttpEntity entity = httpclientResponse.getEntity();
            InputStream is = entity.getContent();
            BufferedInputStream bis = new BufferedInputStream(is);
            
            File file = new File(path + filename);
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            
            byte[] byt = new byte[1024 * 8];
            Integer len = -1;
            while ((len = bis.read(byt)) != -1)
            {
                bos.write(byt, 0, len);
            }
            
            bos.flush();
            bos.close();
            bis.close();
        }
        catch (ClientProtocolException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedOperationException e)
        {
            e.printStackTrace();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
    }
    
    /**
     * 获取本次请求的响应
     *
     * @param url
     * @param zsxq_access_token
     * @param end_time
     * @return
     */
    private static String getAllTopic(String url, String zsxq_access_token, String end_time)
    {
        if (!"".equals(end_time))
        {
            url = url + "&end_time=" + end_time;
        }
        
        try
        {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("Cookie", "zsxq_access_token=" + zsxq_access_token);
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:56.0) Gecko/20100101 Firefox/56.0");
            httpGet.setHeader("Referer", "https://wx.zsxq.com/dweb/");
            CloseableHttpResponse response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String body = EntityUtils.toString(entity, "utf-8");
            return body;
        }
        catch (ClientProtocolException e1)
        {
            e1.printStackTrace();
        }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }
        return "ERROR";
    }
}
