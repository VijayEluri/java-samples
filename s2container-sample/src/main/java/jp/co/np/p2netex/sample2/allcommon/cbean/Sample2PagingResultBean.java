package jp.co.np.p2netex.sample2.allcommon.cbean;

import jp.co.np.p2netex.sample2.allcommon.cbean.mapping.Sample2EntityDtoMapper;
import jp.co.np.p2netex.sample2.allcommon.cbean.pagenavi.group.Sample2PageGroupBean;
import jp.co.np.p2netex.sample2.allcommon.cbean.pagenavi.group.Sample2PageGroupOption;
import jp.co.np.p2netex.sample2.allcommon.cbean.pagenavi.range.Sample2PageRangeBean;
import jp.co.np.p2netex.sample2.allcommon.cbean.pagenavi.range.Sample2PageRangeOption;

/**
 * The paging-result-bean for specified entity.
 * @param <ENTITY> The type of entity for the element of selected list.
 * @author DBFlute(AutoGenerator)
 */
public class Sample2PagingResultBean<ENTITY> extends Sample2ListResultBean<ENTITY> {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                       Page Basic Info
    //                                       ---------------
    /** The value of current page number. */
    protected int _pageSize;

    /** The value of current page number. */
    protected int _currentPageNumber;

    // -----------------------------------------------------
    //                                            Page Group
    //                                            ----------
    /** The value of page-group bean. */
    protected Sample2PageGroupBean _pageGroupBean;

    /** The value of page-group option. */
    protected Sample2PageGroupOption _pageGroupOption;

    // -----------------------------------------------------
    //                                            Page Range
    //                                            ----------
    /** The value of page-range bean. */
    protected Sample2PageRangeBean _pageRangeBean;

    /** The value of page-range option. */
    protected Sample2PageRangeOption _pageRangeOption;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * Constructor.
     */
    public Sample2PagingResultBean() {
    }

    // ===================================================================================
    //                                                                 Calculated Property
    //                                                                 ===================
    /**
     * Get the value of allPageCount that is calculated.
     * @return The value of allPageCount.
     */
    public int getAllPageCount() {
        return calculateAllPageCount(_allRecordCount, _pageSize);
    }

    /**
     * Get the value of currentStartRecordNumber that is calculated.
     * @return The value of currentStartRecordNumber.
     */
    public int getCurrentStartRecordNumber() {
        return calculateCurrentStartRecordNumber(_currentPageNumber, _pageSize);
    }

    /**
     * Get the value of currentEndRecordNumber that is calculated.
     * @return The value of currentEndRecordNumber.
     */
    public int getCurrentEndRecordNumber() {
        return calculateCurrentEndRecordNumber(_currentPageNumber, _pageSize);
    }
	
    // ===================================================================================
    //                                                                    Page Group/Range
    //                                                                    ================
    // -----------------------------------------------------
    //                                            Page Group
    //                                            ----------
    /**
     * Get the value of pageGroupSize.
     * @return The value of pageGroupSize.
     */
    public int getPageGroupSize() {
        return _pageGroupOption != null ? _pageGroupOption.getPageGroupSize() : 0;
    }

    /**
     * Set the value of pageGroupSize.
     * @param pageGroupSize The value of pageGroupSize.
     */
    public void setPageGroupSize(int pageGroupSize) {
        final Sample2PageGroupOption option = new Sample2PageGroupOption();
        option.setPageGroupSize(pageGroupSize);
        setPageGroupOption(option);
    }

    /**
     * Set the value of pageGroupOption.
     * @param pageGroupOption The value of pageGroupOption. (Nullable)
     */
    public void setPageGroupOption(Sample2PageGroupOption pageGroupOption) {
        _pageGroupOption = pageGroupOption;
    }

    /**
     * Get the value of pageGroupBean.
     * @return The value of pageGroupBean. (NotNull)
     */
    public Sample2PageGroupBean pageGroup() {
        assertPageGroupValid();
        if (_pageGroupBean == null) {
            _pageGroupBean = new Sample2PageGroupBean();
        }
        _pageGroupBean.setPageGroupOption(_pageGroupOption);
        _pageGroupBean.setCurrentPageNumber(getCurrentPageNumber());
        _pageGroupBean.setAllPageCount(getAllPageCount());
        return _pageGroupBean;
    }

    protected void assertPageGroupValid() {
        if (_pageGroupOption == null) {
            String msg = "The pageGroupOption should not be null. Please invoke setPageGroupOption().";
            throw new IllegalStateException(msg);
        }
        if (_pageGroupOption.getPageGroupSize() == 0) {
            String msg = "The pageGroupSize should be greater than 1. But the value is zero.";
            msg = msg + " pageGroupSize=" + _pageGroupOption.getPageGroupSize();
            throw new IllegalStateException(msg);
        }
        if (_pageGroupOption.getPageGroupSize() == 1) {
            String msg = "The pageGroupSize should be greater than 1. But the value is one.";
            msg = msg + " pageGroupSize=" + _pageGroupOption.getPageGroupSize();
            throw new IllegalStateException(msg);
        }
    }

    // -----------------------------------------------------
    //                                            Page Range
    //                                            ----------
    /**
     * Get the value of pageRangeSize.
     * @return The value of pageRangeSize.
     */
    public int getPageRangeSize() {
        return _pageRangeOption != null ? _pageRangeOption.getPageRangeSize() : 0;
    }

    /**
     * Set the value of pageRangeSize.
     * @param pageRangeSize The value of pageRangeSize.
     */
    public void setPageRangeSize(int pageRangeSize) {
        final Sample2PageRangeOption option = new Sample2PageRangeOption();
        option.setPageRangeSize(pageRangeSize);
        setPageRangeOption(option);
    }

    /**
     * Set the value of pageRangeOption.
     * @param pageRangeOption The value of pageRangeOption. (Nullable)
     */
    public void setPageRangeOption(Sample2PageRangeOption pageRangeOption) {
        this._pageRangeOption = pageRangeOption;
    }

    /**
     * Get the value of pageRangeBean.
     * @return The value of pageRangeBean. (NotNull)
     */
    public Sample2PageRangeBean pageRange() {
        assertPageRangeValid();
        if (_pageRangeBean == null) {
            _pageRangeBean = new Sample2PageRangeBean();
        }
        _pageRangeBean.setPageRangeOption(_pageRangeOption);
        _pageRangeBean.setCurrentPageNumber(getCurrentPageNumber());
        _pageRangeBean.setAllPageCount(getAllPageCount());
        return _pageRangeBean;
    }

    protected void assertPageRangeValid() {
        if (_pageRangeOption == null) {
            String msg = "The pageRangeOption should not be null. Please invoke setPageRangeOption().";
            throw new IllegalStateException(msg);
        }
        final int pageRangeSize = _pageRangeOption.getPageRangeSize();
        if (pageRangeSize == 0) {
            String msg = "The pageRangeSize should be greater than 1. But the value is zero.";
            throw new IllegalStateException(msg);
        }
    }

    // ===================================================================================
    //                                                                       Determination
    //                                                                       =============
    /**
     * Is existing previous page?
     * Using values are currentPageNumber.
     * @return Determination.
     */
    public boolean isExistPrePage() {
        return (_allRecordCount > 0 && _currentPageNumber > 1);
    }

    /**
     * Is existing next page?
     * Using values are currentPageNumber and allPageCount.
     * @return Determination.
     */
    public boolean isExistNextPage() {
        return (_allRecordCount > 0 && _currentPageNumber < getAllPageCount());
    }

    // ===================================================================================
    //                                                                             Mapping
    //                                                                             =======
    public <DTO> Sample2PagingResultBean<DTO> mappingList(Sample2EntityDtoMapper<ENTITY, DTO> entityDtoMapper) {
        final Sample2ListResultBean<DTO> ls = super.mappingList(entityDtoMapper);
        final Sample2PagingResultBean<DTO> mappingList = new Sample2PagingResultBean<DTO>();
        mappingList.setSelectedList(ls.getSelectedList());
        mappingList.setTableDbName(getTableDbName());
        mappingList.setAllRecordCount(getAllRecordCount());
        mappingList.setOrderByClause(getOrderByClause());
        mappingList.setPageSize(getPageSize());
        mappingList.setCurrentPageNumber(getCurrentPageNumber());
        mappingList.setPageRangeOption(_pageRangeOption);
        mappingList.setPageGroupOption(_pageGroupOption);
        return mappingList;
    }

    // ===================================================================================
    //                                                                 Calculate(Internal)
    //                                                                 ===================
    /**
     * Calculate all page count.
     * @param allRecordCount All record count.
     * @param pageSize Fetch-size.
     * @return All page count.
     */
    protected int calculateAllPageCount(int allRecordCount, int pageSize) {
        if (allRecordCount == 0) {
            return 1;
        }
        int pageCountBase = (allRecordCount / pageSize);
        if (allRecordCount % pageSize > 0) {
            pageCountBase++;
        }
        return pageCountBase;
    }

    protected int calculateCurrentStartRecordNumber(int currentPageNumber, int pageSize) {
        return ((currentPageNumber - 1) * pageSize) + 1;
    }

    protected int calculateCurrentEndRecordNumber(int currentPageNumber, int pageSize) {
        return calculateCurrentStartRecordNumber(currentPageNumber, pageSize) + _selectedList.size() - 1;
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    /**
     * @return The view string of all attribute values. (NotNull)
     */
	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append(getCurrentPageNumber()).append("/").append(getAllPageCount());
        sb.append(" of ").append(getAllRecordCount());
        sb.append(" listSize=").append(getSelectedList() != null ? new Integer(getSelectedList().size()) : null);
        sb.append(" pageSize=").append(getPageSize());
        sb.append(" page:{").append(isExistPrePage()).append("/").append(isExistNextPage()).append("}");
        sb.append(" groupSize=").append(getPageGroupSize());
        sb.append(" rangeSize=").append(getPageRangeSize());

        return sb.toString();
    }
	
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * Get the value of pageSize.
     * @return The value of pageSize.
     */
    public int getPageSize() {
        return _pageSize;
    }

    /**
     * Set the value of pageSize.
     * @param pageSize The value of pageSize.
     */
    public void setPageSize(int pageSize) {
        _pageSize = pageSize;
    }

    /**
     * Get the value of currentPageNumber.
     * @return The value of currentPageNumber.
     */
    public int getCurrentPageNumber() {
        return _currentPageNumber;
    }

    /**
     * Set the value of currentPageNumber.
     * @param currentPageNumber The value of currentPageNumber.
     */
    public void setCurrentPageNumber(int currentPageNumber) {
        _currentPageNumber = currentPageNumber;
    }
}
