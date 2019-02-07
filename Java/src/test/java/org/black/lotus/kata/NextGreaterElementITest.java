package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class NextGreaterElementITest {

    @Test
    public void should_find_next_greater_element() {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        NextGreaterElementI nextGreaterElementI
                = new NextGreaterElementI();
        int[] res = nextGreaterElementI.nextGreaterElement(nums1, nums2);
        int[] expectedRes = {-1, 3, -1};

        assertArrayEquals(expectedRes, res);
    }
}