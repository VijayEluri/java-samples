/*
 * çÏê¨ì˙: 2005/03/24
 */
package javaassist.test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Date;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


/**
 * @author
 */
public class Sample1 {
    
    public static void main(String[] args) throws Exception {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        long before;
        long after;
        int count = 1000000;

        //########################## Original
        before = new Date().getTime();

        IFoo fo = new FooOrg();

        for (int i = 0; i < count; i++) {
            fo.doSomething();
        }

        after = new Date().getTime();
        System.err.println("############### Original " + (after - before)
                           + "ms");

        //########################## Javassist
        before = new Date().getTime();

        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("javaassist.test.Foo");
        CtMethod method = cc.getDeclaredMethod("doSomething");
        method.insertBefore("System.out.println(\"before\");");
        method.insertAfter("System.out.println(\"after\");");

        Class clazz = cc.toClass();
        IFoo foo = (IFoo)clazz.newInstance();
        for (int i = 0; i < count; i++) {
            foo.doSomething();
        }

        after = new Date().getTime();
        System.err.println("############### Javassist " + (after - before)
                           + "ms");

        //########################## CGlib
        before = new Date().getTime();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Foo.class);

        DelegateInterceptor mi = new DelegateInterceptor();
        enhancer.setCallback(mi);

        Foo baa = (Foo)enhancer.create();
        mi.setDelegate(baa);

        for (int i = 0; i < count; i++) {
            baa.doSomething();
        }

        after = new Date().getTime();
        System.err.println("############### CGlib " + (after - before) + "ms");
    }

    public static class DelegateInterceptor implements MethodInterceptor {
        Foo delegate;
        public void setDelegate(Foo delegate){
            this.delegate = delegate;
        }
        public Object intercept(Object obj, Method method, Object[] args,
                                MethodProxy proxy) throws Throwable {
            if ("doSomething".equals(method.getName())) {
                System.out.println("before");

                Object ret = proxy.invokeSuper(obj, args);
                System.out.println("after");

                return ret;
            } else {
                return null;
            }
        }
    }
}
