package jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlcommand;

import javax.sql.DataSource;

import org.seasar.extension.jdbc.StatementFactory;
import org.seasar.dao.BeanMetaData;

import jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlhandler.Sample1InternalAbstractAutoHandler;
import jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlhandler.Sample1InternalAbstractBatchAutoHandler;
import jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlhandler.Sample1InternalDeleteBatchAutoHandler;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample1InternalDeleteBatchAutoStaticCommand extends Sample1InternalAbstractBatchAutoStaticCommand {

	// ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample1InternalDeleteBatchAutoStaticCommand(DataSource dataSource,
            StatementFactory statementFactory, BeanMetaData beanMetaData,
            String[] propertyNames, boolean returningRows) {
        super(dataSource, statementFactory, beanMetaData, propertyNames, returningRows);
    }

	// ===================================================================================
    //                                                                            Override
    //                                                                            ========
	@Override
    protected Sample1InternalAbstractAutoHandler createAutoHandler() {
        return createBatchAutoHandler();
    }

	@Override
    protected Sample1InternalAbstractBatchAutoHandler createBatchAutoHandler() {
        return newInternalBatchAutoHandler();
    }

    protected Sample1InternalDeleteBatchAutoHandler newInternalBatchAutoHandler() {
        return new Sample1InternalDeleteBatchAutoHandler(getDataSource(), getStatementFactory(), getBeanMetaData(), getPropertyTypes());
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
