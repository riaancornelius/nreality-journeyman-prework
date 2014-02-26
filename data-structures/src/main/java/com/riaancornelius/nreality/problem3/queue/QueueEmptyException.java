package com.riaancornelius.nreality.problem3.queue;

/**
 * User: riaan.cornelius
 */
public class QueueEmptyException extends RuntimeException {

    public QueueEmptyException() {
        super("Queue is empty!");
    }

    public QueueEmptyException(String message) {
        super(message);
    }

    public QueueEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public QueueEmptyException(Throwable cause) {
        super(cause);
    }
}
