package jp.co.np.p2netex.sample.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import jp.co.np.p2netex.sample.AbstractFileTransfer;
import jp.co.np.p2netex.sample.FileTransfer;
import jp.co.np.p2netex.sample.TransferInfo;
import jp.co.np.p2netex.sample.TransferWorker;

import org.apache.commons.io.IOUtils;
import org.apache.commons.vfs.FileSystemException;
import org.apache.commons.vfs.FileSystemManager;
import org.apache.commons.vfs.VFS;
import org.apache.commons.vfs.impl.DefaultFileSystemManager;

public class FileTransferImpl extends AbstractFileTransfer implements
        FileTransfer {

    private TransferWorker retrieveWorker;

    private TransferWorker putWorker;

    public TransferWorker getRetrieveWorker() {
        return retrieveWorker;
    }

    public void setRetrieveWorker(TransferWorker retrieveWorker) {
        this.retrieveWorker = retrieveWorker;
    }

    public TransferWorker getPutWorker() {
        return putWorker;
    }

    public void setPutWorker(TransferWorker putWorker) {
        this.putWorker = putWorker;
    }

    @Override
    protected void internalTransfer(TransferInfo info) {
        FileSystemManager fsManager;
        try {
            fsManager = VFS.getManager();
        } catch (FileSystemException e) {
            throw new RuntimeException(e);
        }
        InputStream is = retrieveWorker.getInputStream(fsManager, info
                .getRetrievePath(), info.getRetrieveFilaName());
        OutputStream os = putWorker.getOutputstream(fsManager, info
                .getPutPath(), info.getPutFileName());
        try {
            IOUtils.copy(is, os);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(os);
        }
        retrieveWorker.close();
        putWorker.close();
        ((DefaultFileSystemManager) fsManager).close();

    }

}
