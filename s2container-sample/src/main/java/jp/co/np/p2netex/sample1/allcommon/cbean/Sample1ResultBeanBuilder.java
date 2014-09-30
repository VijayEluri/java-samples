package jp.co.np.p2netex.sample1.allcommon.cbean;

import java.util.List;

/**
 * The list-result-bean for ${myClassName}.
 * 
 * @param <ENTITY> The type of entity.
 * @author DBFlute(AutoGenerator)
 */
public class Sample1ResultBeanBuilder<ENTITY> {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected String _tableDbName;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample1ResultBeanBuilder(String tableDbName) {
        _tableDbName = tableDbName;
    }

    // ===================================================================================
    //                                                                             Builder
    //                                                                             =======
    /**
     * Build the result bean of list.
     * 
     * @param ob The bean of orderBy. (NotNull)
     * @param selectedList Selected list. (NotNull)
     * @return The result bean of list. (NotNull)
     */
    public Sample1ListResultBean<ENTITY> buildListResultBean(Sample1ConditionBean ob, List<ENTITY> selectedList) {
        Sample1ListResultBean<ENTITY> rb = new Sample1ListResultBean<ENTITY>();
        rb.setTableDbName(_tableDbName);
        rb.setAllRecordCount(selectedList.size());
        rb.setSelectedList(selectedList);
        rb.setOrderByClause(ob.getSqlComponentOfOrderByClause());
        return rb;
    }

    /**
     * Build the result bean of paging.
     * 
     * @param pb The bean of paging. (NotNull)
     * @param allRecordCount All record count.
     * @param selectedList The list of selected entity. (NotNull)
     * @return The result bean of paging. (NotNull)
     */
    public Sample1PagingResultBean<ENTITY> buildPagingResultBean(Sample1PagingBean pb, int allRecordCount, List<ENTITY> selectedList) {
        Sample1PagingResultBean<ENTITY> rb = new Sample1PagingResultBean<ENTITY>();
        rb.setTableDbName(_tableDbName);
        rb.setAllRecordCount(allRecordCount);
        rb.setSelectedList(selectedList);
        rb.setOrderByClause(pb.getSqlComponentOfOrderByClause());
        rb.setPageSize(pb.getFetchSize());
        rb.setCurrentPageNumber(pb.getFetchPageNumber());
        return rb;
    }
}
