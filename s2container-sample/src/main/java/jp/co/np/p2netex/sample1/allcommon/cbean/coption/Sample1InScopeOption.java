package jp.co.np.p2netex.sample1.allcommon.cbean.coption;


import jp.co.np.p2netex.sample1.allcommon.cbean.coption.parts.local.Sample1JapaneseOptionPartsAgent;

/**
 * The class of in-scope-option.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class Sample1InScopeOption extends Sample1SimpleStringOption {

    // =====================================================================================
    //                                                                                 Split
    //                                                                                 =====
    public Sample1InScopeOption splitBySpace() {
        return (Sample1InScopeOption)doSplitBySpace();
    }

    public Sample1InScopeOption splitBySpace(int splitLimitCount) {
        return (Sample1InScopeOption)doSplitBySpace(splitLimitCount);
    }

    public Sample1InScopeOption splitBySpaceContainsDoubleByte() {
        return (Sample1InScopeOption)doSplitBySpaceContainsDoubleByte();
    }

    public Sample1InScopeOption splitBySpaceContainsDoubleByte(int splitLimitCount) {
        return (Sample1InScopeOption)doSplitBySpaceContainsDoubleByte(splitLimitCount);
    }

    public Sample1InScopeOption splitByPipeLine() {
        return (Sample1InScopeOption)doSplitByPipeLine();
    }

    public Sample1InScopeOption splitByPipeLine(int splitLimitCount) {
        return (Sample1InScopeOption)doSplitByPipeLine(splitLimitCount);
    }

    // =====================================================================================
    //                                                                   To Upper/Lower Case
    //                                                                   ===================
    public Sample1InScopeOption toUpperCase() {
        return (Sample1InScopeOption)doToUpperCase();
    }

    public Sample1InScopeOption toLowerCase() {
        return (Sample1InScopeOption)doToLowerCase();
    }

    // =====================================================================================
    //                                                                        To Single Byte
    //                                                                        ==============
    public Sample1InScopeOption toSingleByteSpace() {
        return (Sample1InScopeOption)doToSingleByteSpace();
    }

    public Sample1InScopeOption toSingleByteAlphabetNumber() {
        return (Sample1InScopeOption)doToSingleByteAlphabetNumber();
    }

    public Sample1InScopeOption toSingleByteAlphabetNumberMark() {
        return (Sample1InScopeOption)doToSingleByteAlphabetNumberMark();
    }

    // =====================================================================================
    //                                                                        To Double Byte
    //                                                                        ==============

    // =====================================================================================
    //                                                                              Japanese
    //                                                                              ========
    public Sample1JapaneseOptionPartsAgent localJapanese() {
        return doLocalJapanese();
    }

    // =====================================================================================
    //                                                                            Real Value
    //                                                                            ==========
    public java.util.List<String> generateRealValueList(java.util.List<String> valueList) {
        final java.util.List<String> resultList = new java.util.ArrayList<String>();
        for (final java.util.Iterator<String> ite = valueList.iterator(); ite.hasNext(); ) {
            final String value = ite.next();
            resultList.add(generateRealValue(value));
        }
        return resultList;
    }
}
