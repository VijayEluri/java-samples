package jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlcommand;

import javax.sql.DataSource;

import org.seasar.extension.jdbc.StatementFactory;
import org.seasar.dao.BeanMetaData;

import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlhandler.Sample2InternalAbstractAutoHandler;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlhandler.Sample2InternalAbstractBatchAutoHandler;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlhandler.Sample2InternalUpdateBatchAutoHandler;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample2InternalUpdateBatchAutoStaticCommand extends Sample2InternalAbstractBatchAutoStaticCommand {

	// ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample2InternalUpdateBatchAutoStaticCommand(DataSource dataSource,
            StatementFactory statementFactory, BeanMetaData beanMetaData,
            String[] propertyNames, boolean returningRows, boolean versionNoAutoIncrementOnMemory) {
        super(dataSource, statementFactory, beanMetaData, propertyNames, returningRows, versionNoAutoIncrementOnMemory);
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
        Sample2InternalUpdateBatchAutoHandler handler = newInternalBatchAutoHandler();
        handler.setVersionNoAutoIncrementOnMemory(versionNoAutoIncrementOnMemory);
        return handler;
    }

    protected Sample2InternalUpdateBatchAutoHandler newInternalBatchAutoHandler() {
        return new Sample2InternalUpdateBatchAutoHandler(getDataSource(), getStatementFactory(), getBeanMetaData(), getPropertyTypes());
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
