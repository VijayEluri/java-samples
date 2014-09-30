package jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlcommand;

import javax.sql.DataSource;

import org.seasar.dao.SqlCommand;
import org.seasar.dao.ProcedureMetaData;
import org.seasar.extension.jdbc.ResultSetFactory;
import org.seasar.extension.jdbc.ResultSetHandler;
import org.seasar.extension.jdbc.StatementFactory;
import jp.co.np.p2netex.sample2.allcommon.cbean.outsidesql.Sample2OutsideSqlContext;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlhandler.Sample2InternalProcedureHandler;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample2InternalProcedureCommand implements SqlCommand {

	// ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected DataSource dataSource;
    protected ResultSetHandler resultSetHandler;
    protected StatementFactory statementFactory;
    protected ResultSetFactory resultSetFactory;
    protected ProcedureMetaData procedureMetaData;
	
	// ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample2InternalProcedureCommand(DataSource dataSource, ResultSetHandler resultSetHandler,
            StatementFactory statementFactory, ResultSetFactory resultSetFactory,
            ProcedureMetaData procedureMetaData) {
        this.dataSource = dataSource;
        this.resultSetHandler = resultSetHandler;
        this.statementFactory = statementFactory;
        this.resultSetFactory = resultSetFactory;
        this.procedureMetaData = procedureMetaData;
    }

	// ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    public Object execute(final Object[] args) {
        final Sample2InternalProcedureHandler handler = newArgumentDtoProcedureHandler();
        final Sample2OutsideSqlContext outsideSqlContext = Sample2OutsideSqlContext.getOutsideSqlContextOnThread();
        final Object pmb = outsideSqlContext.getParameterBean();

        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        // @jflute -- At the future, I'll implement the handling of several result sets.
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

        return handler.execute(new Object[]{pmb});
    }
    protected Sample2InternalProcedureHandler newArgumentDtoProcedureHandler() {
        return new Sample2InternalProcedureHandler(dataSource, createSql(procedureMetaData), resultSetHandler,
                statementFactory, resultSetFactory, procedureMetaData);
    }
    protected String createSql(final ProcedureMetaData procedureMetaData) {
        final StringBuilder sb = new StringBuilder();
        sb.append("{");
        int size = procedureMetaData.getParameterTypeSize();
        if (procedureMetaData.hasReturnParameterType()) {
            sb.append("? = ");
            size--;
        }
        sb.append("call ").append(procedureMetaData.getProcedureName()).append("(");
        for (int i = 0; i < size; i++) {
            sb.append("?, ");
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append(")}");
        return sb.toString();
    }
}
