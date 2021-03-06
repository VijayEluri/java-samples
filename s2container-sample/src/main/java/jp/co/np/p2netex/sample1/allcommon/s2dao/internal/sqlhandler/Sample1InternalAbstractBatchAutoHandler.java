package jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlhandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.seasar.dao.BeanMetaData;
import org.seasar.extension.jdbc.PropertyType;
import org.seasar.extension.jdbc.StatementFactory;

/**
 * @author DBFlute(AutoGenerator)
 */
public abstract class Sample1InternalAbstractBatchAutoHandler extends Sample1InternalAbstractAutoHandler {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Log instance. */
    private static final org.apache.commons.logging.Log _log = org.apache.commons.logging.LogFactory.getLog(Sample1InternalAbstractBatchAutoHandler.class);

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample1InternalAbstractBatchAutoHandler(DataSource dataSource,
            StatementFactory statementFactory, BeanMetaData beanMetaData,
            PropertyType[] propertyTypes) {
        super(dataSource, statementFactory, beanMetaData, propertyTypes);
    }

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    public int[] execute(List<?> list, Class<?>[] argTypes) {
        return execute(list);
    }

    public int[] execute(List<?> list) {
        if (list == null) {
            throw new IllegalArgumentException("list");
        }
		if (list.isEmpty()) {
		    if (_log.isDebugEnabled()) {
                _log.debug("Skip executeBatch() bacause of the empty list.");
            }
			return new int[0];
		}
        final Connection connection = getConnection();
        try {
            final PreparedStatement ps = prepareStatement(connection);
            try {
                for (Iterator<?> iter = list.iterator(); iter.hasNext();) {
                    final Object bean = (Object) iter.next();
                    prepareBatchElement(ps, bean);
                }
                return executeBatch(ps, list);
            } finally {
                close(ps);
            }
        } finally {
            close(connection);
        }
        // Reflection to bean is unsupported at batch update.
        // postBatchUpdateBean(...);
    }
	
    public int execute(Object[] args) {
        List<?> list = null;
        if (args[0] instanceof Object[]) {
            list = Arrays.asList((Object[]) args[0]);
        } else if (args[0] instanceof List) {
            list = (List<?>) args[0];
        }
        if (list == null) {
            throw new IllegalArgumentException("args[0]");
        }
        int[] ret = execute(list);
        int updatedRow = 0;
        for (int i = 0; i < ret.length; i++) {
            if (ret[i] > 0) {
                updatedRow += ret[i];
            }
        }
        return updatedRow;
    }

    public int[] executeBatch(Object[] args) {
        List<?> list = null;
        if (args[0] instanceof Object[]) {
            list = Arrays.asList((Object[]) args[0]);
        } else if (args[0] instanceof List) {
            list = (List<?>) args[0];
        }
        if (list == null) {
            throw new IllegalArgumentException("args[0]");
        }
        return execute(list);
    }

    protected void prepareBatchElement(PreparedStatement ps, Object bean) {
        setupBindVariables(bean);
        logSql(getBindVariables(), getArgTypes(getBindVariables()));
        bindArgs(ps, getBindVariables(), getBindVariableValueTypes());
        addBatch(ps);
    }

    // ===================================================================================
    //                                                                      JDBC Delegator
    //                                                                      ==============
    protected int[] executeBatch(PreparedStatement ps, List<?> list) {
        try {
            return ps.executeBatch();
        } catch (SQLException e) {
            handleSQLException(e, ps, true, list);
            return null;// Unreachable!
        }
    }
	
    protected void addBatch(PreparedStatement ps) {
        try {
            ps.addBatch();
        } catch (SQLException e) {
            handleSQLException(e, ps);
        }
    }
}
