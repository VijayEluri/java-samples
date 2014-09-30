package jp.co.np.p2netex.sample2.allcommon.dbmeta.hierarchy.basic;


import jp.co.np.p2netex.sample2.allcommon.dbmeta.hierarchy.Sample2HierarchySourceColumn;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.info.Sample2ColumnInfo;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample2HierarchySourceEntityColumn implements Sample2HierarchySourceColumn {

    protected Sample2ColumnInfo columnInfo;

    public Sample2HierarchySourceEntityColumn(Sample2ColumnInfo columnInfo) {
        this.columnInfo = columnInfo;
    }

    public String getColumnName() {
        return columnInfo.getColumnDbName();
    }

    public java.lang.reflect.Method findGetter() {
        return columnInfo.findGetter();
    }
}