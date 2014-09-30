package sample.json;

import junit.framework.TestCase;

public class SimpleJsonLibWorkTest extends TestCase {
	
	static SimpleJsonLibWork target = new SimpleJsonLibWork();

	public void testArraySample() {
		target.arraySample();
	}

	public void testCollectionSample() {
		target.collectionSample();
	}

	public void testMapSample() {
		target.mapSample();
	}

	public void testBeanSample() {
		target.beanSample();
	}

	public void testConvertToDynaBean() throws Exception {
		target.convertToDynaBean();
	}

}
