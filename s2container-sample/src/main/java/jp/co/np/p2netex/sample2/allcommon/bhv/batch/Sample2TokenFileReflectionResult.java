package jp.co.np.p2netex.sample2.allcommon.bhv.batch;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample2TokenFileReflectionResult {

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    protected java.util.List<String> _columnNameList;
    protected int _successCount;
    protected java.util.List<Sample2TokenFileReflectionFailure> _failureList;

    // =====================================================================================
    //                                                                           Easy-to-Use
    //                                                                           ===========
    public void incrementSuccessCount() {
        ++_successCount;
    }

    // =====================================================================================
    //                                                                              Accessor
    //                                                                              ========
    public java.util.List<String> getColumnNameList() {
        return _columnNameList;
    }

    public void setColumnNameList(java.util.List<String> columnNameList) {
        this._columnNameList = columnNameList;
    }

    public int getSuccessCount() {
        return _successCount;
    }

    public void setSuccessCount(int successCount) {
        _successCount = successCount;
    }

    public java.util.List<Sample2TokenFileReflectionFailure> getFailureList() {
        return _failureList;
    }

    public void setFailureList(java.util.List<Sample2TokenFileReflectionFailure> failureList) {
        this._failureList = failureList;
    }
}
