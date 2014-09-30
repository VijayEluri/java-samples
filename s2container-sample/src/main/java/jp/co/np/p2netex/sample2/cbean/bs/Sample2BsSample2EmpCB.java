package jp.co.np.p2netex.sample2.cbean.bs;

import java.util.Map;

import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2AbstractConditionBean;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2ConditionBean;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2ConditionQuery;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2SubQuery;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2UnionQuery;
import jp.co.np.p2netex.sample2.cbean.*;
import jp.co.np.p2netex.sample2.cbean.cq.*;
import jp.co.np.p2netex.sample2.cbean.nss.*;

/**
 * The base condition-bean of SAMPLE2_EMP.
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample2BsSample2EmpCB extends Sample2AbstractConditionBean {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected Sample2Sample2EmpCQ _conditionQuery;

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    public String getTableDbName() {
        return "SAMPLE2_EMP";
    }

    public String getTableSqlName() {
        return "SAMPLE2_EMP";
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
    public Sample2Sample2EmpCQ query() {
        return getConditionQuery();
    }

    public Sample2Sample2EmpCQ getConditionQuery() {
        if (_conditionQuery == null) {
            _conditionQuery = new Sample2Sample2EmpCQ(null, getSqlClause(), getSqlClause().getLocalTableAliasName(), 0);
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
     * cb.query().union(new Sample2UnionQuery&lt;Sample2Sample2EmpCB&gt;() {
     *     public void query(Sample2Sample2EmpCB unionCB) {
     *         unionCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param unionQuery The query of 'union'. (NotNull)
     */
    public void union(Sample2UnionQuery<Sample2Sample2EmpCB> unionQuery) {
        final Sample2Sample2EmpCB cb = new Sample2Sample2EmpCB(); cb.xsetupForUnion(); unionQuery.query(cb);
        final Sample2Sample2EmpCQ cq = cb.query(); query().xsetUnionQuery(cq);
    }

    /**
     * Set up 'union all'.
     * <pre>
     * cb.query().unionAll(new Sample2UnionQuery&lt;Sample2Sample2EmpCB&gt;() {
     *     public void query(Sample2Sample2EmpCB unionCB) {
     *         unionCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param unionQuery The query of 'union'. (NotNull)
     */
    public void unionAll(Sample2UnionQuery<Sample2Sample2EmpCB> unionQuery) {
        final Sample2Sample2EmpCB cb = new Sample2Sample2EmpCB(); cb.xsetupForUnion(); unionQuery.query(cb);
        final Sample2Sample2EmpCQ cq = cb.query(); query().xsetUnionAllQuery(cq);
    }
    
    /**
     * @param unionQuery The query of 'union'. (NotNull)
     * @deprecated Sorry! Please use union(Sample2UnionQuery<Sample2Sample2EmpCB> unionQuery).
     */
    public void union(Sample2Sample2EmpCQ unionQuery) {
        query().xsetUnionQuery(unionQuery);
    }

    /**
     * @param unionQuery The query of 'union'. (NotNull)
     * @deprecated Sorry! Please use unionAll(Sample2UnionQuery<Sample2Sample2EmpCB> unionQuery).
     */
    public void unionAll(Sample2Sample2EmpCQ unionQuery) {
        query().xsetUnionAllQuery(unionQuery);
    }

    public boolean hasUnionQueryOrUnionAllQuery() {
        return query().hasUnionQueryOrUnionAllQuery();
    }

    // ===================================================================================
    //                                                                        Setup Select
    //                                                                        ============

    protected Sample2Sample2DeptNss _nssSample2Dept;
    public Sample2Sample2DeptNss getNssSample2Dept() {
        if (_nssSample2Dept == null) { _nssSample2Dept = new Sample2Sample2DeptNss(null); }
        return _nssSample2Dept;
    }
    public Sample2Sample2DeptNss setupSelect_Sample2Dept() {
        doSetupSelect(new SsCall() { public Sample2ConditionQuery qf() { return query().querySample2Dept(); } });
        if (_nssSample2Dept == null || !_nssSample2Dept.hasConditionQuery()) { _nssSample2Dept = new Sample2Sample2DeptNss(query().querySample2Dept()); }
        return _nssSample2Dept;
    }

    // [DBFlute-0.7.4]
    // ===================================================================================
    //                                                                             Specify
    //                                                                             =======
    protected Specification _specification;
    public Specification specify() {
        if (_specification == null) { _specification = new Specification(this, new SpQyCall<Sample2Sample2EmpCQ>() {
            public boolean has() { return true; } public Sample2Sample2EmpCQ qy() { return query(); } }, _forDeriveReferrer); } return _specification;
    }
    public static class Specification extends AbstractSpecification<Sample2Sample2EmpCQ> {
        protected SpQyCall<Sample2Sample2EmpCQ> _myQyCall;
        protected Sample2Sample2DeptCB.Specification _sample2Dept;
        public Specification(Sample2ConditionBean baseCB, SpQyCall<Sample2Sample2EmpCQ> qyCall, boolean forDeriveReferrer) { super(baseCB, qyCall, forDeriveReferrer); _myQyCall = qyCall; }
        public void columnId() { doColumn("ID"); }
        public void columnName() { doColumn("NAME"); }
        public void columnHireDate() { doColumn("HIRE_DATE"); }
        public void columnDeptId() { doColumn("DEPT_ID"); }
        public void columnVersionNo() { doColumn("VERSION_NO"); }
        protected void doSpecifyRequiredColumn() {
            columnId();// PK
            if (_myQyCall.qy().hasConditionQuerySample2Dept()) {
                columnDeptId();// FK
            }
        }
        protected String getTableDbName() { return "SAMPLE2_EMP"; }
        public Sample2Sample2DeptCB.Specification specifySample2Dept() {
            assertForeign("sample2Dept");
            if (_sample2Dept == null) {
                _sample2Dept = new Sample2Sample2DeptCB.Specification(_baseCB, new SpQyCall<Sample2Sample2DeptCQ>() {
                    public boolean has() { return _myQyCall.has() && _myQyCall.qy().hasConditionQuerySample2Dept(); }
                    public Sample2Sample2DeptCQ qy() { return _myQyCall.qy().querySample2Dept(); } }, _forDeriveReferrer);
            }
            return _sample2Dept;
        }
    }

    // Very Internal (for Suppressing Warn about 'Not Use Import')
    protected String getConditionBeanClassNameInternally() { return Sample2Sample2EmpCB.class.getName(); }
    protected String getConditionQueryClassNameInternally() { return Sample2Sample2EmpCQ.class.getName(); }
    protected String getSubQueryClassNameInternally() { return Sample2SubQuery.class.getName(); }
}
