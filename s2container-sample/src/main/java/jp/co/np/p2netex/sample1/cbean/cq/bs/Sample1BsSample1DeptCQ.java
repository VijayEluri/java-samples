package jp.co.np.p2netex.sample1.cbean.cq.bs;

import java.util.Map;

import jp.co.np.p2netex.sample1.allcommon.cbean.*;
import jp.co.np.p2netex.sample1.allcommon.cbean.cvalue.Sample1ConditionValue;
import jp.co.np.p2netex.sample1.allcommon.cbean.sqlclause.Sample1SqlClause;
import jp.co.np.p2netex.sample1.cbean.cq.ciq.*;
import jp.co.np.p2netex.sample1.cbean.cq.*;

/**
 * The base condition-query of SAMPLE1_DEPT.
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample1BsSample1DeptCQ extends Sample1AbstractBsSample1DeptCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected Sample1Sample1DeptCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample1BsSample1DeptCQ(Sample1ConditionQuery childQuery, Sample1SqlClause sqlClause, String aliasName, int nestLevel) {
        super(childQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                              Inline
    //                                                                              ======
    /**
     * Prepare inline query. <br />
     * {select ... from ... left outer join (select * from SAMPLE1_DEPT) where abc = [abc] ...}
     * @return Inline query. (NotNull)
     */
    public Sample1Sample1DeptCIQ inline() {
        if (_inlineQuery == null) {
            _inlineQuery = new Sample1Sample1DeptCIQ(getChildQuery(), getSqlClause(), getAliasName(), getNestLevel(), this);
        }
        _inlineQuery.xsetOnClauseInline(false); return _inlineQuery;
    }
    
    /**
     * Prepare on-clause query. <br />
     * {select ... from ... left outer join SAMPLE1_DEPT on ... and abc = [abc] ...}
     * @return On-clause query. (NotNull)
     */
    public Sample1Sample1DeptCIQ on() {
        if (isBaseQuery(this)) { throw new UnsupportedOperationException("Unsupported onClause of Base Table!"); }
        Sample1Sample1DeptCIQ inlineQuery = inline(); inlineQuery.xsetOnClauseInline(true); return inlineQuery;
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
          
    protected Map<String, Sample1Sample1EmpCQ> _id_InScopeSubQuery_Sample1EmpListMap;
    public Map<String, Sample1Sample1EmpCQ> getId_InScopeSubQuery_Sample1EmpList() {
        return _id_InScopeSubQuery_Sample1EmpListMap;
    }
    public String keepId_InScopeSubQuery_Sample1EmpList(Sample1Sample1EmpCQ subQuery) {
        if (_id_InScopeSubQuery_Sample1EmpListMap == null) { _id_InScopeSubQuery_Sample1EmpListMap = newLinkedHashMap(); }
        String key = "subQueryMapKey" + (_id_InScopeSubQuery_Sample1EmpListMap.size() + 1);
        _id_InScopeSubQuery_Sample1EmpListMap.put(key, subQuery); return "id_InScopeSubQuery_Sample1EmpList." + key;
    }

    protected Map<String, Sample1Sample1EmpCQ> _id_NotInScopeSubQuery_Sample1EmpListMap;
    public Map<String, Sample1Sample1EmpCQ> getId_NotInScopeSubQuery_Sample1EmpList() {
        return _id_NotInScopeSubQuery_Sample1EmpListMap;
    }
    public String keepId_NotInScopeSubQuery_Sample1EmpList(Sample1Sample1EmpCQ subQuery) {
        if (_id_NotInScopeSubQuery_Sample1EmpListMap == null) { _id_NotInScopeSubQuery_Sample1EmpListMap = newLinkedHashMap(); }
        String key = "subQueryMapKey" + (_id_NotInScopeSubQuery_Sample1EmpListMap.size() + 1);
        _id_NotInScopeSubQuery_Sample1EmpListMap.put(key, subQuery); return "id_NotInScopeSubQuery_Sample1EmpList." + key;
    }

    protected Map<String, Sample1Sample1EmpCQ> _id_ExistsSubQuery_Sample1EmpListMap;
    public Map<String, Sample1Sample1EmpCQ> getId_ExistsSubQuery_Sample1EmpList() {
        return _id_ExistsSubQuery_Sample1EmpListMap;
    }
    public String keepId_ExistsSubQuery_Sample1EmpList(Sample1Sample1EmpCQ subQuery) {
        if (_id_ExistsSubQuery_Sample1EmpListMap == null) { _id_ExistsSubQuery_Sample1EmpListMap = newLinkedHashMap(); }
        String key = "subQueryMapKey" + (_id_ExistsSubQuery_Sample1EmpListMap.size() + 1);
        _id_ExistsSubQuery_Sample1EmpListMap.put(key, subQuery); return "id_ExistsSubQuery_Sample1EmpList." + key;
    }

    protected Map<String, Sample1Sample1EmpCQ> _id_NotExistsSubQuery_Sample1EmpListMap;
    public Map<String, Sample1Sample1EmpCQ> getId_NotExistsSubQuery_Sample1EmpList() {
        return _id_NotExistsSubQuery_Sample1EmpListMap;
    }
    public String keepId_NotExistsSubQuery_Sample1EmpList(Sample1Sample1EmpCQ subQuery) {
        if (_id_NotExistsSubQuery_Sample1EmpListMap == null) { _id_NotExistsSubQuery_Sample1EmpListMap = newLinkedHashMap(); }
        String key = "subQueryMapKey" + (_id_NotExistsSubQuery_Sample1EmpListMap.size() + 1);
        _id_NotExistsSubQuery_Sample1EmpListMap.put(key, subQuery); return "id_NotExistsSubQuery_Sample1EmpList." + key;
    }

    protected Map<String, Sample1Sample1EmpCQ> _id_DeriveSubQuery_Sample1EmpListMap;
    public Map<String, Sample1Sample1EmpCQ> getId_DeriveSubQuery_Sample1EmpList() {
        return _id_DeriveSubQuery_Sample1EmpListMap;
    }
    public String keepId_DeriveSubQuery_Sample1EmpList(Sample1Sample1EmpCQ subQuery) {
        if (_id_DeriveSubQuery_Sample1EmpListMap == null) { _id_DeriveSubQuery_Sample1EmpListMap = newLinkedHashMap(); }
        String key = "subQueryMapKey" + (_id_DeriveSubQuery_Sample1EmpListMap.size() + 1);
        _id_DeriveSubQuery_Sample1EmpListMap.put(key, subQuery); return "id_DeriveSubQuery_Sample1EmpList." + key;
    }
                    
    public Sample1BsSample1DeptCQ addOrderBy_Id_Asc() { regOBA("ID"); return this; }
    public Sample1BsSample1DeptCQ addOrderBy_Id_Desc() { regOBD("ID"); return this; }

    protected Sample1ConditionValue _name;
    public Sample1ConditionValue getName() {
        if (_name == null) { _name = new Sample1ConditionValue(); }
        return _name;
    }
    protected Sample1ConditionValue getCValueName() { return getName(); }
                        
    public Sample1BsSample1DeptCQ addOrderBy_Name_Asc() { regOBA("NAME"); return this; }
    public Sample1BsSample1DeptCQ addOrderBy_Name_Desc() { regOBD("NAME"); return this; }

    protected Sample1ConditionValue _versionNo;
    public Sample1ConditionValue getVersionNo() {
        if (_versionNo == null) { _versionNo = new Sample1ConditionValue(); }
        return _versionNo;
    }
    protected Sample1ConditionValue getCValueVersionNo() { return getVersionNo(); }
                                  
    public Sample1BsSample1DeptCQ addOrderBy_VersionNo_Asc() { regOBA("VERSION_NO"); return this; }
    public Sample1BsSample1DeptCQ addOrderBy_VersionNo_Desc() { regOBD("VERSION_NO"); return this; }

    // ===================================================================================
    //                                                           Specified Derived OrderBy
    //                                                           =========================
    public Sample1BsSample1DeptCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }
    public Sample1BsSample1DeptCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    protected void reflectRelationOnUnionQuery(Sample1ConditionQuery baseQueryAsSuper, Sample1ConditionQuery unionQueryAsSuper) {
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============


    protected String getConditionQueryClassNameInternally() { return Sample1Sample1DeptCQ.class.getName(); }
    protected String getMapClassNameInternally() { return Map.class.getName(); }
}
