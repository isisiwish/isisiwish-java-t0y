package top.cfish.bak.ext.thread.extra;

import lombok.extern.slf4j.Slf4j;
import top.cfish.bak.thread.returnValue.MyCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        Future<String> future = newCachedThreadPool.submit(new MyCallable());
        if(!future.isDone()){
            log.info("task has not finished, please wait!");
        }
        try {
            log.info(future.get());
        } catch (InterruptedException e) {
            log.error("", e);
        } catch (ExecutionException e) {
            log.error("", e);
        } finally {
            newCachedThreadPool.shutdown();
        }
    }
}
