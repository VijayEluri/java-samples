package jp.co.np.p2netex.sample1.allcommon;

import jp.co.np.p2netex.sample1.allcommon.bhv.Sample1BehaviorReadable;

/**
 * The interface of behavior-selector.
 * @author DBFlute(AutoGenerator)
 */
public interface Sample1BehaviorSelector {

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
    public <BEHAVIOR extends Sample1BehaviorReadable> BEHAVIOR select(Class<BEHAVIOR> behaviorType);

    /**
     * Select behavior-readable.
     * @param tableFlexibleName Table flexible-name. (NotNull)
     * @return Behavior-readable. (NotNull)
     */
    public Sample1BehaviorReadable byName(String tableFlexibleName);
}
