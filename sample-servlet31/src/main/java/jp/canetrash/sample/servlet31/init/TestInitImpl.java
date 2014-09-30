package jp.canetrash.sample.servlet31.init;

public class TestInitImpl implements TestInit {

	@Override
	public void onCall() {
		System.out.println("########### OnCalled!");
	}

}
