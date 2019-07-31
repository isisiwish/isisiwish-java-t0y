package top.cfish.bak.jvm.gc;

import lombok.extern.slf4j.Slf4j;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

@Slf4j
public class NormalObjectWeakReference extends WeakReference<NormalObject> {
    public String name;

    public NormalObjectWeakReference(NormalObject normalObject, ReferenceQueue<NormalObject> rq) {
        super(normalObject, rq);
        this.name = normalObject.name;
    }
    @Override
    protected void finalize(){
        log.info("Finalizing NormalObjectWeakReference " + name);
    }
}
