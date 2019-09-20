package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class KthLargestTest {

    @Test
    public void should_find_k_largest() {
        int[] nums = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, nums);
        assertEquals(4, kthLargest.add(3));
        assertEquals(5, kthLargest.add(5));
        assertEquals(5, kthLargest.add(10));
        assertEquals(8, kthLargest.add(9));

    }
}