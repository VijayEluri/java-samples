package jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlcommand;

import javax.sql.DataSource;

import org.seasar.extension.jdbc.StatementFactory;
import org.seasar.dao.BeanMetaData;

import jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlhandler.Sample1InternalAbstractBatchAutoHandler;

/**
 * @author DBFlute(AutoGenerator)
 */
public abstract class Sample1InternalAbstractBatchAutoStaticCommand extends Sample1InternalAbstractAutoStaticCommand {

	// ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final boolean returningRows;

	// ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample1InternalAbstractBatchAutoStaticCommand(DataSource dataSource,
            StatementFactory statementFactory, BeanMetaData beanMetaData,
            String[] propertyNames, boolean returningRows) {
        this(dataSource, statementFactory, beanMetaData, propertyNames, returningRows, DEFAULT_VERSION_NO_AUTO_INCREMENT_ON_MEMORY);
    }

    public Sample1InternalAbstractBatchAutoStaticCommand(DataSource dataSource,
            StatementFactory statementFactory, BeanMetaData beanMetaData,
            String[] propertyNames, boolean returningRows, boolean versionNoAutoIncrementOnMemory) {
        super(dataSource, statementFactory, beanMetaData, propertyNames, versionNoAutoIncrementOnMemory);
        this.returningRows = returningRows;
    }

	// ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    public Object execute(Object[] args) {
        final Sample1InternalAbstractBatchAutoHandler handler = createBatchAutoHandler();
        
		// It is unnecessary!
		// injectDaoClass(handler);
        
		handler.setSql(getSql());
        if (this.returningRows) {
            return handler.executeBatch(args);
        } else {
            final int updatedRows = handler.execute(args);
            return new Integer(updatedRows);
        }
    }
	
    protected abstract Sample1InternalAbstractBatchAutoHandler createBatchAutoHandler();
}
