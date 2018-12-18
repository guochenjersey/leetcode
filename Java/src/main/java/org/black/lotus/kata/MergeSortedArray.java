package org.black.lotus.kata;


import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 */
@LeetCode
@Easy
@FirstRound
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int size = m + n;
        int[] res = new int[size];
        int i = 0, j = 0, k = 0;
        for (; i < size && (j < m) && (k < n); ++i) {
            if (nums1[j] < nums2[k]) {
                res[i] = nums1[j];
                ++j;
            } else {
                res[i] = nums2[k];
                ++k;
            }
        }

        for (; i < size && j < m; ++i) {
            res[i] = nums1[j];
            ++j;
        }

        for (; i < size && k < n; ++i) {
            res[i] = nums2[k];
            ++k;
        }

        System.arraycopy(res, 0, nums1, 0, size);
    }
}
