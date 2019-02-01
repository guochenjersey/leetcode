package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubArraySumEqualsKTest {

    @Test
    public void should_find_sub_array_sum_equals_k() {
        SubArraySumEqualsK subArraySumEqualsK = new SubArraySumEqualsK();
        int[] source = {1, 1, 1};
        int res = subArraySumEqualsK.subarraySum(source, 2);

        assertEquals(2, res);

        int[] source1 = {1, 2, 3};

        int res1 = subArraySumEqualsK.subarraySum(source1, 3);
        assertEquals(2, res1);
    }
}