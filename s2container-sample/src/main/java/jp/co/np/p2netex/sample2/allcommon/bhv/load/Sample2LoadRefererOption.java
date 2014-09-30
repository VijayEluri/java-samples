package jp.co.np.p2netex.sample2.allcommon.bhv.load;

import jp.co.np.p2netex.sample2.allcommon.Sample2Entity;
import jp.co.np.p2netex.sample2.allcommon.bhv.setup.Sample2ConditionBeanSetupper;
import jp.co.np.p2netex.sample2.allcommon.bhv.setup.Sample2EntityListSetupper;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2ConditionBean;

/**
 * The class of load referrer option.
 * 
 * @param <REFERRER_CONDITION_BEAN> The type of referrer condition-bean.
 * @param <REFERRER_ENTITY> The type of referrer entity.
 * @author DBFlute(AutoGenerator)
 */
public class Sample2LoadRefererOption<REFERRER_CONDITION_BEAN extends Sample2ConditionBean, REFERRER_ENTITY extends Sample2Entity> extends Sample2LoadReferrerOption<REFERRER_CONDITION_BEAN, REFERRER_ENTITY> {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample2LoadRefererOption() {
    }

    public Sample2LoadRefererOption(Sample2ConditionBeanSetupper<REFERRER_CONDITION_BEAN> conditionBeanSetupper) {
        super(conditionBeanSetupper);
    }

    public Sample2LoadRefererOption(Sample2ConditionBeanSetupper<REFERRER_CONDITION_BEAN> conditionBeanSetupper, Sample2EntityListSetupper<REFERRER_ENTITY> entityListSetupper) {
        super(conditionBeanSetupper, entityListSetupper);
    }

    public Sample2LoadRefererOption(Sample2LoadReferrerOption<REFERRER_CONDITION_BEAN, REFERRER_ENTITY> option) {
        super(option);
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * @return The condition-bean of referrer.
     * @deprecated Sorry! This methid have typo! Please use getRefererConditionBean().
     */
    public REFERRER_CONDITION_BEAN getReffererConditionBean() {
        return super.getReferrerConditionBean();
    }

    /**
     * @param referrerConditionBean The condition-bean of referrer.
     * @deprecated Sorry! This methid have typo! Please use setReferrerConditionBean().
     */
    public void setReffererConditionBean(REFERRER_CONDITION_BEAN referrerConditionBean) {
        super.setReferrerConditionBean(referrerConditionBean);
    }

    /**
     * @return The condition-bean of referrer.
     */
    public REFERRER_CONDITION_BEAN getRefererConditionBean() {
        return super.getReferrerConditionBean();
    }

    /**
     * @param referrerConditionBean The condition-bean of referrer.
     */
    public void setRefererConditionBean(REFERRER_CONDITION_BEAN referrerConditionBean) {
        super.setReferrerConditionBean(referrerConditionBean);
    }
}
