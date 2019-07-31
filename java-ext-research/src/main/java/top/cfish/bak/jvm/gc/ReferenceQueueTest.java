package top.cfish.bak.jvm.gc;

import lombok.extern.slf4j.Slf4j;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@Slf4j
public class ReferenceQueueTest {
    private static ReferenceQueue<NormalObject> rq = new ReferenceQueue<NormalObject>();

    private static void checkQueue(){
        Reference<NormalObject> ref = null;
        while ((ref = (Reference<NormalObject>)rq.poll()) != null){
            if (ref != null){
                log.info("In queue: " + ((NormalObjectWeakReference)(ref)).name);
                log.info("reference object:" + ref.get());
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<WeakReference<NormalObject>> weakList = new ArrayList<WeakReference<NormalObject>>();
        for (int i =0; i < 3 ; i++){
            weakList.add(new NormalObjectWeakReference(new NormalObject("Weak " + i),rq));
            log.info("Created weak:" + weakList.get(i));
        }
        log.info("first time");
        checkQueue();
        System.gc();
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e){
            log.error("", e);
        }
        log.info("second time");
        checkQueue();
    }
}
