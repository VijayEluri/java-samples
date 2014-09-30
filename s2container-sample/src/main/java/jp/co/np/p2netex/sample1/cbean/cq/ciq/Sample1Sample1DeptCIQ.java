package jp.co.np.p2netex.sample1.cbean.cq.ciq;

import jp.co.np.p2netex.sample.*;
import jp.co.np.p2netex.sample1.allcommon.cbean.*;
import jp.co.np.p2netex.sample1.allcommon.cbean.ckey.Sample1ConditionKey;
import jp.co.np.p2netex.sample1.allcommon.cbean.coption.Sample1ConditionOption;
import jp.co.np.p2netex.sample1.allcommon.cbean.cvalue.Sample1ConditionValue;
import jp.co.np.p2netex.sample1.allcommon.cbean.sqlclause.Sample1SqlClause;
import jp.co.np.p2netex.sample1.cbean.cq.bs.*;
import jp.co.np.p2netex.sample1.cbean.cq.*;

/**
 * The condition-inline-query of SAMPLE1_DEPT.
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample1Sample1DeptCIQ extends Sample1AbstractBsSample1DeptCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected Sample1BsSample1DeptCQ _myCQ;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample1Sample1DeptCIQ(Sample1ConditionQuery childQuery, Sample1SqlClause sqlClause, String aliasName, int nestLevel, Sample1BsSample1DeptCQ myCQ) {
        super(childQuery, sqlClause, aliasName, nestLevel);
        _myCQ = myCQ;
        _foreignPropertyName = _myCQ.getForeignPropertyName();// Accept foreign property name.
        _relationPath = _myCQ.getRelationPath();// Accept relation path.
    }

    // ===================================================================================
    //                                                             Override about Register
    //                                                             =======================
    @Override
    protected void reflectRelationOnUnionQuery(Sample1ConditionQuery baseQueryAsSuper, Sample1ConditionQuery unionQueryAsSuper) {
        throw new UnsupportedOperationException("InlineQuery must not need UNION method: " + baseQueryAsSuper + " : " + unionQueryAsSuper);
    }

    @Override
    protected void setupConditionValueAndRegisterWhereClause(Sample1ConditionKey key, Object value, Sample1ConditionValue cvalue
                                                             , String colName, String capPropName, String uncapPropName) {
        registerInlineQuery(key, value, cvalue, colName, capPropName, uncapPropName);
    }

    @Override
    protected void setupConditionValueAndRegisterWhereClause(Sample1ConditionKey key, Object value, Sample1ConditionValue cvalue
                                                             , String colName, String capPropName, String uncapPropName, Sample1ConditionOption option) {
        registerInlineQuery(key, value, cvalue, colName, capPropName, uncapPropName, option);
    }

    @Override
    protected void registerWhereClause(String whereClause) {
        registerInlineWhereClause(whereClause);
    }

    @Override
    protected String getInScopeSubQueryRealColumnName(String columnName) {
        if (_onClauseInline) {
            throw new UnsupportedOperationException("InScopeSubQuery of on-clause is unsupported");
        }
        return _onClauseInline ? getRealAliasName() + "." + columnName : columnName;
    }

    @Override
    protected void registerExistsSubQuery(Sample1ConditionQuery subQuery
                                 , String columnName, String relatedColumnName, String propertyName) {
        throw new UnsupportedOperationException("Sorry! ExistsSubQuery at inline view is unsupported. So please use InScopeSubQyery.");
    }

    // ===================================================================================
    //                                                                Override about Query
    //                                                                ====================
    protected Sample1ConditionValue getCValueId() {
        return _myCQ.getId();
    }
    public String keepId_InScopeSubQuery_Sample1EmpList(Sample1Sample1EmpCQ subQuery) {
        return _myCQ.keepId_InScopeSubQuery_Sample1EmpList(subQuery);
    }
    public String keepId_NotInScopeSubQuery_Sample1EmpList(Sample1Sample1EmpCQ subQuery) {
        return _myCQ.keepId_NotInScopeSubQuery_Sample1EmpList(subQuery);
    }
    public String keepId_ExistsSubQuery_Sample1EmpList(Sample1Sample1EmpCQ subQuery) {
        throw new UnsupportedOperationException("ExistsSubQuery at inline() is unsupported! Sorry!");
    }
    public String keepId_NotExistsSubQuery_Sample1EmpList(Sample1Sample1EmpCQ subQuery) {
        throw new UnsupportedOperationException("NotExistsSubQuery at inline() is unsupported! Sorry!");
    }
    public String keepId_DeriveSubQuery_Sample1EmpList(Sample1Sample1EmpCQ subQuery) {
        throw new UnsupportedOperationException("DeriveSubQuery at inline() is unsupported! Sorry!");
    }
    protected Sample1ConditionValue getCValueName() {
        return _myCQ.getName();
    }
    protected Sample1ConditionValue getCValueVersionNo() {
        return _myCQ.getVersionNo();
    }

    protected String getConditionQueryClassNameInternally() { return Sample1Sample1DeptCQ.class.getName(); }
}
