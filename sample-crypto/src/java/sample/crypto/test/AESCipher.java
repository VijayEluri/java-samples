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
 * AES �Í���
 * ���[�h CBC
 * �p�f�B���O PKCS5Padding
 * �ł̈Í����̃e�X�g
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
     * AES/CBC/PKCS5Padding�ŃG���R�[�h����.
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
     * AES/CBC/PKCS5Padding�Ńf�R�[�h����.
     * @param str
     * @throws Exception
     */
    public String decode(String str) {
        if (str == null) {
            return null;
        } else if (str.length() < 2) {
            throw new IllegalArgumentException("invalid data.");
        }

        // �o�[�W�����̃`�F�b�N
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
     * �Í������擾����.
     * Hex�ŕ\�����ꂽ�Í�����byte�z��ɕϊ�����.
     * @return
     * @throws Exception
     */
    private byte[] getKey() {
        String key = System.getProperty(this.getClass().getName() + ".secretKey");
        return asByteArray(key);
    }

    /**
     * �o�C�g�z���16�i���̕�����ɕϊ�����B
     * @param bytes �o�C�g�z��
     * @return 16�i���̕�����
     */
    private String asHex(byte[] bytes) {
        StringBuffer strbuf = new StringBuffer(bytes.length * 2);

        for (int index = 0; index < bytes.length; index++) {
            // �o�C�g�l�����R���ɕϊ��B
            int bt = bytes[index] & 0xff;

            if (bt < 0x10) {
                strbuf.append("0");
            }

            strbuf.append(Long.toString(bt, 16));
        }

        return strbuf.toString();
    }

    /**
     * 16�i���̕�������o�C�g�z��ɕϊ�����B
     *
     * @param hex 16�i���̕�����
     * @return �o�C�g�z��
     */
    private byte[] asByteArray(String hex) {
        byte[] bytes = new byte[hex.length() / 2];

        for (int index = 0; index < bytes.length; index++) {
            bytes[index] = (byte) Integer.parseInt(hex.substring(index * 2, (index + 1) * 2), 16);
        }

        return bytes;
    }
}
