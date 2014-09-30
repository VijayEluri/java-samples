package jp.co.np.p2netex.sample1.allcommon.bhv.load;

import jp.co.np.p2netex.sample1.allcommon.Sample1Entity;
import jp.co.np.p2netex.sample1.allcommon.bhv.setup.Sample1ConditionBeanSetupper;
import jp.co.np.p2netex.sample1.allcommon.bhv.setup.Sample1EntityListSetupper;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1ConditionBean;

/**
 * The class of load referrer option.
 * 
 * @param <REFERRER_CONDITION_BEAN> The type of referrer condition-bean.
 * @param <REFERRER_ENTITY> The type of referrer entity.
 * @author DBFlute(AutoGenerator)
 */
public class Sample1LoadRefererOption<REFERRER_CONDITION_BEAN extends Sample1ConditionBean, REFERRER_ENTITY extends Sample1Entity> extends Sample1LoadReferrerOption<REFERRER_CONDITION_BEAN, REFERRER_ENTITY> {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample1LoadRefererOption() {
    }

    public Sample1LoadRefererOption(Sample1ConditionBeanSetupper<REFERRER_CONDITION_BEAN> conditionBeanSetupper) {
        super(conditionBeanSetupper);
    }

    public Sample1LoadRefererOption(Sample1ConditionBeanSetupper<REFERRER_CONDITION_BEAN> conditionBeanSetupper, Sample1EntityListSetupper<REFERRER_ENTITY> entityListSetupper) {
        super(conditionBeanSetupper, entityListSetupper);
    }

    public Sample1LoadRefererOption(Sample1LoadReferrerOption<REFERRER_CONDITION_BEAN, REFERRER_ENTITY> option) {
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
