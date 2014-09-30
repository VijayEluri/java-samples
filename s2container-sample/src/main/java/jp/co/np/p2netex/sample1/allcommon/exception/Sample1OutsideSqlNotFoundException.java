package jp.co.np.p2netex.sample1.allcommon.exception;

/**
 * The exception of when the outside-sql is not found.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class Sample1OutsideSqlNotFoundException extends RuntimeException {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     * 
     * @param msg Exception message.
     */
    public Sample1OutsideSqlNotFoundException(String msg) {
        super(msg);
    }

    /**
     * Constructor.
     * 
     * @param msg Exception message.
     * @param cause Throwable.
     */
    public Sample1OutsideSqlNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
