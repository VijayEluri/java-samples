package jp.co.np.p2netex.sample1.allcommon.cbean.coption;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import jp.co.np.p2netex.sample1.allcommon.cbean.coption.parts.local.Sample1JapaneseOptionPartsAgent;

/**
 * The class of like-search-option.
 * @author DBFlute(AutoGenerator)
 */
public class Sample1LikeSearchOption extends Sample1SimpleStringOption {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    protected static final String LIKE_PREFIX = "prefix";
    protected static final String LIKE_SUFFIX = "suffix";
    protected static final String LIKE_CONTAIN = "contain";

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected String _like;
    protected String _escape;
    protected boolean _asOrSplit;
    protected List<LikeAsOrCallback> _likeAsOrCallbackList;

    // ===================================================================================
    //                                                                         Rear Option
    //                                                                         ===========
    public String getRearOption() {
        if (_escape == null || _escape.trim().length() == 0) {
            return "";
        }
        return " escape '" + _escape + "'";
    }

    // ===================================================================================
    //                                                                                AsOr
    //                                                                                ====
    /** @deprecated */
    public static interface LikeAsOrCallback {
        public String getAdditionalTargetPropertyName();
        public String filterValue(String currentValue);
        public Sample1LikeSearchOption filterOption(Sample1LikeSearchOption optionDeepCopyWithoutCallback);
    }

	/** @deprecated */
    public static abstract class DefaultLikeAsOrCallback implements LikeAsOrCallback {
        public String filterValue(String currentValue) {
            return currentValue;
        }
        public Sample1LikeSearchOption filterOption(Sample1LikeSearchOption optionDeepCopyWithoutCallback) {
            return optionDeepCopyWithoutCallback;
        }
    }

    public boolean hasLikeAsOrCallback() {
        return _likeAsOrCallbackList != null && !_likeAsOrCallbackList.isEmpty();
    }
	
    public List<LikeAsOrCallback> getLikeAsOrCallbackList() {
		if (_likeAsOrCallbackList == null) {
		    _likeAsOrCallbackList = new ArrayList<LikeAsOrCallback>();
		}
        return _likeAsOrCallbackList;
    }

	/** 
     * @param likeAsOrCallback Callback.
     * @deprecated
     */
    public void addLikeAsOrCallback(LikeAsOrCallback likeAsOrCallback) {
        getLikeAsOrCallbackList().add(likeAsOrCallback);
    }

    public void clearLikeAsOrCallback() {
        getLikeAsOrCallbackList().clear();
    }

    // ===================================================================================
    //                                                                                Like
    //                                                                                ====
    public Sample1LikeSearchOption likePrefix() {
        _like = LIKE_PREFIX;
        return this;
    }
    public Sample1LikeSearchOption likeSuffix() {
        _like = LIKE_SUFFIX;
        return this;
    }
    public Sample1LikeSearchOption likeContain() {
        _like = LIKE_CONTAIN;
        return this;
    }

    // ===================================================================================
    //                                                                              Escape
    //                                                                              ======
    public Sample1LikeSearchOption escapeByPipeLine() {
        _escape = "|";
        return this;
    }

    public Sample1LikeSearchOption escapeByAtMark() {
        _escape = "@";
        return this;
    }

    public Sample1LikeSearchOption escapeBySlash() {
        _escape = "/";
        return this;
    }

    public Sample1LikeSearchOption escapeByBackSlash() {
        _escape = "\\";
        return this;
    }

    // ===================================================================================
    //                                                                               Split
    //                                                                               =====
    public Sample1LikeSearchOption splitBySpace() {
        return (Sample1LikeSearchOption)doSplitBySpace();
    }

    public Sample1LikeSearchOption splitBySpace(int splitLimitCount) {
        return (Sample1LikeSearchOption)doSplitBySpace(splitLimitCount);
    }

    public Sample1LikeSearchOption splitBySpaceContainsDoubleByte() {
        return (Sample1LikeSearchOption)doSplitBySpaceContainsDoubleByte();
    }

    public Sample1LikeSearchOption splitBySpaceContainsDoubleByte(int splitLimitCount) {
        return (Sample1LikeSearchOption)doSplitBySpaceContainsDoubleByte(splitLimitCount);
    }

    public Sample1LikeSearchOption splitByPipeLine() {
        return (Sample1LikeSearchOption)doSplitByPipeLine();
    }

    public Sample1LikeSearchOption splitByPipeLine(int splitLimitCount) {
        return (Sample1LikeSearchOption)doSplitByPipeLine(splitLimitCount);
    }
	
	public Sample1LikeSearchOption asOrSplit() {
	    _asOrSplit = true;
		return this;
	}
	
	public boolean isAsOrSplit() {
	    return _asOrSplit;
	}

    // ===================================================================================
    //                                                                 To Upper/Lower Case
    //                                                                 ===================
    public Sample1LikeSearchOption toUpperCase() {
        return (Sample1LikeSearchOption)doToUpperCase();
    }

    public Sample1LikeSearchOption toLowerCase() {
        return (Sample1LikeSearchOption)doToLowerCase();
    }

    // ===================================================================================
    //                                                                      To Single Byte
    //                                                                      ==============
    public Sample1LikeSearchOption toSingleByteSpace() {
        return (Sample1LikeSearchOption)doToSingleByteSpace();
    }

    public Sample1LikeSearchOption toSingleByteAlphabetNumber() {
        return (Sample1LikeSearchOption)doToSingleByteAlphabetNumber();
    }

    public Sample1LikeSearchOption toSingleByteAlphabetNumberMark() {
        return (Sample1LikeSearchOption)doToSingleByteAlphabetNumberMark();
    }

    // ===================================================================================
    //                                                                      To Double Byte
    //                                                                      ==============

    // ===================================================================================
    //                                                                            Japanese
    //                                                                            ========
    public Sample1JapaneseOptionPartsAgent localJapanese() {
        return doLocalJapanese();
    }

    // ===================================================================================
    //                                                                          Real Value
    //                                                                          ==========
    public String generateRealValue(String value) {
        value = super.generateRealValue(value);

        // Escape
        if (_escape != null && _escape.trim().length() != 0) {
            String tmp = replace(value, _escape, _escape + _escape);
            tmp = replace(tmp, "%", _escape + "%");
            tmp = replace(tmp, "_", _escape + "_");
            value = tmp;
        }
        final String wildCard = "%";
        if (_like == null || _like.trim().length() == 0) {
            return value;
        } else if (_like.equals(LIKE_PREFIX)) {
            return value + wildCard;
        } else if (_like.equals(LIKE_SUFFIX)) {
            return wildCard + value;
        } else if (_like.equals(LIKE_CONTAIN)) {
            return wildCard + value + wildCard;
        } else {
            String msg = "The like was wrong string: " + _like;
            throw new IllegalStateException(msg);
        }
    }

    // ===================================================================================
    //                                                                            DeepCopy
    //                                                                            ========
    public Object createDeepCopy() {
        final Sample1LikeSearchOption deepCopy = (Sample1LikeSearchOption)super.createDeepCopy();
        deepCopy._like = _like;
        deepCopy._escape = _escape;
		if (hasLikeAsOrCallback()) {
            for (Iterator<LikeAsOrCallback> ite = _likeAsOrCallbackList.iterator(); ite.hasNext(); ) {
                deepCopy.addLikeAsOrCallback((LikeAsOrCallback)ite.next());
            }
		}
        return deepCopy;
    }

    protected Sample1SimpleStringOption newDeepCopyInstance() {
        return new Sample1LikeSearchOption();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    public String toString() {
        return "like=" + _like + ", escape=" + _escape + ", split=" + isSplit() + ", asOrSplit = " + _asOrSplit;  
    }
}
