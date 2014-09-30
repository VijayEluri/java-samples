package jp.co.np.p2netex.sample.thread.impl;

import jp.co.np.p2netex.sample.thread.AbstractProcessor;
import jp.co.np.p2netex.sample.thread.ThreadStatus;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * サンプルのProcessor
 * 
 * @author 00522
 * 
 */
public class SampleProcessor extends AbstractProcessor {
    private static Log log = LogFactory.getLog(SampleProcessor.class);

    public SampleProcessor(ThreadStatus status) {
        super(status);
    }

    /*
     * (non-Javadoc)
     * 
     * @see jp.co.np.p2netex.sample.thread.AbstractProcessor#internalExecute()
     * ここだけ実装する
     */
    @Override
    public void internalExecute() {
        log.debug("internalExecute. :" + this.status);
        for (int i = 0; i < 60; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("status update.");
            this.status.setProcessCount(i); // ステータスを更新
        }
    }


}
