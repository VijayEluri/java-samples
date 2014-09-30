package jp.co.np.p2netex.sample2.allcommon.cbean.outsidesql;

import jp.co.np.p2netex.sample2.allcommon.jdbc.Sample2StatementConfig;

/**
 * The option of outside-SQL. It contains various information about execution.
 * @author DBFlute(AutoGenerator)
 */
public class Sample2OutsideSqlOption {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                                Option
    //                                                ------
    protected String _pagingRequestType = "non";

    protected boolean _dynamicBinding;

	/** The configuration of statement. (Nullable) */
	protected Sample2StatementConfig _statementConfig;
	
    // -----------------------------------------------------
    //                                           Information
    //                                           -----------
	/** The DB name of table. It is not related with the options of outside-SQL. */
    protected String _tableDbName;
	
    // ===================================================================================
    //                                                                         Easy-to-Use
    //                                                                         ===========
    public void autoPaging() {
        _pagingRequestType = "auto";
    }

    public void manualPaging() {
        _pagingRequestType = "manual";
    }

    public void dynamicBinding() {
        _dynamicBinding = true;
    }

    // ===================================================================================
    //                                                                          Unique Key
    //                                                                          ==========
    public String generateUniqueKey() {
        return "{" + _pagingRequestType + "/" + _dynamicBinding + "}";
    }

    // ===================================================================================
    //                                                                                Copy
    //                                                                                ====
    public Sample2OutsideSqlOption copyOptionWithoutPaging() {
        final Sample2OutsideSqlOption copyOption = new Sample2OutsideSqlOption();
        if (isDynamicBinding()) {
            copyOption.dynamicBinding();
        }
		copyOption.setTableDbName(_tableDbName);
        return copyOption;
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    public String toString() {
        return "{paging=" + _pagingRequestType + ", dynamic=" + _dynamicBinding + "}";
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    // -----------------------------------------------------
    //                                                Option
    //                                                ------
    public boolean isAutoPaging() {
        return "auto".equals(_pagingRequestType);
    }

    public boolean isManualPaging() {
        return "manual".equals(_pagingRequestType);
    }

    public boolean isDynamicBinding() {
        return _dynamicBinding;
    }
	
    public Sample2StatementConfig getStatementConfig() {
        return _statementConfig;
    }

    public void setStatementConfig(Sample2StatementConfig statementConfig) {
        _statementConfig = statementConfig;
    }
	
    // -----------------------------------------------------
    //                                           Information
    //                                           -----------
    public String getTableDbName() {
        return _tableDbName;
    }

    public void setTableDbName(String tableDbName) {
        _tableDbName = tableDbName;
    }
}
