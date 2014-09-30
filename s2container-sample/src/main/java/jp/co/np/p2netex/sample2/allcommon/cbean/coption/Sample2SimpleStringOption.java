package jp.co.np.p2netex.sample2.allcommon.cbean.coption;


import jp.co.np.p2netex.sample2.allcommon.cbean.coption.parts.Sample2SplitOptionParts;
import jp.co.np.p2netex.sample2.allcommon.cbean.coption.parts.Sample2ToUpperLowerCaseOptionParts;
import jp.co.np.p2netex.sample2.allcommon.cbean.coption.parts.Sample2ToSingleByteOptionParts;
import jp.co.np.p2netex.sample2.allcommon.cbean.coption.parts.local.Sample2JapaneseOptionPartsAgent;
import jp.co.np.p2netex.sample2.allcommon.util.Sample2SimpleStringUtil;

/**
 * The class of simple-string-option.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class Sample2SimpleStringOption implements Sample2ConditionOption {

    protected Sample2SplitOptionParts _splitOptionParts;
    protected Sample2ToUpperLowerCaseOptionParts _toUpperLowerCaseOptionParts;
    protected Sample2ToSingleByteOptionParts _toSingleByteCaseOptionParts;
    protected Sample2JapaneseOptionPartsAgent _japaneseOptionPartsAgent;

    // =====================================================================================
    //                                                                           Rear Option
    //                                                                           ===========
    public String getRearOption() {
        return "";
    }

    // =====================================================================================
    //                                                                                 Split
    //                                                                                 =====
    protected Sample2SimpleStringOption doSplitBySpace() {
        getSplitOptionParts().splitBySpace();
        return this;
    }

    protected Sample2SimpleStringOption doSplitBySpace(int splitLimitCount) {
        getSplitOptionParts().splitBySpace(splitLimitCount);
        return this;
    }

    protected Sample2SimpleStringOption doSplitBySpaceContainsDoubleByte() {
        getSplitOptionParts().splitBySpaceContainsDoubleByte();
        return this;
    }

    protected Sample2SimpleStringOption doSplitBySpaceContainsDoubleByte(int splitLimitCount) {
        getSplitOptionParts().splitBySpaceContainsDoubleByte(splitLimitCount);
        return this;
    }

    protected Sample2SimpleStringOption doSplitByPipeLine() {
        getSplitOptionParts().splitByPipeLine();
        return this;
    }

    protected Sample2SimpleStringOption doSplitByPipeLine(int splitLimitCount) {
        getSplitOptionParts().splitByPipeLine(splitLimitCount);
        return this;
    }

    protected Sample2SplitOptionParts getSplitOptionParts() {
        if (_splitOptionParts == null) {
            _splitOptionParts = new Sample2SplitOptionParts();
        }
        return _splitOptionParts;
    }

    public boolean isSplit() {
        return getSplitOptionParts().isSplit();
    }

    public String[] generateSplitValueArray(String value) {
        return getSplitOptionParts().generateSplitValueArray(value);
    }

    // =====================================================================================
    //                                                                   To Upper/Lower Case
    //                                                                   ===================
    protected Sample2SimpleStringOption doToUpperCase() {
        getToUpperLowerCaseOptionParts().toUpperCase();
        return this;
    }

    protected Sample2SimpleStringOption doToLowerCase() {
        getToUpperLowerCaseOptionParts().toLowerCase();
        return this;
    }

    protected Sample2ToUpperLowerCaseOptionParts getToUpperLowerCaseOptionParts() {
        if (_toUpperLowerCaseOptionParts == null) {
            _toUpperLowerCaseOptionParts = new Sample2ToUpperLowerCaseOptionParts();
        }
        return _toUpperLowerCaseOptionParts;
    }

    // =====================================================================================
    //                                                                        To Single Byte
    //                                                                        ==============
    protected Sample2SimpleStringOption doToSingleByteSpace() {
        getToSingleByteOptionParts().toSingleByteSpace();
        return this;
    }

    protected Sample2SimpleStringOption doToSingleByteAlphabetNumber() {
        getToSingleByteOptionParts().toSingleByteAlphabetNumber();
        return this;
    }

    protected Sample2SimpleStringOption doToSingleByteAlphabetNumberMark() {
        getToSingleByteOptionParts().toSingleByteAlphabetNumberMark();
        return this;
    }

    protected Sample2ToSingleByteOptionParts getToSingleByteOptionParts() {
        if (_toSingleByteCaseOptionParts == null) {
            _toSingleByteCaseOptionParts = new Sample2ToSingleByteOptionParts();
        }
        return _toSingleByteCaseOptionParts;
    }

    // =====================================================================================
    //                                                                        To Double Byte
    //                                                                        ==============

    // =====================================================================================
    //                                                                              Japanese
    //                                                                              ========
    protected Sample2JapaneseOptionPartsAgent doLocalJapanese() {
        return getJapaneseOptionPartsAgent();
    }

    protected Sample2JapaneseOptionPartsAgent getJapaneseOptionPartsAgent() {
        if (_japaneseOptionPartsAgent == null) {
            _japaneseOptionPartsAgent = new Sample2JapaneseOptionPartsAgent();
        }
        return _japaneseOptionPartsAgent;
    }

    // =====================================================================================
    //                                                                            Real Value
    //                                                                            ==========
    public String generateRealValue(String value) {
        value = getToUpperLowerCaseOptionParts().generateRealValue(value);
        value = getToSingleByteOptionParts().generateRealValue(value);
        value = getJapaneseOptionPartsAgent().generateRealValue(value);
        return value;
    }

    // =====================================================================================
    //                                                                        General Helper
    //                                                                        ==============
    protected String replace(String text, String fromText, String toText) {
	    return Sample2SimpleStringUtil.replace(text, fromText, toText);
    }

    // =====================================================================================
    //                                                                              DeepCopy
    //                                                                              ========
    public Object createDeepCopy() {
        final Sample2SimpleStringOption deepCopy = newDeepCopyInstance();
        deepCopy._splitOptionParts = _splitOptionParts != null ? (Sample2SplitOptionParts)_splitOptionParts.createDeepCopy() : null;
        deepCopy._toUpperLowerCaseOptionParts = _toUpperLowerCaseOptionParts != null ? (Sample2ToUpperLowerCaseOptionParts)_toUpperLowerCaseOptionParts.createDeepCopy() : null;
        deepCopy._toSingleByteCaseOptionParts = _toSingleByteCaseOptionParts != null ? (Sample2ToSingleByteOptionParts)_toSingleByteCaseOptionParts.createDeepCopy() : null;
        deepCopy._japaneseOptionPartsAgent = _japaneseOptionPartsAgent != null ? (Sample2JapaneseOptionPartsAgent)_japaneseOptionPartsAgent.createDeepCopy() : null;
        return deepCopy;
    }
    protected Sample2SimpleStringOption newDeepCopyInstance() {
        return new Sample2SimpleStringOption();
    }
}
