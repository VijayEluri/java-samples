package jp.co.np.p2netex.sample2.allcommon.cbean.coption;


import jp.co.np.p2netex.sample2.allcommon.cbean.coption.parts.local.Sample2JapaneseOptionPartsAgent;

/**
 * The class of in-scope-option.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class Sample2InScopeOption extends Sample2SimpleStringOption {

    // =====================================================================================
    //                                                                                 Split
    //                                                                                 =====
    public Sample2InScopeOption splitBySpace() {
        return (Sample2InScopeOption)doSplitBySpace();
    }

    public Sample2InScopeOption splitBySpace(int splitLimitCount) {
        return (Sample2InScopeOption)doSplitBySpace(splitLimitCount);
    }

    public Sample2InScopeOption splitBySpaceContainsDoubleByte() {
        return (Sample2InScopeOption)doSplitBySpaceContainsDoubleByte();
    }

    public Sample2InScopeOption splitBySpaceContainsDoubleByte(int splitLimitCount) {
        return (Sample2InScopeOption)doSplitBySpaceContainsDoubleByte(splitLimitCount);
    }

    public Sample2InScopeOption splitByPipeLine() {
        return (Sample2InScopeOption)doSplitByPipeLine();
    }

    public Sample2InScopeOption splitByPipeLine(int splitLimitCount) {
        return (Sample2InScopeOption)doSplitByPipeLine(splitLimitCount);
    }

    // =====================================================================================
    //                                                                   To Upper/Lower Case
    //                                                                   ===================
    public Sample2InScopeOption toUpperCase() {
        return (Sample2InScopeOption)doToUpperCase();
    }

    public Sample2InScopeOption toLowerCase() {
        return (Sample2InScopeOption)doToLowerCase();
    }

    // =====================================================================================
    //                                                                        To Single Byte
    //                                                                        ==============
    public Sample2InScopeOption toSingleByteSpace() {
        return (Sample2InScopeOption)doToSingleByteSpace();
    }

    public Sample2InScopeOption toSingleByteAlphabetNumber() {
        return (Sample2InScopeOption)doToSingleByteAlphabetNumber();
    }

    public Sample2InScopeOption toSingleByteAlphabetNumberMark() {
        return (Sample2InScopeOption)doToSingleByteAlphabetNumberMark();
    }

    // =====================================================================================
    //                                                                        To Double Byte
    //                                                                        ==============

    // =====================================================================================
    //                                                                              Japanese
    //                                                                              ========
    public Sample2JapaneseOptionPartsAgent localJapanese() {
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
