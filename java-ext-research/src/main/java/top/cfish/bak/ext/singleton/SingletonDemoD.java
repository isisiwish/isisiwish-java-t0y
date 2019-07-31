package top.cfish.bak.ext.singleton;

import top.cfish.thread.annotation.ThreadNotSafe;

/**
 * @author: isisiwish
 * @date: 2019/1/25
 * @time: 14:39
 * 懒汉模式 - 双重同步锁单例模式
 */

// 1、memory = allocate() 分配对象的内存空间
// 2、ctorInstance() 初始化对象
// 3、instance = memory 设置instance指向刚分配的内存

// JVM和cpu优化，发生了指令重排

// 1、memory = allocate() 分配对象的内存空间
// 3、instance = memory 设置instance指向刚分配的内存
// 2、ctorInstance() 初始化对象
@ThreadNotSafe
public class SingletonDemoD
{
    private SingletonDemoD()
    {
    
    }
    
    private static SingletonDemoD instance = null;
    
    public static SingletonDemoD getInstance()
    {
        if (instance == null)
        {
            // 双重检测机制
            synchronized (SingletonDemoD.class)
            {
                // 同步锁
                if (instance == null)
                {
                    instance = new SingletonDemoD();
                }
            }
        }
        return instance;
    }
}
