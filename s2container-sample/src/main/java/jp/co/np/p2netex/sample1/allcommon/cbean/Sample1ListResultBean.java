package jp.co.np.p2netex.sample1.allcommon.cbean;

import java.util.List;
import java.util.ArrayList;

import jp.co.np.p2netex.sample1.allcommon.cbean.mapping.Sample1EntityDtoMapper;
import jp.co.np.p2netex.sample1.allcommon.cbean.grouping.Sample1GroupingOption;
import jp.co.np.p2netex.sample1.allcommon.cbean.grouping.Sample1GroupingRowEndDeterminer;
import jp.co.np.p2netex.sample1.allcommon.cbean.grouping.Sample1GroupingRowResource;
import jp.co.np.p2netex.sample1.allcommon.cbean.grouping.Sample1GroupingRowSetupper;
import jp.co.np.p2netex.sample1.allcommon.cbean.sqlclause.Sample1OrderByClause;

/**
 * The list-result-bean for Sample1ListResultBean.
 * @param <ENTITY> The type of entity for the element of selected list.
 * @author DBFlute(AutoGenerator)
 */
public class Sample1ListResultBean<ENTITY> implements List<ENTITY>, java.io.Serializable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The value of table db-name. */
    protected String _tableDbName;

    /** The value of all record count. */
    protected int _allRecordCount;

    /** Selected list. */
    protected List<ENTITY> _selectedList = new java.util.ArrayList<ENTITY>();

    /** Order-by clause. */
    protected Sample1OrderByClause _orderByClause = new Sample1OrderByClause();

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * Constructor.
     */
    public Sample1ListResultBean() {
    }

    // ===================================================================================
    //                                                                            Grouping
    //                                                                            ========
    public <ROW> List<ROW> groupingList(Sample1GroupingRowSetupper<ROW, ENTITY> groupingRowSetupper, Sample1GroupingOption<ENTITY> groupingOption) {
        final List<ROW> groupingList = new ArrayList<ROW>();
        Sample1GroupingRowEndDeterminer<ENTITY> rowEndDeterminer = groupingOption.getGroupingRowEndDeterminer();
        if (rowEndDeterminer == null) {
            rowEndDeterminer = new Sample1GroupingRowEndDeterminer<ENTITY>() {
                public boolean determine(int columnIndex, int columnCount, Sample1GroupingRowResource<ENTITY> rowResource, ENTITY nextEntity) {
                    return columnIndex == (columnCount-1);
                }
            };// as Default
        }
        Sample1GroupingRowResource<ENTITY> rowResource = new Sample1GroupingRowResource<ENTITY>();
        int columnCount = groupingOption.getColumnCount();
        int columnIndex = 0;
        int rowIndex = 0;
        for (ENTITY entity : _selectedList) {
            // Set up row resource.
            rowResource.addGroupingRowList(entity);

            if (_selectedList.size() == (rowIndex + 1)) {// Last Loop!
                // Callback!
                final ROW groupingRowObject = groupingRowSetupper.setup(rowResource);

                // Register!
                groupingList.add(groupingRowObject);
                break;
            }

            ENTITY nextElement = null;
            if (_selectedList.size() > (rowIndex + 1)) {
                nextElement = _selectedList.get(rowIndex);
            }

            // Do at row end.
            if (rowEndDeterminer.determine(columnIndex, columnCount, rowResource, nextElement)) {
                // Callback!
                final ROW groupingRowObject = groupingRowSetupper.setup(rowResource);

                // Register!
                groupingList.add(groupingRowObject);

                // Initialize!
                rowResource = new Sample1GroupingRowResource<ENTITY>();
                columnIndex = 0;
                ++rowIndex;
                continue;
            }
            ++columnIndex;
            ++rowIndex;
        }
        return groupingList;
    }

    // ===================================================================================
    //                                                                             Mapping
    //                                                                             =======
    public <DTO> Sample1ListResultBean<DTO> mappingList(Sample1EntityDtoMapper<ENTITY, DTO> entityDtoMapper) {
        final Sample1ListResultBean<DTO> mappingList = new Sample1ListResultBean<DTO>();
        for (ENTITY entity : _selectedList) {
            mappingList.add(entityDtoMapper.map(entity));
        }
        mappingList.setTableDbName(getTableDbName());
        mappingList.setAllRecordCount(getAllRecordCount());
        mappingList.setOrderByClause(getOrderByClause());
        return mappingList;
    }

    // ===================================================================================
    //                                                                       Determination
    //                                                                       =============
    /**
     * Has this result selected?
     * @return Determination.
     */
    public boolean isSelectedResult() {
        return _tableDbName != null;
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    /**
     * @return Hash-code from primary-keys.
     */
    public int hashCode() {
        if (_selectedList == null) {
            return super.hashCode();
        }
        return _selectedList.hashCode();
    }

    /**
     * @param other Other entity. (Nullable)
     * @return Comparing result. If other is null, returns false.
     */
    public boolean equals(Object other) {
        if (_selectedList == null) {
            return false;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof List)) {
            return false;
        }
        return _selectedList.equals(other);
    }

    /**
     * @return The view string of all attribute values. (NotNull)
     */
	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append(" tableDbName=").append(_tableDbName);
        sb.append(" allRecordCount=").append(_allRecordCount);
        sb.append(" selectedList.size()=").append(_selectedList.size());
        sb.append(" orderByClause=").append(_orderByClause);

        return sb.toString();
    }

    // ===================================================================================
    //                                                                       List Elements
    //                                                                       =============
    public boolean add(ENTITY o) {
        return _selectedList.add(o);
    }

    public boolean addAll(java.util.Collection<? extends ENTITY> c) {
        return _selectedList.addAll(c);
    }

    public void clear() {
        _selectedList.clear();
    }

    public boolean contains(Object o) {
        return _selectedList.contains(o);
    }

    public boolean containsAll(java.util.Collection<?> c) {
        return _selectedList.containsAll(c);
    }

    public boolean isEmpty() {
        return _selectedList.isEmpty();
    }

    public java.util.Iterator<ENTITY> iterator() {
        return _selectedList.iterator();
    }

    public boolean remove(Object o) {
        return _selectedList.remove(o);
    }

    public boolean removeAll(java.util.Collection<?> c) {
        return _selectedList.removeAll(c);
    }

    public boolean retainAll(java.util.Collection<?> c) {
        return _selectedList.retainAll(c);
    }

    public int size() {
        return _selectedList.size();
    }

    public Object[] toArray() {
        return _selectedList.toArray();
    }

    public <TYPE> TYPE[] toArray(TYPE[] a) {
        return _selectedList.toArray(a);
    }

    public void add(int index, ENTITY element) {
        _selectedList.add(index, element);
    }

    public boolean addAll(int index, java.util.Collection<? extends ENTITY> c) {
        return _selectedList.addAll(index, c);
    }

    public ENTITY get(int index) {
        return _selectedList.get(index);
    }

    public int indexOf(Object o) {
        return _selectedList.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return _selectedList.lastIndexOf(o);
    }

    public java.util.ListIterator<ENTITY> listIterator() {
        return _selectedList.listIterator();
    }

    public java.util.ListIterator<ENTITY> listIterator(int index) {
        return _selectedList.listIterator(index);
    }

    public ENTITY remove(int index) {
        return _selectedList.remove(index);
    }

    public ENTITY set(int index, ENTITY element) {
        return _selectedList.set(index, element);
    }

    public java.util.List<ENTITY> subList(int fromIndex, int toIndex) {
        return _selectedList.subList(fromIndex, toIndex);
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * Get the value of tableDbName.
     * @return The value of tableDbName. (Nullable: If it's null, it means 'Not Selected Yet'.)
     */
    public String getTableDbName() {
        return _tableDbName;
    }

    /**
     * Set the value of tableDbName.
     * @param tableDbName The value of tableDbName. (NotNull)
     */
    public void setTableDbName(String tableDbName) {
        _tableDbName = tableDbName;
    }

    /**
     * Get the value of allRecordCount.
     * @return The value of allRecordCount.
     */
    public int getAllRecordCount() {
        return _allRecordCount;
    }

    /**
     * Set the value of allRecordCount.
     * @param allRecordCount The value of allRecordCount.
     */
    public void setAllRecordCount(int allRecordCount) {
        _allRecordCount = allRecordCount;
    }

    /**
     * Get the value of selectedList.
     * @return Selected list. (Nullable: If it's null, it means 'Not Selected Yet'.)
     */
    public List<ENTITY> getSelectedList() {
        return _selectedList;
    }

    /**
     * Set the value of selectedList.
     * @param selectedList Selected list. (NotNull)
     */
    public void setSelectedList(List<ENTITY> selectedList) {
        _selectedList = selectedList;
    }

    /**
     * Get the value of orderByClause.
     * @return The value of orderByClause. (Nullable: If it's null, it means 'Not Selected Yet'.)
     */
    public Sample1OrderByClause getOrderByClause() {
        return _orderByClause;
    }

    /**
     * Set the value of orderByClause.
     * @param orderByClause The value of orderByClause. (NotNull)
     */
    public void setOrderByClause(Sample1OrderByClause orderByClause) {
        _orderByClause = orderByClause;
    }
}
