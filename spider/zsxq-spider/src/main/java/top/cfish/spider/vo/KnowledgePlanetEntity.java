package top.cfish.spider.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KnowledgePlanetEntity
{
    private Boolean succeeded;
    
    @JSONField(name = "resp_data")
    private RespData respData;
}
