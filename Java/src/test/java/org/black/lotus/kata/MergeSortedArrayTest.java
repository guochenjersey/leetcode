package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortedArrayTest {

    @Test
    public void should_merge_sorted_array_1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(nums1, 3, nums2, 3);
        int[] res = {1, 2, 2, 3, 5, 6};

        assertArrayEquals(res, nums1);
    }

    @Test
    public void should_merge_sorted_array_2() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {};
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(nums1, 3, nums2, 0);
        int[] res = {1, 2, 3};

        assertArrayEquals(res, nums1);
    }

    @Test
    public void should_merge_sorted_array_3() {
        int[] nums1 = {0, 0, 0, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(nums1, 3, nums2, 3);
        int[] res = {0,0 ,0, 1, 2, 3};

        assertArrayEquals(res, nums1);
    }
}