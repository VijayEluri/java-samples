package jp.co.np.p2netex.sample2.bsbhv;


import java.util.List;

import jp.co.np.p2netex.sample2.allcommon.*;
import jp.co.np.p2netex.sample2.allcommon.bhv.load.Sample2LoadReferrerOption;
import jp.co.np.p2netex.sample2.allcommon.bhv.setup.Sample2ConditionBeanSetupper;
import jp.co.np.p2netex.sample2.allcommon.bhv.setup.Sample2ValueLabelSetupper;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2ConditionBean;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2ListResultBean;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2PagingHandler;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2PagingInvoker;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2PagingBean;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2PagingResultBean;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.Sample2DBMeta;
import jp.co.np.p2netex.sample2.exbhv.*;
import jp.co.np.p2netex.sample2.exdao.*;
import jp.co.np.p2netex.sample2.exentity.*;
import jp.co.np.p2netex.sample2.bsentity.dbmeta.*;
import jp.co.np.p2netex.sample2.cbean.*;


/**
 * The behavior of SAMPLE2_DEPT.
 * <pre>
 * [primary-key]
 *     ID
 * 
 * [column]
 *     ID, NAME, VERSION_NO
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     
 * 
 * [version-no]
 *     VERSION_NO
 * 
 * [foreign-table]
 *     
 * 
 * [referrer-table]
 *     SAMPLE2_EMP
 * 
 * [foreign-property]
 *     
 * 
 * [referrer-property]
 *     sample2EmpList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public abstract class Sample2BsSample2DeptBhv extends jp.co.np.p2netex.sample2.allcommon.bhv.Sample2AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:BehaviorQueryPathBegin*/
    /*df:BehaviorQueryPathEnd*/

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected Sample2Sample2DeptDao _dao;

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    public String getTableDbName() { return "SAMPLE2_DEPT"; }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** @return The meta data of the database. (NotNull) */
    public Sample2DBMeta getDBMeta() { return Sample2Sample2DeptDbm.getInstance(); }

    /** @return The meta data of the database as my table type. (NotNull) */
    public Sample2Sample2DeptDbm getMyDBMeta() { return Sample2Sample2DeptDbm.getInstance(); }

    // ===================================================================================
    //                                                                        Dao Accessor
    //                                                                        ============
    public Sample2Sample2DeptDao getMyDao() { return _dao; }
    public void setMyDao(Sample2Sample2DeptDao dao) { assertObjectNotNull("dao", dao); _dao = dao; }
    public Sample2DaoReadable getDaoReadable() { return getMyDao(); }
    public Sample2DaoWritable getDaoWritable() { return getMyDao(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    public Sample2Entity newEntity() { return newMyEntity(); }
    public Sample2ConditionBean newConditionBean() { return newMyConditionBean(); }
    public Sample2Sample2Dept newMyEntity() { return new Sample2Sample2Dept(); }
    public Sample2Sample2DeptCB newMyConditionBean() { return new Sample2Sample2DeptCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of the condition-bean. {IgnorePagingCondition}
     * @param cb The condition-bean of Sample2Sample2Dept. (NotNull)
     * @return The selected count.
     */
    public int selectCount(Sample2Sample2DeptCB cb) {
        assertConditionBeanNotNull(cb);
        return delegateSelectCount(cb);
    }

    // ===================================================================================
    //                                                                       Entity Select
    //                                                                       =============
    /**
     * Select the entity by the condition-bean.
     * @param cb The condition-bean of Sample2Sample2Dept. (NotNull)
     * @return The selected entity. (Nullalble)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     */
    public Sample2Sample2Dept selectEntity(final Sample2Sample2DeptCB cb) {
        return helpSelectEntityInternally(cb, new InternalSelectEntityCallback<Sample2Sample2Dept, Sample2Sample2DeptCB>() {
            public List<Sample2Sample2Dept> callbackSelectList(Sample2Sample2DeptCB cb) { return selectList(cb); } });
    }

    /**
     * Select the entity by the condition-bean with deleted check.
     * @param cb The condition-bean of Sample2Sample2Dept. (NotNull)
     * @return The selected entity. (NotNull)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     */
    public Sample2Sample2Dept selectEntityWithDeletedCheck(final Sample2Sample2DeptCB cb) {
        return helpSelectEntityWithDeletedCheckInternally(cb, new InternalSelectEntityWithDeletedCheckCallback<Sample2Sample2Dept, Sample2Sample2DeptCB>() {
            public List<Sample2Sample2Dept> callbackSelectList(Sample2Sample2DeptCB cb) { return selectList(cb); } });
    }

    /* (non-javadoc)
     * Select the entity with deleted check. {by primary-key value}
     * @param primaryKey The keys of primary.
     * @return The selected entity. (NotNull)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     */
    public Sample2Sample2Dept selectByPKValueWithDeletedCheck(java.lang.Integer id) {
        Sample2Sample2Dept entity = new Sample2Sample2Dept();
        entity.setId(id);
        final Sample2Sample2DeptCB cb = newMyConditionBean();
        cb.acceptPrimaryKeyMapString(getDBMeta().extractPrimaryKeyMapString(entity));
        return selectEntityWithDeletedCheck(cb);
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result-bean.
     * @param cb The condition-bean of Sample2Sample2Dept. (NotNull)
     * @return The result-bean of selected list. (NotNull)
     */
    public Sample2ListResultBean<Sample2Sample2Dept> selectList(Sample2Sample2DeptCB cb) {
        assertConditionBeanNotNull(cb);
        return new jp.co.np.p2netex.sample2.allcommon.cbean.Sample2ResultBeanBuilder<Sample2Sample2Dept>(getTableDbName()).buildListResultBean(cb, delegateSelectList(cb));
    }

    // ===================================================================================
    //                                                                         Page Select
    //                                                                         ===========
    /**
     * Select the page as result-bean.
     * @param cb The condition-bean of Sample2Sample2Dept. (NotNull)
     * @return The result-bean of selected page. (NotNull)
     */
    public Sample2PagingResultBean<Sample2Sample2Dept> selectPage(final Sample2Sample2DeptCB cb) {
        assertConditionBeanNotNull(cb);
        final Sample2PagingInvoker<Sample2Sample2Dept> invoker = new Sample2PagingInvoker<Sample2Sample2Dept>(getTableDbName());
        final Sample2PagingHandler<Sample2Sample2Dept> handler = new Sample2PagingHandler<Sample2Sample2Dept>() {
            public Sample2PagingBean getPagingBean() { return cb; }
            public int count() { return selectCount(cb); }
            public List<Sample2Sample2Dept> paging() { return selectList(cb); }
        };
        return invoker.invokePaging(handler);
    }

    // ===================================================================================
    //                                                                      Various Select
    //                                                                      ==============
    /**
     * Select the list of value-label.
     * @param cb The condition-bean of Sample2Sample2Dept. (NotNull)
     * @param valueLabelSetupper The setupper of value-label. (NotNull)
     * @return The list of value-label. (NotNull)
     */
    public List<java.util.Map<String, Object>> selectValueLabelList(Sample2Sample2DeptCB cb, Sample2ValueLabelSetupper<Sample2Sample2Dept> valueLabelSetupper) {
        return createValueLabelList(selectList(cb), valueLabelSetupper);
    }


    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    /**
     * Load referrer of sample2EmpList with the setupper for condition-bean of referrer. <br />
     * About internal policy, the value of primary key(and others too) is treated as case-insensitive. <br />
     * The conditionBean that the setupper provides have settings before you touch it. It is as follows:
     * <pre>
     * cb.query().setDeptId_InScope(pkList);
     * cb.query().addOrderBy_DeptId_Asc();
     * </pre>
     * @param sample2DeptList The entity list of sample2Dept. (NotNull)
     * @param conditionBeanSetupper Referrer condition setupper instance for registering referrer condition. (NotNull)
     */
    public void loadSample2EmpList(List<Sample2Sample2Dept> sample2DeptList, Sample2ConditionBeanSetupper<Sample2Sample2EmpCB> conditionBeanSetupper) {
        assertObjectNotNull("sample2DeptList<Sample2Sample2Dept>", sample2DeptList);
        assertObjectNotNull("conditionBeanSetupper<Sample2Sample2EmpCB>", conditionBeanSetupper);
        if (sample2DeptList.isEmpty()) { return; }
        loadSample2EmpList(sample2DeptList, new Sample2LoadReferrerOption<Sample2Sample2EmpCB, Sample2Sample2Emp>(conditionBeanSetupper));
    }
    /**
     * {Refer to overload method that has an argument of condition-bean setupper.}
     * @param sample2DeptList The entity list of sample2Dept. (NotNull)
     * @param loadReferrerOption the option of load-referrer. (NotNull)
     */
    public void loadSample2EmpList(List<Sample2Sample2Dept> sample2DeptList, Sample2LoadReferrerOption<Sample2Sample2EmpCB, Sample2Sample2Emp> loadReferrerOption) {
        assertObjectNotNull("sample2DeptList<Sample2Sample2Dept>", sample2DeptList);
        assertObjectNotNull("loadReferrerOption<Sample2Sample2Emp, Sample2Sample2EmpCB>", loadReferrerOption);
        if (sample2DeptList.isEmpty()) { return; }
        final Sample2Sample2EmpBhv referrerBhv = getBehaviorSelector().select(Sample2Sample2EmpBhv.class);
        helpLoadReferrerInternally(sample2DeptList, loadReferrerOption, new InternalLoadReferrerCallback<Sample2Sample2Dept, java.lang.Integer, Sample2Sample2EmpCB, Sample2Sample2Emp>() {
            public java.lang.Integer callbackBase_getPrimaryKeyValue(Sample2Sample2Dept entity) { return entity.getId(); }
            public void callbackBase_setReferrerList(Sample2Sample2Dept entity, List<Sample2Sample2Emp> referrerList) { entity.setSample2EmpList(referrerList); }
            public Sample2Sample2EmpCB callbackReferrer_newMyConditionBean() { return referrerBhv.newMyConditionBean(); }
            public void callbackReferrer_queryForeignKeyInScope(Sample2Sample2EmpCB cb, List<java.lang.Integer> pkList) { cb.query().setDeptId_InScope(pkList); }
            public void callbackReferrer_queryAddOrderByForeignKeyAsc(Sample2Sample2EmpCB cb) { cb.query().addOrderBy_DeptId_Asc(); }
            public List<Sample2Sample2Emp> callbackReferrer_selectList(Sample2Sample2EmpCB cb) { return referrerBhv.selectList(cb); }
            public java.lang.Integer callbackReferrer_getForeignKeyValue(Sample2Sample2Emp entity) { return entity.getDeptId(); }
            public void callbackReferrer_setForeignEntity(Sample2Sample2Emp referrerEntity, Sample2Sample2Dept baseEntity) { referrerEntity.setSample2Dept(baseEntity); }
        } );
    }

    // ===================================================================================
    //                                                                    Pull Out Foreign
    //                                                                    ================
  
    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity.
     * @param sample2Dept The entity of insert target. (NotNull)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void insert(Sample2Sample2Dept sample2Dept) {
        assertEntityNotNull(sample2Dept);
        delegateInsert(sample2Dept);
    }

    @Override
    protected void doCreate(Sample2Entity sample2Dept) {
        insert((Sample2Sample2Dept)sample2Dept);
    }

    /**
     * Update the entity modified-only. {UpdateCountZeroException, ConcurrencyControl}
     * @param sample2Dept The entity of update target. (NotNull) {PrimaryKeyRequired, ConcurrencyColumnRequired}
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void update(final Sample2Sample2Dept sample2Dept) {
        helpUpdateInternally(sample2Dept, new InternalUpdateCallback<Sample2Sample2Dept>() {
            public int callbackDelegateUpdate(Sample2Sample2Dept entity) { return delegateUpdate(entity); } });
    }

    @Override
    protected void doModify(Sample2Entity entity) {
        update((Sample2Sample2Dept)entity);
    }
    
    /**
     * Update the entity non-strictly modified-only. {UpdateCountZeroException, NonConcurrencyControl}
     * @param sample2Dept The entity of update target. (NotNull) {PrimaryKeyRequired}
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void updateNonstrict(final Sample2Sample2Dept sample2Dept) {
        helpUpdateNonstrictInternally(sample2Dept, new InternalUpdateNonstrictCallback<Sample2Sample2Dept>() {
            public int callbackDelegateUpdateNonstrict(Sample2Sample2Dept entity) { return delegateUpdateNonstrict(entity); } });
    }

    @Override
    protected void doModifyNonstrict(Sample2Entity entity) {
        updateNonstrict((Sample2Sample2Dept)entity);
    }

    /**
     * Insert or update the entity modified-only. {ConcurrencyControl(when update)}
     * @param sample2Dept The entity of insert or update target. (NotNull)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void insertOrUpdate(final Sample2Sample2Dept sample2Dept) {
        helpInsertOrUpdateInternally(sample2Dept, new InternalInsertOrUpdateCallback<Sample2Sample2Dept, Sample2Sample2DeptCB>() {
            public void callbackInsert(Sample2Sample2Dept entity) { insert(entity); }
            public void callbackUpdate(Sample2Sample2Dept entity) { update(entity); }
            public Sample2Sample2DeptCB callbackNewMyConditionBean() { return newMyConditionBean(); }
            public int callbackSelectCount(Sample2Sample2DeptCB cb) { return selectCount(cb); }
        });
    }

    @Override
    protected void doCreateOrUpdate(Sample2Entity sample2Dept) {
        insertOrUpdate((Sample2Sample2Dept)sample2Dept);
    }

    /**
     * Insert or update the entity non-strictly modified-only. {NonConcurrencyControl(when update)}
     * @param sample2Dept The entity of insert or update target. (NotNull)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void insertOrUpdateNonstrict(Sample2Sample2Dept sample2Dept) {
        helpInsertOrUpdateInternally(sample2Dept, new InternalInsertOrUpdateNonstrictCallback<Sample2Sample2Dept>() {
            public void callbackInsert(Sample2Sample2Dept entity) { insert(entity); }
            public void callbackUpdateNonstrict(Sample2Sample2Dept entity) { updateNonstrict(entity); }
        });
    }

    @Override
    protected void doCreateOrUpdateNonstrict(Sample2Entity entity) {
        insertOrUpdateNonstrict((Sample2Sample2Dept)entity);
    }

    /**
     * Delete the entity. {UpdateCountZeroException, ConcurrencyControl}
     * @param sample2Dept The entity of delete target. (NotNull) {PrimaryKeyRequired, ConcurrencyColumnRequired}
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(Sample2Sample2Dept sample2Dept) {
        helpDeleteInternally(sample2Dept, new InternalDeleteCallback<Sample2Sample2Dept>() {
            public int callbackDelegateDelete(Sample2Sample2Dept entity) { return delegateDelete(entity); } });
    }

    @Override
    protected void doRemove(Sample2Entity sample2Dept) {
        delete((Sample2Sample2Dept)sample2Dept);
    }

    /**
     * Delete the entity non-strictly. {UpdateCountZeroException, NonConcurrencyControl}
     * @param sample2Dept Entity. (NotNull) {PrimaryKeyRequired}
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     */
    public void deleteNonstrict(Sample2Sample2Dept sample2Dept) {
        helpDeleteNonstrictInternally(sample2Dept, new InternalDeleteNonstrictCallback<Sample2Sample2Dept>() {
            public int callbackDelegateDeleteNonstrict(Sample2Sample2Dept entity) { return delegateDeleteNonstrict(entity); } });
    }

    /**
     * Delete the entity non-strictly ignoring deleted. {UpdateCountZeroException, NonConcurrencyControl}
     * @param sample2Dept Entity. (NotNull) {PrimaryKeyRequired}
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     */
    public void deleteNonstrictIgnoreDeleted(Sample2Sample2Dept sample2Dept) {
        helpDeleteNonstrictIgnoreDeletedInternally(sample2Dept, new InternalDeleteNonstrictIgnoreDeletedCallback<Sample2Sample2Dept>() {
            public int callbackDelegateDeleteNonstrict(Sample2Sample2Dept entity) { return delegateDeleteNonstrict(entity); } });
    }


    // ===================================================================================
    //                                                                        Batch Update
    //                                                                        ============
    /**
     * Batch insert the list. This method use 'Batch Update' of java.sql.PreparedStatement.
     * @param sample2DeptList The list of the entity. (NotNull)
     * @return The array of inserted count.
     */
    public int[] batchInsert(List<Sample2Sample2Dept> sample2DeptList) {
        assertObjectNotNull("sample2DeptList", sample2DeptList);
        return delegateInsertList(sample2DeptList);
    }

    /**
     * Batch update the list. All columns are update target. {NOT modified only} <br />
     * This method use 'Batch Update' of java.sql.PreparedStatement.
     * @param sample2DeptList The list of the entity. (NotNull)
     * @return The array of updated count.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends ${glEntityAlreadyUpdateException}.
     */
    public int[] batchUpdate(List<Sample2Sample2Dept> sample2DeptList) {
        assertObjectNotNull("sample2DeptList", sample2DeptList);
        return delegateUpdateList(sample2DeptList);
    }

    /**
     * Batch update the list non-strictly. All columns are update target. {NOT modified only} <br />
     * This method use 'Batch Update' of java.sql.PreparedStatement.
     * @param sample2DeptList The list of the entity. (NotNull)
     * @return The array of updated count.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException When the entity has already been deleted.
     */
    public int[] batchUpdateNonstrict(List<Sample2Sample2Dept> sample2DeptList) {
        assertObjectNotNull("sample2DeptList", sample2DeptList);
        return delegateUpdateListNonstrict(sample2DeptList);
    }

    /**
     * Batch delete the list. <br />
     * This method use 'Batch Update' of java.sql.PreparedStatement.
     * @param sample2DeptList The list of the entity. (NotNull)
     * @return The array of deleted count.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends ${glEntityAlreadyUpdateException}.
     */
    public int[] batchDelete(List<Sample2Sample2Dept> sample2DeptList) {
        assertObjectNotNull("sample2DeptList", sample2DeptList);
        return delegateDeleteList(sample2DeptList);
    }

    /**
     * Batch delete the list non-strictly. <br />
     * This method use 'Batch Update' of java.sql.PreparedStatement.
     * @param sample2DeptList The list of the entity. (NotNull)
     * @return The array of deleted count.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException When the entity has already been deleted.
     */
    public int[] batchDeleteNonstrict(List<Sample2Sample2Dept> sample2DeptList) {
        assertObjectNotNull("sample2DeptList", sample2DeptList);
        return delegateDeleteListNonstrict(sample2DeptList);
    }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    /**
     * Query update the several entities. {NoConcurrencyControl}
     * @param sample2Dept Entity. (NotNull) {PrimaryKeyNotRequired}
     * @param cb Condition-bean. (NotNull)
     * @return The updated count.
     */
    public int queryUpdate(Sample2Sample2Dept sample2Dept, Sample2Sample2DeptCB cb) {
        assertObjectNotNull("sample2Dept", sample2Dept); assertConditionBeanNotNull(cb);
        setupCommonColumnOfUpdateIfNeeds(sample2Dept);
        filterEntityOfUpdate(sample2Dept); assertEntityOfUpdate(sample2Dept);
        return getMyDao().updateByQuery(cb, sample2Dept);
    }

    /**
     * Query delete the several entities. {NoConcurrencyControl}
     * @param cb Condition-bean. (NotNull)
     * @return The deleted count.
     */
    public int queryDelete(Sample2Sample2DeptCB cb) {
        assertConditionBeanNotNull(cb);
        return getMyDao().deleteByQuery(cb);
    }

    // ===================================================================================
    //                                                                      Various Update
    //                                                                      ==============

    // ===================================================================================
    //                                                                     Delegate Method
    //                                                                     ===============
    // -----------------------------------------------------
    //                                                Select
    //                                                ------
    protected int delegateGetCountAll() { return getMyDao().getCountAll(); }
    protected List<Sample2Sample2Dept> delegateGetListAll() { return getMyDao().getListAll(); }
    protected Sample2Sample2Dept delegateGetEntity(java.lang.Integer id) { return getMyDao().getEntity(id); }
    protected int delegateSelectCount(Sample2Sample2DeptCB cb) { assertConditionBeanNotNull(cb); return getMyDao().selectCount(cb); }
    protected List<Sample2Sample2Dept> delegateSelectList(Sample2Sample2DeptCB cb) { assertConditionBeanNotNull(cb); return getMyDao().selectList(cb); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(Sample2Sample2Dept e) { if (!processBeforeInsert(e)) { return 1; } return getMyDao().insert(e); }
    protected int delegateUpdate(Sample2Sample2Dept e) { if (!processBeforeUpdate(e)) { return 1; } return getMyDao().updateModifiedOnly(e); }
    protected int delegateUpdateNonstrict(Sample2Sample2Dept e) { if (!processBeforeUpdate(e)) { return 1; } return getMyDao().updateNonstrictModifiedOnly(e); }
    protected int delegateDelete(Sample2Sample2Dept e) { if (!processBeforeDelete(e)) { return 1; } return getMyDao().delete(e); }
    protected int delegateDeleteNonstrict(Sample2Sample2Dept e) { if (!processBeforeDelete(e)) { return 1; } return getMyDao().deleteNonstrict(e); }

    protected int[] delegateInsertList(List<Sample2Sample2Dept> ls) {
        assertObjectNotNull("sample2DeptList", ls); return getMyDao().insertList(helpFilterBeforeInsertInternally(ls));
    }
    protected int[] delegateUpdateList(List<Sample2Sample2Dept> ls) {
        assertObjectNotNull("sample2DeptList", ls); return getMyDao().updateList(helpFilterBeforeUpdateInternally(ls));
    }
    protected int[] delegateUpdateListNonstrict(List<Sample2Sample2Dept> ls) {
        assertObjectNotNull("sample2DeptList", ls); return getMyDao().updateListNonstrict(helpFilterBeforeUpdateInternally(ls));
    }
    protected int[] delegateDeleteList(List<Sample2Sample2Dept> ls) {
        assertObjectNotNull("sample2DeptList", ls); return getMyDao().deleteList(helpFilterBeforeDeleteInternally(ls));
    }
    protected int[] delegateDeleteListNonstrict(List<Sample2Sample2Dept> ls) {
        assertObjectNotNull("sample2DeptList", ls); return getMyDao().deleteListNonstrict(helpFilterBeforeDeleteInternally(ls));
    }

    // ===================================================================================
    //                                                                Optimistic Lock Info
    //                                                                ====================
    @Override
    protected boolean hasVersionNoValue(Sample2Entity entity) {
        return !(downcast(entity).getVersionNo() + "").equals("null");// For primitive type
    }

    @Override
    protected boolean hasUpdateDateValue(Sample2Entity entity) {
        return false;
    }

    // ===================================================================================
    //                                                                              Helper
    //                                                                              ======
    protected Sample2Sample2Dept downcast(Sample2Entity entity) {
        return helpDowncastInternally(entity, Sample2Sample2Dept.class);
    }
}
