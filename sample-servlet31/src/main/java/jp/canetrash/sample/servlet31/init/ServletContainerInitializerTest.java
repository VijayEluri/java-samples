package jp.canetrash.sample.servlet31.init;

import java.lang.reflect.Modifier;
import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;

/**
 * @see META-INF/services/javax.servlet.ServletContainerInitializer
 * 
 * @author tfunato
 * 
 */
@HandlesTypes(TestInit.class)
public class ServletContainerInitializerTest implements
		ServletContainerInitializer {
	@Override
	public void onStartup(Set<Class<?>> initializer, ServletContext context)
			throws ServletException {
		System.out
				.println("############################ Auto Initiaraize Start Up!:"
						+ this);
		System.out.println("aaaaaaaaaaaa:" + initializer);
		

		// XXX ここのHandlesTypesで指定されたクラスのリストが返ってくる
		// どうもHandlesTypesに指定するのはインターフェースで、渡されるのは実装クラス
		if (initializer != null) {
			for (Class<?> clz : initializer) {
				System.out.println(clz);
				// インターフェースでなく、抽象クラスでなく、TestInitクラスと同等か？
				if (!clz.isInterface()
						&& !Modifier.isAbstract(clz.getModifiers())
						&& TestInit.class.isAssignableFrom(clz)) {
					try {
						TestInit init = (TestInit) clz.newInstance();
						init.onCall();
					} catch (InstantiationException | IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
