package jp.co.np.p2netex.sample1.allcommon.bhv.batch;

import jp.co.np.p2netex.sample1.allcommon.helper.token.file.Sample1FileMakingOption;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample1TokenFileOutputOption {

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    protected Sample1FileMakingOption _fileMakingOption = new Sample1FileMakingOption();

    // =====================================================================================
    //                                                                           Easy-to-Use
    //                                                                           ===========
    public Sample1TokenFileOutputOption delimitateByComma() {
        _fileMakingOption.delimitateByComma();
        return this;
    }

    public Sample1TokenFileOutputOption delimitateByTab() {
        _fileMakingOption.delimitateByTab();
        return this;
    }

    public Sample1TokenFileOutputOption encodeAsUTF8() {
        _fileMakingOption.encodeAsUTF8();
        return this;
    }

    public Sample1TokenFileOutputOption encodeAsWindows31J() {
        _fileMakingOption.encodeAsWindows31J();
        return this;
    }

    public Sample1TokenFileOutputOption separateCrLf() {
        _fileMakingOption.separateCrLf();
        return this;
    }

    public Sample1TokenFileOutputOption separateLf() {
        _fileMakingOption.separateLf();
        return this;
    }

    public Sample1TokenFileOutputOption goodByeDoubleQuotation() {
        _fileMakingOption.goodByeDoubleQuotation();
        return this;
    }

    // =====================================================================================
    //                                                                              Accessor
    //                                                                              ========
    public String getEncoding() {
        return _fileMakingOption.getEncoding();
    }

    public void setEncoding(String encoding) {
        _fileMakingOption.setDelimiter(encoding);
    }

    public String getDelimiter() {
        return _fileMakingOption.getDelimiter();
    }

    public void setDelimiter(String delimiter) {
        _fileMakingOption.setDelimiter(delimiter);
    }

    public String getLineSeparator() {
        return _fileMakingOption.getLineSeparator();
    }

    public void setLineSeparator(String lineSeparator) {
        _fileMakingOption.setLineSeparator(lineSeparator);
    }

    public boolean isGoodByeDoubleQuotation() {
        return _fileMakingOption.isGoodByeDoubleQuotation();
    }

    public Sample1FileMakingOption getFileMakingOption() {
        return _fileMakingOption;
    }
}
