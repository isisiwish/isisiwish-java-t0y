package top.cfish.bak.ext.singleton;


import top.cfish.thread.annotation.ThreadSafe;

/**
 * @author: isisiwish
 * @date: 2019/1/25
 * @time: 15:15
 * 懒汉模式 - 单例实例在类装载时进行创建
 */
@ThreadSafe
public class SingletonDemoG
{
    private SingletonDemoG()
    {

    }

    private static SingletonDemoG instance = null;

    static
    {
        instance = new SingletonDemoG();
    }

    public static SingletonDemoG getInstance()
    {
        return instance;
    }
}
