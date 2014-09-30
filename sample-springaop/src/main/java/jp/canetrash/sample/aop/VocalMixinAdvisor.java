package jp.canetrash.sample.aop;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

public class VocalMixinAdvisor extends DefaultIntroductionAdvisor {
 
    private static final long serialVersionUID = 6870718120343022603L;

    public VocalMixinAdvisor() {
        super(new VocalMixin(), Vocal.class);
    }



}
