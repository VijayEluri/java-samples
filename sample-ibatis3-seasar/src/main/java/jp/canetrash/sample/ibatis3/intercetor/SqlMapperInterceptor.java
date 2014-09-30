package jp.canetrash.sample.ibatis3.intercetor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;

public class SqlMapperInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 1L;

    public SqlSessionFactory sqlSessionFactory;

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @SuppressWarnings("unchecked")
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Class targetClass = getTargetClass(invocation);
        if (!sqlSessionFactory.getConfiguration().hasMapper(targetClass)) {
            sqlSessionFactory.getConfiguration().addMapper(targetClass);
        }
        SqlSession session = sqlSessionFactory.openSession();
        Object target = session.getMapper(targetClass);
        Method method = invocation.getMethod();
            return method.invoke(target, invocation.getArguments());
    }

    private boolean hasAnnotation(Method method) {
        Annotation[] annotations = method.getAnnotations();
        if (annotations == null || annotations.length == 0) {
            return false;
        }
        return true;

    }
}
