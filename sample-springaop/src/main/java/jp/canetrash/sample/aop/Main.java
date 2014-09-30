package jp.canetrash.sample.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Springの
 * @author Takashi Funato
 *
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx = 
            new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Guitar target = (Guitar) ctx.getBean("target");
        target.play();
        Vocal vocal = (Vocal) target;
        vocal.sing();
    }
}
