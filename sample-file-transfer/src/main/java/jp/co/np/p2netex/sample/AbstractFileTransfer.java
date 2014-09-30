package jp.co.np.p2netex.sample;

public abstract class AbstractFileTransfer implements FileTransfer {

    public final void transfer(TransferInfo info) {
        internalTransfer(info);
    }

    /**
     * サブクラスへの委譲メソッド
     */
    protected abstract void internalTransfer(TransferInfo info);

}
