package top.cfish.pojo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * author: isisiwish
 * date: 2018/4/16 0016
 * time: 11:04
 */
@Slf4j
@Component
public class ObjB implements IObj
{
    @Override
    public void printMsg(String msg)
    {
        log.info("{} - msgB:{}",this.getClass().getName(), msg);
    }
}

