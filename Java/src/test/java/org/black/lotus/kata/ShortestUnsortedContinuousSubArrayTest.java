package org.black.lotus.kata;

import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.*;

public class ShortestUnsortedContinuousSubArrayTest {

    @Test
    public void find_shortestUnsorted() {
        int[] source = {1, 3, 2, 4, 5};
        ShortestUnsortedContinuousSubArray shortestUnsortedContinuousSubArray
                = new ShortestUnsortedContinuousSubArray();
        int res = shortestUnsortedContinuousSubArray.findUnsortedSubarray(source);
    }
}