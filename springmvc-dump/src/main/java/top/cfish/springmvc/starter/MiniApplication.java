package top.cfish.springmvc.starter;


import top.cfish.springmvc.beans.BeanFactory;
import top.cfish.springmvc.core.ClassScanner;
import top.cfish.springmvc.web.handler.HandlerManager;
import top.cfish.springmvc.web.server.TomcatServer;

import java.util.List;

public class MiniApplication
{
    public static void run(Class<?> cls, String[] args)
    {
        System.out.println("Hello mini-spring!");
        TomcatServer tomcatServer = new TomcatServer(args);
        try
        {
            tomcatServer.startServer();
            List<Class<?>> classList = ClassScanner.scanClasses(cls.getPackage().getName());
            BeanFactory.initBean(classList);
            HandlerManager.resolveMappingHandler(classList);
            classList.forEach(it->System.out.println(it.getName()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
