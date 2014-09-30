package jp.co.np.p2netex.sample1.allcommon.jdbc;

/**
 * The provider of latest SQL.
 * @author DBFlute(AutoGenerator)
 */
public interface Sample1LatestSqlProvider {

    /**
     * Get display SQL.
     * @return Display SQL. (Nullable: If it was not found, returns null.)
     */
    public String getDisplaySql();
	
	/**
	 * Clear the cache of SQL.
	 */
	public void clearSqlCache();
}
