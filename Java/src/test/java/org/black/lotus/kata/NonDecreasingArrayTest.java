package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class NonDecreasingArrayTest {

    @Test
    public void should_find_non_descending_array_1() {
        int[] nums = {4, 2, 3};
        NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();
        boolean res = nonDecreasingArray.checkPossibility(nums);
        assertTrue(res);
    }

    @Test
    public void should_find_non_descending_array_2() {
        int[] nums = {4, 2, 1};
        NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();
        boolean res = nonDecreasingArray.checkPossibility(nums);
        assertFalse(res);
    }

    @Test
    public void should_find_non_descending_array_3() {
        int[] nums = {3, 4, 2, 3};
        NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();
        boolean res = nonDecreasingArray.checkPossibility(nums);
        assertFalse(res);
    }

    @Test
    public void should_find_non_descending_array_4() {
        int[] nums = {2, 3, 3, 2, 4};
        NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();
        boolean res = nonDecreasingArray.checkPossibility(nums);
        assertTrue(res);
    }
}