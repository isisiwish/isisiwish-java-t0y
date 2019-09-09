package top.cfish.spider.services;

import top.cfish.spider.domain.Comments;
import top.cfish.spider.mapper.CommentsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: isisiwish
 * @date: 2019/9/4
 * @time: 14:47
 */

@Service
public class CommentsService
{
    @Resource
    private CommentsMapper commentsMapper;
    
    public int deleteByPrimaryKey(Long id)
    {
        return commentsMapper.deleteByPrimaryKey(id);
    }
    
    public int insert(Comments record)
    {
        return commentsMapper.insert(record);
    }
    
    public int insertSelective(Comments record)
    {
        return commentsMapper.insertSelective(record);
    }
    
    public Comments selectByPrimaryKey(Long id)
    {
        return commentsMapper.selectByPrimaryKey(id);
    }
    
    public int updateByPrimaryKeySelective(Comments record)
    {
        return commentsMapper.updateByPrimaryKeySelective(record);
    }
    
    public int updateByPrimaryKey(Comments record)
    {
        return commentsMapper.updateByPrimaryKey(record);
    }
}
