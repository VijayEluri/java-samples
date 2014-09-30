package jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlcommand;

import javax.sql.DataSource;
import org.seasar.dao.CommandContext;
import org.seasar.extension.jdbc.StatementFactory;

import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlhandler.Sample2InternalBasicUpdateHandler;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample2InternalUpdateDynamicCommand extends Sample2InternalAbstractDynamicCommand {

	// ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
	public Sample2InternalUpdateDynamicCommand(DataSource dataSource, StatementFactory statementFactory) {
		super(dataSource, statementFactory);
	}

	// ===================================================================================
    //                                                                             Execute
    //                                                                             =======
	public Object execute(Object args[]) {
		final CommandContext ctx = apply(args);
		final Sample2InternalBasicUpdateHandler updateHandler = new Sample2InternalBasicUpdateHandler(getDataSource(), ctx.getSql(), getStatementFactory());
		return new Integer(updateHandler.execute(ctx.getBindVariables(), ctx.getBindVariableTypes()));
	}
}
