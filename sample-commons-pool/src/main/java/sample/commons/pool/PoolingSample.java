package sample.commons.pool;

import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.impl.GenericObjectPoolFactory;


/**
 * プールを扱うクラス
 */
public class PoolingSample {
    private ObjectPool pool;

    public PoolingSample() {
        GenericObjectPoolFactory factory = new GenericObjectPoolFactory(new SimpleFactory());
        pool = factory.createPool();
    }

    /**
     * プールから取り出す
     * @return プールされているオブジェト
     */
    PooledObject borrowObject() {
        try {
            return (PooledObject) pool.borrowObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * プールに返却する
     * @param obj
     */
    void returnObject(Object obj) {
        try {
            pool.returnObject(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * プールのクリア
     */
    void clear() {
        try {
            pool.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * プールのクローズ
     */
    void close() {
        try {
            pool.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
