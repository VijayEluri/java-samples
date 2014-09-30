package jp.co.np.p2netex.sample1.allcommon.dbmeta.hierarchy.basic;


/**
 * @author DBFlute(AutoGenerator)
 * @param <SOURCE_ROW> The type of source.
 */
public class Sample1HierarchySourceEntityListIterator<SOURCE_ROW> extends Sample1HierarchySourceListIterator<SOURCE_ROW> {

    /**
     * Constructor.
     * 
     * @param sourceRowList The list of source row. (NotNull)
     */
    public Sample1HierarchySourceEntityListIterator(java.util.List<SOURCE_ROW> sourceRowList) {
        super(sourceRowList, new Sample1HierarchySourceRowSetupper<SOURCE_ROW>() {
            public jp.co.np.p2netex.sample1.allcommon.dbmeta.hierarchy.Sample1HierarchySourceRow setup(SOURCE_ROW source) {
                return new Sample1HierarchySourceEntityRow(source);
            }
        });
    }
}