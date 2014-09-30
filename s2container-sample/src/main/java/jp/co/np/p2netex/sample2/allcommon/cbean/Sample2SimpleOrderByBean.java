package jp.co.np.p2netex.sample2.allcommon.cbean;

import jp.co.np.p2netex.sample2.allcommon.cbean.sqlclause.Sample2OrderByClause;
import jp.co.np.p2netex.sample2.allcommon.cbean.sqlclause.Sample2SqlClause;

/**
 * @deprecated
 */
public class Sample2SimpleOrderByBean implements Sample2OrderByBean {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** SQL clause instance. */
    protected final Sample2SqlClause _sqlClause;
    {
        _sqlClause = Sample2ConditionBeanContext.createSqlClause("Dummy");
    }

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * Constructor.
     */
    public Sample2SimpleOrderByBean() {
    }

    // ===================================================================================
    //                                                                           SqlClause
    //                                                                           =========
    /**
     * Get sql-clause.
     * 
     * @return Sql clause. (NotNull)
     */
    protected Sample2SqlClause getSqlClause() {
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
    public Sample2OrderByClause getSqlComponentOfOrderByClause() {
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
    public Sample2OrderByBean clearOrderBy() {
        getSqlClause().clearOrderBy();
        return this;
    }

    /**
     * The implementation.
     * 
     * @return this. (NotNull)
     */
    public Sample2OrderByBean ignoreOrderBy() {
        getSqlClause().ignoreOrderBy();
        return this;
    }

    /**
     * The implementation.
     * 
     * @return this. (NotNull)
     */
    public Sample2OrderByBean makeOrderByEffective() {
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
    public Sample2OrderByBean registerOrderByAsc(String orderByProperty) {
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
    public Sample2OrderByBean registerOrderByDesc(String orderByProperty) {
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
    public Sample2OrderByBean reverseOrderBy_Or_OverrideOrderByAsc(String orderByProperty) {
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
    public Sample2OrderByBean reverseOrderBy_Or_OverrideOrderByDesc(String orderByProperty) {
        getSqlClause().reverseOrderBy_Or_OverrideOrderBy(orderByProperty, orderByProperty, false);
        return this;
    }
}
