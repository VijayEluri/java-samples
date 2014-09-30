package jp.co.np.p2netex.sample.impl;

import java.io.InputStream;
import java.io.OutputStream;

import jp.co.np.p2netex.sample.AbstractTransferWorker;
import jp.co.np.p2netex.sample.TransferWorker;

import org.apache.commons.vfs.FileContent;
import org.apache.commons.vfs.FileObject;
import org.apache.commons.vfs.FileSystemException;
import org.apache.commons.vfs.FileSystemManager;

/**
 * FTP—p‚ÌTransferWorker
 * 
 * @author 00522
 * 
 */
public class FTPTransferWorker extends AbstractTransferWorker implements
        TransferWorker {

    public InputStream getInputStream(FileSystemManager fsManager, String path,
            String filename) {
        try {
            FileObject file = super.resolveFile(fsManager, "ftp://" + username
                    + ":" + password + "@" + host + path + filename);
            FileContent content = file.getContent();
            return content.getInputStream();
        } catch (FileSystemException e) {
            throw new RuntimeException(e);
        }
    }

    public OutputStream getOutputstream(FileSystemManager fsManager,
            String path, String filename) {
        try {
            FileObject file = super.resolveFile(fsManager, "ftp://" + username
                    + ":" + password + "@" + host + path + filename);
            FileContent content = file.getContent();
            return content.getOutputStream();
        } catch (FileSystemException e) {
            throw new RuntimeException(e);
        }
    }

}
