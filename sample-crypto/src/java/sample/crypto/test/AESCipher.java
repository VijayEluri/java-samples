// Copyright(c) 2005 Isetan Co.,Ltd. and ATL Systems, Incorporated.
//
//
package sample.crypto.test;

import org.apache.commons.codec.binary.Base64;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 * AES 暗号化
 * モード CBC
 * パディング PKCS5Padding
 * での暗号化のテスト
 *
 * @version $Revision$
 * @author $Author$
 */
public class AESCipher {
    static Cipher cipher = null;
    static String version = "10";
    static final String codeMethod = "AES/CBC/PKCS5Padding";
    private static AESCipher util = null;

    private AESCipher() {}

    public static AESCipher getInstance() {
        if (util == null) {
            util = new AESCipher();
        }

        return util;
    }

    private Cipher getCipher() {
        if (cipher == null) {
            try {
                cipher = Cipher.getInstance(codeMethod);
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalArgumentException("Cant' find Algorithm.:" + codeMethod);
            } catch (NoSuchPaddingException e) {
                throw new IllegalArgumentException("Cant' find Padding.:" + codeMethod);
            }
        }

        return cipher;
    }

    /**
     * AES/CBC/PKCS5Paddingでエンコードする.
     * @param str
     * @return
     * @throws Exception
     */
    public String encode(String str) {
        byte[] iv;

        try {
            iv = SecureRandom.getInstance("SHA1PRNG").generateSeed(16);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Can't encode :" + e);
        }

        return version + asHex(iv) +
        new String(Base64.encodeBase64(encryptCipher(getKey(), iv, str.getBytes())));
    }

    /**
     * AES/CBC/PKCS5Paddingでデコードする.
     * @param str
     * @throws Exception
     */
    public String decode(String str) {
        if (str == null) {
            return null;
        } else if (str.length() < 2) {
            throw new IllegalArgumentException("invalid data.");
        }

        // バージョンのチェック
        String value = str.substring(0, 2);

        if (!version.equals(value)) {
            throw new RuntimeException("invalid Version current version:" + version +
                " evaluate version:" + value);
        }

        return new String(decryptCipher(getKey(), asByteArray(str.substring(2, 34)),
                Base64.decodeBase64(str.substring(34).getBytes())));
    }

    byte[] encryptCipher(byte[] key, byte[] iv, byte[] data) {
        try {
            getCipher().init(Cipher.ENCRYPT_MODE, new SecretKeySpec(getKey(), "AES"),
                new IvParameterSpec(iv));

            return getCipher().doFinal(data);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException("Invalid Key:" + e.getMessage());
        } catch (InvalidAlgorithmParameterException e) {
            throw new IllegalArgumentException("Invalid Algorithm:" + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Can't encypt:" + e);
        }
    }

    byte[] decryptCipher(byte[] key, byte[] iv, byte[] data) {
        try {
            Cipher cipher = getCipher();
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));

            return getCipher().doFinal(data);
        } catch (Exception e) {
            throw new RuntimeException("Can't decode :" + e);
        }
    }

    /**
     * 暗号鍵を取得する.
     * Hexで表現された暗号鍵をbyte配列に変換する.
     * @return
     * @throws Exception
     */
    private byte[] getKey() {
        String key = System.getProperty(this.getClass().getName() + ".secretKey");
        return asByteArray(key);
    }

    /**
     * バイト配列を16進数の文字列に変換する。
     * @param bytes バイト配列
     * @return 16進数の文字列
     */
    private String asHex(byte[] bytes) {
        StringBuffer strbuf = new StringBuffer(bytes.length * 2);

        for (int index = 0; index < bytes.length; index++) {
            // バイト値を自然数に変換。
            int bt = bytes[index] & 0xff;

            if (bt < 0x10) {
                strbuf.append("0");
            }

            strbuf.append(Long.toString(bt, 16));
        }

        return strbuf.toString();
    }

    /**
     * 16進数の文字列をバイト配列に変換する。
     *
     * @param hex 16進数の文字列
     * @return バイト配列
     */
    private byte[] asByteArray(String hex) {
        byte[] bytes = new byte[hex.length() / 2];

        for (int index = 0; index < bytes.length; index++) {
            bytes[index] = (byte) Integer.parseInt(hex.substring(index * 2, (index + 1) * 2), 16);
        }

        return bytes;
    }
}
