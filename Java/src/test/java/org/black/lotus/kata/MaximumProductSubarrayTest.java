package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumProductSubarrayTest {

    @Test
    public void should_find_biggest_product_of_subarray_1() {
        int[] source = {2, 3, -2, 4};
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        int res = maximumProductSubarray.maxProduct(source);
        assertEquals(6, res);
    }

    @Test
    public void should_find_biggest_product_of_subarray_2() {
        int[] source = {-2, 0, -1};
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        int res = maximumProductSubarray.maxProduct(source);
        assertEquals(0, res);
    }

    @Test
    public void should_find_biggest_product_of_subarray_3() {
        int[] source = {-2, 3, -4};
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        int res = maximumProductSubarray.maxProduct(source);
        assertEquals(24, res);
    }
}