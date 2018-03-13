package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubarraySumClosestTest {

    @Test
    public void should_find_subarray_closest() {
        int[] nums = {-3, 1, 1, -3, 5};
        SubarraySumClosest subarraySumClosest = new SubarraySumClosest();
        subarraySumClosest.subarraySumClosest(nums);
    }
}