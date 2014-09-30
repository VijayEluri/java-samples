package jp.co.np.p2netex.sample1.allcommon.helper.token.line;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample1LineMakingOption {

    protected String _delimiter;

    protected boolean _quoteByDoubleQuotation;

    protected boolean _trimSpace;

    public Sample1LineMakingOption delimitateByComma() {
        _delimiter = ",";
        return this;
    }

    public Sample1LineMakingOption delimitateByTab() {
        _delimiter = "\t";
        return this;
    }

    public String getDelimiter() {
        return _delimiter;
    }

    public void setDelimiter(String delimiter) {
        _delimiter = delimiter;
    }

    public Sample1LineMakingOption quoteByDoubleQuotation() {
        _quoteByDoubleQuotation = true;
        return this;
    }

    public boolean isQuoteByDoubleQuotation() {
        return _quoteByDoubleQuotation;
    }

    public Sample1LineMakingOption trimSpace() {
        _trimSpace = true;
        return this;
    }

    public boolean isTrimSpace() {
        return _trimSpace;
    }
}