package jp.canetrash.sample.servlet31.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ListenerTest implements ServletRequestListener {

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		System.out.println("############ request event init.");
	}

	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		System.out.println("############ request event destroyed.");
	}


}
