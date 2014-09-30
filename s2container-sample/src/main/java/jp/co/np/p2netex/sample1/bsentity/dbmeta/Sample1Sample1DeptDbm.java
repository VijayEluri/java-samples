package jp.co.np.p2netex.sample1.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import jp.co.np.p2netex.sample1.allcommon.Sample1Entity;
import jp.co.np.p2netex.sample1.allcommon.dbmeta.Sample1AbstractDBMeta;
import jp.co.np.p2netex.sample1.exentity.Sample1Sample1Dept;
import jp.co.np.p2netex.sample1.allcommon.dbmeta.info.*;

/**
 * The DB meta of SAMPLE1_DEPT. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample1Sample1DeptDbm extends Sample1AbstractDBMeta {

    private static final Sample1Sample1DeptDbm _instance = new Sample1Sample1DeptDbm();
    private Sample1Sample1DeptDbm() {}
    public static Sample1Sample1DeptDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    public String getTableDbName() { return "SAMPLE1_DEPT"; }
    public String getTablePropertyName() { return "sample1Dept"; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected Sample1ColumnInfo _columnId = cci("ID", "id", java.lang.Integer.class, true, null, null);
    protected Sample1ColumnInfo _columnName = cci("NAME", "name", String.class, false, 20, 0);
    protected Sample1ColumnInfo _columnVersionNo = cci("VERSION_NO", "versionNo", java.lang.Integer.class, false, null, null, OptimisticLockType.VERSION_NO);

    public Sample1ColumnInfo columnId() { return _columnId; }
    public Sample1ColumnInfo columnName() { return _columnName; }
    public Sample1ColumnInfo columnVersionNo() { return _columnVersionNo; }
    { initializeColumnInfoList(); }

    // ===================================================================================
    //                                                                            Name Map
    //                                                                            ========
    public Map<String, String> getDbNamePropertyNameKeyToLowerMap() { return createDbNamePropertyNameKeyToLowerMap(); }
    public Map<String, String> getPropertyNameDbNameKeyToLowerMap() { return createPropertyNameDbNameKeyToLowerMap(); }
    protected static Map<String, String> _dbNamePropertyNameKeyToLowerMap;
    protected Map<String, String> createDbNamePropertyNameKeyToLowerMap() {
        if (_dbNamePropertyNameKeyToLowerMap == null) { _dbNamePropertyNameKeyToLowerMap = setupKeyToLowerMap(true); }
        return _dbNamePropertyNameKeyToLowerMap;
    }
    protected static Map<String, String> _propertyNameDbNameKeyToLowerMap;
    protected Map<String, String> createPropertyNameDbNameKeyToLowerMap() {
        if (_propertyNameDbNameKeyToLowerMap == null) { _propertyNameDbNameKeyToLowerMap = setupKeyToLowerMap(false); }
        return _propertyNameDbNameKeyToLowerMap;
    }

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "jp.co.np.p2netex.sample1.exentity.Sample1Sample1Dept"; }
    public String getConditionBeanTypeName() { return "jp.co.np.p2netex.sample1.cbean.bs.Sample1Sample1DeptCB"; }
    public String getDaoTypeName() { return "jp.co.np.p2netex.sample1.exdao.Sample1Sample1DeptDao"; }
    public String getBehaviorTypeName() { return "jp.co.np.p2netex.sample1.exbhv.Sample1Sample1DeptBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<Sample1Sample1Dept> getEntityType() { return Sample1Sample1Dept.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Sample1Entity newEntity() { return newMyEntity(); }
    public Sample1Sample1Dept newMyEntity() { return new Sample1Sample1Dept(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    public Sample1UniqueInfo getPrimaryUniqueInfo() { return createPrimaryUniqueInfo(columnId()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasTwoOrMorePrimaryKeys() { return false; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------
    public Sample1ReferrerInfo referrerSample1EmpList() {
        Map<Sample1ColumnInfo, Sample1ColumnInfo> map = newLinkedHashMap(columnId(), Sample1Sample1EmpDbm.getInstance().columnDeptId());
	    return cri("sample1EmpList", this, Sample1Sample1EmpDbm.getInstance(), map, false);
    }

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasVersionNo() { return true; }
    public Sample1ColumnInfo getVersionNoColumnInfo() { return _columnVersionNo; }

    // ===================================================================================
    //                                                                     Entity Handling
    //                                                                     ===============  
    // -----------------------------------------------------
    //                                                Accept
    //                                                ------
    public void acceptPrimaryKeyMap(Sample1Entity entity, Map<String, ? extends Object> primaryKeyMap) {
		doAcceptPrimaryKeyMap((Sample1Sample1Dept)entity, primaryKeyMap, _epsMap);
    }

    public void acceptPrimaryKeyMapString(Sample1Entity entity, String primaryKeyMapString) {
        MapStringUtil.acceptPrimaryKeyMapString(primaryKeyMapString, entity);
    }

    public void acceptColumnValueMap(Sample1Entity entity, Map<String, ? extends Object> columnValueMap) {
        doAcceptColumnValueMap((Sample1Sample1Dept)entity, columnValueMap, _epsMap);
    }

    public void acceptColumnValueMapString(Sample1Entity entity, String columnValueMapString) {
        MapStringUtil.acceptColumnValueMapString(columnValueMapString, entity);
    }

    // -----------------------------------------------------
    //                                               Extract
    //                                               -------
    public String extractPrimaryKeyMapString(Sample1Entity entity) { return MapStringUtil.extractPrimaryKeyMapString(entity); }
    public String extractPrimaryKeyMapString(Sample1Entity entity, String startBrace, String endBrace, String delimiter, String equal) {
        return doExtractPrimaryKeyMapString(entity, startBrace, endBrace, delimiter, equal);
    }
    public String extractColumnValueMapString(Sample1Entity entity) { return MapStringUtil.extractColumnValueMapString(entity); }
    public String extractColumnValueMapString(Sample1Entity entity, String startBrace, String endBrace, String delimiter, String equal) {
        return doExtractColumnValueMapString(entity, startBrace, endBrace, delimiter, equal);
    }

    // -----------------------------------------------------
    //                                               Convert
    //                                               -------
    public List<Object> convertToColumnValueList(Sample1Entity entity) { return newArrayList(convertToColumnValueMap(entity).values()); }
    public Map<String, Object> convertToColumnValueMap(Sample1Entity entity) { return doConvertToColumnValueMap(entity); }
    public List<String> convertToColumnStringValueList(Sample1Entity entity) { return newArrayList(convertToColumnStringValueMap(entity).values()); }
    public Map<String, String> convertToColumnStringValueMap(Sample1Entity entity) { return doConvertToColumnStringValueMap(entity); }

    // ===================================================================================
    //                                                               Entity Property Setup
    //                                                               =====================
    // It's very INTERNAL!
    protected Map<String, Eps<Sample1Sample1Dept>> _epsMap = newHashMap();
    {
        setupEps(_epsMap, new EpsId(), columnId());
        setupEps(_epsMap, new EpsName(), columnName());
        setupEps(_epsMap, new EpsVersionNo(), columnVersionNo());
    }
    
    public boolean hasEntityPropertySetupper(String propertyName) {
        return _epsMap.containsKey(propertyName);
    }

    public void setupEntityProperty(String propertyName, Object entity, Object value) {
        findEps(_epsMap, propertyName).setup((Sample1Sample1Dept)entity, value);
    }
    
    public static class EpsId implements Eps<Sample1Sample1Dept> {
        public void setup(Sample1Sample1Dept e, Object v) { e.setId((java.lang.Integer)v); }
    }
    public static class EpsName implements Eps<Sample1Sample1Dept> {
        public void setup(Sample1Sample1Dept e, Object v) { e.setName((String)v); }
    }
    public static class EpsVersionNo implements Eps<Sample1Sample1Dept> {
        public void setup(Sample1Sample1Dept e, Object v) { e.setVersionNo((java.lang.Integer)v); }
    }
}
