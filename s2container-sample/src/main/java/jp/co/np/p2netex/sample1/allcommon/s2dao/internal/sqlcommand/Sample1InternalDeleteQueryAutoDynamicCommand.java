package jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlcommand;

import javax.sql.DataSource;

import org.seasar.extension.jdbc.StatementFactory;
import org.seasar.dao.CommandContext;
import org.seasar.dao.Node;
import org.seasar.dao.SqlCommand;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1ConditionBean;
import jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlhandler.Sample1InternalCommandContextHandler;
import jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlparser.Sample1InternalCommandContextCreator;
import jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlparser.Sample1InternalSqlParser;
import jp.co.np.p2netex.sample1.allcommon.util.Sample1SimpleSystemUtil;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample1InternalDeleteQueryAutoDynamicCommand implements SqlCommand  {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected DataSource dataSource;
    protected StatementFactory statementFactory;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample1InternalDeleteQueryAutoDynamicCommand(DataSource dataSource, StatementFactory statementFactory) {
        this.dataSource = dataSource;
        this.statementFactory = statementFactory;
    }

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    public Object execute(Object[] args) {
        Sample1ConditionBean cb = extractConditionBeanWithCheck(args);
        String[] argNames = new String[]{"dto"};
        Class<?>[] argTypes = new Class<?>[]{cb.getClass()};
        String twoWaySql = buildQueryDeleteTwoWaySql(cb);
        CommandContext context = createCommandContext(twoWaySql, argNames, argTypes, args);
        Sample1InternalCommandContextHandler handler = createCommandContextHandler(context);
        int rows = handler.execute(args);
        return new Integer(rows);
    }
    
    protected Sample1ConditionBean extractConditionBeanWithCheck(Object[] args) {
        if (args == null || args.length == 0) {
            String msg = "The arguments should have one argument! But:";
            msg = msg + " args=" + (args != null ? args.length : null);
            throw new IllegalArgumentException(msg);
        }
        Object fisrtArg = args[0];
        if (!(fisrtArg instanceof Sample1ConditionBean)) {
            String msg = "The type of argument should be " + Sample1ConditionBean.class + "! But:";
            msg = msg + " type=" + fisrtArg.getClass();
            throw new IllegalArgumentException(msg);
        }
        return (Sample1ConditionBean) fisrtArg;
    }
    
    protected Sample1InternalCommandContextHandler createCommandContextHandler(CommandContext context) {
        return new Sample1InternalCommandContextHandler(dataSource, statementFactory, context);
    }

    protected String buildQueryDeleteTwoWaySql(Sample1ConditionBean cb) {
        return cb.getSqlClause().getClauseQueryDelete();
    }
    
    protected CommandContext createCommandContext(String twoWaySql, String[] argNames, Class<?>[] argTypes, Object[] args) {
        CommandContext context;
        {
            Sample1InternalSqlParser parser = new Sample1InternalSqlParser(twoWaySql);
            Node node = parser.parse();
            Sample1InternalCommandContextCreator creator = new Sample1InternalCommandContextCreator(argNames, argTypes);
            context = creator.createCommandContext(args);
            node.accept(context);
        }
        return context;
    }
	
    // ===================================================================================
    //                                                                      General Helper
    //                                                                      ==============
    protected String getLineSeparator() {
        return Sample1SimpleSystemUtil.getLineSeparator();
    }
}
