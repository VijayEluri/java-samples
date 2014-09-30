// Copyright(c) 2005 Isetan Co.,Ltd. and ATL Systems, Incorporated.
//
//
package sample.crypto.test;

import junit.framework.TestCase;

public class AESCipherTest extends TestCase {

    protected void setUp() throws Exception {
        System.setProperty(AESCipher.class.getName() + ".secretKey", "85988a6a420fd5fee9b3e4d1672445c4");
        super.setUp();
    }
    /*
     * 'sample.crypto.test.AESCryptUtil.getInstance()' のためのテスト・メソッド
     */
    public void testGetInstance() {
        assertNotNull(AESCipher.getInstance());
    }

    /*
     * 'sample.crypto.test.AESCryptUtil.encode(String)' のためのテスト・メソッド
     */
    public void testEncode() throws Exception{
        AESCipher cipher =  AESCipher.getInstance();
        String code =AESCipher.getInstance().encode("abcdefg");
        assertEquals("abcdefg", cipher.decode(code));
    }

    /*
     * 'sample.crypto.test.AESCryptUtil.decode(String)' のためのテスト・メソッド
     */
    public void testDecode() {
        assertEquals("abcdefg", AESCipher.getInstance().decode("10a8d8fe65736e97fa89e4f48340142b84XQ9uBEuAxqC5WiXVgB66Rg=="));
    }


}
