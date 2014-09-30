package jp.co.np.p2netex.sample2.allcommon.dbmeta.hierarchy.basic;


/**
 * @author DBFlute(AutoGenerator)
 * @param <SOURCE_ROW> The type of source.
 */
public class Sample2HierarchySourceEntityListIterator<SOURCE_ROW> extends Sample2HierarchySourceListIterator<SOURCE_ROW> {

    /**
     * Constructor.
     * 
     * @param sourceRowList The list of source row. (NotNull)
     */
    public Sample2HierarchySourceEntityListIterator(java.util.List<SOURCE_ROW> sourceRowList) {
        super(sourceRowList, new Sample2HierarchySourceRowSetupper<SOURCE_ROW>() {
            public jp.co.np.p2netex.sample2.allcommon.dbmeta.hierarchy.Sample2HierarchySourceRow setup(SOURCE_ROW source) {
                return new Sample2HierarchySourceEntityRow(source);
            }
        });
    }
}