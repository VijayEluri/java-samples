package sample.betwixt;

import junit.framework.TestCase;

/**
 * @author funato
 *
 */
public class SimpleOperationTest extends TestCase {

	static SimpleOperation ope = new SimpleOperation();

	public void testProcessToXml() throws Exception {
		ope.processToXml(createAddress(), "src/test/resources/test.xml");
	}

	public void testProcessToBean() throws Exception {
		Address addr = ope.processToBean("src/test/resources/test.xml");
	}
	
	private Address createAddress() {
        Address addr = new Address();
        addr.setAge(25);
        addr.setMyAddress("Tokyo");
        addr.setMyName("Foo Baa");
        addr.setTel("00-3333-5555");

        Friend friend = new Friend();
        friend.setName("‘DŒË");
        friend.setAge(23);
        friend.setType("female");
        addr.addFriends(friend);
        friend = new Friend();
        friend.setName("ŽR“c");
        friend.setAge(21);
        friend.setType("male");
        addr.addFriends(friend);
        return addr;
  
	}

}
