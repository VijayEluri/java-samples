package jp.co.np.p2netex.sample.impl;

import java.io.InputStream;
import java.io.OutputStream;

import jp.co.np.p2netex.sample.TransferWorker;

import org.apache.commons.io.IOUtils;
import org.apache.commons.vfs.FileSystemException;
import org.apache.commons.vfs.FileSystemManager;
import org.apache.commons.vfs.VFS;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.framework.unit.Seasar2;
import static org.junit.Assert.*;

@RunWith(Seasar2.class)
public class LocalFileTransferWorkerTest {
    private FileSystemManager fsManager;

    private TransferWorker localFileTransferWorker;

    @Before
    public void setUp() {
        try {
            fsManager = VFS.getManager();
        } catch (FileSystemException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testファイルを書き込んで取得するテスト() throws Exception {
        String path = System.getProperty("java.io.tmpdir");
        assertNotNull(this.localFileTransferWorker);
        assertNotNull(this.fsManager);

        // 書き込む
        OutputStream os = localFileTransferWorker.getOutputstream(fsManager,
                path, "localfiletest.txt");
        assertNotNull(os);
        IOUtils.write("localfilewrite", os);
        IOUtils.closeQuietly(os);
        localFileTransferWorker.close();

        // 読み込む
        InputStream is = localFileTransferWorker.getInputStream(fsManager,
                path, "localfiletest.txt");
        assertNotNull(is);
        String result = IOUtils.toString(is);
        assertEquals("想定と違います", "localfilewrite", result);
        IOUtils.closeQuietly(is);
        localFileTransferWorker.close();
    }
}
