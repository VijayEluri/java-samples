package jp.canetrash.sample.springhadoop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                "/mapred-context.xml", Main.class);
        context.registerShutdownHook();
    }
}
