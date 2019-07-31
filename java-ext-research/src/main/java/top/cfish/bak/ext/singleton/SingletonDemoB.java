package top.cfish.bak.ext.singleton;


import top.cfish.thread.annotation.ThreadNotSafe;

/**
 * @author: isisiwish
 * @date: 2019/1/25
 * @time: 14:32
 * 懒汉模式 - 单例实例在第一次使用时进行创建
 */
@ThreadNotSafe
public class SingletonDemoB
{
    private SingletonDemoB()
    {
    
    }
    
    private static SingletonDemoB instance = null;
    
    public static SingletonDemoB getInstance()
    {
        // 非线程安全
        if (instance == null)
        {
            instance = new SingletonDemoB();
        }
        return instance;
    }
}
