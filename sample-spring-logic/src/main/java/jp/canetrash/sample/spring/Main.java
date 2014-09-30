package jp.canetrash.sample.spring;

import jp.canetrash.sample.spring.dbflute.exentity.Users;
import jp.canetrash.sample.spring.dbflute2.exentity.OtherUsers2;
import jp.canetrash.sample.spring.service.UserService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"classpath:/applicationContext.xml",
				"classpath:/dbflute-sample-Beans.xml",
				"classpath:/dbflute-sample2-Beans.xml",
				"classpath:/dataSourceBeans.xml");
		UserService userService = appContext.getBean(UserService.class);

		Users user = userService.getUserById(0);
		OtherUsers2 otherUser = userService.getOtherUserById(0);
	}
}
