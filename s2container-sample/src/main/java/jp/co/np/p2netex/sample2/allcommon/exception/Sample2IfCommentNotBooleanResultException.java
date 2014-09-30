package jp.co.np.p2netex.sample2.allcommon.exception;

/**
 * The exception of when the result of IF comment is not boolean about outsideSql.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class Sample2IfCommentNotBooleanResultException extends Sample2IfCommentWrongExpressionException {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     * 
     * @param msg Exception message. (NotNull)
     */
    public Sample2IfCommentNotBooleanResultException(String msg) {
        super(msg);
    }

    /**
     * Constructor.
     * 
     * @param msg Exception message. (NotNull)
     * @param cause Throwable.
     */
    public Sample2IfCommentNotBooleanResultException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
