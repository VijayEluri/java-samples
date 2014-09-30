package jp.co.np.p2netex.sample1.allcommon.bhv;


import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import jp.co.np.p2netex.sample1.allcommon.Sample1BehaviorSelector;
import jp.co.np.p2netex.sample1.allcommon.Sample1DaoSelector;
import jp.co.np.p2netex.sample1.allcommon.Sample1Entity;
import jp.co.np.p2netex.sample1.allcommon.bhv.setup.Sample1ValueLabelSetupper;
import jp.co.np.p2netex.sample1.allcommon.bhv.setup.Sample1ValueLabelBox;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1ConditionBeanContext;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1ConditionBean;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1ListResultBean;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1PagingHandler;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1PagingInvoker;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1PagingBean;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1PagingResultBean;
import jp.co.np.p2netex.sample1.allcommon.cbean.outsidesql.Sample1OutsideSqlDao;
import jp.co.np.p2netex.sample1.allcommon.cbean.outsidesql.executor.Sample1OutsideSqlBasicExecutor;

import jp.co.np.p2netex.sample1.allcommon.bhv.batch.Sample1TokenFileOutputOption;
import jp.co.np.p2netex.sample1.allcommon.bhv.batch.Sample1TokenFileOutputResult;

import jp.co.np.p2netex.sample1.allcommon.dbmeta.info.Sample1ColumnInfo;

import jp.co.np.p2netex.sample1.allcommon.helper.token.file.Sample1FileMakingOption;
import jp.co.np.p2netex.sample1.allcommon.helper.token.file.Sample1FileMakingHeaderInfo;
import jp.co.np.p2netex.sample1.allcommon.helper.token.file.Sample1FileMakingSimpleFacade;
import jp.co.np.p2netex.sample1.allcommon.helper.token.file.impl.Sample1FileMakingSimpleFacadeImpl;

/**
 * The abstract class of behavior-readable.
 * 
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public abstract class Sample1AbstractBehaviorReadable implements Sample1BehaviorReadable {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** Behavior-selector instance. It's basically referred at loadReferrer. (Required for loadReferrer) */
    protected Sample1BehaviorSelector _behaviorSelector;

    /** Dao-selector instance. It's basically referred at loadReferrer. (Required for OutsideSql) */
    protected Sample1DaoSelector _daoSelector;

    // =====================================================================================
    //                                                                         Basic Get All
    //                                                                         =============
    /**
     * Get count all.
     * 
     * @return Count all.
     */
    public int getCountAll() {
        return callGetCountAll();
    }

    // =====================================================================================
    //                                                                            Count Read
    //                                                                            ==========
    /**
     * The implementation.
     * @param cb Condition-bean. This condition-bean should not be set up about fetch-scope. (NotNull)
     * @return Read count. (NotNull)
     */
    public int readCount(Sample1ConditionBean cb) {
        assertConditionBeanNotNull(cb);
        return callReadCount(cb);
    }

    // =====================================================================================
    //                                                                           Entity Read 
    //                                                                           ===========
    /**
     * The implementation.
     * @param cb Condition-bean. (NotNull)
     * @return Read entity. (Nullalble)
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     */
    public Sample1Entity readEntity(Sample1ConditionBean cb) {
        assertConditionBeanNotNull(cb);
        final java.util.List<Sample1Entity> ls = readList(cb);
        if (ls.isEmpty()) {
            return null;
        }
        assertEntitySelectedAsOne(ls, cb);
        return (Sample1Entity)ls.get(0);
    }

    /**
     * The implementation.
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Read entity. (NotNull)
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     */
    public Sample1Entity readEntityWithDeletedCheck(Sample1ConditionBean cb) {
        assertConditionBeanNotNull(cb);
        final java.util.List<Sample1Entity> ls = readList(cb);
        assertEntityNotDeleted(ls, cb);
        assertEntitySelectedAsOne(ls, cb);
        return (Sample1Entity)ls.get(0);
    }

    // =====================================================================================
    //                                                           Entity Read Internal Helper
    //                                                           ===========================
    protected <ENTITY_TYPE extends Sample1Entity, CB_TYPE extends Sample1ConditionBean>
            ENTITY_TYPE helpSelectEntityInternally(CB_TYPE cb, InternalSelectEntityCallback<ENTITY_TYPE, CB_TYPE> callback) {
        assertConditionBeanNotNull(cb);
        cb.checkSafetyResult(1);
        java.util.List<ENTITY_TYPE> ls = null;
        try {
            ls = callback.callbackSelectList(cb);
        } catch (jp.co.np.p2netex.sample1.allcommon.exception.Sample1DangerousResultSizeException e) {
            throwEntityDuplicatedException("{Over safetyMaxResultSize '1'}", cb, e);
        }
        if (ls.isEmpty()) {
            return null;
        }
        assertEntitySelectedAsOne(ls, cb);
        return (ENTITY_TYPE)ls.get(0);
    }

    protected static interface InternalSelectEntityCallback<ENTITY_TYPE extends Sample1Entity, CB_TYPE extends Sample1ConditionBean> {
        public java.util.List<ENTITY_TYPE> callbackSelectList(CB_TYPE cb);
    }

    protected <ENTITY_TYPE extends Sample1Entity, CB_TYPE extends Sample1ConditionBean>
            ENTITY_TYPE helpSelectEntityWithDeletedCheckInternally(CB_TYPE cb, InternalSelectEntityWithDeletedCheckCallback<ENTITY_TYPE, CB_TYPE> callback) {
        assertConditionBeanNotNull(cb);
        cb.checkSafetyResult(1);
        java.util.List<ENTITY_TYPE> ls = null;
        try {
            ls = callback.callbackSelectList(cb);
        } catch (jp.co.np.p2netex.sample1.allcommon.exception.Sample1DangerousResultSizeException e) {
            throwEntityDuplicatedException("{Over safetyMaxResultSize '1'}", cb, e);
        }
        assertEntityNotDeleted(ls, cb);
        assertEntitySelectedAsOne(ls, cb);
        return (ENTITY_TYPE)ls.get(0);
    }

    protected static interface InternalSelectEntityWithDeletedCheckCallback<ENTITY_TYPE extends Sample1Entity, CB_TYPE extends Sample1ConditionBean> {
        public java.util.List<ENTITY_TYPE> callbackSelectList(CB_TYPE cb);
    }

    // =====================================================================================
    //                                                                             List Read
    //                                                                             =========
    /**
     * The implementation.
     * @param cb Condition-bean.
     * @return List-result-bean. If the select result is zero, it returns empty list. (NotNull)
     */
    public Sample1ListResultBean<Sample1Entity> readList(Sample1ConditionBean cb) {
        assertConditionBeanNotNull(cb);
        return new jp.co.np.p2netex.sample1.allcommon.cbean.Sample1ResultBeanBuilder<Sample1Entity>(getTableDbName()).buildListResultBean(cb, callReadList(cb));
    }

    /**
     * The implementation.
     * @param cb Condition-bean. (NotNull)
     * @return Read page. (NotNull)
     */
    public Sample1PagingResultBean<Sample1Entity> readPage(final Sample1ConditionBean cb) {
        assertConditionBeanNotNull(cb);
        final Sample1PagingInvoker<Sample1Entity> invoker = new Sample1PagingInvoker<Sample1Entity>(getTableDbName());
        final Sample1PagingHandler<Sample1Entity> handler = new Sample1PagingHandler<Sample1Entity>() {
            public Sample1PagingBean getPagingBean() { return cb; }
            public int count() { return readCount(cb); }
            public List<Sample1Entity> paging() { return readList(cb); }
        };
        return invoker.invokePaging(handler);
    }

    /**
     * Assert that the entity is not deleted.
     * @param entity Selected entity. (Nullable)
     * @param searchKey4Log Search-key for Logging.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyDeletedException When the entity has already been deleted.
     */
    protected void assertEntityNotDeleted(jp.co.np.p2netex.sample1.allcommon.Sample1Entity entity, Object searchKey4Log) {
        if (entity == null) {
            throwEntityAlreadyDeletedException(searchKey4Log);
        }
    }

    /**
     * Assert that the entity is not deleted.
     * @param ls Selected list. (Nullable)
     * @param searchKey4Log Search-key for Logging. (NotNull)
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyDeletedException
     */
    protected void assertEntityNotDeleted(java.util.List ls, Object searchKey4Log) {
        if (ls == null || ls.isEmpty()) {
            throwEntityAlreadyDeletedException(searchKey4Log);
        }
    }

    /**
     * Assert that the entity is selected as one.
     * @param ls Selected list. (NotNull)
     * @param searchKey4Log Search-key for Logging. (NotNull)
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyDeletedException
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException
     */
    protected void assertEntitySelectedAsOne(java.util.List ls, Object searchKey4Log) {
        if (ls == null || ls.isEmpty()) {
            throwEntityAlreadyDeletedException(searchKey4Log);
        }
        if (ls.size() > 1) {
            throwEntityDuplicatedException(ls.size() + "", searchKey4Log, null);
        }
    }

    private void throwEntityAlreadyDeletedException(Object searchKey4Log) {
        Sample1ConditionBeanContext.throwEntityAlreadyDeletedException(searchKey4Log);
    }

    private void throwEntityDuplicatedException(String resultCountString, Object searchKey4Log, Throwable cause) {
        Sample1ConditionBeanContext.throwEntityDuplicatedException(resultCountString, searchKey4Log, cause);
    }

    // ===================================================================================
    //                                                                      Various Select
    //                                                                      ==============
    public Sample1OutsideSqlBasicExecutor outsideSql() {
        assertDaoSelectorNotNull("outsideSql");
        final Sample1OutsideSqlDao outsideSqlDao = _daoSelector.select(Sample1OutsideSqlDao.class);
        return new Sample1OutsideSqlBasicExecutor(outsideSqlDao, getTableDbName());
    }

    private void assertDaoSelectorNotNull(String methodName) {
        if (_daoSelector == null) {
            String msg = "Look! Read the message below." + getLineSeparator();
            msg = msg + "/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *" + getLineSeparator();
            msg = msg + "Not found the selector of dao as behavior's attributed!" + getLineSeparator();
            msg = msg + getLineSeparator();
            msg = msg + "[Advice]" + getLineSeparator();
            msg = msg + "Please confirm the definition of the selector at your 'dbflute.dicon'." + getLineSeparator();
            msg = msg + "It is precondition that '" + methodName + "()' needs the selector instance." + getLineSeparator();
            msg = msg + getLineSeparator();
            msg = msg + "[Your Behavior's Attributes]" + getLineSeparator();
            msg = msg + "  _behaviorSelector  : " + _behaviorSelector + getLineSeparator();
            msg = msg + "  _daoSelector       : " + _daoSelector + getLineSeparator();
            msg = msg + "* * * * * * * * * */" + getLineSeparator();
            throw new IllegalStateException(msg);
        }
    }

    /**
     * Create value-label list.
     * @param <ENTITY> The type of entity.
     * @param entityList The list of entity. (NotNull)
     * @param valueLabelSetupper Value-label-setupper. (NotNull)
     * @return Value-label list. (NotNull)
     */
    public <ENTITY extends Sample1Entity> List<java.util.Map<String, Object>> createValueLabelList(List<ENTITY> entityList, Sample1ValueLabelSetupper<ENTITY> valueLabelSetupper) {
        final List<Map<String, Object>> valueLabelList = new ArrayList<Map<String, Object>>();
        final Sample1ValueLabelBox box = new Sample1ValueLabelBox();
        for (ENTITY entity : entityList) {
            final Map<String, Object> valueLabel = new HashMap<String, Object>();
            valueLabelSetupper.setup(box, entity);
            valueLabel.put("value", box.getValue());
            valueLabel.put("label", box.getLabel());
            valueLabelList.add(valueLabel);
        }
        return valueLabelList;
    }

    // ===================================================================================
    //                                                                            Sequence
    //                                                                            ========
    /**
     * The implementation.
     * 
     * @return The value of sequence. (NotNull)
     */
    public java.math.BigDecimal readNextVal() {
        try {
            final java.lang.reflect.Method method = getClass().getMethod("selectNextVal", new Class[]{});
            Object sequenceObject = method.invoke(this, new Object[] {});
            if (sequenceObject instanceof java.math.BigDecimal) {
                return (java.math.BigDecimal)sequenceObject;
            }
            return (java.math.BigDecimal)helpConvertingSequenceObject(java.math.BigDecimal.class, sequenceObject);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("The table does not have sequence: " + getTableDbName(), e);
        } catch (Exception e) {
            throw new RuntimeException("The selectNextVal() of the table threw the exception: " + getTableDbName(), e);
        }
    }

    protected Object helpConvertingSequenceObject(Class resultClass, Object sequenceObject) {
        try {
            final java.lang.reflect.Constructor constructor = resultClass.getConstructor(new Class[]{String.class});
            return constructor.newInstance(new Object[]{sequenceObject.toString()});
        } catch (NoSuchMethodException e) {
        } catch (Exception e) {
            throw new RuntimeException("The readNextVal() of the table threw the exception: " + getTableDbName(), e);
        }
        try {
            final java.lang.reflect.Method method = resultClass.getMethod("valueOf", new Class[]{long.class});
            return method.invoke(null, new Object[]{Long.valueOf(sequenceObject.toString())});
        } catch (NoSuchMethodException e) {
        } catch (Exception e) {
            throw new RuntimeException("The readNextVal() of the table threw the exception: " + getTableDbName(), e);
        }
        String msg = "Cannot convert sequenceObject to resultClass:";
        msg = msg + " resultClass=" + resultClass + " sequenceObjectType=" + sequenceObject.getClass();
        throw new IllegalStateException(msg);
    }

    // ===================================================================================
    //                                                       Load Referrer Internal Helper
    //                                                       =============================
    /**
     * @param <LOCAL_ENTITY_TYPE> The type of base entity.
     * @param <PK_TYPE> The type of primary key.
     * @param <REFERRER_CB_TYPE> The type of referrer condition-bean.
     * @param <REFERRER_ENTITY_TYPE> The type of referrer entity.
     * @param localEntityList The list of local entity. (NotNull)
     * @param loadReferrerOption The option of loadReferrer. (NotNull)
     * @param callback The internal call-back of loadReferrer. (NotNull) 
     */
    protected <LOCAL_ENTITY_TYPE extends Sample1Entity, PK_TYPE, REFERRER_CB_TYPE extends Sample1ConditionBean, REFERRER_ENTITY_TYPE extends Sample1Entity>
            void helpLoadRefererInternally(java.util.List<LOCAL_ENTITY_TYPE> localEntityList
                                         , jp.co.np.p2netex.sample1.allcommon.bhv.load.Sample1LoadRefererOption<REFERRER_CB_TYPE, REFERRER_ENTITY_TYPE> loadReferrerOption
                                         , InternalLoadRefererCallback<LOCAL_ENTITY_TYPE, PK_TYPE, REFERRER_CB_TYPE, REFERRER_ENTITY_TYPE> callback) {
        doHelpLoadReferrerInternally(localEntityList, loadReferrerOption, callback);
    }// Cannot deprecated because someone who overrides this method exists.

    /**
     * Help load referrer internally. <br />
     * About internal policy, the value of primary key(and others too) is treated as CaseInsensitive.
     * @param <LOCAL_ENTITY_TYPE> The type of base entity.
     * @param <PK_TYPE> The type of primary key.
     * @param <REFERRER_CB_TYPE> The type of referrer condition-bean.
     * @param <REFERRER_ENTITY_TYPE> The type of referrer entity.
     * @param localEntityList The list of local entity. (NotNull)
     * @param loadReferrerOption The option of loadReferrer. (NotNull)
     * @param callback The internal call-back of loadReferrer. (NotNull) 
     */
    protected <LOCAL_ENTITY_TYPE extends Sample1Entity, PK_TYPE, REFERRER_CB_TYPE extends Sample1ConditionBean, REFERRER_ENTITY_TYPE extends Sample1Entity>
            void helpLoadReferrerInternally(java.util.List<LOCAL_ENTITY_TYPE> localEntityList
                                         , jp.co.np.p2netex.sample1.allcommon.bhv.load.Sample1LoadReferrerOption<REFERRER_CB_TYPE, REFERRER_ENTITY_TYPE> loadReferrerOption
                                         , final InternalLoadReferrerCallback<LOCAL_ENTITY_TYPE, PK_TYPE, REFERRER_CB_TYPE, REFERRER_ENTITY_TYPE> callback) {
        final InternalLoadRefererCallback<LOCAL_ENTITY_TYPE, PK_TYPE, REFERRER_CB_TYPE, REFERRER_ENTITY_TYPE> compatibleCallback = new InternalLoadRefererCallback<LOCAL_ENTITY_TYPE, PK_TYPE, REFERRER_CB_TYPE, REFERRER_ENTITY_TYPE>() {
            public PK_TYPE callbackBase_getPrimaryKeyValue(LOCAL_ENTITY_TYPE entity) {
                return callback.callbackBase_getPrimaryKeyValue(entity);
            }
            public void callbackBase_setReferrerList(LOCAL_ENTITY_TYPE entity, List<REFERRER_ENTITY_TYPE> referrerList) {
                callback.callbackBase_setReferrerList(entity, referrerList);
            }
            public PK_TYPE callbackReferrer_getForeignKeyValue(REFERRER_ENTITY_TYPE entity) {
                return callback.callbackReferrer_getForeignKeyValue(entity);
            }
            public REFERRER_CB_TYPE callbackReferrer_newMyConditionBean() {
                return callback.callbackReferrer_newMyConditionBean();
            }
            public void callbackReferrer_queryAddOrderByForeignKeyAsc(REFERRER_CB_TYPE cb) {
                callback.callbackReferrer_queryAddOrderByForeignKeyAsc(cb);
            }
            public void callbackReferrer_queryForeignKeyInScope(REFERRER_CB_TYPE cb, List<PK_TYPE> pkList) {
                callback.callbackReferrer_queryForeignKeyInScope(cb, pkList);
            }
            public List<REFERRER_ENTITY_TYPE> callbackReferrer_selectList(REFERRER_CB_TYPE cb) {
                return callback.callbackReferrer_selectList(cb);
            }
            public void callbackReferrer_setForeignEntity(REFERRER_ENTITY_TYPE referrerEntity, LOCAL_ENTITY_TYPE localEntity) {
                callback.callbackReferrer_setForeignEntity(referrerEntity, localEntity);
            }
        };
        helpLoadRefererInternally(localEntityList, new jp.co.np.p2netex.sample1.allcommon.bhv.load.Sample1LoadRefererOption<REFERRER_CB_TYPE, REFERRER_ENTITY_TYPE>(loadReferrerOption), compatibleCallback);
    }

    /**
     * Help load referrer internally. <br />
     * About internal policy, the value of primary key(and others too) is treated as CaseInsensitive.
     * @param <LOCAL_ENTITY_TYPE> The type of base entity.
     * @param <PK_TYPE> The type of primary key.
     * @param <REFERRER_CB_TYPE> The type of referrer condition-bean.
     * @param <REFERRER_ENTITY_TYPE> The type of referrer entity.
     * @param localEntityList The list of local entity. (NotNull)
     * @param loadReferrerOption The option of loadReferrer. (NotNull)
     * @param callback The internal call-back of loadReferrer. (NotNull) 
     */
    protected <LOCAL_ENTITY_TYPE extends Sample1Entity, PK_TYPE, REFERRER_CB_TYPE extends Sample1ConditionBean, REFERRER_ENTITY_TYPE extends Sample1Entity>
            void doHelpLoadReferrerInternally(java.util.List<LOCAL_ENTITY_TYPE> localEntityList
                                         , jp.co.np.p2netex.sample1.allcommon.bhv.load.Sample1LoadReferrerOption<REFERRER_CB_TYPE, REFERRER_ENTITY_TYPE> loadReferrerOption
                                         , InternalLoadReferrerCallback<LOCAL_ENTITY_TYPE, PK_TYPE, REFERRER_CB_TYPE, REFERRER_ENTITY_TYPE> callback) {

        // - - - - - - - - - - -
        // Assert pre-condition
        // - - - - - - - - - - -
        assertBehaviorSelectorNotNull("loadReferrer");
        assertObjectNotNull("localEntityList", localEntityList);
        assertObjectNotNull("loadReferrerOption", loadReferrerOption);
        if (localEntityList.isEmpty()) {
            return;
        }

        // - - - - - - - - - - - - - -
        // Prepare temporary container
        // - - - - - - - - - - - - - -
        final java.util.Map<PK_TYPE, LOCAL_ENTITY_TYPE> pkBaseEntityMap = new java.util.LinkedHashMap<PK_TYPE, LOCAL_ENTITY_TYPE>();
        final java.util.List<PK_TYPE> pkList = new java.util.ArrayList<PK_TYPE>();
        for (LOCAL_ENTITY_TYPE localEntity : localEntityList) {
            final PK_TYPE primaryKeyValue = callback.callbackBase_getPrimaryKeyValue(localEntity);
            pkList.add(callback.callbackBase_getPrimaryKeyValue(localEntity));
            pkBaseEntityMap.put(toLowerCasePrimaryKeyIfString(primaryKeyValue), localEntity);
        }

        // - - - - - - - - - - - - - - - -
        // Prepare referrer condition bean
        // - - - - - - - - - - - - - - - -
        final REFERRER_CB_TYPE cb;
        if (loadReferrerOption.getReferrerConditionBean() != null) {
            cb = loadReferrerOption.getReferrerConditionBean();
        } else {
            cb = callback.callbackReferrer_newMyConditionBean();
        }

        // - - - - - - - - - - - - - -
        // Select the list of referrer
        // - - - - - - - - - - - - - -
        callback.callbackReferrer_queryForeignKeyInScope(cb, pkList);
        loadReferrerOption.delegateKeyConditionExchangingFirstWhereClauseForLastOne(cb);
        if (!loadReferrerOption.isStopOrderByKey()) {
            callback.callbackReferrer_queryAddOrderByForeignKeyAsc(cb);
            cb.getSqlComponentOfOrderByClause().exchangeFirstOrderByElementForLastOne();
        }
        loadReferrerOption.delegateConditionBeanSettingUp(cb);
        final java.util.List<REFERRER_ENTITY_TYPE> referrerList = callback.callbackReferrer_selectList(cb);
        loadReferrerOption.delegateEntitySettingUp(referrerList);

        // - - - - - - - - - - - - - - - - - - - - - - - -
        // Create the map of {primary key / referrer list}
        // - - - - - - - - - - - - - - - - - - - - - - - -
        final java.util.Map<PK_TYPE, java.util.List<REFERRER_ENTITY_TYPE>> pkReffererListMap = new java.util.LinkedHashMap<PK_TYPE, java.util.List<REFERRER_ENTITY_TYPE>>();
        for (REFERRER_ENTITY_TYPE referrerEntity : referrerList) {
            final PK_TYPE referrerListKey;
            {
                final PK_TYPE foreignKeyValue = callback.callbackReferrer_getForeignKeyValue(referrerEntity);
                referrerListKey = toLowerCasePrimaryKeyIfString(foreignKeyValue);
            }
            if (!pkReffererListMap.containsKey(referrerListKey)) {
                pkReffererListMap.put(referrerListKey, new java.util.ArrayList<REFERRER_ENTITY_TYPE>());
            }
            (pkReffererListMap.get(referrerListKey)).add(referrerEntity);

            // for Reverse Reference.
            final LOCAL_ENTITY_TYPE localEntity = pkBaseEntityMap.get(referrerListKey);
            callback.callbackReferrer_setForeignEntity(referrerEntity, localEntity);
        }

        // - - - - - - - - - - - - - - - - - -
        // Relate referrer list to base entity
        // - - - - - - - - - - - - - - - - - -
        for (LOCAL_ENTITY_TYPE localEntity : localEntityList) {
            final PK_TYPE referrerListKey;
            {
                final PK_TYPE primaryKey = callback.callbackBase_getPrimaryKeyValue(localEntity);
                referrerListKey = toLowerCasePrimaryKeyIfString(primaryKey);
            }
            if (pkReffererListMap.containsKey(referrerListKey)) {
                callback.callbackBase_setReferrerList(localEntity, pkReffererListMap.get(referrerListKey));
            } else {
                callback.callbackBase_setReferrerList(localEntity, new java.util.ArrayList<REFERRER_ENTITY_TYPE>());
            }
        }
    }

    /**
     * To lower case for primary key if the value is string.
     * @param <PK_TYPE> The type of primary key.
     * @param value The value of primary key. (Nullable)
     * @return The value of primary key. (Nullable)
     */
    protected <PK_TYPE> PK_TYPE toLowerCasePrimaryKeyIfString(PK_TYPE value) {
        return (PK_TYPE)toLowerCaseIfString(value);
    }

    /**
     * @param <LOCAL_ENTITY_TYPE> The type of base entity.
     * @param <PK_TYPE> The type of primary key.
     * @param <REFERRER_CB_TYPE> The type of referrer condition-bean.
     * @param <REFERRER_ENTITY_TYPE> The type of referrer entity.
     */
    protected static interface InternalLoadRefererCallback<LOCAL_ENTITY_TYPE extends Sample1Entity
                                                         , PK_TYPE, REFERRER_CB_TYPE extends Sample1ConditionBean
                                                         , REFERRER_ENTITY_TYPE extends Sample1Entity>
                                                  extends InternalLoadReferrerCallback<LOCAL_ENTITY_TYPE, PK_TYPE, REFERRER_CB_TYPE, REFERRER_ENTITY_TYPE> {
    }

    /**
     * @param <LOCAL_ENTITY_TYPE> The type of base entity.
     * @param <PK_TYPE> The type of primary key.
     * @param <REFERRER_CB_TYPE> The type of referrer conditionBean.
     * @param <REFERRER_ENTITY_TYPE> The type of referrer entity.
     */
    protected static interface InternalLoadReferrerCallback<LOCAL_ENTITY_TYPE extends Sample1Entity
                                                         , PK_TYPE, REFERRER_CB_TYPE extends Sample1ConditionBean
                                                         , REFERRER_ENTITY_TYPE extends Sample1Entity> {
        // For Base
        public PK_TYPE callbackBase_getPrimaryKeyValue(LOCAL_ENTITY_TYPE entity);
        public void callbackBase_setReferrerList(LOCAL_ENTITY_TYPE entity, java.util.List<REFERRER_ENTITY_TYPE> referrerList);

        // For Referrer
        public REFERRER_CB_TYPE callbackReferrer_newMyConditionBean();
        public void callbackReferrer_queryForeignKeyInScope(REFERRER_CB_TYPE cb, java.util.List<PK_TYPE> pkList);
        public void callbackReferrer_queryAddOrderByForeignKeyAsc(REFERRER_CB_TYPE cb);
        public java.util.List<REFERRER_ENTITY_TYPE> callbackReferrer_selectList(REFERRER_CB_TYPE cb);
        public PK_TYPE callbackReferrer_getForeignKeyValue(REFERRER_ENTITY_TYPE entity);
        public void callbackReferrer_setForeignEntity(REFERRER_ENTITY_TYPE referrerEntity, LOCAL_ENTITY_TYPE localEntity);
    }

    private void assertBehaviorSelectorNotNull(String methodName) {
        if (_behaviorSelector == null) {
            String msg = "Look! Read the message below." + getLineSeparator();
            msg = msg + "/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *" + getLineSeparator();
            msg = msg + "Not found the selector of behavior as behavior's attributed!" + getLineSeparator();
            msg = msg + getLineSeparator();
            msg = msg + "[Advice]" + getLineSeparator();
            msg = msg + "Please confirm the definition of the selector at your 'dbflute.dicon'." + getLineSeparator();
            msg = msg + "It is precondition that '" + methodName + "()' needs the selector instance." + getLineSeparator();
            msg = msg + getLineSeparator();
            msg = msg + "[Your Behavior's Attributes]" + getLineSeparator();
            msg = msg + "  _behaviorSelector  : " + _behaviorSelector + getLineSeparator();
            msg = msg + "  _daoSelector       : " + _daoSelector + getLineSeparator();
            msg = msg + "* * * * * * * * * */" + getLineSeparator();
            throw new IllegalStateException(msg);
        }
    }

    // ===================================================================================
    //                                                             Pullout Internal Helper
    //                                                             =======================
    protected <LOCAL_ENTITY_TYPE extends Sample1Entity, FOREIGN_ENTITY_TYPE extends Sample1Entity>
            java.util.List<FOREIGN_ENTITY_TYPE> helpPulloutInternally(java.util.List<LOCAL_ENTITY_TYPE> localEntityList, InternalPulloutCallback<LOCAL_ENTITY_TYPE, FOREIGN_ENTITY_TYPE> callback) {
        assertObjectNotNull("localEntityList", localEntityList);
        final java.util.Set<FOREIGN_ENTITY_TYPE> foreignSet = new java.util.LinkedHashSet<FOREIGN_ENTITY_TYPE>();
        for (LOCAL_ENTITY_TYPE entity : localEntityList) {
            final FOREIGN_ENTITY_TYPE foreignEntity = callback.callbackGetForeignEntity(entity);
            if (foreignEntity == null || foreignSet.contains(foreignEntity)) {
                continue;
            }
            foreignSet.add(foreignEntity);
        }
        return new java.util.ArrayList<FOREIGN_ENTITY_TYPE>(foreignSet);
    }

    protected static interface InternalPulloutCallback<LOCAL_ENTITY_TYPE extends Sample1Entity, FOREIGN_ENTITY_TYPE extends Sample1Entity> {
        public FOREIGN_ENTITY_TYPE callbackGetForeignEntity(LOCAL_ENTITY_TYPE entity);
    }

    // ===================================================================================
    //                                                                          Token File
    //                                                                          ==========
    public TokenFileOutputExecutor tokenFileOutput() throws java.io.FileNotFoundException, java.io.IOException {
        return new TokenFileOutputExecutor();
    }

    public class TokenFileOutputExecutor {

        /**
         * Output token-file from this table records.
         * 
         * @param cb Condition-bean. (NotNull)
         * @param filename Name of the file. (NotNull and NotEmpty)
         * @param tokenFileOutputOption token-file-output-option. (NotNull and Required{delimiter and encoding})
         * @return Token-file-output-result. (NotNull)
         * @throws java.io.FileNotFoundException
         * @throws java.io.IOException
         */
        public Sample1TokenFileOutputResult outputTokenFile(Sample1ConditionBean cb, String filename, Sample1TokenFileOutputOption tokenFileOutputOption) throws java.io.FileNotFoundException, java.io.IOException {
            assertConditionBeanNotNull(cb);
            assertStringNotNullAndNotTrimmedEmpty("filename", filename);
            assertObjectNotNull("tokenFileOutputOption", tokenFileOutputOption);

            final java.util.List<Sample1Entity> ls = readList(cb);
            java.util.List<java.util.List<String>> rowList = new java.util.ArrayList<java.util.List<String>>();
            for (java.util.Iterator ite = ls.iterator(); ite.hasNext(); ) {
                final Sample1Entity entity = (Sample1Entity)ite.next();
                final java.util.List<String> valueList = getDBMeta().convertToColumnStringValueList(entity);
                rowList.add(valueList);
            }
            final Sample1FileMakingSimpleFacade fileMakingSimpleFacade = new Sample1FileMakingSimpleFacadeImpl();
            final Sample1FileMakingOption fileMakingOption = tokenFileOutputOption.getFileMakingOption();
            final Sample1FileMakingHeaderInfo fileMakingHeaderInfo = new Sample1FileMakingHeaderInfo();
            final java.util.List<String> columnDbNameList = new java.util.ArrayList<String>();
            for (final java.util.Iterator ite = getDBMeta().getColumnInfoList().iterator(); ite.hasNext(); ) {
                final Sample1ColumnInfo columnInfo = (Sample1ColumnInfo)ite.next();
                columnDbNameList.add(columnInfo.getColumnDbName());
            }
            fileMakingHeaderInfo.setColumnNameList(columnDbNameList);
            fileMakingOption.setFileMakingHeaderInfo(fileMakingHeaderInfo);
            fileMakingSimpleFacade.makeFromRowList(filename, rowList, fileMakingOption);
            final Sample1TokenFileOutputResult tokeFileOutputResult = new Sample1TokenFileOutputResult();
            tokeFileOutputResult.setSelectedList(ls);
            return tokeFileOutputResult;
        }
    }

    // ===================================================================================
    //                                                                     Delegate Method
    //                                                                     ===============
    /**
     * The implementation.
     * @return All count.
     */
    protected int callGetCountAll() {
        final java.lang.reflect.Method mtd = getMethod(getDaoReadable().getClass(), "getCountAll", new Class[]{});
        final Object result = invoke(mtd, getDaoReadable(), new Object[]{});
        return ((Integer)result).intValue();
    }

    /**
     * The implementation.
     * @return All list. (NotNull)
     */
    protected java.util.List<Sample1Entity> callGetListAll() {
        final java.lang.reflect.Method mtd = getMethod(getDaoReadable().getClass(), "getListAll", new Class[]{});
        final Object result = invoke(mtd, getDaoReadable(), new Object[]{});
        return (java.util.List<Sample1Entity>)result;
    }

    /**
     * The implementation.
     * @param cb Condition-bean that the type is condition-bean-interface. (NotNull)
     * @return Read count. (NotNull)
     */
    protected int callReadCount(Sample1ConditionBean cb) {
        assertConditionBeanNotNull(cb);
        final Class[] types = new Class[]{cb.getClass()};
        final java.lang.reflect.Method mtd = getMethod(getDaoReadable().getClass(), "selectCount", types);
        final Object result = invoke(mtd, getDaoReadable(), new Object[]{cb});
        return ((Integer)result).intValue();
    }

    /**
     * The implementation.
     * @param cb Condition-bean that the type is condition-bean-interface. (NotNull)
     * @return Read list. If the select result is zero, it returns empty list. (NotNull)
     */
    protected java.util.List<Sample1Entity> callReadList(Sample1ConditionBean cb) {
        assertConditionBeanNotNull(cb);
        final Class[] types = new Class[]{cb.getClass()};
        final java.lang.reflect.Method mtd = getMethod(getDaoReadable().getClass(), "selectList", types);
        final Object result = invoke(mtd, getDaoReadable(), new Object[]{cb});
        return (java.util.List<Sample1Entity>)result;
    }

    private java.lang.reflect.Method getMethod(Class clazz, String methodName, Class[] argTypes) {
        try {
            return clazz.getMethod(methodName, argTypes);
        } catch (NoSuchMethodException ex) {
            String msg = "class=" + clazz + " method=" + methodName + "-" + java.util.Arrays.asList(argTypes);
            throw new RuntimeException(msg, ex);
        }
    }

    private Object invoke(java.lang.reflect.Method method, Object target, Object[] args) {
        try {
            return method.invoke(target, args);
        } catch (java.lang.reflect.InvocationTargetException ex) {
            Throwable t = ex.getCause();
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            }
            if (t instanceof Error) {
                throw (Error) t;
            }
            String msg = "target=" + target + " method=" + method + "-" + java.util.Arrays.asList(args);
            throw new RuntimeException(msg, ex);
        } catch (IllegalAccessException ex) {
            String msg = "target=" + target + " method=" + method + "-" + java.util.Arrays.asList(args);
            throw new RuntimeException(msg, ex);
        }
    }

    // ===================================================================================
    //                                                                Optimistic Lock Info
    //                                                                ====================
    protected abstract boolean hasVersionNoValue(Sample1Entity entity);
    protected abstract boolean hasUpdateDateValue(Sample1Entity entity);

    // ===================================================================================
    //                                                                              Helper
    //                                                                              ======
    /**
     * To lower case if the type is String.
     * 
     * @param obj Object. (Nullable)
     * @return Lower object. (Nullable)
     */
    protected Object toLowerCaseIfString(Object obj) {
        if (obj != null && obj instanceof String) {
            return ((String)obj).toLowerCase();
        }
        return obj;
    }

    /**
     * Get the value of line separator.
     * 
     * @return The value of line separator. (NotNull)
     */
    protected String getLineSeparator() {
        return System.getProperty("line.separator");
    }

    protected <ENTITY_TYPE extends Sample1Entity> ENTITY_TYPE helpDowncastInternally(Sample1Entity entity, Class<ENTITY_TYPE> clazz) {
        assertObjectNotNull("entity", entity);
        assertObjectNotNull("clazz", clazz);
        try {
            return (ENTITY_TYPE)entity;
        } catch (ClassCastException e) {
            String msg = "The entity should be " + clazz.getSimpleName() + " but it was: " + entity.getClass();
            throw new RuntimeException(msg, e);
        }
    }

    // ----------------------------------------------------------------
    //                                                    Assert Object
    //                                                    -------------
    /**
     * Assert that the object is not null.
     * 
     * @param variableName Variable name. (NotNull)
     * @param value Value. (NotNull)
     * @exception IllegalArgumentException
     */
    protected void assertObjectNotNull(String variableName, Object value) {
        if (variableName == null) {
            String msg = "The value should not be null: variableName=" + variableName + " value=" + value;
            throw new IllegalArgumentException(msg);
        }
        if (value == null) {
            String msg = "The value should not be null: variableName=" + variableName;
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * Assert that the entity is not null.
     * 
     * @param entity Entity. (NotNull)
     */
    protected void assertEntityNotNull(Sample1Entity entity) {
        assertObjectNotNull("entity", entity);
    }

    /**
     * Assert that the condition-bean is not null.
     * 
     * @param cb Condition-bean. (NotNull)
     */
    protected void assertConditionBeanNotNull(jp.co.np.p2netex.sample1.allcommon.cbean.Sample1ConditionBean cb) {
        assertObjectNotNull("cb", cb);
    }

    /**
     * Assert that the entity has primary-key value.
     * 
     * @param entity Entity. (NotNull)
     */
    protected void assertEntityNotNullAndHasPrimaryKeyValue(Sample1Entity entity) {
        assertEntityNotNull(entity);
        if (!entity.hasPrimaryKeyValue()) {
            String msg = "The entity must should primary-key: entity=" + entity;
            throw new IllegalArgumentException(msg + entity);
        }
    }

    // ----------------------------------------------------------------
    //                                                    Assert String
    //                                                    -------------
    /**
     * Assert that the entity is not null and not trimmed empty.
     * 
     * @param variableName Variable name. (NotNull)
     * @param value Value. (NotNull)
     */
    protected void assertStringNotNullAndNotTrimmedEmpty(String variableName, String value) {
        assertObjectNotNull("variableName", variableName);
        assertObjectNotNull(variableName, value);
        if (value.trim().length() ==0) {
            String msg = "The value should not be empty: variableName=" + variableName + " value=" + value;
            throw new IllegalArgumentException(msg);
        }
    }

    // ----------------------------------------------------------------
    //                                                      Assert List
    //                                                      -----------
    /**
     * Assert that the list is empty.
     * 
     * @param ls List. (NotNull)
     */
    protected void assertListNotNullAndEmpty(java.util.List ls) {
        assertObjectNotNull("ls", ls);
        if (!ls.isEmpty()) {
            String msg = "The list should be empty: ls=" + ls.toString();
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * Assert that the list is not empty.
     * 
     * @param ls List. (NotNull)
     */
    protected void assertListNotNullAndNotEmpty(java.util.List ls) {
        assertObjectNotNull("ls", ls);
        if (ls.isEmpty()) {
            String msg = "The list should not be empty: ls=" + ls.toString();
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * Assert that the list having only one.
     * 
     * @param ls List. (NotNull)
     */
    protected void assertListNotNullAndHasOnlyOne(java.util.List ls) {
        assertObjectNotNull("ls", ls);
        if (ls.size() != 1) {
            String msg = "The list should contain only one object: ls=" + ls.toString();
            throw new IllegalArgumentException(msg);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * Get the selector of behavior.
     * 
     * @return The select of behavior. (Nullable: But normally NotNull)
     */
    protected Sample1BehaviorSelector getBehaviorSelector() {
        return _behaviorSelector;
    }

    /**
     * Set the selector of behavior.
     * 
     * @param behaviorSelector The selector of behavior. (NotNull)
     */
    public void setBehaviorSelector(Sample1BehaviorSelector behaviorSelector) {
        this._behaviorSelector = behaviorSelector;
    }

    /**
     * Get the selector of dao.
     * 
     * @return The select of behavior. (Nullable: But normally NotNull)
     */
    protected Sample1DaoSelector getDaoSelector() {
        return _daoSelector;
    }

    /**
     * Set the selector of dao.
     * 
     * @param daoSelector The selector of dao. (NotNull)
     */
    public void setDaoSelector(Sample1DaoSelector daoSelector) {
        _daoSelector = daoSelector;
    }
}
