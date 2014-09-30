package jp.co.np.p2netex.sample2.cbean.cq.ciq;

import jp.co.np.p2netex.sample2.allcommon.cbean.*;
import jp.co.np.p2netex.sample2.allcommon.cbean.ckey.*;
import jp.co.np.p2netex.sample2.allcommon.cbean.coption.Sample2ConditionOption;
import jp.co.np.p2netex.sample2.allcommon.cbean.cvalue.Sample2ConditionValue;
import jp.co.np.p2netex.sample2.allcommon.cbean.sqlclause.Sample2SqlClause;
import jp.co.np.p2netex.sample2.cbean.cq.bs.*;
import jp.co.np.p2netex.sample2.cbean.cq.*;

/**
 * The condition-inline-query of SAMPLE2_EMP.
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample2Sample2EmpCIQ extends Sample2AbstractBsSample2EmpCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected Sample2BsSample2EmpCQ _myCQ;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample2Sample2EmpCIQ(Sample2ConditionQuery childQuery, Sample2SqlClause sqlClause, String aliasName, int nestLevel, Sample2BsSample2EmpCQ myCQ) {
        super(childQuery, sqlClause, aliasName, nestLevel);
        _myCQ = myCQ;
        _foreignPropertyName = _myCQ.getForeignPropertyName();// Accept foreign property name.
        _relationPath = _myCQ.getRelationPath();// Accept relation path.
    }

    // ===================================================================================
    //                                                             Override about Register
    //                                                             =======================
    @Override
    protected void reflectRelationOnUnionQuery(Sample2ConditionQuery baseQueryAsSuper, Sample2ConditionQuery unionQueryAsSuper) {
        throw new UnsupportedOperationException("InlineQuery must not need UNION method: " + baseQueryAsSuper + " : " + unionQueryAsSuper);
    }

    @Override
    protected void setupConditionValueAndRegisterWhereClause(Sample2ConditionKey key, Object value, Sample2ConditionValue cvalue
                                                             , String colName, String capPropName, String uncapPropName) {
        registerInlineQuery(key, value, cvalue, colName, capPropName, uncapPropName);
    }

    @Override
    protected void setupConditionValueAndRegisterWhereClause(Sample2ConditionKey key, Object value, Sample2ConditionValue cvalue
                                                             , String colName, String capPropName, String uncapPropName, Sample2ConditionOption option) {
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
    protected void registerExistsSubQuery(Sample2ConditionQuery subQuery
                                 , String columnName, String relatedColumnName, String propertyName) {
        throw new UnsupportedOperationException("Sorry! ExistsSubQuery at inline view is unsupported. So please use InScopeSubQyery.");
    }

    // ===================================================================================
    //                                                                Override about Query
    //                                                                ====================
    protected Sample2ConditionValue getCValueId() {
        return _myCQ.getId();
    }
    protected Sample2ConditionValue getCValueName() {
        return _myCQ.getName();
    }
    protected Sample2ConditionValue getCValueHireDate() {
        return _myCQ.getHireDate();
    }
    protected Sample2ConditionValue getCValueDeptId() {
        return _myCQ.getDeptId();
    }
    public String keepDeptId_InScopeSubQuery_Sample2Dept(Sample2Sample2DeptCQ subQuery) {
        return _myCQ.keepDeptId_InScopeSubQuery_Sample2Dept(subQuery);
    }
    protected Sample2ConditionValue getCValueVersionNo() {
        return _myCQ.getVersionNo();
    }

    protected String getConditionQueryClassNameInternally() { return Sample2Sample2EmpCQ.class.getName(); }
}
