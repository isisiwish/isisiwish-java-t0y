package top.cfish.bak.ext.singleton;


import top.cfish.thread.annotation.ThreadSafe;

/**
 * @author: isisiwish
 * @date: 2019/1/25
 * @time: 14:37
 * 懒汉模式 - 单例实例在第一次使用时进行创建（同步方法）
 */
@ThreadSafe
public class SingletonDemoC
{
    private SingletonDemoC()
    {
    
    }
    
    private static SingletonDemoC instance = null;
    
    public static synchronized SingletonDemoC getInstance()
    {
        if (instance == null)
        {
            instance = new SingletonDemoC();
        }
        return instance;
    }
}
