package jp.co.np.p2netex.sample2.allcommon.dbmeta;

import java.util.Collections;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;

import jp.co.np.p2netex.sample2.allcommon.util.Sample2SimpleAssertUtil;

/**
 * DBMeta instance handler.
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample2DBMetaInstanceHandler {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Table DB-name instance map. */
    protected static final Map<String, Sample2DBMeta> _tableDbNameInstanceMap = new LinkedHashMap<String, Sample2DBMeta>();

    /** The map of table DB-name and class name. */
    protected static final Map<String, String> _tableDbNameClassNameMap;
    static {
        Map<String, String> tmpMap = new LinkedHashMap<String, String>();

        tmpMap.put("SAMPLE2_DEPT", "jp.co.np.p2netex.sample2.bsentity.dbmeta.Sample2Sample2DeptDbm");
        tmpMap.put("SAMPLE2_EMP", "jp.co.np.p2netex.sample2.bsentity.dbmeta.Sample2Sample2EmpDbm");

        _tableDbNameClassNameMap = Collections.unmodifiableMap(tmpMap);
    }

    /** The key-to-lower map of DB-name and property-name for table. */
    protected static final Map<String, String> _tableDbNamePropertyNameKeyToLowerMap;
    static {
        Map<String, String> tmpMap = new LinkedHashMap<String, String>();

        tmpMap.put("SAMPLE2_DEPT".toLowerCase(), "sample2Dept");
        tmpMap.put("SAMPLE2_EMP".toLowerCase(), "sample2Emp");

        _tableDbNamePropertyNameKeyToLowerMap = Collections.unmodifiableMap(tmpMap);
    }

    /** The key-to-lower map of property-name and DB-name for table. */
    protected static final Map<String, String> _tablePropertyNameDbNameKeyToLowerMap;
    static {
        Map<String, String> tmpMap = new LinkedHashMap<String, String>();

        tmpMap.put("sample2Dept".toLowerCase(), "SAMPLE2_DEPT");
        tmpMap.put("sample2Emp".toLowerCase(), "SAMPLE2_EMP");

        _tablePropertyNameDbNameKeyToLowerMap = Collections.unmodifiableMap(tmpMap);
    }

    protected static Sample2DBMeta getDBMeta(String className) {
        try {
            Class clazz = Class.forName(className);
            java.lang.reflect.Method methoz = clazz.getMethod("getInstance", (Class[])null);
            Object result = methoz.invoke(null, (Object[])null);
            return (Sample2DBMeta)result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return The initialized map that contains all instances of dbmeta. (NotNull & NotEmpty)
     */
    public static Map<String, Sample2DBMeta> getDBMetaMap() {
        initializeDBMetaMap();
        return _tableDbNameInstanceMap;
    }
    
    protected static void initializeDBMetaMap() {
        if (isInitialized()) {
            return;
        }
        final Set<String> tableDbNameSet = _tableDbNameClassNameMap.keySet();
        for (String tableDbName : tableDbNameSet) {
            findDBMeta(tableDbName); // Initialize!
        }
        if (!isInitialized()) {
            String msg = "Failed to initialize tableDbNameInstanceMap:";
            msg = msg + " tableDbNameInstanceMap=" + _tableDbNameInstanceMap;
            throw new IllegalStateException(msg);
        }
    }

    protected static boolean isInitialized() {
        return _tableDbNameInstanceMap.size() == _tableDbNameClassNameMap.size();
    }

    // ===================================================================================
    //                                                                         Main Method
    //                                                                         ===========
    /**
     * Find dbmeta by table flexible-name.
     * <pre>
     * If the table name is 'ORDER_DETAIL', you can find the dbmeta by ...(as follows)
     *     'ORDER_DETAIL', 'ORDer_DeTAiL', 'order_detail'
     *     , 'OrderDetail', 'orderdetail', 'oRderDetaIl'
     * </pre>
     * @param tableFlexibleName Table flexible-name. (NotNull)
     * @return Instance. (NotNull)
     */
    public static Sample2DBMeta findDBMeta(String tableFlexibleName) {
        assertStringNotNullAndNotTrimmedEmpty("tableFlexibleName", tableFlexibleName);
        if (_tableDbNameInstanceMap.containsKey(tableFlexibleName)) {
            return byTableDbName(tableFlexibleName);
        }
        String toLowerKey = tableFlexibleName.toLowerCase();
        if (_tableDbNamePropertyNameKeyToLowerMap.containsKey(toLowerKey)) {
            String propertyName = (String)_tableDbNamePropertyNameKeyToLowerMap.get(toLowerKey);
            String dbName = (String)_tablePropertyNameDbNameKeyToLowerMap.get(propertyName.toLowerCase());
            return byTableDbName(dbName);
        }
        if (_tablePropertyNameDbNameKeyToLowerMap.containsKey(toLowerKey)) {
            String dbName = (String)_tablePropertyNameDbNameKeyToLowerMap.get(toLowerKey);
            return byTableDbName(dbName);
        }
        final int dotLastIndex = tableFlexibleName.lastIndexOf(".");
        if (dotLastIndex >= 0) {
            try {
                return findDBMeta(tableFlexibleName.substring(dotLastIndex + 1));
            } catch (IllegalStateException e) {
                // Nothing
            }
        }
        String msg = "The instance map returned null by the key: key=" + tableFlexibleName + " instanceMap=" + _tableDbNameInstanceMap;
        throw new IllegalStateException(msg);
    }

    /**
     * Get instance by table DB-name.
     * @param tableDbName Table DB-name. (NotNull)
     * @return Instance. (NotNull)
     */
    protected static Sample2DBMeta byTableDbName(String tableDbName) {
        assertStringNotNullAndNotTrimmedEmpty("tableDbName", tableDbName);
        Sample2DBMeta instance = getCachedDBMeta(tableDbName);
        if (instance == null) {
            String msg = "The instance map returned null by the key: key=" + tableDbName + " instanceMap=" + _tableDbNameInstanceMap;
            throw new IllegalStateException(msg);
        }
        return instance;
    }
    
    protected static Sample2DBMeta getCachedDBMeta(String tableName) {// For lazy-load! Thank you koyak!
        if (_tableDbNameInstanceMap.containsKey(tableName)) {
            return _tableDbNameInstanceMap.get(tableName);
        }
        synchronized (_tableDbNameInstanceMap) {
            if (_tableDbNameInstanceMap.containsKey(tableName)) {
                return _tableDbNameInstanceMap.get(tableName);
            }
            String entityName = _tableDbNameClassNameMap.get(tableName);
            _tableDbNameInstanceMap.put(tableName, getDBMeta(entityName));
        }
        return _tableDbNameInstanceMap.get(tableName);
    }

    // ===================================================================================
    //                                                                      General Helper
    //                                                                      ==============
    // -----------------------------------------------------
    //                                         Assert Object
    //                                         -------------
    protected static void assertObjectNotNull(String variableName, Object value) {
	    Sample2SimpleAssertUtil.assertObjectNotNull(variableName, value);
    }

    // -----------------------------------------------------
    //                                         Assert String
    //                                         -------------
    protected static void assertStringNotNullAndNotTrimmedEmpty(String variableName, String value) {
	    Sample2SimpleAssertUtil.assertStringNotNullAndNotTrimmedEmpty(variableName, value);
    }
}
