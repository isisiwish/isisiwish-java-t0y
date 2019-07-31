package top.cfish.bak.bytecode;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: isisiwish
 * @date: 2019/3/6
 * @time: 20:50
 */

@Slf4j
public class Main
{
    public static void main(String[] args)
    {
        Integer i1 = new Integer(10);
        Integer i2 = new Integer(10);
        Integer i3 = 1200;
        Integer i4 = 1200;
        if (i1 == i2)
        {
            log.info("true");
        }
        else
        {
            log.info("false");
        }
    
        if (i3 == i4)
        {
            log.info("true");
        }
        else
        {
            log.info("false");
        }
    }
}
