package jp.co.np.p2netex.sample.thread.worker;

import jp.co.np.p2netex.sample.thread.Processor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Actionから使うクラス
 * 
 * @author 00522
 * 
 */
public class ThreadWorkerInvoker {
    private static Log log = LogFactory.getLog(ThreadWorkerInvoker.class);
    private static Channel channel;
    private int totalWorker = 5; // Workerの数

    /**
     * 初期化
     */
    public void init() {
        log.debug("Invoker init");
        channel = new Channel(totalWorker); // ワーカースレッドの数
        channel.startWorkers(); // Workerの起動
    }

    /**
     * Workerの数を設定する
     * @param totalWorker
     */
    public void setTotalWorker(int totalWorker) {
        this.totalWorker = totalWorker;
    }

    /**
     * 処理の起動
     */
    public void execute(Processor processor) {
        log.debug("Invoker execute:" + processor);
        channel.putRequest(processor);
    }
}
