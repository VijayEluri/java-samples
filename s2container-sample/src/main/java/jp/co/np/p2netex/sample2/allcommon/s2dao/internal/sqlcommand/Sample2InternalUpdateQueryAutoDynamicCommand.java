package jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlcommand;

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
import jp.co.np.p2netex.sample2.allcommon.Sample2Entity;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2ConditionBean;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.Sample2DBMeta;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.Sample2DBMetaInstanceHandler;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.info.Sample2ColumnInfo;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlhandler.Sample2InternalCommandContextHandler;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlparser.Sample2InternalCommandContextCreator;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlparser.Sample2InternalSqlParser;
import jp.co.np.p2netex.sample2.allcommon.util.Sample2SimpleSystemUtil;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample2InternalUpdateQueryAutoDynamicCommand implements SqlCommand  {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected DataSource dataSource;
    protected StatementFactory statementFactory;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample2InternalUpdateQueryAutoDynamicCommand(DataSource dataSource, StatementFactory statementFactory) {
        this.dataSource = dataSource;
        this.statementFactory = statementFactory;
    }

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    public Object execute(Object[] args) {
        Sample2ConditionBean cb = extractConditionBeanWithCheck(args);
        Sample2Entity entity = extractEntityWithCheck(args);
        String[] argNames = new String[]{"dto", "entity"};
        Class<?>[] argTypes = new Class<?>[]{cb.getClass(), entity.getClass()};
        String twoWaySql = buildQueryUpdateTwoWaySql(cb, entity);
        if (twoWaySql == null) {
            return 0;// No execute!
        }
        CommandContext context = createCommandContext(twoWaySql, argNames, argTypes, args);
        Sample2InternalCommandContextHandler handler = createCommandContextHandler(context);
        int rows = handler.execute(args);
        return new Integer(rows);
    }
    
    protected Sample2ConditionBean extractConditionBeanWithCheck(Object[] args) {
        assertArgument(args);
        Object fisrtArg = args[0];
        if (!(fisrtArg instanceof Sample2ConditionBean)) {
            String msg = "The type of first argument should be " + Sample2ConditionBean.class + "! But:";
            msg = msg + " type=" + fisrtArg.getClass();
            throw new IllegalArgumentException(msg);
        }
        return (Sample2ConditionBean) fisrtArg;
    }
    
    protected Sample2Entity extractEntityWithCheck(Object[] args) {
        assertArgument(args);
        Object secondArg = args[1];
        if (!(secondArg instanceof Sample2Entity)) {
            String msg = "The type of second argument should be " + Sample2Entity.class + "! But:";
            msg = msg + " type=" + secondArg.getClass();
            throw new IllegalArgumentException(msg);
        }
        return (Sample2Entity) secondArg;
    }
	
    protected void assertArgument(Object[] args) {
        if (args == null || args.length <= 1) {
            String msg = "The arguments should have two argument! But:";
            msg = msg + " args=" + (args != null ? args.length : null);
            throw new IllegalArgumentException(msg);
        }
    }
    
    protected Sample2InternalCommandContextHandler createCommandContextHandler(CommandContext context) {
        return new Sample2InternalCommandContextHandler(dataSource, statementFactory, context);
    }

    /**
     * @param cb Condition-bean. (NotNull)
     * @param entity Entity. (NotNull)
     * @return The two-way SQL of query update. (Nullable: If the set of modified properties is empty, return null.)
     */
    protected String buildQueryUpdateTwoWaySql(Sample2ConditionBean cb, Sample2Entity entity) {
        Map<String, String> columnParameterMap = new LinkedHashMap<String, String>();
        Sample2DBMeta dbmeta = Sample2DBMetaInstanceHandler.findDBMeta(entity.getTableDbName());
        Set<String> modifiedPropertyNames = entity.getModifiedPropertyNames();
        if (modifiedPropertyNames.isEmpty()) {
            return null;
        }
        String currentPropertyName = null;
        try {
            for (String propertyName : modifiedPropertyNames) {
                currentPropertyName = propertyName;
                Sample2ColumnInfo columnInfo = dbmeta.findColumnInfo(propertyName);
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
                Sample2ColumnInfo columnInfo = dbmeta.getVersionNoColumnInfo();
                String columnName = columnInfo.getColumnDbName();
                columnParameterMap.put(columnName, columnName + " + 1");
            }
            if (dbmeta.hasUpdateDate()) {
                Sample2ColumnInfo columnInfo = dbmeta.getUpdateDateColumnInfo();
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
    
    protected void throwQueryUpdateFailureException(Sample2ConditionBean cb, Sample2Entity entity, String propertyName, Exception e) {
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
