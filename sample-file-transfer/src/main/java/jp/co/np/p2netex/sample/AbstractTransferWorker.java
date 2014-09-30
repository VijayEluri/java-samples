package jp.co.np.p2netex.sample;

import org.apache.commons.vfs.FileObject;
import org.apache.commons.vfs.FileSystemException;
import org.apache.commons.vfs.FileSystemManager;
import org.apache.commons.vfs.FileSystemOptions;

public abstract class AbstractTransferWorker implements TransferWorker {

    protected FileObject fileObject;

    protected String username;

    protected String password;

    protected String host;

    protected String port;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void close() {
        try {
            this.fileObject.close();
        } catch (FileSystemException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * FileObject‚ðŽæ“¾‚·‚é
     * 
     * @param fsManager
     * @param path
     * @return
     */
    protected FileObject resolveFile(FileSystemManager fsManager, String path) {
        return resolveFile(fsManager, null, path);
    }

    /**
     * FileObject‚ðŽæ“¾‚·‚é
     * 
     * @param fsManager
     * @param path
     * @param opts
     * @return
     */
    protected FileObject resolveFile(FileSystemManager fsManager, FileSystemOptions opts, String path) {
        try {
            FileObject file;
            if (opts == null ) {
                file = fsManager.resolveFile(path);
            } else {
                file = fsManager.resolveFile(path, opts);
            }
            this.fileObject = file;
            return file;
        } catch (FileSystemException e) {
            throw new RuntimeException(e);
        }
    }
}
