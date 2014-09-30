package jp.co.np.p2netex.sample2.allcommon;

import java.util.Collection;
import java.util.Map;
import java.util.LinkedHashMap;

import jp.co.np.p2netex.sample2.allcommon.Sample2DaoReadable;
import jp.co.np.p2netex.sample2.allcommon.bhv.Sample2BehaviorReadable;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.Sample2DBMeta;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.Sample2DBMetaInstanceHandler;
import jp.co.np.p2netex.sample2.allcommon.util.Sample2TraceViewUtil;

/**
 * The implementation of behavior-selector.
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample2CacheBehaviorSelector extends Sample2CacheAbstractSelector implements Sample2BehaviorSelector {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Log-instance. */
    private static final org.apache.commons.logging.Log _log = org.apache.commons.logging.LogFactory.getLog(Sample2CacheBehaviorSelector.class);

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The cache of behavior. (It's the generic hell!) */
    protected Map<Class<? extends Sample2BehaviorReadable>, Sample2BehaviorReadable> _behaviorCache = new LinkedHashMap<Class<? extends Sample2BehaviorReadable>, Sample2BehaviorReadable>();

    // ===================================================================================
    //                                                                          Initialize
    //                                                                          ==========
    /**
     * Initialize condition-bean meta data. <br />
	 * If you call this, Hot Deploy of OutsideSql becomes Cool!
     */
    public void initializeConditionBeanMetaData() {
        final Map<String, Sample2DBMeta> dbmetaMap = Sample2DBMetaInstanceHandler.getDBMetaMap();
        final Collection<Sample2DBMeta> dbmetas = dbmetaMap.values();
        long before = 0;
	    if (_log.isInfoEnabled()) {
		    before = System.currentTimeMillis();
		    _log.info("/= = = = = = = = = = = = = = = = = initializeConditionBeanMetaData()");
		}
        for (Sample2DBMeta dbmeta : dbmetas) {
		    final Sample2BehaviorReadable bhv = byName(dbmeta.getTableDbName());
            final Sample2DaoReadable dao = bhv.getDaoReadable();
			dao.initializeDaoMetaData("selectList");
        }
	    if (_log.isInfoEnabled()) {
		    long after = System.currentTimeMillis();
		    _log.info("Initialized Count: " + dbmetas.size());
		    _log.info("= = = = = = = = = =/ [" + Sample2TraceViewUtil.convertToPerformanceView(after - before) + "]");
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
    public <BEHAVIOR extends Sample2BehaviorReadable> BEHAVIOR select(Class<BEHAVIOR> behaviorType) {
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
    public Sample2BehaviorReadable byName(String tableFlexibleName) {
        assertStringNotNullAndNotTrimmedEmpty("tableFlexibleName", tableFlexibleName);
        final Sample2DBMeta dbmeta = Sample2DBMetaInstanceHandler.findDBMeta(tableFlexibleName);
        return select(getBehaviorType(dbmeta));
    }

    /**
     * Get behavior-type by dbmeta.
     * @param dbmeta Dbmeta. (NotNull)
     * @return Behavior-type. (NotNull)
     */
    protected Class<Sample2BehaviorReadable> getBehaviorType(Sample2DBMeta dbmeta) {
        final String behaviorTypeName = dbmeta.getBehaviorTypeName();
        if (behaviorTypeName == null) {
            String msg = "The dbmeta.getBehaviorTypeName() should not return null: dbmeta=" + dbmeta;
            throw new IllegalStateException(msg);
        }
        final Class<Sample2BehaviorReadable> behaviorType;
        try {
            behaviorType = (Class<Sample2BehaviorReadable>)Class.forName(behaviorTypeName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("The class does not exist: " + behaviorTypeName, e);
        }
        return behaviorType;
    }
}
