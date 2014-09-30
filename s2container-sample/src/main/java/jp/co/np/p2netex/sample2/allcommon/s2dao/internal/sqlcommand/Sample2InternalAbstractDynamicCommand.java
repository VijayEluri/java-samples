package jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlcommand;

import javax.sql.DataSource;

import org.seasar.dao.CommandContext;
import org.seasar.dao.Node;
import org.seasar.extension.jdbc.StatementFactory;

import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlparser.Sample2InternalCommandContextCreator;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlparser.Sample2InternalSqlParser;

/**
 * @author DBFlute(AutoGenerator)
 */
public abstract class Sample2InternalAbstractDynamicCommand extends Sample2InternalAbstractSqlCommand {

	// ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected Node rootNode;
    protected String[] argNames = new String[0];
    protected Class<?>[] argTypes = new Class[0];

	// ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample2InternalAbstractDynamicCommand(DataSource dataSource, StatementFactory statementFactory) {
        super(dataSource, statementFactory);
    }

	// ===================================================================================
    //                                                                        Sql Handling
    //                                                                        ============
    public void setSql(String sql) {
        super.setSql(sql);
        this.rootNode = createInternalSqlParser(sql).parse();
    }
	
	protected Sample2InternalSqlParser createInternalSqlParser(String sql) {
	    return new Sample2InternalSqlParser(sql);
	}

    public CommandContext apply(Object[] args) {// It is necessary to be public!
        final CommandContext ctx = createCommandContext(args);
        rootNode.accept(ctx);
        return ctx;
    }

    protected CommandContext createCommandContext(Object[] args) {
	    return createCommandContextCreator().createCommandContext(args);
    }

	protected Sample2InternalCommandContextCreator createCommandContextCreator() {
	    return new Sample2InternalCommandContextCreator(argNames, argTypes);
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
