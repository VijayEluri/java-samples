package jp.co.np.p2netex.sample2.allcommon.cbean;

import java.util.List;

/**
 * The list-result-bean for ${myClassName}.
 * 
 * @param <ENTITY> The type of entity.
 * @author DBFlute(AutoGenerator)
 */
public class Sample2ResultBeanBuilder<ENTITY> {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected String _tableDbName;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample2ResultBeanBuilder(String tableDbName) {
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
    public Sample2ListResultBean<ENTITY> buildListResultBean(Sample2ConditionBean ob, List<ENTITY> selectedList) {
        Sample2ListResultBean<ENTITY> rb = new Sample2ListResultBean<ENTITY>();
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
    public Sample2PagingResultBean<ENTITY> buildPagingResultBean(Sample2PagingBean pb, int allRecordCount, List<ENTITY> selectedList) {
        Sample2PagingResultBean<ENTITY> rb = new Sample2PagingResultBean<ENTITY>();
        rb.setTableDbName(_tableDbName);
        rb.setAllRecordCount(allRecordCount);
        rb.setSelectedList(selectedList);
        rb.setOrderByClause(pb.getSqlComponentOfOrderByClause());
        rb.setPageSize(pb.getFetchSize());
        rb.setCurrentPageNumber(pb.getFetchPageNumber());
        return rb;
    }
}
