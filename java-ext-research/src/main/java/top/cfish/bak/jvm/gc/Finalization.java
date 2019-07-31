package top.cfish.bak.jvm.gc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Finalization
{
    public static Finalization finalization;
    
    @Override
    protected void finalize()
    {
        log.info("Finalized");
        finalization = this;
    }
    
    public static void main(String[] args)
    {
        Finalization f = new Finalization();
        log.info("First print: " + f);
        f = null;
        System.gc();
        try
        {// 休息一段时间，让上面的垃圾回收线程执行完成
            Thread.currentThread().sleep(1000);
        }
        catch (InterruptedException e)
        {
            log.error("", e);
        }
        log.info("Second print: " + f);
        log.info("{}", f.finalization);
    }
}
