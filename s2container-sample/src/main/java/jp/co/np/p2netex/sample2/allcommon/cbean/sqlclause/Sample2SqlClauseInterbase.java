package jp.co.np.p2netex.sample2.allcommon.cbean.sqlclause;


/**
 * SqlClause for Interbase.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class Sample2SqlClauseInterbase extends Sample2AbstractSqlClause {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** String of fetch-scope as select-hint. */
    protected String _fetchScopeSelectHint = "";

    /** String of lock as sql-suffix. */
    protected String _lockSqlSuffix = "";

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * Constructor.
     * @param tableName Table name. (NotNull)
     **/
    public Sample2SqlClauseInterbase(String tableName) {
        super(tableName);
    }

    /**
     * The implementation.
     */
    protected void doFetchFirst() {
        if (isFetchSizeSupported()) {
            _fetchScopeSelectHint = " first " + getFetchSize();
        }
    }

    /**
     * The implementation.
     */
    protected void doFetchPage() {
        if (isFetchStartIndexSupported() && isFetchSizeSupported()) {
            _fetchScopeSelectHint = " first " + getFetchSize() + " skip " + getPageStartIndex();
        }
        if (isFetchStartIndexSupported() && !isFetchSizeSupported()) {
            _fetchScopeSelectHint = " skip " + getPageStartIndex();
        }
        if (!isFetchStartIndexSupported() && isFetchSizeSupported()) {
            _fetchScopeSelectHint = " first " + getPageEndIndex();
        }
    }

    /**
     * The implementation.
     */
    protected void doClearFetchPageClause() {
        _fetchScopeSelectHint = "";
    }

    /**
     * The implementation.
     * 
     * @return this. (NotNull)
     */
    public Sample2SqlClause lockForUpdate() {
        _lockSqlSuffix = " for update with lock";
        return this;
    }

    /**
     * The implementation.
     * 
     * @return Select-hint. (NotNull)
     */
    protected String createSelectHint() {
        return _fetchScopeSelectHint;
    }

    /**
     * The implementation.
     * 
     * @return From-base-table-hint. {select * from table [from-base-table-hint] where ...} (NotNull)
     */
    protected String createFromBaseTableHint() {
        return "";
    }

    /**
     * The implementation.
     * 
     * @return From-hint. (NotNull)
     */
    protected String createFromHint() {
        return "";
    }

    /**
     * The implementation.
     * 
     * @return Sql-suffix. (NotNull)
     */
    protected String createSqlSuffix() {
        return _lockSqlSuffix;
    }
}
