package jp.co.np.p2netex.sample2.allcommon.bhv;

import jp.co.np.p2netex.sample2.allcommon.Sample2DaoReadable;
import jp.co.np.p2netex.sample2.allcommon.Sample2Entity;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2ConditionBean;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2ListResultBean;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2PagingResultBean;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.Sample2DBMeta;

/**
 * The interface of behavior-readable.
 * 
 * @author DBFlute(AutoGenerator)
 */
public interface Sample2BehaviorReadable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Map-string map-mark. */
    public static final String MAP_STRING_MAP_MARK = "map:";

    /** Map-string list-mark. */
    public static final String MAP_STRING_LIST_MARK = "list:";

    /** Map-string start-brace. */
    public static final String MAP_STRING_START_BRACE = "@{";

    /** Map-string end-brace. */
    public static final String MAP_STRING_END_BRACE = "@}";

    /** Map-string delimiter. */
    public static final String MAP_STRING_DELIMITER = "@;";

    /** Map-string equal. */
    public static final String MAP_STRING_EQUAL = "@=";

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /**
     * Get table db-name.
     * @return Table db-name. (NotNull)
     */
    public String getTableDbName();

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /**
     * Get dbmeta.
     * @return DBMeta. (NotNull)
     */
    public Sample2DBMeta getDBMeta();

    // ===================================================================================
    //                                                                        Dao Accessor
    //                                                                        ============
    /**
     * Get dao-readable.
     * @return Dao-readable. (NotNull)
     */
    public Sample2DaoReadable getDaoReadable();

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /**
     * New entity.
     * @return Entity. (NotNull)
     */
    public Sample2Entity newEntity();

    /**
     * New condition-bean.
     * @return Condition-bean. (NotNull)
     */
    public Sample2ConditionBean newConditionBean();

    // ===================================================================================
    //                                                                       Basic Get All
    //                                                                       =============
    /**
     * Get count all.
     * @return Count all.
     */
    public int getCountAll();

    // ===================================================================================
    //                                                                    Basic Read Count
    //                                                                    ================
    /**
     * Read count by condition-bean.
     * <pre>
     * If the argument 'condition-bean' is effective about fetch-scope,
     * this method invoke select count ignoring the fetch-scope.
     * </pre>
     * @param cb Condition-bean. This condition-bean should not be set up about fetch-scope. (NotNull)
     * @return Read count. (NotNull)
     */
    public int readCount(Sample2ConditionBean cb);

    // ===================================================================================
    //                                                                   Basic Read Entity
    //                                                                   =================
    /**
     * Read entity by condition-bean.
     * @param cb Condition-bean. (NotNull)
     * @return Read entity. (Nullalble)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     */
    public Sample2Entity readEntity(Sample2ConditionBean cb);

    /**
     * Read simple entity by condition-bean with deleted check.
     * @param cb Condition-bean. (NotNull)
     * @return Read entity. (NotNull)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     */
    public Sample2Entity readEntityWithDeletedCheck(Sample2ConditionBean cb);

    // ===================================================================================
    //                                                                     Basic Read List
    //                                                                     ===============
    /**
     * Read list as result-bean.
     * @param cb Condition-bean. (NotNull)
     * @return List-result-bean. If the select result is zero, it returns empty list. (NotNull)
     */
    public Sample2ListResultBean<Sample2Entity> readList(Sample2ConditionBean cb);

    /**
     * Read page as result-bean.
     * @param cb Condition-bean. (NotNull)
     * @return Read page. (NotNull)
     */
    public Sample2PagingResultBean<Sample2Entity> readPage(final Sample2ConditionBean cb);

    // ===================================================================================
    //                                                                            Sequence
    //                                                                            ========
    /**
     * The implementation.
     * @return The value of sequence. (NotNull)
     */
    public java.math.BigDecimal readNextVal();
}
