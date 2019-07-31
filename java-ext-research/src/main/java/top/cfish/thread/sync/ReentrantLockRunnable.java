package top.cfish.thread.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ReentrantLockRunnable implements Runnable
{
    private static ReentrantLock lock = new ReentrantLock(true);
    
    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                lock.lock();
                log.info(Thread.currentThread().getName() + " get lock");
                Thread.sleep(1000);
            }
            catch (Exception e)
            {
                log.error("", e);
            }
            finally
            {
                log.info(Thread.currentThread().getName() + " release lock");
                lock.unlock();
            }
        }
    }
}
