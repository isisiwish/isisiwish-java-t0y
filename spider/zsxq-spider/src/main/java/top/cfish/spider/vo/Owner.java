package top.cfish.spider.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Owner
{
    @JSONField(name = "user_id")
    private long userId;
    private String name;
}
