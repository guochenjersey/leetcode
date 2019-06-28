package org.black.lotus.kata;

import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * Follow up:
 * <p>
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 */
@LeetCode
@Medium
public class SearchInRoatatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[start] >= nums[end]) {
                if (nums[start] == target || nums[end] == target) {
                    return true;
                }
                if (nums[mid] > target && nums[mid] > nums[end]) {

                }
            } else if (nums[start] < nums[end]) {
                if (nums[mid] > target) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }

        return nums[start] == target || nums[end] == target;
    }

}
