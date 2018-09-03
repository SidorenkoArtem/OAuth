package com.prototype.demo.exeptions;

/**
 * Overwrite Application exception class that to send exception in json if error arise.
 */
public abstract class ApplicationException extends RuntimeException {
    public ApplicationException() {
        super(null, null, false, false);
    }

    /**
     * Constructor. Transmitted message of exception.
     * @param message
     */
    public ApplicationException(final String message) {
        super(message, null, false, false);
    }

    public abstract ErrorCode getErrorCode();
}
