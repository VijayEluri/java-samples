package jp.co.np.p2netex.sample1.allcommon.cbean.outsidesql.executor;

import java.util.List;

import jp.co.np.p2netex.sample1.allcommon.cbean.outsidesql.Sample1OutsideSqlDao;
import jp.co.np.p2netex.sample1.allcommon.cbean.outsidesql.Sample1OutsideSqlOption;
import jp.co.np.p2netex.sample1.allcommon.cbean.outsidesql.Sample1ProcedurePmb;
import jp.co.np.p2netex.sample1.allcommon.jdbc.Sample1StatementConfig;

/**
 * The executor of outside-sql. <br />
 * <pre>
 * {Basic}
 *   o selectList()
 *   o execute()
 *   o call()
 * 
 * {Entity}
 *   o entityHandling().selectEntity()
 *   o entityHandling().selectEntityWithDeletedCheck()
 * 
 * {Cursor}
 *   o cursorHandling().selectCursor()
 * 
 * {Paging}
 *   o autoPaging().selectList()
 *   o autoPaging().selectPage()
 *   o manualPaging().selectList()
 *   o manualPaging().selectPage()
 * 
 * {Option -- Dynamic}
 *   o dynamicBinding().selectList()
 * 
 * </pre>
 * 
 * @author DBFlute(AutoGenerator)
 */
public class Sample1OutsideSqlBasicExecutor {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The DAO of outside-sql. (NotNull) */
    protected final Sample1OutsideSqlDao _outsideSqlDao;

    /** Table DB name. (NotNull) */
    protected final String _tableDbName;

    /** Is it dynamic binding? */
    protected boolean _dynamicBinding;
	
	/** The config of statement. (Nullable) */
	protected Sample1StatementConfig _statementConfig;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample1OutsideSqlBasicExecutor(Sample1OutsideSqlDao outsideSqlDao, String tableDbName) {
        this._outsideSqlDao = outsideSqlDao;
        this._tableDbName = tableDbName;
    }

    // ===================================================================================
    //                                                                              Select
    //                                                                              ======
    /**
     * Select the list of the entity.
     * @param <ENTITY> The type of entity for element.
     * @param path The path of SQL file. (NotNull)
     * @param pmb The parameter-bean. Allowed types are Bean object and Map object. (Nullable)
     * @param entityType The element type of entity. (NotNull)
     * @return The list of selected entity. (NotNull)
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1OutsideSqlNotFoundException When the sql is not found.
     */
    public <ENTITY> List<ENTITY> selectList(String path, Object pmb, Class<ENTITY> entityType) {
        return _outsideSqlDao.selectList(path, pmb, createOutsideSqlOption(), entityType);
    }

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    /**
     * Execute. {Insert/Update/Delete/Etc...}
     * @param path The path of SQL file. (NotNull)
     * @param pmb The parameter-bean. Allowed types are Bean object and Map object. (Nullable)
     * @return The count of execution.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1OutsideSqlNotFoundException When the sql is not found.
     */
    public int execute(String path, Object pmb) {
        return _outsideSqlDao.execute(path, pmb, createOutsideSqlOption());
    }

    // [DBFlute-0.7.5]
    // ===================================================================================
    //                                                                      Procedure Call
    //                                                                      ==============
    /**
     * Call stored procedure.
     * @param pmb The parameter-bean for procedure. (NotNull)
     */
    public void call(Sample1ProcedurePmb pmb) {
        if (pmb == null) { throw new IllegalArgumentException("The argument of call() 'pmb' should not be null!"); }
        _outsideSqlDao.call(pmb.getProcedureName(), pmb, createOutsideSqlOption());
    }

    // ===================================================================================
    //                                                                              Option
    //                                                                              ======
    // -----------------------------------------------------
    //                                       Result Handling
    //                                       ---------------
    /**
     * Specify cursor handling. <br />
     * <pre>
     * # ex) Your Program
     * #
     * # executor.cursorHandling().selectCursor(path, pmb, handler);
     * #
     * </pre>
     * @return The cursor executor of outside-sql. (NotNull)
     */
    public Sample1OutsideSqlCursorExecutor<Object> cursorHandling() {
        return new Sample1OutsideSqlCursorExecutor<Object>(_outsideSqlDao, createOutsideSqlOption());
    }

    /**
     * Specify entity handling. <br />
     * <pre>
     * # ex) Your Program
     * #
     * # executor.entityHandling().selectEntityWithDeletedCheck(path, pmb, Xxx.class);
     * #
     * </pre>
     * @return The cursor executor of outside-sql. (NotNull)
     */
    public Sample1OutsideSqlEntityExecutor<Object> entityHandling() {
        return new Sample1OutsideSqlEntityExecutor<Object>(_outsideSqlDao, createOutsideSqlOption());
    }

    // -----------------------------------------------------
    //                                                Paging
    //                                                ------
    /**
     * Option of autoPaging. <br />
     * If you invoke this, you don't need to write paging condition on your SQL. <br />
     * <pre>
     * # ex) Your SQL {MySQL}
     * #
     * # select member.MEMBER_ID, member...
     * #   from Member member
     * #  where ...
     * #  order by ...
     * # -- limit 40, 20        *Here is unnecessary!
     * #
     * </pre>
     * @return The executor of paging that the paging mode is auto. (NotNull)
     */
    public Sample1OutsideSqlPagingExecutor autoPaging() {
        final Sample1OutsideSqlOption option = createOutsideSqlOption();
        option.autoPaging();
        return new Sample1OutsideSqlPagingExecutor(_outsideSqlDao, option, _tableDbName);
    }

    /**
     * Option of manualPaging. <br />
     * If you invoke this, you need to write paging condition on your SQL. <br />
     * <pre>
     * # ex) Your SQL {MySQL}
     * #
     * # select member.MEMBER_ID, member...
     * #   from Member member
     * #  where ...
     * #  order by ...
     * #  limit 40, 20        *Here is necessary!
     * #
     * </pre>
     * @return The executor of paging that the paging mode is manual. (NotNull)
     */
    public Sample1OutsideSqlPagingExecutor manualPaging() {
        final Sample1OutsideSqlOption option = createOutsideSqlOption();
        option.manualPaging();
        return new Sample1OutsideSqlPagingExecutor(_outsideSqlDao, option, _tableDbName);
    }

    // -----------------------------------------------------
    //                                       Dynamic Binding
    //                                       ---------------
    public Sample1OutsideSqlBasicExecutor dynamicBinding() {
        _dynamicBinding = true;
        return this;
    }

    // -----------------------------------------------------
    //                                      Statement Config
    //                                      ----------------
    public Sample1OutsideSqlBasicExecutor configure(Sample1StatementConfig statementConfig) {
        _statementConfig = statementConfig;
        return this;
    }
	
    // ===================================================================================
    //                                                                       Assist Helper
    //                                                                       =============
    protected Sample1OutsideSqlOption createOutsideSqlOption() {
        final Sample1OutsideSqlOption option = new Sample1OutsideSqlOption();
		option.setStatementConfig(_statementConfig);
        if (_dynamicBinding) {
            option.dynamicBinding();
        }
		option.setTableDbName(_tableDbName);// as information
        return option;
    }
}
