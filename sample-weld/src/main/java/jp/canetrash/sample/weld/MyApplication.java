package jp.canetrash.sample.weld;

import jp.canetrash.sample.weld.target.Guitar;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class MyApplication {

	public static void main(String[] args) {

		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		Guitar guitar = container.instance().select(Guitar.class).get();
		System.out.println(guitar.toString());
	}
}
