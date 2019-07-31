package top.cfish.bak.thread.returnValue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: isisiwish
 * @date: 2019/1/22
 * @time: 10:37
 */
@Slf4j
public class FutureThreadPoolDemo
{
    public static void main(String[] args) throws Exception
    {
        log.info("main thread start");
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());
        Thread.sleep(1000);
        String result = future.get();
        log.info("task return : " + result);
        executorService.shutdown();
        log.info("main thread end");
    }
}
