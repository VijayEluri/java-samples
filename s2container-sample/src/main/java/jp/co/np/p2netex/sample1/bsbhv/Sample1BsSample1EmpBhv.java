package jp.co.np.p2netex.sample1.bsbhv;


import java.util.List;

import jp.co.np.p2netex.sample1.allcommon.*;
import jp.co.np.p2netex.sample1.allcommon.bhv.setup.Sample1ValueLabelSetupper;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1ConditionBean;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1ListResultBean;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1PagingHandler;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1PagingInvoker;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1PagingBean;
import jp.co.np.p2netex.sample1.allcommon.cbean.Sample1PagingResultBean;
import jp.co.np.p2netex.sample1.allcommon.dbmeta.Sample1DBMeta;
import jp.co.np.p2netex.sample1.exdao.*;
import jp.co.np.p2netex.sample1.exentity.*;
import jp.co.np.p2netex.sample1.bsentity.dbmeta.*;
import jp.co.np.p2netex.sample1.cbean.*;


/**
 * The behavior of SAMPLE1_EMP.
 * <pre>
 * [primary-key]
 *     ID
 * 
 * [column]
 *     ID, NAME, HIRE_DATE, DEPT_ID, VERSION_NO
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
 *     SAMPLE1_DEPT
 * 
 * [referrer-table]
 *     
 * 
 * [foreign-property]
 *     sample1Dept
 * 
 * [referrer-property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public abstract class Sample1BsSample1EmpBhv extends jp.co.np.p2netex.sample1.allcommon.bhv.Sample1AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:BehaviorQueryPathBegin*/
    /*df:BehaviorQueryPathEnd*/

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected Sample1Sample1EmpDao _dao;

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    public String getTableDbName() { return "SAMPLE1_EMP"; }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** @return The meta data of the database. (NotNull) */
    public Sample1DBMeta getDBMeta() { return Sample1Sample1EmpDbm.getInstance(); }

    /** @return The meta data of the database as my table type. (NotNull) */
    public Sample1Sample1EmpDbm getMyDBMeta() { return Sample1Sample1EmpDbm.getInstance(); }

    // ===================================================================================
    //                                                                        Dao Accessor
    //                                                                        ============
    public Sample1Sample1EmpDao getMyDao() { return _dao; }
    public void setMyDao(Sample1Sample1EmpDao dao) { assertObjectNotNull("dao", dao); _dao = dao; }
    public Sample1DaoReadable getDaoReadable() { return getMyDao(); }
    public Sample1DaoWritable getDaoWritable() { return getMyDao(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    public Sample1Entity newEntity() { return newMyEntity(); }
    public Sample1ConditionBean newConditionBean() { return newMyConditionBean(); }
    public Sample1Sample1Emp newMyEntity() { return new Sample1Sample1Emp(); }
    public Sample1Sample1EmpCB newMyConditionBean() { return new Sample1Sample1EmpCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of the condition-bean. {IgnorePagingCondition}
     * @param cb The condition-bean of Sample1Sample1Emp. (NotNull)
     * @return The selected count.
     */
    public int selectCount(Sample1Sample1EmpCB cb) {
        assertConditionBeanNotNull(cb);
        return delegateSelectCount(cb);
    }

    // ===================================================================================
    //                                                                       Entity Select
    //                                                                       =============
    /**
     * Select the entity by the condition-bean.
     * @param cb The condition-bean of Sample1Sample1Emp. (NotNull)
     * @return The selected entity. (Nullalble)
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     */
    public Sample1Sample1Emp selectEntity(final Sample1Sample1EmpCB cb) {
        return helpSelectEntityInternally(cb, new InternalSelectEntityCallback<Sample1Sample1Emp, Sample1Sample1EmpCB>() {
            public List<Sample1Sample1Emp> callbackSelectList(Sample1Sample1EmpCB cb) { return selectList(cb); } });
    }

    /**
     * Select the entity by the condition-bean with deleted check.
     * @param cb The condition-bean of Sample1Sample1Emp. (NotNull)
     * @return The selected entity. (NotNull)
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     */
    public Sample1Sample1Emp selectEntityWithDeletedCheck(final Sample1Sample1EmpCB cb) {
        return helpSelectEntityWithDeletedCheckInternally(cb, new InternalSelectEntityWithDeletedCheckCallback<Sample1Sample1Emp, Sample1Sample1EmpCB>() {
            public List<Sample1Sample1Emp> callbackSelectList(Sample1Sample1EmpCB cb) { return selectList(cb); } });
    }

    /* (non-javadoc)
     * Select the entity with deleted check. {by primary-key value}
     * @param primaryKey The keys of primary.
     * @return The selected entity. (NotNull)
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     */
    public Sample1Sample1Emp selectByPKValueWithDeletedCheck(java.lang.Integer id) {
        Sample1Sample1Emp entity = new Sample1Sample1Emp();
        entity.setId(id);
        final Sample1Sample1EmpCB cb = newMyConditionBean();
        cb.acceptPrimaryKeyMapString(getDBMeta().extractPrimaryKeyMapString(entity));
        return selectEntityWithDeletedCheck(cb);
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result-bean.
     * @param cb The condition-bean of Sample1Sample1Emp. (NotNull)
     * @return The result-bean of selected list. (NotNull)
     */
    public Sample1ListResultBean<Sample1Sample1Emp> selectList(Sample1Sample1EmpCB cb) {
        assertConditionBeanNotNull(cb);
        return new jp.co.np.p2netex.sample1.allcommon.cbean.Sample1ResultBeanBuilder<Sample1Sample1Emp>(getTableDbName()).buildListResultBean(cb, delegateSelectList(cb));
    }

    // ===================================================================================
    //                                                                         Page Select
    //                                                                         ===========
    /**
     * Select the page as result-bean.
     * @param cb The condition-bean of Sample1Sample1Emp. (NotNull)
     * @return The result-bean of selected page. (NotNull)
     */
    public Sample1PagingResultBean<Sample1Sample1Emp> selectPage(final Sample1Sample1EmpCB cb) {
        assertConditionBeanNotNull(cb);
        final Sample1PagingInvoker<Sample1Sample1Emp> invoker = new Sample1PagingInvoker<Sample1Sample1Emp>(getTableDbName());
        final Sample1PagingHandler<Sample1Sample1Emp> handler = new Sample1PagingHandler<Sample1Sample1Emp>() {
            public Sample1PagingBean getPagingBean() { return cb; }
            public int count() { return selectCount(cb); }
            public List<Sample1Sample1Emp> paging() { return selectList(cb); }
        };
        return invoker.invokePaging(handler);
    }

    // ===================================================================================
    //                                                                      Various Select
    //                                                                      ==============
    /**
     * Select the list of value-label.
     * @param cb The condition-bean of Sample1Sample1Emp. (NotNull)
     * @param valueLabelSetupper The setupper of value-label. (NotNull)
     * @return The list of value-label. (NotNull)
     */
    public List<java.util.Map<String, Object>> selectValueLabelList(Sample1Sample1EmpCB cb, Sample1ValueLabelSetupper<Sample1Sample1Emp> valueLabelSetupper) {
        return createValueLabelList(selectList(cb), valueLabelSetupper);
    }


    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============

    // ===================================================================================
    //                                                                    Pull Out Foreign
    //                                                                    ================

    /**
     * Pull out the list of foreign table 'Sample1Sample1Dept'.
     * @param sample1EmpList The list of sample1Emp. (NotNull)
     * @return The list of foreign table. (NotNull)
     */
    public List<Sample1Sample1Dept> pulloutSample1Dept(List<Sample1Sample1Emp> sample1EmpList) {
        return helpPulloutInternally(sample1EmpList, new InternalPulloutCallback<Sample1Sample1Emp, Sample1Sample1Dept>() {
            public Sample1Sample1Dept callbackGetForeignEntity(Sample1Sample1Emp entity) { return entity.getSample1Dept(); } });
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity.
     * @param sample1Emp The entity of insert target. (NotNull)
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void insert(Sample1Sample1Emp sample1Emp) {
        assertEntityNotNull(sample1Emp);
        delegateInsert(sample1Emp);
    }

    @Override
    protected void doCreate(Sample1Entity sample1Emp) {
        insert((Sample1Sample1Emp)sample1Emp);
    }

    /**
     * Update the entity modified-only. {UpdateCountZeroException, ConcurrencyControl}
     * @param sample1Emp The entity of update target. (NotNull) {PrimaryKeyRequired, ConcurrencyColumnRequired}
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void update(final Sample1Sample1Emp sample1Emp) {
        helpUpdateInternally(sample1Emp, new InternalUpdateCallback<Sample1Sample1Emp>() {
            public int callbackDelegateUpdate(Sample1Sample1Emp entity) { return delegateUpdate(entity); } });
    }

    @Override
    protected void doModify(Sample1Entity entity) {
        update((Sample1Sample1Emp)entity);
    }
    
    /**
     * Update the entity non-strictly modified-only. {UpdateCountZeroException, NonConcurrencyControl}
     * @param sample1Emp The entity of update target. (NotNull) {PrimaryKeyRequired}
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void updateNonstrict(final Sample1Sample1Emp sample1Emp) {
        helpUpdateNonstrictInternally(sample1Emp, new InternalUpdateNonstrictCallback<Sample1Sample1Emp>() {
            public int callbackDelegateUpdateNonstrict(Sample1Sample1Emp entity) { return delegateUpdateNonstrict(entity); } });
    }

    @Override
    protected void doModifyNonstrict(Sample1Entity entity) {
        updateNonstrict((Sample1Sample1Emp)entity);
    }

    /**
     * Insert or update the entity modified-only. {ConcurrencyControl(when update)}
     * @param sample1Emp The entity of insert or update target. (NotNull)
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void insertOrUpdate(final Sample1Sample1Emp sample1Emp) {
        helpInsertOrUpdateInternally(sample1Emp, new InternalInsertOrUpdateCallback<Sample1Sample1Emp, Sample1Sample1EmpCB>() {
            public void callbackInsert(Sample1Sample1Emp entity) { insert(entity); }
            public void callbackUpdate(Sample1Sample1Emp entity) { update(entity); }
            public Sample1Sample1EmpCB callbackNewMyConditionBean() { return newMyConditionBean(); }
            public int callbackSelectCount(Sample1Sample1EmpCB cb) { return selectCount(cb); }
        });
    }

    @Override
    protected void doCreateOrUpdate(Sample1Entity sample1Emp) {
        insertOrUpdate((Sample1Sample1Emp)sample1Emp);
    }

    /**
     * Insert or update the entity non-strictly modified-only. {NonConcurrencyControl(when update)}
     * @param sample1Emp The entity of insert or update target. (NotNull)
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void insertOrUpdateNonstrict(Sample1Sample1Emp sample1Emp) {
        helpInsertOrUpdateInternally(sample1Emp, new InternalInsertOrUpdateNonstrictCallback<Sample1Sample1Emp>() {
            public void callbackInsert(Sample1Sample1Emp entity) { insert(entity); }
            public void callbackUpdateNonstrict(Sample1Sample1Emp entity) { updateNonstrict(entity); }
        });
    }

    @Override
    protected void doCreateOrUpdateNonstrict(Sample1Entity entity) {
        insertOrUpdateNonstrict((Sample1Sample1Emp)entity);
    }

    /**
     * Delete the entity. {UpdateCountZeroException, ConcurrencyControl}
     * @param sample1Emp The entity of delete target. (NotNull) {PrimaryKeyRequired, ConcurrencyColumnRequired}
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(Sample1Sample1Emp sample1Emp) {
        helpDeleteInternally(sample1Emp, new InternalDeleteCallback<Sample1Sample1Emp>() {
            public int callbackDelegateDelete(Sample1Sample1Emp entity) { return delegateDelete(entity); } });
    }

    @Override
    protected void doRemove(Sample1Entity sample1Emp) {
        delete((Sample1Sample1Emp)sample1Emp);
    }

    /**
     * Delete the entity non-strictly. {UpdateCountZeroException, NonConcurrencyControl}
     * @param sample1Emp Entity. (NotNull) {PrimaryKeyRequired}
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     */
    public void deleteNonstrict(Sample1Sample1Emp sample1Emp) {
        helpDeleteNonstrictInternally(sample1Emp, new InternalDeleteNonstrictCallback<Sample1Sample1Emp>() {
            public int callbackDelegateDeleteNonstrict(Sample1Sample1Emp entity) { return delegateDeleteNonstrict(entity); } });
    }

    /**
     * Delete the entity non-strictly ignoring deleted. {UpdateCountZeroException, NonConcurrencyControl}
     * @param sample1Emp Entity. (NotNull) {PrimaryKeyRequired}
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     */
    public void deleteNonstrictIgnoreDeleted(Sample1Sample1Emp sample1Emp) {
        helpDeleteNonstrictIgnoreDeletedInternally(sample1Emp, new InternalDeleteNonstrictIgnoreDeletedCallback<Sample1Sample1Emp>() {
            public int callbackDelegateDeleteNonstrict(Sample1Sample1Emp entity) { return delegateDeleteNonstrict(entity); } });
    }


    // ===================================================================================
    //                                                                        Batch Update
    //                                                                        ============
    /**
     * Batch insert the list. This method use 'Batch Update' of java.sql.PreparedStatement.
     * @param sample1EmpList The list of the entity. (NotNull)
     * @return The array of inserted count.
     */
    public int[] batchInsert(List<Sample1Sample1Emp> sample1EmpList) {
        assertObjectNotNull("sample1EmpList", sample1EmpList);
        return delegateInsertList(sample1EmpList);
    }

    /**
     * Batch update the list. All columns are update target. {NOT modified only} <br />
     * This method use 'Batch Update' of java.sql.PreparedStatement.
     * @param sample1EmpList The list of the entity. (NotNull)
     * @return The array of updated count.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends ${glEntityAlreadyUpdateException}.
     */
    public int[] batchUpdate(List<Sample1Sample1Emp> sample1EmpList) {
        assertObjectNotNull("sample1EmpList", sample1EmpList);
        return delegateUpdateList(sample1EmpList);
    }

    /**
     * Batch update the list non-strictly. All columns are update target. {NOT modified only} <br />
     * This method use 'Batch Update' of java.sql.PreparedStatement.
     * @param sample1EmpList The list of the entity. (NotNull)
     * @return The array of updated count.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyDeletedException When the entity has already been deleted.
     */
    public int[] batchUpdateNonstrict(List<Sample1Sample1Emp> sample1EmpList) {
        assertObjectNotNull("sample1EmpList", sample1EmpList);
        return delegateUpdateListNonstrict(sample1EmpList);
    }

    /**
     * Batch delete the list. <br />
     * This method use 'Batch Update' of java.sql.PreparedStatement.
     * @param sample1EmpList The list of the entity. (NotNull)
     * @return The array of deleted count.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends ${glEntityAlreadyUpdateException}.
     */
    public int[] batchDelete(List<Sample1Sample1Emp> sample1EmpList) {
        assertObjectNotNull("sample1EmpList", sample1EmpList);
        return delegateDeleteList(sample1EmpList);
    }

    /**
     * Batch delete the list non-strictly. <br />
     * This method use 'Batch Update' of java.sql.PreparedStatement.
     * @param sample1EmpList The list of the entity. (NotNull)
     * @return The array of deleted count.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyDeletedException When the entity has already been deleted.
     */
    public int[] batchDeleteNonstrict(List<Sample1Sample1Emp> sample1EmpList) {
        assertObjectNotNull("sample1EmpList", sample1EmpList);
        return delegateDeleteListNonstrict(sample1EmpList);
    }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    /**
     * Query update the several entities. {NoConcurrencyControl}
     * @param sample1Emp Entity. (NotNull) {PrimaryKeyNotRequired}
     * @param cb Condition-bean. (NotNull)
     * @return The updated count.
     */
    public int queryUpdate(Sample1Sample1Emp sample1Emp, Sample1Sample1EmpCB cb) {
        assertObjectNotNull("sample1Emp", sample1Emp); assertConditionBeanNotNull(cb);
        setupCommonColumnOfUpdateIfNeeds(sample1Emp);
        filterEntityOfUpdate(sample1Emp); assertEntityOfUpdate(sample1Emp);
        return getMyDao().updateByQuery(cb, sample1Emp);
    }

    /**
     * Query delete the several entities. {NoConcurrencyControl}
     * @param cb Condition-bean. (NotNull)
     * @return The deleted count.
     */
    public int queryDelete(Sample1Sample1EmpCB cb) {
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
    protected List<Sample1Sample1Emp> delegateGetListAll() { return getMyDao().getListAll(); }
    protected Sample1Sample1Emp delegateGetEntity(java.lang.Integer id) { return getMyDao().getEntity(id); }
    protected int delegateSelectCount(Sample1Sample1EmpCB cb) { assertConditionBeanNotNull(cb); return getMyDao().selectCount(cb); }
    protected List<Sample1Sample1Emp> delegateSelectList(Sample1Sample1EmpCB cb) { assertConditionBeanNotNull(cb); return getMyDao().selectList(cb); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(Sample1Sample1Emp e) { if (!processBeforeInsert(e)) { return 1; } return getMyDao().insert(e); }
    protected int delegateUpdate(Sample1Sample1Emp e) { if (!processBeforeUpdate(e)) { return 1; } return getMyDao().updateModifiedOnly(e); }
    protected int delegateUpdateNonstrict(Sample1Sample1Emp e) { if (!processBeforeUpdate(e)) { return 1; } return getMyDao().updateNonstrictModifiedOnly(e); }
    protected int delegateDelete(Sample1Sample1Emp e) { if (!processBeforeDelete(e)) { return 1; } return getMyDao().delete(e); }
    protected int delegateDeleteNonstrict(Sample1Sample1Emp e) { if (!processBeforeDelete(e)) { return 1; } return getMyDao().deleteNonstrict(e); }

    protected int[] delegateInsertList(List<Sample1Sample1Emp> ls) {
        assertObjectNotNull("sample1EmpList", ls); return getMyDao().insertList(helpFilterBeforeInsertInternally(ls));
    }
    protected int[] delegateUpdateList(List<Sample1Sample1Emp> ls) {
        assertObjectNotNull("sample1EmpList", ls); return getMyDao().updateList(helpFilterBeforeUpdateInternally(ls));
    }
    protected int[] delegateUpdateListNonstrict(List<Sample1Sample1Emp> ls) {
        assertObjectNotNull("sample1EmpList", ls); return getMyDao().updateListNonstrict(helpFilterBeforeUpdateInternally(ls));
    }
    protected int[] delegateDeleteList(List<Sample1Sample1Emp> ls) {
        assertObjectNotNull("sample1EmpList", ls); return getMyDao().deleteList(helpFilterBeforeDeleteInternally(ls));
    }
    protected int[] delegateDeleteListNonstrict(List<Sample1Sample1Emp> ls) {
        assertObjectNotNull("sample1EmpList", ls); return getMyDao().deleteListNonstrict(helpFilterBeforeDeleteInternally(ls));
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
    protected Sample1Sample1Emp downcast(Sample1Entity entity) {
        return helpDowncastInternally(entity, Sample1Sample1Emp.class);
    }
}
