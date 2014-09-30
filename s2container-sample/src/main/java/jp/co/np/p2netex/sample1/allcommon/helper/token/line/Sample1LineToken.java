package jp.co.np.p2netex.sample1.allcommon.helper.token.line;

/**
 * @author DBFlute(AutoGenerator)
 */
public interface Sample1LineToken {

    public java.util.List<String> tokenize(String lineString, Sample1LineTokenizingOption lineTokenizingOption);

    public String make(java.util.List<String> valueList, Sample1LineMakingOption lineMakingOption);
}