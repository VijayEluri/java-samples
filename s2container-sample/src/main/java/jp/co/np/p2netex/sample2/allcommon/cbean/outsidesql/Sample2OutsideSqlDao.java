package jp.co.np.p2netex.sample2.allcommon.cbean.outsidesql;

import java.util.List;

import jp.co.np.p2netex.sample2.allcommon.Sample2DaoReadable;
import jp.co.np.p2netex.sample2.allcommon.jdbc.Sample2CursorHandler;

/**
 * The dao of outside-sql.
 * @author DBFlute(AutoGenerator)
 */
public interface Sample2OutsideSqlDao extends Sample2DaoReadable {

    // ===================================================================================
    //                                                                              Select
    //                                                                              ======
    <ENTITY> List<ENTITY> selectList(String path, Object pmb, Sample2OutsideSqlOption option, Class<ENTITY> entityType);

    <ENTITY> Object selectCursor(String path, Object pmb, Sample2OutsideSqlOption option, Sample2CursorHandler handler);

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    int execute(String path, Object pmb, Sample2OutsideSqlOption option);

    // [DBFlute-0.7.5]
    // ===================================================================================
    //                                                                                Call
    //                                                                                ====
    void call(String path, Object pmb, Sample2OutsideSqlOption option);
}
