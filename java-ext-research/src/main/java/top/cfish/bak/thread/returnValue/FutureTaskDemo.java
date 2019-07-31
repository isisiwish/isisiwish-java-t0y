package top.cfish.bak.thread.returnValue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: isisiwish
 * @date: 2019/1/22
 * @time: 10:04
 */

@Slf4j
public class FutureTaskDemo
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        log.info("main thread start");
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        Thread thread = new Thread(futureTask);
        thread.start();
        if (!futureTask.isDone())
        {
            log.info("task has not finished....");
        }
        log.info("task return : " + futureTask.get());
        log.info("main thread end");
    }
}
