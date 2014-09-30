package jp.co.np.p2netex.sample1.allcommon.dbmeta.hierarchy;


import java.util.List;

import jp.co.np.p2netex.sample1.allcommon.dbmeta.Sample1DBMeta;
import jp.co.np.p2netex.sample1.allcommon.dbmeta.info.Sample1ColumnInfo;
import jp.co.np.p2netex.sample1.allcommon.dbmeta.info.Sample1RelationInfo;

/**
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample1HierarchyRequestElement {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Top key. */
    public static final String TOP_KEY = "$top$";

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The column of source. */
    protected Sample1HierarchySourceColumn sourceColumn;

    /** The dbmeta of destination. */
    protected Sample1DBMeta destinationDBMeta;

    /** The column info of destination. */
    protected Sample1ColumnInfo destinationColumnInfo;

    /** The list of relation info. */
    protected java.util.List<Sample1RelationInfo> relationInfoList = new java.util.ArrayList<Sample1RelationInfo>();

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
    public void mapping(Sample1HierarchySourceColumn sourceColumn, Sample1ColumnInfo destinationColumnInfo) {
        this.sourceColumn = sourceColumn;
        this.destinationColumnInfo = destinationColumnInfo;
    }

    /**
     * Make relatetion by relation info.
     * 
     * @param relationInfo Relation info. (NotNull)
     */
    public void relation(Sample1RelationInfo relationInfo) {
        addRelationInfoList(relationInfo);
    }

    protected void addRelationInfoList(Sample1RelationInfo relationInfo) {
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
    public Sample1HierarchySourceColumn getSourceColumnInfo() {
        return sourceColumn;
    }

    public void setSourceColumnInfo(Sample1HierarchySourceColumn sourceColumn) {
        this.sourceColumn = sourceColumn;
    }

    public void setDestinationDBMeta(Sample1DBMeta destinationDBMeta) {
        this.destinationDBMeta = destinationDBMeta;
    }

    public Sample1DBMeta getDestinationDBMeta() {
        return destinationDBMeta;
    }

    public Sample1ColumnInfo getDestinationColumnInfo() {
        return destinationColumnInfo;
    }

    public java.util.List<Sample1RelationInfo> getRelationInfoList() {
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
