package jp.co.np.p2netex.sample2.allcommon.s2dao;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.seasar.extension.jdbc.ResultSetFactory;

import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2FetchNarrowingBean;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2FetchNarrowingBeanContext;
import jp.co.np.p2netex.sample2.allcommon.cbean.outsidesql.Sample2OutsideSqlContext;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlhandler.Sample2InternalBasicHandler.SQLExceptionHandler;

/**
 * Fetch narrowing result set factory.
 * @author DBFlute(AutoGenerator)
 */
public class Sample2FetchNarrowingResultSetFactory implements ResultSetFactory {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * Constructor.
     */
    public Sample2FetchNarrowingResultSetFactory() {
    }

    // ===================================================================================
    //                                                                                Main
    //                                                                                ====
    /**
     * Get result set.
     * @param statement Statement. (NotNull)
     * @return Result set for procedure executing of s2dao. (NotNull)
     */
    public ResultSet getResultSet(Statement statement) {
        return doGetResultSet(statement);
    }

    /**
     * Create result set.
     * @param ps Prepared statement. (NotNull)
     * @return Result set. (NotNull)
     */
    public ResultSet createResultSet(PreparedStatement ps) {
        final ResultSet resultSet = executeQuery(ps);

        if (!Sample2FetchNarrowingBeanContext.isExistFetchNarrowingBeanOnThread()) {
            return resultSet;
        }
        final Sample2FetchNarrowingBean cb = Sample2FetchNarrowingBeanContext.getFetchNarrowingBeanOnThread();
        if (!isUseFetchNarrowingResultSetWrapper(cb)) {
            return resultSet;
        }
        final Sample2FetchNarrowingResultSetWrapper wrapper;
        if (Sample2OutsideSqlContext.isExistOutsideSqlContextOnThread()) {
            final Sample2OutsideSqlContext outsideSqlContext = Sample2OutsideSqlContext.getOutsideSqlContextOnThread();
            wrapper = new Sample2FetchNarrowingResultSetWrapper(resultSet, cb, outsideSqlContext.isOffsetByCursorForcedly(), outsideSqlContext.isLimitByCursorForcedly());
        } else {
            wrapper = new Sample2FetchNarrowingResultSetWrapper(resultSet, cb, false, false);
        }
        return wrapper;
    }

    protected boolean isUseFetchNarrowingResultSetWrapper(Sample2FetchNarrowingBean cb) {
        if (cb.getSafetyMaxResultSize() > 0) {
            return true;
        }
        if (!cb.isFetchNarrowingEffective()) {
            return false;// It is not necessary to control.
        }
        if (Sample2OutsideSqlContext.isExistOutsideSqlContextOnThread()) {
            final Sample2OutsideSqlContext outsideSqlContext = Sample2OutsideSqlContext.getOutsideSqlContextOnThread();
            if (outsideSqlContext.isOffsetByCursorForcedly() || outsideSqlContext.isLimitByCursorForcedly()) {
                return true;
            }
        }
        if (cb.isFetchNarrowingSkipStartIndexEffective() || cb.isFetchNarrowingLoopCountEffective()) {
            return true;
        }
        return false;
    }

    // ===================================================================================
    //                                                                      JDBC Delegator
    //                                                                      ==============
    protected ResultSet doGetResultSet(Statement statement)  {
        try {
            return statement.getResultSet();
        } catch (SQLException e) {
            handleSQLException(e, statement);
            return null;// Unreachable!
        }
    }

    protected ResultSet executeQuery(PreparedStatement ps) {
        try {
            return ps.executeQuery();
        } catch (SQLException e) {
            handleSQLException(e, ps);
            return null;// Unreachable!
        }
    }

    protected void handleSQLException(SQLException e, Statement statement) {
        new SQLExceptionHandler().handleSQLException(e, statement);
    }
}
