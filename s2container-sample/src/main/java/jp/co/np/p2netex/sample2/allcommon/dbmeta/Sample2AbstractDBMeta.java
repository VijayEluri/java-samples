package jp.co.np.p2netex.sample2.allcommon.dbmeta;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.lang.reflect.Method;

import jp.co.np.p2netex.sample2.allcommon.Sample2Entity;
import jp.co.np.p2netex.sample2.allcommon.helper.Sample2MapListString;
import jp.co.np.p2netex.sample2.allcommon.helper.Sample2MapListStringImpl;
import jp.co.np.p2netex.sample2.allcommon.helper.Sample2MapStringBuilder;
import jp.co.np.p2netex.sample2.allcommon.helper.Sample2MapStringBuilderImpl;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.info.Sample2ColumnInfo;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.info.Sample2ForeignInfo;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.info.Sample2ReferrerInfo;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.info.Sample2RelationInfo;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.info.Sample2UniqueInfo;
import jp.co.np.p2netex.sample2.allcommon.util.Sample2SimpleAssertUtil;
import jp.co.np.p2netex.sample2.allcommon.util.Sample2SimpleStringUtil;
import jp.co.np.p2netex.sample2.allcommon.util.Sample2SimpleSystemUtil;

/**
 * The abstract class of DB meta.
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public abstract class Sample2AbstractDBMeta implements Sample2DBMeta {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Sample2ColumnInfo> _columnInfoList;

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    /**
     * The implementation.
     * @param columnFlexibleName The flexible name of the column. (NotNull)
     * @return Determination.
     */
    public boolean hasColumn(String columnFlexibleName) {
        if (!hasFlexibleName(columnFlexibleName)) {
            return false;
        }
        final String propertyName = findPropertyName(columnFlexibleName);
        return hasMethod("column" + initCap(propertyName));
    }

    /**
     * The implementation.
     * @param columnFlexibleName The flexible name of the column. (NotNull and NotEmpty)
     * @return The information of the column. (NotNull)
     */ 
    public Sample2ColumnInfo findColumnInfo(String columnFlexibleName) {
        assertStringNotNullAndNotTrimmedEmpty("columnFlexibleName", columnFlexibleName);
        if (!hasColumn(columnFlexibleName)) {
            String msg = "Not found column by columnFlexibleName: " + columnFlexibleName;
            msg = msg + " tableName=" + getTableDbName();
            throw new IllegalArgumentException(msg);
        }
        String methodName = "column" + initCap(findPropertyName(columnFlexibleName));
        Method method = null;
        try {
            method = this.getClass().getMethod(methodName, new Class[]{});
        } catch (NoSuchMethodException e) {
            String msg = "Not found column by columnFlexibleName: " + columnFlexibleName;
            msg = msg + " tableName=" + getTableDbName() + " methodName=" + methodName;
            throw new RuntimeException(msg, e);
        }
        try {
            return (Sample2ColumnInfo)method.invoke(this, new Object[]{});
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (java.lang.reflect.InvocationTargetException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    protected Sample2ColumnInfo cci(String columnDbName, String propertyName
                           , Class<?> propertyType, boolean primary
                           , Integer columnSize, Integer columnDecimalDigits) {// createColumnInfo()
        return new Sample2ColumnInfo(this, columnDbName, propertyName, propertyType, primary, columnSize, columnDecimalDigits);
    }

    protected Sample2ColumnInfo cci(String columnDbName, String propertyName
                           , Class<?> propertyType, boolean primary
                           , Integer columnSize, Integer columnDecimalDigits, OptimisticLockType optimisticLockType) {// createColumnInfo()
        return new Sample2ColumnInfo(this, columnDbName, propertyName, propertyType, primary, columnSize, columnDecimalDigits, optimisticLockType);
    }

    /**
	 * The implementation.
     * @return The list of columns. (NotNull and NotEmpty)
     */
    public List<Sample2ColumnInfo> getColumnInfoList() {
        if (_columnInfoList != null) {
            return _columnInfoList;
        }
        synchronized (this) {
            if (_columnInfoList != null) {
                return _columnInfoList;
            }
            Method[] methods = this.getClass().getMethods();
            _columnInfoList = newArrayList();
            String prefix = "column";
            Class<Sample2ColumnInfo> returnType = Sample2ColumnInfo.class;
            Object[] args = new Object[]{};
            try {
                for (Method method : methods) {
                    if (method.getName().startsWith(prefix) && returnType.equals(method.getReturnType())) {
                        _columnInfoList.add((Sample2ColumnInfo)method.invoke(this, args));
                    }
                }
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
            return _columnInfoList;
        }
    }

    protected void initializeColumnInfoList() {
        getColumnInfoList();// Ignore return value because of initialization only!
    }
	
    // =====================================================================================
    //                                                                         Name Handling
    //                                                                         =============
    /**
     * The implementation.
     * @param flexibleName Flexible-name(IgnoreCase). (NotNull and NotEmpty)
     * @return Determination.
     */
    public boolean hasFlexibleName(String flexibleName) {
        final String key = flexibleName.toLowerCase();
        if (getDbNamePropertyNameKeyToLowerMap().containsKey(key)) {
            return true;
        }
        if (getPropertyNameDbNameKeyToLowerMap().containsKey(key)) {
            return true;
        }
        return false;
    }

    /**
     * The implementation.
     * @param flexibleName Flexible-name(IgnoreCase). (NotNull and NotEmpty)
     * @return DB name. (NotNull and NotEmpty)
     */
    public String findDbName(String flexibleName) {
        final String key = flexibleName.toLowerCase();
        if (getPropertyNameDbNameKeyToLowerMap().containsKey(key)) {
            return (String)getPropertyNameDbNameKeyToLowerMap().get(key);
        }
        if (getDbNamePropertyNameKeyToLowerMap().containsKey(key)) {
            final String dbNameKeyToLower = ((String)getDbNamePropertyNameKeyToLowerMap().get(key)).toLowerCase();
            if (getPropertyNameDbNameKeyToLowerMap().containsKey(dbNameKeyToLower)) {
                return (String)getPropertyNameDbNameKeyToLowerMap().get(dbNameKeyToLower);
            }
        }
        String msg = "Not found object by the flexible name: flexibleName=" + flexibleName;
        throw new IllegalStateException(msg);
    }

    /**
     * The implementation.
     * @param flexibleName Flexible-name(IgnoreCase). (NotNull and NotEmpty)
     * @return DB name. (NotNull and NotEmpty)
     */
    public String findPropertyName(String flexibleName) {
        final String key = flexibleName.toLowerCase();
        if (getDbNamePropertyNameKeyToLowerMap().containsKey(key)) {
            return (String)getDbNamePropertyNameKeyToLowerMap().get(key);
        }
        if (getPropertyNameDbNameKeyToLowerMap().containsKey(key)) {
            final String dbNameToLower = ((String)getPropertyNameDbNameKeyToLowerMap().get(key)).toLowerCase();
            if (getDbNamePropertyNameKeyToLowerMap().containsKey(dbNameToLower)) {
                return (String)getDbNamePropertyNameKeyToLowerMap().get(dbNameToLower);
            }
        }
        String msg = "Not found object by the flexible name: flexibleName=" + flexibleName;
        throw new IllegalStateException(msg);
    }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    protected Sample2UniqueInfo createPrimaryUniqueInfo() {
        Sample2UniqueInfo uniqueInfo = new Sample2UniqueInfo();
        uniqueInfo.setDBMeta(this);
        uniqueInfo.setPrimary(true);
        return uniqueInfo;
    }

    protected Sample2UniqueInfo createPrimaryUniqueInfo(Sample2ColumnInfo uniqueColumnInfo) {
        Sample2UniqueInfo uniqueInfo = new Sample2UniqueInfo();
        uniqueInfo.setDBMeta(this);
        uniqueInfo.setPrimary(true);
		uniqueInfo.addUniqueColumnList(uniqueColumnInfo);
        return uniqueInfo;
    }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    /**
     * @param relationPropertyName Relation property name. (Both OK - InitCap or not). (NotNull)
     * @return The information of relation. (NotNull)
     */ 
    public Sample2RelationInfo findRelationInfo(String relationPropertyName) {
        assertStringNotNullAndNotTrimmedEmpty("relationPropertyName", relationPropertyName);
        return hasForeign(relationPropertyName) ? (Sample2RelationInfo)findForeignInfo(relationPropertyName) : (Sample2RelationInfo)findReferrerInfo(relationPropertyName);
    }

    // -----------------------------------------------------
    //                                       Foreign Element
    //                                       ---------------
    /**
     * @param foreignPropertyName The property name of foreign. (Both OK - InitCap or not). (NotNull)
     * @return Determination. (NotNull)
     */ 
    public boolean hasForeign(String foreignPropertyName) {
        assertStringNotNullAndNotTrimmedEmpty("foreignPropertyName", foreignPropertyName);
        final String methodName = buildRelationInfoGetterMethodNameInitCap("foreign", foreignPropertyName);
        return hasMethod(methodName);
    }

    /**
     * @param foreignPropertyName The property name of foreign. (Both OK - InitCap or not). (NotNull)
     * @return Foreign DBMeta. (NotNull)
     */ 
    public Sample2DBMeta findForeignDBMeta(String foreignPropertyName) {
        return findForeignInfo(foreignPropertyName).getForeignDBMeta();
    }

    /**
     * @param foreignPropertyName The property name of foreign. (Both OK - InitCap or not). (NotNull)
     * @return Foreign information. (NotNull)
     */ 
    public jp.co.np.p2netex.sample2.allcommon.dbmeta.info.Sample2ForeignInfo findForeignInfo(String foreignPropertyName) {
        assertStringNotNullAndNotTrimmedEmpty("foreignPropertyName", foreignPropertyName);
        final String methodName = buildRelationInfoGetterMethodNameInitCap("foreign", foreignPropertyName);
        java.lang.reflect.Method method = null;
        try {
            method = this.getClass().getMethod(methodName, new Class[]{});
        } catch (NoSuchMethodException e) {
            String msg = "Not found foreign by foreignPropertyName: foreignPropertyName=" + foreignPropertyName;
            msg = msg + " tableName=" + getTableDbName() + " methodName=" + methodName;
            throw new RuntimeException(msg, e);
        }
        try {
            return (Sample2ForeignInfo)method.invoke(this, new Object[]{});
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (java.lang.reflect.InvocationTargetException e) {
            throw new RuntimeException(e.getCause());
        }
    }
    
    protected Sample2ForeignInfo cfi(String propName
                            , Sample2DBMeta localDbm, Sample2DBMeta foreignDbm
                            , Map<Sample2ColumnInfo, Sample2ColumnInfo> localForeignColumnInfoMap
                            , int relNo, boolean oneToOne) {// createForeignInfo()
        final Sample2ForeignInfo foreignInfo = new Sample2ForeignInfo();
        foreignInfo.setForeignPropertyName(propName);
        foreignInfo.setLocalDBMeta(localDbm);
        foreignInfo.setForeignDBMeta(foreignDbm);
        foreignInfo.setLocalForeignColumnInfoMap(localForeignColumnInfoMap);
        foreignInfo.setRelationNo(relNo);
        foreignInfo.setOneToOne(oneToOne);
        return foreignInfo;
    }
	
    // -----------------------------------------------------
    //                                      Referrer Element
    //                                      ----------------
    /**
     * @param referrerPropertyName The property name of referrer. (Both OK - InitCap or not). (NotNull)
     * @return Determination. (NotNull)
     */ 
    public boolean hasReferrer(String referrerPropertyName) {
        assertStringNotNullAndNotTrimmedEmpty("referrerPropertyName", referrerPropertyName);
        final String methodName = buildRelationInfoGetterMethodNameInitCap("referrer", referrerPropertyName);
        return hasMethod(methodName);
    }

    /**
     * @param referrerPropertyName The property name of referrer. (Both OK - InitCap or not). (NotNull)
     * @return Referrer DBMeta. (NotNull)
     */ 
    public Sample2DBMeta findReferrerDBMeta(String referrerPropertyName) {
        assertStringNotNullAndNotTrimmedEmpty("referrerPropertyName", referrerPropertyName);
        return findReferrerInfo(referrerPropertyName).getReferrerDBMeta();
    }

    /**
     * @param referrerPropertyName The property name of referrer. (Both OK - InitCap or not). (NotNull)
     * @return Referrer information. (NotNull)
     */ 
    public Sample2ReferrerInfo findReferrerInfo(String referrerPropertyName) {
        assertStringNotNullAndNotTrimmedEmpty("referrerPropertyName", referrerPropertyName);
        final String methodName = buildRelationInfoGetterMethodNameInitCap("referrer", referrerPropertyName);
        java.lang.reflect.Method method = null;
        try {
            method = this.getClass().getMethod(methodName, new Class[]{});
        } catch (NoSuchMethodException e) {
            String msg = "Not found referrer by referrerPropertyName: referrerPropertyName=" + referrerPropertyName;
            msg = msg + " tableName=" + getTableDbName() + " methodName=" + methodName;
            throw new RuntimeException(msg, e);
        }
        try {
            return (Sample2ReferrerInfo)method.invoke(this, new Object[]{});
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (java.lang.reflect.InvocationTargetException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    protected Sample2ReferrerInfo cri(String propName
                             , Sample2DBMeta localDbm, Sample2DBMeta referrerDbm
                             , Map<Sample2ColumnInfo, Sample2ColumnInfo> localReferrerColumnInfoMap
                             , boolean oneToOne) {// createReferrerInfo()
        final Sample2ReferrerInfo referrerInfo = new Sample2ReferrerInfo();
        referrerInfo.setReferrerPropertyName(propName);
        referrerInfo.setLocalDBMeta(localDbm);
        referrerInfo.setReferrerDBMeta(referrerDbm);
        referrerInfo.setLocalReferrerColumnInfoMap(localReferrerColumnInfoMap);
        referrerInfo.setOneToOne(oneToOne);
        return referrerInfo;
    }

    // -----------------------------------------------------
    //                                          Common Logic
    //                                          ------------
    protected String buildRelationInfoGetterMethodNameInitCap(String targetName, String relationPropertyName) {
        return  targetName + relationPropertyName.substring(0, 1).toUpperCase() + relationPropertyName.substring(1);
    }
	
    // -----------------------------------------------------
    //                                        Relation Trace
    //                                        --------------
    /**
     * Relation trace.
     */
    protected static abstract class AbstractRelationTrace implements RelationTrace {

        /** The list of relation. */
        protected List<Sample2RelationInfo> _relationList;

        /** The list of relation trace. */
        protected List<AbstractRelationTrace> _relationTraceList;

        /** The list of relation info as trace. */
        protected List<Sample2RelationInfo> _traceRelationInfoList;

        /** The column info as trace. */
        protected Sample2ColumnInfo _traceColumnInfo;

        /** The handler of fixed relation trace. */
        protected RelationTraceFixHandler _relationTraceFixHandler;

        /**
         * Constructor for first step.
         * 
         * @param relationTraceFixHandler The handler of fixed relation trace. (Nullable)
         */
        public AbstractRelationTrace(RelationTraceFixHandler relationTraceFixHandler) {
            this(new ArrayList<Sample2RelationInfo>(), new ArrayList<AbstractRelationTrace>());
            this._relationTraceFixHandler = relationTraceFixHandler;
        }

        /**
         * Constructor for relation step.
         * 
         * @param relationList The list of relation. (NotNull)
         * @param relationTraceList The list of relation trace. (NotNull)
         */
        public AbstractRelationTrace(List<Sample2RelationInfo> relationList, List<AbstractRelationTrace> relationTraceList) {
            this._relationList = relationList;
            this._relationTraceList = relationTraceList;
            this._relationTraceList.add(this);
        }

        /**
         * The implementation.
         * @return The trace of relation as the list of relation info. (NotNull)
         */
        public List<Sample2RelationInfo> getTraceRelation() {
            return _traceRelationInfoList;
        }

        /**
         * The implementation.
         * @return The trace of column as column info. (Nullable)
         */
        public Sample2ColumnInfo getTraceColumn() {
            return _traceColumnInfo;
        }

        /**
         * Fix trace.
         * 
         * @param traceRelationInfoList The trace of relation as the list of relation info. (NotNull)
         * @param traceColumnInfo The trace of column as column info. (Nullable)
         * @return Relation trace(result). (NotNull)
         */
        protected RelationTrace fixTrace(List<Sample2RelationInfo> traceRelationInfoList, Sample2ColumnInfo traceColumnInfo) {
            final AbstractRelationTrace localRelationTrace = (AbstractRelationTrace)_relationTraceList.get(0);
            localRelationTrace.setTraceRelation(traceRelationInfoList);
            localRelationTrace.setTraceColumn(traceColumnInfo);
            localRelationTrace.recycle();
            localRelationTrace.handleFixedRelationTrace();
            return localRelationTrace;
        }

        protected void setTraceRelation(List<Sample2RelationInfo> traceRelationInfoList) {
            this._traceRelationInfoList = traceRelationInfoList;
        }

        protected void setTraceColumn(Sample2ColumnInfo traceColumn) {
            this._traceColumnInfo = traceColumn;
        }

        /**
         * The implementation.
         */
        protected void recycle() {
            this._relationList = new ArrayList<Sample2RelationInfo>();
            this._relationTraceList = new ArrayList<AbstractRelationTrace>();
            this._relationTraceList.add(this);
        }

        protected void handleFixedRelationTrace() {
            if (_relationTraceFixHandler != null) {
                _relationTraceFixHandler.handleFixedTrace(this);
            }
        }
    }

    // ===================================================================================
    //                                                                          Map String
    //                                                                          ==========
    /**
     * The implementation.
     * @return Map list string that is prepared. (NotNull)
     */
    public Sample2MapListString createMapListString() {
        return MapStringUtil.createMapListString();
    }

    /**
     * The implementation.
     * @return Map string builder that is prepared. (NotNull)
     */
    public Sample2MapStringBuilder createMapStringBuilder() {
        final List<String> columnDbNameList = new ArrayList<String>();
        for (final Iterator<Sample2ColumnInfo> ite = getColumnInfoList().iterator(); ite.hasNext(); ) {
            final Sample2ColumnInfo columnInfo = (Sample2ColumnInfo)ite.next();
            columnDbNameList.add(columnInfo.getColumnDbName());
        }
        return MapStringUtil.createMapStringBuilder(columnDbNameList);
    }

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    // These methods is expected to override if it needs.
    public boolean hasSequence() { return false; }
    public boolean hasVersionNo() { return false; }
    public Sample2ColumnInfo getVersionNoColumnInfo() { return null; }
    public boolean hasUpdateDate() { return false; }
    public Sample2ColumnInfo getUpdateDateColumnInfo() { return null; }
    public boolean hasCommonColumn() { return false; }

    // ===================================================================================
    //                                                                     Entity Handling
    //                                                                     ===============  
    // -----------------------------------------------------
    //                                                Accept
    //                                                ------
    protected <ENTITY extends Sample2Entity> void doAcceptPrimaryKeyMap(ENTITY entity
            , Map<String, ? extends Object> columnValueMap
            , Map<String, Eps<ENTITY>> entityPropertySetupperMap) {
        MapAssertUtil.assertColumnValueMapNotNullAndNotEmpty(columnValueMap);
        MapStringValueAnalyzer analyzer = new MapStringValueAnalyzer(columnValueMap, entity.getModifiedPropertyNames());
        List<Sample2ColumnInfo> columnInfoList = getPrimaryUniqueInfo().getUniqueColumnList();
        for (Sample2ColumnInfo columnInfo : columnInfoList) {
            String columnName = columnInfo.getColumnDbName();
            String propertyName = columnInfo.getPropertyName();
            String uncapPropName = initUncap(propertyName);
            Class<?> propertyType = columnInfo.getPropertyType();
            if (analyzer.init(columnName, uncapPropName, propertyName)) {
                final Object value;
                if (String.class.isAssignableFrom(propertyType)) {
                    value = analyzer.analyzeString(propertyType);
                } else if (Number.class.isAssignableFrom(propertyType)) {
                    value = analyzer.analyzeNumber(propertyType);
                } else if (java.util.Date.class.isAssignableFrom(propertyType)) {
                    value = analyzer.analyzeDate(propertyType);
                } else {
                    value = analyzer.analyzeOther(propertyType);
                }
                findEps(entityPropertySetupperMap, propertyName).setup(entity, value);
            }
        }
    }

    protected <ENTITY extends Sample2Entity> void doAcceptColumnValueMap(ENTITY entity
            , Map<String, ? extends Object> columnValueMap
            , Map<String, Eps<ENTITY>> entityPropertySetupperMap) {
        MapAssertUtil.assertColumnValueMapNotNullAndNotEmpty(columnValueMap);
        MapStringValueAnalyzer analyzer = new MapStringValueAnalyzer(columnValueMap, entity.getModifiedPropertyNames());
        List<Sample2ColumnInfo> columnInfoList = getColumnInfoList();
        for (Sample2ColumnInfo columnInfo : columnInfoList) {
            String columnName = columnInfo.getColumnDbName();
            String propertyName = columnInfo.getPropertyName();
            String uncapPropName = initUncap(propertyName);
            Class<?> propertyType = columnInfo.getPropertyType();
            if (analyzer.init(columnName, uncapPropName, propertyName)) {
                final Object value;
                if (String.class.isAssignableFrom(propertyType)) {
                    value = analyzer.analyzeString(propertyType);
                } else if (Number.class.isAssignableFrom(propertyType)) {
                    value = analyzer.analyzeNumber(propertyType);
                } else if (java.util.Date.class.isAssignableFrom(propertyType)) {
                    value = analyzer.analyzeDate(propertyType);
                } else {
                    value = analyzer.analyzeOther(propertyType);
                }
                findEps(entityPropertySetupperMap, propertyName).setup(entity, value);
            }
        }
    }

    protected String doExtractPrimaryKeyMapString(Sample2Entity entity
                                                , String startBrace
                                                , String endBrace
                                                , String delimiter
                                                , String equal) {
        String mapMarkAndStartBrace = MAP_STRING_MAP_MARK + startBrace;
        StringBuilder sb = new StringBuilder();
        List<Sample2ColumnInfo> columnInfoList = getPrimaryUniqueInfo().getUniqueColumnList();
		try {
            for (Sample2ColumnInfo columnInfo : columnInfoList) {
                String columnName = columnInfo.getColumnDbName();
                Method getterMethod = columnInfo.findGetter();
				Object value = getterMethod.invoke(entity, (Object[])null);
                helpAppendingColumnValueString(sb, delimiter, equal, columnName, value);
            }
		} catch (Exception e) {
		    throw new IllegalStateException(e);
		}
		sb.delete(0, delimiter.length()).insert(0, mapMarkAndStartBrace).append(endBrace);
		return sb.toString();
	}

    protected String doExtractColumnValueMapString(Sample2Entity entity
                                                 , String startBrace
                                                 , String endBrace
                                                 , String delimiter
                                                 , String equal) {
        String mapMarkAndStartBrace = MAP_STRING_MAP_MARK + startBrace;
        StringBuilder sb = new StringBuilder();
        List<Sample2ColumnInfo> columnInfoList = getColumnInfoList();
		try {
            for (Sample2ColumnInfo columnInfo : columnInfoList) {
                String columnName = columnInfo.getColumnDbName();
                Method getterMethod = columnInfo.findGetter();
				Object value = getterMethod.invoke(entity, (Object[])null);
                helpAppendingColumnValueString(sb, delimiter, equal, columnName, value);
            }
		} catch (Exception e) {
		    throw new IllegalStateException(e);
		}
		sb.delete(0, delimiter.length()).insert(0, mapMarkAndStartBrace).append(endBrace);
		return sb.toString();
	}

    // -----------------------------------------------------
    //                                               Convert
    //                                               -------
    protected Map<String, Object> doConvertToColumnValueMap(Sample2Entity entity) {
        Map<String, Object> valueMap = newLinkedHashMap();
		try {
            List<Sample2ColumnInfo> columnInfoList = getColumnInfoList();
            for (Sample2ColumnInfo columnInfo : columnInfoList) {
                String columnName = columnInfo.getColumnDbName();
                Method getterMethod = columnInfo.findGetter();
                Object value = getterMethod.invoke(entity, (Object[])null);
                valueMap.put(columnName, value);
            }
		} catch (Exception e) {
		    throw new IllegalStateException(e);
		}
        return valueMap;
    }
	
    protected Map<String, String> doConvertToColumnStringValueMap(Sample2Entity entity) {
        Map<String, String> valueMap = newLinkedHashMap();
		try {
            List<Sample2ColumnInfo> columnInfoList = getColumnInfoList();
            for (Sample2ColumnInfo columnInfo : columnInfoList) {
                String columnName = columnInfo.getColumnDbName();
                Method getterMethod = columnInfo.findGetter();
                Object value = getterMethod.invoke(entity, (Object[])null);
                valueMap.put(columnName, helpGettingColumnStringValue(value));
            }
		} catch (Exception e) {
		    throw new IllegalStateException(e);
		}
        return valueMap;
    }
	
	// ===================================================================================
    //                                                               Entity Property Setup
    //                                                               =====================
	// It's very INTERNAL!
    protected <ENTITY extends Sample2Entity> void setupEps(Map<String, Eps<ENTITY>> entityPropertySetupperMap
                                                           , Eps<ENTITY> setupper
                                                           , Sample2ColumnInfo columnInfo) {
        String columnName = columnInfo.getColumnDbName();
        String propertyName = columnInfo.getPropertyName();
        registerEntityPropertySetupper(columnName, propertyName, setupper, entityPropertySetupperMap);
    }

    protected <ENTITY extends Sample2Entity> void registerEntityPropertySetupper(
		                                          String columnName
												, String propertyName
	                                            , Eps<ENTITY> setupper
											    , Map<String, Eps<ENTITY>> entityPropertySetupperMap) {
		entityPropertySetupperMap.put(columnName, setupper);
		entityPropertySetupperMap.put(propertyName, setupper);
		entityPropertySetupperMap.put(columnName.toLowerCase(), setupper);
		entityPropertySetupperMap.put(propertyName.toLowerCase(), setupper);
	}
	
    protected <ENTITY extends Sample2Entity> Eps<ENTITY> findEps(Map<String, Eps<ENTITY>> entityPropertySetupperMap, String propertyName) {
        Eps<ENTITY> setupper = entityPropertySetupperMap.get(propertyName);
        if (setupper == null) {
            String msg = "The propertyName was Not Found in the map of setupper of entity property:";
            msg = msg + " propertyName=" + propertyName + " _entityPropertySetupperMap.keySet()=" + entityPropertySetupperMap.keySet();
            throw new IllegalStateException(msg);
        }
        return setupper;
    }
	
    // ===================================================================================
    //                                                                          Util Class
    //                                                                          ==========
    /**
     * This class is for Internal. Don't use this!
     */
    protected static class MapStringUtil {

        public static void acceptPrimaryKeyMapString(String primaryKeyMapString, Sample2Entity entity) {
            if (primaryKeyMapString == null) {
                String msg = "The argument[primaryKeyMapString] should not be null.";
                throw new IllegalArgumentException(msg);
            }
            final String prefix = MAP_STRING_MAP_MARK + MAP_STRING_START_BRACE;
            final String suffix = MAP_STRING_END_BRACE;
            if (!primaryKeyMapString.trim().startsWith(prefix)) {
                primaryKeyMapString = prefix + primaryKeyMapString;
            }
            if (!primaryKeyMapString.trim().endsWith(suffix)) {
                primaryKeyMapString = primaryKeyMapString + suffix;
            }
            Sample2MapListString mapListString = createMapListString();
            entity.getDBMeta().acceptPrimaryKeyMap(entity, mapListString.generateMap(primaryKeyMapString));
        }

        public static void acceptColumnValueMapString(String columnValueMapString, Sample2Entity entity) {
            if (columnValueMapString == null) {
                String msg = "The argument[columnValueMapString] should not be null.";
                throw new IllegalArgumentException(msg);
            }
            final String prefix = MAP_STRING_MAP_MARK + MAP_STRING_START_BRACE;
            final String suffix = MAP_STRING_END_BRACE;
            if (!columnValueMapString.trim().startsWith(prefix)) {
                columnValueMapString = prefix + columnValueMapString;
            }
            if (!columnValueMapString.trim().endsWith(suffix)) {
                columnValueMapString = columnValueMapString + suffix;
            }
            Sample2MapListString mapListString = createMapListString();
            entity.getDBMeta().acceptColumnValueMap(entity, mapListString.generateMap(columnValueMapString));
        }

        public static String extractPrimaryKeyMapString(Sample2Entity entity) {
            final String startBrace = MAP_STRING_START_BRACE;
            final String endBrace = MAP_STRING_END_BRACE;
            final String delimiter = MAP_STRING_DELIMITER;
            final String equal = MAP_STRING_EQUAL;
            return entity.getDBMeta().extractPrimaryKeyMapString(entity, startBrace, endBrace, delimiter, equal);
        }

        public static String extractColumnValueMapString(Sample2Entity entity) {
            final String startBrace = MAP_STRING_START_BRACE;
            final String endBrace = MAP_STRING_END_BRACE;
            final String delimiter = MAP_STRING_DELIMITER;
            final String equal = MAP_STRING_EQUAL;
            return entity.getDBMeta().extractColumnValueMapString(entity, startBrace, endBrace, delimiter, equal);
        }

        public static void checkTypeString(Object value, String propertyName, String typeName) {
            if (value == null) {
                throw new IllegalArgumentException("The value should not be null: " + propertyName);
            }
            if (!(value instanceof String)) {
                String msg = "The value of " + propertyName + " should be " + typeName + " or String: ";
                msg = msg + "valueType=" + value.getClass() + " value=" + value;
                throw new IllegalArgumentException(msg);
            }
        }

        public static long parseDateStringAsMillis(Object value, String propertyName, String typeName) {
            checkTypeString(value, propertyName, typeName);
            try {
                final String valueString = filterTimestampValue(((String)value).trim());
                return java.sql.Timestamp.valueOf(valueString).getTime();
            } catch (RuntimeException e) {
                String msg = "The value of " + propertyName + " should be " + typeName + ". but: " + value;
                throw new RuntimeException(msg + " threw the exception: value=[" + value + "]", e);
            }
        }

        public static String filterTimestampValue(String value) {
            value = value.trim();
            if (value.indexOf("/") == 4 && value.lastIndexOf("/") == 7) {
                value = value.replaceAll("/", "-");
            }
            if (value.indexOf("-") == 4 && value.lastIndexOf("-") == 7) {
                if (value.length() == "2007-07-09".length()) {
                    value = value + " 00:00:00";
                }
            }
            return value;
        }

        public static String formatDate(java.util.Date value) {
            return getFormatDateFormat().format(value);
        }

        public static String formatTimestamp(java.sql.Timestamp value) {
            return getFormatDateFormat().format(value);
        }

        public static java.text.DateFormat getParseDateFormat() {
            return java.text.DateFormat.getDateInstance();
        }

        public static java.text.DateFormat getFormatDateFormat() {
            return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        }

        public static Sample2MapListString createMapListString() {
            final Sample2MapListString mapListString = new Sample2MapListStringImpl();
            mapListString.setMapMark(MAP_STRING_MAP_MARK);
            mapListString.setListMark(MAP_STRING_LIST_MARK);
            mapListString.setStartBrace(MAP_STRING_START_BRACE);
            mapListString.setEndBrace(MAP_STRING_END_BRACE);
            mapListString.setEqual(MAP_STRING_EQUAL);
            mapListString.setDelimiter(MAP_STRING_DELIMITER);
            return mapListString;
        }

        public static Sample2MapStringBuilder createMapStringBuilder(List<String> columnNameList) {
            Sample2MapStringBuilder mapStringBuilder = new Sample2MapStringBuilderImpl();
            mapStringBuilder.setMsMapMark(MAP_STRING_MAP_MARK);
            mapStringBuilder.setMsStartBrace(MAP_STRING_START_BRACE);
            mapStringBuilder.setMsEndBrace(MAP_STRING_END_BRACE);
            mapStringBuilder.setMsEqual(MAP_STRING_EQUAL);
            mapStringBuilder.setMsDelimiter(MAP_STRING_DELIMITER);
            mapStringBuilder.setColumnNameList(columnNameList);
            return mapStringBuilder;
        }
    }

    /**
     * This class is for Internal. Don't use this!
     */
    protected static class MapAssertUtil {
        public static void assertPrimaryKeyMapNotNullAndNotEmpty(java.util.Map<String, ? extends Object> primaryKeyMap) {
            if (primaryKeyMap == null) {
                String msg = "The argument[primaryKeyMap] should not be null.";
                throw new IllegalArgumentException(msg);
            }
            if (primaryKeyMap.isEmpty()) {
                String msg = "The argument[primaryKeyMap] should not be empty.";
                throw new IllegalArgumentException(msg);
            }
        }
        public static void assertColumnExistingInPrimaryKeyMap(java.util.Map<String, ? extends Object> primaryKeyMap, String columnName) {
            if (!primaryKeyMap.containsKey(columnName)) {
                String msg = "The primaryKeyMap must have the value of " + columnName;
                throw new IllegalStateException(msg + ": primaryKeyMap --> " + primaryKeyMap);
            }
        }
        public static void assertColumnValueMapNotNullAndNotEmpty(java.util.Map<String, ? extends Object> columnValueMap) {
            if (columnValueMap == null) {
                String msg = "The argument[columnValueMap] should not be null.";
                throw new IllegalArgumentException(msg);
            }
            if (columnValueMap.isEmpty()) {
                String msg = "The argument[columnValueMap] should not be empty.";
                throw new IllegalArgumentException(msg);
            }
        }
    }

    /**
     * This class is for Internal. Don't use this!
     */
    protected static class MapStringValueAnalyzer {
        protected java.util.Map<String, ? extends Object> _valueMap;
        protected java.util.Set<String> _modifiedPropertyNames;
        protected String _columnName;
        protected String _uncapPropName;
        protected String _propertyName;

        public MapStringValueAnalyzer(java.util.Map<String, ? extends Object> valueMap, java.util.Set<String> modifiedPropertyNames) {
            this._valueMap = valueMap;
            this._modifiedPropertyNames = modifiedPropertyNames;
        }

        public boolean init(String columnName, String uncapPropName, String propertyName) {
            this._columnName = columnName;
            this._uncapPropName = uncapPropName;
            this._propertyName = propertyName;
            return _valueMap.containsKey(_columnName);
        }

        public <COLUMN_TYPE> COLUMN_TYPE analyzeString(Class<COLUMN_TYPE> javaType) {
            final Object obj = _valueMap.get(_columnName);
            if (obj == null) {
                _modifiedPropertyNames.remove(_propertyName);
                return null;
            }
            helpCheckingTypeString(obj, _uncapPropName, javaType.getName());
            return (COLUMN_TYPE)obj;
        }

        public <COLUMN_TYPE> COLUMN_TYPE analyzeNumber(Class<COLUMN_TYPE> javaType) {
            final Object obj = _valueMap.get(_columnName);
            if (obj == null) {
                _modifiedPropertyNames.remove(_propertyName);
                return null;
            }
            if (javaType.isAssignableFrom(obj.getClass())) {
                return (COLUMN_TYPE)obj;
            }
            return (COLUMN_TYPE)newInstanceByConstructor(javaType, String.class, obj.toString());
        }

        public <COLUMN_TYPE> COLUMN_TYPE analyzeDate(Class<COLUMN_TYPE> javaType) {
            final Object obj = _valueMap.get(_columnName);
            if (obj == null) {
                _modifiedPropertyNames.remove(_propertyName);
                return null;
            }
            if (javaType.isAssignableFrom(obj.getClass())) {
                return (COLUMN_TYPE)obj;
            }
            return (COLUMN_TYPE)newInstanceByConstructor(javaType, long.class, helpParsingDateString(obj, _uncapPropName, javaType.getName()));
        }

        public <COLUMN_TYPE> COLUMN_TYPE analyzeOther(Class<COLUMN_TYPE> javaType) {
            final Object obj = _valueMap.get(_columnName);
            if (obj == null) {
                _modifiedPropertyNames.remove(_propertyName);
                return null;
            }
            return (COLUMN_TYPE)obj;
        }

	    private void helpCheckingTypeString(Object value, String uncapPropName, String typeName) {
	        MapStringUtil.checkTypeString(value, uncapPropName, typeName);
	    }

	    private long helpParsingDateString(Object value, String uncapPropName, String typeName) {
	        return MapStringUtil.parseDateStringAsMillis(value, uncapPropName, typeName);
	    }

        protected Object newInstanceByConstructor(Class targetType, Class argType, Object arg) {
            java.lang.reflect.Constructor constructor;
            try {
                constructor = targetType.getConstructor(new Class[]{argType});
            } catch (SecurityException e) {
                String msg = "targetType=" + targetType + " argType=" + argType + " arg=" + arg;
                throw new RuntimeException(msg, e);
            } catch (NoSuchMethodException e) {
                String msg = "targetType=" + targetType + " argType=" + argType + " arg=" + arg;
                throw new RuntimeException(msg, e);
            }
            try {
                return constructor.newInstance(new Object[]{arg});
            } catch (IllegalArgumentException e) {
                String msg = "targetType=" + targetType + " argType=" + argType + " arg=" + arg;
                throw new RuntimeException(msg, e);
            } catch (InstantiationException e) {
                String msg = "targetType=" + targetType + " argType=" + argType + " arg=" + arg;
                throw new RuntimeException(msg, e);
            } catch (IllegalAccessException e) {
                String msg = "targetType=" + targetType + " argType=" + argType + " arg=" + arg;
                throw new RuntimeException(msg, e);
            } catch (java.lang.reflect.InvocationTargetException e) {
                String msg = "targetType=" + targetType + " argType=" + argType + " arg=" + arg;
                throw new RuntimeException(msg, e);
            }
        }
    }

    // ===================================================================================
    //                                                                       Assist Helper
    //                                                                       =============
	protected <ENTITY> ENTITY downcast(Sample2Entity entity) {
		checkDowncast(entity);
		return (ENTITY)entity;
	}

    protected void checkDowncast(Sample2Entity entity) {
        assertObjectNotNull("entity", entity);
        Class<? extends Sample2Entity> entityType = getEntityType();
        Class<? extends Sample2Entity> targetType = entity.getClass();
        if (!entityType.isAssignableFrom(targetType)) {
            String name = entityType.getSimpleName();
            String msg = "The entity should be " + name + " but it was: " + targetType;
            throw new IllegalStateException(msg);
        }
    }

    protected void helpAppendingColumnValueString(StringBuilder sb, String delimiter, String equal, String colName, Object value) {
        sb.append(delimiter).append(colName).append(equal);
        sb.append(helpGettingColumnStringValue(value));
    }

    protected String helpGettingColumnStringValue(Object value) {
        if (value instanceof java.sql.Timestamp) {
            return (value != null ? helpFormatingTimestamp((java.sql.Timestamp)value) : "");
        } else if (value instanceof java.util.Date) {
            return (value != null ? helpFormatingDate((java.util.Date)value) : "");
        } else {
            return (value != null ? value.toString() : "");
        }
    }

    protected String helpFormatingDate(java.util.Date date) {
        return MapStringUtil.formatDate(date);
    }

    protected String helpFormatingTimestamp(java.sql.Timestamp timestamp) {
        return MapStringUtil.formatTimestamp(timestamp);
    }

    protected Map<String, String> setupKeyToLowerMap(boolean dbNameKey) {
        final Map<String, String> map;
		if (dbNameKey) {
		    map = newLinkedHashMap(getTableDbName().toLowerCase(), getTablePropertyName());
		} else {
		    map = newLinkedHashMap(getTablePropertyName().toLowerCase(), getTableDbName());
		}
        Method[] methods = this.getClass().getMethods();
        String columnInfoMethodPrefix = "column";
        try {
            for (Method method : methods) {
                String name = method.getName();
                if (!name.startsWith(columnInfoMethodPrefix)) {
                    continue;
                }
                Sample2ColumnInfo columnInfo = (Sample2ColumnInfo)method.invoke(this);
                String dbName = columnInfo.getColumnDbName();
                String propertyName = columnInfo.getPropertyName();
                if (dbNameKey) {
                    map.put(dbName.toLowerCase(), propertyName);
                } else {
                    map.put(propertyName.toLowerCase(), dbName);                    
                }
            }
			return Collections.unmodifiableMap(map);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
	
    // ===================================================================================
    //                                                                      General Helper
    //                                                                      ==============
    // -----------------------------------------------------
    //                                       String Handling
    //                                       ---------------
    protected final String replaceString(String text, String fromText, String toText) {
	    return Sample2SimpleStringUtil.replace(text, fromText, toText);
    }

    protected String initCap(String str) {
	    return Sample2SimpleStringUtil.initCap(str);
    }

    protected String initUncap(String str) {
	    return Sample2SimpleStringUtil.initUncap(str);
    }

    protected String getLineSeparator() {
	    return Sample2SimpleSystemUtil.getLineSeparator();
    }
		
    // -----------------------------------------------------
    //                                  Collection Generator
    //                                  --------------------
	protected <KEY, VALUE> HashMap<KEY, VALUE> newHashMap() {
        return new HashMap<KEY, VALUE>();
    }
	
	protected <KEY, VALUE> LinkedHashMap<KEY, VALUE> newLinkedHashMap() {
        return new LinkedHashMap<KEY, VALUE>();
    }
	
	protected <KEY, VALUE> LinkedHashMap<KEY, VALUE> newLinkedHashMap(KEY key, VALUE value) {
		LinkedHashMap<KEY, VALUE> map = newLinkedHashMap();
		map.put(key, value);
        return map;
    }
	
	protected <ELEMENT> ArrayList<ELEMENT> newArrayList() {
	    return new ArrayList<ELEMENT>();
	}
	
	protected <ELEMENT> ArrayList<ELEMENT> newArrayList(Collection<ELEMENT> collection) {
	    return new ArrayList<ELEMENT>(collection);
	}
	
    // -----------------------------------------------------
    //                                   Reflection Handling
    //                                   -------------------
    protected boolean hasMethod(String methodName) {
        assertStringNotNullAndNotTrimmedEmpty("methodName", methodName);
        try {
            this.getClass().getMethod(methodName, new Class[]{});
            return true;
        } catch (NoSuchMethodException ignored) {
            return false;
        }
    }
	
    // -----------------------------------------------------
    //                                         Assert Object
    //                                         -------------
    /**
     * Assert that the argument is not null.
     * @param variableName Variable name. (NotNull)
     * @param value Value. (NotNull)
     */
    protected void assertObjectNotNull(String variableName, Object value) {
        Sample2SimpleAssertUtil.assertObjectNotNull(variableName, value);
    }

    // -----------------------------------------------------
    //                                         Assert String
    //                                         -------------
    /**
     * Assert that the string is not null and not trimmed empty.
     * @param variableName Variable name. (NotNull)
     * @param value Value. (NotNull)
     */
    protected void assertStringNotNullAndNotTrimmedEmpty(String variableName, String value) {
        Sample2SimpleAssertUtil.assertStringNotNullAndNotTrimmedEmpty(variableName, value);
    }
}
