package jp.co.np.p2netex.sample2.allcommon.exception;

/**
 * The exception of when the entity has been duplicated.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class Sample2EntityDuplicatedException extends Sample2RecordHasOverlappedException {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     * @param msg Exception message.
     */
    public Sample2EntityDuplicatedException(String msg) {
        super(msg);
    }

    /**
     * Constructor.
     * @param msg Exception message.
     * @param cause Throwable.
     */
    public Sample2EntityDuplicatedException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
