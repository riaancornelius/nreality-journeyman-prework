package com.riaancornelius.nreality.problem3.queue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * User: riaan.cornelius
 */
public class ArrayQueueTest {

    private Queue<Integer> arrayQueue;
    private final static int maxQueueSize = 10;

    @Before
    public void setUp() throws Exception {
        arrayQueue = new ArrayQueue<Integer>(Integer.class, maxQueueSize);
    }

    @Test
    public void testEnqueue() throws Exception {
        Integer object = 1;
        arrayQueue.enqueue(object);
        assertEquals("Expected size to increase after enqueue", 1, arrayQueue.size());
    }

    @Test(expected = QueueFullException.class)
    public void testEnqueueMoreThanMax() throws Exception {
        for (int i=0; i<maxQueueSize; i++) {
            arrayQueue.enqueue(i);
        }
        // Queue should be filled up now
        assertEquals("Expected queue to be full", maxQueueSize, arrayQueue.size());
        // so add 1 more :)
        Integer lastAdded = 15;
        arrayQueue.enqueue(lastAdded);
    }

    @Test
    public void testDequeue() throws Exception {
        Integer objectToQueue = 1;
        arrayQueue.enqueue(objectToQueue);
        assertEquals("Expected size to increase after enqueue", 1, arrayQueue.size());
        Integer fromQueue = arrayQueue.dequeue();
        assertEquals("Expected size to decrease after dequeue", 0, arrayQueue.size());
        assertEquals("Expected to get the item enqueued", objectToQueue, fromQueue);
    }

    @Test(expected = QueueEmptyException.class)
    public void testDequeueWithEmptyList() throws Exception {
        arrayQueue.dequeue();
    }

    @Test
    public void testPeek() throws Exception {
        Integer firstObject = 1;
        arrayQueue.enqueue(firstObject);
        assertEquals(firstObject, arrayQueue.peek());
        arrayQueue.enqueue(2);
        // Check that first item in is still at the head of the queue
        assertEquals(firstObject, arrayQueue.peek());
    }

    @Test(expected = QueueEmptyException.class)
    public void testPeekWithEmptyList() throws Exception {
        arrayQueue.peek();
    }

    @Test
    public void testSize() throws Exception {
        assertEquals("Expected queue to be empty", 0, arrayQueue.size());
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(arrayQueue.isEmpty());
    }
}
