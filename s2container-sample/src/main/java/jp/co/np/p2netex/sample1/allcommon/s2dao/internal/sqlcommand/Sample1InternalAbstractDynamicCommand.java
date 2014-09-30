package jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlcommand;

import javax.sql.DataSource;

import org.seasar.dao.CommandContext;
import org.seasar.dao.Node;
import org.seasar.extension.jdbc.StatementFactory;

import jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlparser.Sample1InternalCommandContextCreator;
import jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlparser.Sample1InternalSqlParser;

/**
 * @author DBFlute(AutoGenerator)
 */
public abstract class Sample1InternalAbstractDynamicCommand extends Sample1InternalAbstractSqlCommand {

	// ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected Node rootNode;
    protected String[] argNames = new String[0];
    protected Class<?>[] argTypes = new Class[0];

	// ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample1InternalAbstractDynamicCommand(DataSource dataSource, StatementFactory statementFactory) {
        super(dataSource, statementFactory);
    }

	// ===================================================================================
    //                                                                        Sql Handling
    //                                                                        ============
    public void setSql(String sql) {
        super.setSql(sql);
        this.rootNode = createInternalSqlParser(sql).parse();
    }
	
	protected Sample1InternalSqlParser createInternalSqlParser(String sql) {
	    return new Sample1InternalSqlParser(sql);
	}

    public CommandContext apply(Object[] args) {// It is necessary to be public!
        final CommandContext ctx = createCommandContext(args);
        rootNode.accept(ctx);
        return ctx;
    }

    protected CommandContext createCommandContext(Object[] args) {
	    return createCommandContextCreator().createCommandContext(args);
    }

	protected Sample1InternalCommandContextCreator createCommandContextCreator() {
	    return new Sample1InternalCommandContextCreator(argNames, argTypes);
	}
	
	// ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public String[] getArgNames() {
        return argNames;
    }

    public void setArgNames(String[] argNames) {
        this.argNames = argNames;
    }

    public Class<?>[] getArgTypes() {
        return argTypes;
    }

    public void setArgTypes(Class<?>[] argTypes) {
        this.argTypes = argTypes;
    }
}
