package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 * <p>
 * Each element in the result must be unique.
 * The result can be in any order.
 */
@LeetCode
@Easy
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null) {
            return null;
        }

        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        for (int i : nums1) {
            if (binarySearch(nums2, i)) {
                if (res.size() == 0 || res.get(res.size() - 1) != i) {
                    res.add(i);
                }
            }
        }
        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); ++i) {
            resArray[i] = res.get(i);
        }

        return resArray;
    }

    private boolean binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return array[start] == target || array[end] == target;
    }
}
