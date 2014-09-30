package jp.co.np.p2netex.sample1.allcommon.cbean.grouping;

/**
 * The interface of grouping row setupper.
 * 
 * @param <ROW> The type of row.
 * @param <ENTITY> The type of entity.
 * @author DBFlute(AutoGenerator)
 */
public interface Sample1GroupingRowSetupper<ROW, ENTITY> {

    /**
     * Set up grouping row object.
     * 
     * @param groupingRowResource Grouping row resource. (NotNull)
     * @return Grouping row object. (NotNull)
     */
    public ROW setup(Sample1GroupingRowResource<ENTITY> groupingRowResource);
}
