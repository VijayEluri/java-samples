package jp.co.np.p2netex.sample.impl;

import java.io.InputStream;
import java.io.OutputStream;

import jp.co.np.p2netex.sample.AbstractTransferWorker;
import jp.co.np.p2netex.sample.TransferWorker;

import org.apache.commons.vfs.FileContent;
import org.apache.commons.vfs.FileObject;
import org.apache.commons.vfs.FileSystemException;
import org.apache.commons.vfs.FileSystemManager;
import org.apache.commons.vfs.FileSystemOptions;
import org.apache.commons.vfs.provider.sftp.SftpFileSystemConfigBuilder;

/**
 * SFTP用のTransferWorker
 * 
 * @author 00522
 * 
 */
public class SFTPTransferWorker extends AbstractTransferWorker implements
        TransferWorker {

    public InputStream getInputStream(FileSystemManager fsManager, String path,
            String filename) {
        try {
            FileSystemOptions opts = new FileSystemOptions();
            SftpFileSystemConfigBuilder builder = SftpFileSystemConfigBuilder.getInstance();
            builder.setStrictHostKeyChecking(opts,"no"); // ホストキーを確認しない
            FileObject file = super.resolveFile(fsManager, opts, "sftp://" + username
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
            FileSystemOptions opts = new FileSystemOptions();
            SftpFileSystemConfigBuilder builder = SftpFileSystemConfigBuilder.getInstance();
            builder.setStrictHostKeyChecking(opts,"no"); // ホストキーを確認しない
            FileObject file = super.resolveFile(fsManager, opts, "sftp://" + username
                    + ":" + password + "@" + host + path + filename);
            FileContent content = file.getContent();
            return content.getOutputStream();
        } catch (FileSystemException e) {
            throw new RuntimeException(e);
        }
    }

}
