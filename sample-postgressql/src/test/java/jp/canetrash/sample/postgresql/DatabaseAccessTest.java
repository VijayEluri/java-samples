package jp.canetrash.sample.postgresql;

import org.junit.Test;

public class DatabaseAccessTest {

	@Test
	public void testSimple() throws Exception {
		DatabaseAccess da = new DatabaseAccess();
		da.dbSelect();
	}
}
