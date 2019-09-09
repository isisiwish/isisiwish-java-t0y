package top.cfish.spider.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Solution
{
    @JSONField(name = "task_id")
    private long taskId;
    
    private Owner owner;
    
    private String text;
    
    private List<Files> files;
    private List<Images> images;
}
