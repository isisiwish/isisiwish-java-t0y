package top.cfish.spider.mapper;

import top.cfish.spider.domain.Comments;

/**
 * @author: isisiwish
 * @date: 2019/9/4
 * @time: 14:47
 */

public interface CommentsMapper
{
    int deleteByPrimaryKey(Long id);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKey(Comments record);
}
