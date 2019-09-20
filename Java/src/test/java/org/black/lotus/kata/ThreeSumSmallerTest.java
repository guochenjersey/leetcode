package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreeSumSmallerTest {

    @Test
    public void should_find_three_sum_smaller() {
        int[] nums = {3, 1, 0, -2};
        ThreeSumSmaller threeSumSmaller = new ThreeSumSmaller();
        assertEquals(3, threeSumSmaller.threeSumSmaller(nums, 4));
    }
}