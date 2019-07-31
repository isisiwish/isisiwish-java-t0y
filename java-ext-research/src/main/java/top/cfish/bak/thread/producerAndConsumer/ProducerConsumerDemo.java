package top.cfish.bak.thread.producerAndConsumer;

/**
 * @author: isisiwish
 * @date: 2019/1/23
 * @time: 11:45
 */
public class ProducerConsumerDemo
{
    public static void main(String[] args)
    {
        BlockingQueueLite<String> queue = new BlockingQueueLite<>(10);
        new Producer(queue).start();
        new Consumer(queue).start();
    }
}
