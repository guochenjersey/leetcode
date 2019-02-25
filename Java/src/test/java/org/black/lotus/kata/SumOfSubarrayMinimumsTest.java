package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class SumOfSubarrayMinimumsTest {

    @Test
    public void should_sum_of_subarray_min() {
        int[] nums = {3, 1, 2, 4};
        SumOfSubarrayMinimums sumOfSubarrayMinimums
                = new SumOfSubarrayMinimums();
        int res = sumOfSubarrayMinimums.sumSubarrayMins(nums);
        assertEquals(17, res);
    }
}