package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContinuousSubarraySumTest {

    @Test
    public void should_handle_zero() {
        int[] source = {0, 0};
        ContinuousSubarraySum continuousSubarraySum = new ContinuousSubarraySum();
        boolean res = continuousSubarraySum.checkSubarraySum(source, 0);
        assertEquals(true, res);
    }
}