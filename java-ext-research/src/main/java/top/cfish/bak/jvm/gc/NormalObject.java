package top.cfish.bak.jvm.gc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NormalObject {
    public String name;
    public NormalObject(String name){
        this.name = name;
    }

    @Override
    protected void finalize(){
        log.info("Finalizing obj " + name);
    }

}
