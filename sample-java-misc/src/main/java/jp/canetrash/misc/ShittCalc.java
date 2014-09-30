package jp.canetrash.misc;

/**
 * �V�t�g���Z�̎���
 * �� �r�b�g���Z�q
 * NOT
 *     �r�b�g�̔��]�B10101��������01010�ɂȂ�
 * OR
 *     �Q�̃r�b�g�̔�r�łǂ����1�������Ă���1�ɂ���
 *     10101
 *     01000
 *     -----
 *     11101
 * XOR
 *     �Q�̃r�b�g�̔�r�œ����r�b�g��������0�A����Ă���P������
 *     10101
 *     01001
 *     -----
 *     11100
 *   
 * AND
 *     �Q�̃r�b�g���r���Ăǂ�����P�������Ă�����P������
 *     10101
 *     01001
 *     -----
 *     00001
 *     
 * ��4���
 * 
 */
public class ShittCalc {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int i = Integer.parseInt("10101", 2);
        int j = Integer.parseInt("01011", 2);
        System.out.println(Integer.toBinaryString(i ^ j)); // XOR ����Ă���1
        System.out.println(Integer.toBinaryString(i & j)); // AND �ǂ�����P�������Ă���P
        System.out.println(Integer.toBinaryString(i | j)); // OR�ǂ��炩�P�������Ă���1
        
    }

}
