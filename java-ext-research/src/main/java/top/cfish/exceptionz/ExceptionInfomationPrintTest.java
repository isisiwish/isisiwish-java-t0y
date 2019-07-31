package top.cfish.exceptionz;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: isisiwish
 * @date: 2019/7/14 0014
 * @time: 20:47
 */
@Slf4j
public class ExceptionInfomationPrintTest
{
    public static void main(String[] args)
    {
        // / by zero
        try
        {
            int i = 10 / 0;
            log.info("i = {}", i);
        }
        catch (ArithmeticException e)
        {
            log.error(e.getMessage());
        }
        
        // bak.lang.ArithmeticException: / by zero
        // try
        // {
        //     int i = 10 / 0;
        //     log.info("i = {}", i);
        // }
        // catch (ArithmeticException e)
        // {
        //     log.error(e);
        // }
        
        // bak.lang.ArithmeticException: / by zero
        // at top.cfish.bak.exceptionz.ExceptionInfomationPrint.main(ExceptionInfomationPrint.bak:28)
        // try
        // {
        //     int i = 10 / 0;
        //     log.info("i = {}", i);
        // }
        // catch (ArithmeticException e)
        // {
        //     log.error("", e);
        // }
        
        // 默认logback配置
        // 20:49:42.774 [main] ERROR t.c.j.t.ExceptionInfomationPrint -
        //     bak.lang.ArithmeticException: / by zero
        // at top.cfish.bak.exceptionz.ExceptionInfomationPrint.main(ExceptionInfomationPrint.bak:40) ~[classes/:na]
        // try
        // {
        //     int i = 10 / 0;
        //     log.info("i = {}", i);
        // }
        // catch (ArithmeticException e)
        // {
        //     log.error("", e);
        // }
    }
}
