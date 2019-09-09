package top.cfish.spider.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import top.cfish.spider.mapper.ImgMapMapper;
import top.cfish.spider.domain.ImgMap;

/**
 * @author: isisiwish
 * @date: 2019/9/4
 * @time: 16:10
 */

@Slf4j
@Service
public class ImgMapService
{
    @Resource
    private ImgMapMapper imgMapMapper;
    
    public int deleteByPrimaryKey(Integer id)
    {
        return imgMapMapper.deleteByPrimaryKey(id);
    }
    
    public int insert(ImgMap record)
    {
        return imgMapMapper.insert(record);
    }
    
    public int insertSelective(ImgMap record)
    {
        int result = 0;
        try
        {
            result = imgMapMapper.insertSelective(record);
        }
        catch (DuplicateKeyException e)
        {
            log.debug("DuplicateKey: {}, imgUrl: {}", record.getImgMd5(), record.getOriginalImgUrl());
        }
        
        return result;
    }
    
    public ImgMap selectByPrimaryKey(Integer id)
    {
        return imgMapMapper.selectByPrimaryKey(id);
    }
    
    public int updateByPrimaryKeySelective(ImgMap record)
    {
        return imgMapMapper.updateByPrimaryKeySelective(record);
    }
    
    public int updateByPrimaryKey(ImgMap record)
    {
        return imgMapMapper.updateByPrimaryKey(record);
    }
}
