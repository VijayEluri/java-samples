package jp.co.np.p2netex.sample2.allcommon.cbean;

/**
 * Fetch-Narrowing-Bean context. (referring to s2pager)
 * 
 * @author DBFlute(AutoGenerator)
 */
public class Sample2FetchNarrowingBeanContext {

    /** The thread-local for this. */
    private static ThreadLocal<Sample2FetchNarrowingBean> _threadLocal = new ThreadLocal<Sample2FetchNarrowingBean>();

    /**
     * Get fetch-narrowing-bean on thread.
     * @return Condition-bean context. (Nullable)
     */
    public static Sample2FetchNarrowingBean getFetchNarrowingBeanOnThread() {
        return (Sample2FetchNarrowingBean)_threadLocal.get();
    }

    /**
     * Set fetch-narrowing-bean on thread.
     * @param cb Condition-bean. (NotNull)
     */
    public static void setFetchNarrowingBeanOnThread(Sample2FetchNarrowingBean cb) {
        if (cb == null) {
            String msg = "The argument[cb] must not be null.";
            throw new IllegalArgumentException(msg);
        }
        _threadLocal.set(cb);
    }

    /**
     * Is existing fetch-narrowing-bean on thread?
     * @return Determination.
     */
    public static boolean isExistFetchNarrowingBeanOnThread() {
        return (_threadLocal.get() != null);
    }

    /**
     * Clear fetch-narrowing-bean on thread.
     */
    public static void clearFetchNarrowingBeanOnThread() {
        _threadLocal.set(null);
    }

    /**
     * Is the argument fetch-narrowing-bean?
     * @param dtoInstance Dto instance.
     * @return Determination.
     */
    public static boolean isTheArgumentFetchNarrowingBean(final Object dtoInstance) {
        if (dtoInstance instanceof Sample2FetchNarrowingBean) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Is the type fetch-narrowing-bean?
     * @param dtoClass DtoClass.
     * @return Determination.
     */
    public static boolean isTheTypeFetchNarrowingBean(final Class<?> dtoClass) {
        if (Sample2FetchNarrowingBean.class.isAssignableFrom(dtoClass)) {
            return true;
        } else {
            return false;
        }
    }
}
