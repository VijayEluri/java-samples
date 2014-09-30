package jp.co.np.p2netex.sample2.cbean.cq.bs;

import java.util.Map;

import jp.co.np.p2netex.sample2.allcommon.cbean.*;
import jp.co.np.p2netex.sample2.allcommon.cbean.cvalue.Sample2ConditionValue;
import jp.co.np.p2netex.sample2.allcommon.cbean.sqlclause.Sample2SqlClause;
import jp.co.np.p2netex.sample2.cbean.cq.ciq.*;
import jp.co.np.p2netex.sample2.cbean.cq.*;

/**
 * The base condition-query of SAMPLE2_EMP.
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample2BsSample2EmpCQ extends Sample2AbstractBsSample2EmpCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected Sample2Sample2EmpCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample2BsSample2EmpCQ(Sample2ConditionQuery childQuery, Sample2SqlClause sqlClause, String aliasName, int nestLevel) {
        super(childQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                              Inline
    //                                                                              ======
    /**
     * Prepare inline query. <br />
     * {select ... from ... left outer join (select * from SAMPLE2_EMP) where abc = [abc] ...}
     * @return Inline query. (NotNull)
     */
    public Sample2Sample2EmpCIQ inline() {
        if (_inlineQuery == null) {
            _inlineQuery = new Sample2Sample2EmpCIQ(getChildQuery(), getSqlClause(), getAliasName(), getNestLevel(), this);
        }
        _inlineQuery.xsetOnClauseInline(false); return _inlineQuery;
    }
    
    /**
     * Prepare on-clause query. <br />
     * {select ... from ... left outer join SAMPLE2_EMP on ... and abc = [abc] ...}
     * @return On-clause query. (NotNull)
     */
    public Sample2Sample2EmpCIQ on() {
        if (isBaseQuery(this)) { throw new UnsupportedOperationException("Unsupported onClause of Base Table!"); }
        Sample2Sample2EmpCIQ inlineQuery = inline(); inlineQuery.xsetOnClauseInline(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====

    protected Sample2ConditionValue _id;
    public Sample2ConditionValue getId() {
        if (_id == null) { _id = new Sample2ConditionValue(); }
        return _id;
    }
    protected Sample2ConditionValue getCValueId() { return getId(); }
                              
    public Sample2BsSample2EmpCQ addOrderBy_Id_Asc() { regOBA("ID"); return this; }
    public Sample2BsSample2EmpCQ addOrderBy_Id_Desc() { regOBD("ID"); return this; }

    protected Sample2ConditionValue _name;
    public Sample2ConditionValue getName() {
        if (_name == null) { _name = new Sample2ConditionValue(); }
        return _name;
    }
    protected Sample2ConditionValue getCValueName() { return getName(); }
                        
    public Sample2BsSample2EmpCQ addOrderBy_Name_Asc() { regOBA("NAME"); return this; }
    public Sample2BsSample2EmpCQ addOrderBy_Name_Desc() { regOBD("NAME"); return this; }

    protected Sample2ConditionValue _hireDate;
    public Sample2ConditionValue getHireDate() {
        if (_hireDate == null) { _hireDate = new Sample2ConditionValue(); }
        return _hireDate;
    }
    protected Sample2ConditionValue getCValueHireDate() { return getHireDate(); }
                            
    public Sample2BsSample2EmpCQ addOrderBy_HireDate_Asc() { regOBA("HIRE_DATE"); return this; }
    public Sample2BsSample2EmpCQ addOrderBy_HireDate_Desc() { regOBD("HIRE_DATE"); return this; }

    protected Sample2ConditionValue _deptId;
    public Sample2ConditionValue getDeptId() {
        if (_deptId == null) { _deptId = new Sample2ConditionValue(); }
        return _deptId;
    }
    protected Sample2ConditionValue getCValueDeptId() { return getDeptId(); }
          
    protected Map<String, Sample2Sample2DeptCQ> _deptId_InScopeSubQuery_Sample2DeptMap;
    public Map<String, Sample2Sample2DeptCQ> getDeptId_InScopeSubQuery_Sample2Dept() {
        return _deptId_InScopeSubQuery_Sample2DeptMap;
    }
    public String keepDeptId_InScopeSubQuery_Sample2Dept(Sample2Sample2DeptCQ subQuery) {
        if (_deptId_InScopeSubQuery_Sample2DeptMap == null) { _deptId_InScopeSubQuery_Sample2DeptMap = newLinkedHashMap(); }
        String key = "subQueryMapKey" + (_deptId_InScopeSubQuery_Sample2DeptMap.size() + 1);
        _deptId_InScopeSubQuery_Sample2DeptMap.put(key, subQuery); return "deptId_InScopeSubQuery_Sample2Dept." + key;
    }
                              
    public Sample2BsSample2EmpCQ addOrderBy_DeptId_Asc() { regOBA("DEPT_ID"); return this; }
    public Sample2BsSample2EmpCQ addOrderBy_DeptId_Desc() { regOBD("DEPT_ID"); return this; }

    protected Sample2ConditionValue _versionNo;
    public Sample2ConditionValue getVersionNo() {
        if (_versionNo == null) { _versionNo = new Sample2ConditionValue(); }
        return _versionNo;
    }
    protected Sample2ConditionValue getCValueVersionNo() { return getVersionNo(); }
                                  
    public Sample2BsSample2EmpCQ addOrderBy_VersionNo_Asc() { regOBA("VERSION_NO"); return this; }
    public Sample2BsSample2EmpCQ addOrderBy_VersionNo_Desc() { regOBD("VERSION_NO"); return this; }

    // ===================================================================================
    //                                                           Specified Derived OrderBy
    //                                                           =========================
    public Sample2BsSample2EmpCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }
    public Sample2BsSample2EmpCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    protected void reflectRelationOnUnionQuery(Sample2ConditionQuery baseQueryAsSuper, Sample2ConditionQuery unionQueryAsSuper) {
        Sample2Sample2EmpCQ baseQuery = (Sample2Sample2EmpCQ)baseQueryAsSuper;
        Sample2Sample2EmpCQ unionQuery = (Sample2Sample2EmpCQ)unionQueryAsSuper;
        if (baseQuery.hasConditionQuerySample2Dept()) {
            unionQuery.querySample2Dept().reflectRelationOnUnionQuery(baseQuery.querySample2Dept(), unionQuery.querySample2Dept());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    
    public Sample2Sample2DeptCQ querySample2Dept() {
        return getConditionQuerySample2Dept();
    }
    protected Sample2Sample2DeptCQ _conditionQuerySample2Dept;
    public Sample2Sample2DeptCQ getConditionQuerySample2Dept() {
        if (_conditionQuerySample2Dept == null) {
            _conditionQuerySample2Dept = createQuerySample2Dept();
            setupOuterJoin_Sample2Dept();
        }
        return _conditionQuerySample2Dept;
    }
    protected void setupOuterJoin_Sample2Dept() {
        Map<String, String> joinOnMap = newLinkedHashMap();
        joinOnMap.put(getRealColumnName("DEPT_ID"), getConditionQuerySample2Dept().getRealColumnName("ID"));
        registerOuterJoin(getConditionQuerySample2Dept(), joinOnMap);
    }
    protected Sample2Sample2DeptCQ createQuerySample2Dept() {
        String nrp = resolveNextRelationPath("SAMPLE2_EMP", "sample2Dept");
        String jan = resolveJoinAliasName(nrp, getNextNestLevel());
        Sample2Sample2DeptCQ cq = new Sample2Sample2DeptCQ(this, getSqlClause(), jan, getNextNestLevel());
        cq.xsetForeignPropertyName("sample2Dept"); cq.xsetRelationPath(nrp); return cq;
    }
    public boolean hasConditionQuerySample2Dept() {
        return _conditionQuerySample2Dept != null;
    }


    protected String getConditionQueryClassNameInternally() { return Sample2Sample2EmpCQ.class.getName(); }
    protected String getMapClassNameInternally() { return Map.class.getName(); }
}
