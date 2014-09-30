/*
 * çÏê¨ì˙: 2005/03/10
 */
package cglib.test;

import junit.framework.TestCase;

import net.sf.cglib.core.ReflectUtils;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.Factory;
import net.sf.cglib.proxy.MethodInterceptor;


/**
 * @author
 */
public class TestEnhancer extends TestCase {
    private static final MethodInterceptor TEST_INTERCEPTOR =
        new TestInterceptor();

    public void testEnhanced() throws Throwable {
        Enhancer e = new Enhancer();
        e.setSuperclass(ArgInit.class);
        e.setCallbackType(MethodInterceptor.class);
        Class f = e.createClass();
        ArgInit a =
            (ArgInit)ReflectUtils.newInstance(f, new Class[]{ String.class },
                                              new Object[]{ "test" });
        ((Factory)a).setCallback(0, TEST_INTERCEPTOR);
        a.getValue();
        
        /*
        TestInterface tf = (TestInterface)Enhancer.create(TestInterfaceImpl.class, null, TEST_INTERCEPTOR);
        tf.testMethod();
        */
    }
    /*
    public void testTypes() {
        Source source =
            (Source)Enhancer.create(Source.class, TEST_INTERCEPTOR);
        source.getValue();
    }
/*
    public void testObject() throws Throwable {
        Object source = Enhancer.create(null, null, TEST_INTERCEPTOR);

        assertTrue("parent is object",
                   source.getClass().getSuperclass() == Object.class);
    }

    public void testRuntimException() throws Throwable {
        Source source =
            (Source)Enhancer.create(Source.class, null, TEST_INTERCEPTOR);

        try {
            source.throwIndexOutOfBoundsException();
            fail("must throw an exception");
        } catch (IndexOutOfBoundsException ok) {}
    }

    public void testArgInit() throws Throwable {
        Enhancer e = new Enhancer();
        e.setSuperclass(ArgInit.class);
        e.setCallbackType(MethodInterceptor.class);

        Class f = e.createClass();
        ArgInit a =
            (ArgInit)ReflectUtils.newInstance(f, new Class[]{ String.class },
                                              new Object[]{ "test" });
        assertEquals("test", a.toString());
        ((Factory)a).setCallback(0, TEST_INTERCEPTOR);
        assertEquals("test", a.toString());

        Callback[] callbacks = new Callback[]{ TEST_INTERCEPTOR };
        ArgInit b =
            (ArgInit)((Factory)a).newInstance(new Class[]{ String.class },
                                              new Object[]{ "test2" }, callbacks);
        assertEquals("test2", b.toString());

        try {
            ((Factory)a).newInstance(new Class[]{ String.class, String.class },
                                     new Object[]{ "test" }, callbacks);
            fail("must throw exception");
        } catch (IllegalArgumentException iae) {}
    }
    */
}
