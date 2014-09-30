package jp.co.np.p2netex.sample2.allcommon.cbean.ckey;

import java.util.List;

import jp.co.np.p2netex.sample2.allcommon.cbean.coption.Sample2ConditionOption;
import jp.co.np.p2netex.sample2.allcommon.cbean.cvalue.Sample2ConditionValue;

/**
 * The abstract class of condition-key.
 * 
 * @author DBFlute(AutoGenerator)
 */
public abstract class Sample2ConditionKey {

    /** Mark of replaced value. */
    public static final String MARK_OF_REPLACED_VALUE = "ReplacedValue";

    /** The condition key of equal. */
    public static final Sample2ConditionKey CK_EQUAL = new Sample2ConditionKeyEqual();

    /** The condition key of notEqual. */
    public static final Sample2ConditionKey CK_NOT_EQUAL = new Sample2ConditionKeyNotEqual();

    /** The condition key of greaterThan. */
    public static final Sample2ConditionKey CK_GREATER_THAN = new Sample2ConditionKeyGreaterThan();

    /** The condition key of lessrThan. */
    public static final Sample2ConditionKey CK_LESS_THAN = new Sample2ConditionKeyLessThan();

    /** The condition key of greaterEqual. */
    public static final Sample2ConditionKey CK_GREATER_EQUAL = new Sample2ConditionKeyGreaterEqual();

    /** The condition key of lessEqual. */
    public static final Sample2ConditionKey CK_LESS_EQUAL = new Sample2ConditionKeyLessEqual();

    /** The condition key of prefixSearch. */
    public static final Sample2ConditionKey CK_PREFIX_SEARCH = new Sample2ConditionKeyPrefixSearch();

    /** The condition key of likeSearch. */
    public static final Sample2ConditionKey CK_LIKE_SEARCH = new Sample2ConditionKeyLikeSearch();

    /** The condition key of inScope. */
    public static final Sample2ConditionKey CK_IN_SCOPE = new Sample2ConditionKeyInScope();

    /** The condition key of notInScope. */
    public static final Sample2ConditionKey CK_NOT_IN_SCOPE = new Sample2ConditionKeyNotInScope();

    /** The condition key of isNull. */
    public static final Sample2ConditionKey CK_IS_NULL = new Sample2ConditionKeyIsNull();

    /** The condition key of isNotNull. */
    public static final Sample2ConditionKey CK_IS_NOT_NULL = new Sample2ConditionKeyIsNotNull();

    /** Dummy-object for IsNull and IsNotNull and so on... */
    protected static final Object DUMMY_OBJECT = new Object();

    /** Condition-key. */
    protected String _conditionKey;

    /** Operand. */
    protected String _operand;

    /**
     * Get condition-key.
     * @return Condition-key.
     */
    public String getConditionKey() {
        return _conditionKey;
    }

    /**
     * Get operand.
     * @return Operand.
     */
    public String getOperand() {
        return _operand;
    }

    /**
     * Is valid registration?
     * @param conditionValue Condition value. (NotNull)
     * @param value Value. (NotNull)
     * @param callerName Caller name. (NotNull)
     * @return Determination.
     */
    abstract public boolean isValidRegistration(Sample2ConditionValue conditionValue, Object value, String callerName);

    /**
     * Add where clause.
     * @param conditionList Condition list. (NotNull)
     * @param columnName Column name. (NotNull)
     * @param value Condition value. (NotNull)
     * @return this.
     */
    public Sample2ConditionKey addWhereClause(java.util.List<String> conditionList, String columnName, Sample2ConditionValue value) {
        if (value == null) {
            String msg = "Argument[value] must not be null:";
            throw new IllegalArgumentException(msg + " value=" + value + " this.toString()=" + toString());
        }
        doAddWhereClause(conditionList, columnName, value);
        return this;
    }

    /**
     * Add where clause.
     * @param conditionList Condition list. (NotNull)
     * @param columnName Column name. (NotNull)
     * @param value Condition value. (NotNull)
     * @param option Condition option. (NotNull)
     * @return this.
     */
    public Sample2ConditionKey addWhereClause(java.util.List<String> conditionList, String columnName, Sample2ConditionValue value, Sample2ConditionOption option) {
        if (value == null) {
            String msg = "Argument[value] must not be null:";
            throw new IllegalArgumentException(msg + " value=" + value + " this.toString()=" + toString());
        }
        doAddWhereClause(conditionList, columnName, value, option);
        return this;
    }

    /**
     * Do add where clause.
     * @param conditionList Condition list. (NotNull)
     * @param columnName Column name. (NotNull)
     * @param value Condition value. (NotNull)
     */
    abstract protected void doAddWhereClause(List<String> conditionList, String columnName, Sample2ConditionValue value);

    /**
     * Do add where clause.
     * @param conditionList Condition list. (NotNull)
     * @param columnName Column name. (NotNull)
     * @param value Condition value. (NotNull)
     * @param option Condition option. (NotNull)
     */
    abstract protected void doAddWhereClause(List<String> conditionList, String columnName, Sample2ConditionValue value, Sample2ConditionOption option);

    /**
     * Setup condition value.
     * @param conditionValue Condition value. (NotNull)
     * @param value Value. (Nullable)
     * @param location Location. (Nullable)
     * @return Condition value. (The same as argument[conditionValue]) (NotNull)
     */
    public Sample2ConditionValue setupConditionValue(Sample2ConditionValue conditionValue, Object value, String location) {
        if (conditionValue == null) {
            String msg = "Argument[conditionValue] must not be null:";
            throw new IllegalArgumentException(msg + " value=" + value + " this.toString()=" + toString());
        }
        doSetupConditionValue(conditionValue, value, location);
        return conditionValue;
    }

    /**
     * Setup condition value.
     * @param conditionValue Condition value. (NotNull)
     * @param value Value. (Nullable)
     * @param location Location. (Nullable)
     * @param option Condition option. (NotNull)
     * @return Condition value. (The same as argument[conditionValue]) (NotNull)
     */
    public Sample2ConditionValue setupConditionValue(Sample2ConditionValue conditionValue, Object value, String location, Sample2ConditionOption option) {
        if (conditionValue == null) {
            String msg = "Argument[conditionValue] must not be null:";
            throw new IllegalArgumentException(msg + " value=" + value + " this.toString()=" + toString());
        }
        doSetupConditionValue(conditionValue, value, location, option);
        return conditionValue;
    }

    /**
     * Do setup condition value.
     * @param conditionValue Condition value. (NotNull)
     * @param value Value. (NotNull)
     * @param location Location. (NotNull)
     */
    abstract protected void doSetupConditionValue(Sample2ConditionValue conditionValue, Object value, String location);

    /**
     * Do setup condition value.
     * @param conditionValue Condition value. (NotNull)
     * @param value Value. (NotNull)
     * @param location Location. (NotNull)
     * @param option Condition option. (NotNull)
     */
    abstract protected void doSetupConditionValue(Sample2ConditionValue conditionValue, Object value, String location, Sample2ConditionOption option);

    /**
     * Build bind clause. (for s2dao)
     * @param columnName Column name. (NotNull)
     * @param location Location. (NotNull)
     * @return Bind clause. (NotNull)
     */
    protected String buildBindClause(String columnName, String location) {
        return columnName + " " + getOperand() + " " + "/*dto." + location + "*/null";
    }

    /**
     * Build bind clause. (for s2dao)
     * @param columnName Column name. (NotNull)
     * @param location Location. (NotNull)
     * @param rearOption Rear option. (NotNull)
     * @return Bind clause. (NotNull)
     */
    protected String buildBindClauseWithRearOption(String columnName, String location, String rearOption) {
        return columnName + " " + getOperand() + " " + "/*dto." + location + "*/null" + rearOption;
    }

    /**
     * Build bind clause. (for s2dao)
     * @param columnName Column name. (NotNull)
     * @param location Location. (NotNull)
     * @param dummyValue Dummy value. (NotNull)
     * @return Bind clause. (NotNull)
     */
    protected String buildBindClause(String columnName, String location, String dummyValue) {
        return columnName + " " + getOperand() + " " + "/*dto." + location + "*/" + dummyValue;
    }

    /**
     * Build clause without value.
     * @param columnName Column name. (NotNull)
     * @return Clause without value. (NotNull)
     */
    protected String buildClauseWithoutValue(String columnName) {
        return columnName + " " + getOperand();
    }

    /**
     * Get wild-card.
     * @return Wild-card.
     */
    protected String getWildCard() {
        return "%";
    }

    /**
     * The override.
     * Returns hash-code of this condition-key string.
     * 
     * @return HashCode.
     */
    public int hashCode() {
        return getConditionKey().hashCode();
    }

    /**
     * The override.
     * If the condition-key of the other is same as this one, returns true.
     * 
     * @param other Other entity. (Nullable)
     * @return Comparing result. If other is null, returns false.
     */
    public boolean equals(Object other) {
        if (other instanceof Sample2ConditionKey) {
            if (this.getConditionKey().equals(((Sample2ConditionKey)other).getConditionKey())) {
                return true;
            }
        }
        return false;
    }

    /**
     * The override.
     * 
     * @return View-string of condition key information.
     */
    public String toString() {
        return "Sample2ConditionKey: " + getConditionKey() + " " + getOperand() + " wild-card=[" + getWildCard() + "]";
    }
}
