package sample.commons.pool;

import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.impl.GenericObjectPoolFactory;


/**
 * �v�[���������N���X
 */
public class PoolingSample {
    private ObjectPool pool;

    public PoolingSample() {
        GenericObjectPoolFactory factory = new GenericObjectPoolFactory(new SimpleFactory());
        pool = factory.createPool();
    }

    /**
     * �v�[��������o��
     * @return �v�[������Ă���I�u�W�F�g
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
     * �v�[���ɕԋp����
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
     * �v�[���̃N���A
     */
    void clear() {
        try {
            pool.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * �v�[���̃N���[�Y
     */
    void close() {
        try {
            pool.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
