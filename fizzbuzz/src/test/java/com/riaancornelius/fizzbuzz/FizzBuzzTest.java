package com.riaancornelius.fizzbuzz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * User: riaan.cornelius
 */
public class FizzBuzzTest {

    @Test
    public void testGetStringToPrint(){
        assertEquals("1", FizzBuzz.getStringToPrint(1));
        assertEquals("2", FizzBuzz.getStringToPrint(2));
        assertEquals("Fizz", FizzBuzz.getStringToPrint(3));
        assertEquals("4", FizzBuzz.getStringToPrint(4));
        assertEquals("Buzz", FizzBuzz.getStringToPrint(5));
        assertEquals("Fizz", FizzBuzz.getStringToPrint(9));
        assertEquals("Buzz", FizzBuzz.getStringToPrint(10));
        assertEquals("FizzBuzz", FizzBuzz.getStringToPrint(15));
    }

    @Test
    public void testShouldBuzz() throws Exception {
        assertTrue(FizzBuzz.shouldBuzz(5));
        assertTrue(FizzBuzz.shouldBuzz(15));
        assertFalse(FizzBuzz.shouldBuzz(3));
        assertFalse(FizzBuzz.shouldBuzz(2));
    }

    @Test
    public void testShouldFizz() throws Exception {
        assertTrue(FizzBuzz.shouldFizz(3));
        assertTrue(FizzBuzz.shouldFizz(15));
        assertFalse(FizzBuzz.shouldFizz(5));
        assertFalse(FizzBuzz.shouldFizz(2));
    }

    @Test
    public void testShouldFizzBuzz() throws Exception {
        assertTrue(FizzBuzz.shouldFizzBuzz(15));
        assertFalse(FizzBuzz.shouldFizzBuzz(5));
        assertFalse(FizzBuzz.shouldFizzBuzz(3));
        assertFalse(FizzBuzz.shouldFizzBuzz(2));
    }
}
