package top.cfish.bak.jvm.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InternDifference {
    public static void main(String[] args) {
        String s = new String("a");
        s.intern();
        String s2 = "a";
        log.info("rs: {}", s == s2);

        String s3 = new String("a") + new String("a");
        s3.intern();
        String s4 = "aa";
        log.info("rs: {}", s3 == s4);
    }
}
