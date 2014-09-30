package jp.canetrash.sample.sec;

public class OuterClass implements Runnable {

	public void run() {
		System.out.println("Run Exit!");
		System.exit(0);
	}

}
