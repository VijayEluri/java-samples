package jp.co.np.p2netex.sample2.allcommon.cbean;

/**
 * The invoker of paging.
 * @param <ENTITY> The type of entity.
 * @author DBFlute(AutoGenerator)
 */
public class Sample2PagingInvoker<ENTITY> {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected String _tableDbName;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample2PagingInvoker(String tableDbName) {
        _tableDbName = tableDbName;
    }

    // ===================================================================================
    //                                                                              Invoke
    //                                                                              ======
    /**
     * Invoke select-page by handler.
     * @param handler The handler of paging. (NotNull)
     * @return The result bean of paging. (NotNull)
     */
    public Sample2PagingResultBean<ENTITY> invokePaging(Sample2PagingHandler<ENTITY> handler) {
        assertObjectNotNull("handler", handler);
        final Sample2PagingBean pagingBean = handler.getPagingBean();
        assertObjectNotNull("handler.getPagingBean()", pagingBean);
        if (!pagingBean.isFetchScopeEffective()) {
            String msg = "The paging bean is not effective about fetch-scope!";
            msg = msg + " When you select page, you should set up fetch-scope of paging bean(Should invoke fetchFirst() and fetchPage()!).";
            msg = msg + " The paging bean is: " + pagingBean;
            throw new IllegalStateException(msg);
        }
        final int allRecordCount = handler.count();
        final java.util.List<ENTITY> selectedList = handler.paging();
        final Sample2PagingResultBean<ENTITY> rb = new Sample2ResultBeanBuilder<ENTITY>(_tableDbName).buildPagingResultBean(pagingBean, allRecordCount, selectedList);
        if (isNecessaryToReadPageAgain(rb)) {
            pagingBean.fetchPage(rb.getAllPageCount());
            final int reAllRecordCount = handler.count();
            final java.util.List<ENTITY> reSelectedList = handler.paging();
            return new Sample2ResultBeanBuilder<ENTITY>(_tableDbName).buildPagingResultBean(pagingBean, reAllRecordCount, reSelectedList);
        } else {
            return rb;
        }
    }

    /**
     * Is it necessary to read page again?
     * @param rb The result bean of paging. (NotNull)
     * @return Determination.
     */
    protected boolean isNecessaryToReadPageAgain(Sample2PagingResultBean<ENTITY> rb) {
        return rb.getAllRecordCount() > 0 && rb.getSelectedList().isEmpty();
    }

    // ===================================================================================
    //                                                                              Helper
    //                                                                              ======
    /**
     * Assert that the object is not null.
     * @param variableName Variable name. (NotNull)
     * @param value Value. (NotNull)
     * @exception IllegalArgumentException
     */
    protected void assertObjectNotNull(String variableName, Object value) {
        if (variableName == null) {
            String msg = "The value should not be null: variableName=" + variableName + " value=" + value;
            throw new IllegalArgumentException(msg);
        }
        if (value == null) {
            String msg = "The value should not be null: variableName=" + variableName;
            throw new IllegalArgumentException(msg);
        }
    }
}
