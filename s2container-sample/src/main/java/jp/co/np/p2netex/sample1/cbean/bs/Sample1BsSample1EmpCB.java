package jp.co.np.p2netex.sample1.cbean.bs;

import java.util.Map;

import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1AbstractConditionBean;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1ConditionBean;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1ConditionQuery;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1SubQuery;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1UnionQuery;
import jp.co.np.p2netex.sample1.cbean.*;
import jp.co.np.p2netex.sample1.cbean.cq.*;
import jp.co.np.p2netex.sample1.cbean.nss.*;

/**
 * The base condition-bean of SAMPLE1_EMP.
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample1BsSample1EmpCB extends Sample1AbstractConditionBean {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected Sample1Sample1EmpCQ _conditionQuery;

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    public String getTableDbName() {
        return "SAMPLE1_EMP";
    }

    public String getTableSqlName() {
        return "SAMPLE1_EMP";
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
    public Sample1Sample1EmpCQ query() {
        return getConditionQuery();
    }

    public Sample1Sample1EmpCQ getConditionQuery() {
        if (_conditionQuery == null) {
            _conditionQuery = new Sample1Sample1EmpCQ(null, getSqlClause(), getSqlClause().getLocalTableAliasName(), 0);
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
     * cb.query().union(new Sample1UnionQuery&lt;Sample1Sample1EmpCB&gt;() {
     *     public void query(Sample1Sample1EmpCB unionCB) {
     *         unionCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param unionQuery The query of 'union'. (NotNull)
     */
    public void union(Sample1UnionQuery<Sample1Sample1EmpCB> unionQuery) {
        final Sample1Sample1EmpCB cb = new Sample1Sample1EmpCB(); cb.xsetupForUnion(); unionQuery.query(cb);
        final Sample1Sample1EmpCQ cq = cb.query(); query().xsetUnionQuery(cq);
    }

    /**
     * Set up 'union all'.
     * <pre>
     * cb.query().unionAll(new Sample1UnionQuery&lt;Sample1Sample1EmpCB&gt;() {
     *     public void query(Sample1Sample1EmpCB unionCB) {
     *         unionCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param unionQuery The query of 'union'. (NotNull)
     */
    public void unionAll(Sample1UnionQuery<Sample1Sample1EmpCB> unionQuery) {
        final Sample1Sample1EmpCB cb = new Sample1Sample1EmpCB(); cb.xsetupForUnion(); unionQuery.query(cb);
        final Sample1Sample1EmpCQ cq = cb.query(); query().xsetUnionAllQuery(cq);
    }
    
    /**
     * @param unionQuery The query of 'union'. (NotNull)
     * @deprecated Sorry! Please use union(Sample1UnionQuery<Sample1Sample1EmpCB> unionQuery).
     */
    public void union(Sample1Sample1EmpCQ unionQuery) {
        query().xsetUnionQuery(unionQuery);
    }

    /**
     * @param unionQuery The query of 'union'. (NotNull)
     * @deprecated Sorry! Please use unionAll(Sample1UnionQuery<Sample1Sample1EmpCB> unionQuery).
     */
    public void unionAll(Sample1Sample1EmpCQ unionQuery) {
        query().xsetUnionAllQuery(unionQuery);
    }

    public boolean hasUnionQueryOrUnionAllQuery() {
        return query().hasUnionQueryOrUnionAllQuery();
    }

    // ===================================================================================
    //                                                                        Setup Select
    //                                                                        ============

    protected Sample1Sample1DeptNss _nssSample1Dept;
    public Sample1Sample1DeptNss getNssSample1Dept() {
        if (_nssSample1Dept == null) { _nssSample1Dept = new Sample1Sample1DeptNss(null); }
        return _nssSample1Dept;
    }
    public Sample1Sample1DeptNss setupSelect_Sample1Dept() {
        doSetupSelect(new SsCall() { public Sample1ConditionQuery qf() { return query().querySample1Dept(); } });
        if (_nssSample1Dept == null || !_nssSample1Dept.hasConditionQuery()) { _nssSample1Dept = new Sample1Sample1DeptNss(query().querySample1Dept()); }
        return _nssSample1Dept;
    }

    // [DBFlute-0.7.4]
    // ===================================================================================
    //                                                                             Specify
    //                                                                             =======
    protected Specification _specification;
    public Specification specify() {
        if (_specification == null) { _specification = new Specification(this, new SpQyCall<Sample1Sample1EmpCQ>() {
            public boolean has() { return true; } public Sample1Sample1EmpCQ qy() { return query(); } }, _forDeriveReferrer); } return _specification;
    }
    public static class Specification extends AbstractSpecification<Sample1Sample1EmpCQ> {
        protected SpQyCall<Sample1Sample1EmpCQ> _myQyCall;
        protected Sample1Sample1DeptCB.Specification _sample1Dept;
        public Specification(Sample1ConditionBean baseCB, SpQyCall<Sample1Sample1EmpCQ> qyCall, boolean forDeriveReferrer) { super(baseCB, qyCall, forDeriveReferrer); _myQyCall = qyCall; }
        public void columnId() { doColumn("ID"); }
        public void columnName() { doColumn("NAME"); }
        public void columnHireDate() { doColumn("HIRE_DATE"); }
        public void columnDeptId() { doColumn("DEPT_ID"); }
        public void columnVersionNo() { doColumn("VERSION_NO"); }
        protected void doSpecifyRequiredColumn() {
            columnId();// PK
            if (_myQyCall.qy().hasConditionQuerySample1Dept()) {
                columnDeptId();// FK
            }
        }
        protected String getTableDbName() { return "SAMPLE1_EMP"; }
        public Sample1Sample1DeptCB.Specification specifySample1Dept() {
            assertForeign("sample1Dept");
            if (_sample1Dept == null) {
                _sample1Dept = new Sample1Sample1DeptCB.Specification(_baseCB, new SpQyCall<Sample1Sample1DeptCQ>() {
                    public boolean has() { return _myQyCall.has() && _myQyCall.qy().hasConditionQuerySample1Dept(); }
                    public Sample1Sample1DeptCQ qy() { return _myQyCall.qy().querySample1Dept(); } }, _forDeriveReferrer);
            }
            return _sample1Dept;
        }
    }

    // Very Internal (for Suppressing Warn about 'Not Use Import')
    protected String getConditionBeanClassNameInternally() { return Sample1Sample1EmpCB.class.getName(); }
    protected String getConditionQueryClassNameInternally() { return Sample1Sample1EmpCQ.class.getName(); }
    protected String getSubQueryClassNameInternally() { return Sample1SubQuery.class.getName(); }
}
