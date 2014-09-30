package jp.co.np.p2netex.sample2.allcommon.dbmeta.hierarchy.basic;


/**
 * @author DBFlute(AutoGenerator)
 * @param <SOURCE_ROW> The type of source.
 */
public class Sample2HierarchySourceListIterator<SOURCE_ROW> implements jp.co.np.p2netex.sample2.allcommon.dbmeta.hierarchy.Sample2HierarchySourceIterator {

    protected java.util.List<? extends Object> sourceRowList;

    protected Sample2HierarchySourceRowSetupper<SOURCE_ROW> sourceRowSetupper;

    protected java.util.Iterator<SOURCE_ROW> sourceBeanListIterator;

    protected jp.co.np.p2netex.sample2.allcommon.dbmeta.hierarchy.Sample2HierarchySourceRow currentSourceEntity;

    public Sample2HierarchySourceListIterator(java.util.List<SOURCE_ROW> sourceRowList,
            Sample2HierarchySourceRowSetupper<SOURCE_ROW> sourceRowSetupper) {
        this.sourceRowList = sourceRowList;
        this.sourceRowSetupper = sourceRowSetupper;
        this.sourceBeanListIterator = sourceRowList.iterator();
    }

    public boolean hasNext() {
        return this.sourceBeanListIterator.hasNext();
    }

    public jp.co.np.p2netex.sample2.allcommon.dbmeta.hierarchy.Sample2HierarchySourceRow next() {
        this.currentSourceEntity = this.sourceRowSetupper.setup(this.sourceBeanListIterator.next());
        return this.currentSourceEntity;
    }

    public jp.co.np.p2netex.sample2.allcommon.dbmeta.hierarchy.Sample2HierarchySourceRow current() {
        return this.currentSourceEntity;
    }
}