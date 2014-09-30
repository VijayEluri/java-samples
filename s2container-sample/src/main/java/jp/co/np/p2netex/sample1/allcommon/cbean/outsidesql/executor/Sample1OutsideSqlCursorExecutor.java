package jp.co.np.p2netex.sample1.allcommon.cbean.outsidesql.executor;

import jp.co.np.p2netex.sample1.allcommon.jdbc.Sample1CursorHandler;
import jp.co.np.p2netex.sample1.allcommon.cbean.outsidesql.Sample1OutsideSqlDao;
import jp.co.np.p2netex.sample1.allcommon.cbean.outsidesql.Sample1OutsideSqlOption;
import jp.co.np.p2netex.sample1.allcommon.jdbc.Sample1StatementConfig;

/**
 * The cursor executor of outside-sql.
 * 
 * @param <PARAMETER_BEAN> The type of parameter-bean.
 * @author DBFlute(AutoGenerator)
 */
public class Sample1OutsideSqlCursorExecutor<PARAMETER_BEAN> {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final Sample1OutsideSqlDao _outsideSqlDao;

    protected final Sample1OutsideSqlOption _outsideSqlOption;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample1OutsideSqlCursorExecutor(Sample1OutsideSqlDao outsideSqlDao, Sample1OutsideSqlOption outsideSqlOption) {
        this._outsideSqlDao = outsideSqlDao;
        this._outsideSqlOption = outsideSqlOption;
    }

    // ===================================================================================
    //                                                                              Select
    //                                                                              ======
    public Object selectCursor(String path, PARAMETER_BEAN pmb, Sample1CursorHandler handler) {
        return _outsideSqlDao.selectCursor(path, pmb, _outsideSqlOption, handler);
    }

    // ===================================================================================
    //                                                                              Option
    //                                                                              ======
    public Sample1OutsideSqlCursorExecutor<PARAMETER_BEAN> configure(Sample1StatementConfig statementConfig) {
		_outsideSqlOption.setStatementConfig(statementConfig);
        return this;
    }
	
    public Sample1OutsideSqlCursorExecutor<PARAMETER_BEAN> dynamicBinding() {
        _outsideSqlOption.dynamicBinding();
        return this;
    }
}
