import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.MD5;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.cfish.spider.domain.Comments;
import top.cfish.spider.domain.ImgMap;
import top.cfish.spider.domain.Topic;
import top.cfish.spider.services.CommentsService;
import top.cfish.spider.services.HttpService;
import top.cfish.spider.services.ImgMapService;
import top.cfish.spider.services.TopicService;
import top.cfish.spider.vo.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author: isisiwish
 * @date: 2019/9/3
 * @time: 21:06
 */

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring.xml"})
public class SpiderApp
{
    @Autowired
    private CommentsService commentsService;
    
    @Autowired
    private TopicService topicService;
    
    @Autowired
    private ImgMapService imgMapService;
    
    @Autowired
    HttpService httpService;
    
    private boolean check(KnowledgePlanetEntity entity)
    {
        // 校验entity
        if (entity == null || entity.getSucceeded() == false || entity.getRespData() == null || entity.getRespData().getTopics() == null || entity.getRespData().getTopics().size() == 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    private Date saveTopic(List<Topics> topicList)
    {
        for (Topics topic : topicList)
        {
            Topic dbTopic = new Topic();
            dbTopic.setTopicId(topic.getTopicId());
            dbTopic.setReadingCount(topic.getReadingCount());
            dbTopic.setCommentsCount(topic.getCommentsCount());
            dbTopic.setTopicCreateTime(topic.getCreateTime());
            dbTopic.setCreateTime(new Date());
            dbTopic.setUpdateTime(new Date());
            
            if (topic.getType().equals("talk"))
            {
                dbTopic.setTopicType(0);
                Talk talk = topic.getTalk();
                dbTopic.setOwnerId(talk.getOwner().getUserId());
                dbTopic.setOwnerName(talk.getOwner().getName());
                dbTopic.setContent(talk.getText());
                
                List<Images> imageList = talk.getImages();
                if (imageList != null && imageList.size() != 0)
                {
                    String imagePathStr = saveImage(imageList);
                    dbTopic.setImagePath(imagePathStr);
                }
            }
            else if (topic.getType().equals("q&a"))
            {
                dbTopic.setTopicType(1);
                Question question = topic.getQuestion();
                Answer answer = topic.getAnswer();
                dbTopic.setOwnerId(question.getQuestionee().getUserId());
                dbTopic.setOwnerName(question.getQuestionee().getName());
                dbTopic.setContent("Q: " + question.getText() + "\n" + "A: " + answer.getText());
                
                List<Images> imageList = question.getImages();
                if (imageList != null && imageList.size() != 0)
                {
                    String imagePathStr = saveImage(imageList);
                    dbTopic.setImagePath(imagePathStr);
                }
            }
            else if (topic.getType().equals("task"))
            {
                dbTopic.setTopicType(2);
                Task task = topic.getTask();
                
                dbTopic.setOwnerId(task.getOwner().getUserId());
                dbTopic.setOwnerName(task.getOwner().getName());
                dbTopic.setContent(task.getText());
                
                List<Images> imageList = task.getImages();
                if (imageList != null && imageList.size() != 0)
                {
                    String imagePathStr = saveImage(imageList);
                    dbTopic.setImagePath(imagePathStr);
                }
            }
            else if (topic.getType().equals("solution"))
            {
                dbTopic.setTopicType(3);
                Solution solution = topic.getSolution();
                dbTopic.setOwnerId(solution.getOwner().getUserId());
                dbTopic.setOwnerName(solution.getOwner().getName());
                dbTopic.setContent(solution.getText());
                
                List<Images> imageList = solution.getImages();
                if (imageList != null && imageList.size() != 0)
                {
                    String imagePathStr = saveImage(imageList);
                    dbTopic.setImagePath(imagePathStr);
                }
            }
            else
            {
                log.info("未知的类型: {}", JSON.toJSONString(topic));
                continue;
            }
            topicService.insertSelective(dbTopic);
            
            List<ShowComments> commentList = topic.getShowComments();
            if (commentList != null && commentList.size() != 0)
            {
                saveComment(topic.getTopicId(), commentList);
            }
        }
        
        return topicList.get(topicList.size() - 1).getCreateTime();
    }
    
    private String saveImage(List<Images> imageList)
    {
        StringBuilder imagePath = new StringBuilder();
        
        for (Images image : imageList)
        {
            if (image.getOriginal() == null || image.getOriginal().getUrl() == null)
            {
                continue;
            }
            
            String originalUrl = image.getOriginal().getUrl();
            imagePath.append(originalUrl);
            imagePath.append(",");
            
            ImgMap dbImageMap = new ImgMap();
            dbImageMap.setOriginalImgUrl(originalUrl);
            dbImageMap.setWidth(image.getOriginal().getWidth());
            dbImageMap.setHeight(image.getOriginal().getHeight());
            dbImageMap.setSize((int)image.getOriginal().getSize());
            dbImageMap.setImgMd5(MD5.create().digestHex(originalUrl));
            dbImageMap.setCreateTime(new Date());
            dbImageMap.setUpdateTime(new Date());
            // todo cdnUrl
            dbImageMap.setCdnImgUrl(originalUrl);
            imgMapService.insertSelective(dbImageMap);
        }
        return imagePath.toString();
    }
    
    private void saveComment(Long topicId, List<ShowComments> commentList)
    {
        for (ShowComments comment : commentList)
        {
            Comments dbComment = new Comments();
            dbComment.setTopicId(topicId);
            dbComment.setUserId(comment.getOwner().getUserId());
            dbComment.setUserName(comment.getOwner().getName());
            dbComment.setComment(comment.getText());
            commentsService.insertSelective(dbComment);
        }
    }
    
    public Date save(KnowledgePlanetEntity entity)
    {
        if (!check(entity))
        {
            return null;
        }
        
        List<Topics> topicList = entity.getRespData().getTopics();
        Date nextCreateTime = saveTopic(topicList);
        return nextCreateTime;
    }
    
    @Test
    public void spiderTest() throws InterruptedException
    {
        KnowledgePlanetEntity fristEntity = httpService.getOnePage();
        Date nextCreateTime = save(fristEntity);
        
        while (nextCreateTime != null)
        {
            KnowledgePlanetEntity entity = httpService.getOnePage(nextCreateTime);
            nextCreateTime = save(entity);
            Thread.sleep(1000 * RandomUtil.randomInt(10, 60));
        }
    }
}
