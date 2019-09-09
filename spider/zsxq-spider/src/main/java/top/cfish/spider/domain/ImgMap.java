package top.cfish.spider.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author: isisiwish
 * @date: 2019/9/4
 * @time: 16:10
 */

@Getter
@Setter
public class ImgMap
{
    private Integer id;
    
    private String originalImgUrl;
    
    private String cdnImgUrl;
    
    private String imgMd5;
    
    private Date createTime;
    
    private Date updateTime;
    
    private Integer width;
    
    private Integer height;
    
    private Integer size;
}
