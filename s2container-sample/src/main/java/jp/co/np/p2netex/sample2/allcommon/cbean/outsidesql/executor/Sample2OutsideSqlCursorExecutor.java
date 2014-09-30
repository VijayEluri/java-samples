package jp.co.np.p2netex.sample2.allcommon.cbean.outsidesql.executor;

import jp.co.np.p2netex.sample2.allcommon.jdbc.Sample2CursorHandler;
import jp.co.np.p2netex.sample2.allcommon.cbean.outsidesql.Sample2OutsideSqlDao;
import jp.co.np.p2netex.sample2.allcommon.cbean.outsidesql.Sample2OutsideSqlOption;
import jp.co.np.p2netex.sample2.allcommon.jdbc.Sample2StatementConfig;

/**
 * The cursor executor of outside-sql.
 * 
 * @param <PARAMETER_BEAN> The type of parameter-bean.
 * @author DBFlute(AutoGenerator)
 */
public class Sample2OutsideSqlCursorExecutor<PARAMETER_BEAN> {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final Sample2OutsideSqlDao _outsideSqlDao;

    protected final Sample2OutsideSqlOption _outsideSqlOption;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample2OutsideSqlCursorExecutor(Sample2OutsideSqlDao outsideSqlDao, Sample2OutsideSqlOption outsideSqlOption) {
        this._outsideSqlDao = outsideSqlDao;
        this._outsideSqlOption = outsideSqlOption;
    }

    // ===================================================================================
    //                                                                              Select
    //                                                                              ======
    public Object selectCursor(String path, PARAMETER_BEAN pmb, Sample2CursorHandler handler) {
        return _outsideSqlDao.selectCursor(path, pmb, _outsideSqlOption, handler);
    }

    // ===================================================================================
    //                                                                              Option
    //                                                                              ======
    public Sample2OutsideSqlCursorExecutor<PARAMETER_BEAN> configure(Sample2StatementConfig statementConfig) {
		_outsideSqlOption.setStatementConfig(statementConfig);
        return this;
    }
	
    public Sample2OutsideSqlCursorExecutor<PARAMETER_BEAN> dynamicBinding() {
        _outsideSqlOption.dynamicBinding();
        return this;
    }
}
