package jp.co.np.p2netex.sample2.cbean.cq.bs;

import java.util.Collection;

import jp.co.np.p2netex.sample2.allcommon.cbean.*;
import jp.co.np.p2netex.sample2.allcommon.cbean.ckey.*;
import jp.co.np.p2netex.sample2.allcommon.cbean.cvalue.Sample2ConditionValue;
import jp.co.np.p2netex.sample2.allcommon.cbean.sqlclause.Sample2SqlClause;
import jp.co.np.p2netex.sample2.cbean.*;
import jp.co.np.p2netex.sample2.cbean.cq.*;

/**
 * The abstract condition-query of SAMPLE2_DEPT.
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public abstract class Sample2AbstractBsSample2DeptCQ extends Sample2AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample2AbstractBsSample2DeptCQ(Sample2ConditionQuery childQuery, Sample2SqlClause sqlClause, String aliasName, int nestLevel) {
        super(childQuery, sqlClause, aliasName, nestLevel);
    }

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
	 * @param sample2EmpCBquery Query.
	 * @deprecated Please use inScopeSample2EmpList(subQuery) method.
	 */
    public void setId_InScopeSubQuery_Sample2EmpList(Sample2Sample2EmpCQ sample2EmpCBquery) {
        String subQueryPropertyName = keepId_InScopeSubQuery_Sample2EmpList(sample2EmpCBquery);// for saving query-value.
        registerInScopeSubQuery(sample2EmpCBquery, "ID", "DEPT_ID", subQueryPropertyName);
    }
    public void inScopeSample2EmpList(Sample2SubQuery<Sample2Sample2EmpCB> subQuery) {
        assertObjectNotNull("subQuery<Sample2Sample2EmpCB>", subQuery);
        Sample2Sample2EmpCB cb = new Sample2Sample2EmpCB(); cb.xsetupForInScopeSubQuery(); subQuery.query(cb);
        String subQueryPropertyName = keepId_InScopeSubQuery_Sample2EmpList(cb.query());// for saving query-value.
        registerInScopeSubQuery(cb.query(), "ID", "DEPT_ID", subQueryPropertyName);
    }
    abstract public String keepId_InScopeSubQuery_Sample2EmpList(Sample2Sample2EmpCQ subQuery);

    public void notInScopeSample2EmpList(Sample2SubQuery<Sample2Sample2EmpCB> subQuery) {
        assertObjectNotNull("subQuery<Sample2Sample2EmpCB>", subQuery);
        Sample2Sample2EmpCB cb = new Sample2Sample2EmpCB(); cb.xsetupForInScopeSubQuery(); subQuery.query(cb);
        String subQueryPropertyName = keepId_NotInScopeSubQuery_Sample2EmpList(cb.query());// for saving query-value.
        registerNotInScopeSubQuery(cb.query(), "ID", "DEPT_ID", subQueryPropertyName);
    }
    abstract public String keepId_NotInScopeSubQuery_Sample2EmpList(Sample2Sample2EmpCQ subQuery);

    /**
	 * @param sample2EmpCBquery Query.
	 * @deprecated Please use existsSample2EmpList(subQuery) method.
	 */
    public void setId_ExistsSubQuery_Sample2EmpList(Sample2Sample2EmpCQ sample2EmpCBquery) {
        String subQueryPropertyName = keepId_ExistsSubQuery_Sample2EmpList(sample2EmpCBquery);// for saving query-value.
        registerExistsSubQuery(sample2EmpCBquery, "ID", "DEPT_ID", subQueryPropertyName);
    }
    /**
     * Set up 'exists' sub-query. {exists (select DEPT_ID from SAMPLE2_EMP where ...)}
     * @param subQuery The sub-query of Id_ExistsSubQuery_Sample2EmpList for 'exists'. (NotNull)
     */
    public void existsSample2EmpList(Sample2SubQuery<Sample2Sample2EmpCB> subQuery) {
        assertObjectNotNull("subQuery<Sample2Sample2EmpCB>", subQuery);
        Sample2Sample2EmpCB cb = new Sample2Sample2EmpCB(); cb.xsetupForExistsSubQuery(); subQuery.query(cb);
        String subQueryPropertyName = keepId_ExistsSubQuery_Sample2EmpList(cb.query());// for saving query-value.
        registerExistsSubQuery(cb.query(), "ID", "DEPT_ID", subQueryPropertyName);
    }
    abstract public String keepId_ExistsSubQuery_Sample2EmpList(Sample2Sample2EmpCQ subQuery);

    /**
     * Set up 'not exists' sub-query. {not exists (select DEPT_ID from SAMPLE2_EMP where ...)}
     * @param subQuery The sub-query of Id_NotExistsSubQuery_Sample2EmpList for 'not exists'. (NotNull)
     */
    public void notExistsSample2EmpList(Sample2SubQuery<Sample2Sample2EmpCB> subQuery) {
        assertObjectNotNull("subQuery<Sample2Sample2EmpCB>", subQuery);
        Sample2Sample2EmpCB cb = new Sample2Sample2EmpCB(); cb.xsetupForExistsSubQuery(); subQuery.query(cb);
        String subQueryPropertyName = keepId_NotExistsSubQuery_Sample2EmpList(cb.query());// for saving query-value.
        registerNotExistsSubQuery(cb.query(), "ID", "DEPT_ID", subQueryPropertyName);
    }
    abstract public String keepId_NotExistsSubQuery_Sample2EmpList(Sample2Sample2EmpCQ subQuery);

    public void xderiveSample2EmpList(String function, Sample2SubQuery<Sample2Sample2EmpCB> subQuery, String aliasName) {
        assertObjectNotNull("subQuery<Sample2Sample2EmpCB>", subQuery);
        Sample2Sample2EmpCB cb = new Sample2Sample2EmpCB(); cb.xsetupForDeriveReferrer(); subQuery.query(cb);
        String subQueryPropertyName = keepId_DeriveSubQuery_Sample2EmpList(cb.query());// for saving query-value.
        registerDeriveSubQuery(function, cb.query(), "ID", "DEPT_ID", subQueryPropertyName, aliasName);
    }
    abstract public String keepId_DeriveSubQuery_Sample2EmpList(Sample2Sample2EmpCQ subQuery);

    protected void regId(Sample2ConditionKey key, Object value) {
        registerQuery(key, value, getCValueId(), "ID", "Id", "id");
    }
    protected void registerInlineId(Sample2ConditionKey key, Object value) {
        registerInlineQuery(key, value, getCValueId(), "ID", "Id", "id");
    }
    abstract protected Sample2ConditionValue getCValueId();

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
    public void setName_LikeSearch(String name, jp.co.np.p2netex.sample2.allcommon.cbean.coption.Sample2LikeSearchOption likeSearchOption) {
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
    public void setName_InScope(String name, jp.co.np.p2netex.sample2.allcommon.cbean.coption.Sample2InScopeOption inScopeOption) {
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

    protected void regName(Sample2ConditionKey key, Object value) {
        registerQuery(key, value, getCValueName(), "NAME", "Name", "name");
    }
    protected void registerInlineName(Sample2ConditionKey key, Object value) {
        registerInlineQuery(key, value, getCValueName(), "NAME", "Name", "name");
    }
    abstract protected Sample2ConditionValue getCValueName();
    
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

    protected void regVersionNo(Sample2ConditionKey key, Object value) {
        registerQuery(key, value, getCValueVersionNo(), "VERSION_NO", "VersionNo", "versionNo");
    }
    protected void registerInlineVersionNo(Sample2ConditionKey key, Object value) {
        registerInlineQuery(key, value, getCValueVersionNo(), "VERSION_NO", "VersionNo", "versionNo");
    }
    abstract protected Sample2ConditionValue getCValueVersionNo();

    // Very Internal (for Suppressing Warn about 'Not Use Import')
    protected String getConditionBeanClassNameInternally() { return Sample2Sample2DeptCB.class.getName(); }
    protected String getConditionQueryClassNameInternally() { return Sample2Sample2DeptCQ.class.getName(); }
}
