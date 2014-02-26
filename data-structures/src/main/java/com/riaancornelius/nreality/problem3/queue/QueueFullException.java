package com.riaancornelius.nreality.problem3.queue;

/**
 * User: riaan.cornelius
 */
public class QueueFullException extends RuntimeException {

    public QueueFullException() {
        super("Queue is full!");
    }

    public QueueFullException(String message) {
        super(message);
    }

    public QueueFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public QueueFullException(Throwable cause) {
        super(cause);
    }
}
