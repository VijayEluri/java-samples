package jp.co.np.p2netex.sample2.allcommon.exception;

import java.sql.SQLException;

/**
 * The exception of when the entity already exists on the database.
 * @author DBFlute(AutoGenerator)
 */
public class Sample2EntityAlreadyExistsException extends Sample2SQLFailureException {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     * @param msg Exception message. (NotNull)
     * @param cause SQLException. (NotNull)
     */
    public Sample2EntityAlreadyExistsException(String msg, SQLException cause) {
        super(msg, cause);
        sqlEx = cause;
    }
}
