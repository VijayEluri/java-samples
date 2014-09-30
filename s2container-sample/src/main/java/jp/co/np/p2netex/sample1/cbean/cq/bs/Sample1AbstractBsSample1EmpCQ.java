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
 * The abstract condition-query of SAMPLE1_EMP.
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public abstract class Sample1AbstractBsSample1EmpCQ extends Sample1AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample1AbstractBsSample1EmpCQ(Sample1ConditionQuery childQuery, Sample1SqlClause sqlClause, String aliasName, int nestLevel) {
        super(childQuery, sqlClause, aliasName, nestLevel);
    }

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
     * Equal(=). And NullIgnored, OnceRegistered. {DATE}
     * @param hireDate The value of hireDate as equal.
     */
    public void setHireDate_Equal(java.util.Date hireDate) {
        regHireDate(CK_EQ, hireDate);
    }

    /**
     * NotEqual(!=). And NullIgnored, OnceRegistered.
     * @param hireDate The value of hireDate as notEqual.
     */
    public void setHireDate_NotEqual(java.util.Date hireDate) {
        regHireDate(CK_NE, hireDate);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnceRegistered.
     * @param hireDate The value of hireDate as greaterThan.
     */
    public void setHireDate_GreaterThan(java.util.Date hireDate) {
        regHireDate(CK_GT, hireDate);
    }

    /**
     * LessThan(&gt;). And NullIgnored, OnceRegistered.
     * @param hireDate The value of hireDate as lessThan.
     */
    public void setHireDate_LessThan(java.util.Date hireDate) {
        regHireDate(CK_LT, hireDate);
    }

    /**
     * GreaterEqual(&gt;). And NullIgnored, OnceRegistered.
     * @param hireDate The value of hireDate as greaterEqual.
     */
    public void setHireDate_GreaterEqual(java.util.Date hireDate) {
        regHireDate(CK_GE, hireDate);
    }

    /**
     * LessEqual(&gt;). And NullIgnored, OnceRegistered.
     * @param hireDate The value of hireDate as lessEqual.
     */
    public void setHireDate_LessEqual(java.util.Date hireDate) {
        regHireDate(CK_LE, hireDate);
    }

    /**
     * FromTo($fromDate &lt;= COLUMN_NAME &lt;= $toDate). And NullIgnored, OnceRegistered. {DATE}
     * @param fromDate The from-date of hireDate. (Nullable)
     * @param toDate The to-date of hireDate. (Nullable)
     * @param fromToOption The option of from-to. (NotNull)
     */
    public void setHireDate_FromTo(java.util.Date fromDate, java.util.Date toDate, jp.co.np.p2netex.sample1.allcommon.cbean.coption.Sample1FromToOption fromToOption) {
        registerFromToQuery(fromDate, toDate, getCValueHireDate(), "HIRE_DATE", "HireDate", "hireDate", fromToOption);
    }

    /**
     * FromTo($fromDate &lt;= COLUMN_NAME &lt; $toDate + 1). And NullIgnored, OnceRegistered. {DATE}
     * @param fromDate The from-date of hireDate. (Nullable)
     * @param toDate The to-date of hireDate. (Nullable)
     */
    public void setHireDate_DateFromTo(java.util.Date fromDate, java.util.Date toDate) {
        setHireDate_FromTo(fromDate, toDate, new jp.co.np.p2netex.sample1.allcommon.cbean.coption.Sample1DateFromToOption());
    }

    /**
     * IsNull(is null). And OnceRegistered.
     */
    public void setHireDate_IsNull() { regHireDate(CK_ISN, DUMMY_OBJECT); }

    /**
     * IsNotNull(is not null). And OnceRegistered.
     */
    public void setHireDate_IsNotNull() { regHireDate(CK_ISNN, DUMMY_OBJECT); }

    protected void regHireDate(Sample1ConditionKey key, Object value) {
        registerQuery(key, value, getCValueHireDate(), "HIRE_DATE", "HireDate", "hireDate");
    }
    protected void registerInlineHireDate(Sample1ConditionKey key, Object value) {
        registerInlineQuery(key, value, getCValueHireDate(), "HIRE_DATE", "HireDate", "hireDate");
    }
    abstract protected Sample1ConditionValue getCValueHireDate();
    
    /**
     * Equal(=). And NullIgnored, OnceRegistered. {INTEGER : FK to SAMPLE1_DEPT}
     * @param deptId The value of deptId as equal.
     */
    public void setDeptId_Equal(java.lang.Integer deptId) {
        regDeptId(CK_EQ, deptId);
    }

    /**
     * NotEqual(!=). And NullIgnored, OnceRegistered.
     * @param deptId The value of deptId as notEqual.
     */
    public void setDeptId_NotEqual(java.lang.Integer deptId) {
        regDeptId(CK_NE, deptId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnceRegistered.
     * @param deptId The value of deptId as greaterThan.
     */
    public void setDeptId_GreaterThan(java.lang.Integer deptId) {
        regDeptId(CK_GT, deptId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnceRegistered.
     * @param deptId The value of deptId as lessThan.
     */
    public void setDeptId_LessThan(java.lang.Integer deptId) {
        regDeptId(CK_LT, deptId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnceRegistered.
     * @param deptId The value of deptId as greaterEqual.
     */
    public void setDeptId_GreaterEqual(java.lang.Integer deptId) {
        regDeptId(CK_GE, deptId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnceRegistered.
     * @param deptId The value of deptId as lessEqual.
     */
    public void setDeptId_LessEqual(java.lang.Integer deptId) {
        regDeptId(CK_LE, deptId);
    }

    /**
     * InScope(in (1, 2)). And NullIgnored, NullElementIgnored, SeveralRegistered.
     * @param deptIdList The collection of deptId as inScope.
     */
    public void setDeptId_InScope(Collection<java.lang.Integer> deptIdList) {
        regDeptId(CK_INS, cTL(deptIdList));
    }

    /**
     * NotInScope(not in (1, 2)). And NullIgnored, NullElementIgnored, SeveralRegistered.
     * @param deptIdList The collection of deptId as notInScope.
     */
    public void setDeptId_NotInScope(Collection<java.lang.Integer> deptIdList) {
        regDeptId(CK_NINS, cTL(deptIdList));
    }

    /**
	 * @param sample1DeptCBquery Query.
	 * @deprecated Please use inScopeSample1Dept(subQuery) method.
	 */
    public void setDeptId_InScopeSubQuery_Sample1Dept(Sample1Sample1DeptCQ sample1DeptCBquery) {
        String subQueryPropertyName = keepDeptId_InScopeSubQuery_Sample1Dept(sample1DeptCBquery);// for saving query-value.
        registerInScopeSubQuery(sample1DeptCBquery, "DEPT_ID", "ID", subQueryPropertyName);
    }
    public void inScopeSample1Dept(Sample1SubQuery<Sample1Sample1DeptCB> subQuery) {
        assertObjectNotNull("subQuery<Sample1Sample1DeptCB>", subQuery);
        Sample1Sample1DeptCB cb = new Sample1Sample1DeptCB(); cb.xsetupForInScopeSubQuery(); subQuery.query(cb);
        String subQueryPropertyName = keepDeptId_InScopeSubQuery_Sample1Dept(cb.query());// for saving query-value.
        registerInScopeSubQuery(cb.query(), "DEPT_ID", "ID", subQueryPropertyName);
    }
    abstract public String keepDeptId_InScopeSubQuery_Sample1Dept(Sample1Sample1DeptCQ subQuery);

    /**
     * IsNull(is null). And OnceRegistered.
     */
    public void setDeptId_IsNull() { regDeptId(CK_ISN, DUMMY_OBJECT); }

    /**
     * IsNotNull(is not null). And OnceRegistered.
     */
    public void setDeptId_IsNotNull() { regDeptId(CK_ISNN, DUMMY_OBJECT); }

    protected void regDeptId(Sample1ConditionKey key, Object value) {
        registerQuery(key, value, getCValueDeptId(), "DEPT_ID", "DeptId", "deptId");
    }
    protected void registerInlineDeptId(Sample1ConditionKey key, Object value) {
        registerInlineQuery(key, value, getCValueDeptId(), "DEPT_ID", "DeptId", "deptId");
    }
    abstract protected Sample1ConditionValue getCValueDeptId();
    
    /**
     * Equal(=). And NullIgnored, OnceRegistered. {DECIMAL(8)}
     * @param versionNo The value of versionNo as equal.
     */
    public void setVersionNo_Equal(java.math.BigDecimal versionNo) {
        regVersionNo(CK_EQ, versionNo);
    }

    /**
     * NotEqual(!=). And NullIgnored, OnceRegistered.
     * @param versionNo The value of versionNo as notEqual.
     */
    public void setVersionNo_NotEqual(java.math.BigDecimal versionNo) {
        regVersionNo(CK_NE, versionNo);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnceRegistered.
     * @param versionNo The value of versionNo as greaterThan.
     */
    public void setVersionNo_GreaterThan(java.math.BigDecimal versionNo) {
        regVersionNo(CK_GT, versionNo);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnceRegistered.
     * @param versionNo The value of versionNo as lessThan.
     */
    public void setVersionNo_LessThan(java.math.BigDecimal versionNo) {
        regVersionNo(CK_LT, versionNo);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnceRegistered.
     * @param versionNo The value of versionNo as greaterEqual.
     */
    public void setVersionNo_GreaterEqual(java.math.BigDecimal versionNo) {
        regVersionNo(CK_GE, versionNo);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnceRegistered.
     * @param versionNo The value of versionNo as lessEqual.
     */
    public void setVersionNo_LessEqual(java.math.BigDecimal versionNo) {
        regVersionNo(CK_LE, versionNo);
    }

    /**
     * InScope(in (1, 2)). And NullIgnored, NullElementIgnored, SeveralRegistered.
     * @param versionNoList The collection of versionNo as inScope.
     */
    public void setVersionNo_InScope(Collection<java.math.BigDecimal> versionNoList) {
        regVersionNo(CK_INS, cTL(versionNoList));
    }

    /**
     * NotInScope(not in (1, 2)). And NullIgnored, NullElementIgnored, SeveralRegistered.
     * @param versionNoList The collection of versionNo as notInScope.
     */
    public void setVersionNo_NotInScope(Collection<java.math.BigDecimal> versionNoList) {
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
    protected String getConditionBeanClassNameInternally() { return Sample1Sample1EmpCB.class.getName(); }
    protected String getConditionQueryClassNameInternally() { return Sample1Sample1EmpCQ.class.getName(); }
}
