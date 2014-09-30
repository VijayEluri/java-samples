package jp.co.np.p2netex.sample2.allcommon.exception;

/**
 * The exception of when the outside-sql is not found.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class Sample2OutsideSqlNotFoundException extends RuntimeException {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     * 
     * @param msg Exception message.
     */
    public Sample2OutsideSqlNotFoundException(String msg) {
        super(msg);
    }

    /**
     * Constructor.
     * 
     * @param msg Exception message.
     * @param cause Throwable.
     */
    public Sample2OutsideSqlNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
