package jp.co.np.p2netex.sample2.allcommon.dbmeta.hierarchy;


import java.util.List;

import jp.co.np.p2netex.sample2.allcommon.dbmeta.Sample2DBMeta;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.info.Sample2ColumnInfo;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.info.Sample2RelationInfo;

/**
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample2HierarchyRequestElement {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Top key. */
    public static final String TOP_KEY = "$top$";

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The column of source. */
    protected Sample2HierarchySourceColumn sourceColumn;

    /** The dbmeta of destination. */
    protected Sample2DBMeta destinationDBMeta;

    /** The column info of destination. */
    protected Sample2ColumnInfo destinationColumnInfo;

    /** The list of relation info. */
    protected java.util.List<Sample2RelationInfo> relationInfoList = new java.util.ArrayList<Sample2RelationInfo>();

    /** the list of relation property name. */
    protected java.util.List<String> relationPropertyNameList = new java.util.ArrayList<String>();

    /** Relation property key. Default value is TOP_KEY. */
    protected String relationPropertyKey = TOP_KEY;

    // ===================================================================================
    //                                                                         Easy-to-Use
    //                                                                         ===========
    // -----------------------------------------------------
    //                                              Internal
    //                                              --------
    /**
     * Make mapping between the source column and the destination one.
     * 
     * @param sourceColumn The column of source. (NotNull)
     * @param destinationColumnInfo The column info of destination. (NotNull)
     */
    public void mapping(Sample2HierarchySourceColumn sourceColumn, Sample2ColumnInfo destinationColumnInfo) {
        this.sourceColumn = sourceColumn;
        this.destinationColumnInfo = destinationColumnInfo;
    }

    /**
     * Make relatetion by relation info.
     * 
     * @param relationInfo Relation info. (NotNull)
     */
    public void relation(Sample2RelationInfo relationInfo) {
        addRelationInfoList(relationInfo);
    }

    protected void addRelationInfoList(Sample2RelationInfo relationInfo) {
        relationInfoList.add(relationInfo);
        addRelationPropertyNameList(relationInfo.getRelationPropertyName());
    }

    protected void addRelationPropertyNameList(String relationPropertyName) {
        relationPropertyNameList.add(relationPropertyName);
        setupRelationPropertyKey();
    }

    protected void setupRelationPropertyKey() {
        final StringBuilder sb = new StringBuilder();
        for (String relationPropertyName : relationPropertyNameList) {
            if (sb.length() > 0) {
                sb.append("_");
            }
            sb.append(relationPropertyName);
        }
        this.relationPropertyKey = sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public Sample2HierarchySourceColumn getSourceColumnInfo() {
        return sourceColumn;
    }

    public void setSourceColumnInfo(Sample2HierarchySourceColumn sourceColumn) {
        this.sourceColumn = sourceColumn;
    }

    public void setDestinationDBMeta(Sample2DBMeta destinationDBMeta) {
        this.destinationDBMeta = destinationDBMeta;
    }

    public Sample2DBMeta getDestinationDBMeta() {
        return destinationDBMeta;
    }

    public Sample2ColumnInfo getDestinationColumnInfo() {
        return destinationColumnInfo;
    }

    public java.util.List<Sample2RelationInfo> getRelationInfoList() {
        return relationInfoList;
    }

    public List<String> getRelationPropertyNameList() {
        return relationPropertyNameList;
    }

    public String getRelationPropertyKey() {
        return relationPropertyKey;
    }

    public String toString() {
        return sourceColumn + "," + destinationColumnInfo;
    }
}
