package jp.co.np.p2netex.sample1.allcommon.s2dao;

import jp.co.np.p2netex.sample1.allcommon.jdbc.Sample1LatestSqlProvider;
import jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqllog.Sample1InternalSqlLogRegistry;

/**
 * The provider of latest SQL as S2Dao. <br />
 * This instance should be singleton. <br />
 * 
 * @author DBFlute(AutoGenerator)
 */
public class Sample1S2DaoLatestSqlProvider implements Sample1LatestSqlProvider {

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
            return Sample1InternalSqlLogRegistry.peekCompleteSql();
        } catch (RuntimeException ignored) {
            return null;
        }
    }
	
	public void clearSqlCache() {
	}
}
