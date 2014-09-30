package jp.co.np.p2netex.sample2.allcommon.exception;

/**
 * The exception of when the entity has already been deleted by other thread.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class Sample2EntityAlreadyDeletedException extends Sample2RecordHasAlreadyBeenDeletedException {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     * 
     * @param msg Exception message.
     */
    public Sample2EntityAlreadyDeletedException(String msg) {
        super(msg);
    }
}
