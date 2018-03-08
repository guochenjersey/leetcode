package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSumLessThanOrEqualToTargetTest {

    @Test
    public void should_find_correct_number() {
        int[] nums = {2, 7, 11, 15};
        TwoSumLessThanOrEqualToTarget two = new TwoSumLessThanOrEqualToTarget();
        int res = two.twoSum5(nums, 24);
        assertEquals(5, res);
    }
}