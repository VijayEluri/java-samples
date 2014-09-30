package jp.co.np.p2netex.sample1.allcommon.cbean.coption.parts;


import jp.co.np.p2netex.sample1.allcommon.helper.character.Sample1GeneralCharacter;
import jp.co.np.p2netex.sample1.allcommon.helper.character.impl.Sample1GeneralCharacterImpl;

/**
 * The interface of condition-option.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class Sample1ToSingleByteOptionParts {

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    protected boolean _toSingleByteSpace;
    protected boolean _toSingleByteAlphabetNumber;
    protected boolean _toSingleByteAlphabetNumberMark;

    private Sample1GeneralCharacter _generalCharacter;

    // =====================================================================================
    //                                                                                  Main
    //                                                                                  ====
    public boolean isToSingleByteSpace() {
        return _toSingleByteSpace;
    }
    public void toSingleByteSpace() {
        _toSingleByteSpace = true;
    }

    public void toSingleByteAlphabetNumber() {
        _toSingleByteAlphabetNumber = true;
    }

    public void toSingleByteAlphabetNumberMark() {
        _toSingleByteAlphabetNumberMark = true;
    }

    // =====================================================================================
    //                                                                            Real Value
    //                                                                            ==========
    public String generateRealValue(String value) {
        if (value == null) {
            return value;
        }

        // To Single Byte
        if (_toSingleByteSpace) {
            value = (value != null ? value.replaceAll("\u3000", " ") : value);
        }
        if (_toSingleByteAlphabetNumberMark) {
            value = getGeneralCharacter().toSingleByteAlphabetNumberMark(value);
        } else if (_toSingleByteAlphabetNumber) {
            value = getGeneralCharacter().toSingleByteAlphabetNumber(value);
        }
        return value;
    }

    // =====================================================================================
    //                                                                                Helper
    //                                                                                ======
    protected Sample1GeneralCharacter getGeneralCharacter() {
        if (_generalCharacter == null) {
            _generalCharacter = new Sample1GeneralCharacterImpl();
        }
        return _generalCharacter;
    }

    // =====================================================================================
    //                                                                              DeepCopy
    //                                                                              ========
    public Object createDeepCopy() {
        final Sample1ToSingleByteOptionParts deepCopy = new Sample1ToSingleByteOptionParts();
        deepCopy._toSingleByteSpace = _toSingleByteSpace;
        deepCopy._toSingleByteAlphabetNumber = _toSingleByteAlphabetNumber;
        deepCopy._toSingleByteAlphabetNumberMark = _toSingleByteAlphabetNumberMark;
        return deepCopy;
    }
}
