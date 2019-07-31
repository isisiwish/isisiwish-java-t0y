package top.cfish.bak.ext.concurrency.atomic;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import top.cfish.thread.annotation.ThreadSafe;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author: isisiwish
 * @date: 2019/1/24
 * @time: 11:24
 */
@Slf4j
@ThreadSafe
public class AtomicIntegerFieldUpdaterDemo
{
    @Getter
    public volatile int count = 100;
    
    private static AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterDemo> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterDemo.class, "count");
    
    public static void main(String[] args)
    {
        AtomicIntegerFieldUpdaterDemo demo = new AtomicIntegerFieldUpdaterDemo();
        
        if (updater.compareAndSet(demo, 100, 120))
        {
            log.info("update success 1, {}", demo.getCount());
        }
        
        if (updater.compareAndSet(demo, 100, 120))
        {
            log.info("update success 2, {}", demo.getCount());
        }
        else
        {
            log.info("update failed, {}", demo.getCount());
        }
    }
}
