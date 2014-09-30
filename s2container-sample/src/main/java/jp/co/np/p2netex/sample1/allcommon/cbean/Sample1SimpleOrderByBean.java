package jp.co.np.p2netex.sample1.allcommon.cbean;

import jp.co.np.p2netex.sample1.allcommon.cbean.sqlclause.Sample1OrderByClause;
import jp.co.np.p2netex.sample1.allcommon.cbean.sqlclause.Sample1SqlClause;

/**
 * @deprecated
 */
public class Sample1SimpleOrderByBean implements Sample1OrderByBean {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** SQL clause instance. */
    protected final Sample1SqlClause _sqlClause;
    {
        _sqlClause = Sample1ConditionBeanContext.createSqlClause("Dummy");
    }

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * Constructor.
     */
    public Sample1SimpleOrderByBean() {
    }

    // ===================================================================================
    //                                                                           SqlClause
    //                                                                           =========
    /**
     * Get sql-clause.
     * 
     * @return Sql clause. (NotNull)
     */
    protected Sample1SqlClause getSqlClause() {
        return _sqlClause;
    }

    // ===================================================================================
    //                                                                     Select Resource
    //                                                                     ===============
    /**
     * Check safety result.
     * 
     * @param safetyMaxResultSize Safety max result size. (If zero or minus, ignore checking)
     */
    public void checkSafetyResult(int safetyMaxResultSize) {
        throw new UnsupportedOperationException();
    }

    // ===================================================================================
    //                                                                             OrderBy
    //                                                                             =======
    /**
     * The implementation.
     * 
     * @return Sql component of order-by clause. (NotNull)
     */
    public Sample1OrderByClause getSqlComponentOfOrderByClause() {
        return getSqlClause().getSqlComponentOfOrderByClause();
    }

    /**
     * The implementation.
     * 
     * @return Order-by clause. (NotNull)
     */
    public String getOrderByClause() {
        return getSqlClause().getOrderByClause();
    }

    /**
     * The implementation.
     * 
     * @return this. (NotNull)
     */
    public Sample1OrderByBean clearOrderBy() {
        getSqlClause().clearOrderBy();
        return this;
    }

    /**
     * The implementation.
     * 
     * @return this. (NotNull)
     */
    public Sample1OrderByBean ignoreOrderBy() {
        getSqlClause().ignoreOrderBy();
        return this;
    }

    /**
     * The implementation.
     * 
     * @return this. (NotNull)
     */
    public Sample1OrderByBean makeOrderByEffective() {
        getSqlClause().makeOrderByEffective();
        return this;
    }
    /**
     * Register order-by-asc.
     * 
     * @param orderByProperty Order-by-property. 'aliasName.columnName/aliasName.columnName/...' (NotNull)
     * @return this. (NotNull)
     * @deprecated
     */
    public Sample1OrderByBean registerOrderByAsc(String orderByProperty) {
        getSqlClause().registerOrderBy(orderByProperty, orderByProperty, true);
        return this;
    }

    /**
     * Register order-by-desc.
     * 
     * @param orderByProperty Order-by-property. 'aliasName.columnName/aliasName.columnName/...' (NotNull)
     * @return this. (NotNull)
     * @deprecated
     */
    public Sample1OrderByBean registerOrderByDesc(String orderByProperty) {
        getSqlClause().registerOrderBy(orderByProperty, orderByProperty, false);
        return this;
    }

    /**
     * Reverse order-by or Override order-by asc.
     * 
     * @param orderByProperty Order-by-property. 'aliasName.columnName/aliasName.columnName/...' (NotNull)
     * @return this. (NotNull)
     * @deprecated
     */
    public Sample1OrderByBean reverseOrderBy_Or_OverrideOrderByAsc(String orderByProperty) {
        getSqlClause().reverseOrderBy_Or_OverrideOrderBy(orderByProperty, orderByProperty, true);
        return this;
    }

    /**
     * Reverse order-by or Override order-by desc.
     * 
     * @param orderByProperty Order-by-property. 'aliasName.columnName/aliasName.columnName/...' (NotNull)
     * @return this. (NotNull)
     * @deprecated
     */
    public Sample1OrderByBean reverseOrderBy_Or_OverrideOrderByDesc(String orderByProperty) {
        getSqlClause().reverseOrderBy_Or_OverrideOrderBy(orderByProperty, orderByProperty, false);
        return this;
    }
}
