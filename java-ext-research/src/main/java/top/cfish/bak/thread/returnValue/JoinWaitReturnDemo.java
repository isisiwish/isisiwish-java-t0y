package top.cfish.bak.thread.returnValue;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: isisiwish
 * @date: 2019/1/22
 * @time: 19:44
 */

@Slf4j
public class JoinWaitReturnDemo implements Runnable
{
    @Getter
    private String value;
    
    @Override
    public void run()
    {
        try
        {
            Thread.currentThread().sleep(5000);
        }
        catch (InterruptedException e)
        {
            log.error("", e);
        }
        value = "return value";
    }
    
    public static void main(String[] args) throws InterruptedException
    {
        JoinWaitReturnDemo obj = new JoinWaitReturnDemo();
        Thread thread = new Thread(obj);
        thread.start();
        
        thread.join();
        log.info(obj.getValue());
    }
}
