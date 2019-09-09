package top.cfish.spider.services;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.cfish.spider.vo.KnowledgePlanetEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: isisiwish
 * @date: 2019/9/4
 * @time: 14:17
 */
@Slf4j
@Service
public class HttpService
{
    // https://api.zsxq.com/v1.10/groups/825258842212/topics?scope=all&count=30&end_time=2019-08-06T08%3A14%3A16.023%2B0800
    public final static String baseUrl = "https://api.zsxq.com/v1.10/groups/825258842212/topics?scope=all&count=30";
    public final static String userAgent = "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:56.0) Gecko/20100101 Firefox/56.0";
    public final static String cookie = "abtest_env=product; zsxq_access_token=52C56BA0-012E-067E-A31C-8F40B61FF3E4";
    
    private KnowledgePlanetEntity callKnowledgePlanetApi(String url)
    {
        String json = HttpRequest.get(url)
            .header("User-Agent", userAgent)
            .header("Cookie", cookie)
            .cookie(cookie)
            .timeout(20000)
            .execute()
            .body();
        log.info("url: {}，接口返回: {}", url, json);
        KnowledgePlanetEntity entity = JSON.parseObject(json, KnowledgePlanetEntity.class);
        return entity;
    }
    
    public KnowledgePlanetEntity getOnePage()
    {
        return callKnowledgePlanetApi(baseUrl);
    }
    
    public KnowledgePlanetEntity getOnePage(Date date)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        log.info("createTime: {}", dateFormat.format(date));
        date = DateUtil.date(date.getTime() + 1L);
        String apiUrl = baseUrl + "&end_time=" + URLUtil.encodeAll(dateFormat.format(date));
        log.info("apiUrl: {}", apiUrl);
        return callKnowledgePlanetApi(apiUrl);
    }
}
