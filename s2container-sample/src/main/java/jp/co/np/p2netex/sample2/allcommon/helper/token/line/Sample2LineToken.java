package jp.co.np.p2netex.sample2.allcommon.helper.token.line;

/**
 * @author DBFlute(AutoGenerator)
 */
public interface Sample2LineToken {

    public java.util.List<String> tokenize(String lineString, Sample2LineTokenizingOption lineTokenizingOption);

    public String make(java.util.List<String> valueList, Sample2LineMakingOption lineMakingOption);
}