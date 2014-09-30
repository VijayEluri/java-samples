package jp.canetrash.sample.aop;

import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class VocalMixin extends DelegatingIntroductionInterceptor implements
        Vocal {

    private static final long serialVersionUID = 1424260018914763707L;

    @Override
    public void sing() {
        System.out.println("歌を歌う");
        
    }

}
