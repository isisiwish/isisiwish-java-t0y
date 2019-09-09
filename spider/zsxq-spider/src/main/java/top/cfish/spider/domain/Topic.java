package top.cfish.spider.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author: isisiwish
 * @date: 2019/9/4
 * @time: 14:47
 */

@Getter
@Setter
public class Topic
{
    private Long id;

    private Long topicId;

    private Integer topicType;

    private Long ownerId;

    private String ownerName;

    private String content;

    private String imagePath;

    private Integer readingCount;

    private Integer commentsCount;

    private Date topicCreateTime;

    private Date createTime;

    private Date updateTime;
}
