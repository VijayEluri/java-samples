package jp.co.np.p2netex.sample.thread.worker;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jp.co.np.p2netex.sample.thread.Processor;

/**
 * 通信経路 処理のリクエストをThreadに渡す
 * 
 * @author 00522
 * 
 */
public class Channel {
    private static Log log = LogFactory.getLog(Channel.class);

    private static final int MAX_REQUEST = 100;
    private final Processor[] requestQueue;
    private int tail; // 次にputRequestする場所
    private int head; // 次にtakeRequestする場所
    private int count; // Requestの数

    private final WorkerThread[] threadPool;

    public Channel(int threads) {
        this.requestQueue = new Processor[MAX_REQUEST];
        this.head = 0;
        this.tail = 0;
        this.count = 0;

        threadPool = new WorkerThread[threads];
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i] = new WorkerThread("CONVERT_WORKER-" + i, this);
        }
    }

    public void startWorkers() {
        log.debug("Workers start.");
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i].start();
        }
    }

    public synchronized void putRequest(Processor request) {
        log.debug("put request. " + request);
        while (count >= requestQueue.length) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        requestQueue[tail] = request;
        tail = (tail + 1) % requestQueue.length;
        count++;
        notifyAll();
    }

    public synchronized Processor takeRequest() {
        log.debug("takeRequest. ");
        while (count <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        Processor request = requestQueue[head];
        head = (head + 1) % requestQueue.length;
        count--;
        notifyAll();
        log.debug("request:" + request);
        return request;
    }

}
