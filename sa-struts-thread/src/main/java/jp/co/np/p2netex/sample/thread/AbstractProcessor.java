package jp.co.np.p2netex.sample.thread;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Processorの抽象クラス
 * 
 * @author 00522
 * 
 */
public abstract class AbstractProcessor implements Processor {

    private static Log log = LogFactory.getLog(AbstractProcessor.class);
    protected ThreadStatus status;

    public AbstractProcessor(ThreadStatus status) {
        this.status = status;
    }

    public void execute() throws Exception {
        log.debug("Processor execute!" + this);
        synchronized (this) {
            if (status.isActive()) {
                log.debug("process is active.");
                return;
            } else {
                log.debug("process run.");
                status.toActive();
            }
        }
        beforeExecute();
        status.setStartDate(new Date());
        try {
            internalExecute();
        } catch (Exception e) {
            throw e;
        } finally {
            status.toLeisure();
        }
        afterExeute();
    }

    /**
     * 実際の実行処理
     */
    protected abstract void internalExecute();

    /*
     * 前処理 必要があればオーライドしてください
     * 
     * @see jp.co.np.p2netex.sample.thread.Processor#beforeExecute()
     */
    public void beforeExecute() {
        // no-op
    }

    /*
     * 後処理 必要があればオーバーライドしてください
     * 
     * @see jp.co.np.p2netex.sample.thread.Processor#afterExeute()
     */
    public void afterExeute() {
        // no-op
    }
}
