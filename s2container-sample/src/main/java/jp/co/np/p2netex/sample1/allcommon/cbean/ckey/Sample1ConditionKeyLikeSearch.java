package jp.co.np.p2netex.sample1.allcommon.cbean.ckey;

import java.util.List;

import jp.co.np.p2netex.sample1.allcommon.cbean.coption.Sample1ConditionOption;
import jp.co.np.p2netex.sample1.allcommon.cbean.coption.Sample1LikeSearchOption;
import jp.co.np.p2netex.sample1.allcommon.cbean.cvalue.Sample1ConditionValue;

/**
 * The condition-key of likeSearch.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class Sample1ConditionKeyLikeSearch extends Sample1ConditionKey {

    /**
     * Constructor.
     */
    protected Sample1ConditionKeyLikeSearch() {
        _conditionKey = "likeSearch";
        _operand = "like";
    }

    /**
     * Is valid registration?
     * @param conditionValue Condition value. (NotNull)
     * @param value Value. (NotNull)
     * @param callerName Caller name. (NotNull)
     * @return Determination.
     */
    public boolean isValidRegistration(Sample1ConditionValue conditionValue, Object value, String callerName) {
        if (value == null) {
            return false;
        }
        return true;
    }

    /**
     * This method implements super#doAddWhereClause().
     * @param conditionList Condition list. (NotNull)
     * @param columnName Column name. (NotNull)
     * @param value Condition value. (NotNull)
     */
    protected void doAddWhereClause(List<String> conditionList, String columnName, Sample1ConditionValue value) {
        throw new UnsupportedOperationException("doAddWhereClause without condition-option is unsupported!!!");
    }

    /**
     * This method implements super#doAddWhereClause().
     * @param conditionList Condition list. (NotNull)
     * @param columnName Column name. (NotNull)
     * @param value Condition value. (NotNull)
     * @param option Condition option. (NotNull)
     */
    protected void doAddWhereClause(List<String> conditionList, String columnName, Sample1ConditionValue value, Sample1ConditionOption option) {
        if (option == null) {
            String msg = "The argument[option] should not be null: columnName=" + columnName + " value=" + value;
            throw new IllegalArgumentException(msg);
        }
        if (!(option instanceof Sample1LikeSearchOption)) {
            String msg = "The argument[option] should be Sample1LikeSearchOption: columnName=" + columnName + " value=" + value;
            throw new IllegalArgumentException(msg);
        }
        final Sample1LikeSearchOption myOption = (Sample1LikeSearchOption)option;
        conditionList.add(buildBindClauseWithRearOption(columnName, value.getLikeSearchLocation(), myOption.getRearOption()));
    }

    /**
     * This method implements super#doSetupConditionValue().
     * @param conditionValue Condition value. (NotNull)
     * @param value Value. (NotNull)
     * @param location Location. (NotNull)
     */
    protected void doSetupConditionValue(Sample1ConditionValue conditionValue, Object value, String location) {
        throw new UnsupportedOperationException("doSetupConditionValue without condition-option is unsupported!!!");
    }

    /**
     * This method implements super#doSetupConditionValue().
     * @param conditionValue Condition value. (NotNull)
     * @param value Value. (NotNull)
     * @param location Location. (NotNull)
     * @param option Condition option. (NotNull)
     */
    protected void doSetupConditionValue(Sample1ConditionValue conditionValue, Object value, String location, Sample1ConditionOption option) {
        conditionValue.setLikeSearch((String)value, (Sample1LikeSearchOption)option).setLikeSearchLocation(location);
    }
}
