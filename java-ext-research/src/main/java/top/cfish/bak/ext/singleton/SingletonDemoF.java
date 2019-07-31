package top.cfish.bak.ext.singleton;


import top.cfish.thread.annotation.ThreadSafe;

/**
 * @author: isisiwish
 * @date: 2019/1/25
 * @time: 14:52
 * 懒汉模式 - 双重同步锁单例模式
 */
@ThreadSafe
public class SingletonDemoF
{
    private SingletonDemoF()
    {
    
    }
    
    // 单例对象volatile + 双重检测机制 -> 禁止指令重排
    private volatile static SingletonDemoF instance = null;
    
    public static SingletonDemoF getInstance()
    {
        if (instance == null)
        {
            // 双重检测机制
            synchronized (SingletonDemoF.class)
            {
                // 同步锁
                if (instance == null)
                {
                    instance = new SingletonDemoF();
                }
            }
        }
        return instance;
    }
}
