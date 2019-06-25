package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class GrumpyStoreOwnerTest {

    @Test
    public void should_find_all_grumpy_stores() {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int X = 3;

        GrumpyStoreOwner grumpyStoreOwner = new GrumpyStoreOwner();

        assertEquals(16, grumpyStoreOwner.maxSatisfied(customers, grumpy, X));

        int[] customers2 = {2, 6, 6, 9};
        int[] grumpy2 = {0, 0, 1, 1};

        assertEquals(17, grumpyStoreOwner.maxSatisfied(customers2, grumpy2, 1));

        int[] customer3 = {9, 10, 4, 5};
        int[] grumpy3 = {1, 0, 1, 1};

        assertEquals(19, grumpyStoreOwner.maxSatisfied(customer3, grumpy3, 1));

        int[] customer4 = {3, 8, 8, 7, 1};
        int[] grumpy4 = {1, 1, 1, 1, 1};
        assertEquals(23, grumpyStoreOwner.maxSatisfied(customer4, grumpy4, 3));

    }
}