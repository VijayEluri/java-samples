package jp.co.np.p2netex.sample2.allcommon.cbean.grouping;

/**
 * The interface of grouping switch point determiner.
 * 
 * @param <ENTITY> The type of entity.
 * @author DBFlute(AutoGenerator)
 */
public interface Sample2GroupingRowEndDeterminer<ENTITY> {

    public boolean determine(int columnIndex, int columnCount, Sample2GroupingRowResource<ENTITY> rowResource, ENTITY nextEntity);
}
