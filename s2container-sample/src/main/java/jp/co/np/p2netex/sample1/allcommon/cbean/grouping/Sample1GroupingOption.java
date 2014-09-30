package jp.co.np.p2netex.sample1.allcommon.cbean.grouping;

/**
 * The class of option for grouping making.
 * 
 * @param <ENTITY> The type of entity.
 * @author DBFlute(AutoGenerator)
 */
public class Sample1GroupingOption<ENTITY> {

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    protected int _columnCount;

    protected Sample1GroupingRowEndDeterminer<ENTITY> _groupingRowEndDeterminer;

    // =====================================================================================
    //                                                                           Constructor
    //                                                                           ===========
    public Sample1GroupingOption(int columnCount) {
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

    public Sample1GroupingRowEndDeterminer<ENTITY> getGroupingRowEndDeterminer() {
        return this._groupingRowEndDeterminer;
    }

    public void setGroupingRowEndDeterminer(Sample1GroupingRowEndDeterminer<ENTITY> groupingRowEndDeterminer) {
        this._groupingRowEndDeterminer = groupingRowEndDeterminer;
    }
}
