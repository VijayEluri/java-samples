package jp.co.np.p2netex.sample1.allcommon.cbean;

import java.util.Collections;
import java.util.Map;
import java.util.LinkedHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jp.co.np.p2netex.sample1.allcommon.Sample1DBFluteConfig;
import jp.co.np.p2netex.sample1.allcommon.cbean.sqlclause.*;
import jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlparser.Sample1InternalSqlParser;
import jp.co.np.p2netex.sample1.allcommon.util.Sample1SimpleSystemUtil;

/**
 * Condition-Bean context.
 * @author DBFlute(AutoGenerator)
 */
public class Sample1ConditionBeanContext {

    /** Log instance. */
    private static final Log _log = LogFactory.getLog(Sample1ConditionBeanContext.class);

    // ===================================================================================
    //                                                                        Thread Local
    //                                                                        ============
    /** The thread-local for this. */
    private static final ThreadLocal<Sample1ConditionBean> _threadLocal = new ThreadLocal<Sample1ConditionBean>();

    /**
     * Get condition-bean on thread.
     * @return Condition-bean context. (Nullable)
     */
    public static Sample1ConditionBean getConditionBeanOnThread() {
        return (Sample1ConditionBean)_threadLocal.get();
    }

    /**
     * Set condition-bean on thread.
     * @param cb Condition-bean. (NotNull)
     */
    public static void setConditionBeanOnThread(Sample1ConditionBean cb) {
        if (cb == null) {
            String msg = "The argument[cb] must not be null.";
            throw new IllegalArgumentException(msg);
        }
        _threadLocal.set(cb);
    }

    /**
     * Is existing condition-bean on thread?
     * @return Determination.
     */
    public static boolean isExistConditionBeanOnThread() {
        return (_threadLocal.get() != null);
    }

    /**
     * Clear condition-bean on thread.
     */
    public static void clearConditionBeanOnThread() {
        _threadLocal.set(null);
    }

    // ===================================================================================
    //                                         Initialize against the ClassLoader Headache
    //                                         ===========================================
	@SuppressWarnings("unused")
    public static void initialize() {
        boolean debugEnabled = _log.isDebugEnabled();
        // Against the ClassLoader Headache!
        final StringBuilder sb = new StringBuilder();
        {
            final Class<?> clazz = jp.co.np.p2netex.sample1.allcommon.cbean.Sample1SimplePagingBean.class;
            if (debugEnabled) { sb.append("  ...Loading class of " + clazz.getName() + " by " + clazz.getClassLoader().getClass()).append(getLineSeparator()); }
        }
		{
            Class<?> clazz = jp.co.np.p2netex.sample1.allcommon.cbean.coption.Sample1FromToOption.class;
            clazz = jp.co.np.p2netex.sample1.allcommon.cbean.coption.Sample1LikeSearchOption.class;
            clazz = jp.co.np.p2netex.sample1.allcommon.cbean.coption.Sample1InScopeOption.class;
            clazz = jp.co.np.p2netex.sample1.allcommon.cbean.grouping.Sample1GroupingOption.class;
            clazz = jp.co.np.p2netex.sample1.allcommon.cbean.grouping.Sample1GroupingRowEndDeterminer.class;
            clazz = jp.co.np.p2netex.sample1.allcommon.cbean.grouping.Sample1GroupingRowResource.class;
            clazz = jp.co.np.p2netex.sample1.allcommon.cbean.grouping.Sample1GroupingRowSetupper.class;
            clazz = jp.co.np.p2netex.sample1.allcommon.cbean.pagenavi.Sample1PageNumberLink.class;
            clazz = jp.co.np.p2netex.sample1.allcommon.cbean.pagenavi.Sample1PageNumberLinkSetupper.class;
            clazz = jp.co.np.p2netex.sample1.allcommon.jdbc.Sample1CursorHandler.class;
            if (debugEnabled) { sb.append("  ...Loading class of ...and so on"); }
        }
        if (debugEnabled) { 
            _log.debug("{Initialize against the ClassLoader Headache}" + getLineSeparator() + sb);
        }
    }

    // ===================================================================================
    //                                                                  Type Determination
    //                                                                  ==================
    /**
     * Is the argument condition-bean?
     * @param dtoInstance DTO instance.
     * @return Determination.
     */
    public static boolean isTheArgumentConditionBean(final Object dtoInstance) {
        if (dtoInstance instanceof Sample1ConditionBean) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Is the type condition-bean?
     * @param dtoClass DtoClass.
     * @return Determination.
     */
    public static boolean isTheTypeConditionBean(final Class<?> dtoClass) {
        if (Sample1ConditionBean.class.isAssignableFrom(dtoClass)) {
            return true;
        } else {
            return false;
        }
    }

    // ===================================================================================
    //                                                                        Product Name
    //                                                                        ============
    public static final String DB_NAME_DERBY = "derby";
    public static final String DB_NAME_H2 = "h2";
    public static final String DB_NAME_ORACLE = "oracle";
    public static final String DB_NAME_MYSQL = "mysql";
    public static final String DB_NAME_POSTGRESQL = "postgresql";
    public static final String DB_NAME_FIREBIRD = "firebird";
    public static final String DB_NAME_MSSQL = "mssql";
    public static final String DB_NAME_SYBASE = "sybase";
    public static final String DB_NAME_DB2 = "db2";

    protected static final Map<String, String> _driverHintDatabaseProductNameMap;
    static {
        final Map<String, String> tmpMap = Collections.synchronizedMap(new LinkedHashMap<String, String>());
        tmpMap.put("org.apache.derby", DB_NAME_DERBY);
        tmpMap.put("org.h2", DB_NAME_H2);
        tmpMap.put("oracle", DB_NAME_ORACLE);
        tmpMap.put("mysql", DB_NAME_MYSQL);
        tmpMap.put("postgresql", DB_NAME_POSTGRESQL);
        tmpMap.put("firebird", DB_NAME_FIREBIRD);
        tmpMap.put("sqlserver", DB_NAME_MSSQL);
        tmpMap.put("sybase", DB_NAME_SYBASE);
        tmpMap.put("db2", DB_NAME_DB2);
        _driverHintDatabaseProductNameMap = java.util.Collections.unmodifiableMap(tmpMap);
    }

    public static boolean setupDatabaseProductNameByDriverClassName(String driverClassName) {
        final java.util.Set<String> keySet = _driverHintDatabaseProductNameMap.keySet();
        for (final java.util.Iterator<String> ite = keySet.iterator(); ite.hasNext(); ) {
            final String driverHint = (String)ite.next();
            if (driverClassName.indexOf(driverHint) >= 0) {
                final String databaseProductName = (String)_driverHintDatabaseProductNameMap.get(driverHint);
                setDatabaseProductName(databaseProductName);
                return true;
            }
        }
        return false;
    }

    /** The database product name. */
    private static String _databaseProductName;

    /**
     * Get database product name.
     * @return Database product name.
     */
    public static String getDatabaseProductName() {
        return _databaseProductName;
    }

    /**
     * Set database product name.
     * @param name Database product name. (NotNull)
     */
    public static void setDatabaseProductName(String name) {
        if (_databaseProductName != null) {
            String msg = "Already set up: current=" + _databaseProductName + " your=" + name;
            throw new IllegalStateException(msg);
        }
        _databaseProductName = name;
    }

    // ===================================================================================
    //                                                                   SqlClause Creator
    //                                                                   =================
	/**
	 * Create SQL-clause. {for condition-bean}
	 * @param cb Condition-bean. (NotNull) 
	 * @return SQL-clause. (NotNull)
	 */
    public static Sample1SqlClause createSqlClause(Sample1ConditionBean cb) {
        final String tableSqlName = cb.getTableSqlName();
		final Sample1SqlClause sqlClause = createSqlClause(tableSqlName);
		if (Sample1DBFluteConfig.getInstance().isConditionBeanFormatSql()) {
		    sqlClause.makeFormatClauseEffective();
		}
        return sqlClause;
    }

	/**
	 * Create SQL-clause. {for SimplePagingBean}
	 * @param tableDbName The DB name of table. (NotNull) 
	 * @return SQL-clause. (NotNull)
	 */
    public static Sample1SqlClause createSqlClause(String tableDbName) {
        final String databaseProductName = getDatabaseProductName();
        if (databaseProductName == null) {
            return new Sample1SqlClauseH2(tableDbName);
        }
        final String name = databaseProductName.toLowerCase();
        if (name.equalsIgnoreCase(DB_NAME_DERBY)) {
            return new Sample1SqlClauseDerby(tableDbName);
        } else if (name.equalsIgnoreCase(DB_NAME_H2)) {
            return new Sample1SqlClauseH2(tableDbName);
        } else if (name.equalsIgnoreCase(DB_NAME_ORACLE)) {
            return new Sample1SqlClauseOracle(tableDbName);
        } else if (name.equalsIgnoreCase(DB_NAME_FIREBIRD)) {
            return new Sample1SqlClauseFirebird(tableDbName);
        } else if (name.equalsIgnoreCase(DB_NAME_MYSQL)) {
            return new Sample1SqlClauseMySql(tableDbName);
        } else if (name.equalsIgnoreCase(DB_NAME_POSTGRESQL)) {
            return new Sample1SqlClausePostgreSql(tableDbName);
        } else if (name.equalsIgnoreCase(DB_NAME_MSSQL)) {
            return new Sample1SqlClauseSqlServer(tableDbName);
        } else if (name.equalsIgnoreCase(DB_NAME_DB2)) {
            return new Sample1SqlClauseDb2(tableDbName);
        } else {
            return new Sample1SqlClauseH2(tableDbName);
        }
    }

    // ===================================================================================
    //                                                                  Exception Handling
    //                                                                  ==================
    public static void throwEntityAlreadyDeletedException(Object searchKey4Log) {
        String msg = "Look! Read the message below." + getLineSeparator();
        msg = msg + "/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *" + getLineSeparator();
        msg = msg + "The entity was Not Found! it has already been deleted!" + getLineSeparator();
        msg = msg + getLineSeparator();
        msg = msg + "[Advice]" + getLineSeparator();
        msg = msg + "Please confirm the existence of your target record on your database." + getLineSeparator();
        msg = msg + "Does the target record really created before this operation?" + getLineSeparator();
        msg = msg + "Has the target record been deleted by other thread?" + getLineSeparator();
        msg = msg + "It is precondition that the record exists on your database." + getLineSeparator();
        msg = msg + getLineSeparator();
		if (searchKey4Log != null && searchKey4Log instanceof Sample1ConditionBean) {
		    final Sample1ConditionBean cb = (Sample1ConditionBean)searchKey4Log;
			msg = msg + "[Executed SQL for Display]" + getLineSeparator() + cb.toDisplaySql() + getLineSeparator();
		} else {
            msg = msg + "[Search Condition]" + getLineSeparator() + searchKey4Log + getLineSeparator();
        }
        msg = msg + "* * * * * * * * * */";
        throw new jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyDeletedException(msg);
    }

    public static void throwEntityDuplicatedException(String resultCountString, Object searchKey4Log, Throwable cause) {
        String msg = "Look! Read the message below." + getLineSeparator();
        msg = msg + "/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *" + getLineSeparator();
        msg = msg + "The entity was Too Many! it has been duplicated. It should be the only one! But the resultCount=" + resultCountString + getLineSeparator();
        msg = msg + getLineSeparator();
        msg = msg + "[Advice]" + getLineSeparator();
        msg = msg + "Please confirm your search condition. Does it really select the only one?" + getLineSeparator();
        msg = msg + "Please confirm your database. Does it really exist the only one?" + getLineSeparator();
        msg = msg + getLineSeparator();
		if (searchKey4Log != null && searchKey4Log instanceof Sample1ConditionBean) {
		    final Sample1ConditionBean cb = (Sample1ConditionBean)searchKey4Log;
			msg = msg + "[Executed SQL for Display]" + getLineSeparator() + cb.toDisplaySql() + getLineSeparator();
		} else {
            msg = msg + "[Search Condition]" + getLineSeparator() + searchKey4Log + getLineSeparator();
        }
        msg = msg + "* * * * * * * * * */";
        if (cause != null) {
            throw new jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException(msg, cause);
        } else {
            throw new jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException(msg);
        }
    }

    // ===================================================================================
    //                                                                         Display SQL
    //                                                                         ===========
	public static String convertConditionBean2DisplaySql(Sample1ConditionBean cb) {
	    final String twoWaySql;
	    if (cb.isLimitSelect_PKOnly()) {
		    twoWaySql = cb.getSqlClause().getClausePKOnly();
		} else {
		    twoWaySql = cb.getSqlClause().getClause();
		}
	    return Sample1InternalSqlParser.convertTwoWaySql2DisplaySql(twoWaySql, cb);
	}

    // [DBFlute-0.7.7]
    // ===================================================================================
    //                                                                   Unique Constraint
    //                                                                   =================
    /**
     * Is the SQLException from unique constraint? {Use both SQLState and ErrorCode}
     * @param sqlState SQLState of the SQLException. (Nullable)
     * @param errorCode ErrorCode of the SQLException. (Nullable)
     * @return Is the SQLException from unique constraint?
     */
    public static boolean isUniqueConstraintException(String sqlState, Integer errorCode) {
        return createSqlClause("dummy").isUniqueConstraintException(sqlState, errorCode);
    }

    // [DBFlute-0.7.8]
    // ===================================================================================
    //                                                                       Database Type
    //                                                                       =============
    /**
     * Is the database Oracle?
     * @return Is the database Oracle?
     */
    public static boolean isOracle() {
        return createSqlClause("dummy") instanceof Sample1SqlClauseOracle;
    }

    /**
     * Is the database PostgreSQL?
     * @return Is the database PostgreSQL?
     */
    public static boolean isPostgreSql() {
        return createSqlClause("dummy") instanceof Sample1SqlClausePostgreSql;
    }

    // ===================================================================================
    //                                                                              Helper
    //                                                                              ======
    /**
     * Get the value of line separator.
     * @return The value of line separator. (NotNull)
     */
    protected static String getLineSeparator() {
        return Sample1SimpleSystemUtil.getLineSeparator();
    }
}
