package jp.co.np.p2netex.sample2.allcommon.cbean.outsidesql.executor;

import java.util.List;

import jp.co.np.p2netex.sample2.allcommon.Sample2DBFluteConfig;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2PagingBean;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2PagingHandler;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2PagingInvoker;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2PagingResultBean;
import jp.co.np.p2netex.sample2.allcommon.cbean.outsidesql.Sample2OutsideSqlDao;
import jp.co.np.p2netex.sample2.allcommon.cbean.outsidesql.Sample2OutsideSqlOption;
import jp.co.np.p2netex.sample2.allcommon.jdbc.Sample2StatementConfig;

/**
 * The paging executor of outsideSql.
 * @author DBFlute(AutoGenerator)
 */
public class Sample2OutsideSqlPagingExecutor {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The DAO of outsideSql. (NotNull) */
    protected final Sample2OutsideSqlDao _outsideSqlDao;

    /** The option of outsideSql. (NotNull) */
    protected final Sample2OutsideSqlOption _outsideSqlOption;

    /** The DB name of table. (NotNull) */
    protected final String _tableDbName;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample2OutsideSqlPagingExecutor(Sample2OutsideSqlDao outsideSqlDao, Sample2OutsideSqlOption outsideSqlOption, String tableDbName) {
        this._outsideSqlDao = outsideSqlDao;
        this._outsideSqlOption = outsideSqlOption;
        this._tableDbName = tableDbName;
    }

    // ===================================================================================
    //                                                                              Select
    //                                                                              ======
    public <ENTITY> List<ENTITY> selectList(String path, Sample2PagingBean pmb, Class<ENTITY> entityType) {
        setupScrollableCursorIfNeeds();
        return _outsideSqlDao.selectList(path, pmb, _outsideSqlOption, entityType);
    }

    /**
     * Select page.
     * <p>
     * The SQL should have Count and Paging. <br />
     * You can realize by pagingBean's isPaging() method on your 'SQL Comment'. For example, 'IF Comment'. <br />
     * It returns false when it executes Count. And it returns true when it executes Paging. <br />
     * <pre>
     * - - - - - - - - - - - - - - - - - - - - - - -
     * ex) Your Correct SQL {MySQL and manualPaging}
     * - - - - - - - - - - - - - - - - - - - - - - -
     * # /[*]IF pmb.isPaging()[*]/
     * # select member.MEMBER_ID
     * #      , member.MEMBER_NAME
     * #      , memberStatus.MEMBER_STATUS_NAME
     * # -- ELSE select count(*)
     * # /[*]END[*]/
     * #   from MEMBER member
     * #     /[*]IF pmb.isPaging()[*]/
     * #     left outer join MEMBER_STATUS memberStatus
     * #       on member.MEMBER_STATUS_CODE = memberStatus.MEMBER_STATUS_CODE
     * #     /[*]END[*]/
     * #  /[*]BEGIN[*]/where
     * #    /[*]IF pmb.memberId != null[*]/member.MEMBER_ID = /[*]pmb.memberId[*]/'123'/[*]END[*]/
     * #    /[*]IF pmb.memberName != null[*]/and member.MEMBER_NAME like /[*]pmb.memberName[*]/'Billy' || '%'/[*]END[*]/
     * #  /[*]END[*]/
     * #  /[*]IF pmb.isPaging()[*]/
     * #  order by member.UPDATE_DATETIME desc
     * #  /[*]END[*]/
     * #  /[*]IF pmb.isPaging()[*]/
     * #  limit /[*]$pmb.pageStartIndex[*]/80, /[*]$pmb.fetchSize[*]/20
     * #  /[*]END[*]/
     * # 
     * o [*] is easy escape to Java Doc Comment.
     * o If it's autoPaging, the line of 'limit 80, 20' is unnecessary!
     * 
     * - - - - - - - - - - - - - - - - - - - - - - - - -
     * ex) Wrong SQL {part 1}
     *     -- Line comment before ELSE comment --
     * - - - - - - - - - - - - - - - - - - - - - - - - -
     * # /[*]IF pmb.isPaging()[*]/
     * # select member.MEMBER_ID
     * #      , member.MEMBER_NAME -- The name of member...    *NG
     * #      -- The status name of member...                  *NG
     * #      , memberStatus.MEMBER_STATUS_NAME
     * # -- ELSE select count(*)
     * # /[*]END[*]/
     * # ...
     * o It's S2Dao's restriction...Sorry
     * </pre>
     * @param <ENTITY> The type of entity.
     * @param path The path of SQL that executes count and paging. (NotNull)
     * @param pagingPath The path of paging SQL. (NotNull)
     * @param pmb The bean of paging parameter. (NotNull)
     * @param entityType The type of result entity. (NotNull)
     * @return The result bean of paging. (NotNull)
     */
    public <ENTITY> Sample2PagingResultBean<ENTITY> selectPage(final String path
                                                               , final Sample2PagingBean pmb
                                                               , final Class<ENTITY> entityType) {
        final Sample2OutsideSqlOption countOption = _outsideSqlOption.copyOptionWithoutPaging();
        final Sample2OutsideSqlEntityExecutor<Sample2PagingBean> countExecutor = new Sample2OutsideSqlEntityExecutor<Sample2PagingBean>(_outsideSqlDao, countOption);
        final Sample2PagingHandler<ENTITY> handler = new Sample2PagingHandler<ENTITY>() {
            public Sample2PagingBean getPagingBean() {
                return pmb;
            }
            public int count() {
                pmb.xsetPaging(false);
                return countExecutor.selectEntityWithDeletedCheck(path, pmb, Integer.class);
            }
            public java.util.List<ENTITY> paging() {
                pmb.xsetPaging(true);
				setupScrollableCursorIfNeeds();
                return selectList(path, pmb, entityType);
            }
        };
        final Sample2PagingInvoker<ENTITY>  invoker = new Sample2PagingInvoker<ENTITY>(_tableDbName);
        return invoker.invokePaging(handler);
    }
    
    protected void setupScrollableCursorIfNeeds() {
        if (!_outsideSqlOption.isAutoPaging()) {
            return;
        }
        Sample2StatementConfig statementConfig = _outsideSqlOption.getStatementConfig();
        if (statementConfig != null && statementConfig.getResultSetType() != null) {
            return;
        }
        Sample2StatementConfig defaultStatementConfig = Sample2DBFluteConfig.getInstance().getDefaultStatementConfig();
        if (defaultStatementConfig != null && defaultStatementConfig.hasResultSetType()) {
            return;
        }
        if (statementConfig == null) {
            statementConfig = new Sample2StatementConfig();
            configure(statementConfig);
        }
        statementConfig.typeScrollInsensitive();
    }
	
    // ===================================================================================
    //                                                                              Option
    //                                                                              ======
    public Sample2OutsideSqlCursorExecutor<Sample2PagingBean> cursorHandling() {
        return new Sample2OutsideSqlCursorExecutor<Sample2PagingBean>(_outsideSqlDao, _outsideSqlOption);
    }
	
    public Sample2OutsideSqlPagingExecutor configure(Sample2StatementConfig statementConfig) {
		_outsideSqlOption.setStatementConfig(statementConfig);
        return this;
    }

    public Sample2OutsideSqlPagingExecutor dynamicBinding() {
        _outsideSqlOption.dynamicBinding();
        return this;
    }
}
