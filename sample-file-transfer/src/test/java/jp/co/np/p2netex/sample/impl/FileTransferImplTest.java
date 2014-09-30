package jp.co.np.p2netex.sample.impl;

import jp.co.np.p2netex.sample.FileTransfer;
import jp.co.np.p2netex.sample.TransferInfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.framework.unit.Seasar2;
import static org.junit.Assert.*;

@RunWith(Seasar2.class)
public class FileTransferImplTest {

    private FileTransfer fileTransfer;
    
    @Test
    public void testファイルの転送のテスト() throws Exception {
       assertNotNull(fileTransfer);
       TransferInfo info = new TransferInfo();
       info.setRetrieveFilaName("ftptest.txt");
       info.setRetrievePath("/home/tfunato/");
       info.setPutFileName("sftp.txt");
       info.setPutPath("/home/tfunato/put/");
 
       fileTransfer.transfer(info);
    }

}
