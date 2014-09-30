package jp.co.np.p2netex.sample1.bsbhv;


import java.util.List;

import jp.co.np.p2netex.sample1.allcommon.*;
import jp.co.np.p2netex.sample1.allcommon.bhv.load.Sample1LoadReferrerOption;
import jp.co.np.p2netex.sample1.allcommon.bhv.setup.Sample1ConditionBeanSetupper;
import jp.co.np.p2netex.sample1.allcommon.bhv.setup.Sample1ValueLabelSetupper;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1ConditionBean;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1ListResultBean;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1PagingHandler;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1PagingInvoker;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1PagingBean;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1PagingResultBean;
import jp.co.np.p2netex.sample1.allcommon.dbmeta.Sample1DBMeta;
import jp.co.np.p2netex.sample1.exbhv.*;
import jp.co.np.p2netex.sample1.exdao.*;
import jp.co.np.p2netex.sample1.exentity.*;
import jp.co.np.p2netex.sample1.bsentity.dbmeta.*;
import jp.co.np.p2netex.sample1.cbean.*;


/**
 * The behavior of SAMPLE1_DEPT.
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
 *     SAMPLE1_EMP
 * 
 * [foreign-property]
 *     
 * 
 * [referrer-property]
 *     sample1EmpList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public abstract class Sample1BsSample1DeptBhv extends jp.co.np.p2netex.sample1.allcommon.bhv.Sample1AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:BehaviorQueryPathBegin*/
    /*df:BehaviorQueryPathEnd*/

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected Sample1Sample1DeptDao _dao;

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    public String getTableDbName() { return "SAMPLE1_DEPT"; }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** @return The meta data of the database. (NotNull) */
    public Sample1DBMeta getDBMeta() { return Sample1Sample1DeptDbm.getInstance(); }

    /** @return The meta data of the database as my table type. (NotNull) */
    public Sample1Sample1DeptDbm getMyDBMeta() { return Sample1Sample1DeptDbm.getInstance(); }

    // ===================================================================================
    //                                                                        Dao Accessor
    //                                                                        ============
    public Sample1Sample1DeptDao getMyDao() { return _dao; }
    public void setMyDao(Sample1Sample1DeptDao dao) { assertObjectNotNull("dao", dao); _dao = dao; }
    public Sample1DaoReadable getDaoReadable() { return getMyDao(); }
    public Sample1DaoWritable getDaoWritable() { return getMyDao(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    public Sample1Entity newEntity() { return newMyEntity(); }
    public Sample1ConditionBean newConditionBean() { return newMyConditionBean(); }
    public Sample1Sample1Dept newMyEntity() { return new Sample1Sample1Dept(); }
    public Sample1Sample1DeptCB newMyConditionBean() { return new Sample1Sample1DeptCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of the condition-bean. {IgnorePagingCondition}
     * @param cb The condition-bean of Sample1Sample1Dept. (NotNull)
     * @return The selected count.
     */
    public int selectCount(Sample1Sample1DeptCB cb) {
        assertConditionBeanNotNull(cb);
        return delegateSelectCount(cb);
    }

    // ===================================================================================
    //                                                                       Entity Select
    //                                                                       =============
    /**
     * Select the entity by the condition-bean.
     * @param cb The condition-bean of Sample1Sample1Dept. (NotNull)
     * @return The selected entity. (Nullalble)
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     */
    public Sample1Sample1Dept selectEntity(final Sample1Sample1DeptCB cb) {
        return helpSelectEntityInternally(cb, new InternalSelectEntityCallback<Sample1Sample1Dept, Sample1Sample1DeptCB>() {
            public List<Sample1Sample1Dept> callbackSelectList(Sample1Sample1DeptCB cb) { return selectList(cb); } });
    }

    /**
     * Select the entity by the condition-bean with deleted check.
     * @param cb The condition-bean of Sample1Sample1Dept. (NotNull)
     * @return The selected entity. (NotNull)
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     */
    public Sample1Sample1Dept selectEntityWithDeletedCheck(final Sample1Sample1DeptCB cb) {
        return helpSelectEntityWithDeletedCheckInternally(cb, new InternalSelectEntityWithDeletedCheckCallback<Sample1Sample1Dept, Sample1Sample1DeptCB>() {
            public List<Sample1Sample1Dept> callbackSelectList(Sample1Sample1DeptCB cb) { return selectList(cb); } });
    }

    /* (non-javadoc)
     * Select the entity with deleted check. {by primary-key value}
     * @param primaryKey The keys of primary.
     * @return The selected entity. (NotNull)
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     */
    public Sample1Sample1Dept selectByPKValueWithDeletedCheck(java.lang.Integer id) {
        Sample1Sample1Dept entity = new Sample1Sample1Dept();
        entity.setId(id);
        final Sample1Sample1DeptCB cb = newMyConditionBean();
        cb.acceptPrimaryKeyMapString(getDBMeta().extractPrimaryKeyMapString(entity));
        return selectEntityWithDeletedCheck(cb);
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result-bean.
     * @param cb The condition-bean of Sample1Sample1Dept. (NotNull)
     * @return The result-bean of selected list. (NotNull)
     */
    public Sample1ListResultBean<Sample1Sample1Dept> selectList(Sample1Sample1DeptCB cb) {
        assertConditionBeanNotNull(cb);
        return new jp.co.np.p2netex.sample1.allcommon.cbean.Sample1ResultBeanBuilder<Sample1Sample1Dept>(getTableDbName()).buildListResultBean(cb, delegateSelectList(cb));
    }

    // ===================================================================================
    //                                                                         Page Select
    //                                                                         ===========
    /**
     * Select the page as result-bean.
     * @param cb The condition-bean of Sample1Sample1Dept. (NotNull)
     * @return The result-bean of selected page. (NotNull)
     */
    public Sample1PagingResultBean<Sample1Sample1Dept> selectPage(final Sample1Sample1DeptCB cb) {
        assertConditionBeanNotNull(cb);
        final Sample1PagingInvoker<Sample1Sample1Dept> invoker = new Sample1PagingInvoker<Sample1Sample1Dept>(getTableDbName());
        final Sample1PagingHandler<Sample1Sample1Dept> handler = new Sample1PagingHandler<Sample1Sample1Dept>() {
            public Sample1PagingBean getPagingBean() { return cb; }
            public int count() { return selectCount(cb); }
            public List<Sample1Sample1Dept> paging() { return selectList(cb); }
        };
        return invoker.invokePaging(handler);
    }

    // ===================================================================================
    //                                                                      Various Select
    //                                                                      ==============
    /**
     * Select the list of value-label.
     * @param cb The condition-bean of Sample1Sample1Dept. (NotNull)
     * @param valueLabelSetupper The setupper of value-label. (NotNull)
     * @return The list of value-label. (NotNull)
     */
    public List<java.util.Map<String, Object>> selectValueLabelList(Sample1Sample1DeptCB cb, Sample1ValueLabelSetupper<Sample1Sample1Dept> valueLabelSetupper) {
        return createValueLabelList(selectList(cb), valueLabelSetupper);
    }


    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    /**
     * Load referrer of sample1EmpList with the setupper for condition-bean of referrer. <br />
     * About internal policy, the value of primary key(and others too) is treated as case-insensitive. <br />
     * The conditionBean that the setupper provides have settings before you touch it. It is as follows:
     * <pre>
     * cb.query().setDeptId_InScope(pkList);
     * cb.query().addOrderBy_DeptId_Asc();
     * </pre>
     * @param sample1DeptList The entity list of sample1Dept. (NotNull)
     * @param conditionBeanSetupper Referrer condition setupper instance for registering referrer condition. (NotNull)
     */
    public void loadSample1EmpList(List<Sample1Sample1Dept> sample1DeptList, Sample1ConditionBeanSetupper<Sample1Sample1EmpCB> conditionBeanSetupper) {
        assertObjectNotNull("sample1DeptList<Sample1Sample1Dept>", sample1DeptList);
        assertObjectNotNull("conditionBeanSetupper<Sample1Sample1EmpCB>", conditionBeanSetupper);
        if (sample1DeptList.isEmpty()) { return; }
        loadSample1EmpList(sample1DeptList, new Sample1LoadReferrerOption<Sample1Sample1EmpCB, Sample1Sample1Emp>(conditionBeanSetupper));
    }
    /**
     * {Refer to overload method that has an argument of condition-bean setupper.}
     * @param sample1DeptList The entity list of sample1Dept. (NotNull)
     * @param loadReferrerOption the option of load-referrer. (NotNull)
     */
    public void loadSample1EmpList(List<Sample1Sample1Dept> sample1DeptList, Sample1LoadReferrerOption<Sample1Sample1EmpCB, Sample1Sample1Emp> loadReferrerOption) {
        assertObjectNotNull("sample1DeptList<Sample1Sample1Dept>", sample1DeptList);
        assertObjectNotNull("loadReferrerOption<Sample1Sample1Emp, Sample1Sample1EmpCB>", loadReferrerOption);
        if (sample1DeptList.isEmpty()) { return; }
        final Sample1Sample1EmpBhv referrerBhv = getBehaviorSelector().select(Sample1Sample1EmpBhv.class);
        helpLoadReferrerInternally(sample1DeptList, loadReferrerOption, new InternalLoadReferrerCallback<Sample1Sample1Dept, java.lang.Integer, Sample1Sample1EmpCB, Sample1Sample1Emp>() {
            public java.lang.Integer callbackBase_getPrimaryKeyValue(Sample1Sample1Dept entity) { return entity.getId(); }
            public void callbackBase_setReferrerList(Sample1Sample1Dept entity, List<Sample1Sample1Emp> referrerList) { entity.setSample1EmpList(referrerList); }
            public Sample1Sample1EmpCB callbackReferrer_newMyConditionBean() { return referrerBhv.newMyConditionBean(); }
            public void callbackReferrer_queryForeignKeyInScope(Sample1Sample1EmpCB cb, List<java.lang.Integer> pkList) { cb.query().setDeptId_InScope(pkList); }
            public void callbackReferrer_queryAddOrderByForeignKeyAsc(Sample1Sample1EmpCB cb) { cb.query().addOrderBy_DeptId_Asc(); }
            public List<Sample1Sample1Emp> callbackReferrer_selectList(Sample1Sample1EmpCB cb) { return referrerBhv.selectList(cb); }
            public java.lang.Integer callbackReferrer_getForeignKeyValue(Sample1Sample1Emp entity) { return entity.getDeptId(); }
            public void callbackReferrer_setForeignEntity(Sample1Sample1Emp referrerEntity, Sample1Sample1Dept baseEntity) { referrerEntity.setSample1Dept(baseEntity); }
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
     * @param sample1Dept The entity of insert target. (NotNull)
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void insert(Sample1Sample1Dept sample1Dept) {
        assertEntityNotNull(sample1Dept);
        delegateInsert(sample1Dept);
    }

    @Override
    protected void doCreate(Sample1Entity sample1Dept) {
        insert((Sample1Sample1Dept)sample1Dept);
    }

    /**
     * Update the entity modified-only. {UpdateCountZeroException, ConcurrencyControl}
     * @param sample1Dept The entity of update target. (NotNull) {PrimaryKeyRequired, ConcurrencyColumnRequired}
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void update(final Sample1Sample1Dept sample1Dept) {
        helpUpdateInternally(sample1Dept, new InternalUpdateCallback<Sample1Sample1Dept>() {
            public int callbackDelegateUpdate(Sample1Sample1Dept entity) { return delegateUpdate(entity); } });
    }

    @Override
    protected void doModify(Sample1Entity entity) {
        update((Sample1Sample1Dept)entity);
    }
    
    /**
     * Update the entity non-strictly modified-only. {UpdateCountZeroException, NonConcurrencyControl}
     * @param sample1Dept The entity of update target. (NotNull) {PrimaryKeyRequired}
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void updateNonstrict(final Sample1Sample1Dept sample1Dept) {
        helpUpdateNonstrictInternally(sample1Dept, new InternalUpdateNonstrictCallback<Sample1Sample1Dept>() {
            public int callbackDelegateUpdateNonstrict(Sample1Sample1Dept entity) { return delegateUpdateNonstrict(entity); } });
    }

    @Override
    protected void doModifyNonstrict(Sample1Entity entity) {
        updateNonstrict((Sample1Sample1Dept)entity);
    }

    /**
     * Insert or update the entity modified-only. {ConcurrencyControl(when update)}
     * @param sample1Dept The entity of insert or update target. (NotNull)
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void insertOrUpdate(final Sample1Sample1Dept sample1Dept) {
        helpInsertOrUpdateInternally(sample1Dept, new InternalInsertOrUpdateCallback<Sample1Sample1Dept, Sample1Sample1DeptCB>() {
            public void callbackInsert(Sample1Sample1Dept entity) { insert(entity); }
            public void callbackUpdate(Sample1Sample1Dept entity) { update(entity); }
            public Sample1Sample1DeptCB callbackNewMyConditionBean() { return newMyConditionBean(); }
            public int callbackSelectCount(Sample1Sample1DeptCB cb) { return selectCount(cb); }
        });
    }

    @Override
    protected void doCreateOrUpdate(Sample1Entity sample1Dept) {
        insertOrUpdate((Sample1Sample1Dept)sample1Dept);
    }

    /**
     * Insert or update the entity non-strictly modified-only. {NonConcurrencyControl(when update)}
     * @param sample1Dept The entity of insert or update target. (NotNull)
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void insertOrUpdateNonstrict(Sample1Sample1Dept sample1Dept) {
        helpInsertOrUpdateInternally(sample1Dept, new InternalInsertOrUpdateNonstrictCallback<Sample1Sample1Dept>() {
            public void callbackInsert(Sample1Sample1Dept entity) { insert(entity); }
            public void callbackUpdateNonstrict(Sample1Sample1Dept entity) { updateNonstrict(entity); }
        });
    }

    @Override
    protected void doCreateOrUpdateNonstrict(Sample1Entity entity) {
        insertOrUpdateNonstrict((Sample1Sample1Dept)entity);
    }

    /**
     * Delete the entity. {UpdateCountZeroException, ConcurrencyControl}
     * @param sample1Dept The entity of delete target. (NotNull) {PrimaryKeyRequired, ConcurrencyColumnRequired}
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(Sample1Sample1Dept sample1Dept) {
        helpDeleteInternally(sample1Dept, new InternalDeleteCallback<Sample1Sample1Dept>() {
            public int callbackDelegateDelete(Sample1Sample1Dept entity) { return delegateDelete(entity); } });
    }

    @Override
    protected void doRemove(Sample1Entity sample1Dept) {
        delete((Sample1Sample1Dept)sample1Dept);
    }

    /**
     * Delete the entity non-strictly. {UpdateCountZeroException, NonConcurrencyControl}
     * @param sample1Dept Entity. (NotNull) {PrimaryKeyRequired}
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     */
    public void deleteNonstrict(Sample1Sample1Dept sample1Dept) {
        helpDeleteNonstrictInternally(sample1Dept, new InternalDeleteNonstrictCallback<Sample1Sample1Dept>() {
            public int callbackDelegateDeleteNonstrict(Sample1Sample1Dept entity) { return delegateDeleteNonstrict(entity); } });
    }

    /**
     * Delete the entity non-strictly ignoring deleted. {UpdateCountZeroException, NonConcurrencyControl}
     * @param sample1Dept Entity. (NotNull) {PrimaryKeyRequired}
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     */
    public void deleteNonstrictIgnoreDeleted(Sample1Sample1Dept sample1Dept) {
        helpDeleteNonstrictIgnoreDeletedInternally(sample1Dept, new InternalDeleteNonstrictIgnoreDeletedCallback<Sample1Sample1Dept>() {
            public int callbackDelegateDeleteNonstrict(Sample1Sample1Dept entity) { return delegateDeleteNonstrict(entity); } });
    }


    // ===================================================================================
    //                                                                        Batch Update
    //                                                                        ============
    /**
     * Batch insert the list. This method use 'Batch Update' of java.sql.PreparedStatement.
     * @param sample1DeptList The list of the entity. (NotNull)
     * @return The array of inserted count.
     */
    public int[] batchInsert(List<Sample1Sample1Dept> sample1DeptList) {
        assertObjectNotNull("sample1DeptList", sample1DeptList);
        return delegateInsertList(sample1DeptList);
    }

    /**
     * Batch update the list. All columns are update target. {NOT modified only} <br />
     * This method use 'Batch Update' of java.sql.PreparedStatement.
     * @param sample1DeptList The list of the entity. (NotNull)
     * @return The array of updated count.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends ${glEntityAlreadyUpdateException}.
     */
    public int[] batchUpdate(List<Sample1Sample1Dept> sample1DeptList) {
        assertObjectNotNull("sample1DeptList", sample1DeptList);
        return delegateUpdateList(sample1DeptList);
    }

    /**
     * Batch update the list non-strictly. All columns are update target. {NOT modified only} <br />
     * This method use 'Batch Update' of java.sql.PreparedStatement.
     * @param sample1DeptList The list of the entity. (NotNull)
     * @return The array of updated count.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyDeletedException When the entity has already been deleted.
     */
    public int[] batchUpdateNonstrict(List<Sample1Sample1Dept> sample1DeptList) {
        assertObjectNotNull("sample1DeptList", sample1DeptList);
        return delegateUpdateListNonstrict(sample1DeptList);
    }

    /**
     * Batch delete the list. <br />
     * This method use 'Batch Update' of java.sql.PreparedStatement.
     * @param sample1DeptList The list of the entity. (NotNull)
     * @return The array of deleted count.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends ${glEntityAlreadyUpdateException}.
     */
    public int[] batchDelete(List<Sample1Sample1Dept> sample1DeptList) {
        assertObjectNotNull("sample1DeptList", sample1DeptList);
        return delegateDeleteList(sample1DeptList);
    }

    /**
     * Batch delete the list non-strictly. <br />
     * This method use 'Batch Update' of java.sql.PreparedStatement.
     * @param sample1DeptList The list of the entity. (NotNull)
     * @return The array of deleted count.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyDeletedException When the entity has already been deleted.
     */
    public int[] batchDeleteNonstrict(List<Sample1Sample1Dept> sample1DeptList) {
        assertObjectNotNull("sample1DeptList", sample1DeptList);
        return delegateDeleteListNonstrict(sample1DeptList);
    }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    /**
     * Query update the several entities. {NoConcurrencyControl}
     * @param sample1Dept Entity. (NotNull) {PrimaryKeyNotRequired}
     * @param cb Condition-bean. (NotNull)
     * @return The updated count.
     */
    public int queryUpdate(Sample1Sample1Dept sample1Dept, Sample1Sample1DeptCB cb) {
        assertObjectNotNull("sample1Dept", sample1Dept); assertConditionBeanNotNull(cb);
        setupCommonColumnOfUpdateIfNeeds(sample1Dept);
        filterEntityOfUpdate(sample1Dept); assertEntityOfUpdate(sample1Dept);
        return getMyDao().updateByQuery(cb, sample1Dept);
    }

    /**
     * Query delete the several entities. {NoConcurrencyControl}
     * @param cb Condition-bean. (NotNull)
     * @return The deleted count.
     */
    public int queryDelete(Sample1Sample1DeptCB cb) {
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
    protected List<Sample1Sample1Dept> delegateGetListAll() { return getMyDao().getListAll(); }
    protected Sample1Sample1Dept delegateGetEntity(java.lang.Integer id) { return getMyDao().getEntity(id); }
    protected int delegateSelectCount(Sample1Sample1DeptCB cb) { assertConditionBeanNotNull(cb); return getMyDao().selectCount(cb); }
    protected List<Sample1Sample1Dept> delegateSelectList(Sample1Sample1DeptCB cb) { assertConditionBeanNotNull(cb); return getMyDao().selectList(cb); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(Sample1Sample1Dept e) { if (!processBeforeInsert(e)) { return 1; } return getMyDao().insert(e); }
    protected int delegateUpdate(Sample1Sample1Dept e) { if (!processBeforeUpdate(e)) { return 1; } return getMyDao().updateModifiedOnly(e); }
    protected int delegateUpdateNonstrict(Sample1Sample1Dept e) { if (!processBeforeUpdate(e)) { return 1; } return getMyDao().updateNonstrictModifiedOnly(e); }
    protected int delegateDelete(Sample1Sample1Dept e) { if (!processBeforeDelete(e)) { return 1; } return getMyDao().delete(e); }
    protected int delegateDeleteNonstrict(Sample1Sample1Dept e) { if (!processBeforeDelete(e)) { return 1; } return getMyDao().deleteNonstrict(e); }

    protected int[] delegateInsertList(List<Sample1Sample1Dept> ls) {
        assertObjectNotNull("sample1DeptList", ls); return getMyDao().insertList(helpFilterBeforeInsertInternally(ls));
    }
    protected int[] delegateUpdateList(List<Sample1Sample1Dept> ls) {
        assertObjectNotNull("sample1DeptList", ls); return getMyDao().updateList(helpFilterBeforeUpdateInternally(ls));
    }
    protected int[] delegateUpdateListNonstrict(List<Sample1Sample1Dept> ls) {
        assertObjectNotNull("sample1DeptList", ls); return getMyDao().updateListNonstrict(helpFilterBeforeUpdateInternally(ls));
    }
    protected int[] delegateDeleteList(List<Sample1Sample1Dept> ls) {
        assertObjectNotNull("sample1DeptList", ls); return getMyDao().deleteList(helpFilterBeforeDeleteInternally(ls));
    }
    protected int[] delegateDeleteListNonstrict(List<Sample1Sample1Dept> ls) {
        assertObjectNotNull("sample1DeptList", ls); return getMyDao().deleteListNonstrict(helpFilterBeforeDeleteInternally(ls));
    }

    // ===================================================================================
    //                                                                Optimistic Lock Info
    //                                                                ====================
    @Override
    protected boolean hasVersionNoValue(Sample1Entity entity) {
        return !(downcast(entity).getVersionNo() + "").equals("null");// For primitive type
    }

    @Override
    protected boolean hasUpdateDateValue(Sample1Entity entity) {
        return false;
    }

    // ===================================================================================
    //                                                                              Helper
    //                                                                              ======
    protected Sample1Sample1Dept downcast(Sample1Entity entity) {
        return helpDowncastInternally(entity, Sample1Sample1Dept.class);
    }
}
