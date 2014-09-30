package jp.co.np.p2netex.sample1.allcommon;

import java.util.List;

import jp.co.np.p2netex.sample1.allcommon.Sample1Entity;

/**
 * The interface of dao-writable.
 * @author DBFlute(AutoGenerator)
 */
public interface Sample1DaoWritable extends Sample1DaoReadable {

    /**
     * Insert one entity that the type is entity-interface.
     * @param entity Entity that the type is entity-interface. (NotNull)
     * @return Inserted count.
     */
    public int create(Sample1Entity entity);

    /**
     * Update one entity that the type is entity-interface.
     * @param entity Entity that the type is entity-interface. (NotNull)
     * @return Updated count.
     */
    public int modify(Sample1Entity entity);

    /**
     * Update one entity that the type is entity-interface. (modified only)
     * @param entity Entity that the type is entity-interface. (NotNull)
     * @return Updated count.
     */
    public int modifyModifiedOnly(Sample1Entity entity);

    /**
     * Delete one entity that the type is entity-interface.
     * @param entity Entity that the type is entity-interface. (NotNull)
     * @return Deleted count.
     */
    public int remove(Sample1Entity entity);


    /**
     * Insert several entities that the type is entity-interface.
     * @param entityList Entity-list that the type is entity-interface. (NotNull)
     * @return The array of inserted count.
     */
    public int[] createList(List<Sample1Entity> entityList);

    /**
     * Update several entities that the type is entity-interface.
     * @param entityList Entity-list that the type is entity-interface. (NotNull)
     * @return The array of updated count.
     */
    public int[] modifyList(List<Sample1Entity> entityList);

    /**
     * Delete several entities that the type is entity-interface.
     * @param entityList Entity-list that the type is entity-interface. (NotNull)
     * @return The array of deleted count.
     */
    public int[] removeList(List<Sample1Entity> entityList);
}
