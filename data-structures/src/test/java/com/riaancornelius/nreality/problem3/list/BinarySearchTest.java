package com.riaancornelius.nreality.problem3.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * User: riaan.cornelius
 */
public class BinarySearchTest {
    
    @Test
    public void testFind() throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(7);
        list.add(5);
        list.add(9);
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(8);
        list.add(6);
        Collections.sort(list);
        // Confirm list is sorted:
        assertEquals(new Integer(1), list.get(0));
        assertEquals(new Integer(9), list.get(list.size()-1));
        // Search for first item:
        int indexFor1 = BinarySearch.find(list, 1);
        assertEquals(0, indexFor1);
        // Search for low item:
        int indexFor2 = BinarySearch.find(list, 2);
        assertEquals(1, indexFor2);
        // Search for midpoint item:
        int indexFor5 = BinarySearch.find(list, 5);
        assertEquals(4, indexFor5);
        // Search for high item:
        int indexFor8 = BinarySearch.find(list, 8);
        assertEquals(7, indexFor8);
        // Search for last item:
        int indexFor9 = BinarySearch.find(list, 9);
        assertEquals(8, indexFor9);
        // Search for non-existent item:
        int indexFor15 = BinarySearch.find(list, 15);
        assertEquals(-1, indexFor15);
    }
}
