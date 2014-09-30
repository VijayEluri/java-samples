package jp.co.np.p2netex.sample1.cbean.cq.bs;

import java.util.Collection;

import jp.co.np.p2netex.sample.*;
import jp.co.np.p2netex.sample1.allcommon.cbean.*;
import jp.co.np.p2netex.sample1.allcommon.cbean.ckey.Sample1ConditionKey;
import jp.co.np.p2netex.sample1.allcommon.cbean.cvalue.Sample1ConditionValue;
import jp.co.np.p2netex.sample1.allcommon.cbean.sqlclause.Sample1SqlClause;
import jp.co.np.p2netex.sample1.cbean.*;
import jp.co.np.p2netex.sample1.cbean.cq.*;

/**
 * The abstract condition-query of SAMPLE1_DEPT.
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public abstract class Sample1AbstractBsSample1DeptCQ extends Sample1AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample1AbstractBsSample1DeptCQ(Sample1ConditionQuery childQuery, Sample1SqlClause sqlClause, String aliasName, int nestLevel) {
        super(childQuery, sqlClause, aliasName, nestLevel);
    }

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
    //                                                                               Query
    //                                                                               =====
    
    /**
     * Equal(=). And NullIgnored, OnceRegistered. {PK : INTEGER : NotNull}
     * @param id The value of id as equal.
     */
    public void setId_Equal(java.lang.Integer id) {
        regId(CK_EQ, id);
    }

    /**
     * NotEqual(!=). And NullIgnored, OnceRegistered.
     * @param id The value of id as notEqual.
     */
    public void setId_NotEqual(java.lang.Integer id) {
        regId(CK_NE, id);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnceRegistered.
     * @param id The value of id as greaterThan.
     */
    public void setId_GreaterThan(java.lang.Integer id) {
        regId(CK_GT, id);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnceRegistered.
     * @param id The value of id as lessThan.
     */
    public void setId_LessThan(java.lang.Integer id) {
        regId(CK_LT, id);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnceRegistered.
     * @param id The value of id as greaterEqual.
     */
    public void setId_GreaterEqual(java.lang.Integer id) {
        regId(CK_GE, id);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnceRegistered.
     * @param id The value of id as lessEqual.
     */
    public void setId_LessEqual(java.lang.Integer id) {
        regId(CK_LE, id);
    }

    /**
     * InScope(in (1, 2)). And NullIgnored, NullElementIgnored, SeveralRegistered.
     * @param idList The collection of id as inScope.
     */
    public void setId_InScope(Collection<java.lang.Integer> idList) {
        regId(CK_INS, cTL(idList));
    }

    /**
     * NotInScope(not in (1, 2)). And NullIgnored, NullElementIgnored, SeveralRegistered.
     * @param idList The collection of id as notInScope.
     */
    public void setId_NotInScope(Collection<java.lang.Integer> idList) {
        regId(CK_NINS, cTL(idList));
    }

    /**
	 * @param sample1EmpCBquery Query.
	 * @deprecated Please use inScopeSample1EmpList(subQuery) method.
	 */
    public void setId_InScopeSubQuery_Sample1EmpList(Sample1Sample1EmpCQ sample1EmpCBquery) {
        String subQueryPropertyName = keepId_InScopeSubQuery_Sample1EmpList(sample1EmpCBquery);// for saving query-value.
        registerInScopeSubQuery(sample1EmpCBquery, "ID", "DEPT_ID", subQueryPropertyName);
    }
    public void inScopeSample1EmpList(Sample1SubQuery<Sample1Sample1EmpCB> subQuery) {
        assertObjectNotNull("subQuery<Sample1Sample1EmpCB>", subQuery);
        Sample1Sample1EmpCB cb = new Sample1Sample1EmpCB(); cb.xsetupForInScopeSubQuery(); subQuery.query(cb);
        String subQueryPropertyName = keepId_InScopeSubQuery_Sample1EmpList(cb.query());// for saving query-value.
        registerInScopeSubQuery(cb.query(), "ID", "DEPT_ID", subQueryPropertyName);
    }
    abstract public String keepId_InScopeSubQuery_Sample1EmpList(Sample1Sample1EmpCQ subQuery);

    public void notInScopeSample1EmpList(Sample1SubQuery<Sample1Sample1EmpCB> subQuery) {
        assertObjectNotNull("subQuery<Sample1Sample1EmpCB>", subQuery);
        Sample1Sample1EmpCB cb = new Sample1Sample1EmpCB(); cb.xsetupForInScopeSubQuery(); subQuery.query(cb);
        String subQueryPropertyName = keepId_NotInScopeSubQuery_Sample1EmpList(cb.query());// for saving query-value.
        registerNotInScopeSubQuery(cb.query(), "ID", "DEPT_ID", subQueryPropertyName);
    }
    abstract public String keepId_NotInScopeSubQuery_Sample1EmpList(Sample1Sample1EmpCQ subQuery);

    /**
	 * @param sample1EmpCBquery Query.
	 * @deprecated Please use existsSample1EmpList(subQuery) method.
	 */
    public void setId_ExistsSubQuery_Sample1EmpList(Sample1Sample1EmpCQ sample1EmpCBquery) {
        String subQueryPropertyName = keepId_ExistsSubQuery_Sample1EmpList(sample1EmpCBquery);// for saving query-value.
        registerExistsSubQuery(sample1EmpCBquery, "ID", "DEPT_ID", subQueryPropertyName);
    }
    /**
     * Set up 'exists' sub-query. {exists (select DEPT_ID from SAMPLE1_EMP where ...)}
     * @param subQuery The sub-query of Id_ExistsSubQuery_Sample1EmpList for 'exists'. (NotNull)
     */
    public void existsSample1EmpList(Sample1SubQuery<Sample1Sample1EmpCB> subQuery) {
        assertObjectNotNull("subQuery<Sample1Sample1EmpCB>", subQuery);
        Sample1Sample1EmpCB cb = new Sample1Sample1EmpCB(); cb.xsetupForExistsSubQuery(); subQuery.query(cb);
        String subQueryPropertyName = keepId_ExistsSubQuery_Sample1EmpList(cb.query());// for saving query-value.
        registerExistsSubQuery(cb.query(), "ID", "DEPT_ID", subQueryPropertyName);
    }
    abstract public String keepId_ExistsSubQuery_Sample1EmpList(Sample1Sample1EmpCQ subQuery);

    /**
     * Set up 'not exists' sub-query. {not exists (select DEPT_ID from SAMPLE1_EMP where ...)}
     * @param subQuery The sub-query of Id_NotExistsSubQuery_Sample1EmpList for 'not exists'. (NotNull)
     */
    public void notExistsSample1EmpList(Sample1SubQuery<Sample1Sample1EmpCB> subQuery) {
        assertObjectNotNull("subQuery<Sample1Sample1EmpCB>", subQuery);
        Sample1Sample1EmpCB cb = new Sample1Sample1EmpCB(); cb.xsetupForExistsSubQuery(); subQuery.query(cb);
        String subQueryPropertyName = keepId_NotExistsSubQuery_Sample1EmpList(cb.query());// for saving query-value.
        registerNotExistsSubQuery(cb.query(), "ID", "DEPT_ID", subQueryPropertyName);
    }
    abstract public String keepId_NotExistsSubQuery_Sample1EmpList(Sample1Sample1EmpCQ subQuery);

    public void xderiveSample1EmpList(String function, Sample1SubQuery<Sample1Sample1EmpCB> subQuery, String aliasName) {
        assertObjectNotNull("subQuery<Sample1Sample1EmpCB>", subQuery);
        Sample1Sample1EmpCB cb = new Sample1Sample1EmpCB(); cb.xsetupForDeriveReferrer(); subQuery.query(cb);
        String subQueryPropertyName = keepId_DeriveSubQuery_Sample1EmpList(cb.query());// for saving query-value.
        registerDeriveSubQuery(function, cb.query(), "ID", "DEPT_ID", subQueryPropertyName, aliasName);
    }
    abstract public String keepId_DeriveSubQuery_Sample1EmpList(Sample1Sample1EmpCQ subQuery);

    protected void regId(Sample1ConditionKey key, Object value) {
        registerQuery(key, value, getCValueId(), "ID", "Id", "id");
    }
    protected void registerInlineId(Sample1ConditionKey key, Object value) {
        registerInlineQuery(key, value, getCValueId(), "ID", "Id", "id");
    }
    abstract protected Sample1ConditionValue getCValueId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnceRegistered. {VARCHAR(20)}
     * @param name The value of name as equal.
     */
    public void setName_Equal(String name) {
        regName(CK_EQ, fRES(name));
    }

    /**
     * NotEqual(!=). And NullOrEmptyIgnored, OnceRegistered.
     * @param name The value of name as notEqual.
     */
    public void setName_NotEqual(String name) {
        regName(CK_NE, fRES(name));
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnceRegistered.
     * @param name The value of name as greaterThan.
     */
    public void setName_GreaterThan(String name) {
        regName(CK_GT, fRES(name));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnceRegistered.
     * @param name The value of name as lessThan.
     */
    public void setName_LessThan(String name) {
        regName(CK_LT, fRES(name));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnceRegistered.
     * @param name The value of name as greaterEqual.
     */
    public void setName_GreaterEqual(String name) {
        regName(CK_GE, fRES(name));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnceRegistered.
     * @param name The value of name as lessEqual.
     */
    public void setName_LessEqual(String name) {
        regName(CK_LE, fRES(name));
    }

    /**
     * PrefixSearch(like 'xxx%'). And NullOrEmptyIgnored, OnceRegistered.
     * @param name The value of name as prefixSearch.
     */
    public void setName_PrefixSearch(String name) {
        regName(CK_PS, fRES(name));
    }

    /**
     * LikeSearch(like 'xxx%' escape ...). And NullOrEmptyIgnored, SeveralRegistered.
     * @param name The value of name as likeSearch.
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setName_LikeSearch(String name, jp.co.np.p2netex.sample1.allcommon.cbean.coption.Sample1LikeSearchOption likeSearchOption) {
        registerLikeSearchQuery(CK_LS, fRES(name), getCValueName(), "NAME", "Name", "name", likeSearchOption);
    }

    /**
     * InScope(in ('a', 'b')). And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered.
     * @param nameList The collection of name as inScope.
     */
    public void setName_InScope(Collection<String> nameList) {
        regName(CK_INS, cTL(nameList));
    }

    /**
     * InScope(in ('a', 'b')). And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered.
     * @param name The collection of name as inScope.
     * @param inScopeOption The option of in-scope. (NotNull)
     */
    public void setName_InScope(String name, jp.co.np.p2netex.sample1.allcommon.cbean.coption.Sample1InScopeOption inScopeOption) {
        registerInScopeQuery(CK_INS, fRES(name), getCValueName(), "NAME", "Name", "name", inScopeOption);
    }

    /**
     * NotInScope(not in ('a', 'b')). And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered.
     * @param nameList The collection of name as notInScope.
     */
    public void setName_NotInScope(Collection<String> nameList) {
        regName(CK_NINS, cTL(nameList));
    }

    /**
     * IsNull(is null). And OnceRegistered.
     */
    public void setName_IsNull() { regName(CK_ISN, DUMMY_OBJECT); }

    /**
     * IsNotNull(is not null). And OnceRegistered.
     */
    public void setName_IsNotNull() { regName(CK_ISNN, DUMMY_OBJECT); }

    protected void regName(Sample1ConditionKey key, Object value) {
        registerQuery(key, value, getCValueName(), "NAME", "Name", "name");
    }
    protected void registerInlineName(Sample1ConditionKey key, Object value) {
        registerInlineQuery(key, value, getCValueName(), "NAME", "Name", "name");
    }
    abstract protected Sample1ConditionValue getCValueName();
    
    /**
     * Equal(=). And NullIgnored, OnceRegistered. {INTEGER}
     * @param versionNo The value of versionNo as equal.
     */
    public void setVersionNo_Equal(java.lang.Integer versionNo) {
        regVersionNo(CK_EQ, versionNo);
    }

    /**
     * NotEqual(!=). And NullIgnored, OnceRegistered.
     * @param versionNo The value of versionNo as notEqual.
     */
    public void setVersionNo_NotEqual(java.lang.Integer versionNo) {
        regVersionNo(CK_NE, versionNo);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnceRegistered.
     * @param versionNo The value of versionNo as greaterThan.
     */
    public void setVersionNo_GreaterThan(java.lang.Integer versionNo) {
        regVersionNo(CK_GT, versionNo);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnceRegistered.
     * @param versionNo The value of versionNo as lessThan.
     */
    public void setVersionNo_LessThan(java.lang.Integer versionNo) {
        regVersionNo(CK_LT, versionNo);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnceRegistered.
     * @param versionNo The value of versionNo as greaterEqual.
     */
    public void setVersionNo_GreaterEqual(java.lang.Integer versionNo) {
        regVersionNo(CK_GE, versionNo);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnceRegistered.
     * @param versionNo The value of versionNo as lessEqual.
     */
    public void setVersionNo_LessEqual(java.lang.Integer versionNo) {
        regVersionNo(CK_LE, versionNo);
    }

    /**
     * InScope(in (1, 2)). And NullIgnored, NullElementIgnored, SeveralRegistered.
     * @param versionNoList The collection of versionNo as inScope.
     */
    public void setVersionNo_InScope(Collection<java.lang.Integer> versionNoList) {
        regVersionNo(CK_INS, cTL(versionNoList));
    }

    /**
     * NotInScope(not in (1, 2)). And NullIgnored, NullElementIgnored, SeveralRegistered.
     * @param versionNoList The collection of versionNo as notInScope.
     */
    public void setVersionNo_NotInScope(Collection<java.lang.Integer> versionNoList) {
        regVersionNo(CK_NINS, cTL(versionNoList));
    }

    /**
     * IsNull(is null). And OnceRegistered.
     */
    public void setVersionNo_IsNull() { regVersionNo(CK_ISN, DUMMY_OBJECT); }

    /**
     * IsNotNull(is not null). And OnceRegistered.
     */
    public void setVersionNo_IsNotNull() { regVersionNo(CK_ISNN, DUMMY_OBJECT); }

    protected void regVersionNo(Sample1ConditionKey key, Object value) {
        registerQuery(key, value, getCValueVersionNo(), "VERSION_NO", "VersionNo", "versionNo");
    }
    protected void registerInlineVersionNo(Sample1ConditionKey key, Object value) {
        registerInlineQuery(key, value, getCValueVersionNo(), "VERSION_NO", "VersionNo", "versionNo");
    }
    abstract protected Sample1ConditionValue getCValueVersionNo();

    // Very Internal (for Suppressing Warn about 'Not Use Import')
    protected String getConditionBeanClassNameInternally() { return Sample1Sample1DeptCB.class.getName(); }
    protected String getConditionQueryClassNameInternally() { return Sample1Sample1DeptCQ.class.getName(); }
}
