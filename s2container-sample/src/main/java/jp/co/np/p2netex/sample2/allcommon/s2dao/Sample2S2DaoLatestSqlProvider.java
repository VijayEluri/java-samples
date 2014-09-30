package jp.co.np.p2netex.sample2.allcommon.s2dao;

import jp.co.np.p2netex.sample2.allcommon.jdbc.Sample2LatestSqlProvider;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqllog.Sample2InternalSqlLogRegistry;

/**
 * The provider of latest SQL as S2Dao. <br />
 * This instance should be singleton. <br />
 * 
 * @author DBFlute(AutoGenerator)
 */
public class Sample2S2DaoLatestSqlProvider implements Sample2LatestSqlProvider {

    /**
     * The implementation.
     * 
     * @return Display SQL. (Nullable: If it was not found, returns null.)
     */
    public String getDisplaySql() {
        return getLastCompleteSql();
    }

    protected String getLastCompleteSql() {
        try {
            return Sample2InternalSqlLogRegistry.peekCompleteSql();
        } catch (RuntimeException ignored) {
            return null;
        }
    }
	
	public void clearSqlCache() {
	}
}
