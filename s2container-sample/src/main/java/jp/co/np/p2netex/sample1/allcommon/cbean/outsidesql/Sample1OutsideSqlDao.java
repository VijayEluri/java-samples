package jp.co.np.p2netex.sample1.allcommon.cbean.outsidesql;

import java.util.List;

import jp.co.np.p2netex.sample1.allcommon.Sample1DaoReadable;
import jp.co.np.p2netex.sample1.allcommon.jdbc.Sample1CursorHandler;

/**
 * The dao of outside-sql.
 * @author DBFlute(AutoGenerator)
 */
public interface Sample1OutsideSqlDao extends Sample1DaoReadable {

    // ===================================================================================
    //                                                                              Select
    //                                                                              ======
    <ENTITY> List<ENTITY> selectList(String path, Object pmb, Sample1OutsideSqlOption option, Class<ENTITY> entityType);

    <ENTITY> Object selectCursor(String path, Object pmb, Sample1OutsideSqlOption option, Sample1CursorHandler handler);

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    int execute(String path, Object pmb, Sample1OutsideSqlOption option);

    // [DBFlute-0.7.5]
    // ===================================================================================
    //                                                                                Call
    //                                                                                ====
    void call(String path, Object pmb, Sample1OutsideSqlOption option);
}
