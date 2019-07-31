package top.cfish.bak.thread.returnValue;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: isisiwish
 * @date: 2019/1/22
 * @time: 19:47
 */

@Slf4j
public class CycleWaitReturnDemo implements Runnable
{
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
        CycleWaitReturnDemo cw = new CycleWaitReturnDemo();
        Thread t = new Thread(cw);
        t.start();
        
        while (cw.value == null)
        {
            Thread.sleep(100);
        }
        log.info("value : " + cw.value);
    }
}
