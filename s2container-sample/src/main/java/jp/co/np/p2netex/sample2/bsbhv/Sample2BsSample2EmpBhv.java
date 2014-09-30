package jp.co.np.p2netex.sample2.bsbhv;


import java.util.List;

import jp.co.np.p2netex.sample2.allcommon.*;
import jp.co.np.p2netex.sample2.allcommon.bhv.setup.Sample2ValueLabelSetupper;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2ConditionBean;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2ListResultBean;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2PagingHandler;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2PagingInvoker;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2PagingBean;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2PagingResultBean;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.Sample2DBMeta;
import jp.co.np.p2netex.sample2.exdao.*;
import jp.co.np.p2netex.sample2.exentity.*;
import jp.co.np.p2netex.sample2.bsentity.dbmeta.*;
import jp.co.np.p2netex.sample2.cbean.*;


/**
 * The behavior of SAMPLE2_EMP.
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
 *     SAMPLE2_DEPT
 * 
 * [referrer-table]
 *     
 * 
 * [foreign-property]
 *     sample2Dept
 * 
 * [referrer-property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public abstract class Sample2BsSample2EmpBhv extends jp.co.np.p2netex.sample2.allcommon.bhv.Sample2AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:BehaviorQueryPathBegin*/
    /*df:BehaviorQueryPathEnd*/

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected Sample2Sample2EmpDao _dao;

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    public String getTableDbName() { return "SAMPLE2_EMP"; }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** @return The meta data of the database. (NotNull) */
    public Sample2DBMeta getDBMeta() { return Sample2Sample2EmpDbm.getInstance(); }

    /** @return The meta data of the database as my table type. (NotNull) */
    public Sample2Sample2EmpDbm getMyDBMeta() { return Sample2Sample2EmpDbm.getInstance(); }

    // ===================================================================================
    //                                                                        Dao Accessor
    //                                                                        ============
    public Sample2Sample2EmpDao getMyDao() { return _dao; }
    public void setMyDao(Sample2Sample2EmpDao dao) { assertObjectNotNull("dao", dao); _dao = dao; }
    public Sample2DaoReadable getDaoReadable() { return getMyDao(); }
    public Sample2DaoWritable getDaoWritable() { return getMyDao(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    public Sample2Entity newEntity() { return newMyEntity(); }
    public Sample2ConditionBean newConditionBean() { return newMyConditionBean(); }
    public Sample2Sample2Emp newMyEntity() { return new Sample2Sample2Emp(); }
    public Sample2Sample2EmpCB newMyConditionBean() { return new Sample2Sample2EmpCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of the condition-bean. {IgnorePagingCondition}
     * @param cb The condition-bean of Sample2Sample2Emp. (NotNull)
     * @return The selected count.
     */
    public int selectCount(Sample2Sample2EmpCB cb) {
        assertConditionBeanNotNull(cb);
        return delegateSelectCount(cb);
    }

    // ===================================================================================
    //                                                                       Entity Select
    //                                                                       =============
    /**
     * Select the entity by the condition-bean.
     * @param cb The condition-bean of Sample2Sample2Emp. (NotNull)
     * @return The selected entity. (Nullalble)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     */
    public Sample2Sample2Emp selectEntity(final Sample2Sample2EmpCB cb) {
        return helpSelectEntityInternally(cb, new InternalSelectEntityCallback<Sample2Sample2Emp, Sample2Sample2EmpCB>() {
            public List<Sample2Sample2Emp> callbackSelectList(Sample2Sample2EmpCB cb) { return selectList(cb); } });
    }

    /**
     * Select the entity by the condition-bean with deleted check.
     * @param cb The condition-bean of Sample2Sample2Emp. (NotNull)
     * @return The selected entity. (NotNull)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     */
    public Sample2Sample2Emp selectEntityWithDeletedCheck(final Sample2Sample2EmpCB cb) {
        return helpSelectEntityWithDeletedCheckInternally(cb, new InternalSelectEntityWithDeletedCheckCallback<Sample2Sample2Emp, Sample2Sample2EmpCB>() {
            public List<Sample2Sample2Emp> callbackSelectList(Sample2Sample2EmpCB cb) { return selectList(cb); } });
    }

    /* (non-javadoc)
     * Select the entity with deleted check. {by primary-key value}
     * @param primaryKey The keys of primary.
     * @return The selected entity. (NotNull)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     */
    public Sample2Sample2Emp selectByPKValueWithDeletedCheck(java.lang.Integer id) {
        Sample2Sample2Emp entity = new Sample2Sample2Emp();
        entity.setId(id);
        final Sample2Sample2EmpCB cb = newMyConditionBean();
        cb.acceptPrimaryKeyMapString(getDBMeta().extractPrimaryKeyMapString(entity));
        return selectEntityWithDeletedCheck(cb);
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result-bean.
     * @param cb The condition-bean of Sample2Sample2Emp. (NotNull)
     * @return The result-bean of selected list. (NotNull)
     */
    public Sample2ListResultBean<Sample2Sample2Emp> selectList(Sample2Sample2EmpCB cb) {
        assertConditionBeanNotNull(cb);
        return new jp.co.np.p2netex.sample2.allcommon.cbean.Sample2ResultBeanBuilder<Sample2Sample2Emp>(getTableDbName()).buildListResultBean(cb, delegateSelectList(cb));
    }

    // ===================================================================================
    //                                                                         Page Select
    //                                                                         ===========
    /**
     * Select the page as result-bean.
     * @param cb The condition-bean of Sample2Sample2Emp. (NotNull)
     * @return The result-bean of selected page. (NotNull)
     */
    public Sample2PagingResultBean<Sample2Sample2Emp> selectPage(final Sample2Sample2EmpCB cb) {
        assertConditionBeanNotNull(cb);
        final Sample2PagingInvoker<Sample2Sample2Emp> invoker = new Sample2PagingInvoker<Sample2Sample2Emp>(getTableDbName());
        final Sample2PagingHandler<Sample2Sample2Emp> handler = new Sample2PagingHandler<Sample2Sample2Emp>() {
            public Sample2PagingBean getPagingBean() { return cb; }
            public int count() { return selectCount(cb); }
            public List<Sample2Sample2Emp> paging() { return selectList(cb); }
        };
        return invoker.invokePaging(handler);
    }

    // ===================================================================================
    //                                                                      Various Select
    //                                                                      ==============
    /**
     * Select the list of value-label.
     * @param cb The condition-bean of Sample2Sample2Emp. (NotNull)
     * @param valueLabelSetupper The setupper of value-label. (NotNull)
     * @return The list of value-label. (NotNull)
     */
    public List<java.util.Map<String, Object>> selectValueLabelList(Sample2Sample2EmpCB cb, Sample2ValueLabelSetupper<Sample2Sample2Emp> valueLabelSetupper) {
        return createValueLabelList(selectList(cb), valueLabelSetupper);
    }


    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============

    // ===================================================================================
    //                                                                    Pull Out Foreign
    //                                                                    ================

    /**
     * Pull out the list of foreign table 'Sample2Sample2Dept'.
     * @param sample2EmpList The list of sample2Emp. (NotNull)
     * @return The list of foreign table. (NotNull)
     */
    public List<Sample2Sample2Dept> pulloutSample2Dept(List<Sample2Sample2Emp> sample2EmpList) {
        return helpPulloutInternally(sample2EmpList, new InternalPulloutCallback<Sample2Sample2Emp, Sample2Sample2Dept>() {
            public Sample2Sample2Dept callbackGetForeignEntity(Sample2Sample2Emp entity) { return entity.getSample2Dept(); } });
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity.
     * @param sample2Emp The entity of insert target. (NotNull)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void insert(Sample2Sample2Emp sample2Emp) {
        assertEntityNotNull(sample2Emp);
        delegateInsert(sample2Emp);
    }

    @Override
    protected void doCreate(Sample2Entity sample2Emp) {
        insert((Sample2Sample2Emp)sample2Emp);
    }

    /**
     * Update the entity modified-only. {UpdateCountZeroException, ConcurrencyControl}
     * @param sample2Emp The entity of update target. (NotNull) {PrimaryKeyRequired, ConcurrencyColumnRequired}
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void update(final Sample2Sample2Emp sample2Emp) {
        helpUpdateInternally(sample2Emp, new InternalUpdateCallback<Sample2Sample2Emp>() {
            public int callbackDelegateUpdate(Sample2Sample2Emp entity) { return delegateUpdate(entity); } });
    }

    @Override
    protected void doModify(Sample2Entity entity) {
        update((Sample2Sample2Emp)entity);
    }
    
    /**
     * Update the entity non-strictly modified-only. {UpdateCountZeroException, NonConcurrencyControl}
     * @param sample2Emp The entity of update target. (NotNull) {PrimaryKeyRequired}
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void updateNonstrict(final Sample2Sample2Emp sample2Emp) {
        helpUpdateNonstrictInternally(sample2Emp, new InternalUpdateNonstrictCallback<Sample2Sample2Emp>() {
            public int callbackDelegateUpdateNonstrict(Sample2Sample2Emp entity) { return delegateUpdateNonstrict(entity); } });
    }

    @Override
    protected void doModifyNonstrict(Sample2Entity entity) {
        updateNonstrict((Sample2Sample2Emp)entity);
    }

    /**
     * Insert or update the entity modified-only. {ConcurrencyControl(when update)}
     * @param sample2Emp The entity of insert or update target. (NotNull)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void insertOrUpdate(final Sample2Sample2Emp sample2Emp) {
        helpInsertOrUpdateInternally(sample2Emp, new InternalInsertOrUpdateCallback<Sample2Sample2Emp, Sample2Sample2EmpCB>() {
            public void callbackInsert(Sample2Sample2Emp entity) { insert(entity); }
            public void callbackUpdate(Sample2Sample2Emp entity) { update(entity); }
            public Sample2Sample2EmpCB callbackNewMyConditionBean() { return newMyConditionBean(); }
            public int callbackSelectCount(Sample2Sample2EmpCB cb) { return selectCount(cb); }
        });
    }

    @Override
    protected void doCreateOrUpdate(Sample2Entity sample2Emp) {
        insertOrUpdate((Sample2Sample2Emp)sample2Emp);
    }

    /**
     * Insert or update the entity non-strictly modified-only. {NonConcurrencyControl(when update)}
     * @param sample2Emp The entity of insert or update target. (NotNull)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void insertOrUpdateNonstrict(Sample2Sample2Emp sample2Emp) {
        helpInsertOrUpdateInternally(sample2Emp, new InternalInsertOrUpdateNonstrictCallback<Sample2Sample2Emp>() {
            public void callbackInsert(Sample2Sample2Emp entity) { insert(entity); }
            public void callbackUpdateNonstrict(Sample2Sample2Emp entity) { updateNonstrict(entity); }
        });
    }

    @Override
    protected void doCreateOrUpdateNonstrict(Sample2Entity entity) {
        insertOrUpdateNonstrict((Sample2Sample2Emp)entity);
    }

    /**
     * Delete the entity. {UpdateCountZeroException, ConcurrencyControl}
     * @param sample2Emp The entity of delete target. (NotNull) {PrimaryKeyRequired, ConcurrencyColumnRequired}
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(Sample2Sample2Emp sample2Emp) {
        helpDeleteInternally(sample2Emp, new InternalDeleteCallback<Sample2Sample2Emp>() {
            public int callbackDelegateDelete(Sample2Sample2Emp entity) { return delegateDelete(entity); } });
    }

    @Override
    protected void doRemove(Sample2Entity sample2Emp) {
        delete((Sample2Sample2Emp)sample2Emp);
    }

    /**
     * Delete the entity non-strictly. {UpdateCountZeroException, NonConcurrencyControl}
     * @param sample2Emp Entity. (NotNull) {PrimaryKeyRequired}
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     */
    public void deleteNonstrict(Sample2Sample2Emp sample2Emp) {
        helpDeleteNonstrictInternally(sample2Emp, new InternalDeleteNonstrictCallback<Sample2Sample2Emp>() {
            public int callbackDelegateDeleteNonstrict(Sample2Sample2Emp entity) { return delegateDeleteNonstrict(entity); } });
    }

    /**
     * Delete the entity non-strictly ignoring deleted. {UpdateCountZeroException, NonConcurrencyControl}
     * @param sample2Emp Entity. (NotNull) {PrimaryKeyRequired}
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     */
    public void deleteNonstrictIgnoreDeleted(Sample2Sample2Emp sample2Emp) {
        helpDeleteNonstrictIgnoreDeletedInternally(sample2Emp, new InternalDeleteNonstrictIgnoreDeletedCallback<Sample2Sample2Emp>() {
            public int callbackDelegateDeleteNonstrict(Sample2Sample2Emp entity) { return delegateDeleteNonstrict(entity); } });
    }


    // ===================================================================================
    //                                                                        Batch Update
    //                                                                        ============
    /**
     * Batch insert the list. This method use 'Batch Update' of java.sql.PreparedStatement.
     * @param sample2EmpList The list of the entity. (NotNull)
     * @return The array of inserted count.
     */
    public int[] batchInsert(List<Sample2Sample2Emp> sample2EmpList) {
        assertObjectNotNull("sample2EmpList", sample2EmpList);
        return delegateInsertList(sample2EmpList);
    }

    /**
     * Batch update the list. All columns are update target. {NOT modified only} <br />
     * This method use 'Batch Update' of java.sql.PreparedStatement.
     * @param sample2EmpList The list of the entity. (NotNull)
     * @return The array of updated count.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends ${glEntityAlreadyUpdateException}.
     */
    public int[] batchUpdate(List<Sample2Sample2Emp> sample2EmpList) {
        assertObjectNotNull("sample2EmpList", sample2EmpList);
        return delegateUpdateList(sample2EmpList);
    }

    /**
     * Batch update the list non-strictly. All columns are update target. {NOT modified only} <br />
     * This method use 'Batch Update' of java.sql.PreparedStatement.
     * @param sample2EmpList The list of the entity. (NotNull)
     * @return The array of updated count.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException When the entity has already been deleted.
     */
    public int[] batchUpdateNonstrict(List<Sample2Sample2Emp> sample2EmpList) {
        assertObjectNotNull("sample2EmpList", sample2EmpList);
        return delegateUpdateListNonstrict(sample2EmpList);
    }

    /**
     * Batch delete the list. <br />
     * This method use 'Batch Update' of java.sql.PreparedStatement.
     * @param sample2EmpList The list of the entity. (NotNull)
     * @return The array of deleted count.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends ${glEntityAlreadyUpdateException}.
     */
    public int[] batchDelete(List<Sample2Sample2Emp> sample2EmpList) {
        assertObjectNotNull("sample2EmpList", sample2EmpList);
        return delegateDeleteList(sample2EmpList);
    }

    /**
     * Batch delete the list non-strictly. <br />
     * This method use 'Batch Update' of java.sql.PreparedStatement.
     * @param sample2EmpList The list of the entity. (NotNull)
     * @return The array of deleted count.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException When the entity has already been deleted.
     */
    public int[] batchDeleteNonstrict(List<Sample2Sample2Emp> sample2EmpList) {
        assertObjectNotNull("sample2EmpList", sample2EmpList);
        return delegateDeleteListNonstrict(sample2EmpList);
    }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    /**
     * Query update the several entities. {NoConcurrencyControl}
     * @param sample2Emp Entity. (NotNull) {PrimaryKeyNotRequired}
     * @param cb Condition-bean. (NotNull)
     * @return The updated count.
     */
    public int queryUpdate(Sample2Sample2Emp sample2Emp, Sample2Sample2EmpCB cb) {
        assertObjectNotNull("sample2Emp", sample2Emp); assertConditionBeanNotNull(cb);
        setupCommonColumnOfUpdateIfNeeds(sample2Emp);
        filterEntityOfUpdate(sample2Emp); assertEntityOfUpdate(sample2Emp);
        return getMyDao().updateByQuery(cb, sample2Emp);
    }

    /**
     * Query delete the several entities. {NoConcurrencyControl}
     * @param cb Condition-bean. (NotNull)
     * @return The deleted count.
     */
    public int queryDelete(Sample2Sample2EmpCB cb) {
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
    protected List<Sample2Sample2Emp> delegateGetListAll() { return getMyDao().getListAll(); }
    protected Sample2Sample2Emp delegateGetEntity(java.lang.Integer id) { return getMyDao().getEntity(id); }
    protected int delegateSelectCount(Sample2Sample2EmpCB cb) { assertConditionBeanNotNull(cb); return getMyDao().selectCount(cb); }
    protected List<Sample2Sample2Emp> delegateSelectList(Sample2Sample2EmpCB cb) { assertConditionBeanNotNull(cb); return getMyDao().selectList(cb); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(Sample2Sample2Emp e) { if (!processBeforeInsert(e)) { return 1; } return getMyDao().insert(e); }
    protected int delegateUpdate(Sample2Sample2Emp e) { if (!processBeforeUpdate(e)) { return 1; } return getMyDao().updateModifiedOnly(e); }
    protected int delegateUpdateNonstrict(Sample2Sample2Emp e) { if (!processBeforeUpdate(e)) { return 1; } return getMyDao().updateNonstrictModifiedOnly(e); }
    protected int delegateDelete(Sample2Sample2Emp e) { if (!processBeforeDelete(e)) { return 1; } return getMyDao().delete(e); }
    protected int delegateDeleteNonstrict(Sample2Sample2Emp e) { if (!processBeforeDelete(e)) { return 1; } return getMyDao().deleteNonstrict(e); }

    protected int[] delegateInsertList(List<Sample2Sample2Emp> ls) {
        assertObjectNotNull("sample2EmpList", ls); return getMyDao().insertList(helpFilterBeforeInsertInternally(ls));
    }
    protected int[] delegateUpdateList(List<Sample2Sample2Emp> ls) {
        assertObjectNotNull("sample2EmpList", ls); return getMyDao().updateList(helpFilterBeforeUpdateInternally(ls));
    }
    protected int[] delegateUpdateListNonstrict(List<Sample2Sample2Emp> ls) {
        assertObjectNotNull("sample2EmpList", ls); return getMyDao().updateListNonstrict(helpFilterBeforeUpdateInternally(ls));
    }
    protected int[] delegateDeleteList(List<Sample2Sample2Emp> ls) {
        assertObjectNotNull("sample2EmpList", ls); return getMyDao().deleteList(helpFilterBeforeDeleteInternally(ls));
    }
    protected int[] delegateDeleteListNonstrict(List<Sample2Sample2Emp> ls) {
        assertObjectNotNull("sample2EmpList", ls); return getMyDao().deleteListNonstrict(helpFilterBeforeDeleteInternally(ls));
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
    protected Sample2Sample2Emp downcast(Sample2Entity entity) {
        return helpDowncastInternally(entity, Sample2Sample2Emp.class);
    }
}
