package top.cfish.bak.reflect;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectSample {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
        Class rc = Class.forName("com.interview.javabasic.reflect.Robot");
        Robot r = (Robot) rc.newInstance();
        log.info("Class name is " + rc.getName());
        Method getHello = rc.getDeclaredMethod("throwHello", String.class);
        getHello.setAccessible(true);
        Object str = getHello.invoke(r, "Bob");
        log.info("getHello result is " + str);
        Method sayHi = rc.getMethod("sayHi", String.class);
        sayHi.invoke(r, "Welcome");
        Field name = rc.getDeclaredField("name");
        name.setAccessible(true);
        name.set(r, "Alice");
        sayHi.invoke(r, "Welcome");
        log.info(System.getProperty("bak.ext.dirs"));
        log.info(System.getProperty("bak.class.path"));

    }
}
