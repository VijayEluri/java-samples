package jp.co.np.p2netex.sample1.allcommon.dbmeta.info;


import jp.co.np.p2netex.sample1.allcommon.dbmeta.Sample1DBMeta;

/**
 * The class of unique info.
 * 
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample1UniqueInfo {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected Sample1DBMeta dbmeta;
    protected java.util.List<Sample1ColumnInfo> uniqueColumnList = new java.util.ArrayList<Sample1ColumnInfo>();
    protected boolean primary;

    // ===================================================================================
    //                                                                         Easy-to-Use
    //                                                                         ===========
    public boolean containsColumn(String columnName) {
        for (final java.util.Iterator ite = uniqueColumnList.iterator(); ite.hasNext(); ) {
            final Sample1ColumnInfo columnInfo = (Sample1ColumnInfo)ite.next();
            if (columnInfo.getColumnDbName().equals(columnName)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsColumn(Sample1ColumnInfo column) {
        return containsColumn(column.getColumnDbName());
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public Sample1DBMeta getDBMeta() {
        return dbmeta;
    }

    public void setDBMeta(Sample1DBMeta dbmeta) {
        this.dbmeta = dbmeta;
    }

    public java.util.List<Sample1ColumnInfo> getUniqueColumnList() {
        return uniqueColumnList;
    }

    public void addUniqueColumnList(Sample1ColumnInfo uniqueColumn) {
        this.uniqueColumnList.add(uniqueColumn);
    }

    public Sample1ColumnInfo getFirstColumn() {
        return (Sample1ColumnInfo)this.uniqueColumnList.get(0);
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
