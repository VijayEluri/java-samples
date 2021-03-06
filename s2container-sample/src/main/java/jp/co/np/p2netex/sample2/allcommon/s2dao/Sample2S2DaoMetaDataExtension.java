package jp.co.np.p2netex.sample2.allcommon.s2dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import javax.sql.DataSource;

import org.seasar.dao.BeanAnnotationReader;
import org.seasar.dao.BeanEnhancer;
import org.seasar.dao.BeanMetaData;
import org.seasar.dao.BeanMetaDataFactory;
import org.seasar.dao.ColumnNaming;
import org.seasar.dao.Dbms;
import org.seasar.dao.IllegalParameterTypeRuntimeException;
import org.seasar.dao.ProcedureMetaData;
import org.seasar.dao.ProcedureParameterType;
import org.seasar.dao.PropertyTypeFactory;
import org.seasar.dao.PropertyTypeFactoryBuilder;
import org.seasar.dao.RelationPropertyType;
import org.seasar.dao.RelationPropertyTypeFactoryBuilder;
import org.seasar.dao.RelationRowCreator;
import org.seasar.dao.RowCreator;
import org.seasar.dao.SqlCommand;
import org.seasar.dao.TableNaming;
import org.seasar.dao.ValueTypeFactory;
import org.seasar.dao.dbms.DbmsManager;
import org.seasar.dao.impl.BeanMetaDataImpl;
import org.seasar.dao.impl.DaoMetaDataImpl;
import org.seasar.dao.impl.ProcedureMetaDataImpl;
import org.seasar.dao.impl.ProcedureParameterTypeImpl;
import org.seasar.dao.impl.PropertyTypeFactoryBuilderImpl;
import org.seasar.dao.impl.RelationRowCreationResource;
import org.seasar.dao.impl.ResultSetHandlerFactoryImpl;
import org.seasar.dao.impl.SelectDynamicCommand;
import org.seasar.dao.impl.UpdateAutoStaticCommand;
import org.seasar.dao.util.TypeUtil;
import org.seasar.extension.jdbc.PropertyType;
import org.seasar.extension.jdbc.ResultSetHandler;
import org.seasar.extension.jdbc.StatementFactory;
import org.seasar.extension.jdbc.ValueType;
import org.seasar.extension.jdbc.types.ValueTypes;
import org.seasar.framework.beans.BeanDesc;
import org.seasar.framework.beans.MethodNotFoundRuntimeException;
import org.seasar.framework.beans.PropertyDesc;
import org.seasar.framework.beans.factory.BeanDescFactory;
import org.seasar.framework.util.FieldUtil;
import org.seasar.framework.util.MethodUtil;

import jp.co.np.p2netex.sample2.allcommon.Sample2Entity;
import jp.co.np.p2netex.sample2.allcommon.Sample2InternalMapContext;
import jp.co.np.p2netex.sample2.allcommon.Sample2BehaviorSelector;
import jp.co.np.p2netex.sample2.allcommon.annotation.OutsideSql;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2ConditionBean;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2ConditionBeanContext;
import jp.co.np.p2netex.sample2.allcommon.cbean.outsidesql.Sample2OutsideSqlContext;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.Sample2DBMeta;
import jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException;
import jp.co.np.p2netex.sample2.allcommon.exception.Sample2BatchEntityAlreadyUpdatedException;
import jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException;
import jp.co.np.p2netex.sample2.allcommon.jdbc.Sample2CursorHandler;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.rshandler.Sample2InternalBeanListMetaDataResultSetHandler;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.rshandler.Sample2InternalBeanArrayMetaDataResultSetHandler;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlcommand.Sample2InternalDeleteAutoStaticCommand;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlcommand.Sample2InternalDeleteBatchAutoStaticCommand;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlcommand.Sample2InternalDeleteQueryAutoDynamicCommand;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlcommand.Sample2InternalInsertAutoDynamicCommand;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlcommand.Sample2InternalInsertBatchAutoStaticCommand;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlcommand.Sample2InternalProcedureCommand;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlcommand.Sample2InternalUpdateAutoDynamicCommand;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlcommand.Sample2InternalUpdateBatchAutoStaticCommand;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlcommand.Sample2InternalUpdateDynamicCommand;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlcommand.Sample2InternalUpdateModifiedOnlyCommand;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlcommand.Sample2InternalUpdateQueryAutoDynamicCommand;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlhandler.Sample2InternalBasicHandler.SQLExceptionHandler;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlhandler.Sample2InternalUpdateBatchAutoHandler;
import jp.co.np.p2netex.sample2.allcommon.s2dao.internal.sqlhandler.Sample2InternalDeleteBatchAutoHandler;
import jp.co.np.p2netex.sample2.allcommon.util.Sample2SimpleSystemUtil;

/**
 * The extension of DaoMetaDataImpl for DBFlute.
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample2S2DaoMetaDataExtension extends DaoMetaDataImpl {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Log instance. */
    private static final org.apache.commons.logging.Log _log = org.apache.commons.logging.LogFactory.getLog(Sample2S2DaoMetaDataExtension.class);
    
    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** Bean enhancer. */
    protected BeanEnhancer beanEnhancer;

    /** The factory of annotation reader. */
    protected org.seasar.dao.AnnotationReaderFactory annotationReaderFactory;

    /** The naming of column. {After S2Dao-1.0.47} */
    protected ColumnNaming columnNaming;

    /** The builder of property type factory. {After S2Dao-1.0.47} */
    protected PropertyTypeFactoryBuilder propertyTypeFactoryBuilder;

    /** The builder of relation property type factory. {After S2Dao-1.0.47} */
    protected RelationPropertyTypeFactoryBuilder relationPropertyTypeFactoryBuilder;

    /** The builder of table naming. {After S2Dao-1.0.47} */
    protected TableNaming tableNaming;

    // -----------------------------------------------------
    //                                     DBFlute Extension
    //                                     -----------------
    /** The selector of behavior. {Since DBFlute-0.7.1} */
    protected Sample2BehaviorSelector _behaviorSelector;
    
    /** The lock monitor of method initialization. */
    protected Object _methodInitializationLockMonitor = new Object();
    
    /** The determination of internal debug. {Since DBFlute-0.6.2} */
    protected boolean _internalDebug;
    
    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample2S2DaoMetaDataExtension() {
    }

    // ===================================================================================
    //                                                                 Initialize Override
    //                                                                 ===================
    @Override
    public void initialize() {
        beanClass = daoAnnotationReader.getBeanClass();
        daoInterface = getDaoInterface(daoClass);
        daoBeanDesc = BeanDescFactory.getBeanDesc(daoClass);
        final Connection conn = getConnection();// It is first impact to Database!
        try {
            final DatabaseMetaData dbMetaData = getMetaData(conn);
            dbms = DbmsManager.getDbms(getDatabaseProductName(dbMetaData));
        } finally {
            close(conn);
        }
        this.beanMetaData = beanMetaDataFactory.createBeanMetaData(daoInterface, beanClass);
        checkSingleRowUpdateForAll = daoAnnotationReader.isCheckSingleRowUpdate();

        // Comment out for lazy-load!
        // setupSqlCommand();
    }

    // ===================================================================================
    //                                                           SqlCommand Setup Override
    //                                                           =========================
    @Override
    public SqlCommand getSqlCommand(String methodName) throws MethodNotFoundRuntimeException {
        SqlCommand cmd = (SqlCommand) sqlCommands.get(methodName);
        if (cmd != null) {
            return cmd;
        }
        synchronized (_methodInitializationLockMonitor) {
            cmd = (SqlCommand) sqlCommands.get(methodName);
            if (cmd != null) {
                if (_log.isDebugEnabled()) {
                    _log.debug("...Getting sqlCommand as cache because the previous thread have already initilized.");
                }
                return cmd;
            }
            if (_log.isDebugEnabled()) {
                _log.debug("...Initializing sqlCommand.");
            }
            cmd = initializeSqlCommand(methodName);
        }
        return cmd;
    }

    protected SqlCommand initializeSqlCommand(String methodName) throws MethodNotFoundRuntimeException {
        if (Sample2OutsideSqlContext.isExistOutsideSqlContextOnThread()) {
            final Sample2OutsideSqlContext outsideSqlContext = Sample2OutsideSqlContext.getOutsideSqlContextOnThread();
            if (outsideSqlContext != null && outsideSqlContext.isSpecifiedOutsideSql()) {
                return initializeSpecifiedOutsideSqlCommand(methodName, outsideSqlContext);
            }
        }
        final Method[] methods = daoBeanDesc.getMethods(methodName);
        if (methods.length == 1 && MethodUtil.isAbstract(methods[0])) {
            setupMethod(methods[0]);
        }
        final SqlCommand cmd = (SqlCommand) sqlCommands.get(methodName);
        if (cmd != null) {
            return cmd;
        }
        throw new MethodNotFoundRuntimeException(daoClass, methodName, null);
    }

    protected SqlCommand initializeSpecifiedOutsideSqlCommand(String sqlCommandKey, Sample2OutsideSqlContext outsideSqlContext) throws MethodNotFoundRuntimeException {
        final Method[] methods = daoBeanDesc.getMethods(outsideSqlContext.getMethodName());// By real method name.
        if (methods.length == 1 && org.seasar.framework.util.MethodUtil.isAbstract(methods[0])) {
            final Method method = methods[0];
            if (isOutsideSqlDaoMethodSelect(method)) {
                setupSpecifiedOutsideSqlSelectCommand(sqlCommandKey, method, outsideSqlContext);
            } else if (isOutsideSqlDaoMethodCall(method)) {
                setupSpecifiedOutsideSqlCallCommand(sqlCommandKey, method, outsideSqlContext);
            } else {
                setupSpecifiedOutsideSqlExecuteCommand(sqlCommandKey, method, outsideSqlContext);
            }
        }
        final SqlCommand cmd = (SqlCommand) sqlCommands.get(sqlCommandKey);
        if (cmd != null) {
            return cmd;
        }
        String msg = "Internal Error! The sql-command is not found:";
        msg = msg + " sqlCommandKey=" + sqlCommandKey;
        msg = msg + " sqlCommands=" + sqlCommands;
        throw new IllegalStateException(msg);
    }

    protected boolean isOutsideSqlDaoMethodSelect(Method method) {
        return method.getName().startsWith("select");
    }

    protected boolean isOutsideSqlDaoMethodCall(Method method) {
        return method.getName().startsWith("call");
    }

    // ===================================================================================
    //                                                                Setup Method by Auto
    //                                                                ====================
    @Override
    protected void setupMethodByAuto(Method method) {
        final OutsideSql outsideSql = method.getAnnotation(OutsideSql.class);
        if (outsideSql != null) {
            String msg = "This method '" + method.getName() + "()' should use Outside Sql but the file was not found!";
            msg = msg + " Expected sql file name is '" + method.getDeclaringClass().getSimpleName() + "_" + method.getName() + ".sql'";
            throw new IllegalStateException(msg);
        }
        super.setupMethodByAuto(method);
    }

    // ===================================================================================
    //                                                                 ConditionBean Setup
    //                                                                 ===================
    @Override
    protected void setupSelectMethodByAuto(final Method method) {
        final ResultSetHandler handler = createResultSetHandler(method);
        final String[] argNames = daoAnnotationReader.getArgNames(method);
        final String query = daoAnnotationReader.getQuery(method);
        final SqlCommand cmd;
        if (query != null && !startsWithOrderBy(query)) {
            // For Pure S2Dao *Deprecated at the future...
            cmd = setupInternalQuerySelectMethodByAuto(method, handler, argNames, query);
        } else {
            cmd = setupInternalNonQuerySelectMethodByAuto(method, handler, argNames, query);
        }
        putSqlCommand(method.getName(), cmd);
    }

    // For Pure S2Dao *Deprecated at the future...
    protected SelectDynamicCommand setupInternalQuerySelectMethodByAuto(final Method method
                                                                      , final ResultSetHandler handler
                                                                      , final String[] argNames
                                                                      , final String query) {
        final Class[] types = method.getParameterTypes();
        final SelectDynamicCommand cmd = createSelectDynamicCommand(handler, query);
        cmd.setArgNames(argNames);
        cmd.setArgTypes(types);
        return cmd;
    }

    protected SqlCommand setupInternalNonQuerySelectMethodByAuto(final Method method
                                                               , final ResultSetHandler handler
                                                               , final String[] argNames
                                                               , final String query) {
        if (isAutoSelectSqlByDto(method, argNames)) {
            return setupInternalNonQuerySelectMethodByDto(method, handler, argNames, query);
        } else {
            // For Pure S2Dao *Deprecated at the future...
            return setupNonQuerySelectMethodByArgs(method, handler, argNames, query);
        }
    }
    
    // For condition-bean!
    protected SqlCommand setupInternalNonQuerySelectMethodByDto(Method method
                                                              , ResultSetHandler handler
                                                              , String[] argNames
                                                              , String query) {
        Class[] types = method.getParameterTypes();
        Class clazz = types[0];
        // /----------------------------------------------------- [MyExtension]
        if (!Sample2ConditionBeanContext.isTheTypeConditionBean(clazz)) {
            return super.setupNonQuerySelectMethodByDto(method, handler, argNames, query);
        }
        argNames = new String[] { "dto" };
        final Sample2S2DaoSelectDynamicCommand cmd = createCustomizeSelectDynamicCommand(handler);
        cmd.setArgNames(argNames);
        cmd.setArgTypes(types);
        // -----------/
        return cmd;
    }

    // ===================================================================================
    //                                       Insert and Update and Delete By Auto Override
    //                                       =============================================
    // -----------------------------------------------------
    //                                                Insert
    //                                                ------
    @Override
    protected void setupInsertMethodByAuto(final Method method) {
        checkAutoUpdateMethod(method);
        final String[] propertyNames = getPersistentPropertyNames(method);
        final SqlCommand command;
        if (isUpdateSignatureForBean(method)) {
            final Sample2InternalInsertAutoDynamicCommand cmd = new Sample2InternalInsertAutoDynamicCommand();
            cmd.setBeanMetaData(getBeanMetaData());
            cmd.setDataSource(dataSource);
            
            // It is unnecessary for DBFlute!
            // cmd.setNotSingleRowUpdatedExceptionClass(getNotSingleRowUpdatedExceptionClass(method));
            
            cmd.setPropertyNames(propertyNames);
            cmd.setStatementFactory(statementFactory);
            cmd.setCheckSingleRowUpdate(isCheckSingleRowUpdate(method));
            command = cmd;
        } else {
            boolean returningRows = false;
            if (int[].class.isAssignableFrom(method.getReturnType())) {
                returningRows = true;
            }
            final Sample2InternalInsertBatchAutoStaticCommand cmd = new Sample2InternalInsertBatchAutoStaticCommand(
                    dataSource, statementFactory, getBeanMetaData(),
                    propertyNames, returningRows);
            command = cmd;
        }
        putSqlCommand(method.getName(), command);
    }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    @Override
    protected void setupUpdateMethodByAuto(final Method method) {
        if (isFirstArgumentConditionBean(method)) {
            final SqlCommand cmd = new Sample2InternalUpdateQueryAutoDynamicCommand(dataSource, statementFactory);
            putSqlCommand(method.getName(), cmd);
            return;
        }
        checkAutoUpdateMethod(method);
        final String[] propertyNames = getPersistentPropertyNames(method);
        SqlCommand cmd;
        if (isUpdateSignatureForBean(method)) {
            if (isUnlessNull(method.getName())) {
                cmd = createInternalUpdateAutoDynamicCommand(method, propertyNames);
            } else if (isModifiedOnly(method.getName())) {
                cmd = createInternalUpdateModifiedOnlyCommand(method, propertyNames);
            } else {
                cmd = createInternalUpdateAutoStaticCommand(method, propertyNames);
            }
        } else {
            boolean returningRows = false;
            if (int[].class.isAssignableFrom(method.getReturnType())) {
                returningRows = true;
            }
            cmd = createInternalUpdateBatchAutoStaticCommand(method, propertyNames, returningRows);
        }
        putSqlCommand(method.getName(), cmd);
    }

    protected UpdateAutoStaticCommand createInternalUpdateAutoStaticCommand(final Method method, final String[] propertyNames) {
        final UpdateAutoStaticCommand cmd = new UpdateAutoStaticCommand(dataSource, statementFactory, beanMetaData, propertyNames);
        cmd.setCheckSingleRowUpdate(isCheckSingleRowUpdate(method));
        return cmd;
    }
    
    protected Sample2InternalUpdateAutoDynamicCommand createInternalUpdateAutoDynamicCommand(Method method, String[] propertyNames) {
        final Sample2InternalUpdateAutoDynamicCommand cmd = newUpdateAutoDynamicCommand(method, dataSource, statementFactory);
        cmd.setBeanMetaData(createBeanMetaData4UpdateDeleteByAuto(method));// Extension Point!
        cmd.setPropertyNames(propertyNames);
        cmd.setCheckSingleRowUpdate(!isNonstrictMethod(method));
        
        // It is unnecessary for DBFlute!
        // cmd.setNotSingleRowUpdatedExceptionClass(getNotSingleRowUpdatedExceptionClass(method));
        
        cmd.setVersionNoAutoIncrementOnMemory(isUpdateVersionNoAutoIncrementOnMemory(method));
        return cmd;
    }

    protected Sample2InternalUpdateAutoDynamicCommand newUpdateAutoDynamicCommand(Method method, DataSource ds, StatementFactory sf) {
        return new Sample2InternalUpdateAutoDynamicCommand(ds, sf);
    }

    protected Sample2InternalUpdateModifiedOnlyCommand createInternalUpdateModifiedOnlyCommand(final Method method, final String[] propertyNames) {
        final Sample2InternalUpdateModifiedOnlyCommand cmd = newInternalUpdateModifiedOnlyCommand(method, dataSource, statementFactory);
        cmd.setBeanMetaData(createBeanMetaData4UpdateDeleteByAuto(method));// Extension Point!
        cmd.setPropertyNames(propertyNames);
        cmd.setCheckSingleRowUpdate(!isNonstrictMethod(method));
        
        // It is unnecessary for DBFlute!
        // cmd.setNotSingleRowUpdatedExceptionClass(getNotSingleRowUpdatedExceptionClass(method));
        
        cmd.setVersionNoAutoIncrementOnMemory(isUpdateVersionNoAutoIncrementOnMemory(method));
        return cmd;
    }

    protected Sample2InternalUpdateModifiedOnlyCommand newInternalUpdateModifiedOnlyCommand(Method method, DataSource ds, StatementFactory sf) {
        return new Sample2InternalUpdateModifiedOnlyCommand(ds, sf);
    }

    protected Sample2InternalUpdateBatchAutoStaticCommand createInternalUpdateBatchAutoStaticCommand(final Method method, final String[] propertyNames, boolean returningRows) {
        return new Sample2InternalUpdateBatchAutoStaticCommand(dataSource, statementFactory
                                                      , createBeanMetaData4UpdateDeleteByAuto(method), propertyNames, returningRows
                                                      , isUpdateVersionNoAutoIncrementOnMemory(method)) {
            @Override
            protected Sample2InternalUpdateBatchAutoHandler newInternalBatchAutoHandler() {
                return new Sample2InternalUpdateBatchAutoHandler(getDataSource(), getStatementFactory(), getBeanMetaData(), getPropertyTypes()) {
                    @Override
                    protected int[] executeBatch(PreparedStatement ps, List<?> list) {
                        final int[] result = super.executeBatch(ps, list);
                        try {
                            handleBatchUpdateResultWithOptimisticLock(ps, list, result, method);
                        } catch (SQLException e) {
                            handleSQLException(e, ps, false, list);
                            return null;// Unreachable!
                        }
                        return result;
                    }
                };
            }
        };
    }

    // -----------------------------------------------------
    //                                                Delete
    //                                                ------
    @Override
    protected void setupDeleteMethodByAuto(final Method method) {
        if (isFirstArgumentConditionBean(method)) {
            final SqlCommand cmd = new Sample2InternalDeleteQueryAutoDynamicCommand(dataSource, statementFactory);
            putSqlCommand(method.getName(), cmd);
            return;
        }
        checkAutoUpdateMethod(method);
        final String[] propertyNames = getPersistentPropertyNames(method);
        final SqlCommand cmd;
        if (isUpdateSignatureForBean(method)) {
            cmd = createInternalDeleteAutoStaticCommand(method, propertyNames);
        } else {
            boolean returningRows = false;
            if (int[].class.isAssignableFrom(method.getReturnType())) {
                returningRows = true;
            }
            cmd = createInternalDeleteBatchAutoStaticCommand(method, propertyNames, returningRows);
        }
        putSqlCommand(method.getName(), cmd);
    }

    protected Sample2InternalDeleteAutoStaticCommand createInternalDeleteAutoStaticCommand(final Method method, final String[] propertyNames) {
        final Sample2InternalDeleteAutoStaticCommand cmd = new Sample2InternalDeleteAutoStaticCommand(dataSource, statementFactory, createBeanMetaData4UpdateDeleteByAuto(method), propertyNames);
        cmd.setCheckSingleRowUpdate(!isNonstrictMethod(method));
        return cmd;
    }

    protected Sample2InternalDeleteBatchAutoStaticCommand createInternalDeleteBatchAutoStaticCommand(final Method method, final String[] propertyNames, boolean returningRows) {
        return new Sample2InternalDeleteBatchAutoStaticCommand(dataSource, statementFactory, createBeanMetaData4UpdateDeleteByAuto(method), propertyNames, returningRows) {
            @Override
            protected Sample2InternalDeleteBatchAutoHandler newInternalBatchAutoHandler() {
                return new Sample2InternalDeleteBatchAutoHandler(getDataSource(), getStatementFactory(), getBeanMetaData(), getPropertyTypes()) {
                    @Override
                    protected int[] executeBatch(PreparedStatement ps, List<?> list) {
                        final int[] result = super.executeBatch(ps, list);
                        try {
                            handleBatchUpdateResultWithOptimisticLock(ps, list, result, method);
                        } catch (SQLException e) {
                            handleSQLException(e, ps, false, list);
                            return null;// Unreachable!
                        }
                        return result;
                    }
                };
            }
        };
    }

    // -----------------------------------------------------
    //                                         Common Helper
    //                                         -------------
    protected BeanMetaData createBeanMetaData4UpdateDeleteByAuto(Method method) {
        if (isNonstrictMethod(method)) {
            return createNonConcurrencyBmdFactory().createBeanMetaData(getBeanClass());
        } else {
            return getBeanMetaData();
        }
    }
    
    protected boolean isUpdateVersionNoAutoIncrementOnMemory(Method method) {
        return !isNonstrictMethod(method);
    }

    protected boolean isNonstrictMethod(Method method) {
        return method.getName().contains("Nonstrict");
    }

    protected BeanMetaDataFactory createNonConcurrencyBmdFactory() {
        final Sample2S2BeanMetaDataFactoryImpl nonConcurrencyBmdFactory = new Sample2S2BeanMetaDataFactoryImpl() {
            protected BeanMetaDataImpl createBeanMetaDataImpl() {
                return new BeanMetaDataImpl() {
                    public boolean hasVersionNoPropertyType() {
                        return false;
                    }

                    public boolean hasTimestampPropertyType() {
                        return false;
                    }
                };
            }
        };
        nonConcurrencyBmdFactory.setAnnotationReaderFactory(this.annotationReaderFactory);
        nonConcurrencyBmdFactory.setPropertyTypeFactoryBuilder(this.propertyTypeFactoryBuilder);
        nonConcurrencyBmdFactory.setRelationPropertyTypeFactoryBuilder(this.relationPropertyTypeFactoryBuilder);
        nonConcurrencyBmdFactory.setTableNaming(this.tableNaming);
        nonConcurrencyBmdFactory.setDataSource(this.dataSource);
        nonConcurrencyBmdFactory.setDaoNamingConvention(this.daoNamingConvention);
        nonConcurrencyBmdFactory.setBeanEnhancer(this.beanEnhancer);
        return nonConcurrencyBmdFactory;
    }

    protected boolean isFirstArgumentConditionBean(final Method method) {
        final Class<?>[] pmbTypes = method.getParameterTypes();
        return pmbTypes.length > 0 && Sample2ConditionBean.class.isAssignableFrom(pmbTypes[0]);
    }

    protected void handleBatchUpdateResultWithOptimisticLock(PreparedStatement ps, List<?> list, int[] result, Method method) throws SQLException {
        if (Sample2ConditionBeanContext.isOracle()) {
            final int updateCount = ps.getUpdateCount();
            handleBatchUpdateResultWithOptimisticLockByUpdateCount(list, updateCount, method);
        } else {
            handleBatchUpdateResultWithOptimisticLockByResult(list, result, method);
        }
    }

    protected void handleBatchUpdateResultWithOptimisticLockByUpdateCount(List<?> list, int updateCount, Method method) {
        if (list.isEmpty()) {
            return;// for Safety!
        }
        if (updateCount < 0) {
            return;// for Safety!
        }
        final int entityCount = list.size();
        if (updateCount < entityCount) {
            if (isNonstrictMethod(method)) {
                String msg = "The entity have already deleted:";
                msg = msg + " updateCount=" + updateCount;
                msg = msg + " entityCount=" + entityCount;
                msg = msg + " allEntities=" + list;
                throw new Sample2EntityAlreadyDeletedException(msg);
            } else {
                throw new Sample2BatchEntityAlreadyUpdatedException(list.get(0), 0, updateCount);
            }
        }
    }

    protected void handleBatchUpdateResultWithOptimisticLockByResult(List<?> list, Object result, Method method) {
        if (list.isEmpty()) {
            return;// for Safety!
        }
        if (!(result instanceof int[])) {
            return;// for Safety!
        }
        final int[] updatedCountArray = (int[])result;
        final int entityCount = list.size();
        int index = 0;
        boolean alreadyUpdated = false;
        for (int oneUpdateCount : updatedCountArray) {
            if (entityCount <= index) {
                break;// for Safety!
            }
            if (oneUpdateCount == 0) {
                alreadyUpdated = true;
                break;
            } else if (oneUpdateCount > 1) {
                String msg = "The entity updated two or more records in batch update:";
                msg = msg + " entity=" + list.get(index);
                msg = msg + " updatedCount=" + oneUpdateCount;
                msg = msg + " allEntities=" + list;
                throw new Sample2EntityDuplicatedException(msg);
            }
            ++index;
        }
        if (alreadyUpdated) {
            int updateCount = 0;
            for (int oneUpdateCount : updatedCountArray) {
                updateCount = updateCount + oneUpdateCount;
            }
            if (isNonstrictMethod(method)) {
                String msg = "The entity have already deleted:";
                msg = msg + " entity=" + list.get(index);
                msg = msg + " updateCount=" + updateCount;
                msg = msg + " allEntities=" + list;
                throw new Sample2EntityAlreadyDeletedException(msg);
            } else {
                throw new Sample2BatchEntityAlreadyUpdatedException(list.get(index), 0, updateCount);
            }
        }
    }

    // ===================================================================================
    //                                                                 OutsideSql Override
    //                                                                 ===================
    // -----------------------------------------------------
    //                                     Normal OutsideSql
    //                                     -----------------
    @Override
    protected void setupSelectMethodByManual(Method method, String sql) {// Contains SQL-Annotation
        final Class<?>[] pmbTypes = method.getParameterTypes();
        final String[] argNames = this.daoAnnotationReader.getArgNames(method);
        final Class<?>[] argTypes;
        if (pmbTypes != null && pmbTypes.length > 0
                && Sample2CursorHandler.class.isAssignableFrom(pmbTypes[pmbTypes.length-1])) {
            argTypes = new Class<?>[pmbTypes.length - 1];
            for (int i=0; i < pmbTypes.length - 1; i++) {
                argTypes[i] = pmbTypes[i];
            }
        } else {
            argTypes = pmbTypes;
        }
        final BeanMetaData myBeanMetaData = getOutsideSqlBeanMetaData(method);
        registerSqlCommand(method.getName(), method, sql, argNames, argTypes, myBeanMetaData);
    }

    protected BeanMetaData getOutsideSqlBeanMetaData(Method method) {
        final Class beanClass4SelectMethodByManual = getOutsideSqlDefaultBeanClass(method);
        if (beanClass4SelectMethodByManual.equals(getBeanClass())) {
            return getBeanMetaData();
        }
        return createOutsideSqlCustomizeBeanMetaDataFactory().createBeanMetaData(getOutsideSqlDefaultBeanClass(method));
    }

	// @jflute -- This override causes exception, it's pending...
	//            This is for to use QLog about SQL-Annotation. But the priority is very low. 
	// 
    // @Override
    // protected void setupUpdateMethodByManual(Method method, final String sql) {// Contains SQL-Annotation
    //     final Sample2InternalUpdateDynamicCommand cmd = new Sample2InternalUpdateDynamicCommand(dataSource, statementFactory);
    //     cmd.setSql(sql);
    //     String[] argNames = daoAnnotationReader.getArgNames(method);
    //     if (argNames.length == 0 && isUpdateSignatureForBean(method)) {
    //         argNames = new String[] { StringUtil.decapitalize(ClassUtil.getShortClassName(beanClass)) };
    //     }
    // 
    //     // It is unnecessary for DBFlute!
    //     // cmd.setNotSingleRowUpdatedExceptionClass(getNotSingleRowUpdatedExceptionClass(method));
    // 
    //     registerSqlCommand(method.getName(), method, sql, argNames, method.getParameterTypes(), cmd);
    // }

    // -----------------------------------------------------
    //                                  Specified OutsideSql
    //                                  --------------------
    // - - - - - - - - - - - -
    //                  Select
    //                   - - -
    protected void setupSpecifiedOutsideSqlSelectCommand(String sqlCommandKey, Method method, Sample2OutsideSqlContext outsideSqlContext) {
        // - - - - - - - - - - - - - - - - - - - - - - -
        // The attribute of Specified-OutsideSqlContext.
        // - - - - - - - - - - - - - - - - - - - - - - -
        final String sql = outsideSqlContext.readFilteredOutsideSql(getSqlFileEncoding(), dbms.getSuffix());
        final Object pmb = outsideSqlContext.getParameterBean();
        final Object resultTypeSpecification = outsideSqlContext.getResultTypeSpecification();

        // - - - - - - - - - - - - - - -
        // The attribute of SqlCommand.
        // - - - - - - - - - - - - - - -
        final String[] argNames = (pmb != null ? new String[] {"pmb"} : new String[]{});
        final Class<?>[] argTypes = (pmb != null ? new Class<?>[] {pmb.getClass()} : new Class<?>[]{});

        // - - - - - - - - - - - - - - - -
        // Create customized BeanMetaData.
        // - - - - - - - - - - - - - - - -
        final Class<?> lastestArguementType = method.getParameterTypes()[method.getParameterTypes().length-1];
        final ResultSetHandler myResultSetHandler;
        if (Class.class.isAssignableFrom(lastestArguementType)) {
            // - - - - - - - -
            // EntityHandling
            // - - - - - - - -
            final Class<?> customizeEntityType = (Class<?>)resultTypeSpecification;
            final BeanMetaData myBeanMetaData = createSpecifiedOutsideSqlCustomizeBeanMetaData(customizeEntityType);
            if (List.class.isAssignableFrom(method.getReturnType())) {
                myResultSetHandler = createSpecifiedOutsideSqlCustomizeBeanListResultSetHandler(myBeanMetaData, customizeEntityType);
            } else {
                throw new UnsupportedOperationException("The return type of method is unsupported: method.getReturnType()=" + method.getReturnType());
                // myResultSetHandler = createSpecifiedOutsideSqlCustomizeBeanResultSetHandler(myBeanMetaData, customizeEntityType);
            }
        } else if (Sample2CursorHandler.class.isAssignableFrom(lastestArguementType)) {
            // - - - - - - - -
            // CursorHandling
            // - - - - - - - -
            final BeanMetaData myBeanMetaData = createSpecifiedOutsideSqlCursorBeanMetaData(method);
            myResultSetHandler = createSpecifiedOutsideSqlCursorResultSetHandler(myBeanMetaData);
        } else {
            String msg = "The lastestArguementType is unsupported:";
            msg = msg + " lastestArguementType=" + lastestArguementType;
            msg = msg + " method=" + method;
            throw new IllegalStateException(msg);
        }

        // - - - - - - - - - - -
        // Register Sql-Command.
        // - - - - - - - - - - -
        registerSqlCommand(sqlCommandKey, method, sql, argNames, argTypes, myResultSetHandler);
    }

    protected BeanMetaData createSpecifiedOutsideSqlCustomizeBeanMetaData(Class clazz) {
        return createOutsideSqlCustomizeBeanMetaDataFactory().createBeanMetaData(clazz);
    }

// [Unsupported]
// The return type of method is unsupported!
// Because the method of outside-sql that selects one entity is unnecessary!
//
//    /**
//     * Create the handler of result set of specified outside-sql for customize bean.
//     * 
//     * @param specifiedBeanMetaData Specified bean meta data. (NotNull)
//     * @param customizeEntityType The type of customize entity. (NotNull)
//     * @return The handler of result set. (NotNull)
//     */
//    protected ResultSetHandler createSpecifiedOutsideSqlCustomizeBeanResultSetHandler(BeanMetaData specifiedBeanMetaData, Class<?> customizeEntityType) {
//        final ValueType valueType = ValueTypes.getValueType(customizeEntityType);
//        if (valueType == null || !valueType.equals(ValueTypes.OBJECT)) {
//            return new org.seasar.extension.jdbc.impl.ObjectResultSetHandler();
//        }
//        return new org.seasar.dao.impl.BeanMetaDataResultSetHandler(specifiedBeanMetaData, new RowCreatorExtension(), new RelationRowCreatorExtension());
//    }

    /**
     * Create the handler of result set of specified outside-sql for the list of customize bean.
     * @param specifiedBeanMetaData Specified bean meta data. (NotNull)
     * @param customizeEntityType The type of customize entity. (NotNull)
     * @return The handler of result set. (NotNull)
     */
    protected ResultSetHandler createSpecifiedOutsideSqlCustomizeBeanListResultSetHandler(BeanMetaData specifiedBeanMetaData, Class<?> customizeEntityType) {
        final ValueType valueType = ValueTypes.getValueType(customizeEntityType);
        if (valueType == null || !valueType.equals(ValueTypes.OBJECT)) {
            return new InternalObjectListResultSetHandler(valueType);
        }
        return new Sample2InternalBeanListMetaDataResultSetHandler(specifiedBeanMetaData, new RowCreatorExtension(), new RelationRowCreatorExtension());
    }

    protected class InternalObjectListResultSetHandler implements ResultSetHandler {
        private ValueType valueType;
        public InternalObjectListResultSetHandler(ValueType valueType) {
            this.valueType = valueType;
        }
        public Object handle(ResultSet rs) throws SQLException {
            final List<Object> ret = new ArrayList<Object>();
            while (rs.next()) {
                ret.add(valueType.getValue(rs, 1));
            }
            return ret;
        }
    }

    protected BeanMetaData createSpecifiedOutsideSqlCursorBeanMetaData(Method method) {
        return createOutsideSqlCustomizeBeanMetaDataFactory().createBeanMetaData(getOutsideSqlDefaultBeanClass(method));
    }

    protected ResultSetHandler createSpecifiedOutsideSqlCursorResultSetHandler(BeanMetaData specifiedBeanMetaData) {
        return new org.seasar.extension.jdbc.impl.ObjectResultSetHandler();// This is dummy for cursor handling!
    }

    // - - - - - - - - - - - -
    //                 Execute
    //                 - - - -
    protected void setupSpecifiedOutsideSqlExecuteCommand(String sqlCommandKey, Method method, Sample2OutsideSqlContext outsideSqlContext) {
        // - - - - - - - - - - - - - - - - - - - - - - -
        // The attribute of Specified-OutsideSqlContext.
        // - - - - - - - - - - - - - - - - - - - - - - -
        final String sql = outsideSqlContext.readFilteredOutsideSql(getSqlFileEncoding(), dbms.getSuffix());
        final Object pmb = outsideSqlContext.getParameterBean();

        // - - - - - - - - - - - - - - -
        // The attribute of SqlCommand.
        // - - - - - - - - - - - - - - -
        final String[] argNames = (pmb != null ? new String[] {"pmb"} : new String[]{});
        final Class<?>[] argTypes = (pmb != null ? new Class<?>[] {pmb.getClass()} : new Class<?>[]{});

        final Sample2InternalUpdateDynamicCommand cmd = new Sample2InternalUpdateDynamicCommand(dataSource, statementFactory) {
            @Override
            public Object execute(Object[] args) {
                if (args.length != 3) {
                    String msg = "Internal Error! OutsideSqlDao.execute() should have 3 arguements: args.length=" + args.length;
                    throw new IllegalStateException(msg);
                }
                Object arg = args[1];
                return super.execute(new Object[] {arg});
            }
        };
        
        // It is unnecessary for DBFlute!
        // cmd.setNotSingleRowUpdatedExceptionClass(getNotSingleRowUpdatedExceptionClass(method));
        
        registerSqlCommand(sqlCommandKey, method, sql, argNames, argTypes, cmd);
    }

	// - - - - - - - - - - - -
    //          Call Procedure
    //           - - - - - - -
    protected void setupSpecifiedOutsideSqlCallCommand(String sqlCommandKey, Method method, Sample2OutsideSqlContext outsideSqlContext) {
        // - - - - - - - - - - - - - - - - - - - - - - -
        // The attribute of Specified-OutsideSqlContext.
        // - - - - - - - - - - - - - - - - - - - - - - -
        final Object pmb = outsideSqlContext.getParameterBean();
        final String procedureName = outsideSqlContext.getOutsideSqlPath();

        // - - - - - - - - - - - - - - -
        // The attribute of SqlCommand.
        // - - - - - - - - - - - - - - -
        final InternalProcedureMetaDataFactory myProcedureMetaDataFactory = new InternalProcedureMetaDataFactory();
        myProcedureMetaDataFactory.setValueTypeFactory(valueTypeFactory);
        final Class<?> pmbType = pmb != null ? pmb.getClass() : null;
        final ProcedureMetaData metaData = myProcedureMetaDataFactory.createProcedureMetaData(procedureName, pmbType);
        final Sample2InternalProcedureCommand cmd = createInternalProcedureCommand(method, metaData);
        putSqlCommand(sqlCommandKey, cmd);
    }

    protected Sample2InternalProcedureCommand createInternalProcedureCommand(Method method, ProcedureMetaData metaData) {
        final ResultSetHandler resultSetHandler = createResultSetHandler(method);
        return new Sample2InternalProcedureCommand(dataSource, resultSetHandler, statementFactory, resultSetFactory, metaData);
    }
	
    // -----------------------------------------------------
    //                                  Common of OutsideSql
    //                                  --------------------
    protected BeanMetaDataFactory createOutsideSqlCustomizeBeanMetaDataFactory() {
        final Sample2S2BeanMetaDataFactoryImpl originalBmdFactory = new Sample2S2BeanMetaDataFactoryImpl() {
            protected BeanMetaDataImpl createBeanMetaDataImpl() {
                return newOutsideSqlCustomizeBeanMetaDataImpl();
            }
        };
        originalBmdFactory.setAnnotationReaderFactory(this.annotationReaderFactory);
        originalBmdFactory.setPropertyTypeFactoryBuilder(newOutsideSqlPropertyTypeFactoryBuilderImpl());
        originalBmdFactory.setRelationPropertyTypeFactoryBuilder(this.relationPropertyTypeFactoryBuilder);
        originalBmdFactory.setTableNaming(this.tableNaming);
        originalBmdFactory.setDataSource(this.dataSource);
        originalBmdFactory.setDaoNamingConvention(this.daoNamingConvention);
        originalBmdFactory.setBeanEnhancer(this.beanEnhancer);
        return originalBmdFactory;
    }

    protected BeanMetaDataImpl newOutsideSqlCustomizeBeanMetaDataImpl() {
        return new OutsideSqlCustomizeBeanMetaDataImpl();
    }

    protected static class OutsideSqlCustomizeBeanMetaDataImpl extends BeanMetaDataImpl {
        // Though nothing to override, it uses original class just in case.
    }

    protected PropertyTypeFactoryBuilderImpl newOutsideSqlPropertyTypeFactoryBuilderImpl() {
        final PropertyTypeFactoryBuilderImpl impl = new OutsideSqlPropertyTypeFactoryBuilderExtension();
        if (columnNaming == null) {
            String msg = "Internal Error! The columnNaming should not be null! {Failed to Injection!}";
            throw new IllegalStateException(msg);
        }
        impl.setColumnNaming(columnNaming);
        impl.setDaoNamingConvention(daoNamingConvention);
        impl.setValueTypeFactory(valueTypeFactory);
        return impl;
    }

    protected static class OutsideSqlPropertyTypeFactoryBuilderExtension extends PropertyTypeFactoryBuilderImpl {
        @Override
        public PropertyTypeFactory build(Class beanClass, BeanAnnotationReader beanAnnotationReader, Dbms dbms, DatabaseMetaData databaseMetaData) {
            return new Sample2S2DaoPropertyTypeFactoryBuilderExtension.FastPropertyTypeFactoryExtension(beanClass, beanAnnotationReader, valueTypeFactory, columnNaming, daoNamingConvention, dbms);
        }
    }

    protected Class getOutsideSqlDefaultBeanClass(Method method) {
        final Class retType = method.getReturnType();
        if (java.util.List.class.isAssignableFrom(retType)) {
            final Class elementType = InternalMethodUtil.getElementTypeOfListFromReturnMethod(method);
            if (elementType != null) {
                return elementType;
            } else {
                return getBeanClass();
            }
        } else if (retType.isArray()) {
            return retType.getComponentType();
        } else if (retType.isPrimitive() || !ValueTypes.getValueType(retType).equals(ValueTypes.OBJECT)) {
            return getBeanClass();
        } else {
            return retType;
        }
    }
    
    protected void registerSqlCommand(String sqlCommandKey, Method method, String sql, String[] argNames, Class[] argTypes, BeanMetaData myBeanMetaData) {
        registerSqlCommand(sqlCommandKey, method, sql, argNames, argTypes, createResultSetHandler(myBeanMetaData, method));
    }

    protected void registerSqlCommand(String sqlCommandKey, Method method, String sql, String[] argNames, Class[] argTypes, ResultSetHandler myResultSetHandler) {
        final Sample2S2DaoSelectDynamicCommand cmd = createCustomizeSelectDynamicCommand(myResultSetHandler);
        registerSqlCommand(sqlCommandKey, method, sql, argNames, argTypes, cmd);
    }

    protected void registerSqlCommand(String sqlCommandKey, Method method, String sql, String[] argNames, Class[] argTypes, Sample2S2DaoSelectDynamicCommand cmd) {
        cmd.setSql(sql);
        cmd.setArgNames(argNames);
        cmd.setArgTypes(argTypes);
        this.sqlCommands.put(sqlCommandKey, cmd);
    }

    protected void registerSqlCommand(String sqlCommandKey, Method method, String sql, String[] argNames, Class[] argTypes, Sample2InternalUpdateDynamicCommand cmd) {
        cmd.setSql(sql);
        cmd.setArgNames(argNames);
        cmd.setArgTypes(argTypes);
        this.sqlCommands.put(sqlCommandKey, cmd);
    }

    // ===================================================================================
    //                                                                     Common Handlnig
    //                                                                     ===============
    @Override
    protected void putSqlCommand(String methodName, SqlCommand cmd) {
        sqlCommands.put(methodName, cmd);
    }
    
    protected boolean isCheckSingleRowUpdate(Method method) {
        return checkSingleRowUpdateForAll & daoAnnotationReader.isCheckSingleRowUpdate(method);
    }

    // ===================================================================================
    //                                             Customize SelectDynamicCommand Creation
    //                                             =======================================
    /**
     * Create the customize select dynamic command that is for all select SQL on DBFlute.
     * @param handler The handler of result set. (NotNull)
     * @return The customize select dynamic command. (NotNull)
     */
    protected Sample2S2DaoSelectDynamicCommand createCustomizeSelectDynamicCommand(ResultSetHandler handler) {
        return new Sample2S2DaoSelectDynamicCommand(dataSource, statementFactory, handler, resultSetFactory);
    }

    // ===================================================================================
    //                                                           ResultSetHandler Override
    //                                                           =========================
    @Override
    protected ResultSetHandler createResultSetHandler(Method method) {
        return this.resultSetHandlerFactory.getResultSetHandler(daoAnnotationReader, beanMetaData, method);
    }

    protected ResultSetHandler createResultSetHandler(BeanMetaData specifiedBeanMetaData, Method method) {// For specified BeanMetaData
        return this.resultSetHandlerFactory.getResultSetHandler(daoAnnotationReader, specifiedBeanMetaData, method);
    }

    // ===================================================================================
    //                                                                      JDBC Delegator
    //                                                                      ==============
    protected Connection getConnection() {
        if (dataSource == null) {
            throw new IllegalStateException("The dataSource should not be null!");
        }
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            handleSQLException(e, null);
            return null;// Unreachable!
        }
    }

    protected DatabaseMetaData getMetaData(Connection conn) {
        try {
            return conn.getMetaData();
        } catch (SQLException e) {
            handleSQLException(e, null);
            return null;// Unreachable!
        }
    }

    protected String getDatabaseProductName(DatabaseMetaData dbMetaData) {
        try {
            return dbMetaData.getDatabaseProductName();
        } catch (SQLException e) {
            handleSQLException(e, null);
            return null;// Unreachable!
        }
    }

    protected void close(Connection conn) {
        if (conn == null) {
            return;
        }
        try {
            conn.close();
        } catch (SQLException e) {
            handleSQLException(e, null);
        }
    }

    // ===================================================================================
    //                                                                  Exception Handlnig
    //                                                                  ==================
    protected void handleSQLException(SQLException e, Statement statement) {
        new SQLExceptionHandler().handleSQLException(e, statement);
    }

    // ===================================================================================
    //                                                                       Vert Internal
    //                                                                       =============
    protected static class InternalMethodUtil {
        public static Class getElementTypeOfListFromReturnMethod(Method method) {
            return InternalReflectionUtil.getElementTypeOfListFromReturnType(method);
        }
    }

    protected static class InternalReflectionUtil {
        public static Class<?> getElementTypeOfList(final Type parameterizedList) {
            if (!(parameterizedList instanceof ParameterizedType)) {
                return null;
            }

            final ParameterizedType parameterizedType = ParameterizedType.class.cast(parameterizedList);
            final Type rawType = parameterizedType.getRawType();
            if (!(rawType instanceof Class)) {
                return null;
            }

            final Class<?> rawClass = Class.class.cast(rawType);
            if (!rawClass.isAssignableFrom(List.class)) {
                return null;
            }

            final Type[] actualTypeArgument = parameterizedType.getActualTypeArguments();
            if (actualTypeArgument == null || actualTypeArgument.length != 1) {
                return null;
            }
            if (!(actualTypeArgument[0] instanceof Class)) {
                return null;
            }

            return Class.class.cast(actualTypeArgument[0]);
        }

        public static Class<?> getElementTypeOfListFromParameterType(final Method method, final int parameterPosition) {
            final Type[] pmbTypes = method.getGenericParameterTypes();
            return getElementTypeOfList(pmbTypes[parameterPosition]);
        }

        public static Class<?> getElementTypeOfListFromReturnType(final Method method) {
            return getElementTypeOfList(method.getGenericReturnType());
        }
    }

    // ===================================================================================
    //                                               ResultSetHandlerFactoryImpl Extension
    //                                               =====================================
    public static class ResultSetHandlerFactoryExtension extends ResultSetHandlerFactoryImpl {
        public ResultSetHandlerFactoryExtension() {
            super();
        }

        @Override
        protected RowCreator createRowCreator() {// [DAO-118] (2007/08/25)
            return new RowCreatorExtension();
        }

        @Override
        protected RelationRowCreator createRelationRowCreator() {
            return new RelationRowCreatorExtension();
        }
        
        @Override
        protected ResultSetHandler createBeanListMetaDataResultSetHandler(BeanMetaData beanMetaData) {
            return new Sample2InternalBeanListMetaDataResultSetHandler(beanMetaData, createRowCreator(), createRelationRowCreator());
        }
        
        @Override
        protected ResultSetHandler createBeanArrayMetaDataResultSetHandler(BeanMetaData beanMetaData) {
            return new Sample2InternalBeanArrayMetaDataResultSetHandler(beanMetaData, createRowCreator(), createRelationRowCreator());
        }
    }

    // ===================================================================================
    //                                                            RowCreatorImpl Extension
    //                                                            ========================
    protected static class RowCreatorExtension extends org.seasar.dao.impl.RowCreatorImpl {
    
        /** The key of DBMeta cache. */
        protected static final String DBMETA_CACHE_KEY = "df:DBMetaCache";

        @Override
        public Object createRow(ResultSet rs, Map propertyCache, Class beanClass) throws SQLException  {
            final Object row = newBean(beanClass);
            final Sample2DBMeta dbmeta = findDBMeta(row);
            final Set columnNameSet = propertyCache.keySet();
            String columnName = null;
            PropertyType pt = null;
            String propertyName = null;
            try {
                for (final Iterator ite = columnNameSet.iterator(); ite.hasNext();) {
                    columnName = (String) ite.next();
                    pt = (PropertyType) propertyCache.get(columnName);
                    propertyName = pt.getPropertyName();
                    if (dbmeta != null && dbmeta.hasEntityPropertySetupper(propertyName)) {
                        final ValueType valueType = pt.getValueType();
                        final Object value = valueType.getValue(rs, columnName);
                        dbmeta.setupEntityProperty(propertyName, row, value);
                    } else {
                        registerValue(rs, row, pt, columnName);
                    }
                }
            } catch (ClassCastException e) {
                if (_log.isWarnEnabled()) {
                    String msg = ClassCastException.class.getSimpleName() + " occurred while ResultSet Handling:";
                    _log.warn(msg + " target=" + beanClass.getSimpleName() + "." + propertyName + " dbmeta");
                }
                throwNonsenseClassCastException(row, dbmeta, e);
            } catch (SQLException e) {
                if (_log.isWarnEnabled()) {
                    String msg = SQLException.class.getSimpleName() + " occurred while ResultSet Handling:";
                    _log.warn(msg + " target=" + beanClass.getSimpleName() + "." + propertyName);
                }
                throw e;
            }
            return row;
        }

        /**
         * @param row The object of row. (NotNull)
         * @return The interface of DBMeta. (Nullable: If it's null, it means NotFound.)
         */
        protected Sample2DBMeta findDBMeta(Object row) {
            return EntityPropertySetupperHandler.findCachedDBMeta(row);
        }

        protected void throwNonsenseClassCastException(Object entity, Sample2DBMeta dbmeta, ClassCastException e) {
            String msg = "Look! Read the message below." + getLineSeparator();
            msg = msg + "/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *" + getLineSeparator();
            msg = msg + "Nonsense ClassCastException occured!" + getLineSeparator();
            msg = msg + getLineSeparator();
            msg = msg + "[Advice]" + getLineSeparator();
            msg = msg + "This exception may be from ClassLoader Headache about HotDeploy." + getLineSeparator();
            msg = msg + "Please add the ignore-package setting to convention.dicon like as follows:" + getLineSeparator();
            msg = msg + "  For example:" + getLineSeparator();
            msg = msg + "    <initMethod name=”addIgnorePackageName”>" + getLineSeparator();
            msg = msg + "        <arg>”com.example.xxx.dbflute”</arg>" + getLineSeparator();
            msg = msg + "    </initMethod>" + getLineSeparator();
            msg = msg + getLineSeparator();
            msg = msg + "[Exception Message]" + getLineSeparator() + e.getMessage() + getLineSeparator();
            msg = msg + getLineSeparator();
            msg = msg + "[Target Entity]" + getLineSeparator() + entity + getLineSeparator();
            msg = msg + getLineSeparator();
            msg = msg + "[Target Entity Class Loader]" + getLineSeparator() + entity.getClass().getClassLoader() + getLineSeparator();
            msg = msg + getLineSeparator();
            msg = msg + "[Target DBMeta]" + getLineSeparator() + dbmeta + getLineSeparator();
            msg = msg + getLineSeparator();
            msg = msg + "[Target DBMeta Class Loader]" + getLineSeparator() + dbmeta.getClass().getClassLoader() + getLineSeparator();
            msg = msg + "* * * * * * * * * */";
            throw new NonsenseClassCastException(msg, e);
        }
        
        protected String getLineSeparator() {
            return Sample2SimpleSystemUtil.getLineSeparator();
        }
    }

    public static class NonsenseClassCastException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        public NonsenseClassCastException(String msg, ClassCastException e) {
            super(msg, e);
        }
    }

    /**
     * The handler of setupper of entity property.
     */
    protected static class EntityPropertySetupperHandler {
        
        /** The key of DBMeta cache. */
        protected static final String DBMETA_CACHE_KEY = "df:DBMetaCache";
        
        public static Sample2DBMeta findCachedDBMeta(Object row) {
            if (!(row instanceof Sample2Entity)) {
                return null;
            }
            final Sample2Entity entity = (Sample2Entity) row;
            Map<Class<?>, Sample2DBMeta> dbmetaCache = (Map<Class<?>, Sample2DBMeta>)Sample2InternalMapContext.getObject(DBMETA_CACHE_KEY);
            if (dbmetaCache == null) {
                dbmetaCache = new HashMap<Class<?>, Sample2DBMeta>();
                Sample2InternalMapContext.setObject(DBMETA_CACHE_KEY, dbmetaCache);
            }
            Sample2DBMeta dbmeta = dbmetaCache.get(entity.getClass());
            if (dbmeta != null) {
                return dbmeta;
            }
            dbmeta = entity.getDBMeta();
            dbmetaCache.put(entity.getClass(), dbmeta);
            return dbmeta;
        }
    }
    
    // ===================================================================================
    //                                                    RelationRowCreatorImpl Extension
    //                                                    ================================
    protected static class RelationRowCreatorExtension extends org.seasar.dao.impl.RelationRowCreatorImpl {
    
        @Override
        protected Object createRelationRow(RelationRowCreationResource res)
                throws SQLException {
            // - - - - - - - - - - - 
            // Recursive Call Point!
            // - - - - - - - - - - -
            if (!res.hasPropertyCacheElement()) {
                return null;
            }
            setupRelationKeyValue(res);
            setupRelationAllValue(res);
            return res.getRow();
        }
    
        @Override
        protected void setupRelationKeyValue(RelationRowCreationResource res) {
            final RelationPropertyType rpt = res.getRelationPropertyType();
            final BeanMetaData bmd = rpt.getBeanMetaData();
            for (int i = 0; i < rpt.getKeySize(); ++i) {
                final String columnName = rpt.getMyKey(i) + res.getBaseSuffix();
    
                if (!res.containsColumnName(columnName)) {
                    continue;
                }
                if (!res.hasRowInstance()) {
                    res.setRow(newRelationRow(rpt));
                }
                if (!res.containsRelKeyValueIfExists(columnName)) {
                    continue;
                }
                final Object value = res.extractRelKeyValue(columnName);
                if (value == null) {
                    continue;
                }
    
                final String yourKey = rpt.getYourKey(i);
                final PropertyType pt = bmd.getPropertyTypeByColumnName(yourKey);
                final PropertyDesc pd = pt.getPropertyDesc();
                pd.setValue(res.getRow(), value);
                continue;
            }
        }
    
        @Override
        protected void setupRelationAllValue(RelationRowCreationResource res) throws SQLException {
            final Map propertyCacheElement = res.extractPropertyCacheElement();
            final Set columnNameCacheElementKeySet = propertyCacheElement.keySet();
            for (final Iterator ite = columnNameCacheElementKeySet.iterator(); ite.hasNext();) {
                final String columnName = (String) ite.next();
                final PropertyType pt = (PropertyType) propertyCacheElement.get(columnName);
                res.setCurrentPropertyType(pt);
                if (!isValidRelationPerPropertyLoop(res)) {
                    res.clearRowInstance();
                    return;
                }
                setupRelationProperty(res);
            }
            if (!isValidRelationAfterPropertyLoop(res)) {
                res.clearRowInstance();
                return;
            }
            res.clearValidValueCount();
            if (res.hasNextRelationProperty() && (hasConditionBean(res) || res.hasNextRelationLevel())) {
                setupNextRelationRow(res);
            }
        }
        
        @Override
        protected void registerRelationValue(RelationRowCreationResource res, String columnName) throws SQLException {
            final PropertyType pt = res.getCurrentPropertyType();
            Object value = null;
            if (res.containsRelKeyValueIfExists(columnName)) {
                value = res.extractRelKeyValue(columnName);
            } else {
                final ValueType valueType = pt.getValueType();
                value = valueType.getValue(res.getResultSet(), columnName);
            }
            
            if (value != null) {
                res.incrementValidValueCount();
                final Sample2DBMeta dbmeta = findDBMeta(res.getRow());
                final String propertyName = pt.getPropertyName();
                if (dbmeta != null && dbmeta.hasEntityPropertySetupper(propertyName)) {
                    dbmeta.setupEntityProperty(propertyName, res.getRow(), value);
                } else {
                    final PropertyDesc pd = pt.getPropertyDesc();
                    pd.setValue(res.getRow(), value);
                }
            }
        }
        
        /**
         * @param row The object of row. (NotNull)
         * @return The interface of DBMeta. (Nullable: If it's null, it means NotFound.)
         */
        protected Sample2DBMeta findDBMeta(Object row) {
            return EntityPropertySetupperHandler.findCachedDBMeta(row);
        }
        
        @Override
        protected void setupPropertyCache(RelationRowCreationResource res) throws SQLException {
            // - - - - - - - - - - - 
            // Recursive Call Point!
            // - - - - - - - - - - -
            res.initializePropertyCacheElement();
    
            // Do only selected foreign property for performance if condition-bean exists.
            if (hasConditionBean(res)) {
                final Sample2ConditionBean cb = Sample2ConditionBeanContext.getConditionBeanOnThread();
                if (!cb.getSqlClause().hasSelectedForeignInfo(res.getRelationNoSuffix())) {
                    return;
                }
            }
            
            // Set up property cache about current beanMetaData.
            final BeanMetaData nextBmd = res.getRelationBeanMetaData();
            for (int i = 0; i < nextBmd.getPropertyTypeSize(); ++i) {
                final PropertyType pt = nextBmd.getPropertyType(i);
                res.setCurrentPropertyType(pt);
                if (!isTargetProperty(res)) {
                    continue;
                }
                setupPropertyCacheElement(res);
            }
            
            // Set up next relation.
            if (res.hasNextRelationProperty() && (hasConditionBean(res) || res.hasNextRelationLevel())) {
                res.backupRelationPropertyType();
                res.incrementCurrentRelationNestLevel();
                try {
                    setupNextPropertyCache(res, nextBmd);
                } finally {
                    res.restoreRelationPropertyType();
                    res.decrementCurrentRelationNestLevel();
                }
            }
        }
    
        @Override
        protected boolean isTargetProperty(org.seasar.dao.impl.RelationRowCreationResource res) throws java.sql.SQLException {
            final PropertyType pt = res.getCurrentPropertyType();
            if (!pt.getPropertyDesc().hasWriteMethod()) {
                return false;
            }
            if (java.util.List.class.isAssignableFrom(pt.getPropertyDesc().getPropertyType())) {
                return false;
            }
            return true;
        }

        @Override
        protected boolean isCreateDeadLink() {
            return false;
        }
        
        @Override
        protected int getLimitRelationNestLevel() {
            return 2;// for Compatible
        }
        
        @Override
        protected RelationRowCreationResource createResourceForRow(ResultSet rs,
                RelationPropertyType rpt, Set columnNames, Map relKeyValues,
                Map relationPropertyCache) throws SQLException {
            final RelationRowCreationResource res = new RelationRowCreationResourceExtension();
            res.setResultSet(rs);
            res.setRelationPropertyType(rpt);
            res.setColumnNames(columnNames);
            res.setRelKeyValues(relKeyValues);
            res.setRelationPropertyCache(relationPropertyCache);
            res.setBaseSuffix("");// as Default
            res.setRelationNoSuffix(buildRelationNoSuffix(rpt));
            res.setLimitRelationNestLevel(getLimitRelationNestLevel());
            res.setCurrentRelationNestLevel(1);// as Default
            res.setCreateDeadLink(isCreateDeadLink());
            return res;
        }
    
        @Override
        protected RelationRowCreationResource createResourceForPropertyCache(RelationPropertyType rpt, Set columnNames,
                Map relationPropertyCache, String baseSuffix, String relationNoSuffix, int limitRelationNestLevel)
                throws SQLException {
            final RelationRowCreationResource res = new RelationRowCreationResourceExtension();
            res.setRelationPropertyType(rpt);
            res.setColumnNames(columnNames);
            res.setRelationPropertyCache(relationPropertyCache);
            res.setBaseSuffix(baseSuffix);
            res.setRelationNoSuffix(relationNoSuffix);
            res.setLimitRelationNestLevel(limitRelationNestLevel);
            res.setCurrentRelationNestLevel(1);// as Default
            return res;
        }
        
        protected boolean isConditionBeanSelectedRelation(RelationRowCreationResource res) {
            if (hasConditionBean(res)) {
                final Sample2ConditionBean cb = Sample2ConditionBeanContext.getConditionBeanOnThread();
                if (cb.getSqlClause().hasSelectedForeignInfo(res.getRelationNoSuffix())) {
                    return true;
                }
            }
            return false;
        }
        
        protected boolean hasConditionBean(RelationRowCreationResource res) {
            return Sample2ConditionBeanContext.isExistConditionBeanOnThread();
        }
    }
    
    protected static class RelationRowCreationResourceExtension extends RelationRowCreationResource {
        protected Stack<RelationPropertyType> backupRelationPropertyType = new Stack<RelationPropertyType>();
        protected Stack<String> backupBaseSuffix = new Stack<String>();
        protected Stack<String> backupRelationSuffix = new Stack<String>();
        
        @Override
        public void backupRelationPropertyType() {
            backupRelationPropertyType.push(getRelationPropertyType());
        }
        
        @Override
        public void restoreRelationPropertyType() {
            setRelationPropertyType(backupRelationPropertyType.pop());
        }
        
        @Override
        public void backupSuffixAndPrepare(String baseSuffix, String additionalRelationNoSuffix) {
            backupBaseSuffixExtension();
            backupRelationNoSuffixExtension();
            setBaseSuffix(baseSuffix);
            addRelationNoSuffix(additionalRelationNoSuffix);
        }
        
        @Override
        public void restoreSuffix() {
            restoreBaseSuffixExtension();
            restoreRelationNoSuffixExtension();
        }
        
        protected void backupBaseSuffixExtension() {
            backupBaseSuffix.push(getBaseSuffix());
        }

        protected void restoreBaseSuffixExtension() {
            setBaseSuffix(backupBaseSuffix.pop());
        }
        
        protected void backupRelationNoSuffixExtension() {
            backupRelationSuffix.push(getRelationNoSuffix());
        }
        
        protected void restoreRelationNoSuffixExtension() {
            setRelationNoSuffix(backupRelationSuffix.pop());
        }
    }

    // ===================================================================================
    //                                                                           Procedure
    //                                                                           =========
    protected static class InternalProcedureMetaDataFactory {
        protected ValueTypeFactory valueTypeFactory;
        protected InternalFieldProcedureAnnotationReader annotationReader = new InternalFieldProcedureAnnotationReader();
        public ProcedureMetaData createProcedureMetaData(final String procedureName, final Class<?> pmbType) {
            final ProcedureMetaDataImpl metaData = new ProcedureMetaDataImpl(procedureName);
            if (pmbType == null) {
                return metaData;
            } else {
                if (!isDtoType(pmbType)) {
                    throw new IllegalStateException("The pmb type was Not DTO type: " + pmbType.getName());
                }
            }
            final BeanDesc pmbDesc = BeanDescFactory.getBeanDesc(pmbType);

            // *Point
            final Stack<Class<?>> stack = new Stack<Class<?>>();
            for (Class<?> clazz = pmbType; clazz != null && clazz != Object.class; clazz = clazz.getSuperclass()) {
                stack.push(clazz);
            }
            for ( ; !stack.isEmpty() ;) {
                final Class<?> clazz = stack.pop();
                registerParameterType(metaData, pmbDesc, clazz.getDeclaredFields());
            }

            return metaData;
        }
        protected void registerParameterType(ProcedureMetaDataImpl metaData, BeanDesc pmbDesc, Field[] fields) {
            for (Field field : fields) {
                if (!isInstanceField(field)) {
                    continue;
                }
                final ProcedureParameterType ppt = getProcedureParameterType(pmbDesc, field);
                if (ppt == null) {
                    continue;
                }
                metaData.addParameterType(ppt);
            }
        }
        protected ProcedureParameterType getProcedureParameterType(final BeanDesc dtoDesc, final Field field) {
            final String type = annotationReader.getProcedureParameter(dtoDesc, field);
            if (type == null) {
                return null;
            }
            field.setAccessible(true);
            final ProcedureParameterType ppt = new ProcedureParameterTypeImpl(field);
            if (type.equalsIgnoreCase("in")) {
                ppt.setInType(true);
            } else if (type.equalsIgnoreCase("out")) {
                ppt.setOutType(true);
            } else if (type.equalsIgnoreCase("inout")) {
                ppt.setInType(true);
                ppt.setOutType(true);
            } else if (type.equalsIgnoreCase("return")) {
                ppt.setOutType(true);
                ppt.setReturnType(true);
            } else {
                throw new IllegalParameterTypeRuntimeException(type);
            }
            final ValueType valueType = getValueType(dtoDesc, field);
            ppt.setValueType(valueType);
            return ppt;
        }
        protected ValueType getValueType(final BeanDesc dtoDesc, final Field field) {
            final String name = annotationReader.getValueType(dtoDesc, field);
            if (name != null) {
                return valueTypeFactory.getValueTypeByName(name);
            }
            final Class type = field.getType();
            if (List.class.isAssignableFrom(type)) {// is for out parameter cursor.
                if (Sample2ConditionBeanContext.isOracle()) {
                    return ValueTypes.ORACLE_RESULT_SET;
                } else if (Sample2ConditionBeanContext.isPostgreSql()) {
                    return ValueTypes.POSTGRE_RESULT_SET;
                } else {
                    return ValueTypes.SERIALIZABLE_BYTE_ARRAY;
                }
            }
            return valueTypeFactory.getValueTypeByClass(type);
        }
        protected boolean isInstanceField(final Field field) {
            final int mod = field.getModifiers();
            return !Modifier.isStatic(mod) && !Modifier.isFinal(mod);
        }
        protected boolean isDtoType(final Class clazz) {
            return !TypeUtil.isSimpleType(clazz) && !isContainerType(clazz);
        }
        protected boolean isContainerType(final Class clazz) {
            if (clazz == null) { throw new NullPointerException("clazz"); }
            return Collection.class.isAssignableFrom(clazz) || Map.class.isAssignableFrom(clazz) || clazz.isArray();
        }
        public void setValueTypeFactory(final ValueTypeFactory valueTypeFactory) {
            this.valueTypeFactory = valueTypeFactory;
        }
    }

    protected static class InternalFieldProcedureAnnotationReader {
        protected String PROCEDURE_PARAMETER_SUFFIX;
        protected String VALUE_TYPE_SUFFIX;
        public InternalFieldProcedureAnnotationReader() {
            PROCEDURE_PARAMETER_SUFFIX = "_PROCEDURE_PARAMETER";
            VALUE_TYPE_SUFFIX = "_VALUE_TYPE";
        }
        public String getProcedureParameter(BeanDesc dtoDesc, Field field) {
            String fieldName = removeInstanceVariablePrefix(field.getName());// *Point
            String annotationName = fieldName + PROCEDURE_PARAMETER_SUFFIX;
            if (dtoDesc.hasField(annotationName)) {
                Field f = dtoDesc.getField(annotationName);
                return (String) FieldUtil.get(f, null);
            } else {
                return null;
            }
        }
        public String getValueType(BeanDesc dtoDesc, Field field) {
            String fieldName = removeInstanceVariablePrefix(field.getName());// *Point
            String annotationName = fieldName + VALUE_TYPE_SUFFIX;
            if (dtoDesc.hasField(annotationName)) {
                Field f = dtoDesc.getField(annotationName);
                return (String) FieldUtil.get(f, null);
            } else {
                return null;
            }
        }
        protected String removeInstanceVariablePrefix(String fieldName) {
            return fieldName.startsWith("_") ? fieldName.substring("_".length()) : fieldName;
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    // -----------------------------------------------------
    //                                     Sql File Encoding
    //                                     -----------------
    public String getSqlFileEncoding() {
        return sqlFileEncoding;
    }

    // -----------------------------------------------------
    //                                         Bean Enhancer
    //                                         -------------
    public BeanEnhancer getBeanEnhancer() {
        return beanEnhancer;
    }

    public void setBeanEnhancer(final BeanEnhancer beanEnhancer) {
        this.beanEnhancer = beanEnhancer;
    }

    // -----------------------------------------------------
    //                             Annotation Reader Factory
    //                             -------------------------
    public void setAnnotationReaderFactory(org.seasar.dao.AnnotationReaderFactory annotationReaderFactory) {
        this.annotationReaderFactory = annotationReaderFactory;
    }

    // -----------------------------------------------------
    //                                  Version After 1.0.47
    //                                  --------------------
    public ColumnNaming getColumnNaming() {
        return columnNaming;
    }

    public void setColumnNaming(final ColumnNaming columnNaming) {
        this.columnNaming = columnNaming;
    }

    public PropertyTypeFactoryBuilder getPropertyTypeFactoryBuilder() {
        return propertyTypeFactoryBuilder;
    }

    public void setPropertyTypeFactoryBuilder(final PropertyTypeFactoryBuilder propertyTypeFactoryBuilder) {
        this.propertyTypeFactoryBuilder = propertyTypeFactoryBuilder;
    }

    public RelationPropertyTypeFactoryBuilder getRelationPropertyTypeFactoryBuilder() {
        return relationPropertyTypeFactoryBuilder;
    }

    public void setRelationPropertyTypeFactoryBuilder(final RelationPropertyTypeFactoryBuilder relationPropertyTypeFactoryBuilder) {
        this.relationPropertyTypeFactoryBuilder = relationPropertyTypeFactoryBuilder;
    }

    public TableNaming getTableNaming() {
        return tableNaming;
    }

    public void setTableNaming(final TableNaming tableNaming) {
        this.tableNaming = tableNaming;
    }

    // -----------------------------------------------------
    //                                     DBFlute Extension
    //                                     -----------------
    public Sample2BehaviorSelector getBehaviorSelector() {
        return _behaviorSelector;
    }

    public void setBehaviorSelector(final Sample2BehaviorSelector behaviorSelector) {
        this._behaviorSelector = behaviorSelector;
    }
    
    public boolean isInternalDebug() {
        return _internalDebug;
    }

    public void setInternalDebug(final boolean internalDebug) {
        this._internalDebug = internalDebug;
    }
}
