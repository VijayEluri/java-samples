package jp.co.np.p2netex.sample1.allcommon.exception;

/**
 * The exception of when the entity has already been deleted by other thread.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class Sample1EntityAlreadyDeletedException extends Sample1RecordHasAlreadyBeenDeletedException {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     * 
     * @param msg Exception message.
     */
    public Sample1EntityAlreadyDeletedException(String msg) {
        super(msg);
    }
}
