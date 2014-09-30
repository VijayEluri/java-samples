package jp.co.np.p2netex.sample1.allcommon.dbmeta.info;


import jp.co.np.p2netex.sample1.allcommon.dbmeta.Sample1DBMeta;

/**
 * The class of foreign information.
 * 
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample1ForeignInfo implements Sample1RelationInfo {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected String foreignPropertyName;
    protected Sample1DBMeta localDBMeta;
    protected Sample1DBMeta foreignDBMeta;
    protected java.util.Map<Sample1ColumnInfo, Sample1ColumnInfo> localForeignColumnInfoMap;
    protected java.util.Map<Sample1ColumnInfo, Sample1ColumnInfo> foreignLocalColumnInfoMap;
    protected int relationNo;
    protected boolean oneToOne;

    // ===================================================================================
    //                                                                              Finder
    //                                                                              ======
    public Sample1ColumnInfo findLocalByForeign(String foreignColumnDbName) {
        final Sample1ColumnInfo keyColumnInfo = new Sample1ColumnInfo(foreignDBMeta, foreignColumnDbName);
        final Sample1ColumnInfo resultColumnInfo = (Sample1ColumnInfo)foreignLocalColumnInfoMap.get(keyColumnInfo);
        if (resultColumnInfo == null) {
            String msg = "Not found by foreignColumnDbName in foreignLocalColumnInfoMap:";
            msg = msg + " foreignColumnDbName=" + foreignColumnDbName + " foreignLocalColumnInfoMap=" + foreignLocalColumnInfoMap;
            throw new IllegalArgumentException(msg);
        }
        return resultColumnInfo;
    }

    // ===================================================================================
    //                                                                             Builder
    //                                                                             =======
    public String buildInitCapPropertyName() {
        return initCap(this.foreignPropertyName);
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
        return getForeignPropertyName();
    }

    public Sample1DBMeta getTargetDBMeta() {
        return getForeignDBMeta();
    }

    public java.util.Map<Sample1ColumnInfo, Sample1ColumnInfo> getLocalTargetColumnInfoMap() {
        return getLocalForeignColumnInfoMap();
    }

    public boolean isReferrer() {
        return false;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public String getForeignPropertyName() {
        return foreignPropertyName;
    }

    public void setForeignPropertyName(String foreignPropertyName) {
        this.foreignPropertyName = foreignPropertyName;
    }

    public Sample1DBMeta getLocalDBMeta() {
        return localDBMeta;
    }

    public void setLocalDBMeta(Sample1DBMeta localDBMeta) {
        this.localDBMeta = localDBMeta;
    }

    public Sample1DBMeta getForeignDBMeta() {
        return foreignDBMeta;
    }

    public void setForeignDBMeta(Sample1DBMeta foreignDBMeta) {
        this.foreignDBMeta = foreignDBMeta;
    }

    public java.util.Map<Sample1ColumnInfo, Sample1ColumnInfo> getLocalForeignColumnInfoMap() {
        return localForeignColumnInfoMap;
    }

    public void setLocalForeignColumnInfoMap(java.util.Map<Sample1ColumnInfo, Sample1ColumnInfo> localForeignColumnInfoMap) {
        this.localForeignColumnInfoMap = localForeignColumnInfoMap;
        final java.util.Set keySet = localForeignColumnInfoMap.keySet();
        foreignLocalColumnInfoMap = new java.util.LinkedHashMap<Sample1ColumnInfo, Sample1ColumnInfo>();
        for (final java.util.Iterator ite = keySet.iterator(); ite.hasNext(); ) {
            final Sample1ColumnInfo key = (Sample1ColumnInfo)ite.next();
            final Sample1ColumnInfo value = (Sample1ColumnInfo)localForeignColumnInfoMap.get(key);
            foreignLocalColumnInfoMap.put(value, key);
        }
    }

    public java.util.Map<Sample1ColumnInfo, Sample1ColumnInfo> getForeignLocalColumnInfoMap() {
        return foreignLocalColumnInfoMap;
    }

    public int getRelationNo() {
        return relationNo;
    }

    public void setRelationNo(int relationNo) {
        this.relationNo = relationNo;
    }

    public boolean isOneToOne() {
        return oneToOne;
    }

    public void setOneToOne(boolean oneToOne) {
        this.oneToOne = oneToOne;
    }

    // ===================================================================================
    //                                                                      General Helper
    //                                                                      ==============
    protected java.lang.reflect.Method findMethod(Class clazz, String methodName, Class[] argTypes) {
        try {
            return clazz.getMethod(methodName, argTypes);
        } catch (NoSuchMethodException ex) {
            String msg = "class=" + clazz + " method=" + methodName + "-" + java.util.Arrays.asList(argTypes);
            throw new RuntimeException(msg, ex);
        }
    }
	
    protected String initCap(final String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
