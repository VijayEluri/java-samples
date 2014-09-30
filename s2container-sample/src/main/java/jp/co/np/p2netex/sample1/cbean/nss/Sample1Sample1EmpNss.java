package jp.co.np.p2netex.sample1.cbean.nss;

import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1ConditionQuery;
import jp.co.np.p2netex.sample1.cbean.cq.Sample1Sample1EmpCQ;

/**
 * The nest-select-setupper of SAMPLE1_EMP.
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample1Sample1EmpNss {

    protected Sample1Sample1EmpCQ _query;
    public Sample1Sample1EmpNss(Sample1Sample1EmpCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                           With Nested Foreign Table
    //                                                           =========================
    public Sample1Sample1DeptNss withSample1Dept() {
        _query.doNss(new Sample1Sample1EmpCQ.NssCall() { public Sample1ConditionQuery qf() { return _query.querySample1Dept(); }});
		return new Sample1Sample1DeptNss(_query.querySample1Dept());
    }

    // ===================================================================================
    //                                                          With Nested Referrer Table
    //                                                          ==========================
}
