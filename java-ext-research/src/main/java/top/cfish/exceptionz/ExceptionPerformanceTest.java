package top.cfish.exceptionz;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: isisiwish
 * @date: 2019/7/14 0014
 * @time: 20:17
 */

@Slf4j
public class ExceptionPerformanceTest
{
    public static void testException(String[] array)
    {
        try
        {
            log.info("{}", JSON.toJSONString(array[0]));
        }
        catch (NullPointerException e)
        {
            log.info("array cannot be null");
        }
    }
    
    public static void testIf(String[] array)
    {
        if (array != null)
        {
            log.info("{}", JSON.toJSONString(array[0]));
        }
        else
        {
            log.info("array cannot be null");
        }
    }
    
    public static void main(String[] args) throws InterruptedException
    {
        Thread.sleep(2000);
        
        long start = System.nanoTime();
        testException(null);
        log.info("exception cost: {} nanoTime", System.nanoTime() - start);
    
        start = System.nanoTime();
        testIf(null);
        log.info("if cost: {} nanoTime", System.nanoTime() - start);
    }
}
