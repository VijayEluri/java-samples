package sample.commons.pool;

import org.apache.commons.pool.PoolableObjectFactory;


/**
 * プールされるオブジェクトに関する操作を行う
 */
public class SimpleFactory implements PoolableObjectFactory {
    /**
     * プールするオブジェクトを作成する
     * {@inheritDoc}
     */
    public Object makeObject() throws Exception {
        System.out.println("Call makeObject.");

        return new PooledObject();
    }

    /**
     * オブジェクトを破棄する
     * {@inheritDoc}
     */
    public void destroyObject(Object obj) throws Exception {
        System.out.println("Call destroyObject.");
    }

    /**
     * オブジェクトを検証する
     * {@inheritDoc}
     */
    public boolean validateObject(Object obj) {
        // XXX プールされるオブジェクトに対して検証するときに使う。

        return true;
    }

    /**
     * オブジェクトを再初期化する
     * {@inheritDoc}
     */
    public void activateObject(Object obj) throws Exception {
        System.out.println("Call activateObject.");

    }

    /**
     * オブジェクトを非活性化？する
     * {@inheritDoc}
     */
    public void passivateObject(Object obj) throws Exception {
        System.out.println("Call passivateObject.");
    }
}
