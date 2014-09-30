package jp.co.np.p2netex.sample2.allcommon.bhv.batch;

import jp.co.np.p2netex.sample2.allcommon.helper.token.file.Sample2FileTokenizingOption;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample2TokenFileReflectionOption {

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    protected boolean _interruptIfError;

    protected Sample2FileTokenizingOption _fileTokenizingOption = new Sample2FileTokenizingOption();

    // =====================================================================================
    //                                                                           Easy-to-Use
    //                                                                           ===========
    public Sample2TokenFileReflectionOption delimitateByComma() {
        _fileTokenizingOption.delimitateByComma();
        return this;
    }

    public Sample2TokenFileReflectionOption delimitateByTab() {
        _fileTokenizingOption.delimitateByTab();
        return this;
    }

    public Sample2TokenFileReflectionOption encodeAsUTF8() {
        _fileTokenizingOption.encodeAsUTF8();
        return this;
    }

    public Sample2TokenFileReflectionOption encodeAsWindows31J() {
        _fileTokenizingOption.encodeAsWindows31J();
        return this;
    }

    public Sample2TokenFileReflectionOption handleEmptyAsNull() {
        _fileTokenizingOption.handleEmptyAsNull();
        return this;
    }

    public Sample2TokenFileReflectionOption interruptIfError() {
        _interruptIfError = true;
        return this;
    }

    // =====================================================================================
    //                                                                              Accessor
    //                                                                              ========
    public String getDelimiter() {
        return _fileTokenizingOption.getDelimiter();
    }

    public void setDelimiter(String delimiter) {
        _fileTokenizingOption.setDelimiter(delimiter);
    }

    public String getEncoding() {
        return _fileTokenizingOption.getEncoding();
    }

    public void setEncoding(String encoding) {
        _fileTokenizingOption.setDelimiter(encoding);
    }

    public boolean isHandleEmptyAsNull() {
        return _fileTokenizingOption.isHandleEmptyAsNull();
    }

    public boolean isInterruptIfError() {
        return _interruptIfError;
    }
}
