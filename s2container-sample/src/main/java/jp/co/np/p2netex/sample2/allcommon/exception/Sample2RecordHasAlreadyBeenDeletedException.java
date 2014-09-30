package jp.co.np.p2netex.sample2.allcommon.exception;

/**
 * The exception when the record has already been deleted (by other thread). <br />
 * This class is old.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class Sample2RecordHasAlreadyBeenDeletedException extends RuntimeException {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     * 
     * @param msg Exception message.
     */
    public Sample2RecordHasAlreadyBeenDeletedException(String msg) {
        super(msg);
    }
}
