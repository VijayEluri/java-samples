package jp.co.np.p2netex.sample1.cbean.cq.bs;

import java.util.Map;

import jp.co.np.p2netex.sample1.allcommon.cbean.*;
import jp.co.np.p2netex.sample1.allcommon.cbean.cvalue.Sample1ConditionValue;
import jp.co.np.p2netex.sample1.allcommon.cbean.sqlclause.Sample1SqlClause;
import jp.co.np.p2netex.sample1.cbean.cq.ciq.*;
import jp.co.np.p2netex.sample1.cbean.cq.*;

/**
 * The base condition-query of SAMPLE1_EMP.
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample1BsSample1EmpCQ extends Sample1AbstractBsSample1EmpCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected Sample1Sample1EmpCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample1BsSample1EmpCQ(Sample1ConditionQuery childQuery, Sample1SqlClause sqlClause, String aliasName, int nestLevel) {
        super(childQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                              Inline
    //                                                                              ======
    /**
     * Prepare inline query. <br />
     * {select ... from ... left outer join (select * from SAMPLE1_EMP) where abc = [abc] ...}
     * @return Inline query. (NotNull)
     */
    public Sample1Sample1EmpCIQ inline() {
        if (_inlineQuery == null) {
            _inlineQuery = new Sample1Sample1EmpCIQ(getChildQuery(), getSqlClause(), getAliasName(), getNestLevel(), this);
        }
        _inlineQuery.xsetOnClauseInline(false); return _inlineQuery;
    }
    
    /**
     * Prepare on-clause query. <br />
     * {select ... from ... left outer join SAMPLE1_EMP on ... and abc = [abc] ...}
     * @return On-clause query. (NotNull)
     */
    public Sample1Sample1EmpCIQ on() {
        if (isBaseQuery(this)) { throw new UnsupportedOperationException("Unsupported onClause of Base Table!"); }
        Sample1Sample1EmpCIQ inlineQuery = inline(); inlineQuery.xsetOnClauseInline(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====

    protected Sample1ConditionValue _id;
    public Sample1ConditionValue getId() {
        if (_id == null) { _id = new Sample1ConditionValue(); }
        return _id;
    }
    protected Sample1ConditionValue getCValueId() { return getId(); }
                              
    public Sample1BsSample1EmpCQ addOrderBy_Id_Asc() { regOBA("ID"); return this; }
    public Sample1BsSample1EmpCQ addOrderBy_Id_Desc() { regOBD("ID"); return this; }

    protected Sample1ConditionValue _name;
    public Sample1ConditionValue getName() {
        if (_name == null) { _name = new Sample1ConditionValue(); }
        return _name;
    }
    protected Sample1ConditionValue getCValueName() { return getName(); }
                        
    public Sample1BsSample1EmpCQ addOrderBy_Name_Asc() { regOBA("NAME"); return this; }
    public Sample1BsSample1EmpCQ addOrderBy_Name_Desc() { regOBD("NAME"); return this; }

    protected Sample1ConditionValue _hireDate;
    public Sample1ConditionValue getHireDate() {
        if (_hireDate == null) { _hireDate = new Sample1ConditionValue(); }
        return _hireDate;
    }
    protected Sample1ConditionValue getCValueHireDate() { return getHireDate(); }
                            
    public Sample1BsSample1EmpCQ addOrderBy_HireDate_Asc() { regOBA("HIRE_DATE"); return this; }
    public Sample1BsSample1EmpCQ addOrderBy_HireDate_Desc() { regOBD("HIRE_DATE"); return this; }

    protected Sample1ConditionValue _deptId;
    public Sample1ConditionValue getDeptId() {
        if (_deptId == null) { _deptId = new Sample1ConditionValue(); }
        return _deptId;
    }
    protected Sample1ConditionValue getCValueDeptId() { return getDeptId(); }
          
    protected Map<String, Sample1Sample1DeptCQ> _deptId_InScopeSubQuery_Sample1DeptMap;
    public Map<String, Sample1Sample1DeptCQ> getDeptId_InScopeSubQuery_Sample1Dept() {
        return _deptId_InScopeSubQuery_Sample1DeptMap;
    }
    public String keepDeptId_InScopeSubQuery_Sample1Dept(Sample1Sample1DeptCQ subQuery) {
        if (_deptId_InScopeSubQuery_Sample1DeptMap == null) { _deptId_InScopeSubQuery_Sample1DeptMap = newLinkedHashMap(); }
        String key = "subQueryMapKey" + (_deptId_InScopeSubQuery_Sample1DeptMap.size() + 1);
        _deptId_InScopeSubQuery_Sample1DeptMap.put(key, subQuery); return "deptId_InScopeSubQuery_Sample1Dept." + key;
    }
                              
    public Sample1BsSample1EmpCQ addOrderBy_DeptId_Asc() { regOBA("DEPT_ID"); return this; }
    public Sample1BsSample1EmpCQ addOrderBy_DeptId_Desc() { regOBD("DEPT_ID"); return this; }

    protected Sample1ConditionValue _versionNo;
    public Sample1ConditionValue getVersionNo() {
        if (_versionNo == null) { _versionNo = new Sample1ConditionValue(); }
        return _versionNo;
    }
    protected Sample1ConditionValue getCValueVersionNo() { return getVersionNo(); }
                                  
    public Sample1BsSample1EmpCQ addOrderBy_VersionNo_Asc() { regOBA("VERSION_NO"); return this; }
    public Sample1BsSample1EmpCQ addOrderBy_VersionNo_Desc() { regOBD("VERSION_NO"); return this; }

    // ===================================================================================
    //                                                           Specified Derived OrderBy
    //                                                           =========================
    public Sample1BsSample1EmpCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }
    public Sample1BsSample1EmpCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    protected void reflectRelationOnUnionQuery(Sample1ConditionQuery baseQueryAsSuper, Sample1ConditionQuery unionQueryAsSuper) {
        Sample1Sample1EmpCQ baseQuery = (Sample1Sample1EmpCQ)baseQueryAsSuper;
        Sample1Sample1EmpCQ unionQuery = (Sample1Sample1EmpCQ)unionQueryAsSuper;
        if (baseQuery.hasConditionQuerySample1Dept()) {
            unionQuery.querySample1Dept().reflectRelationOnUnionQuery(baseQuery.querySample1Dept(), unionQuery.querySample1Dept());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    
    public Sample1Sample1DeptCQ querySample1Dept() {
        return getConditionQuerySample1Dept();
    }
    protected Sample1Sample1DeptCQ _conditionQuerySample1Dept;
    public Sample1Sample1DeptCQ getConditionQuerySample1Dept() {
        if (_conditionQuerySample1Dept == null) {
            _conditionQuerySample1Dept = createQuerySample1Dept();
            setupOuterJoin_Sample1Dept();
        }
        return _conditionQuerySample1Dept;
    }
    protected void setupOuterJoin_Sample1Dept() {
        Map<String, String> joinOnMap = newLinkedHashMap();
        joinOnMap.put(getRealColumnName("DEPT_ID"), getConditionQuerySample1Dept().getRealColumnName("ID"));
        registerOuterJoin(getConditionQuerySample1Dept(), joinOnMap);
    }
    protected Sample1Sample1DeptCQ createQuerySample1Dept() {
        String nrp = resolveNextRelationPath("SAMPLE1_EMP", "sample1Dept");
        String jan = resolveJoinAliasName(nrp, getNextNestLevel());
        Sample1Sample1DeptCQ cq = new Sample1Sample1DeptCQ(this, getSqlClause(), jan, getNextNestLevel());
        cq.xsetForeignPropertyName("sample1Dept"); cq.xsetRelationPath(nrp); return cq;
    }
    public boolean hasConditionQuerySample1Dept() {
        return _conditionQuerySample1Dept != null;
    }


    protected String getConditionQueryClassNameInternally() { return Sample1Sample1EmpCQ.class.getName(); }
    protected String getMapClassNameInternally() { return Map.class.getName(); }
}
