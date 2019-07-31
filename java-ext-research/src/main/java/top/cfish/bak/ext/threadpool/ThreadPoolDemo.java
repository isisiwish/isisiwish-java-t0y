package top.cfish.bak.ext.threadpool;

import lombok.extern.slf4j.Slf4j;
import top.cfish.bak.thread.returnValue.MyCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: isisiwish
 * @date: 2019/1/22
 * @time: 19:53
 */
@Slf4j
public class ThreadPoolDemo
{
    public static void main(String[] args)
    {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        Future<String> future = newCachedThreadPool.submit(new MyCallable());
        if (!future.isDone())
        {
            log.info("task has not finished");
        }
        try
        {
            log.info(future.get());
        }
        catch (InterruptedException e)
        {
            log.error("", e);
        }
        catch (ExecutionException e)
        {
            log.error("", e);
        }
        finally
        {
            newCachedThreadPool.shutdown();
        }
    }
}
