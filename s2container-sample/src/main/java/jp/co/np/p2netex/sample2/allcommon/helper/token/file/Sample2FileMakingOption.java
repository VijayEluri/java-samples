package jp.co.np.p2netex.sample2.allcommon.helper.token.file;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample2FileMakingOption {

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    /** Encoding. (Required) */
    protected String _encoding;

    /** Delimiter. (Required) */
    protected String _delimiter;

    /** Line separator. (NotRequired) */
    protected String _lineSeparator;

    /** Good bye double quotation. (NotRequired) */
    protected boolean _goodByeDoubleQuotation;

    /** File-making header information. (NotRequired) */
    protected Sample2FileMakingHeaderInfo _fileMakingHeaderInfo;

    // =====================================================================================
    //                                                                           Easy-to-Use
    //                                                                           ===========
    public Sample2FileMakingOption delimitateByComma() {
        _delimiter = ",";
        return this;
    }

    public Sample2FileMakingOption delimitateByTab() {
        _delimiter = "\t";
        return this;
    }

    public Sample2FileMakingOption encodeAsUTF8() {
        _encoding = "UTF-8";
        return this;
    }

    public Sample2FileMakingOption encodeAsWindows31J() {
        _encoding = "Windows-31J";
        return this;
    }

    public Sample2FileMakingOption separateCrLf() {
        _lineSeparator = "\r\n";
        return this;
    }

    public Sample2FileMakingOption separateLf() {
        _lineSeparator = "\n";
        return this;
    }

    public Sample2FileMakingOption goodByeDoubleQuotation() {
        _goodByeDoubleQuotation = true;
        return this;
    }

    // =====================================================================================
    //                                                                              Accessor
    //                                                                              ========
    public String getEncoding() {
        return _encoding;
    }

    public void setEncoding(String encoding) {
        _encoding = encoding;
    }

    public String getDelimiter() {
        return _delimiter;
    }

    public void setDelimiter(String delimiter) {
        _delimiter = delimiter;
    }

    public String getLineSeparator() {
        return _lineSeparator;
    }

    public void setLineSeparator(String lineSeparator) {
        _lineSeparator = lineSeparator;
    }

    public boolean isGoodByeDoubleQuotation() {
        return _goodByeDoubleQuotation;
    }

    public Sample2FileMakingHeaderInfo getFileMakingHeaderInfo() {
        return _fileMakingHeaderInfo;
    }

    public void setFileMakingHeaderInfo(Sample2FileMakingHeaderInfo fileMakingHeaderInfo) {
        _fileMakingHeaderInfo = fileMakingHeaderInfo;
    }

}