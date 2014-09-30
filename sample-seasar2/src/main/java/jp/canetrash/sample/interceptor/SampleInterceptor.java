package jp.canetrash.sample.interceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;

public class SampleInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 1L;

    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object obj = invocation.proceed();
        System.out.println("Intercepted....");
        System.out.println(obj);
        return obj;
    }

}
