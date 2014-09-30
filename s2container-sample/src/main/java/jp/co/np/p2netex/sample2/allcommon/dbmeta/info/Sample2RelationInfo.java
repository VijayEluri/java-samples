package jp.co.np.p2netex.sample2.allcommon.dbmeta.info;


import jp.co.np.p2netex.sample2.allcommon.dbmeta.Sample2DBMeta;

/**
 * The class of referer information.
 * 
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public interface Sample2RelationInfo {

    public String getRelationPropertyName();

    public Sample2DBMeta getLocalDBMeta();

    public Sample2DBMeta getTargetDBMeta();

    public java.util.Map<Sample2ColumnInfo, Sample2ColumnInfo> getLocalTargetColumnInfoMap();

    public boolean isOneToOne();

    public boolean isReferrer();
}
