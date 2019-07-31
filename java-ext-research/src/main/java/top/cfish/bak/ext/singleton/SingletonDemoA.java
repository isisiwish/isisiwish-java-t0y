package top.cfish.bak.ext.singleton;


import top.cfish.thread.annotation.ThreadSafe;

/**
 * @author: isisiwish
 * @date: 2019/1/25
 * @time: 14:28
 * 饿汉模式 - 单例实例在类装载时进行创建
 */
@ThreadSafe
public class SingletonDemoA
{
    // 私有构造函数
    private SingletonDemoA()
    {
    
    }
    
    // 单例对象
    private static SingletonDemoA instance = new SingletonDemoA();
    
    // 静态工厂方法
    public static SingletonDemoA getInstance()
    {
        return instance;
    }
}
