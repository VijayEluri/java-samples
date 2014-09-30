package jp.co.np.p2netex.sample1.allcommon.cbean.grouping;

/**
 * The interface of grouping switch point determiner.
 * 
 * @param <ENTITY> The type of entity.
 * @author DBFlute(AutoGenerator)
 */
public interface Sample1GroupingRowEndDeterminer<ENTITY> {

    public boolean determine(int columnIndex, int columnCount, Sample1GroupingRowResource<ENTITY> rowResource, ENTITY nextEntity);
}
