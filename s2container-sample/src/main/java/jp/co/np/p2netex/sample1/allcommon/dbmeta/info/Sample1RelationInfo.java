package jp.co.np.p2netex.sample1.allcommon.dbmeta.info;


import jp.co.np.p2netex.sample1.allcommon.dbmeta.Sample1DBMeta;

/**
 * The class of referer information.
 * 
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public interface Sample1RelationInfo {

    public String getRelationPropertyName();

    public Sample1DBMeta getLocalDBMeta();

    public Sample1DBMeta getTargetDBMeta();

    public java.util.Map<Sample1ColumnInfo, Sample1ColumnInfo> getLocalTargetColumnInfoMap();

    public boolean isOneToOne();

    public boolean isReferrer();
}
