package jp.canetrash.quextractor.handler;

public class MappingHandleException extends RuntimeException {
    public MappingHandleException() {
        super();
    }

    public MappingHandleException(String message, Throwable cause) {
        super(message, cause);
    }

    public MappingHandleException(Throwable cause) {
        super(cause);
    }

    public MappingHandleException(String message) {
        super(message);
    }

}
