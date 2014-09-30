package jp.co.np.p2netex.sample2.allcommon.cbean.sqlclause;


import jp.co.np.p2netex.sample2.allcommon.dbmeta.Sample2DBMeta;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.Sample2DBMetaInstanceHandler;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.info.Sample2ColumnInfo;

/**
 * SqlClause for Oracle.
 * @author DBFlute(AutoGenerator)
 */
public class Sample2SqlClauseOracle extends Sample2AbstractSqlClause {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** String of fetch-scope as select-hint. */
    protected String _fetchScopeSelectHint = "";

    /** String of fetch-scope as sql-suffix. */
    protected String _fetchScopeSqlSuffix = "";

    /** String of lock as sql-suffix. */
    protected String _lockSqlSuffix = "";

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * Constructor.
     * @param tableName Table name. (NotNull)
     **/
    public Sample2SqlClauseOracle(String tableName) {
        super(tableName);
    }

    // ===================================================================================
    //                                                          Database Original Override
    //                                                          ==========================
    @Override
    protected String buildUnionClause(String selectClause) {
	
	    // - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	    // Remove select-hint comment from select clause of union
		// for fetch-scope with union().
	    // - - - - - - - - - - - - - - - - - - - - - - - - - - - -

        selectClause = replaceString(selectClause, SELECT_HINT, "");
        return super.buildUnionClause(selectClause);
    }
	
    // ===================================================================================
    //                                                                 FetchScope Override
    //                                                                 ===================
    /**
     * The implementation.
     */
    protected void doFetchFirst() {
        doFetchPage();
    }

    /**
     * The implementation.
     */
    protected void doFetchPage() {
        if (!isFetchStartIndexSupported() && !isFetchSizeSupported()) {
            return;
        }
		String ln = null;
		if (isFormatClauseEffective()) {
		    ln = getLineSeparator();
		} else {
		    ln = "";
		}
        _fetchScopeSelectHint = " * from (select base.*, rownum as rn from (" + ln + "select";
        _fetchScopeSqlSuffix = "";
        if (isFetchStartIndexSupported()) {
            _fetchScopeSqlSuffix = ") base )" + ln + " where rn > " + getPageStartIndex();
        }
        if (isFetchSizeSupported()) {
            if (isFetchStartIndexSupported()) {
                _fetchScopeSqlSuffix = _fetchScopeSqlSuffix + " and rn <= " + getPageEndIndex();
            } else {
                _fetchScopeSqlSuffix = ") base )" + ln + " where rn <= " + getPageEndIndex();
            }
        }
    }

    /**
     * The implementation.
     */
    protected void doClearFetchPageClause() {
        _fetchScopeSelectHint = "";
        _fetchScopeSqlSuffix = "";
    }

    // ===================================================================================
    //                                                                       Lock Override
    //                                                                       =============
    /**
     * The implementation.
     * @return this. (NotNull)
     */
    public Sample2SqlClause lockForUpdate() {
        final Sample2DBMeta dbmeta = Sample2DBMetaInstanceHandler.findDBMeta(_tableName);
        if (dbmeta.hasPrimaryKey()) {
            final String primaryKeyColumnName = dbmeta.getPrimaryUniqueInfo().getFirstColumn().getColumnDbName();
            _lockSqlSuffix = " for update of " + getLocalTableAliasName() + "." + primaryKeyColumnName;
        } else {
            final String randomColumnName = ((Sample2ColumnInfo)dbmeta.getColumnInfoList().get(0)).getColumnDbName();
            _lockSqlSuffix = " for update of " + getLocalTableAliasName() + "." + randomColumnName;
        }
        return this;
    }

    // ===================================================================================
    //                                                                       Hint Override
    //                                                                       =============
    /**
     * The implementation.
     * @return Select-hint. (NotNull)
     */
    protected String createSelectHint() {
        return _fetchScopeSelectHint;
    }

    /**
     * The implementation.
     * @return From-base-table-hint. {select * from table [from-base-table-hint] where ...} (NotNull)
     */
    protected String createFromBaseTableHint() {
        return "";
    }

    /**
     * The implementation.
     * @return From-hint. (NotNull)
     */
    protected String createFromHint() {
        return "";
    }

    /**
     * The implementation.
     * @return Sql-suffix. (NotNull)
     */
    protected String createSqlSuffix() {
        return _fetchScopeSqlSuffix + _lockSqlSuffix;
    }

    // [DBFlute-0.7.7]
    // ===================================================================================
    //                                                          Unique Constraint Override
    //                                                          ==========================
    @Override
    public boolean isUniqueConstraintException(String sqlState, Integer errorCode) {
        return errorCode != null && errorCode == 1;
    }
}
