package jp.co.np.p2netex.sample1.allcommon.cbean.outsidesql.executor;

import java.util.List;

import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1ConditionBeanContext;
import jp.co.np.p2netex.sample1.allcommon.cbean.outsidesql.Sample1OutsideSqlDao;
import jp.co.np.p2netex.sample1.allcommon.cbean.outsidesql.Sample1OutsideSqlOption;
import jp.co.np.p2netex.sample1.allcommon.jdbc.Sample1StatementConfig;
import jp.co.np.p2netex.sample1.allcommon.util.Sample1SimpleSystemUtil;

/**
 * The cursor executor of outside-sql.
 * 
 * @param <PARAMETER_BEAN> The type of parameter-bean.
 * @author DBFlute(AutoGenerator)
 */
public class Sample1OutsideSqlEntityExecutor<PARAMETER_BEAN> {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final Sample1OutsideSqlDao _outsideSqlDao;

    protected final Sample1OutsideSqlOption _outsideSqlOption;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample1OutsideSqlEntityExecutor(Sample1OutsideSqlDao outsideSqlDao, Sample1OutsideSqlOption outsideSqlOption) {
        this._outsideSqlDao = outsideSqlDao;
        this._outsideSqlOption = outsideSqlOption;
    }

    // ===================================================================================
    //                                                                              Select
    //                                                                              ======
    /**
     * Select entity.
     * 
     * @param <ENTITY> The type of entity.
     * @param path The path of SQL file. (NotNull)
     * @param pmb The parameter-bean. Allowed types are Bean object and Map object. (Nullable)
     * @param entityType The type of entity. (NotNull)
     * @return The selected entity. (Nullable)
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1OutsideSqlNotFoundException When the sql is not found.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException
     */
    public <ENTITY> ENTITY selectEntity(String path, PARAMETER_BEAN pmb, Class<ENTITY> entityType) {
        final List<ENTITY> ls = _outsideSqlDao.selectList(path, pmb, _outsideSqlOption, entityType);
        if (ls.isEmpty()) {
            return null;
        }
        if (ls.size() > 1) {
            throwEntityDuplicatedException(ls.size() + "", buildSearch4LogString(path, pmb, entityType), null);
        }
        return ls.get(0);
    }

    /**
     * Select entity with deleted check.
     * 
     * @param <ENTITY> The type of entity.
     * @param path The path of SQL file. (NotNull)
     * @param pmb The parameter-bean. Allowed types are Bean object and Map object. (Nullable)
     * @param entityType The type of entity. (NotNull)
     * @return The selected entity. (Nullable)
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1OutsideSqlNotFoundException When the sql is not found.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyDeletedException When the entity has already been deleted(not found).
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity is duplicated.
     */
    public <ENTITY> ENTITY selectEntityWithDeletedCheck(String path, PARAMETER_BEAN pmb, Class<ENTITY> entityType) {
        final List<ENTITY> ls = _outsideSqlDao.selectList(path, pmb, _outsideSqlOption, entityType);
        if (ls == null || ls.isEmpty()) {
            throwEntityAlreadyDeletedException(buildSearch4LogString(path, pmb, entityType));
        }
        if (ls.size() > 1) {
            throwEntityDuplicatedException(ls.size() + "", buildSearch4LogString(path, pmb, entityType), null);
        }
        return ls.get(0);
    }

    protected <ENTITY> String buildSearch4LogString(String path, PARAMETER_BEAN pmb, Class<ENTITY> entityType) {
        String tmp = "Table  = " + _outsideSqlOption.getTableDbName() + getLineSeparator();
        tmp = tmp + "Path   = " + path + getLineSeparator();
        tmp = tmp + "Pmb    = " + (pmb != null ? pmb.getClass().getSimpleName() : "null") + ":" + pmb + getLineSeparator();
        tmp = tmp + "Entity = " + (entityType != null ? entityType.getSimpleName() : "null")  + getLineSeparator();
        tmp = tmp + "Option = " + _outsideSqlOption;
        return tmp;
    }

    // -----------------------------------------------------
    //                                                Helper
    //                                                ------
    protected void throwEntityAlreadyDeletedException(Object searchKey4Log) {
        Sample1ConditionBeanContext.throwEntityAlreadyDeletedException(searchKey4Log);
    }

    protected void throwEntityDuplicatedException(String resultCountString, Object searchKey4Log, Throwable cause) {
        Sample1ConditionBeanContext.throwEntityDuplicatedException(resultCountString, searchKey4Log, cause);
    }

    // ===================================================================================
    //                                                                              Option
    //                                                                              ======
    public Sample1OutsideSqlEntityExecutor<PARAMETER_BEAN> configure(Sample1StatementConfig statementConfig) {
		_outsideSqlOption.setStatementConfig(statementConfig);
        return this;
    }
	
    public Sample1OutsideSqlEntityExecutor<PARAMETER_BEAN> dynamicBinding() {
        _outsideSqlOption.dynamicBinding();
        return this;
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
