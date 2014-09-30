package jp.co.np.p2netex.sample2.allcommon.dbmeta.info;


import jp.co.np.p2netex.sample2.allcommon.dbmeta.Sample2DBMeta;

/**
 * The class of unique info.
 * 
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample2UniqueInfo {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected Sample2DBMeta dbmeta;
    protected java.util.List<Sample2ColumnInfo> uniqueColumnList = new java.util.ArrayList<Sample2ColumnInfo>();
    protected boolean primary;

    // ===================================================================================
    //                                                                         Easy-to-Use
    //                                                                         ===========
    public boolean containsColumn(String columnName) {
        for (final java.util.Iterator ite = uniqueColumnList.iterator(); ite.hasNext(); ) {
            final Sample2ColumnInfo columnInfo = (Sample2ColumnInfo)ite.next();
            if (columnInfo.getColumnDbName().equals(columnName)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsColumn(Sample2ColumnInfo column) {
        return containsColumn(column.getColumnDbName());
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public Sample2DBMeta getDBMeta() {
        return dbmeta;
    }

    public void setDBMeta(Sample2DBMeta dbmeta) {
        this.dbmeta = dbmeta;
    }

    public java.util.List<Sample2ColumnInfo> getUniqueColumnList() {
        return uniqueColumnList;
    }

    public void addUniqueColumnList(Sample2ColumnInfo uniqueColumn) {
        this.uniqueColumnList.add(uniqueColumn);
    }

    public Sample2ColumnInfo getFirstColumn() {
        return (Sample2ColumnInfo)this.uniqueColumnList.get(0);
    }

    public boolean isTwoOrMore() {
        return this.uniqueColumnList.size() > 1;
    }

    public boolean isPrimary() {
        return this.primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }
}
