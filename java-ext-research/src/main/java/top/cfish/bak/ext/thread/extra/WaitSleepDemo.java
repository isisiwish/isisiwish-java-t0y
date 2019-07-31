package top.cfish.bak.ext.thread.extra;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WaitSleepDemo {
    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("thread A is waiting to get lock");
                synchronized (lock){
                    try {
                        log.info("thread A get lock");
                        Thread.sleep(20);
                        log.info("thread A do wait method");
                        lock.wait();
                        log.info("thread A is done");
                    } catch (InterruptedException e){
                        log.error("", e);
                    }
                }
            }
        }).start();
        try{
            Thread.sleep(10);
        } catch (InterruptedException e){
            log.error("", e);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("thread B is waiting to get lock");
                synchronized (lock){
                    try {
                        log.info("thread B get lock");
                        log.info("thread B is sleeping 10 ms");
                        Thread.sleep(10);
                        lock.notifyAll();
                        Thread.yield();
                        Thread.sleep(2000);
                        log.info("thread B is done");
                    } catch (InterruptedException e){
                        log.error("", e);
                    }
                }
            }
        }).start();

    }
}
