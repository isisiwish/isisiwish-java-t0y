package top.cfish.bak.reflect;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClassLoaderChecker {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader m = new MyClassLoader("/Users/baidu/Desktop/", "myClassLoader");
        Class c = m.loadClass("Wali");
        log.info("{}", c.getClassLoader());
        log.info("{}", c.getClassLoader().getParent());
        log.info("{}", c.getClassLoader().getParent().getParent());
        log.info("{}", c.getClassLoader().getParent().getParent().getParent());
        c.newInstance();
    }
}
