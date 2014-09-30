package jp.co.np.p2netex.sample2.allcommon.cbean.ckey;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jp.co.np.p2netex.sample2.allcommon.cbean.coption.Sample2ConditionOption;
import jp.co.np.p2netex.sample2.allcommon.cbean.cvalue.Sample2ConditionValue;

/**
 * The condition-key of isNotNull.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class Sample2ConditionKeyIsNotNull extends Sample2ConditionKey {

    /** Log-instance. */
    private static final Log _log = LogFactory.getLog(Sample2ConditionKeyIsNotNull.class);

    /**
     * Constructor.
     */
    protected Sample2ConditionKeyIsNotNull() {
        _conditionKey = "isNotNull";
        _operand = "is not null";
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
        if (conditionValue.hasIsNotNull()) {
            _log.warn("The value has already registered at " + callerName);
            return false;
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
        if (value.getIsNotNull() == null) {
            return;
        }
        conditionList.add(buildClauseWithoutValue(columnName));
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
        conditionValue.setIsNotNull(DUMMY_OBJECT).setIsNotNullLocation(location);
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
