package jp.co.np.p2netex.sample1.allcommon.exception;

/**
 * The exception of when the result of IF comment is not boolean about outsideSql.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class Sample1IfCommentNotBooleanResultException extends Sample1IfCommentWrongExpressionException {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     * 
     * @param msg Exception message. (NotNull)
     */
    public Sample1IfCommentNotBooleanResultException(String msg) {
        super(msg);
    }

    /**
     * Constructor.
     * 
     * @param msg Exception message. (NotNull)
     * @param cause Throwable.
     */
    public Sample1IfCommentNotBooleanResultException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
