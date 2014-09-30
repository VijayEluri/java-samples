package cglib.test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class TestInterceptor implements MethodInterceptor {

    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        // メソッド呼び出し前
        System.out.println("before");

        Object retValFromSuper = null;

        if (!Modifier.isAbstract(method.getModifiers())){
            try {
                retValFromSuper = proxy.invokeSuper(obj, args);
                System.out.println(retValFromSuper);
            } catch (Throwable t) {
                throw t;
            }
        }
        // メソッド呼出し後
        System.out.println("after");
        return retValFromSuper;
    }

}
