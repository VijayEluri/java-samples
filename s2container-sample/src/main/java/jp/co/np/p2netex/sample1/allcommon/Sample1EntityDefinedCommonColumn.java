package jp.co.np.p2netex.sample1.allcommon;

/**
 * The interface of entity defined common column.
 * @author DBFlute(AutoGenerator)
 */
public interface Sample1EntityDefinedCommonColumn extends Sample1Entity {

    /**
     * Get the value of createDate.
     * @return The value of createDate. (Nullable)
     */
    public java.sql.Timestamp getCreateDate();

    /**
     * Set the value of createDate.
     * @param createDate The value of createDate. (Nullable)
     */
    public void setCreateDate(java.sql.Timestamp createDate);
  
    /**
     * Get the value of createUserId.
     * @return The value of createUserId. (Nullable)
     */
    public java.lang.Long getCreateUserId();

    /**
     * Set the value of createUserId.
     * @param createUserId The value of createUserId. (Nullable)
     */
    public void setCreateUserId(java.lang.Long createUserId);
  
    /**
     * Get the value of updateDate.
     * @return The value of updateDate. (Nullable)
     */
    public java.sql.Timestamp getUpdateDate();

    /**
     * Set the value of updateDate.
     * @param updateDate The value of updateDate. (Nullable)
     */
    public void setUpdateDate(java.sql.Timestamp updateDate);
  
    /**
     * Get the value of updateUserId.
     * @return The value of updateUserId. (Nullable)
     */
    public java.lang.Long getUpdateUserId();

    /**
     * Set the value of updateUserId.
     * @param updateUserId The value of updateUserId. (Nullable)
     */
    public void setUpdateUserId(java.lang.Long updateUserId);
  
    /**
	 * Disable common column auto set up.
	 */
    public void disableCommonColumnAutoSetup();
	
    /**
	 * Can the entity set up common column by auto?
	 * @return Determination.
	 */
	public boolean canCommonColumnAutoSetup();
}
