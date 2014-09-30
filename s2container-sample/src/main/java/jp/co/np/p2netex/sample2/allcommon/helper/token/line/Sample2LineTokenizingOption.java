package jp.co.np.p2netex.sample2.allcommon.helper.token.line;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample2LineTokenizingOption {

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    protected String _delimiter;

    protected boolean _trimDoubleQuotation;

    protected boolean _handleEmtpyAsNull;

    // =====================================================================================
    //                                                                           Easy-to-Use
    //                                                                           ===========
    public Sample2LineTokenizingOption delimitateByComma() {
        _delimiter = ",";
        return this;
    }

    public Sample2LineTokenizingOption delimitateByTab() {
        _delimiter = "\t";
        return this;
    }

    public Sample2LineTokenizingOption trimDoubleQuotation() {
        _trimDoubleQuotation = true;
        return this;
    }

    public Sample2LineTokenizingOption handleEmtpyAsNull() {
        _handleEmtpyAsNull = true;
        return this;
    }

    // =====================================================================================
    //                                                                              Accessor
    //                                                                              ========
    public String getDelimiter() {
        return _delimiter;
    }

    public void setDelimiter(String delimiter) {
        _delimiter = delimiter;
    }

    public boolean isTrimDoubleQuotation() {
        return _trimDoubleQuotation;
    }

    public boolean isHandleEmtpyAsNull() {
        return _handleEmtpyAsNull;
    }
}