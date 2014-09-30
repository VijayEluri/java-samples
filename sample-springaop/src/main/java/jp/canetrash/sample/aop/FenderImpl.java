package jp.canetrash.sample.aop;

public class FenderImpl implements Guitar {

    @Override
    public void play() {
        System.out.println("Fender!");
    }

}
