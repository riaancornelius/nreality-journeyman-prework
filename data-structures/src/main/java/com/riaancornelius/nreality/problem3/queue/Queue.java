package com.riaancornelius.nreality.problem3.queue;

/**
 * User: riaan.cornelius
 */
public interface Queue<T> {

    public void enqueue(T object) throws QueueFullException ;
    public T dequeue() throws QueueEmptyException;
    public T peek() throws QueueEmptyException;
    public int size();
    public boolean isEmpty();

}
