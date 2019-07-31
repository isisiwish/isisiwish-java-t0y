package top.cfish.utils;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.junit.Test;

/**
 * @author: isisiwish
 * @date: 2019/1/22
 * @time: 9:59
 */

public class TimeUtil
{
    private static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    public static String getTimeNow()
    {
        DateTime time = new DateTime();
        String s = time.toString(TIME_FORMAT);
        return s;
    }
}
