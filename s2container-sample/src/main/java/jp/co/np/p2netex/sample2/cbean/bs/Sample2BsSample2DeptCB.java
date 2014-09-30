package jp.co.np.p2netex.sample2.cbean.bs;

import java.util.Map;

import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2AbstractConditionBean;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2ConditionBean;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2ConditionQuery;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2SubQuery;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2UnionQuery;
import jp.co.np.p2netex.sample2.cbean.*;
import jp.co.np.p2netex.sample2.cbean.cq.*;

/**
 * The base condition-bean of SAMPLE2_DEPT.
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample2BsSample2DeptCB extends Sample2AbstractConditionBean {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected Sample2Sample2DeptCQ _conditionQuery;

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    public String getTableDbName() {
        return "SAMPLE2_DEPT";
    }

    public String getTableSqlName() {
        return "SAMPLE2_DEPT";
    }

    // ===================================================================================
    //                                                                      PrimaryKey Map
    //                                                                      ==============
    public void acceptPrimaryKeyMap(Map<String, ? extends Object> primaryKeyMap) {
        assertPrimaryKeyMap(primaryKeyMap);
        {
            Object obj = primaryKeyMap.get("ID");
            if (obj instanceof java.lang.Integer) {
                query().setId_Equal((java.lang.Integer)obj);
            } else {
                query().setId_Equal(new java.lang.Integer((String)obj));
            }
        }

    }

    // ===================================================================================
    //                                                                     OrderBy Setting
    //                                                                     ===============
    public Sample2ConditionBean addOrderBy_PK_Asc() {
        query().addOrderBy_Id_Asc();
        return this;
    }

    public Sample2ConditionBean addOrderBy_PK_Desc() {
        query().addOrderBy_Id_Desc();
        return this;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    public Sample2Sample2DeptCQ query() {
        return getConditionQuery();
    }

    public Sample2Sample2DeptCQ getConditionQuery() {
        if (_conditionQuery == null) {
            _conditionQuery = new Sample2Sample2DeptCQ(null, getSqlClause(), getSqlClause().getLocalTableAliasName(), 0);
        }
        return _conditionQuery;
    }

    public Sample2ConditionQuery getConditionQueryAsInterface() {
        return getConditionQuery();
    }

    // ===================================================================================
    //                                                                               Union
    //                                                                               =====
    /**
     * Set up 'union'.
     * <pre>
     * cb.query().union(new Sample2UnionQuery&lt;Sample2Sample2DeptCB&gt;() {
     *     public void query(Sample2Sample2DeptCB unionCB) {
     *         unionCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param unionQuery The query of 'union'. (NotNull)
     */
    public void union(Sample2UnionQuery<Sample2Sample2DeptCB> unionQuery) {
        final Sample2Sample2DeptCB cb = new Sample2Sample2DeptCB(); cb.xsetupForUnion(); unionQuery.query(cb);
        final Sample2Sample2DeptCQ cq = cb.query(); query().xsetUnionQuery(cq);
    }

    /**
     * Set up 'union all'.
     * <pre>
     * cb.query().unionAll(new Sample2UnionQuery&lt;Sample2Sample2DeptCB&gt;() {
     *     public void query(Sample2Sample2DeptCB unionCB) {
     *         unionCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param unionQuery The query of 'union'. (NotNull)
     */
    public void unionAll(Sample2UnionQuery<Sample2Sample2DeptCB> unionQuery) {
        final Sample2Sample2DeptCB cb = new Sample2Sample2DeptCB(); cb.xsetupForUnion(); unionQuery.query(cb);
        final Sample2Sample2DeptCQ cq = cb.query(); query().xsetUnionAllQuery(cq);
    }
    
    /**
     * @param unionQuery The query of 'union'. (NotNull)
     * @deprecated Sorry! Please use union(Sample2UnionQuery<Sample2Sample2DeptCB> unionQuery).
     */
    public void union(Sample2Sample2DeptCQ unionQuery) {
        query().xsetUnionQuery(unionQuery);
    }

    /**
     * @param unionQuery The query of 'union'. (NotNull)
     * @deprecated Sorry! Please use unionAll(Sample2UnionQuery<Sample2Sample2DeptCB> unionQuery).
     */
    public void unionAll(Sample2Sample2DeptCQ unionQuery) {
        query().xsetUnionAllQuery(unionQuery);
    }

    public boolean hasUnionQueryOrUnionAllQuery() {
        return query().hasUnionQueryOrUnionAllQuery();
    }

    // ===================================================================================
    //                                                                        Setup Select
    //                                                                        ============

    // [DBFlute-0.7.4]
    // ===================================================================================
    //                                                                             Specify
    //                                                                             =======
    protected Specification _specification;
    public Specification specify() {
        if (_specification == null) { _specification = new Specification(this, new SpQyCall<Sample2Sample2DeptCQ>() {
            public boolean has() { return true; } public Sample2Sample2DeptCQ qy() { return query(); } }, _forDeriveReferrer); } return _specification;
    }
    public static class Specification extends AbstractSpecification<Sample2Sample2DeptCQ> {
        protected SpQyCall<Sample2Sample2DeptCQ> _myQyCall;
        public Specification(Sample2ConditionBean baseCB, SpQyCall<Sample2Sample2DeptCQ> qyCall, boolean forDeriveReferrer) { super(baseCB, qyCall, forDeriveReferrer); _myQyCall = qyCall; }
        public void columnId() { doColumn("ID"); }
        public void columnName() { doColumn("NAME"); }
        public void columnVersionNo() { doColumn("VERSION_NO"); }
        protected void doSpecifyRequiredColumn() {
            columnId();// PK
        }
        protected String getTableDbName() { return "SAMPLE2_DEPT"; }
        public RAFunction<Sample2Sample2EmpCB, Sample2Sample2DeptCQ> derivedSample2EmpList() {
            return new RAFunction<Sample2Sample2EmpCB, Sample2Sample2DeptCQ>(_baseCB, _myQyCall.qy(), new RAQSetupper<Sample2Sample2EmpCB, Sample2Sample2DeptCQ>() {
                public void setup(String function, Sample2SubQuery<Sample2Sample2EmpCB> subQuery, Sample2Sample2DeptCQ cq, String aliasName) {
                    cq.xderiveSample2EmpList(function, subQuery, aliasName); } });
        }
    }

    // Very Internal (for Suppressing Warn about 'Not Use Import')
    protected String getConditionBeanClassNameInternally() { return Sample2Sample2DeptCB.class.getName(); }
    protected String getConditionQueryClassNameInternally() { return Sample2Sample2DeptCQ.class.getName(); }
    protected String getSubQueryClassNameInternally() { return Sample2SubQuery.class.getName(); }
}
