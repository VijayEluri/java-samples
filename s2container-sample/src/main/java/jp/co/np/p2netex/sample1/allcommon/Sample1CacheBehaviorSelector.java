package jp.co.np.p2netex.sample1.allcommon;

import java.util.Collection;
import java.util.Map;
import java.util.LinkedHashMap;

import jp.co.np.p2netex.sample1.allcommon.Sample1DaoReadable;
import jp.co.np.p2netex.sample1.allcommon.bhv.Sample1BehaviorReadable;
import jp.co.np.p2netex.sample1.allcommon.dbmeta.Sample1DBMeta;
import jp.co.np.p2netex.sample1.allcommon.dbmeta.Sample1DBMetaInstanceHandler;
import jp.co.np.p2netex.sample1.allcommon.util.Sample1TraceViewUtil;

/**
 * The implementation of behavior-selector.
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample1CacheBehaviorSelector extends Sample1CacheAbstractSelector implements Sample1BehaviorSelector {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Log-instance. */
    private static final org.apache.commons.logging.Log _log = org.apache.commons.logging.LogFactory.getLog(Sample1CacheBehaviorSelector.class);

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The cache of behavior. (It's the generic hell!) */
    protected Map<Class<? extends Sample1BehaviorReadable>, Sample1BehaviorReadable> _behaviorCache = new LinkedHashMap<Class<? extends Sample1BehaviorReadable>, Sample1BehaviorReadable>();

    // ===================================================================================
    //                                                                          Initialize
    //                                                                          ==========
    /**
     * Initialize condition-bean meta data. <br />
	 * If you call this, Hot Deploy of OutsideSql becomes Cool!
     */
    public void initializeConditionBeanMetaData() {
        final Map<String, Sample1DBMeta> dbmetaMap = Sample1DBMetaInstanceHandler.getDBMetaMap();
        final Collection<Sample1DBMeta> dbmetas = dbmetaMap.values();
        long before = 0;
	    if (_log.isInfoEnabled()) {
		    before = System.currentTimeMillis();
		    _log.info("/= = = = = = = = = = = = = = = = = initializeConditionBeanMetaData()");
		}
        for (Sample1DBMeta dbmeta : dbmetas) {
		    final Sample1BehaviorReadable bhv = byName(dbmeta.getTableDbName());
            final Sample1DaoReadable dao = bhv.getDaoReadable();
			dao.initializeDaoMetaData("selectList");
        }
	    if (_log.isInfoEnabled()) {
		    long after = System.currentTimeMillis();
		    _log.info("Initialized Count: " + dbmetas.size());
		    _log.info("= = = = = = = = = =/ [" + Sample1TraceViewUtil.convertToPerformanceView(after - before) + "]");
		}
	}
	
    // ===================================================================================
    //                                                                            Selector
    //                                                                            ========
    /**
     * Select behavior.
     * @param <BEHAVIOR> The type of behavior.
     * @param behaviorType Behavior type. (NotNull)
     * @return Behavior. (NotNull)
     */
    public <BEHAVIOR extends Sample1BehaviorReadable> BEHAVIOR select(Class<BEHAVIOR> behaviorType) {
        if (_behaviorCache.containsKey(behaviorType)) {
            return (BEHAVIOR)_behaviorCache.get(behaviorType);
        }
        synchronized (_behaviorCache) {
            if (_behaviorCache.containsKey(behaviorType)) {
                return (BEHAVIOR)_behaviorCache.get(behaviorType);
            }
            final BEHAVIOR bhv = (BEHAVIOR)getComponent(behaviorType);
            _behaviorCache.put(behaviorType, bhv);
            return bhv;
        }
    }

    /**
     * Select behavior-readable by name.
     * @param tableFlexibleName Table flexible-name. (NotNull)
     * @return Behavior-readable. (NotNull)
     */
    public Sample1BehaviorReadable byName(String tableFlexibleName) {
        assertStringNotNullAndNotTrimmedEmpty("tableFlexibleName", tableFlexibleName);
        final Sample1DBMeta dbmeta = Sample1DBMetaInstanceHandler.findDBMeta(tableFlexibleName);
        return select(getBehaviorType(dbmeta));
    }

    /**
     * Get behavior-type by dbmeta.
     * @param dbmeta Dbmeta. (NotNull)
     * @return Behavior-type. (NotNull)
     */
    protected Class<Sample1BehaviorReadable> getBehaviorType(Sample1DBMeta dbmeta) {
        final String behaviorTypeName = dbmeta.getBehaviorTypeName();
        if (behaviorTypeName == null) {
            String msg = "The dbmeta.getBehaviorTypeName() should not return null: dbmeta=" + dbmeta;
            throw new IllegalStateException(msg);
        }
        final Class<Sample1BehaviorReadable> behaviorType;
        try {
            behaviorType = (Class<Sample1BehaviorReadable>)Class.forName(behaviorTypeName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("The class does not exist: " + behaviorTypeName, e);
        }
        return behaviorType;
    }
}
