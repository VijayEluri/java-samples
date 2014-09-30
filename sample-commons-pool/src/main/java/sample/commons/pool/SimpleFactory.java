package sample.commons.pool;

import org.apache.commons.pool.PoolableObjectFactory;


/**
 * �v�[�������I�u�W�F�N�g�Ɋւ��鑀����s��
 */
public class SimpleFactory implements PoolableObjectFactory {
    /**
     * �v�[������I�u�W�F�N�g���쐬����
     * {@inheritDoc}
     */
    public Object makeObject() throws Exception {
        System.out.println("Call makeObject.");

        return new PooledObject();
    }

    /**
     * �I�u�W�F�N�g��j������
     * {@inheritDoc}
     */
    public void destroyObject(Object obj) throws Exception {
        System.out.println("Call destroyObject.");
    }

    /**
     * �I�u�W�F�N�g�����؂���
     * {@inheritDoc}
     */
    public boolean validateObject(Object obj) {
        // XXX �v�[�������I�u�W�F�N�g�ɑ΂��Č��؂���Ƃ��Ɏg���B

        return true;
    }

    /**
     * �I�u�W�F�N�g���ď���������
     * {@inheritDoc}
     */
    public void activateObject(Object obj) throws Exception {
        System.out.println("Call activateObject.");

    }

    /**
     * �I�u�W�F�N�g��񊈐����H����
     * {@inheritDoc}
     */
    public void passivateObject(Object obj) throws Exception {
        System.out.println("Call passivateObject.");
    }
}
