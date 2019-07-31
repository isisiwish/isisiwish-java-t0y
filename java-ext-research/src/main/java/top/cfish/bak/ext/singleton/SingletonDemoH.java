package top.cfish.bak.ext.singleton;


import top.cfish.thread.annotation.ThreadSafe;

/**
 * @author: isisiwish
 * @date: 2019/1/25
 * @time: 15:35
 * 枚举模式
 */
@ThreadSafe
public class SingletonDemoH
{
    private SingletonDemoH()
    {

    }

    public static SingletonDemoH getInstance()
    {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton
    {
        INSTANCE;

        private SingletonDemoH singleton;

        Singleton()
        {
            singleton = new SingletonDemoH();
        }

        public SingletonDemoH getInstance()
        {
            return singleton;
        }
    }
}
