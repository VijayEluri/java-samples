package jp.co.np.p2netex.sample;

import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.vfs.FileSystemManager;

public interface TransferWorker {

    /**
     * Outputstream‚ðŽæ“¾‚·‚é
     * @param manager
     * @param path
     * @param filename
     */
    OutputStream getOutputstream(FileSystemManager manager, String path, String filename);

    /**
     * InputStream‚ðŽæ“¾‚·‚é
     * @param manager
     * @param path
     * @param filename
     * @return
     */
    InputStream getInputStream(FileSystemManager manager, String path, String filename);

    /**
     * •Ð‚Ã‚¯‚ð‚·‚é
     */
    void close();
}
