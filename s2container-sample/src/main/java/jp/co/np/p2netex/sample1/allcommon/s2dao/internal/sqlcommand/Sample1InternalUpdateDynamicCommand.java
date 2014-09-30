package jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlcommand;

import javax.sql.DataSource;
import org.seasar.dao.CommandContext;
import org.seasar.extension.jdbc.StatementFactory;

import jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlhandler.Sample1InternalBasicUpdateHandler;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample1InternalUpdateDynamicCommand extends Sample1InternalAbstractDynamicCommand {

	// ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
	public Sample1InternalUpdateDynamicCommand(DataSource dataSource, StatementFactory statementFactory) {
		super(dataSource, statementFactory);
	}

	// ===================================================================================
    //                                                                             Execute
    //                                                                             =======
	public Object execute(Object args[]) {
		final CommandContext ctx = apply(args);
		final Sample1InternalBasicUpdateHandler updateHandler = new Sample1InternalBasicUpdateHandler(getDataSource(), ctx.getSql(), getStatementFactory());
		return new Integer(updateHandler.execute(ctx.getBindVariables(), ctx.getBindVariableTypes()));
	}
}
