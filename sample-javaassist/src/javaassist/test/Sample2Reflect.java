/*
 * çÏê¨ì˙: 2005/03/28
 */
package javaassist.test;

import java.lang.reflect.Method;

/**
 * @author
 */
public class Sample2Reflect {

    public static void main(String[] args) throws Exception {
        Method method = Foo.class.getDeclaredMethod("doSomething", null);
        method.invoke(new Foo(), null);
    }
}
