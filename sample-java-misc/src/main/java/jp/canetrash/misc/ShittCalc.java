package jp.canetrash.misc;

/**
 * シフト演算の実験
 * ◆ ビット演算子
 * NOT
 *     ビットの反転。10101だったら01010になる
 * OR
 *     ２つのビットの比較でどちらも1が立ってたら1にする
 *     10101
 *     01000
 *     -----
 *     11101
 * XOR
 *     ２つのビットの比較で同じビットだったら0、違ってたら１が立つ
 *     10101
 *     01001
 *     -----
 *     11100
 *   
 * AND
 *     ２つのビットを比較してどちらも１が立っていたら１が立つ
 *     10101
 *     01001
 *     -----
 *     00001
 *     
 * の4種類
 * 
 */
public class ShittCalc {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int i = Integer.parseInt("10101", 2);
        int j = Integer.parseInt("01011", 2);
        System.out.println(Integer.toBinaryString(i ^ j)); // XOR 違ってたら1
        System.out.println(Integer.toBinaryString(i & j)); // AND どちらも１が立ってたら１
        System.out.println(Integer.toBinaryString(i | j)); // ORどちらか１が立ってたら1
        
    }

}
