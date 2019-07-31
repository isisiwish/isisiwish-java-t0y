package top.cfish.bak.ext.concurrency.atomic;

import lombok.extern.slf4j.Slf4j;
import top.cfish.thread.annotation.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: isisiwish
 * @date: 2019/1/24
 * @time: 11:23
 */
@Slf4j
@ThreadSafe
public class AtomicReferenceDemo
{
    private static AtomicReference<Integer> count = new AtomicReference<>(0);
    
    public static void main(String[] args)
    {
        count.compareAndSet(0, 2);
        count.compareAndSet(0, 1);
        count.compareAndSet(1, 3);
        count.compareAndSet(2, 4);
        count.compareAndSet(3, 5);
        log.info("count:{}", count.get());
    }
}
