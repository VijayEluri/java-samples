package jp.co.np.p2netex.sample2.allcommon.bhv.batch;

import jp.co.np.p2netex.sample2.allcommon.helper.token.file.Sample2FileMakingOption;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample2TokenFileOutputOption {

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    protected Sample2FileMakingOption _fileMakingOption = new Sample2FileMakingOption();

    // =====================================================================================
    //                                                                           Easy-to-Use
    //                                                                           ===========
    public Sample2TokenFileOutputOption delimitateByComma() {
        _fileMakingOption.delimitateByComma();
        return this;
    }

    public Sample2TokenFileOutputOption delimitateByTab() {
        _fileMakingOption.delimitateByTab();
        return this;
    }

    public Sample2TokenFileOutputOption encodeAsUTF8() {
        _fileMakingOption.encodeAsUTF8();
        return this;
    }

    public Sample2TokenFileOutputOption encodeAsWindows31J() {
        _fileMakingOption.encodeAsWindows31J();
        return this;
    }

    public Sample2TokenFileOutputOption separateCrLf() {
        _fileMakingOption.separateCrLf();
        return this;
    }

    public Sample2TokenFileOutputOption separateLf() {
        _fileMakingOption.separateLf();
        return this;
    }

    public Sample2TokenFileOutputOption goodByeDoubleQuotation() {
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

    public Sample2FileMakingOption getFileMakingOption() {
        return _fileMakingOption;
    }
}
