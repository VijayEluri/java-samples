package jp.co.np.p2netex.sample2.allcommon;

import jp.co.np.p2netex.sample2.allcommon.bhv.Sample2BehaviorReadable;

/**
 * The interface of behavior-selector.
 * @author DBFlute(AutoGenerator)
 */
public interface Sample2BehaviorSelector {

    /**
     * Initialize condition-bean meta data. <br />
	 * If you call this, Hot Deploy of OutsideSql becomes Cool!
     */
    public void initializeConditionBeanMetaData();
	
    /**
     * Select behavior.
	 * @param <BEHAVIOR> The type of behavior.
     * @param behaviorType Behavior type. (NotNull)
     * @return Behavior. (NotNull)
     */
    public <BEHAVIOR extends Sample2BehaviorReadable> BEHAVIOR select(Class<BEHAVIOR> behaviorType);

    /**
     * Select behavior-readable.
     * @param tableFlexibleName Table flexible-name. (NotNull)
     * @return Behavior-readable. (NotNull)
     */
    public Sample2BehaviorReadable byName(String tableFlexibleName);
}
