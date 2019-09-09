package top.cfish.spider.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: isisiwish
 * @date: 2019/9/4
 * @time: 14:47
 */

@Getter
@Setter
public class Comments
{
    private Long id;

    private Long topicId;

    private Long userId;

    private String userName;

    private String comment;
}
