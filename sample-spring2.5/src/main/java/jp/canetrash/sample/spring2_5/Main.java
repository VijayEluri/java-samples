package jp.canetrash.sample.spring2_5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
    	APPIF app = (APPIF) ctx.getBean("test");
    	app.print();
    }
}
