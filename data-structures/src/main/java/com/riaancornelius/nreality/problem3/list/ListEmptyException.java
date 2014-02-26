package com.riaancornelius.nreality.problem3.list;

/**
 * User: riaan.cornelius
 */
public class ListEmptyException extends RuntimeException {

    public ListEmptyException() {
        super("List is empty!");
    }

    public ListEmptyException(String message) {
        super(message);
    }

    public ListEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ListEmptyException(Throwable cause) {
        super(cause);
    }
}
