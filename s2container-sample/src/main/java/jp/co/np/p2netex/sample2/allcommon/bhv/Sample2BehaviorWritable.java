package jp.co.np.p2netex.sample2.allcommon.bhv;

import jp.co.np.p2netex.sample2.allcommon.Sample2DaoWritable;
import jp.co.np.p2netex.sample2.allcommon.Sample2Entity;

/**
 * The interface of behavior-writable.
 * 
 * @author DBFlute(AutoGenerator)
 */
public interface Sample2BehaviorWritable extends Sample2BehaviorReadable {

    /**
     * Get dao-writable.
     * @return Dao-writable. (NotNull)
     */
    public Sample2DaoWritable getDaoWritable();

    // =====================================================================================
    //                                                                   Basic Entity Update
    //                                                                   ===================
    /**
     * Create.
     * @param entity Entity. (NotNull)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void create(jp.co.np.p2netex.sample2.allcommon.Sample2Entity entity);

    /**
     * Modify.
     * @param entity Entity. (NotNull)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void modify(jp.co.np.p2netex.sample2.allcommon.Sample2Entity entity);

    /**
     * Modify non-strict.
     * @param entity Entity. (NotNull)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void modifyNonstrict(Sample2Entity entity);

    /**
     * Create or modify. <br />
     * {modify: modified only} <br />
     * This method is faster than createOrModifyAfterSelect().
     * @param entity Entity. This must contain primary-key value at least(Except use identity). (NotNull)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void createOrModify(jp.co.np.p2netex.sample2.allcommon.Sample2Entity entity);

    /**
     * Create or modify non-strict. <br />
     * {modify: modified only} <br />
     * This method is faster than createOrModifyAfterSelect().
     * @param entity Entity. This must contain primary-key value at least(Except use identity). (NotNull)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void createOrModifyNonstrict(jp.co.np.p2netex.sample2.allcommon.Sample2Entity entity);

    /**
     * Remove.
     * @param entity Entity. (NotNull)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     */
    public void remove(jp.co.np.p2netex.sample2.allcommon.Sample2Entity entity);


    // =====================================================================================
    //                                                                    Basic Batch Update
    //                                                                    ==================
    /**
     * Lump create the list.
     * @param entityList Entity-list. (NotNull and NotEmpty)
     * @return The array of created count.
     */
    public int[] lumpCreate(java.util.List<Sample2Entity> entityList);

    /**
     * Lump Modify the list.
     * @param entityList Entity-list. (NotNull and NotEmpty)
     * @return Modified count.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyUpdatedException When the entity has already been updated. And Only when s2dao's version is over 1.0.47 (contains 1.0.47).
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     */
    public int[] lumpModify(java.util.List<Sample2Entity> entityList);

    /**
     * Lump remove the list.
     * @param entityList Entity-list. (NotNull and NotEmpty)
     * @return Removed count.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyUpdatedException When the entity has already been updated. And Only when s2dao's version is over 1.0.47 (contains 1.0.47).
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     */
    public int[] lumpRemove(java.util.List<Sample2Entity> entityList);
}
