package com.riaancornelius.nreality.problem3.list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * User: riaan.cornelius
 */
public class IntegerListTest {

    private IntegerList list;

    @Before
    public void setUp() throws Exception {
        list = new IntegerList();
    }

    @Test
    public void testSort() throws Exception {
        list.insertFirst(3);
        list.insertFirst(7);
        list.insertFirst(5);
        list.insertFirst(9);
        list.insertFirst(2);
        list.insertFirst(4);
        list.insertFirst(1);
        list.insertFirst(8);
        list.insertFirst(6);
        assertEquals(new Integer(6), list.first().element());
        assertEquals(new Integer(3), list.last().element());
        list.sort();
        assertEquals(new Integer(1), list.first().element());
        assertEquals(new Integer(9), list.last().element());
    }
}
