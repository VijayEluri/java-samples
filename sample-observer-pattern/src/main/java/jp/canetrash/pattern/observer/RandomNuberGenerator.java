package jp.canetrash.pattern.observer;

import java.util.Random;

public class RandomNuberGenerator extends NumberGenerator {

	private Random random = new Random();
	private int number;

	@Override
	public void execute() {
		for (int i = 0; i < 20; i++) {
			number = random.nextInt(50);
			notifyObservers();
		}
	}

	@Override
	public int getNumber() {
		return number;
	}

}
