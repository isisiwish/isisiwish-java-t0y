package top.cfish.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import top.cfish.pojo.IObj;
import top.cfish.pojo.ObjEnum;

import java.util.Map;

/**
 * 通过pid直接找到具体实现
 */
@Component
@Slf4j
public class ApplicationContextHelper implements ApplicationContextAware
{
    private ApplicationContext applicationContext;
    private Map<Integer, String> objServiceMap = ObjEnum.getObjBeanMap();
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        this.applicationContext = applicationContext;
    }
    
    public IObj getServiceByPid(Integer pId)
    {
        IObj objService = null;
        try
        {
            objService = (IObj) applicationContext.getBean(objServiceMap.get(pId));
        }
        catch (Exception e)
        {
            log.error("根据pId获取现类发生错误，pId:{}，errorInfo:{}", pId, e);
        }
        return objService;
    }
}
