package jp.co.np.p2netex.sample2.cbean.nss;

import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2ConditionQuery;
import jp.co.np.p2netex.sample2.cbean.cq.Sample2Sample2EmpCQ;

/**
 * The nest-select-setupper of SAMPLE2_EMP.
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample2Sample2EmpNss {

    protected Sample2Sample2EmpCQ _query;
    public Sample2Sample2EmpNss(Sample2Sample2EmpCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                           With Nested Foreign Table
    //                                                           =========================
    public Sample2Sample2DeptNss withSample2Dept() {
        _query.doNss(new Sample2Sample2EmpCQ.NssCall() { public Sample2ConditionQuery qf() { return _query.querySample2Dept(); }});
		return new Sample2Sample2DeptNss(_query.querySample2Dept());
    }

    // ===================================================================================
    //                                                          With Nested Referrer Table
    //                                                          ==========================
}
