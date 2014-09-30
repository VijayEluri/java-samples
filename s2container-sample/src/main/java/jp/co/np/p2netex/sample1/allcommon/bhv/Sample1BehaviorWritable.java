package jp.co.np.p2netex.sample1.allcommon.bhv;

import jp.co.np.p2netex.sample1.allcommon.Sample1DaoWritable;
import jp.co.np.p2netex.sample1.allcommon.Sample1Entity;

/**
 * The interface of behavior-writable.
 * 
 * @author DBFlute(AutoGenerator)
 */
public interface Sample1BehaviorWritable extends Sample1BehaviorReadable {

    /**
     * Get dao-writable.
     * @return Dao-writable. (NotNull)
     */
    public Sample1DaoWritable getDaoWritable();

    // =====================================================================================
    //                                                                   Basic Entity Update
    //                                                                   ===================
    /**
     * Create.
     * @param entity Entity. (NotNull)
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void create(jp.co.np.p2netex.sample1.allcommon.Sample1Entity entity);

    /**
     * Modify.
     * @param entity Entity. (NotNull)
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void modify(jp.co.np.p2netex.sample1.allcommon.Sample1Entity entity);

    /**
     * Modify non-strict.
     * @param entity Entity. (NotNull)
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void modifyNonstrict(Sample1Entity entity);

    /**
     * Create or modify. <br />
     * {modify: modified only} <br />
     * This method is faster than createOrModifyAfterSelect().
     * @param entity Entity. This must contain primary-key value at least(Except use identity). (NotNull)
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void createOrModify(jp.co.np.p2netex.sample1.allcommon.Sample1Entity entity);

    /**
     * Create or modify non-strict. <br />
     * {modify: modified only} <br />
     * This method is faster than createOrModifyAfterSelect().
     * @param entity Entity. This must contain primary-key value at least(Except use identity). (NotNull)
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void createOrModifyNonstrict(jp.co.np.p2netex.sample1.allcommon.Sample1Entity entity);

    /**
     * Remove.
     * @param entity Entity. (NotNull)
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     */
    public void remove(jp.co.np.p2netex.sample1.allcommon.Sample1Entity entity);


    // =====================================================================================
    //                                                                    Basic Batch Update
    //                                                                    ==================
    /**
     * Lump create the list.
     * @param entityList Entity-list. (NotNull and NotEmpty)
     * @return The array of created count.
     */
    public int[] lumpCreate(java.util.List<Sample1Entity> entityList);

    /**
     * Lump Modify the list.
     * @param entityList Entity-list. (NotNull and NotEmpty)
     * @return Modified count.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyUpdatedException When the entity has already been updated. And Only when s2dao's version is over 1.0.47 (contains 1.0.47).
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     */
    public int[] lumpModify(java.util.List<Sample1Entity> entityList);

    /**
     * Lump remove the list.
     * @param entityList Entity-list. (NotNull and NotEmpty)
     * @return Removed count.
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityAlreadyUpdatedException When the entity has already been updated. And Only when s2dao's version is over 1.0.47 (contains 1.0.47).
     * @exception jp.co.np.p2netex.sample1.allcommon.exception.Sample1EntityDuplicatedException When the entity has been duplicated.
     */
    public int[] lumpRemove(java.util.List<Sample1Entity> entityList);
}
