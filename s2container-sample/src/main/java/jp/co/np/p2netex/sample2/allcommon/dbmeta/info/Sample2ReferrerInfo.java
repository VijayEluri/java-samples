package jp.co.np.p2netex.sample2.allcommon.dbmeta.info;


import jp.co.np.p2netex.sample2.allcommon.dbmeta.Sample2DBMeta;

/**
 * The class of referrer information.
 * 
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample2ReferrerInfo implements Sample2RelationInfo {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected String referrerPropertyName;
    protected Sample2DBMeta localDBMeta;
    protected Sample2DBMeta referrerDBMeta;
    protected java.util.Map<Sample2ColumnInfo, Sample2ColumnInfo> localReferrerColumnInfoMap;
    protected java.util.Map<Sample2ColumnInfo, Sample2ColumnInfo> referrerLocalColumnInfoMap;
    protected boolean oneToOne;

    // ===================================================================================
    //                                                                              Finder
    //                                                                              ======
    public Sample2ColumnInfo findLocalByReferrer(String referrerColumnDbName) {
        final Sample2ColumnInfo keyColumnInfo = new Sample2ColumnInfo(referrerDBMeta, referrerColumnDbName);
        final Sample2ColumnInfo resultColumnInfo = (Sample2ColumnInfo)referrerLocalColumnInfoMap.get(keyColumnInfo);
        if (resultColumnInfo == null) {
            String msg = "Not found by referrerColumnDbName in referrerLocalColumnInfoMap:";
            msg = msg + " referrerColumnDbName=" + referrerColumnDbName + " referrerLocalColumnInfoMap=" + referrerLocalColumnInfoMap;
            throw new IllegalArgumentException(msg);
        }
        return resultColumnInfo;
    }

    public Sample2ColumnInfo findReferrerByLocal(String localColumnDbName) {
        final Sample2ColumnInfo keyColumnInfo = new Sample2ColumnInfo(localDBMeta, localColumnDbName);
        final Sample2ColumnInfo resultColumnInfo = (Sample2ColumnInfo)localReferrerColumnInfoMap.get(keyColumnInfo);
        if (resultColumnInfo == null) {
            String msg = "Not found by localColumnDbName in localReferrerColumnInfoMap:";
            msg = msg + " localColumnDbName=" + localColumnDbName + " localReferrerColumnInfoMap=" + localReferrerColumnInfoMap;
            throw new IllegalArgumentException(msg);
        }
        return resultColumnInfo;
    }

    // ===================================================================================
    //                                                                             Builder
    //                                                                             =======
    public String buildInitCapPropertyName() {
        return initCap(this.referrerPropertyName);
    }

    // ===================================================================================
    //                                                                              Finder
    //                                                                              ======
    public java.lang.reflect.Method findSetter() {
        return findMethod(localDBMeta.getEntityType(), "set" + buildInitCapPropertyName(), new Class[] { java.util.List.class });
    }

    public java.lang.reflect.Method findGetter() {
        return findMethod(localDBMeta.getEntityType(), "get" + buildInitCapPropertyName(), new Class[] {});
    }

    // ===================================================================================
    //                                                                           Implement
    //                                                                           =========
    public String getRelationPropertyName() {
        return getReferrerPropertyName();
    }

    public Sample2DBMeta getTargetDBMeta() {
        return getReferrerDBMeta();
    }

    public java.util.Map<Sample2ColumnInfo, Sample2ColumnInfo> getLocalTargetColumnInfoMap() {
        return getLocalReferrerColumnInfoMap();
    }

    public boolean isReferrer() {
        return true;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public String getReferrerPropertyName() {
        return referrerPropertyName;
    }

    public void setReferrerPropertyName(String referrerPropertyName) {
        this.referrerPropertyName = referrerPropertyName;
    }

    public Sample2DBMeta getLocalDBMeta() {
        return localDBMeta;
    }

    public void setLocalDBMeta(Sample2DBMeta localDBMeta) {
        this.localDBMeta = localDBMeta;
    }

    public Sample2DBMeta getReferrerDBMeta() {
        return referrerDBMeta;
    }

    public void setReferrerDBMeta(Sample2DBMeta referrerDBMeta) {
        this.referrerDBMeta = referrerDBMeta;
    }

    public java.util.Map<Sample2ColumnInfo, Sample2ColumnInfo> getLocalReferrerColumnInfoMap() {
        return localReferrerColumnInfoMap;
    }

    public void setLocalReferrerColumnInfoMap(java.util.Map<Sample2ColumnInfo, Sample2ColumnInfo> localReferrerColumnInfoMap) {
        this.localReferrerColumnInfoMap = localReferrerColumnInfoMap;
        final java.util.Set keySet = localReferrerColumnInfoMap.keySet();
        referrerLocalColumnInfoMap = new java.util.LinkedHashMap<Sample2ColumnInfo, Sample2ColumnInfo>();
        for (final java.util.Iterator ite = keySet.iterator(); ite.hasNext(); ) {
            final Sample2ColumnInfo key = (Sample2ColumnInfo)ite.next();
            final Sample2ColumnInfo value = (Sample2ColumnInfo)localReferrerColumnInfoMap.get(key);
            referrerLocalColumnInfoMap.put(value, key);
        }
    }

    public java.util.Map<Sample2ColumnInfo, Sample2ColumnInfo> getReferrerLocalColumnInfoMap() {
        return referrerLocalColumnInfoMap;
    }

    public boolean isOneToOne() {
        return oneToOne;
    }

    public void setOneToOne(boolean oneToOne) {
        this.oneToOne = oneToOne;
    }

    // ===================================================================================
    //                                                                     Internal Helper
    //                                                                     ===============
    protected String initCap(final String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    protected java.lang.reflect.Method findMethod(Class clazz, String methodName, Class[] argTypes) {
        try {
            return clazz.getMethod(methodName, argTypes);
        } catch (NoSuchMethodException ex) {
            String msg = "class=" + clazz + " method=" + methodName + "-" + java.util.Arrays.asList(argTypes);
            throw new RuntimeException(msg, ex);
        }
    }
}
