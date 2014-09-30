package jp.co.np.p2netex.sample.thread.worker;

import jp.co.np.p2netex.sample.thread.Processor;

/**
 * 実際に処理を行うThread
 * @author 00522
 *
 */
public class WorkerThread extends Thread {
    private final Channel channel;

    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    public void run() {
        while (true) {
            Processor processor = channel.takeRequest();
            try {
                processor.execute();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
