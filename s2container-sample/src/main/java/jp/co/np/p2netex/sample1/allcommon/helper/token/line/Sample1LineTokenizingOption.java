package jp.co.np.p2netex.sample1.allcommon.helper.token.line;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample1LineTokenizingOption {

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    protected String _delimiter;

    protected boolean _trimDoubleQuotation;

    protected boolean _handleEmtpyAsNull;

    // =====================================================================================
    //                                                                           Easy-to-Use
    //                                                                           ===========
    public Sample1LineTokenizingOption delimitateByComma() {
        _delimiter = ",";
        return this;
    }

    public Sample1LineTokenizingOption delimitateByTab() {
        _delimiter = "\t";
        return this;
    }

    public Sample1LineTokenizingOption trimDoubleQuotation() {
        _trimDoubleQuotation = true;
        return this;
    }

    public Sample1LineTokenizingOption handleEmtpyAsNull() {
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