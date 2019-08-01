package top.cfish.sso.util;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.util.*;
import java.util.Map.Entry;

/**
 * @author: isisiwish
 * @date: 2019/3/26
 * @time: 18:00
 */

public class HTTPUtil
{
    public static boolean post(String url, Map<String, String> params)
    {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        // 参数处理
        if (params != null && !params.isEmpty())
        {
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            
            Iterator<Entry<String, String>> it = params.entrySet().iterator();
            while (it.hasNext())
            {
                Entry<String, String> entry = it.next();
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            
            httpPost.setEntity(new UrlEncodedFormEntity(list, Consts.UTF_8));
        }

        try
        {
            CloseableHttpResponse response = httpclient.execute(httpPost);
            response.getStatusLine().getStatusCode();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }
}
