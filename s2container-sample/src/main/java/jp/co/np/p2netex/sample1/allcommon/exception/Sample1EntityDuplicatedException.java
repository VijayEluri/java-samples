package jp.co.np.p2netex.sample1.allcommon.exception;

/**
 * The exception of when the entity has been duplicated.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class Sample1EntityDuplicatedException extends Sample1RecordHasOverlappedException {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     * @param msg Exception message.
     */
    public Sample1EntityDuplicatedException(String msg) {
        super(msg);
    }

    /**
     * Constructor.
     * @param msg Exception message.
     * @param cause Throwable.
     */
    public Sample1EntityDuplicatedException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
