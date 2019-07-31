package top.cfish.bak.reflect;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Robot {
    private String name;
    public void sayHi(String helloSentence){
        log.info(helloSentence + " " + name);
    }
    private String throwHello(String tag){
        return "Hello " + tag;
    }
    static {
        log.info("Hello Robot");
    }
}
