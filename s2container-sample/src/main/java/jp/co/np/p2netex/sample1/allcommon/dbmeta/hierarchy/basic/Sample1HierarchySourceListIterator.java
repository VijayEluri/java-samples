package jp.co.np.p2netex.sample1.allcommon.dbmeta.hierarchy.basic;


/**
 * @author DBFlute(AutoGenerator)
 * @param <SOURCE_ROW> The type of source.
 */
public class Sample1HierarchySourceListIterator<SOURCE_ROW> implements jp.co.np.p2netex.sample1.allcommon.dbmeta.hierarchy.Sample1HierarchySourceIterator {

    protected java.util.List<? extends Object> sourceRowList;

    protected Sample1HierarchySourceRowSetupper<SOURCE_ROW> sourceRowSetupper;

    protected java.util.Iterator<SOURCE_ROW> sourceBeanListIterator;

    protected jp.co.np.p2netex.sample1.allcommon.dbmeta.hierarchy.Sample1HierarchySourceRow currentSourceEntity;

    public Sample1HierarchySourceListIterator(java.util.List<SOURCE_ROW> sourceRowList,
            Sample1HierarchySourceRowSetupper<SOURCE_ROW> sourceRowSetupper) {
        this.sourceRowList = sourceRowList;
        this.sourceRowSetupper = sourceRowSetupper;
        this.sourceBeanListIterator = sourceRowList.iterator();
    }

    public boolean hasNext() {
        return this.sourceBeanListIterator.hasNext();
    }

    public jp.co.np.p2netex.sample1.allcommon.dbmeta.hierarchy.Sample1HierarchySourceRow next() {
        this.currentSourceEntity = this.sourceRowSetupper.setup(this.sourceBeanListIterator.next());
        return this.currentSourceEntity;
    }

    public jp.co.np.p2netex.sample1.allcommon.dbmeta.hierarchy.Sample1HierarchySourceRow current() {
        return this.currentSourceEntity;
    }
}