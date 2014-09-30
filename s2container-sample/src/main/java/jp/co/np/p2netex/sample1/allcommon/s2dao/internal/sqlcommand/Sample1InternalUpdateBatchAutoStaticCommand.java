package jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlcommand;

import javax.sql.DataSource;

import org.seasar.extension.jdbc.StatementFactory;
import org.seasar.dao.BeanMetaData;

import jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlhandler.Sample1InternalAbstractAutoHandler;
import jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlhandler.Sample1InternalAbstractBatchAutoHandler;
import jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlhandler.Sample1InternalUpdateBatchAutoHandler;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample1InternalUpdateBatchAutoStaticCommand extends Sample1InternalAbstractBatchAutoStaticCommand {

	// ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample1InternalUpdateBatchAutoStaticCommand(DataSource dataSource,
            StatementFactory statementFactory, BeanMetaData beanMetaData,
            String[] propertyNames, boolean returningRows, boolean versionNoAutoIncrementOnMemory) {
        super(dataSource, statementFactory, beanMetaData, propertyNames, returningRows, versionNoAutoIncrementOnMemory);
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
        Sample1InternalUpdateBatchAutoHandler handler = newInternalBatchAutoHandler();
        handler.setVersionNoAutoIncrementOnMemory(versionNoAutoIncrementOnMemory);
        return handler;
    }

    protected Sample1InternalUpdateBatchAutoHandler newInternalBatchAutoHandler() {
        return new Sample1InternalUpdateBatchAutoHandler(getDataSource(), getStatementFactory(), getBeanMetaData(), getPropertyTypes());
    }

	@Override
    protected void setupSql() {
        setupUpdateSql();
    }

	@Override
    protected void setupPropertyTypes(String[] propertyNames) {
        setupUpdatePropertyTypes(propertyNames);
    }
}
