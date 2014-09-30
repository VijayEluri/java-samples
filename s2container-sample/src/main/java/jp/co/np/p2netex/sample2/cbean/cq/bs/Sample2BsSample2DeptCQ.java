package jp.co.np.p2netex.sample2.cbean.cq.bs;

import java.util.Map;

import jp.co.np.p2netex.sample2.allcommon.cbean.*;
import jp.co.np.p2netex.sample2.allcommon.cbean.cvalue.Sample2ConditionValue;
import jp.co.np.p2netex.sample2.allcommon.cbean.sqlclause.Sample2SqlClause;
import jp.co.np.p2netex.sample2.cbean.cq.ciq.*;
import jp.co.np.p2netex.sample2.cbean.cq.*;

/**
 * The base condition-query of SAMPLE2_DEPT.
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample2BsSample2DeptCQ extends Sample2AbstractBsSample2DeptCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected Sample2Sample2DeptCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample2BsSample2DeptCQ(Sample2ConditionQuery childQuery, Sample2SqlClause sqlClause, String aliasName, int nestLevel) {
        super(childQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                              Inline
    //                                                                              ======
    /**
     * Prepare inline query. <br />
     * {select ... from ... left outer join (select * from SAMPLE2_DEPT) where abc = [abc] ...}
     * @return Inline query. (NotNull)
     */
    public Sample2Sample2DeptCIQ inline() {
        if (_inlineQuery == null) {
            _inlineQuery = new Sample2Sample2DeptCIQ(getChildQuery(), getSqlClause(), getAliasName(), getNestLevel(), this);
        }
        _inlineQuery.xsetOnClauseInline(false); return _inlineQuery;
    }
    
    /**
     * Prepare on-clause query. <br />
     * {select ... from ... left outer join SAMPLE2_DEPT on ... and abc = [abc] ...}
     * @return On-clause query. (NotNull)
     */
    public Sample2Sample2DeptCIQ on() {
        if (isBaseQuery(this)) { throw new UnsupportedOperationException("Unsupported onClause of Base Table!"); }
        Sample2Sample2DeptCIQ inlineQuery = inline(); inlineQuery.xsetOnClauseInline(true); return inlineQuery;
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
          
    protected Map<String, Sample2Sample2EmpCQ> _id_InScopeSubQuery_Sample2EmpListMap;
    public Map<String, Sample2Sample2EmpCQ> getId_InScopeSubQuery_Sample2EmpList() {
        return _id_InScopeSubQuery_Sample2EmpListMap;
    }
    public String keepId_InScopeSubQuery_Sample2EmpList(Sample2Sample2EmpCQ subQuery) {
        if (_id_InScopeSubQuery_Sample2EmpListMap == null) { _id_InScopeSubQuery_Sample2EmpListMap = newLinkedHashMap(); }
        String key = "subQueryMapKey" + (_id_InScopeSubQuery_Sample2EmpListMap.size() + 1);
        _id_InScopeSubQuery_Sample2EmpListMap.put(key, subQuery); return "id_InScopeSubQuery_Sample2EmpList." + key;
    }

    protected Map<String, Sample2Sample2EmpCQ> _id_NotInScopeSubQuery_Sample2EmpListMap;
    public Map<String, Sample2Sample2EmpCQ> getId_NotInScopeSubQuery_Sample2EmpList() {
        return _id_NotInScopeSubQuery_Sample2EmpListMap;
    }
    public String keepId_NotInScopeSubQuery_Sample2EmpList(Sample2Sample2EmpCQ subQuery) {
        if (_id_NotInScopeSubQuery_Sample2EmpListMap == null) { _id_NotInScopeSubQuery_Sample2EmpListMap = newLinkedHashMap(); }
        String key = "subQueryMapKey" + (_id_NotInScopeSubQuery_Sample2EmpListMap.size() + 1);
        _id_NotInScopeSubQuery_Sample2EmpListMap.put(key, subQuery); return "id_NotInScopeSubQuery_Sample2EmpList." + key;
    }

    protected Map<String, Sample2Sample2EmpCQ> _id_ExistsSubQuery_Sample2EmpListMap;
    public Map<String, Sample2Sample2EmpCQ> getId_ExistsSubQuery_Sample2EmpList() {
        return _id_ExistsSubQuery_Sample2EmpListMap;
    }
    public String keepId_ExistsSubQuery_Sample2EmpList(Sample2Sample2EmpCQ subQuery) {
        if (_id_ExistsSubQuery_Sample2EmpListMap == null) { _id_ExistsSubQuery_Sample2EmpListMap = newLinkedHashMap(); }
        String key = "subQueryMapKey" + (_id_ExistsSubQuery_Sample2EmpListMap.size() + 1);
        _id_ExistsSubQuery_Sample2EmpListMap.put(key, subQuery); return "id_ExistsSubQuery_Sample2EmpList." + key;
    }

    protected Map<String, Sample2Sample2EmpCQ> _id_NotExistsSubQuery_Sample2EmpListMap;
    public Map<String, Sample2Sample2EmpCQ> getId_NotExistsSubQuery_Sample2EmpList() {
        return _id_NotExistsSubQuery_Sample2EmpListMap;
    }
    public String keepId_NotExistsSubQuery_Sample2EmpList(Sample2Sample2EmpCQ subQuery) {
        if (_id_NotExistsSubQuery_Sample2EmpListMap == null) { _id_NotExistsSubQuery_Sample2EmpListMap = newLinkedHashMap(); }
        String key = "subQueryMapKey" + (_id_NotExistsSubQuery_Sample2EmpListMap.size() + 1);
        _id_NotExistsSubQuery_Sample2EmpListMap.put(key, subQuery); return "id_NotExistsSubQuery_Sample2EmpList." + key;
    }

    protected Map<String, Sample2Sample2EmpCQ> _id_DeriveSubQuery_Sample2EmpListMap;
    public Map<String, Sample2Sample2EmpCQ> getId_DeriveSubQuery_Sample2EmpList() {
        return _id_DeriveSubQuery_Sample2EmpListMap;
    }
    public String keepId_DeriveSubQuery_Sample2EmpList(Sample2Sample2EmpCQ subQuery) {
        if (_id_DeriveSubQuery_Sample2EmpListMap == null) { _id_DeriveSubQuery_Sample2EmpListMap = newLinkedHashMap(); }
        String key = "subQueryMapKey" + (_id_DeriveSubQuery_Sample2EmpListMap.size() + 1);
        _id_DeriveSubQuery_Sample2EmpListMap.put(key, subQuery); return "id_DeriveSubQuery_Sample2EmpList." + key;
    }
                    
    public Sample2BsSample2DeptCQ addOrderBy_Id_Asc() { regOBA("ID"); return this; }
    public Sample2BsSample2DeptCQ addOrderBy_Id_Desc() { regOBD("ID"); return this; }

    protected Sample2ConditionValue _name;
    public Sample2ConditionValue getName() {
        if (_name == null) { _name = new Sample2ConditionValue(); }
        return _name;
    }
    protected Sample2ConditionValue getCValueName() { return getName(); }
                        
    public Sample2BsSample2DeptCQ addOrderBy_Name_Asc() { regOBA("NAME"); return this; }
    public Sample2BsSample2DeptCQ addOrderBy_Name_Desc() { regOBD("NAME"); return this; }

    protected Sample2ConditionValue _versionNo;
    public Sample2ConditionValue getVersionNo() {
        if (_versionNo == null) { _versionNo = new Sample2ConditionValue(); }
        return _versionNo;
    }
    protected Sample2ConditionValue getCValueVersionNo() { return getVersionNo(); }
                                  
    public Sample2BsSample2DeptCQ addOrderBy_VersionNo_Asc() { regOBA("VERSION_NO"); return this; }
    public Sample2BsSample2DeptCQ addOrderBy_VersionNo_Desc() { regOBD("VERSION_NO"); return this; }

    // ===================================================================================
    //                                                           Specified Derived OrderBy
    //                                                           =========================
    public Sample2BsSample2DeptCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }
    public Sample2BsSample2DeptCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    protected void reflectRelationOnUnionQuery(Sample2ConditionQuery baseQueryAsSuper, Sample2ConditionQuery unionQueryAsSuper) {
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============


    protected String getConditionQueryClassNameInternally() { return Sample2Sample2DeptCQ.class.getName(); }
    protected String getMapClassNameInternally() { return Map.class.getName(); }
}
