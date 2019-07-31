package top.cfish.bak.thread.returnValue;

import lombok.extern.slf4j.Slf4j;
import top.cfish.utils.TimeUtil;

import java.util.concurrent.Callable;

/**
 * @author: isisiwish
 * @date: 2019/1/22
 * @time: 9:52
 */

@Slf4j
public class MyCallable implements Callable
{
    @Override
    public Object call() throws Exception
    {
        log.info(TimeUtil.getTimeNow() + " Callable call() start....");
        Thread.currentThread().sleep(5000);
        log.info(TimeUtil.getTimeNow() + " Callable call() end....");
        
        return "Callable return";
    }
}
