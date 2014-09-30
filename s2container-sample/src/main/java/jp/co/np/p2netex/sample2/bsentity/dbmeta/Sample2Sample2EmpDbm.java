package jp.co.np.p2netex.sample2.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import jp.co.np.p2netex.sample2.allcommon.Sample2Entity;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.Sample2AbstractDBMeta;
import jp.co.np.p2netex.sample2.exentity.Sample2Sample2Emp;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.info.*;

/**
 * The DB meta of SAMPLE2_EMP. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample2Sample2EmpDbm extends Sample2AbstractDBMeta {

    private static final Sample2Sample2EmpDbm _instance = new Sample2Sample2EmpDbm();
    private Sample2Sample2EmpDbm() {}
    public static Sample2Sample2EmpDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    public String getTableDbName() { return "SAMPLE2_EMP"; }
    public String getTablePropertyName() { return "sample2Emp"; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected Sample2ColumnInfo _columnId = cci("ID", "id", java.lang.Integer.class, true, null, null);
    protected Sample2ColumnInfo _columnName = cci("NAME", "name", String.class, false, 20, 0);
    protected Sample2ColumnInfo _columnHireDate = cci("HIRE_DATE", "hireDate", java.util.Date.class, false, null, null);
    protected Sample2ColumnInfo _columnDeptId = cci("DEPT_ID", "deptId", java.lang.Integer.class, false, null, null);
    protected Sample2ColumnInfo _columnVersionNo = cci("VERSION_NO", "versionNo", java.math.BigDecimal.class, false, 8, 0, OptimisticLockType.VERSION_NO);

    public Sample2ColumnInfo columnId() { return _columnId; }
    public Sample2ColumnInfo columnName() { return _columnName; }
    public Sample2ColumnInfo columnHireDate() { return _columnHireDate; }
    public Sample2ColumnInfo columnDeptId() { return _columnDeptId; }
    public Sample2ColumnInfo columnVersionNo() { return _columnVersionNo; }
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
    public String getEntityTypeName() { return "jp.co.np.p2netex.sample2.exentity.Sample2Sample2Emp"; }
    public String getConditionBeanTypeName() { return "jp.co.np.p2netex.sample2.cbean.bs.Sample2Sample2EmpCB"; }
    public String getDaoTypeName() { return "jp.co.np.p2netex.sample2.exdao.Sample2Sample2EmpDao"; }
    public String getBehaviorTypeName() { return "jp.co.np.p2netex.sample2.exbhv.Sample2Sample2EmpBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<Sample2Sample2Emp> getEntityType() { return Sample2Sample2Emp.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Sample2Entity newEntity() { return newMyEntity(); }
    public Sample2Sample2Emp newMyEntity() { return new Sample2Sample2Emp(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    public Sample2UniqueInfo getPrimaryUniqueInfo() { return createPrimaryUniqueInfo(columnId()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasTwoOrMorePrimaryKeys() { return false; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    public Sample2ForeignInfo foreignSample2Dept() {
		Map<Sample2ColumnInfo, Sample2ColumnInfo> map = newLinkedHashMap(columnDeptId(), Sample2Sample2DeptDbm.getInstance().columnId());
	    return cfi("sample2Dept", this, Sample2Sample2DeptDbm.getInstance(), map, 0, false);
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasVersionNo() { return true; }
    public Sample2ColumnInfo getVersionNoColumnInfo() { return _columnVersionNo; }

    // ===================================================================================
    //                                                                     Entity Handling
    //                                                                     ===============  
    // -----------------------------------------------------
    //                                                Accept
    //                                                ------
    public void acceptPrimaryKeyMap(Sample2Entity entity, Map<String, ? extends Object> primaryKeyMap) {
		doAcceptPrimaryKeyMap((Sample2Sample2Emp)entity, primaryKeyMap, _epsMap);
    }

    public void acceptPrimaryKeyMapString(Sample2Entity entity, String primaryKeyMapString) {
        MapStringUtil.acceptPrimaryKeyMapString(primaryKeyMapString, entity);
    }

    public void acceptColumnValueMap(Sample2Entity entity, Map<String, ? extends Object> columnValueMap) {
        doAcceptColumnValueMap((Sample2Sample2Emp)entity, columnValueMap, _epsMap);
    }

    public void acceptColumnValueMapString(Sample2Entity entity, String columnValueMapString) {
        MapStringUtil.acceptColumnValueMapString(columnValueMapString, entity);
    }

    // -----------------------------------------------------
    //                                               Extract
    //                                               -------
    public String extractPrimaryKeyMapString(Sample2Entity entity) { return MapStringUtil.extractPrimaryKeyMapString(entity); }
    public String extractPrimaryKeyMapString(Sample2Entity entity, String startBrace, String endBrace, String delimiter, String equal) {
        return doExtractPrimaryKeyMapString(entity, startBrace, endBrace, delimiter, equal);
    }
    public String extractColumnValueMapString(Sample2Entity entity) { return MapStringUtil.extractColumnValueMapString(entity); }
    public String extractColumnValueMapString(Sample2Entity entity, String startBrace, String endBrace, String delimiter, String equal) {
        return doExtractColumnValueMapString(entity, startBrace, endBrace, delimiter, equal);
    }

    // -----------------------------------------------------
    //                                               Convert
    //                                               -------
    public List<Object> convertToColumnValueList(Sample2Entity entity) { return newArrayList(convertToColumnValueMap(entity).values()); }
    public Map<String, Object> convertToColumnValueMap(Sample2Entity entity) { return doConvertToColumnValueMap(entity); }
    public List<String> convertToColumnStringValueList(Sample2Entity entity) { return newArrayList(convertToColumnStringValueMap(entity).values()); }
    public Map<String, String> convertToColumnStringValueMap(Sample2Entity entity) { return doConvertToColumnStringValueMap(entity); }

    // ===================================================================================
    //                                                               Entity Property Setup
    //                                                               =====================
    // It's very INTERNAL!
    protected Map<String, Eps<Sample2Sample2Emp>> _epsMap = newHashMap();
    {
        setupEps(_epsMap, new EpsId(), columnId());
        setupEps(_epsMap, new EpsName(), columnName());
        setupEps(_epsMap, new EpsHireDate(), columnHireDate());
        setupEps(_epsMap, new EpsDeptId(), columnDeptId());
        setupEps(_epsMap, new EpsVersionNo(), columnVersionNo());
    }
    
    public boolean hasEntityPropertySetupper(String propertyName) {
        return _epsMap.containsKey(propertyName);
    }

    public void setupEntityProperty(String propertyName, Object entity, Object value) {
        findEps(_epsMap, propertyName).setup((Sample2Sample2Emp)entity, value);
    }
    
    public static class EpsId implements Eps<Sample2Sample2Emp> {
        public void setup(Sample2Sample2Emp e, Object v) { e.setId((java.lang.Integer)v); }
    }
    public static class EpsName implements Eps<Sample2Sample2Emp> {
        public void setup(Sample2Sample2Emp e, Object v) { e.setName((String)v); }
    }
    public static class EpsHireDate implements Eps<Sample2Sample2Emp> {
        public void setup(Sample2Sample2Emp e, Object v) { e.setHireDate((java.util.Date)v); }
    }
    public static class EpsDeptId implements Eps<Sample2Sample2Emp> {
        public void setup(Sample2Sample2Emp e, Object v) { e.setDeptId((java.lang.Integer)v); }
    }
    public static class EpsVersionNo implements Eps<Sample2Sample2Emp> {
        public void setup(Sample2Sample2Emp e, Object v) { e.setVersionNo((java.math.BigDecimal)v); }
    }
}
