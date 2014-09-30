package jp.co.np.p2netex.sample2.allcommon.cbean.grouping;

/**
 * The class of row resource for grouping making.
 * 
 * @param <ENTITY> The type of entity.
 * @author DBFlute(AutoGenerator)
 */
public class Sample2GroupingRowResource<ENTITY> {

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    protected java.util.List<ENTITY> _groupingRowList = new java.util.ArrayList<ENTITY>();

    // =====================================================================================
    //                                                                           Easy-to-Use
    //                                                                           ===========

    // =====================================================================================
    //                                                                              Accessor
    //                                                                              ========
    public java.util.List<ENTITY> getGroupingRowList() {
        return this._groupingRowList;
    }

    public void addGroupingRowList(ENTITY groupingRow) {
        this._groupingRowList.add(groupingRow);
    }
}
