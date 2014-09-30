package sample.paranamer.example;

import java.lang.reflect.Method;

import com.thoughtworks.paranamer.DefaultParanamer;

import junit.framework.TestCase;

public class ParanamerTest extends TestCase {

	public void testSimple() {
		 Method method = new DefaultParanamer().lookupMethod(ParanamerExampleClass.class.getClassLoader(), 
	              "", "addToShoppingCart", "make,model,qty,onClick");
	}

}
