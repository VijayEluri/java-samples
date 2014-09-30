package jp.co.np.p2netex.sample2.allcommon.cbean.ckey;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jp.co.np.p2netex.sample2.allcommon.cbean.coption.Sample2ConditionOption;
import jp.co.np.p2netex.sample2.allcommon.cbean.coption.Sample2InScopeOption;
import jp.co.np.p2netex.sample2.allcommon.cbean.cvalue.Sample2ConditionValue;

/**
 * The condition-key of inScope.
 * @author DBFlute(AutoGenerator)
 */
public class Sample2ConditionKeyInScope extends Sample2ConditionKey {

    /** Log-instance. */
    private static final Log _log = LogFactory.getLog(Sample2ConditionKeyInScope.class);

    /**
     * Constructor.
     */
    protected Sample2ConditionKeyInScope() {
        _conditionKey = "inScope";
        _operand = "in";
    }

    /**
     * Is valid registration?
     * @param conditionValue Condition value. (NotNull)
     * @param value Value. (NotNull)
     * @param callerName Caller name. (NotNull)
     * @return Determination.
     */
    public boolean isValidRegistration(Sample2ConditionValue conditionValue, Object value, String callerName) {
        if (value == null) {
            return false;
        }
        if (value instanceof java.util.List && ((java.util.List<?>)value).isEmpty()) {
            return false;
        }
        if (value instanceof java.util.List) {
            if (conditionValue.hasInScope()) {
                if (conditionValue.equalInScope(((java.util.List<?>)value))) {
                    _log.warn("The value has already registered at " + callerName + ": value=" + value);
                    return false;
                } else {
                    conditionValue.overrideInScope(((java.util.List<?>)value));
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This method implements super#doAddWhereClause().
     * @param conditionList Condition list. (NotNull)
     * @param columnName Column name. (NotNull)
     * @param value Condition value. (NotNull)
     */
    protected void doAddWhereClause(java.util.List<String> conditionList, String columnName, Sample2ConditionValue value) {
        if (value.getInScope() == null) {
            return;
        }
        conditionList.add(buildBindClause(columnName, value.getInScopeLocation(), "('a1', 'a2')"));
    }

    /**
     * This method implements super#doAddWhereClause().
     * @param conditionList Condition list. (NotNull)
     * @param columnName Column name. (NotNull)
     * @param value Condition value. (NotNull)
     * @param option Condition option. (NotNull)
     */
    protected void doAddWhereClause(java.util.List<String> conditionList, String columnName, Sample2ConditionValue value, Sample2ConditionOption option) {
        if (option == null) {
            String msg = "The argument[option] should not be null: columnName=" + columnName + " value=" + value;
            throw new IllegalArgumentException(msg);
        }
        if (!(option instanceof Sample2InScopeOption)) {
            String msg = "The argument[option] should be Sample2InScopeOption: columnName=" + columnName + " value=" + value;
            throw new IllegalArgumentException(msg);
        }
        conditionList.add(buildBindClause(columnName, value.getInScopeLocation(), "('a1', 'a2')"));
    }

    /**
     * This method implements super#doSetupConditionValue().
     * @param conditionValue Condition value. (NotNull)
     * @param value Value. (NotNull)
     * @param location Location. (NotNull)
     */
    protected void doSetupConditionValue(Sample2ConditionValue conditionValue, Object value, String location) {
        conditionValue.setInScope((java.util.List<?>)value).setInScopeLocation(location);
    }

    /**
     * This method implements super#doSetupConditionValue().
     * @param conditionValue Condition value. (NotNull)
     * @param value Value. (NotNull)
     * @param location Location. (NotNull)
     * @param option Condition option. (NotNull)
     */
    protected void doSetupConditionValue(Sample2ConditionValue conditionValue, Object value, String location, Sample2ConditionOption option) {
        conditionValue.setInScope((java.util.List<?>)value, (Sample2InScopeOption)option).setInScopeLocation(location);
    }
}
