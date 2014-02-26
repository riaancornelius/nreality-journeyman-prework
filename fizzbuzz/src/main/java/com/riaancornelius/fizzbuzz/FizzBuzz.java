package com.riaancornelius.fizzbuzz;

/**
 * User: riaan.cornelius
 */
public class FizzBuzz {

    public static void fizzBuzz(int max) {
        for (int i=1; i<=max; i++) {
            System.out.println(getStringToPrint(i));
        }
    }

    protected static String getStringToPrint(int i) {
        if (shouldFizzBuzz(i)) {
            return "FizzBuzz";
        } else if(shouldFizz(i)) {
            return "Fizz";
        } else if(shouldBuzz(i)) {
            return "Buzz";
        } else {
            return Integer.toString(i);
        }
    }

    protected static boolean shouldBuzz(int i) {
        return i%5==0;
    }

    protected static boolean shouldFizz(int i) {
        return i%3==0;
    }

    protected static boolean shouldFizzBuzz(int i) {
        return shouldFizz(i) && shouldBuzz(i);
    }

}
