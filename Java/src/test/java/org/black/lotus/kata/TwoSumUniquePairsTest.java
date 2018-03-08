package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSumUniquePairsTest {

    @Test
    public void should_work() {
        TwoSumUniquePairs twoSumUniquePairs = new TwoSumUniquePairs();
        int[] nums = {7,11,11,1,2,3,4};
        int i = twoSumUniquePairs.twoSum6(nums, 22);
        assertEquals(1, i);
    }
}