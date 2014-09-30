package jp.co.np.p2netex.sample;

public abstract class AbstractFileTransfer implements FileTransfer {

    public final void transfer(TransferInfo info) {
        internalTransfer(info);
    }

    /**
     * �T�u�N���X�ւ̈Ϗ����\�b�h
     */
    protected abstract void internalTransfer(TransferInfo info);

}
