package jp.co.np.p2netex.sample2.allcommon.cbean;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

import jp.co.np.p2netex.sample2.allcommon.cbean.ckey.Sample2ConditionKey;
import jp.co.np.p2netex.sample2.allcommon.cbean.coption.Sample2ConditionOption;
import jp.co.np.p2netex.sample2.allcommon.cbean.coption.Sample2FromToOption;
import jp.co.np.p2netex.sample2.allcommon.cbean.coption.Sample2LikeSearchOption;
import jp.co.np.p2netex.sample2.allcommon.cbean.coption.Sample2InScopeOption;
import jp.co.np.p2netex.sample2.allcommon.cbean.cvalue.Sample2ConditionValue;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.Sample2DBMeta;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.Sample2DBMetaInstanceHandler;
import jp.co.np.p2netex.sample2.allcommon.cbean.sqlclause.Sample2SqlClause;
import jp.co.np.p2netex.sample2.allcommon.exception.Sample2RequiredOptionNotFoundException;
import jp.co.np.p2netex.sample2.allcommon.util.Sample2SimpleStringUtil;
import jp.co.np.p2netex.sample2.allcommon.util.Sample2SimpleSystemUtil;
import jp.co.np.p2netex.sample2.allcommon.util.Sample2TraceViewUtil;

/**
 * The abstract class of condition-query.
 * @author DBFlute(AutoGenerator)
 */
public abstract class Sample2AbstractConditionQuery implements Sample2ConditionQuery {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    protected static final Sample2ConditionKey CK_EQ = Sample2ConditionKey.CK_EQUAL;
    protected static final Sample2ConditionKey CK_NE = Sample2ConditionKey.CK_NOT_EQUAL;
    protected static final Sample2ConditionKey CK_GE = Sample2ConditionKey.CK_GREATER_EQUAL;
    protected static final Sample2ConditionKey CK_GT = Sample2ConditionKey.CK_GREATER_THAN;
    protected static final Sample2ConditionKey CK_LE = Sample2ConditionKey.CK_LESS_EQUAL;
    protected static final Sample2ConditionKey CK_LT = Sample2ConditionKey.CK_LESS_THAN;
    protected static final Sample2ConditionKey CK_PS = Sample2ConditionKey.CK_PREFIX_SEARCH;
    protected static final Sample2ConditionKey CK_LS = Sample2ConditionKey.CK_LIKE_SEARCH;
    protected static final Sample2ConditionKey CK_INS = Sample2ConditionKey.CK_IN_SCOPE;
    protected static final Sample2ConditionKey CK_NINS = Sample2ConditionKey.CK_NOT_IN_SCOPE;
    protected static final Sample2ConditionKey CK_ISN = Sample2ConditionKey.CK_IS_NULL;
    protected static final Sample2ConditionKey CK_ISNN = Sample2ConditionKey.CK_IS_NOT_NULL;

    /** Condition value for DUMMY. */
    protected static final Sample2ConditionValue DUMMY_CONDITION_VALUE = new Sample2ConditionValue();

    /** Object for DUMMY. */
    protected static final Object DUMMY_OBJECT = new Object();
    
    /** The property of condition-query. */
    protected static final String CQ_PROPERTY = "conditionQuery";

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** SQL clause. */
    protected final Sample2SqlClause _sqlClause;

    /** My alias name. */
    protected final String _aliasName;

    /** The level of nest. */
    protected final int _nestLevel;
    
    /** The level of subQuery. */
    protected int _subQueryLevel;

    // -----------------------------------------------------
    //                                          Foreign Info
    //                                          ------------
    /** The property name of foreign. */
    protected String _foreignPropertyName;

    /** The path of relation. */
    protected String _relationPath;

    /** The query of child. */
    protected final Sample2ConditionQuery _childQuery;

    // -----------------------------------------------------
    //                                                Inline
    //                                                ------
    /** Is it the inline for on-clause. (Property for Inline Only) */
    protected boolean _onClauseInline;
    
    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * Constructor.
     * @param childQuery Child query. (Nullable: If null, this is base instance.)
     * @param sqlClause SQL clause instance. (NotNull)
     * @param aliasName My alias name. (NotNull)
     * @param nestLevel Nest level.
     */
    public Sample2AbstractConditionQuery(Sample2ConditionQuery childQuery, Sample2SqlClause sqlClause, String aliasName, int nestLevel) {
        _childQuery = childQuery;
        _sqlClause = sqlClause;
        _aliasName = aliasName;
        _nestLevel = nestLevel;
    }

    // ===================================================================================
    //                                                                  Important Accessor
    //                                                                  ==================
    /**
     * Get child query.
     * @return Child query. (Nullable)
     */
    public Sample2ConditionQuery getChildQuery() {
        return _childQuery;
    }

    /**
     * Get sql clause.
     * @return Sql clause. (NotNull)
     */
    public Sample2SqlClause getSqlClause() {
        return _sqlClause;
    }

    /**
     * Get alias name.
     * @return Alias name. (NotNull)
     */
    public String getAliasName() {
        return _aliasName;
    }

    /**
     * Get nest level.
     * @return Nest level.
     */
    public int getNestLevel() {
        return _nestLevel;
    }

    /**
     * Get next nest level.
     * @return Next nest level.
     */
    public int getNextNestLevel() {
        return _nestLevel+1;
    }

    /**
     * Is base query?
     * @param query Condition query. (NotNull)
     * @return Determination.
     */
    public boolean isBaseQuery(Sample2ConditionQuery query) {
        return (query.getChildQuery() == null);
    }

    /**
     * Get the level of subQuery.
     * @return The level of subQuery.
     */
    public int getSubQueryLevel() {
        return _subQueryLevel;
    }
    
    // -----------------------------------------------------
    //                                             Real Name
    //                                             ---------
    /**
     * Get real alias name(that has nest level mark).
     * @return Real alias name.
     */
    public String getRealAliasName() {
        return getAliasName();
    }

    /**
     * Get real column name(with real alias name).
     * @param columnName Column name without alias name. This should not contain comma. (NotNull)
     * @return Real column name.
     */
    public String getRealColumnName(String columnName) {
        assertColumnName(columnName);
        return buildRealColumnName(getRealAliasName(), columnName);
    }

    /**
     * Build real column name.
     * @param aliasName Alias name. (NotNull)
     * @param columnName Column name. (NotNull)
     * @return Real column name. (NotNull)
     */
    protected String buildRealColumnName(String aliasName, String columnName) {
        return aliasName + "." + columnName;
    }

    // -----------------------------------------------------
    //                                          Foreign Info
    //                                          ------------
    public String getForeignPropertyName() {
        return _foreignPropertyName;
    }

    public void xsetForeignPropertyName(String foreignPropertyName) {
        this._foreignPropertyName = foreignPropertyName;
    }

    public String getRelationPath() {
        return _relationPath;
    }

    public void xsetRelationPath(String relationPath) {
        this._relationPath = relationPath;
    }

    // -----------------------------------------------------
    //                                                Inline
    //                                                ------
    public void xsetOnClauseInline(boolean onClauseInline) {
        _onClauseInline = onClauseInline;
    }
    
    // ===================================================================================
    //                                                                            Location
    //                                                                            ========
    /**
     * Get location.
     * @param columnPropertyName Column property name.
     * @param key Condition key.
     * @return Next nest level.
     */
    protected String getLocation(String columnPropertyName, Sample2ConditionKey key) {
        return getLocationBase(columnPropertyName) + "." + key.getConditionKey();
    }

    protected String getLocationBase() {
        final StringBuffer sb = new StringBuffer();
        Sample2ConditionQuery query = this;
        while (true) {
            if (query.isBaseQuery(query)) {
                sb.insert(0, CQ_PROPERTY + ".");
                break;
            } else {
                final String foreignPropertyName = query.getForeignPropertyName();
                if (foreignPropertyName == null) {
                    String msg = "The foreignPropertyName of the query should not be null:";
                    msg = msg + " query=" + query;
                    throw new IllegalStateException(msg);
                }
                sb.insert(0, CQ_PROPERTY + initCap(foreignPropertyName) + ".");
            }
            query = query.getChildQuery();
        }
        return sb.toString();
    }

    protected String getLocationBase(String columnPropertyName) {
        return getLocationBase() + columnPropertyName;
    }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    /** The map of union query. */
    protected Map<String, Sample2ConditionQuery> _unionQueryMap;

    /**
     * Get the map of union query.
     * @return The map of union query. (NotNull)
     */
    public Map<String, Sample2ConditionQuery> getUnionQueryMap() {// for Internal
        if (_unionQueryMap == null) {
            _unionQueryMap = new LinkedHashMap<String, Sample2ConditionQuery>();
        }
        return _unionQueryMap;
    }

    /**
     * Set union query. {Internal}
     * @param unionQuery Union query. (NotNull)
     */
    public void xsetUnionQuery(Sample2ConditionQuery unionQuery) {
        xsetupUnion(unionQuery, false, getUnionQueryMap());
    }

    /** The map of union all query. */
    protected Map<String, Sample2ConditionQuery> _unionAllQueryMap;

    /**
     * Get the map of union all query.
     * @return The map of union all query. (NotNull)
     */
    public Map<String, Sample2ConditionQuery> getUnionAllQueryMap() {// for Internal
        if (_unionAllQueryMap == null) {
            _unionAllQueryMap = new LinkedHashMap<String, Sample2ConditionQuery>();
        }
        return _unionAllQueryMap;
    }

    /**
     * Set union all query. {Internal}
     * @param unionAllQuery Union all query. (NotNull)
     */
    public void xsetUnionAllQuery(Sample2ConditionQuery unionAllQuery) {
        xsetupUnion(unionAllQuery, true, getUnionAllQueryMap());
    }

    protected void xsetupUnion(Sample2ConditionQuery unionQuery, boolean unionAll, Map<String, Sample2ConditionQuery> unionQueryMap) {
        if (unionQuery == null) {
            String msg = "The argument[unionQuery] should not be null.";
            throw new IllegalArgumentException(msg);
        }
        reflectRelationOnUnionQuery(this, unionQuery);// Reflect Relation!
        getSqlClause().copyIncludedSelectColumn(unionQuery.getSqlClause());// Reflect IncludedSelectColumn!
        if (getSqlClause().isFormatClauseEffective()) {
            unionQuery.getSqlClause().makeFormatClauseEffective();// Reflect FormatClause!
        }
        String key = (unionAll ? "unionAllQuery" : "unionQuery") + unionQueryMap.size();
        unionQueryMap.put(key, unionQuery);
        registerUnionQuery(unionQuery, unionAll, (unionAll ? "unionAllQueryMap" : "unionQueryMap") + "." + key);
    }

    /**
     * Reflect relation on union query.
     * @param baseQueryAsSuper Base query as super. (NotNull)
     * @param unionQueryAsSuper Union query as super. (NotNull)
     */
    abstract protected void reflectRelationOnUnionQuery(Sample2ConditionQuery baseQueryAsSuper, Sample2ConditionQuery unionQueryAsSuper);

    /**
     * Has union query or union all query?
     * @return Determination.
     */
    public boolean hasUnionQueryOrUnionAllQuery() {
        return (_unionQueryMap != null && !_unionQueryMap.isEmpty()) || (_unionAllQueryMap != null && !_unionAllQueryMap.isEmpty());
    }

    /**
     * Get the list of union query.
     * @return The list of union query. (NotNull)
     */
    public List<Sample2ConditionQuery> getUnionQueryList() {
        if (_unionQueryMap == null) { return new ArrayList<Sample2ConditionQuery>(); }
        return new ArrayList<Sample2ConditionQuery>(_unionQueryMap.values());
    }

    /**
     * Get the list of union all query.
     * @return The list of union all query. (NotNull)
     */
    public List<Sample2ConditionQuery> getUnionAllQueryList() {
        if (_unionAllQueryMap == null) { return new ArrayList<Sample2ConditionQuery>(); }
        return new ArrayList<Sample2ConditionQuery>(_unionAllQueryMap.values());
    }

    // ===================================================================================
    //                                                                            Register
    //                                                                            ========
    // -----------------------------------------------------
    //                                       Include-As-Mine
    //                                       ---------------
    /**
     * Register included-select-column.
     * @param aliasName Alias name. This should not contain comma. (NotNull)
     * @param realColumnName Real column name. This should not contain comma. (NotNull)
     * @deprecated Unsupported!
     */
    protected void registerIncludedSelectColumn(String aliasName, String realColumnName) {
        throw new UnsupportedOperationException();
    }

    // -----------------------------------------------------
    //                                                 Query
    //                                                 -----
    protected void registerQuery(Sample2ConditionKey key, Object value, Sample2ConditionValue cvalue
                                 , String colName, String capPropName, String uncapPropName) {
        if (key.isValidRegistration(cvalue, value, key.getConditionKey() + " of " + getRealAliasName() + "." + colName)) {
            setupConditionValueAndRegisterWhereClause(key, value, cvalue, colName, capPropName, uncapPropName);
        }
    }

    protected void registerQuery(Sample2ConditionKey key, Object value, Sample2ConditionValue cvalue
                                 , String colName, String capPropName, String uncapPropName, Sample2ConditionOption option) {
        if (key.isValidRegistration(cvalue, value, key.getConditionKey() + " of " + getRealAliasName() + "." + colName)) {
            setupConditionValueAndRegisterWhereClause(key, value, cvalue, colName, capPropName, uncapPropName, option);
        }
    }

    // -----------------------------------------------------
    //                                          FromTo Query
    //                                          ------------
    protected void registerFromToQuery(java.util.Date fromDate, java.util.Date toDate, Sample2ConditionValue cvalue
                                 , String colName, String capPropName, String uncapPropName, Sample2FromToOption option) {
        {
            final java.util.Date filteredFromDate = option.filterFromDate(fromDate);
            final Sample2ConditionKey fromKey = option.getFromDateConditionKey();
            if (fromKey.isValidRegistration(cvalue, filteredFromDate, fromKey.getConditionKey() + " of " + getRealAliasName() + "." + uncapPropName)) {
                setupConditionValueAndRegisterWhereClause(fromKey, filteredFromDate, cvalue, colName, capPropName, uncapPropName);
            }
        }
        {
            final java.util.Date filteredToDate = option.filterToDate(toDate);
            final Sample2ConditionKey toKey = option.getToDateConditionKey();
            if (toKey.isValidRegistration(cvalue, filteredToDate, toKey.getConditionKey() + " of " + getRealAliasName() + "." + uncapPropName)) {
                setupConditionValueAndRegisterWhereClause(toKey, filteredToDate, cvalue, colName, capPropName, uncapPropName);
            }
        }
    }

    // -----------------------------------------------------
    //                                      LikeSearch Query
    //                                      ----------------
    @SuppressWarnings("deprecation")
    protected void registerLikeSearchQuery(Sample2ConditionKey key
                                         , String value
                                         , Sample2ConditionValue cvalue
                                         , String colName
                                         , String capPropName
                                         , String uncapPropName
                                         , Sample2LikeSearchOption option) {
        final String validationMsg = key.getConditionKey() + " of " + getRealAliasName() + "." + colName;
        if (!key.isValidRegistration(cvalue, value, validationMsg)) {
            return;
        }
        if (option == null) {
            throwLikeSearchOptionNotFoundException(capPropName, value);
            return;// Unreachable!
        }
        if (value == null || !option.isSplit()) {
            // As Normal Condition.
            setupConditionValueAndRegisterWhereClause(key, value, cvalue, colName, capPropName, uncapPropName, option);
            return;
        }
        // - - - - - - - - -
        // Use splitByXxx().
        // - - - - - - - - -
        final String[] strArray = option.generateSplitValueArray(value);
        if (!option.isAsOrSplit()) {
            // As 'and' Condition
            for (int i = 0; i < strArray.length; i++) {
                final String currentValue = strArray[i];
                setupConditionValueAndRegisterWhereClause(key, currentValue, cvalue, colName, capPropName, uncapPropName, option);
                
                // Callback for LikeAsOr!
                final List<Sample2LikeSearchOption.LikeAsOrCallback> callbackList = option.getLikeAsOrCallbackList();
                if (!callbackList.isEmpty()) {
                    getSqlClause().makeAdditionalConditionAsOrEffective();
                    for (Iterator<Sample2LikeSearchOption.LikeAsOrCallback> ite = callbackList.iterator(); ite.hasNext();) {
                        final Sample2LikeSearchOption.LikeAsOrCallback likeAsOrCallback = (Sample2LikeSearchOption.LikeAsOrCallback) ite.next();
                        final String additionalTargetPropertyName = likeAsOrCallback.getAdditionalTargetPropertyName();
                        final String filteredValue = likeAsOrCallback.filterValue(currentValue);
                        final Sample2LikeSearchOption optionDeepCopy = (Sample2LikeSearchOption) option.createDeepCopy();
                        optionDeepCopy.clearLikeAsOrCallback();
                        final Sample2LikeSearchOption filteredOption = likeAsOrCallback.filterOption(optionDeepCopy);
                        invokeSetterLikeSearch(additionalTargetPropertyName, filteredValue, filteredOption);
                    }
                    getSqlClause().ignoreAdditionalConditionAsOr();
                }
            }
        } else {
            // As 'or' Condition
            for (int i = 0; i < strArray.length; i++) {
                final String currentValue = strArray[i];
                if (i == 0) {
                    setupConditionValueAndRegisterWhereClause(key, currentValue, cvalue, colName, capPropName, uncapPropName, option);
                } else {
                    getSqlClause().makeAdditionalConditionAsOrEffective();
                    invokeSetterLikeSearch(uncapPropName, currentValue, option);
                }
            }
            
            // @jflute -- Callback for LikeAsOr!
            // final List<Sample2LikeSearchOption.LikeAsOrCallback> callbackList = option.getLikeAsOrCallbackList();
            // ...
            
            getSqlClause().ignoreAdditionalConditionAsOr();
        }
    }

    protected void throwLikeSearchOptionNotFoundException(String capPropName, String value) {
        String msg = "Look! Read the message below." + getLineSeparator();
        msg = msg + "/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *" + getLineSeparator();
        msg = msg + "The likeSearchOption was Not Found! (Should not be null!)" + getLineSeparator();
        msg = msg + getLineSeparator();
        msg = msg + "[Advice]" + getLineSeparator();
        msg = msg + "Please confirm your method call:"  + getLineSeparator();
        final String beanName = getClass().getSimpleName();
        final String methodName = "set" + capPropName + "_LikeSearch('" + value + "', likeSearchOption);";
        msg = msg + "    " + beanName + "." + methodName + getLineSeparator();
        msg = msg + "* * * * * * * * * */" + getLineSeparator();
        throw new Sample2RequiredOptionNotFoundException(msg);
    }
        
    protected void invokeSetterLikeSearch(String columnFlexibleName, Object value, Sample2LikeSearchOption option) {
        if (value == null) {
            return;
        }
        final Sample2DBMeta dbmeta = Sample2DBMetaInstanceHandler.findDBMeta(getTableDbName());
        final String columnCapPropName = initCap(dbmeta.findPropertyName(columnFlexibleName));
        final String methodName = "set" + columnCapPropName + "_LikeSearch";
        Method method = null;
        try {
            method = this.getClass().getMethod(methodName, new Class[]{value.getClass(), Sample2LikeSearchOption.class});
        } catch (NoSuchMethodException e) {
            String msg = "The columnFlexibleName is not existing in this table: columnFlexibleName=" + columnFlexibleName;
            msg = msg + " tableName=" + getTableDbName() + " methodName=" + methodName;
            throw new RuntimeException(msg, e);
        }
        try {
            method.invoke(this, new Object[]{value, option});
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    // -----------------------------------------------------
    //                                         InScope Query
    //                                         -------------
    protected void registerInScopeQuery(Sample2ConditionKey key, String value, Sample2ConditionValue cvalue
                                     , String colName, String capPropName, String uncapPropName, Sample2InScopeOption option) {
        if (key.isValidRegistration(cvalue, value, key.getConditionKey() + " of " + getRealAliasName() + "." + colName)) {
            if (value != null && option.isSplit()) {
                final String[] strArray = option.generateSplitValueArray(value);
                final List<String> realValueList = new ArrayList<String>();
                for (int i=0; i < strArray.length; i++) {
                    final String currentValue = strArray[i];
                    realValueList.add(currentValue);
                }
                setupConditionValueAndRegisterWhereClause(key, realValueList, cvalue, colName, capPropName, uncapPropName, option);
            } else {
                setupConditionValueAndRegisterWhereClause(key, value, cvalue, colName, capPropName, uncapPropName, option);
            }
        }
    }

    // -----------------------------------------------------
    //                                          Inline Query
    //                                          ------------
    protected void registerInlineQuery(Sample2ConditionKey key, Object value, Sample2ConditionValue cvalue
                                       , String colName, String capPropName, String uncapPropName) {
        if (key.isValidRegistration(cvalue, value, key.getConditionKey() + " of " + getRealAliasName() + "." + colName)) {
            key.setupConditionValue(cvalue, value, getLocation(uncapPropName, key));// If Java, it is necessary to use uncapPropName!
            if (isBaseQuery(this)) {
                getSqlClause().registerBaseTableInlineWhereClause(colName, key, cvalue);
            } else {
                getSqlClause().registerOuterJoinInlineWhereClause(getRealAliasName(), colName, key, cvalue, _onClauseInline);
            }
        }
    }

    protected void registerInlineQuery(Sample2ConditionKey key, Object value, Sample2ConditionValue cvalue
                                       , String colName, String capPropName, String uncapPropName, Sample2ConditionOption option) {
        if (key.isValidRegistration(cvalue, value, key.getConditionKey() + " of " + getRealAliasName() + "." + colName)) {
            key.setupConditionValue(cvalue, value, getLocation(uncapPropName, key), option);// If Java, it is necessary to use uncapPropName!
            if (isBaseQuery(this)) {
                getSqlClause().registerBaseTableInlineWhereClause(colName, key, cvalue, option);
            } else {
                getSqlClause().registerOuterJoinInlineWhereClause(getRealAliasName(), colName, key, cvalue, option, _onClauseInline);
            }
        }
    }

    // -----------------------------------------------------
    //                                       InScopeSubQuery
    //                                       ---------------
    // {Modified at DBFlute-0.7.5}
    protected void registerInScopeSubQuery(Sample2ConditionQuery subQuery
                                 , String columnName, String relatedColumnName, String propertyName) {
        registerInScopeSubQuery(subQuery, columnName, relatedColumnName, propertyName, null);
    }

    protected void registerNotInScopeSubQuery(Sample2ConditionQuery subQuery
                                 , String columnName, String relatedColumnName, String propertyName) {
        registerInScopeSubQuery(subQuery, columnName, relatedColumnName, propertyName, "not");
    }

    protected void registerInScopeSubQuery(Sample2ConditionQuery subQuery
                                 , String columnName, String relatedColumnName, String propertyName
                                 , String inScopeOption) {
        assertObjectNotNull("InScopeSubQyery(" + columnName + ")", subQuery);
        inScopeOption = inScopeOption != null ? inScopeOption + " " : "";
        String realColumnName = getInScopeSubQueryRealColumnName(columnName);
        String subQueryClause = getInScopeSubQuerySql(subQuery, relatedColumnName, propertyName);
        String clause = null;
        if (getSqlClause().isFormatClauseEffective()) {
            String ln = getLineSeparator();
            int subQueryLevel = subQuery.getSubQueryLevel();
            String subQueryIdentity = propertyName + "[" + subQueryLevel + "]";
            String beginMark = getSqlClause().resolveSubQueryBeginMark(subQueryIdentity) + ln;
            String endMark = getSqlClause().resolveSubQueryEndMark(subQueryIdentity);
            String endIndent = "       ";
            clause = realColumnName + " " + inScopeOption + "in (" + beginMark + subQueryClause + ln + endIndent + ")" + endMark;
        } else {
            clause = realColumnName + " " + inScopeOption + "in (" + subQueryClause + ")";
        }
        registerWhereClause(clause);
    }

    protected String getInScopeSubQueryRealColumnName(String columnName) {
        return getRealColumnName(columnName);
    }

    protected String getInScopeSubQuerySql(Sample2ConditionQuery subQuery
                                 , String relatedColumnName, String propertyName) {
        String selectClause = "select " + getSqlClause().getLocalTableAliasName() + "." + relatedColumnName;
        String fromWhereClause = subQuery.getSqlClause().getClauseFromWhereWithUnionTemplate();
        fromWhereClause = replaceString(fromWhereClause, ".conditionQuery.", "." + getLocationBase(propertyName) + ".");// Very Important!
        
        // Replace template marks. These are very important!
        fromWhereClause = replaceString(fromWhereClause, getSqlClause().getUnionSelectClauseMark(), selectClause);
        fromWhereClause = replaceString(fromWhereClause, getSqlClause().getUnionWhereClauseMark(), "");
        fromWhereClause = replaceString(fromWhereClause, getSqlClause().getUnionWhereFirstConditionMark(), "");
        
        return selectClause + " " + fromWhereClause;
    }

    // -----------------------------------------------------
    //                                        ExistsSubQuery
    //                                        --------------
    // {Modified at DBFlute-0.7.5}
    protected void registerExistsSubQuery(Sample2ConditionQuery subQuery
                                 , String columnName, String relatedColumnName, String propertyName) {
        registerExistsSubQuery(subQuery, columnName, relatedColumnName, propertyName, null);
    }

    protected void registerNotExistsSubQuery(Sample2ConditionQuery subQuery
                                 , String columnName, String relatedColumnName, String propertyName) {
        registerExistsSubQuery(subQuery, columnName, relatedColumnName, propertyName, "not");
    }

    protected void registerExistsSubQuery(Sample2ConditionQuery subQuery
                                 , String columnName, String relatedColumnName, String propertyName
                                 , String existsOption) {
        assertObjectNotNull("ExistsSubQyery(" + columnName + ")", subQuery);
        existsOption = existsOption != null ? existsOption + " " : "";
        String realColumnName = getExistsSubQueryRealColumnName(columnName);
        String subQueryClause = getExistsSubQuerySql(subQuery, realColumnName, relatedColumnName, propertyName);
        String clause = null;
        if (getSqlClause().isFormatClauseEffective()) {
            String ln = getLineSeparator();
            int subQueryLevel = subQuery.getSubQueryLevel();
            String subQueryIdentity = propertyName + "[" + subQueryLevel + "]";
            String beginMark = getSqlClause().resolveSubQueryBeginMark(subQueryIdentity) + ln;
            String endMark = getSqlClause().resolveSubQueryEndMark(subQueryIdentity);
            String endIndent = "       ";
            clause = existsOption + "exists (" + beginMark + subQueryClause + ln + endIndent + ")" + endMark;
        } else {
            clause = existsOption + "exists (" + subQueryClause + ")";
        }
        registerWhereClause(clause);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    // *Unsupport ExistsSubQuery as inline because it's so dangerous.
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 

    protected String getExistsSubQueryRealColumnName(String columnName) {
        return getRealColumnName(columnName);
    }

    protected String getExistsSubQuerySql(Sample2ConditionQuery subQuery
                                 , String realColumnName, String relatedColumnName, String propertyName) {
        int subQueryLevel = subQuery.getSubQueryLevel();
        if (_subQueryLevel <= subQueryLevel) {
            _subQueryLevel = subQueryLevel + 1;
        }
        String tableAliasName = "dfsublocal_" + subQueryLevel;
        String selectClause = "select " + tableAliasName + "." + relatedColumnName;
        String fromWhereClause = subQuery.getSqlClause().getClauseFromWhereWithWhereUnionTemplate();
        fromWhereClause = replaceString(fromWhereClause, "dflocal", tableAliasName);// Very Important!
        fromWhereClause = replaceString(fromWhereClause, ".conditionQuery.", "." + getLocationBase(propertyName) + ".");// Very Important!
        
        String joinCondition = tableAliasName + "." + relatedColumnName + " = " + realColumnName;
        String firstConditionAfter = " and ";
        if (getSqlClause().isFormatClauseEffective()) {
            firstConditionAfter = getLineSeparator() + "   and ";
        }
        
        // Replace template marks. These are very important!
        fromWhereClause = replaceString(fromWhereClause, getSqlClause().getWhereClauseMark(), "where " + joinCondition);
        fromWhereClause = replaceString(fromWhereClause, getSqlClause().getWhereFirstConditionMark(), joinCondition + firstConditionAfter);
        fromWhereClause = replaceString(fromWhereClause, getSqlClause().getUnionSelectClauseMark(), selectClause);
        fromWhereClause = replaceString(fromWhereClause, getSqlClause().getUnionWhereClauseMark(), "where " + joinCondition);
        fromWhereClause = replaceString(fromWhereClause, getSqlClause().getUnionWhereFirstConditionMark(), joinCondition + firstConditionAfter);
        
        return selectClause + " " + fromWhereClause;
    }

    // [DBFlute-0.7.4]
    // -----------------------------------------------------
    //                                        DeriveSubQuery
    //                                        --------------
    protected void registerDeriveSubQuery(String function, Sample2ConditionQuery subQuery
                                        , String columnName, String relatedColumnName
                                        , String propertyName, String aliasName) {
        assertObjectNotNull("DeriveSubQuery(" + columnName + ")", subQuery);
        final String realColumnName = getDeriveSubQueryRealColumnName(columnName);
        final String subQueryClause = getDeriveSubQuerySql(function, subQuery, realColumnName, relatedColumnName, propertyName, aliasName);
        final String clause;
        if (getSqlClause().isFormatClauseEffective()) {
            final String ln = getLineSeparator();
            final int subQueryLevel = subQuery.getSubQueryLevel();
            final String subQueryIdentity = propertyName + "[" + subQueryLevel + "]";
            final String beginMark = getSqlClause().resolveSubQueryBeginMark(subQueryIdentity) + ln;
            final String endMark = getSqlClause().resolveSubQueryEndMark(subQueryIdentity);
            final String endIndent = "       ";
            clause = "(" + beginMark + subQueryClause + ln + endIndent + ") as " + aliasName + endMark;
        } else {
            clause = "(" + subQueryClause + ") as " + aliasName;
        }
        getSqlClause().specifyDeriveSubQuery(aliasName, clause);
    }

    protected String getDeriveSubQueryRealColumnName(String columnName) {
        return getRealColumnName(columnName);
    }

    protected String getDeriveSubQuerySql(String function, Sample2ConditionQuery subQuery
                                        , String realColumnName, String relatedColumnName
                                        , String propertyName, String aliasName) {
        final int subQueryLevel = subQuery.getSubQueryLevel();
        if (_subQueryLevel <= subQueryLevel) {
            _subQueryLevel = subQueryLevel + 1;
        }
        final String tableAliasName = "dfsublocal_" + subQueryLevel;
        final String deriveColumnName = subQuery.getSqlClause().getSpecifiedColumnNameAsOne();
        if (deriveColumnName == null || deriveColumnName.trim().length() == 0) {
            throwDeriveReferrerInvalidColumnSpecificationException(function, aliasName);
        }
        assertDeriveReferrerColumnType(function, subQuery, deriveColumnName);
        subQuery.getSqlClause().clearSpecifiedSelectColumn();
        final String selectClause = "select " + function + "(" + tableAliasName + "." + deriveColumnName + ")";
        String fromWhereClause = subQuery.getSqlClause().getClauseFromWhereWithWhereUnionTemplate();
        fromWhereClause = replaceString(fromWhereClause, "dflocal", tableAliasName);// Very Important!
        fromWhereClause = replaceString(fromWhereClause, ".conditionQuery.", "." + getLocationBase(propertyName) + ".");// Very Important!
        
        final String joinCondition = tableAliasName + "." + relatedColumnName + " = " + realColumnName;
        String firstConditionAfter = " and ";
        if (getSqlClause().isFormatClauseEffective()) {
            firstConditionAfter = getLineSeparator() + "   and ";
        }
        
        // Replace template marks. These are very important!
        fromWhereClause = replaceString(fromWhereClause, getSqlClause().getWhereClauseMark(), "where " + joinCondition);
        fromWhereClause = replaceString(fromWhereClause, getSqlClause().getWhereFirstConditionMark(), joinCondition + firstConditionAfter);
        fromWhereClause = replaceString(fromWhereClause, getSqlClause().getUnionSelectClauseMark(), selectClause);
        fromWhereClause = replaceString(fromWhereClause, getSqlClause().getUnionWhereClauseMark(), "where " + joinCondition);
        fromWhereClause = replaceString(fromWhereClause, getSqlClause().getUnionWhereFirstConditionMark(), joinCondition + firstConditionAfter);
        
        return selectClause + " " + fromWhereClause;
    }

    protected void throwDeriveReferrerInvalidColumnSpecificationException(String function, String aliasName) {
        String msg = "Look! Read the message below." + getLineSeparator();
        msg = msg + "/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *" + getLineSeparator();
        msg = msg + "The specified the column for derive-referrer was Invalid!" + getLineSeparator();
        msg = msg + getLineSeparator();
        msg = msg + "[Advice]" + getLineSeparator();
        msg = msg + " You should call specify().column[TargetColumn]() only once." + getLineSeparator();
        msg = msg + "  For example:" + getLineSeparator();
        msg = msg + "    " + getLineSeparator();
        msg = msg + "    [Wrong]" + getLineSeparator();
        msg = msg + "    /- - - - - - - - - - - - - - - - - - - - " + getLineSeparator();
        msg = msg + "    MemberCB cb = new MemberCB();" + getLineSeparator();
        msg = msg + "    cb.specify().derivePurchaseList()." + function + "(new SubQuery<PurchaseCB>() {" + getLineSeparator();
        msg = msg + "        public void query(PurchaseCB subCB) {" + getLineSeparator();
        msg = msg + "            // *No! It's empty!" + getLineSeparator();
        msg = msg + "        }" + getLineSeparator();
        msg = msg + "    }, \"LATEST_PURCHASE_DATETIME\");" + getLineSeparator();
        msg = msg + "    - - - - - - - - - -/" + getLineSeparator();
        msg = msg + "    " + getLineSeparator();
        msg = msg + "    [Wrong]" + getLineSeparator();
        msg = msg + "    /- - - - - - - - - - - - - - - - - - - - " + getLineSeparator();
        msg = msg + "    MemberCB cb = new MemberCB();" + getLineSeparator();
        msg = msg + "    cb.specify().derivePurchaseList()." + function + "(new SubQuery<PurchaseCB>() {" + getLineSeparator();
        msg = msg + "        public void query(PurchaseCB subCB) {" + getLineSeparator();
        msg = msg + "            subCB.specify().columnPurchaseDatetime();" + getLineSeparator();
        msg = msg + "            subCB.specify().columnPurchaseCount(); // *No! It's duplicated!" + getLineSeparator();
        msg = msg + "        }" + getLineSeparator();
        msg = msg + "    }, \"LATEST_PURCHASE_DATETIME\");" + getLineSeparator();
        msg = msg + "    - - - - - - - - - -/" + getLineSeparator();
        msg = msg + "    " + getLineSeparator();
        msg = msg + "    [Good!]" + getLineSeparator();
        msg = msg + "    /- - - - - - - - - - - - - - - - - - - - " + getLineSeparator();
        msg = msg + "    MemberCB cb = new MemberCB();" + getLineSeparator();
        msg = msg + "    cb.specify().derivePurchaseList()." + function + "(new SubQuery<PurchaseCB>() {" + getLineSeparator();
        msg = msg + "        public void query(PurchaseCB subCB) {" + getLineSeparator();
        msg = msg + "            subCB.specify().columnPurchaseDatetime(); // *Point!" + getLineSeparator();
        msg = msg + "        }" + getLineSeparator();
        msg = msg + "    }, \"LATEST_PURCHASE_DATETIME\");" + getLineSeparator();
        msg = msg + "    - - - - - - - - - -/" + getLineSeparator();
        msg = msg + getLineSeparator();
        msg = msg + "[Alias Name]" + getLineSeparator() + aliasName + getLineSeparator();
        msg = msg + "* * * * * * * * * */";
        throw new DeriveReferrerInvalidColumnSpecificationException(msg);
    }

    public static class DeriveReferrerInvalidColumnSpecificationException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        public DeriveReferrerInvalidColumnSpecificationException(String msg) {
            super(msg);
        }
    }
    
    protected void assertDeriveReferrerColumnType(String function, Sample2ConditionQuery subQuery, String deriveColumnName) {
        final Sample2DBMeta dbmeta = Sample2DBMetaInstanceHandler.findDBMeta(subQuery.getTableDbName());
        final Class<?> deriveColumnType = dbmeta.findColumnInfo(deriveColumnName).getPropertyType();
        if ("sum".equalsIgnoreCase(function) || "avg".equalsIgnoreCase(function)) {
            if (!Number.class.isAssignableFrom(deriveColumnType)) {
                throwDeriveReferrerUnmatchedColumnTypeException(function, deriveColumnName, deriveColumnType);
            }
        }
        
        // @jflute -- At the future, I'll refactor this logic. 
    }

    protected void throwDeriveReferrerUnmatchedColumnTypeException(String function, String deriveColumnName, Class<?> deriveColumnType) {
        String msg = "Look! Read the message below." + getLineSeparator();
        msg = msg + "/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *" + getLineSeparator();
        msg = msg + "The type of the specified the column unmatched with the function!" + getLineSeparator();
        msg = msg + getLineSeparator();
        msg = msg + "[Advice]" + getLineSeparator();
        msg = msg + "You should confirm the list as follow:" + getLineSeparator();
        msg = msg + "    max()   : String, Number, Date" + getLineSeparator();
        msg = msg + "    min()   : String, Number, Date" + getLineSeparator();
        msg = msg + "    sum()   : Number" + getLineSeparator();
        msg = msg + "    avg()   : Number" + getLineSeparator();
        msg = msg + "    count() : String, Number, Date" + getLineSeparator();
        msg = msg + getLineSeparator();
        msg = msg + "[Function]" + getLineSeparator() + function + getLineSeparator();
        msg = msg + getLineSeparator();
        msg = msg + "[Derive Column]" + getLineSeparator() + deriveColumnName + "(" + deriveColumnType.getName() + ")" + getLineSeparator();
        msg = msg + "* * * * * * * * * */";
        throw new DeriveReferrerUnmatchedColumnTypeException(msg);
    }

    public static class DeriveReferrerUnmatchedColumnTypeException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        public DeriveReferrerUnmatchedColumnTypeException(String msg) {
            super(msg);
        }
    }
    
    // -----------------------------------------------------
    //                                          Where Clause
    //                                          ------------
    protected void setupConditionValueAndRegisterWhereClause(Sample2ConditionKey key, Object value, Sample2ConditionValue cvalue
                                                             , String colName, String capPropName, String uncapPropName) {
        key.setupConditionValue(cvalue, value, getLocation(uncapPropName, key));// If Java, it is necessary to use uncapPropName!
        getSqlClause().registerWhereClause(getRealColumnName(colName), key, cvalue);
    }

    protected void setupConditionValueAndRegisterWhereClause(Sample2ConditionKey key, Object value, Sample2ConditionValue cvalue
                                                             , String colName, String capPropName, String uncapPropName, Sample2ConditionOption option) {
        key.setupConditionValue(cvalue, value, getLocation(uncapPropName, key), option);// If Java, it is necessary to use uncapPropName!
        getSqlClause().registerWhereClause(getRealColumnName(colName), key, cvalue, option);
    }

    protected void registerWhereClause(String whereClause) {
        getSqlClause().registerWhereClause(whereClause);
    }

    protected void registerInlineWhereClause(String whereClause) {
        if (isBaseQuery(this)) {
            getSqlClause().registerBaseTableInlineWhereClause(whereClause);
        } else {
            getSqlClause().registerOuterJoinInlineWhereClause(getRealAliasName(), whereClause, _onClauseInline);
        }
    }

    // -----------------------------------------------------
    //                                           Union Query
    //                                           -----------
    public void registerUnionQuery(Sample2ConditionQuery unionQuery, boolean unionAll, String unionQueryPropertyName) {
        final String unionQueryClause = getUnionQuerySql(unionQuery, unionQueryPropertyName);
        
        // At the future, building SQL will be moved to sqlClause.
        getSqlClause().registerUnionQuery(unionQueryClause, unionAll);
    }

    protected String getUnionQuerySql(Sample2ConditionQuery unionQuery, String unionQueryPropertyName) {
        final String fromClause = unionQuery.getSqlClause().getFromClause();
        final String whereClause = unionQuery.getSqlClause().getWhereClause();
        final String unionQueryClause;
        if (whereClause.trim().length() <= 0) {
            unionQueryClause = fromClause + " " + getSqlClause().getUnionWhereClauseMark();
        } else {
            final int whereIndex = whereClause.indexOf("where ");
            if (whereIndex < 0) {
                String msg = "The whereClause should have 'where' string: " + whereClause;
                throw new IllegalStateException(msg);
            }
            final int clauseIndex = whereIndex + "where ".length();
            final String mark = getSqlClause().getUnionWhereFirstConditionMark();
            unionQueryClause = fromClause + " " + whereClause.substring(0, clauseIndex) + mark + whereClause.substring(clauseIndex);
        }
        final String oldStr = ".conditionQuery.";
        final String newStr = ".conditionQuery." + unionQueryPropertyName + ".";
        return replaceString(unionQueryClause, oldStr, newStr);// Very Important!
    }

    // -----------------------------------------------------
    //                                               OrderBy
    //                                               -------
    public void withNullsFirst() {// is User Public!
        getSqlClause().addNullsFirstToPreviousOrderBy();
    }
    
    public void withNullsLast() {// is User Public!
        getSqlClause().addNullsLastToPreviousOrderBy();
    }

    protected void registerSpecifiedDerivedOrderBy_Asc(String aliasName) {
        if (!getSqlClause().hasSpecifiedDeriveSubQuery(aliasName)) {
            throwSpecifiedDerivedOrderByAliasNameNotFoundException(aliasName);
        }
        getSqlClause().registerOrderBy(aliasName, null, true);
    }

    protected void registerSpecifiedDerivedOrderBy_Desc(String aliasName) {
        if (!getSqlClause().hasSpecifiedDeriveSubQuery(aliasName)) {
            throwSpecifiedDerivedOrderByAliasNameNotFoundException(aliasName);
        }
        getSqlClause().registerOrderBy(aliasName, null, false);
    }

    protected void throwSpecifiedDerivedOrderByAliasNameNotFoundException(String aliasName) {
        String msg = "Look! Read the message below." + getLineSeparator();
        msg = msg + "/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *" + getLineSeparator();
        msg = msg + "The aliasName was Not Found in specified alias names." + getLineSeparator();
        msg = msg + getLineSeparator();
        msg = msg + "[Advice]" + getLineSeparator();
        msg = msg + "You should specified an alias name that is the same as one in specify-derived-referrer." + getLineSeparator();
        msg = msg + "  For example:" + getLineSeparator();
        msg = msg + "    " + getLineSeparator();
        msg = msg + "    [Wrong]" + getLineSeparator();
        msg = msg + "    /- - - - - - - - - - - - - - - - - - - - " + getLineSeparator();
        msg = msg + "    MemberCB cb = new MemberCB();" + getLineSeparator();
        msg = msg + "    cb.specify().derivePurchaseList().max(new SubQuery<PurchaseCB>() {" + getLineSeparator();
        msg = msg + "        public void query(PurchaseCB subCB) {" + getLineSeparator();
        msg = msg + "            subCB.specify().specifyProduct().columnProductName(); // *No!" + getLineSeparator();
        msg = msg + "        }" + getLineSeparator();
        msg = msg + "    }, \"LATEST_PURCHASE_DATETIME\");" + getLineSeparator();
        msg = msg + "    cb.query().addSpecifiedDerivedOrderBy_Desc(\"WRONG_NAME_DATETIME\");" + getLineSeparator();
        msg = msg + "    - - - - - - - - - -/" + getLineSeparator();
        msg = msg + "    " + getLineSeparator();
        msg = msg + "    [Good!]" + getLineSeparator();
        msg = msg + "    /- - - - - - - - - - - - - - - - - - - - " + getLineSeparator();
        msg = msg + "    MemberCB cb = new MemberCB();" + getLineSeparator();
        msg = msg + "    cb.specify().derivePurchaseList().max(new SubQuery<PurchaseCB>() {" + getLineSeparator();
        msg = msg + "        public void query(PurchaseCB subCB) {" + getLineSeparator();
        msg = msg + "            subCB.specify().columnPurchaseDatetime();// *Point!" + getLineSeparator();
        msg = msg + "        }" + getLineSeparator();
        msg = msg + "    }, \"LATEST_PURCHASE_DATETIME\");" + getLineSeparator();
        msg = msg + "    cb.query().addSpecifiedDerivedOrderBy_Desc(\"LATEST_PURCHASE_DATETIME\");" + getLineSeparator();
        msg = msg + "    - - - - - - - - - -/" + getLineSeparator();
        msg = msg + getLineSeparator();
        msg = msg + "[Not Found Alias Name]" + getLineSeparator() + aliasName + getLineSeparator();
        msg = msg + "* * * * * * * * * */";
        throw new SpecifiedDerivedOrderByAliasNameNotFoundException(msg);
    }

    public static class SpecifiedDerivedOrderByAliasNameNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        public SpecifiedDerivedOrderByAliasNameNotFoundException(String msg) {
            super(msg);
        }
    }

    protected void registerOrderBy(String columnName, boolean ascOrDesc) {
        getSqlClause().registerOrderBy(getRealColumnName(columnName), null, ascOrDesc);
    }

    protected void regOBA(String columnName) {
        registerOrderBy(columnName, true);
    }

    protected void regOBD(String columnName) {
        registerOrderBy(columnName, false);
    }
    
    // ===================================================================================
    //                                                                       Name Resolver
    //                                                                       =============
    /**
     * Resolve join alias name.
     * @param relationPath Relation path. (NotNull)
     * @param nestLevel Nest level.
     * @return Resolved join alias name. (NotNull)
     */
    protected String resolveJoinAliasName(String relationPath, int nestLevel) {
        return getSqlClause().resolveJoinAliasName(relationPath, nestLevel);
    }

    protected String resolveNestLevelExpression(String name) {
        return getSqlClause().resolveNestLevelExpression(name, getNestLevel());
    }

    protected String resolveNextRelationPath(String tableName, String relationPropertyName) {
        final int relationNo = getSqlClause().resolveRelationNo(tableName, relationPropertyName);
        String nextRelationPath = "_" + relationNo;
        if (_relationPath != null) {
            nextRelationPath = _relationPath + nextRelationPath;
        }
        return nextRelationPath;
    }
    
    // ===================================================================================
    //                                                                     Fixed Condition
    //                                                                     ===============
    protected String prepareFixedCondition(String fixedCondition, String localAliasName, String foreignAliasName) {
        fixedCondition = replaceString(fixedCondition, "$$alias$$", foreignAliasName);
        fixedCondition = replaceString(fixedCondition, "$$foreignAlias$$", foreignAliasName);
        fixedCondition = replaceString(fixedCondition, "$$localAlias$$", localAliasName);
        return fixedCondition;
    }

    // ===================================================================================
    //                                                                 Reflection Invoking
    //                                                                 ===================
    /**
     * The implementation.
     * @param columnFlexibleName The flexible name of the column. (NotNull and NotEmpty)
     * @return The conditionValue. (NotNull)
     */
    public Sample2ConditionValue invokeValue(String columnFlexibleName) {
        assertStringNotNullAndNotTrimmedEmpty("columnFlexibleName", columnFlexibleName);
        final Sample2DBMeta dbmeta = Sample2DBMetaInstanceHandler.findDBMeta(getTableDbName());
        final String columnCapPropName = initCap(dbmeta.findPropertyName(columnFlexibleName));
        final String methodName = "get" + columnCapPropName;
        final Method method = helpGettingCQMethod(this, methodName, new Class<?>[]{}, columnFlexibleName);
        return (Sample2ConditionValue)helpInvokingCQMethod(this, method, new Object[]{});
    }

    /**
     * The implementation.
     * @param columnFlexibleName The flexible name of the column allowed to contain relations. (NotNull and NotEmpty)
     * @param conditionKeyName The name of the conditionKey. (NotNull)
     * @param value The value of the condition. (NotNull)
     */
    public void invokeQuery(String columnFlexibleName, String conditionKeyName, Object value) {
        assertStringNotNullAndNotTrimmedEmpty("columnFlexibleName", columnFlexibleName);
        assertStringNotNullAndNotTrimmedEmpty("conditionKeyName", conditionKeyName);
        if (value == null) {
            return;
        }
        final PropertyNameCQContainer container = helpExtractingPropertyNameCQContainer(columnFlexibleName);
        final String propertyName = container.getPropertyName();
        final Sample2ConditionQuery cq = container.getConditionQuery();
        final Sample2DBMeta dbmeta = Sample2DBMetaInstanceHandler.findDBMeta(cq.getTableDbName());
        final String columnCapPropName = initCap(dbmeta.findPropertyName(propertyName));
        final String methodName = "set" + columnCapPropName + "_" + initCap(conditionKeyName);
        final Method method = helpGettingCQMethod(cq, methodName, new Class<?>[]{value.getClass()}, propertyName);
        helpInvokingCQMethod(cq, method, new Object[]{value});
    }

    /**
     * The implementation.
     * @param columnFlexibleName The flexible name of a column allowed to contain relations. (NotNull and NotEmpty)
     * @param isAsc Is it ascend?
     */
    public void invokeOrderBy(String columnFlexibleName, boolean isAsc) {
        assertStringNotNullAndNotTrimmedEmpty("columnFlexibleName", columnFlexibleName);
        final PropertyNameCQContainer container = helpExtractingPropertyNameCQContainer(columnFlexibleName);
        final String propertyName = container.getPropertyName();
        final Sample2ConditionQuery cq = container.getConditionQuery();
        final String ascDesc = isAsc ? "Asc" : "Desc";
        final Sample2DBMeta dbmeta = Sample2DBMetaInstanceHandler.findDBMeta(cq.getTableDbName());
        final String columnCapPropName = initCap(dbmeta.findPropertyName(propertyName));
        final String methodName = "addOrderBy_" + columnCapPropName + "_" + ascDesc;
        final Method method = helpGettingCQMethod(cq, methodName, new Class<?>[]{}, propertyName);
        helpInvokingCQMethod(cq, method, new Object[]{});
    }

    /**
     * The implementation.
     * @param foreignPropertyName The property name of foreign. (NotNull and NotEmpty)
     * @return The conditionQuery of foreign as interface. (NotNull)
     */
    public Sample2ConditionQuery invokeForeignCQ(String foreignPropertyName) {
        assertStringNotNullAndNotTrimmedEmpty("foreignPropertyName", foreignPropertyName);
        final String methodName = "query" + initCap(foreignPropertyName);
        final Method method = helpGettingCQMethod(this, methodName, new Class<?>[]{}, foreignPropertyName);
        return (Sample2ConditionQuery)helpInvokingCQMethod(this, method, new Object[]{});
    }

    private PropertyNameCQContainer helpExtractingPropertyNameCQContainer(String name) {
        final String[] strings = name.split("\\.");
        final int length = strings.length;
        String propertyName = null;
        Sample2ConditionQuery cq = this;
        int index = 0;
        for (String element : strings) {
            if (length == (index+1)) {// at last loop!
                propertyName = element;
                break;
            }
            cq = cq.invokeForeignCQ(element);
            ++index;
        }
        return new PropertyNameCQContainer(propertyName, cq);
    }

    private static class PropertyNameCQContainer {
        protected String _propertyName;
        protected Sample2ConditionQuery _cq;
        public PropertyNameCQContainer(String propertyName, Sample2ConditionQuery cq) {
            this._propertyName = propertyName;
            this._cq = cq;
        }
        public String getPropertyName() {
            return _propertyName;
        }
        public Sample2ConditionQuery getConditionQuery() {
            return _cq;
        }
    }

    private Method helpGettingCQMethod(Sample2ConditionQuery cq, String methodName, Class<?>[] argTypes, String property) {
        try {
            return cq.getClass().getMethod(methodName, argTypes);
        } catch (NoSuchMethodException e) {
            String msg = "The method is not existing:";
            msg = msg + " methodName=" + methodName;
            msg = msg + " argTypes=" + convertObjectArrayToStringView(argTypes);
            msg = msg + " tableName=" + cq.getTableDbName();
            msg = msg + " property=" + property;
            throw new IllegalStateException(msg, e);
        }
    }

    private Object helpInvokingCQMethod(Sample2ConditionQuery cq, Method method, Object[] args) {
        try {
            return method.invoke(cq, args);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        } catch (InvocationTargetException e) {
            throw new IllegalStateException(e.getCause());
        }
    }

    // ===================================================================================
    //                                                                       Assist Helper
    //                                                                       =============
    /**
     * @param value Query-value-string. (Nullable)
     * @return Filtered value. (Nullable)
     */
    protected String fRES(String value) {
        return filterRemoveEmptyString(value);
    }

    /**
     * @param value Query-value-string. (Nullable)
     * @return Filtered value. (Nullable)
     */
    private String filterRemoveEmptyString(String value) {
        return ((value != null && !"".equals(value)) ? value : null);
    }
    
    /**
     * @param col Target collection. (Nullable)
     * @param <PROPERTY_TYPE> The type of property.
     * @return List. (Nullable: If the argument is null, returns null.)
     */
    protected <PROPERTY_TYPE> List<PROPERTY_TYPE> cTL(Collection<PROPERTY_TYPE> col) {
        return convertToList(col);
    }
    
    /**
     * @param col Target collection. (Nullable)
     * @param <PROPERTY_TYPE> The type of property.
     * @return List. (Nullable: If the argument is null, returns null.)
     */
    private <PROPERTY_TYPE> List<PROPERTY_TYPE> convertToList(Collection<PROPERTY_TYPE> col) {
        if (col == null) {
            return null;
        }
        if (col instanceof List) {
            return filterRemoveNullOrEmptyValueFromList((List<PROPERTY_TYPE>)col);
        }
        return filterRemoveNullOrEmptyValueFromList(new ArrayList<PROPERTY_TYPE>(col));
    }

    private <PROPERTY_TYPE> List<PROPERTY_TYPE> filterRemoveNullOrEmptyValueFromList(List<PROPERTY_TYPE> ls) {
        if (ls == null) {
            return null;
        }
        List<PROPERTY_TYPE> newList = new ArrayList<PROPERTY_TYPE>();
        for (Iterator<PROPERTY_TYPE> ite = ls.iterator(); ite.hasNext(); ) {
            final PROPERTY_TYPE element = ite.next();
            if (element == null) {
                continue;
            }
            if (element instanceof String) {
                if (((String)element).length() == 0) {
                    continue;
                }
            }
            newList.add(element);
        }
        return newList;
    }
    
    public void doNss(NssCall callback) {// Very Internal
        String foreignPropertyName = callback.qf().getForeignPropertyName();
        String foreignTableAliasName = callback.qf().getRealAliasName();
        getSqlClause().registerSelectedSelectColumn(foreignTableAliasName, getTableDbName(), foreignPropertyName, getRelationPath());
        getSqlClause().registerSelectedForeignInfo(callback.qf().getRelationPath(), foreignPropertyName);
    }
    
    public static interface NssCall {// Very Internal
        public Sample2ConditionQuery qf();
    }

    protected void registerOuterJoin(Sample2ConditionQuery cq, Map<String, String> joinOnMap) {
        getSqlClause().registerOuterJoin(cq.getTableSqlName(), cq.getRealAliasName(), joinOnMap);
    }
    
    // ===================================================================================
    //                                                                      General Helper
    //                                                                      ==============
    protected final String replaceString(String text, String fromText, String toText) {
        return Sample2SimpleStringUtil.replace(text, fromText, toText);
    }

    protected String initCap(String str) {
        return Sample2SimpleStringUtil.initCap(str);
    }

    protected String getLineSeparator() {
        return Sample2SimpleSystemUtil.getLineSeparator();
    }

    protected String convertObjectArrayToStringView(Object[] objArray) {
	    return Sample2TraceViewUtil.convertObjectArrayToStringView(objArray);
    }

    // -----------------------------------------------------
    //                                  Collection Generator
    //                                  --------------------
    protected <KEY, VALUE> LinkedHashMap<KEY, VALUE> newLinkedHashMap() {
        return new LinkedHashMap<KEY, VALUE>();
    }

    // -----------------------------------------------------
    //                                         Assert Object
    //                                         -------------
    /**
     * Assert that the object is not null.
     * @param variableName Variable name. (NotNull)
     * @param value Value. (NotNull)
     * @exception IllegalArgumentException
     */
    protected void assertObjectNotNull(String variableName, Object value) {
        if (variableName == null) {
            String msg = "The value should not be null: variableName=" + variableName + " value=" + value;
            throw new IllegalArgumentException(msg);
        }
        if (value == null) {
            String msg = "The value should not be null: variableName=" + variableName;
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * Assert that the column-name is not null and is not empty and does not contain comma.
     * @param columnName Column-name. (NotNull)
     * @exception IllegalArgumentException
     */
    protected void assertColumnName(String columnName) {
        if (columnName == null) {
            String msg = "The columnName should not be null.";
            throw new IllegalArgumentException(msg);
        }
        if (columnName.trim().length() == 0) {
            String msg = "The columnName should not be empty-string.";
            throw new IllegalArgumentException(msg);
        }
        if (columnName.indexOf(",") >= 0) {
            String msg = "The columnName should not contain comma ',': " + columnName;
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * Assert that the alias-name is not null and is not empty and does not contain comma.
     * @param aliasName Alias-name. (NotNull)
     * @exception IllegalArgumentException
     */
    protected void assertAliasName(String aliasName) {
        if (aliasName == null) {
            String msg = "The aliasName should not be null.";
            throw new IllegalArgumentException(msg);
        }
        if (aliasName.trim().length() == 0) {
            String msg = "The aliasName should not be empty-string.";
            throw new IllegalArgumentException(msg);
        }
        if (aliasName.indexOf(",") >= 0) {
            String msg = "The aliasName should not contain comma ',': " + aliasName;
            throw new IllegalArgumentException(msg);
        }
    }

    // -----------------------------------------------------
    //                                         Assert String
    //                                         -------------
    /**
     * Assert that the entity is not null and not trimmed empty.
     * @param variableName Variable name. (NotNull)
     * @param value Value. (NotNull)
     */
    protected void assertStringNotNullAndNotTrimmedEmpty(String variableName, String value) {
        assertObjectNotNull("variableName", variableName);
        assertObjectNotNull("value", value);
        if (value.trim().length() ==0) {
            String msg = "The value should not be empty: variableName=" + variableName + " value=" + value;
            throw new IllegalArgumentException(msg);
        }
    }
    
    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    public String toString() {
        return getClass().getSimpleName() + ":{aliasName=" + _aliasName + ", nestLevel=" + _nestLevel
             + ", subQueryLevel=" + _subQueryLevel + ", foreignPropertyName=" + _foreignPropertyName
             + ", relationPath=" + _relationPath + ", onClauseInline=" + _onClauseInline + "}";
    }
}
