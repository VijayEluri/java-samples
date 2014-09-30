package jp.co.np.p2netex.sample2.allcommon.cbean.grouping;

/**
 * The interface of grouping row setupper.
 * 
 * @param <ROW> The type of row.
 * @param <ENTITY> The type of entity.
 * @author DBFlute(AutoGenerator)
 */
public interface Sample2GroupingRowSetupper<ROW, ENTITY> {

    /**
     * Set up grouping row object.
     * 
     * @param groupingRowResource Grouping row resource. (NotNull)
     * @return Grouping row object. (NotNull)
     */
    public ROW setup(Sample2GroupingRowResource<ENTITY> groupingRowResource);
}
