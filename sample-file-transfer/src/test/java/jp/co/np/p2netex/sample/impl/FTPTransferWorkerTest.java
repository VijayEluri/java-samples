package jp.co.np.p2netex.sample.impl;

import static org.junit.Assert.*;

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

@RunWith(Seasar2.class)
public class FTPTransferWorkerTest {

    private FileSystemManager fsManager;

    private TransferWorker ftpTransferWorker;

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
    public void test�t�@�C������������Ŏ擾����e�X�g() throws Exception {
        assertNotNull(this.ftpTransferWorker);
        assertNotNull(this.fsManager);

        // ��������
        OutputStream os = ftpTransferWorker.getOutputstream(fsManager,
                "/home/tfunato/", "ftptest.txt");
        assertNotNull(os);
        IOUtils.write("ftpwrite", os);
        IOUtils.closeQuietly(os);
        ftpTransferWorker.close();

        // �ǂݍ���
        InputStream is = ftpTransferWorker.getInputStream(fsManager,
                "/home/tfunato/", "ftptest.txt");
        assertNotNull(is);
        String result = IOUtils.toString(is);
        assertEquals("�z��ƈႢ�܂�", "ftpwrite", result);
        IOUtils.closeQuietly(is);
        ftpTransferWorker.close();
    }

}
