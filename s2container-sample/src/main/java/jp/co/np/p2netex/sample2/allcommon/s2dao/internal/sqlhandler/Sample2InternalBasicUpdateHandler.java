package jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlhandler;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.seasar.extension.jdbc.StatementFactory;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample2InternalBasicUpdateHandler extends Sample2InternalBasicHandler {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample2InternalBasicUpdateHandler(DataSource dataSource, String sql, StatementFactory statementFactory) {
        super(dataSource, sql, statementFactory);
    }

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    public int execute(Object[] args) {
        return execute(args, getArgTypes(args));
    }

    @SuppressWarnings("unchecked")
    public int execute(Object[] args, Class[] argTypes) {
        Connection connection = getConnection();
        try {
            return execute(connection, args, argTypes);
        } finally {
            close(connection);
        }
    }

    @SuppressWarnings("unchecked")
    public int execute(Connection connection, Object[] args, Class[] argTypes) {
        logSql(args, argTypes);
        PreparedStatement ps = prepareStatement(connection);
        try {
            bindArgs(ps, args, argTypes);
            return executeUpdate(ps, args);
        } finally {
            close(ps);
        }
    }
}
