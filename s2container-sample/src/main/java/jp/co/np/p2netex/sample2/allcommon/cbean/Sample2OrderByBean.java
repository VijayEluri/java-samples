package jp.co.np.p2netex.sample2.allcommon.cbean;

import jp.co.np.p2netex.sample2.allcommon.cbean.sqlclause.Sample2OrderByClause;

/**
 * The order-by-bean as interface.
 * 
 * @author DBFlute(AutoGenerator)
 */
public interface Sample2OrderByBean extends Sample2SelectResource {

    /**
     * Get sql component of order-by clause.
     * 
     * @return Sql component of order-by clause. (NotNull)
     */
    public Sample2OrderByClause getSqlComponentOfOrderByClause();

    /**
     * Get order-by clause.
     * 
     * @return Order-by clause. (NotNull)
     */
    public String getOrderByClause();

    /**
     * Clear order-by.
     * 
     * @return this. (NotNull)
     */
    public Sample2OrderByBean clearOrderBy();

    /**
     * Ignore order-by.
     * 
     * @return this. (NotNull)
     */
    public Sample2OrderByBean ignoreOrderBy();

    /**
     * Make order-by effective.
     * 
     * @return this. (NotNull)
     */
    public Sample2OrderByBean makeOrderByEffective();
}
