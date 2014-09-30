package jp.co.np.p2netex.sample2.allcommon.cbean.ckey;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jp.co.np.p2netex.sample2.allcommon.cbean.coption.Sample2ConditionOption;
import jp.co.np.p2netex.sample2.allcommon.cbean.cvalue.Sample2ConditionValue;

/**
 * The condition-key of prefixSearch.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class Sample2ConditionKeyPrefixSearch extends Sample2ConditionKey {

    /** Log-instance. */
    private static final Log _log = LogFactory.getLog(Sample2ConditionKeyPrefixSearch.class);

    /**
     * Constructor.
     */
    protected Sample2ConditionKeyPrefixSearch() {
        _conditionKey = "prefixSearch";
        _operand = "like";
    }

    /**
     * Is valid registration?
     * 
     * @param conditionValue Condition value. (NotNull)
     * @param value Value. (NotNull)
     * @param callerName Caller name. (NotNull)
     * @return Determination.
     */
    public boolean isValidRegistration(Sample2ConditionValue conditionValue, Object value, String callerName) {
        if (value == null) {
            return false;
        }
        if (conditionValue.hasPrefixSearch()) {
            if (conditionValue.equalPrefixSearch(value + getWildCard())) {
                _log.warn("The value has already registered at " + callerName + ": value=" + value);
                return false;
            } else {
                conditionValue.overridePrefixSearch(value);
                return false;
            }
        }
        return true;
    }

    /**
     * This method implements super#doAddWhereClause().
     * 
     * @param conditionList Condition list. (NotNull)
     * @param columnName Column name. (NotNull)
     * @param value Condition value. (NotNull)
     */
    protected void doAddWhereClause(java.util.List<String> conditionList, String columnName, Sample2ConditionValue value) {
        if (value.getPrefixSearch() == null) {
            return;
        }
        conditionList.add(buildBindClause(columnName, value.getPrefixSearchLocation()));
    }

    /**
     * This method implements super#doAddWhereClause().
     * 
     * @param conditionList Condition list. (NotNull)
     * @param columnName Column name. (NotNull)
     * @param value Condition value. (NotNull)
     * @param option Condition option. (NotNull)
     */
    protected void doAddWhereClause(java.util.List<String> conditionList, String columnName, Sample2ConditionValue value, Sample2ConditionOption option) {
        throw new UnsupportedOperationException("doAddWhereClause that has ConditionOption is unsupported!!!");
    }

    /**
     * This method implements super#doSetupConditionValue().
     * 
     * @param conditionValue Condition value. (NotNull)
     * @param value Value. (NotNull)
     * @param location Location. (NotNull)
     */
    protected void doSetupConditionValue(Sample2ConditionValue conditionValue, Object value, String location) {
        conditionValue.setPrefixSearch((value != null ? value + getWildCard() : null)).setPrefixSearchLocation(location);
    }

    /**
     * This method implements super#doSetupConditionValue().
     * 
     * @param conditionValue Condition value. (NotNull)
     * @param value Value. (NotNull)
     * @param location Location. (NotNull)
     * @param option Condition option. (NotNull)
     */
    protected void doSetupConditionValue(Sample2ConditionValue conditionValue, Object value, String location, Sample2ConditionOption option) {
        throw new UnsupportedOperationException("doSetupConditionValue with condition-option is unsupported!!!");
    }
}
