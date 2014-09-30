package jp.co.np.p2netex.sample1.cbean.cq;


import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1ConditionQuery;
import jp.co.np.p2netex.sample1.allcommon.cbean.sqlclause.Sample1SqlClause;
import jp.co.np.p2netex.sample1.cbean.cq.bs.Sample1BsSample1EmpCQ;

/**
 * The condition-query of SAMPLE1_EMP.
 * <p>
 * You can implement your original methods here.
 * This class is NOT overrided when re-generating.
 * </p>
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample1Sample1EmpCQ extends Sample1BsSample1EmpCQ {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * Constructor.
     * @param childQuery Child query as abstract class. (Nullable: If null, this is base instance.)
     * @param sqlClause SQL clause instance. (NotNull)
     * @param aliasName My alias name. (NotNull)
     * @param nestLevel Nest level.
     */
    public Sample1Sample1EmpCQ(Sample1ConditionQuery childQuery, Sample1SqlClause sqlClause, String aliasName, int nestLevel) {
        super(childQuery, sqlClause, aliasName, nestLevel);
    }
	
    // ===================================================================================
    //                                                                      Arrange Method
    //                                                                      ==============
	// You can make original arrange query methods here.
	// public void arranegeXxx() {
	//     ...
	// }
}
