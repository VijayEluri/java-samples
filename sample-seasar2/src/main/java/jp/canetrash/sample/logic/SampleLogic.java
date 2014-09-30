package jp.canetrash.sample.logic;

/**
 * サンプルのロジック
 * 
 * @author tfunato
 * 
 */
public class SampleLogic {

    /**
     * 引数を足し算する
     * 
     * @param x
     * @param y
     * @return
     */
    public int plus(int x, int y) {
        if (x < 0 || y < 0) {
           throw new RuntimeException("引数に負の値はだめですよ"); 
        }
        return x + y;
    }
}
