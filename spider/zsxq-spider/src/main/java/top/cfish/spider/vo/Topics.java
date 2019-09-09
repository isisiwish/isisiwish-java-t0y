package top.cfish.spider.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Date;

@Getter
@Setter
public class Topics
{
    @JSONField(name = "topic_id")
    private long topicId;
    private String type;
    private Talk talk;
    private Question question;
    private Answer answer;
    private Solution solution;
    private Task task;
    
    @JSONField(name = "show_comments")
    private List<ShowComments> showComments;
    
    @JSONField(name = "comments_count")
    private int commentsCount;
    
    @JSONField(name = "reading_count")
    private int readingCount;
    
    @JSONField(name = "create_time")
    private Date createTime;
}
