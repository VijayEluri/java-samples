package jp.co.np.p2netex.sample1.allcommon.cbean.coption.parts.local;


import jp.co.np.p2netex.sample1.allcommon.helper.character.Sample1JapaneseCharacter;
import jp.co.np.p2netex.sample1.allcommon.helper.character.impl.Sample1JapaneseCharacterImpl;

/**
 * The class of condition-option-parts-agent.
 * @author DBFlute(AutoGenerator)
 */
public class Sample1JapaneseOptionPartsAgent {

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    protected boolean _toDoubleByteKatakana;
    protected boolean _removeLastLongVowel;
    private Sample1JapaneseCharacter _japaneseCharacter;

    // =====================================================================================
    //                                                                                  Main
    //                                                                                  ====
    public boolean isToDoubleByteKatakana() {
        return _toDoubleByteKatakana;
    }

    public void toDoubleByteKatakana() {
        _toDoubleByteKatakana = true;
    }

    public boolean isRemoveLastLongVowel() {
        return _removeLastLongVowel;
    }
    public void removeLastLongVowel() {
        _removeLastLongVowel = true;
    }

    // =====================================================================================
    //                                                                            Real Value
    //                                                                            ==========
    public String generateRealValue(String value) {
        if (value == null) {
            return value;
        }

        // To Double Byte
        if (_toDoubleByteKatakana) {
            value = getJapaneseCharacter().toDoubleByteKatakana(value);
        }

        // Remove
        if (_removeLastLongVowel) {
            if (value != null && value.endsWith("\u30fc")) {
                value = value.substring(0, value.length() - "\u30fc".length());
            }
        }
        return value;
    }

    // =====================================================================================
    //                                                                                Helper
    //                                                                                ======
    protected Sample1JapaneseCharacter getJapaneseCharacter() {
        if (_japaneseCharacter == null) {
            _japaneseCharacter = new Sample1JapaneseCharacterImpl();
        }
        return _japaneseCharacter;
    }

    // =====================================================================================
    //                                                                              DeepCopy
    //                                                                              ========
    public Object createDeepCopy() {
        final Sample1JapaneseOptionPartsAgent deepCopy = new Sample1JapaneseOptionPartsAgent();
        deepCopy._toDoubleByteKatakana = _toDoubleByteKatakana;
        deepCopy._removeLastLongVowel = _removeLastLongVowel;
        return deepCopy;
    }
}
