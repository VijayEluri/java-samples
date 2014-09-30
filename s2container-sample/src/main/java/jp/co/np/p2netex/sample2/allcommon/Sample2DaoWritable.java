package jp.co.np.p2netex.sample2.allcommon;

import java.util.List;

import jp.co.np.p2netex.sample2.allcommon.Sample2Entity;

/**
 * The interface of dao-writable.
 * @author DBFlute(AutoGenerator)
 */
public interface Sample2DaoWritable extends Sample2DaoReadable {

    /**
     * Insert one entity that the type is entity-interface.
     * @param entity Entity that the type is entity-interface. (NotNull)
     * @return Inserted count.
     */
    public int create(Sample2Entity entity);

    /**
     * Update one entity that the type is entity-interface.
     * @param entity Entity that the type is entity-interface. (NotNull)
     * @return Updated count.
     */
    public int modify(Sample2Entity entity);

    /**
     * Update one entity that the type is entity-interface. (modified only)
     * @param entity Entity that the type is entity-interface. (NotNull)
     * @return Updated count.
     */
    public int modifyModifiedOnly(Sample2Entity entity);

    /**
     * Delete one entity that the type is entity-interface.
     * @param entity Entity that the type is entity-interface. (NotNull)
     * @return Deleted count.
     */
    public int remove(Sample2Entity entity);


    /**
     * Insert several entities that the type is entity-interface.
     * @param entityList Entity-list that the type is entity-interface. (NotNull)
     * @return The array of inserted count.
     */
    public int[] createList(List<Sample2Entity> entityList);

    /**
     * Update several entities that the type is entity-interface.
     * @param entityList Entity-list that the type is entity-interface. (NotNull)
     * @return The array of updated count.
     */
    public int[] modifyList(List<Sample2Entity> entityList);

    /**
     * Delete several entities that the type is entity-interface.
     * @param entityList Entity-list that the type is entity-interface. (NotNull)
     * @return The array of deleted count.
     */
    public int[] removeList(List<Sample2Entity> entityList);
}
