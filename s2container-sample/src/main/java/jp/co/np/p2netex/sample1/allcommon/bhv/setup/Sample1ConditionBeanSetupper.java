package jp.co.np.p2netex.sample1.allcommon.bhv.setup;

import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1ConditionBean;

/**
 * The interface of condition-bean setupper.
 * @param <CONDITION_BEAN> The type of condition-bean.
 * @author DBFlute(AutoGenerator)
 */
public interface Sample1ConditionBeanSetupper<CONDITION_BEAN extends Sample1ConditionBean> {

    /**
     * Set up condition.
     * @param cb Condition-bean. (NotNull)
     */
    public void setup(CONDITION_BEAN cb);
}
