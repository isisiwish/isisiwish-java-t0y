package top.cfish.spider.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import top.cfish.spider.domain.Topic;
import top.cfish.spider.mapper.TopicMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: isisiwish
 * @date: 2019/9/4
 * @time: 14:47
 */

@Slf4j
@Service
public class TopicService
{
    @Resource
    private TopicMapper topicMapper;
    
    public int deleteByPrimaryKey(Long id)
    {
        return topicMapper.deleteByPrimaryKey(id);
    }
    
    public int insert(Topic record)
    {
        return topicMapper.insert(record);
    }
    
    public int insertSelective(Topic record)
    {
        int result = 0;
        try
        {
            result = topicMapper.insertSelective(record);
        }
        catch (DuplicateKeyException e)
        {
            log.debug("DuplicateKey: {}", record.getTopicId());
        }
        return result;
    }
    
    public Topic selectByPrimaryKey(Long id)
    {
        return topicMapper.selectByPrimaryKey(id);
    }
    
    public int updateByPrimaryKeySelective(Topic record)
    {
        return topicMapper.updateByPrimaryKeySelective(record);
    }
    
    public int updateByPrimaryKey(Topic record)
    {
        return topicMapper.updateByPrimaryKey(record);
    }
}
