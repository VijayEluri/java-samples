package jp.co.np.p2netex.sample2.allcommon.cbean;

/**
 * The handler of paging.
 * @param <ENTITY> The type of entity.
 * @author DBFlute(AutoGenerator)
 */
public interface Sample2PagingHandler<ENTITY> {

    /**
     * Get the bean of paging.
     * @return The bean of paging. (NotNull)
     */
    public Sample2PagingBean getPagingBean();

    /**
     * Execute SQL for count.
     * @return The count of execution.
     */
    public int count();

    /**
     * Execute SQL for paging.
     * @return The list of entity. (NotNull)
     */
    public java.util.List<ENTITY> paging();
}
