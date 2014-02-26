package com.riaancornelius.nreality.problem3.queue;

import java.lang.reflect.Array;

/**
 * User: riaan.cornelius
 */
public class ArrayQueue<T> implements Queue<T> {

    private final int maxQueueSize;
    private final T[] data;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(Class<T> type, int maxQueueSize) {
        this.maxQueueSize = maxQueueSize + 1;   // We need one element extra otherwise full and empty list looks the same
        data = (T[]) Array.newInstance(type, this.maxQueueSize);
    }

    @Override
    public void enqueue(T object) throws QueueFullException {
        if (size() == maxQueueSize-1) {
            throw new QueueFullException("Could not enqueue item because queue is full");
        }
        data[tail] = object;
        tail = (tail + 1) % maxQueueSize;
    }

    @Override
    public T dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue empty when trying to dequeue");
        }
        T itemToReturn = data[head];
        head = (head + 1) % maxQueueSize;
        return itemToReturn;
    }

    @Override
    public T peek() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue empty when trying to dequeue");
        }
        return data[head];
    }

    @Override
    public int size() {
        return (maxQueueSize - head + tail) % maxQueueSize;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }
}
