package jp.co.np.p2netex.sample1.allcommon.bhv.batch;

import jp.co.np.p2netex.sample1.allcommon.helper.token.file.Sample1FileTokenizingOption;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample1TokenFileReflectionOption {

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    protected boolean _interruptIfError;

    protected Sample1FileTokenizingOption _fileTokenizingOption = new Sample1FileTokenizingOption();

    // =====================================================================================
    //                                                                           Easy-to-Use
    //                                                                           ===========
    public Sample1TokenFileReflectionOption delimitateByComma() {
        _fileTokenizingOption.delimitateByComma();
        return this;
    }

    public Sample1TokenFileReflectionOption delimitateByTab() {
        _fileTokenizingOption.delimitateByTab();
        return this;
    }

    public Sample1TokenFileReflectionOption encodeAsUTF8() {
        _fileTokenizingOption.encodeAsUTF8();
        return this;
    }

    public Sample1TokenFileReflectionOption encodeAsWindows31J() {
        _fileTokenizingOption.encodeAsWindows31J();
        return this;
    }

    public Sample1TokenFileReflectionOption handleEmptyAsNull() {
        _fileTokenizingOption.handleEmptyAsNull();
        return this;
    }

    public Sample1TokenFileReflectionOption interruptIfError() {
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
