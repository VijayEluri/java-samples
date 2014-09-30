package jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlcommand;

import javax.sql.DataSource;

import org.seasar.extension.jdbc.StatementFactory;
import org.seasar.dao.BeanMetaData;

import jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlhandler.Sample1InternalAbstractAutoHandler;
import jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlhandler.Sample1InternalDeleteAutoHandler;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample1InternalDeleteAutoStaticCommand extends Sample1InternalAbstractAutoStaticCommand {

	// ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample1InternalDeleteAutoStaticCommand(DataSource dataSource,
            StatementFactory statementFactory, BeanMetaData beanMetaData,
            String[] propertyNames) {
        super(dataSource, statementFactory, beanMetaData, propertyNames);
    }

	// ===================================================================================
    //                                                                            Override
    //                                                                            ========
    @Override
    protected Sample1InternalAbstractAutoHandler createAutoHandler() {
        return new Sample1InternalDeleteAutoHandler(getDataSource(), getStatementFactory(), getBeanMetaData(), getPropertyTypes());
    }
	
	@Override
    protected void setupSql() {
        setupDeleteSql();
    }

	@Override
    protected void setupPropertyTypes(String[] propertyNames) {
        setupDeletePropertyTypes(propertyNames);
    }
}
