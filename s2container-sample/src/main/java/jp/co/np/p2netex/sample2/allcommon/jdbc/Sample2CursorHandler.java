package jp.co.np.p2netex.sample2.allcommon.jdbc;

/**
 * The interface of statement history witness.
 * @author DBFlute(AutoGenerator)
 */
public interface Sample2CursorHandler {

    /**
     * @param resultSet Result set. (NotNull)
     * @return Result
     * @throws java.sql.SQLException
     */
    Object handle(java.sql.ResultSet resultSet) throws java.sql.SQLException;
}
