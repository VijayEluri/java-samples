package jp.co.np.p2netex.sample1.allcommon.cbean.ckey;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jp.co.np.p2netex.sample1.allcommon.cbean.coption.Sample1ConditionOption;
import jp.co.np.p2netex.sample1.allcommon.cbean.cvalue.Sample1ConditionValue;

/**
 * The condition-key of greaterEqual.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class Sample1ConditionKeyGreaterEqual extends Sample1ConditionKey {

    /** Log-instance. */
    private static final Log _log = LogFactory.getLog(Sample1ConditionKeyGreaterEqual.class);

    /**
     * Constructor.
     */
    protected Sample1ConditionKeyGreaterEqual() {
        _conditionKey = "greaterEqual";
        _operand = ">=";
    }

    /**
     * Is valid registration?
     * 
     * @param conditionValue Condition value. (NotNull)
     * @param value Value. (NotNull)
     * @param callerName Caller name. (NotNull)
     * @return Determination.
     */
    public boolean isValidRegistration(Sample1ConditionValue conditionValue, Object value, String callerName) {
        if (value == null) {
            return false;
        }
        if (conditionValue.hasGreaterEqual()) {
            if (conditionValue.equalGreaterEqual(value)) {
                _log.warn("The value has already registered at " + callerName + ": value=" + value);
                return false;
            } else {
                conditionValue.overrideGreaterEqual(value);
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
    protected void doAddWhereClause(java.util.List<String> conditionList, String columnName, Sample1ConditionValue value) {
        if (value.getGreaterEqual() == null) {
            return;
        }
        conditionList.add(buildBindClause(columnName, value.getGreaterEqualLocation()));
    }

    /**
     * This method implements super#doAddWhereClause().
     * 
     * @param conditionList Condition list. (NotNull)
     * @param columnName Column name. (NotNull)
     * @param value Condition value. (NotNull)
     * @param option Condition option. (NotNull)
     */
    protected void doAddWhereClause(java.util.List<String> conditionList, String columnName, Sample1ConditionValue value, Sample1ConditionOption option) {
        throw new UnsupportedOperationException("doAddWhereClause that has ConditionOption is unsupported!!!");
    }

    /**
     * This method implements super#doSetupConditionValue().
     * 
     * @param conditionValue Condition value. (NotNull)
     * @param value Value. (NotNull)
     * @param location Location. (NotNull)
     */
    protected void doSetupConditionValue(Sample1ConditionValue conditionValue, Object value, String location) {
        conditionValue.setGreaterEqual(value).setGreaterEqualLocation(location);
    }

    /**
     * This method implements super#doSetupConditionValue().
     * 
     * @param conditionValue Condition value. (NotNull)
     * @param value Value. (NotNull)
     * @param location Location. (NotNull)
     * @param option Condition option. (NotNull)
     */
    protected void doSetupConditionValue(Sample1ConditionValue conditionValue, Object value, String location, Sample1ConditionOption option) {
        throw new UnsupportedOperationException("doSetupConditionValue with condition-option is unsupported!!!");
    }
}
