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
public class Sample1LoadReferrerOption<REFERRER_CONDITION_BEAN extends Sample1ConditionBean, REFERRER_ENTITY extends Sample1Entity> {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected Sample1ConditionBeanSetupper<REFERRER_CONDITION_BEAN> _conditionBeanSetupper;

    protected Sample1EntityListSetupper<REFERRER_ENTITY> _entityListSetupper;

    protected REFERRER_CONDITION_BEAN _referrerConditionBean;

    protected boolean _toLastKeyCondition;

    protected boolean _stopOrderByKey;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample1LoadReferrerOption() {
    }

    public Sample1LoadReferrerOption(Sample1ConditionBeanSetupper<REFERRER_CONDITION_BEAN> conditionBeanSetupper) {
        this._conditionBeanSetupper = conditionBeanSetupper;
    }

    public Sample1LoadReferrerOption(Sample1ConditionBeanSetupper<REFERRER_CONDITION_BEAN> conditionBeanSetupper, Sample1EntityListSetupper<REFERRER_ENTITY> entityListSetupper) {
        this._conditionBeanSetupper = conditionBeanSetupper;
        this._entityListSetupper = entityListSetupper;
    }

    public Sample1LoadReferrerOption(Sample1LoadReferrerOption<REFERRER_CONDITION_BEAN, REFERRER_ENTITY> option) {
        this._conditionBeanSetupper = option._conditionBeanSetupper;
        this._entityListSetupper = option._entityListSetupper;
        this._referrerConditionBean = option._referrerConditionBean;
        this._toLastKeyCondition = option._toLastKeyCondition;
        this._stopOrderByKey = option._stopOrderByKey;
    }

    // ===================================================================================
    //                                                                         Easy-to-Use
    //                                                                         ===========
    /**
     * Specify that the key condition is added as last condition. <br />
     * This method is valid only after you use reffererConditionBean and add your original condition to it.
     * @return this. (NotNull)
     */
    public Sample1LoadReferrerOption<REFERRER_CONDITION_BEAN, REFERRER_ENTITY> toLastKeyCondition() {
        _toLastKeyCondition = true;
        return this;
    }

    /**
     * Specify that it stops adding order-by of the key. <br />
     * This method is valid only after you use reffererConditionBean and add your original order-by to it.
     * @return this. (NotNull)
     */
    public Sample1LoadReferrerOption<REFERRER_CONDITION_BEAN, REFERRER_ENTITY> stopOrderByKey() {
        _stopOrderByKey = true;
        return this;
    }

    public void delegateKeyConditionExchangingFirstWhereClauseForLastOne(REFERRER_CONDITION_BEAN cb) {// Internal
        if (!_toLastKeyCondition) {
            cb.getSqlClause().exchangeFirstWhereClauseForLastOne();
        }
    }

    public void delegateConditionBeanSettingUp(REFERRER_CONDITION_BEAN cb) {// Internal
        if (_conditionBeanSetupper != null) {
            _conditionBeanSetupper.setup(cb);
        }
    }

    public void delegateEntitySettingUp(java.util.List<REFERRER_ENTITY> entityList) {// Internal
        if (_entityListSetupper != null) {
            _entityListSetupper.setup(entityList);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public Sample1ConditionBeanSetupper<REFERRER_CONDITION_BEAN> getConditionBeanSetupper() {
        return _conditionBeanSetupper;
    }

    public void setConditionBeanSetupper(Sample1ConditionBeanSetupper<REFERRER_CONDITION_BEAN> conditionBeanSetupper) {
        this._conditionBeanSetupper = conditionBeanSetupper;
    }

    public Sample1EntityListSetupper<REFERRER_ENTITY> getEntityListSetupper() {
        return _entityListSetupper;
    }

    public void setEntityListSetupper(Sample1EntityListSetupper<REFERRER_ENTITY> entityListSetupper) {
        this._entityListSetupper = entityListSetupper;
    }

    public REFERRER_CONDITION_BEAN getReferrerConditionBean() {
        return _referrerConditionBean;
    }

    public void setReferrerConditionBean(REFERRER_CONDITION_BEAN referrerConditionBean) {
        this._referrerConditionBean = referrerConditionBean;
    }

    public boolean isToLastKeyCondition() {
        return _toLastKeyCondition;
    }

    public boolean isStopOrderByKey() {
        return _stopOrderByKey;
    }
}
