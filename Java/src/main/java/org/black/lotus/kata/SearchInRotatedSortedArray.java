package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.BinarySearch;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.NeedToSubmit;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
@LeetCode
@Medium
@FirstRound
@NeedToSubmit
@NoIdeaOrBadIdeaInitially
@Accepted
@BinarySearch
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[start] < nums[end]) {
                if (nums[mid] < target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }

            if (nums[start] > nums[end]) {
                if (nums[start] == target) {
                    return start;
                }
                if (nums[end] == target) {
                    return end;
                }
                // zig zag part
                if (nums[mid] > nums[start]) {
                    if (nums[mid] > target) {
                        if (nums[start] < target) {
                            end = mid;
                        } else {
                            start = mid;
                        }
                    } else {
                        start = mid;
                    }
                } else {
                    if (nums[mid] < target) {
                        if (target < nums[end]) {
                            start = mid;
                        } else {
                            end = mid;
                        }
                    } else {
                        end = mid;
                    }
                }

            }
        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }

        return -1;
    }
}
