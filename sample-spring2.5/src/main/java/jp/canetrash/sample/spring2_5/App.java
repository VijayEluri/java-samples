package jp.canetrash.sample.spring2_5;

import org.springframework.stereotype.Component;

@Component("test")
public class App implements APPIF {

	
	public void print() {
		System.out.println("動いてるよ");

	}

}
