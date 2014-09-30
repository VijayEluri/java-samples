/**
 * 
 */
package jp.co.np.p2netex.sample.thread;

/**
 * 処理を行うインターフェース
 * @author 00522
 *
 */
public interface Processor {

    /**
     * 前処理
     */
    void beforeExecute();
    /**
     * 処理を実行する
     */
    void execute() throws Exception;
    
    /**
     * 後処理
     */
    void afterExeute();
}
