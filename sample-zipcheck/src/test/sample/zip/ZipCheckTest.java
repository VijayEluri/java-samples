// Copyright(c) 2005 Isetan Co.,Ltd. and ATL Systems, Incorporated.
//
//
package sample.zip;

import junit.framework.TestCase;

public class ZipCheckTest extends TestCase {

    /*
     * 'sample.zip.ZipCheck.checkZipFile(String)' のためのテスト・メソッド
     */
    public void testZipCheck() throws Exception {
        assertTrue(ZipCheck.checkZipFile("test.zip"));
    }
}
