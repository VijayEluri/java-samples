package jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlcommand;

import javax.sql.DataSource;

import org.seasar.extension.jdbc.StatementFactory;
import org.seasar.dao.BeanMetaData;

import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlhandler.Sample2InternalAbstractAutoHandler;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlhandler.Sample2InternalAbstractBatchAutoHandler;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlhandler.Sample2InternalDeleteBatchAutoHandler;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample2InternalDeleteBatchAutoStaticCommand extends Sample2InternalAbstractBatchAutoStaticCommand {

	// ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample2InternalDeleteBatchAutoStaticCommand(DataSource dataSource,
            StatementFactory statementFactory, BeanMetaData beanMetaData,
            String[] propertyNames, boolean returningRows) {
        super(dataSource, statementFactory, beanMetaData, propertyNames, returningRows);
    }

	// ===================================================================================
    //                                                                            Override
    //                                                                            ========
	@Override
    protected Sample2InternalAbstractAutoHandler createAutoHandler() {
        return createBatchAutoHandler();
    }

	@Override
    protected Sample2InternalAbstractBatchAutoHandler createBatchAutoHandler() {
        return newInternalBatchAutoHandler();
    }

    protected Sample2InternalDeleteBatchAutoHandler newInternalBatchAutoHandler() {
        return new Sample2InternalDeleteBatchAutoHandler(getDataSource(), getStatementFactory(), getBeanMetaData(), getPropertyTypes());
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
