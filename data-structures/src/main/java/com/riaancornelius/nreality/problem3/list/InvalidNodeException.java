package com.riaancornelius.nreality.problem3.list;

/**
 * User: riaan.cornelius
 */
public class InvalidNodeException extends RuntimeException {

    public InvalidNodeException() {
        super("Invalid node!");
    }

    public InvalidNodeException(String message) {
        super(message);
    }

    public InvalidNodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNodeException(Throwable cause) {
        super(cause);
    }
}
