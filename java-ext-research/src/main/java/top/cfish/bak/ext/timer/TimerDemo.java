package top.cfish.bak.ext.timer;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: isisiwish
 * @date: 2019/1/24
 * @time: 19:25
 */
@Slf4j
public class TimerDemo
{
    public static void main(String[] args)
    {
        Timer timer = new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                log.warn("timer run");
            }
        }, new Date(), 5 * 1000);
    }
}
