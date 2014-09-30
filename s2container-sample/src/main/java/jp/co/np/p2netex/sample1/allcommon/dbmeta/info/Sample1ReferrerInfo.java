package jp.co.np.p2netex.sample1.allcommon.dbmeta.info;


import jp.co.np.p2netex.sample1.allcommon.dbmeta.Sample1DBMeta;

/**
 * The class of referrer information.
 * 
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample1ReferrerInfo implements Sample1RelationInfo {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected String referrerPropertyName;
    protected Sample1DBMeta localDBMeta;
    protected Sample1DBMeta referrerDBMeta;
    protected java.util.Map<Sample1ColumnInfo, Sample1ColumnInfo> localReferrerColumnInfoMap;
    protected java.util.Map<Sample1ColumnInfo, Sample1ColumnInfo> referrerLocalColumnInfoMap;
    protected boolean oneToOne;

    // ===================================================================================
    //                                                                              Finder
    //                                                                              ======
    public Sample1ColumnInfo findLocalByReferrer(String referrerColumnDbName) {
        final Sample1ColumnInfo keyColumnInfo = new Sample1ColumnInfo(referrerDBMeta, referrerColumnDbName);
        final Sample1ColumnInfo resultColumnInfo = (Sample1ColumnInfo)referrerLocalColumnInfoMap.get(keyColumnInfo);
        if (resultColumnInfo == null) {
            String msg = "Not found by referrerColumnDbName in referrerLocalColumnInfoMap:";
            msg = msg + " referrerColumnDbName=" + referrerColumnDbName + " referrerLocalColumnInfoMap=" + referrerLocalColumnInfoMap;
            throw new IllegalArgumentException(msg);
        }
        return resultColumnInfo;
    }

    public Sample1ColumnInfo findReferrerByLocal(String localColumnDbName) {
        final Sample1ColumnInfo keyColumnInfo = new Sample1ColumnInfo(localDBMeta, localColumnDbName);
        final Sample1ColumnInfo resultColumnInfo = (Sample1ColumnInfo)localReferrerColumnInfoMap.get(keyColumnInfo);
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

    public Sample1DBMeta getTargetDBMeta() {
        return getReferrerDBMeta();
    }

    public java.util.Map<Sample1ColumnInfo, Sample1ColumnInfo> getLocalTargetColumnInfoMap() {
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

    public Sample1DBMeta getLocalDBMeta() {
        return localDBMeta;
    }

    public void setLocalDBMeta(Sample1DBMeta localDBMeta) {
        this.localDBMeta = localDBMeta;
    }

    public Sample1DBMeta getReferrerDBMeta() {
        return referrerDBMeta;
    }

    public void setReferrerDBMeta(Sample1DBMeta referrerDBMeta) {
        this.referrerDBMeta = referrerDBMeta;
    }

    public java.util.Map<Sample1ColumnInfo, Sample1ColumnInfo> getLocalReferrerColumnInfoMap() {
        return localReferrerColumnInfoMap;
    }

    public void setLocalReferrerColumnInfoMap(java.util.Map<Sample1ColumnInfo, Sample1ColumnInfo> localReferrerColumnInfoMap) {
        this.localReferrerColumnInfoMap = localReferrerColumnInfoMap;
        final java.util.Set keySet = localReferrerColumnInfoMap.keySet();
        referrerLocalColumnInfoMap = new java.util.LinkedHashMap<Sample1ColumnInfo, Sample1ColumnInfo>();
        for (final java.util.Iterator ite = keySet.iterator(); ite.hasNext(); ) {
            final Sample1ColumnInfo key = (Sample1ColumnInfo)ite.next();
            final Sample1ColumnInfo value = (Sample1ColumnInfo)localReferrerColumnInfoMap.get(key);
            referrerLocalColumnInfoMap.put(value, key);
        }
    }

    public java.util.Map<Sample1ColumnInfo, Sample1ColumnInfo> getReferrerLocalColumnInfoMap() {
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
