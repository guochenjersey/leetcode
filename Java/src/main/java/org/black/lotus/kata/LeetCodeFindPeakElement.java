package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Facebook;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

/**
 * A peak element is an element that is greater than its neighbors.

 Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that nums[-1] = nums[n] = -∞.

 Example 1:

 Input: nums = [1,2,3,1]
 Output: 2
 Explanation: 3 is a peak element and your function should return the index number 2.
 Example 2:

 Input: nums = [1,2,1,3,5,6,4]
 Output: 1 or 5
 Explanation: Your function can return either index number 1 where the peak element is 2,
 or index number 5 where the peak element is 6.
 * */
@LeetCode
@Medium
@Facebook
@Accepted
public class LeetCodeFindPeakElement {

    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        if (nums.length == 1) {
            return 0;
        }
        if (nums.length > 2) {
            if (nums[0] > nums[1])
                return 0;
            else if (nums[nums.length -1] > nums[nums.length -2]) {
                return nums.length - 1;
            }
        }
        while (start + 1 < end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] > nums[mid -1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
 
            if (nums[mid] < nums[mid -1] && nums[mid] < nums[mid +1]) {
                start = mid;
                continue;
            }

            if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                start = mid;
            } else if (nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                end = mid;
            }

        }
        return -1;
    }
}
