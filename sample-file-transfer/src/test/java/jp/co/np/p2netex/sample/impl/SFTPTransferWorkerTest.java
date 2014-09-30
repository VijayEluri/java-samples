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
public class SFTPTransferWorkerTest {

    private FileSystemManager fsManager;

    private TransferWorker sftpTransferWorker;

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
        assertNotNull(this.sftpTransferWorker);
        assertNotNull(this.fsManager);

        // ��������
        OutputStream os = sftpTransferWorker.getOutputstream(fsManager,
                "/home/tfunato/", "sftptest.txt");
        assertNotNull(os);
        IOUtils.write("write", os);
        IOUtils.closeQuietly(os);
        sftpTransferWorker.close();
        
        
        // �ǂݍ���
        InputStream is = sftpTransferWorker.getInputStream(fsManager,
                "/home/tfunato/", "sftptest.txt");
        assertNotNull(is);
        String result = IOUtils.toString(is);
        assertEquals("�z��ƈႢ�܂�", "write", result);
        IOUtils.closeQuietly(is);
        sftpTransferWorker.close();
    }
}
