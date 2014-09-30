package jp.co.np.p2netex.sample2.allcommon.cbean.grouping;

/**
 * The class of option for grouping making.
 * 
 * @param <ENTITY> The type of entity.
 * @author DBFlute(AutoGenerator)
 */
public class Sample2GroupingOption<ENTITY> {

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    protected int _columnCount;

    protected Sample2GroupingRowEndDeterminer<ENTITY> _groupingRowEndDeterminer;

    // =====================================================================================
    //                                                                           Constructor
    //                                                                           ===========
    public Sample2GroupingOption(int columnCount) {
        _columnCount = columnCount;
    }

    // =====================================================================================
    //                                                                           Easy-to-Use
    //                                                                           ===========

    // =====================================================================================
    //                                                                              Accessor
    //                                                                              ========
    public int getColumnCount() {
        return this._columnCount;
    }

    public Sample2GroupingRowEndDeterminer<ENTITY> getGroupingRowEndDeterminer() {
        return this._groupingRowEndDeterminer;
    }

    public void setGroupingRowEndDeterminer(Sample2GroupingRowEndDeterminer<ENTITY> groupingRowEndDeterminer) {
        this._groupingRowEndDeterminer = groupingRowEndDeterminer;
    }
}
