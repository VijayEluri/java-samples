package jp.canetrash.sample.spring.dbflute2.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.seasar.dbflute.DBDef;
import org.seasar.dbflute.Entity;
import org.seasar.dbflute.dbmeta.AbstractDBMeta;
import org.seasar.dbflute.dbmeta.PropertyGateway;
import org.seasar.dbflute.dbmeta.info.*;
import org.seasar.dbflute.dbmeta.name.*;
import jp.canetrash.sample.spring.dbflute2.allcommon.*;
import jp.canetrash.sample.spring.dbflute2.exentity.*;

/**
 * The DB meta of users2. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class OtherUsers2Dbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final OtherUsers2Dbm _instance = new OtherUsers2Dbm();
    private OtherUsers2Dbm() {}
    public static OtherUsers2Dbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public DBDef getCurrentDBDef() { return OtherDBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    {
        setupEpg(_epgMap, new EpgId(), "id");
        setupEpg(_epgMap, new EpgName(), "name");
        setupEpg(_epgMap, new EpgHome(), "home");
    }
    public PropertyGateway findPropertyGateway(String propertyName)
    { return doFindEpg(_epgMap, propertyName); }
    public static class EpgId implements PropertyGateway {
        public Object read(Entity e) { return ((OtherUsers2)e).getId(); }
        public void write(Entity e, Object v) { ((OtherUsers2)e).setId(cti(v)); }
    }
    public static class EpgName implements PropertyGateway {
        public Object read(Entity e) { return ((OtherUsers2)e).getName(); }
        public void write(Entity e, Object v) { ((OtherUsers2)e).setName((String)v); }
    }
    public static class EpgHome implements PropertyGateway {
        public Object read(Entity e) { return ((OtherUsers2)e).getHome(); }
        public void write(Entity e, Object v) { ((OtherUsers2)e).setHome((String)v); }
    }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "users2";
    protected final String _tablePropertyName = "users2";
    protected final TableSqlName _tableSqlName = new TableSqlName("users2", _tableDbName);
    { _tableSqlName.xacceptFilter(OtherDBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnId = cci("id", "id", null, null, true, "id", Integer.class, true, false, "int4", 10, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnName = cci("name", "name", null, null, false, "name", String.class, false, false, "varchar", 30, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnHome = cci("home", "home", null, null, false, "home", String.class, false, false, "varchar", 30, 0, null, false, null, null, null, null, null);

    public ColumnInfo columnId() { return _columnId; }
    public ColumnInfo columnName() { return _columnName; }
    public ColumnInfo columnHome() { return _columnHome; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnId());
        ls.add(columnName());
        ls.add(columnHome());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnId()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "jp.canetrash.sample.spring.dbflute2.exentity.OtherUsers2"; }
    public String getConditionBeanTypeName() { return "jp.canetrash.sample.spring.dbflute2.cbean.OtherUsers2CB"; }
    public String getDaoTypeName() { return "${glPackageExtendedDao}.OtherUsers2Dao"; }
    public String getBehaviorTypeName() { return "jp.canetrash.sample.spring.dbflute2.exbhv.OtherUsers2Bhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<OtherUsers2> getEntityType() { return OtherUsers2.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Entity newEntity() { return newMyEntity(); }
    public OtherUsers2 newMyEntity() { return new OtherUsers2(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity e, Map<String, ? extends Object> m)
    { doAcceptPrimaryKeyMap((OtherUsers2)e, m); }
    public void acceptAllColumnMap(Entity e, Map<String, ? extends Object> m)
    { doAcceptAllColumnMap((OtherUsers2)e, m); }
    public Map<String, Object> extractPrimaryKeyMap(Entity e) { return doExtractPrimaryKeyMap(e); }
    public Map<String, Object> extractAllColumnMap(Entity e) { return doExtractAllColumnMap(e); }
}
