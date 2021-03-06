package jp.co.np.p2netex.sample;

import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.vfs.FileSystemManager;

public interface TransferWorker {

    /**
     * Outputstreamを取得する
     * @param manager
     * @param path
     * @param filename
     */
    OutputStream getOutputstream(FileSystemManager manager, String path, String filename);

    /**
     * InputStreamを取得する
     * @param manager
     * @param path
     * @param filename
     * @return
     */
    InputStream getInputStream(FileSystemManager manager, String path, String filename);

    /**
     * 片づけをする
     */
    void close();
}
