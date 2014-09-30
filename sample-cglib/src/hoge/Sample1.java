/*
 * çÏê¨ì˙: 2005/03/08
 */
package hoge;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


/**
 * @author
 */
public class Sample1 {
    public static void main(String[] arg) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Foo.class);
        enhancer.setCallback(new MyMethodIntercepter());

        Foo foo = (Foo)enhancer.create();
        foo.doSomething();
    }
}


class MyMethodIntercepter implements MethodInterceptor {
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        System.out.println("before");

        return proxy.invokeSuper(obj, args);
    }
}
