package jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlcommand;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Date;
import java.sql.Timestamp;
import java.lang.reflect.Method;
import javax.sql.DataSource;

import org.seasar.extension.jdbc.StatementFactory;
import org.seasar.dao.CommandContext;
import org.seasar.dao.Node;
import org.seasar.dao.SqlCommand;
import jp.co.np.p2netex.sample1.allcommon.Sample1Entity;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1ConditionBean;
import jp.co.np.p2netex.sample1.allcommon.dbmeta.Sample1DBMeta;
import jp.co.np.p2netex.sample1.allcommon.dbmeta.Sample1DBMetaInstanceHandler;
import jp.co.np.p2netex.sample1.allcommon.dbmeta.info.Sample1ColumnInfo;
import jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlhandler.Sample1InternalCommandContextHandler;
import jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlparser.Sample1InternalCommandContextCreator;
import jp.co.np.p2netex.sample1.allcommon.s2dao.internal.sqlparser.Sample1InternalSqlParser;
import jp.co.np.p2netex.sample1.allcommon.util.Sample1SimpleSystemUtil;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample1InternalUpdateQueryAutoDynamicCommand implements SqlCommand  {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected DataSource dataSource;
    protected StatementFactory statementFactory;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample1InternalUpdateQueryAutoDynamicCommand(DataSource dataSource, StatementFactory statementFactory) {
        this.dataSource = dataSource;
        this.statementFactory = statementFactory;
    }

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    public Object execute(Object[] args) {
        Sample1ConditionBean cb = extractConditionBeanWithCheck(args);
        Sample1Entity entity = extractEntityWithCheck(args);
        String[] argNames = new String[]{"dto", "entity"};
        Class<?>[] argTypes = new Class<?>[]{cb.getClass(), entity.getClass()};
        String twoWaySql = buildQueryUpdateTwoWaySql(cb, entity);
        if (twoWaySql == null) {
            return 0;// No execute!
        }
        CommandContext context = createCommandContext(twoWaySql, argNames, argTypes, args);
        Sample1InternalCommandContextHandler handler = createCommandContextHandler(context);
        int rows = handler.execute(args);
        return new Integer(rows);
    }
    
    protected Sample1ConditionBean extractConditionBeanWithCheck(Object[] args) {
        assertArgument(args);
        Object fisrtArg = args[0];
        if (!(fisrtArg instanceof Sample1ConditionBean)) {
            String msg = "The type of first argument should be " + Sample1ConditionBean.class + "! But:";
            msg = msg + " type=" + fisrtArg.getClass();
            throw new IllegalArgumentException(msg);
        }
        return (Sample1ConditionBean) fisrtArg;
    }
    
    protected Sample1Entity extractEntityWithCheck(Object[] args) {
        assertArgument(args);
        Object secondArg = args[1];
        if (!(secondArg instanceof Sample1Entity)) {
            String msg = "The type of second argument should be " + Sample1Entity.class + "! But:";
            msg = msg + " type=" + secondArg.getClass();
            throw new IllegalArgumentException(msg);
        }
        return (Sample1Entity) secondArg;
    }
	
    protected void assertArgument(Object[] args) {
        if (args == null || args.length <= 1) {
            String msg = "The arguments should have two argument! But:";
            msg = msg + " args=" + (args != null ? args.length : null);
            throw new IllegalArgumentException(msg);
        }
    }
    
    protected Sample1InternalCommandContextHandler createCommandContextHandler(CommandContext context) {
        return new Sample1InternalCommandContextHandler(dataSource, statementFactory, context);
    }

    /**
     * @param cb Condition-bean. (NotNull)
     * @param entity Entity. (NotNull)
     * @return The two-way SQL of query update. (Nullable: If the set of modified properties is empty, return null.)
     */
    protected String buildQueryUpdateTwoWaySql(Sample1ConditionBean cb, Sample1Entity entity) {
        Map<String, String> columnParameterMap = new LinkedHashMap<String, String>();
        Sample1DBMeta dbmeta = Sample1DBMetaInstanceHandler.findDBMeta(entity.getTableDbName());
        Set<String> modifiedPropertyNames = entity.getModifiedPropertyNames();
        if (modifiedPropertyNames.isEmpty()) {
            return null;
        }
        String currentPropertyName = null;
        try {
            for (String propertyName : modifiedPropertyNames) {
                currentPropertyName = propertyName;
                Sample1ColumnInfo columnInfo = dbmeta.findColumnInfo(propertyName);
                String columnName = columnInfo.getColumnDbName();
                Method getter = columnInfo.findGetter();
                Object value = getter.invoke(entity, (Object[])null);
                if (value != null) {
                    columnParameterMap.put(columnName, "/*entity." + propertyName + "*/null");
                } else {
                    columnParameterMap.put(columnName, "null");
                }
            }
            if (dbmeta.hasVersionNo()) {
                Sample1ColumnInfo columnInfo = dbmeta.getVersionNoColumnInfo();
                String columnName = columnInfo.getColumnDbName();
                columnParameterMap.put(columnName, columnName + " + 1");
            }
            if (dbmeta.hasUpdateDate()) {
                Sample1ColumnInfo columnInfo = dbmeta.getUpdateDateColumnInfo();
                Method setter = columnInfo.findSetter();
                if (Timestamp.class.isAssignableFrom(columnInfo.getPropertyType())) {
                    setter.invoke(entity, new Timestamp(System.currentTimeMillis()));
                } else {
                    setter.invoke(entity, new Date());
                }
                String columnName = columnInfo.getColumnDbName();
                columnParameterMap.put(columnName, "/*entity." + columnInfo.getPropertyName() + "*/null");
            }
        } catch (Exception e) {
            throwQueryUpdateFailureException(cb, entity, currentPropertyName, e);
        }
        return cb.getSqlClause().getClauseQueryUpdate(columnParameterMap);
    }
    
    protected void throwQueryUpdateFailureException(Sample1ConditionBean cb, Sample1Entity entity, String propertyName, Exception e) {
        String msg = "Look! Read the message below." + getLineSeparator();
        msg = msg + "/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *" + getLineSeparator();
        msg = msg + "queryUpdate() failed to execute!" + getLineSeparator();
        msg = msg + getLineSeparator();
        msg = msg + "[Advice]" + getLineSeparator();
        msg = msg + "Please confirm the parameter comment logic." + getLineSeparator();
        msg = msg + "It may exist the parameter comment that DOESN'T have an end comment." + getLineSeparator();
        msg = msg + "  For example:" + getLineSeparator();
        msg = msg + "    before (x) -- /*IF pmb.xxxId != null*/XXX_ID = /*pmb.xxxId*/3" + getLineSeparator();
        msg = msg + "    after  (o) -- /*IF pmb.xxxId != null*/XXX_ID = /*pmb.xxxId*/3/*END*/" + getLineSeparator();
        msg = msg + getLineSeparator();
        msg = msg + "[Doubtful Property Name]" + getLineSeparator() + propertyName + getLineSeparator();
        msg = msg + getLineSeparator();
        msg = msg + "[ConditionBean]" + getLineSeparator() + cb + getLineSeparator();
        msg = msg + getLineSeparator();
        msg = msg + "[Entity]" + getLineSeparator() + entity + getLineSeparator();
        msg = msg + getLineSeparator();
        msg = msg + "[Exception Message]" + getLineSeparator() + e.getMessage() + getLineSeparator();
        msg = msg + "* * * * * * * * * */";
        throw new QueryUpdateFailureException(msg, e);
    }
	
    public static class QueryUpdateFailureException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        public QueryUpdateFailureException(String msg, Exception e) {
            super(msg, e);
        }
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
