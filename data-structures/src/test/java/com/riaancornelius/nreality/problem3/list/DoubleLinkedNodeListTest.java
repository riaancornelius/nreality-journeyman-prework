package com.riaancornelius.nreality.problem3.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * User: riaan.cornelius
 */
public class DoubleLinkedNodeListTest {

    private DoubleLinkedNodeList<String> list;

    @Before
    public void setUp() throws Exception {
        list = new DoubleLinkedNodeList<String>();
    }

    @Test
    public void testSize() throws Exception {
        assertEquals("List should initially be empty", 0, list.size());
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue("List should initially be empty", list.isEmpty());
    }

    @Test
    public void testIsNotEmptyAfterAdding() throws Exception {
        assertEquals("List size should be 0 before adding", 0, list.size());
        assertTrue("List should initially be empty", list.isEmpty());
        list.insertFirst("First");
        assertEquals("List size should be 1 after adding", 1, list.size());
        assertFalse("List should not be empty after adding", list.isEmpty());
    }

    @Test
    public void testShouldBeEmptyAfterAddingAndRemoving() throws Exception {
        assertTrue("List should initially be empty", list.isEmpty());
        list.insertFirst("First");
        assertFalse("List should not be empty after inserting", list.isEmpty());
        list.remove(list.last());
        assertTrue("List should be empty after adding and removing", list.isEmpty());
    }

    @Test(expected = ListEmptyException.class)
    public void testIsFirstEmpty() throws Exception {
        list.isFirst(new DoubleLinkedNode<String>(null, null, "Test"));
    }

    @Test
    public void testIsFirst() throws Exception {
        Node<String> first = list.insertFirst("First");
        assertFalse("Random object should not be in list!",
                list.isFirst(new DoubleLinkedNode<String>(null, null, "Test")));
        assertEquals("Expected first item inserted", first, list.first());
        assertTrue("Expected first item inserted to be first", list.isFirst(first));
    }

    @Test
    public void testIsLast() throws Exception {
        Node<String> first = list.insertFirst("First");
        assertEquals("Expected first item inserted", first, list.first());
        list.insertFirst("New First");
        assertTrue("Expected first item inserted to be last now", list.isLast(first));
    }

    @Test
    public void testFirst() throws Exception {
        Node<String> first = list.insertFirst("First");
        assertEquals("Expected first item inserted", first, list.first());
    }

    @Test
    public void testLast() throws Exception {
        Node<String> first = list.insertFirst("First");
        assertEquals("Expected first item inserted", first, list.first());
        list.insertFirst("New First");
        assertEquals("Expected first item inserted to be last now", first, list.last());
    }

    @Test
    public void testBefore() throws Exception {
        Node<String> first = list.insertFirst("First");
        assertEquals("Expected first item inserted", first, list.first());
        Node<String> last = list.insertLast("Last");
        assertEquals("Expected first item to be before last item", first, list.before(last));
    }

    @Test
    public void testAfter() throws Exception {
        Node<String> first = list.insertFirst("First");
        assertEquals("Expected first item inserted", first, list.first());
        Node<String> last = list.insertLast("Last");
        assertEquals("Expected first item to be before last item", last, list.after(first));
    }

    @Test
    public void testInsertBefore() throws Exception {
        Node<String> first = list.insertFirst("First");
        assertEquals("Expected first item inserted", first, list.first());
        Node<String> beforeFirst = list.insertBefore(first, "New first");
        assertTrue("Expected new item to be first", list.isFirst(beforeFirst));
    }

    @Test
    public void testInsertAfter() throws Exception {
        Node<String> first = list.insertFirst("First");
        assertEquals("Expected first item inserted", first, list.first());
        Node<String> afterFirst = list.insertAfter(first, "After first");
        assertTrue("Expected new item to be last", list.isLast(afterFirst));
    }

    @Test
    public void testInsertFirst() throws Exception {
        Node<String> first = list.insertFirst("First");
        assertEquals("Expected first item inserted", first, list.first());
        Node<String> newFirst = list.insertFirst("New first");
        assertTrue("Expected new item to be first", list.isFirst(newFirst));
    }

    @Test
    public void testInsertLast() throws Exception {
        Node<String> first = list.insertFirst("First");
        assertEquals("Expected first item inserted", first, list.first());
        Node<String> last = list.insertLast("Last");
        assertTrue("Expected new item to be last", list.isLast(last));
    }

    @Test
    public void testRemove() throws Exception {
        Node<String> first = list.insertFirst("First");
        assertEquals("Expected first item inserted", first, list.first());
        String retrieved = list.remove(first);
        assertEquals("Expected first item to be retrieved with removal", first.element(), retrieved);
        assertTrue("Expected list to be empty after only removal", list.isEmpty());
    }

    @Test
    public void testReplace() throws Exception {
        Node<String> first = list.insertFirst("First");
        assertEquals("Expected first item inserted", first, list.first());
        list.replace(first, "New First");
        assertFalse(list.isEmpty());
        assertEquals("Expected first item to be replaced with new item", "New First", list.first().element());
    }

    @Test
    public void testSwap() throws Exception {
        String first1 = "First";
        Node<String> first = list.insertFirst(first1);
        assertEquals("Expected first item inserted", first, list.first());
        String last1 = "Last";
        Node<String> last = list.insertLast(last1);
        assertTrue("Expected new item to be last", list.isLast(last));
        list.swap(first, last);
        assertEquals("After swapping, expected first to be last", first1, list.last().element());
        assertEquals("After swapping, expected last to be first", last1, list.first().element());
    }
}
