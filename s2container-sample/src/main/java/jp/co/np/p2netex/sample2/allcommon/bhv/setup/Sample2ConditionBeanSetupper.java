package jp.co.np.p2netex.sample2.allcommon.bhv.setup;

import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2ConditionBean;

/**
 * The interface of condition-bean setupper.
 * @param <CONDITION_BEAN> The type of condition-bean.
 * @author DBFlute(AutoGenerator)
 */
public interface Sample2ConditionBeanSetupper<CONDITION_BEAN extends Sample2ConditionBean> {

    /**
     * Set up condition.
     * @param cb Condition-bean. (NotNull)
     */
    public void setup(CONDITION_BEAN cb);
}
