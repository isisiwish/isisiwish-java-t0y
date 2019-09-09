package top.cfish.spider.mapper;

import top.cfish.spider.domain.ImgMap;

/**
 * @author: isisiwish
 * @date: 2019/9/4
 * @time: 16:10
 */

public interface ImgMapMapper
{
    int deleteByPrimaryKey(Integer id);

    int insert(ImgMap record);

    int insertSelective(ImgMap record);

    ImgMap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImgMap record);

    int updateByPrimaryKey(ImgMap record);
}
