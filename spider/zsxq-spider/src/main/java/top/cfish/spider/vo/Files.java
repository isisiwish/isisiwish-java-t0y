package top.cfish.spider.vo;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Files
{
    @JSONField(name = "file_id")
    private long fileId;
    
    private String name;
    
    private String hash;
    
    private long size;
    
    @JSONField(name = "download_count")
    private int downloadCount;
    
    @JSONField(name = "create_time")
    private Date createTime;
}
