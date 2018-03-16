package org.black.lotus.kata;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MaximumSubarrayIITest {

    @Test
    public void should_find_maximum() {
        List<Integer> nums = Arrays.asList(1, 3, -1, 2, -1, 2);
        MaximumSubarrayII maximumSubarrayII = new MaximumSubarrayII();
        maximumSubarrayII.maxTwoSubArrays(nums);
    }
}