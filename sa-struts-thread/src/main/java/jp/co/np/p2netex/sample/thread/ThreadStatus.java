package jp.co.np.p2netex.sample.thread;

import java.io.Serializable;
import java.util.Date;

/**
 * スレッドの実行状況を表すクラス
 * 
 * @author 00522
 * 
 */
public class ThreadStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    private volatile Date startDate;
    public volatile String name;
    private volatile int processCount;
    private volatile boolean active;

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    void toActive() {
        this.active = true;
    }

    void toLeisure() {
        this.active = false;
    }

    public int getProcessCount() {
        return processCount;
    }

    public void setProcessCount(int count) {
        this.processCount = count;
    }
    
    public Date getStartDate() {
        return startDate;
    }
    
    public void reset() {
        this.processCount = 0;
        this.startDate = null;
    }
}