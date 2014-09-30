package jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlcommand;

import javax.sql.DataSource;

import org.seasar.extension.jdbc.StatementFactory;
import org.seasar.dao.BeanMetaData;

import jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlhandler.Sample1InternalAbstractAutoHandler;
import jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlhandler.Sample1InternalAbstractBatchAutoHandler;
import jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlhandler.Sample1InternalInsertBatchAutoHandler;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample1InternalInsertBatchAutoStaticCommand extends Sample1InternalAbstractBatchAutoStaticCommand {

	// ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample1InternalInsertBatchAutoStaticCommand(DataSource dataSource,
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
        return new Sample1InternalInsertBatchAutoHandler(getDataSource(), getStatementFactory(), getBeanMetaData(), getPropertyTypes());
    }

	@Override
    protected void setupSql() {
        setupInsertSql();
    }

	@Override
    protected void setupPropertyTypes(String[] propertyNames) {
        setupInsertPropertyTypes(propertyNames);
    }
}
