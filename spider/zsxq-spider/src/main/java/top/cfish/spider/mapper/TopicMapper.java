package top.cfish.spider.mapper;

import top.cfish.spider.domain.Topic;

/**
 * @author: isisiwish
 * @date: 2019/9/4
 * @time: 14:47
 */

public interface TopicMapper
{
    int deleteByPrimaryKey(Long id);

    int insert(Topic record);

    int insertSelective(Topic record);

    Topic selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKey(Topic record);
}
