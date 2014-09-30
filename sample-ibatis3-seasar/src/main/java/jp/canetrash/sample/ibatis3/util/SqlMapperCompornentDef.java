package jp.canetrash.sample.ibatis3.util;

import org.apache.ibatis.session.SqlSessionFactory;
import org.seasar.framework.container.TooManyRegistrationRuntimeException;
import org.seasar.framework.container.impl.SimpleComponentDef;

public class SqlMapperCompornentDef extends SimpleComponentDef {

    private SqlSessionFactory sqlSessionFactory;

    @SuppressWarnings("unchecked")
    public SqlMapperCompornentDef(Class targetClass, SqlSessionFactory sqlSessionFactory) {
        super(targetClass);
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Object getComponent() throws TooManyRegistrationRuntimeException {
        return sqlSessionFactory.openSession();
    }

}
