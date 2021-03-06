package jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlhandler;

import javax.sql.DataSource;

import org.seasar.dao.BeanMetaData;
import org.seasar.dao.IdentifierGenerator;
import org.seasar.extension.jdbc.PropertyType;
import org.seasar.extension.jdbc.StatementFactory;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample1InternalInsertAutoHandler extends Sample1InternalAbstractAutoHandler {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample1InternalInsertAutoHandler(DataSource dataSource,
            StatementFactory statementFactory, BeanMetaData beanMetaData,
            PropertyType[] propertyTypes) {
        super(dataSource, statementFactory, beanMetaData, propertyTypes);
    }

    // ===================================================================================
    //                                                                            Override
    //                                                                            ========
	@Override
    protected void setupBindVariables(Object bean) {
        setupInsertBindVariables(bean);
    }

	@Override
    protected void preUpdateBean(Object bean) {
        BeanMetaData bmd = getBeanMetaData();
        for (int i = 0; i < bmd.getIdentifierGeneratorSize(); i++) {
            IdentifierGenerator generator = bmd.getIdentifierGenerator(i);
            if (generator.isSelfGenerate()) {
                generator.setIdentifier(bean, getDataSource());
            }
        }
    }
	
	@Override
    protected void postUpdateBean(Object bean) {
        BeanMetaData bmd = getBeanMetaData();
        for (int i = 0; i < bmd.getIdentifierGeneratorSize(); i++) {
            IdentifierGenerator generator = bmd.getIdentifierGenerator(i);
            if (!generator.isSelfGenerate()) {
                generator.setIdentifier(bean, getDataSource());
            }
        }
        updateVersionNoIfNeed(bean);
        updateTimestampIfNeed(bean);
    }
}
