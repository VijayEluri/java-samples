package jp.co.np.p2netex.sample2.allcommon.exception;

import org.seasar.dao.NotSingleRowUpdatedRuntimeException;

/**
 * The exception of when the entity has already been updated by other thread.
 * @author DBFlute(AutoGenerator)
 */
public class Sample2EntityAlreadyUpdatedException extends NotSingleRowUpdatedRuntimeException {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;
    
    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * Constructor.
     * @param bean Bean. (NotNull)
     * @param rows Rows.
     */
    public Sample2EntityAlreadyUpdatedException(Object bean, int rows) {
        super(bean, rows);
    }

    /**
     * Constructor.
     * @param e NotSingleRowUpdatedRuntimeException. (NotNull)
     */
    public Sample2EntityAlreadyUpdatedException(NotSingleRowUpdatedRuntimeException e) {
        super(e.getBean(), e.getRows());
    }
}
