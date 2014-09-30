package jp.canetrash.pattern.observer;

public class DigitObserver implements Observer {

	@Override
	public void update(NumberGenerator generator) {
		System.out.println("Digit Observer:" + generator.getNumber());
		try {
			Thread.sleep(100L);
		} catch (InterruptedException e) {
		}
	}

}
