package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlusOneTest {

    @Test
    public void should_plus_one_successfully() {
        int[] nums = {4, 3, 2, 1};
        PlusOne plusOne = new PlusOne();
        int[] res = plusOne.digits(nums);
        int[] expected = {4, 3, 2, 2};
        assertArrayEquals(expected, res);

        int[] nums1 = {9, 9, 9, 9};
        int[] res1 = plusOne.digits(nums1);
        int[] expected1 = {1, 0, 0, 0, 0};
        assertArrayEquals(expected1, res1);
    }
}