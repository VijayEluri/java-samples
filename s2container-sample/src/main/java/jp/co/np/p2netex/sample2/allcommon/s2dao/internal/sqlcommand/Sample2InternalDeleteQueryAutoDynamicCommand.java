package jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlcommand;

import javax.sql.DataSource;

import org.seasar.extension.jdbc.StatementFactory;
import org.seasar.dao.CommandContext;
import org.seasar.dao.Node;
import org.seasar.dao.SqlCommand;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2ConditionBean;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlhandler.Sample2InternalCommandContextHandler;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlparser.Sample2InternalCommandContextCreator;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlparser.Sample2InternalSqlParser;
import jp.co.np.p2netex.sample2.allcommon.util.Sample2SimpleSystemUtil;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample2InternalDeleteQueryAutoDynamicCommand implements SqlCommand  {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected DataSource dataSource;
    protected StatementFactory statementFactory;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample2InternalDeleteQueryAutoDynamicCommand(DataSource dataSource, StatementFactory statementFactory) {
        this.dataSource = dataSource;
        this.statementFactory = statementFactory;
    }

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    public Object execute(Object[] args) {
        Sample2ConditionBean cb = extractConditionBeanWithCheck(args);
        String[] argNames = new String[]{"dto"};
        Class<?>[] argTypes = new Class<?>[]{cb.getClass()};
        String twoWaySql = buildQueryDeleteTwoWaySql(cb);
        CommandContext context = createCommandContext(twoWaySql, argNames, argTypes, args);
        Sample2InternalCommandContextHandler handler = createCommandContextHandler(context);
        int rows = handler.execute(args);
        return new Integer(rows);
    }
    
    protected Sample2ConditionBean extractConditionBeanWithCheck(Object[] args) {
        if (args == null || args.length == 0) {
            String msg = "The arguments should have one argument! But:";
            msg = msg + " args=" + (args != null ? args.length : null);
            throw new IllegalArgumentException(msg);
        }
        Object fisrtArg = args[0];
        if (!(fisrtArg instanceof Sample2ConditionBean)) {
            String msg = "The type of argument should be " + Sample2ConditionBean.class + "! But:";
            msg = msg + " type=" + fisrtArg.getClass();
            throw new IllegalArgumentException(msg);
        }
        return (Sample2ConditionBean) fisrtArg;
    }
    
    protected Sample2InternalCommandContextHandler createCommandContextHandler(CommandContext context) {
        return new Sample2InternalCommandContextHandler(dataSource, statementFactory, context);
    }

    protected String buildQueryDeleteTwoWaySql(Sample2ConditionBean cb) {
        return cb.getSqlClause().getClauseQueryDelete();
    }
    
    protected CommandContext createCommandContext(String twoWaySql, String[] argNames, Class<?>[] argTypes, Object[] args) {
        CommandContext context;
        {
            Sample2InternalSqlParser parser = new Sample2InternalSqlParser(twoWaySql);
            Node node = parser.parse();
            Sample2InternalCommandContextCreator creator = new Sample2InternalCommandContextCreator(argNames, argTypes);
            context = creator.createCommandContext(args);
            node.accept(context);
        }
        return context;
    }
	
    // ===================================================================================
    //                                                                      General Helper
    //                                                                      ==============
    protected String getLineSeparator() {
        return Sample2SimpleSystemUtil.getLineSeparator();
    }
}
