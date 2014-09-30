package jp.co.np.p2netex.sample1.allcommon.dbmeta.hierarchy.basic;


import jp.co.np.p2netex.sample1.allcommon.dbmeta.hierarchy.Sample1HierarchySourceColumn;
import jp.co.np.p2netex.sample1.allcommon.dbmeta.info.Sample1ColumnInfo;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample1HierarchySourceEntityColumn implements Sample1HierarchySourceColumn {

    protected Sample1ColumnInfo columnInfo;

    public Sample1HierarchySourceEntityColumn(Sample1ColumnInfo columnInfo) {
        this.columnInfo = columnInfo;
    }

    public String getColumnName() {
        return columnInfo.getColumnDbName();
    }

    public java.lang.reflect.Method findGetter() {
        return columnInfo.findGetter();
    }
}