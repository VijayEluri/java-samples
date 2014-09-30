package jp.co.np.p2netex.sample1.cbean.bs;

import java.util.Map;

import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1AbstractConditionBean;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1ConditionBean;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1ConditionQuery;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1SubQuery;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1UnionQuery;
import jp.co.np.p2netex.sample1.cbean.*;
import jp.co.np.p2netex.sample1.cbean.cq.*;

/**
 * The base condition-bean of SAMPLE1_DEPT.
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample1BsSample1DeptCB extends Sample1AbstractConditionBean {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected Sample1Sample1DeptCQ _conditionQuery;

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    public String getTableDbName() {
        return "SAMPLE1_DEPT";
    }

    public String getTableSqlName() {
        return "SAMPLE1_DEPT";
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
    public Sample1ConditionBean addOrderBy_PK_Asc() {
        query().addOrderBy_Id_Asc();
        return this;
    }

    public Sample1ConditionBean addOrderBy_PK_Desc() {
        query().addOrderBy_Id_Desc();
        return this;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    public Sample1Sample1DeptCQ query() {
        return getConditionQuery();
    }

    public Sample1Sample1DeptCQ getConditionQuery() {
        if (_conditionQuery == null) {
            _conditionQuery = new Sample1Sample1DeptCQ(null, getSqlClause(), getSqlClause().getLocalTableAliasName(), 0);
        }
        return _conditionQuery;
    }

    public Sample1ConditionQuery getConditionQueryAsInterface() {
        return getConditionQuery();
    }

    // ===================================================================================
    //                                                                               Union
    //                                                                               =====
    /**
     * Set up 'union'.
     * <pre>
     * cb.query().union(new Sample1UnionQuery&lt;Sample1Sample1DeptCB&gt;() {
     *     public void query(Sample1Sample1DeptCB unionCB) {
     *         unionCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param unionQuery The query of 'union'. (NotNull)
     */
    public void union(Sample1UnionQuery<Sample1Sample1DeptCB> unionQuery) {
        final Sample1Sample1DeptCB cb = new Sample1Sample1DeptCB(); cb.xsetupForUnion(); unionQuery.query(cb);
        final Sample1Sample1DeptCQ cq = cb.query(); query().xsetUnionQuery(cq);
    }

    /**
     * Set up 'union all'.
     * <pre>
     * cb.query().unionAll(new Sample1UnionQuery&lt;Sample1Sample1DeptCB&gt;() {
     *     public void query(Sample1Sample1DeptCB unionCB) {
     *         unionCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param unionQuery The query of 'union'. (NotNull)
     */
    public void unionAll(Sample1UnionQuery<Sample1Sample1DeptCB> unionQuery) {
        final Sample1Sample1DeptCB cb = new Sample1Sample1DeptCB(); cb.xsetupForUnion(); unionQuery.query(cb);
        final Sample1Sample1DeptCQ cq = cb.query(); query().xsetUnionAllQuery(cq);
    }
    
    /**
     * @param unionQuery The query of 'union'. (NotNull)
     * @deprecated Sorry! Please use union(Sample1UnionQuery<Sample1Sample1DeptCB> unionQuery).
     */
    public void union(Sample1Sample1DeptCQ unionQuery) {
        query().xsetUnionQuery(unionQuery);
    }

    /**
     * @param unionQuery The query of 'union'. (NotNull)
     * @deprecated Sorry! Please use unionAll(Sample1UnionQuery<Sample1Sample1DeptCB> unionQuery).
     */
    public void unionAll(Sample1Sample1DeptCQ unionQuery) {
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
        if (_specification == null) { _specification = new Specification(this, new SpQyCall<Sample1Sample1DeptCQ>() {
            public boolean has() { return true; } public Sample1Sample1DeptCQ qy() { return query(); } }, _forDeriveReferrer); } return _specification;
    }
    public static class Specification extends AbstractSpecification<Sample1Sample1DeptCQ> {
        protected SpQyCall<Sample1Sample1DeptCQ> _myQyCall;
        public Specification(Sample1ConditionBean baseCB, SpQyCall<Sample1Sample1DeptCQ> qyCall, boolean forDeriveReferrer) { super(baseCB, qyCall, forDeriveReferrer); _myQyCall = qyCall; }
        public void columnId() { doColumn("ID"); }
        public void columnName() { doColumn("NAME"); }
        public void columnVersionNo() { doColumn("VERSION_NO"); }
        protected void doSpecifyRequiredColumn() {
            columnId();// PK
        }
        protected String getTableDbName() { return "SAMPLE1_DEPT"; }
        public RAFunction<Sample1Sample1EmpCB, Sample1Sample1DeptCQ> derivedSample1EmpList() {
            return new RAFunction<Sample1Sample1EmpCB, Sample1Sample1DeptCQ>(_baseCB, _myQyCall.qy(), new RAQSetupper<Sample1Sample1EmpCB, Sample1Sample1DeptCQ>() {
                public void setup(String function, Sample1SubQuery<Sample1Sample1EmpCB> subQuery, Sample1Sample1DeptCQ cq, String aliasName) {
                    cq.xderiveSample1EmpList(function, subQuery, aliasName); } });
        }
    }

    // Very Internal (for Suppressing Warn about 'Not Use Import')
    protected String getConditionBeanClassNameInternally() { return Sample1Sample1DeptCB.class.getName(); }
    protected String getConditionQueryClassNameInternally() { return Sample1Sample1DeptCQ.class.getName(); }
    protected String getSubQueryClassNameInternally() { return Sample1SubQuery.class.getName(); }
}
