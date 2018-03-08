package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;


/**
 * Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:

 All elements < k are moved to the left
 All elements >= k are moved to the right
 Return the partitioning index, i.e the first index i nums[i] >= k.

 Notice
 You should do really partition in array nums instead of just counting the numbers of integers smaller than k.

 If all elements in nums are smaller than k, then return nums.length

 Have you met this question in a real interview?
 Example
 If nums = [3,2,2,1] and k=2, a valid answer is 1.

 Challenge
 Can you partition the array in-place and in O(n)?


 *
 * */
@LintCode
@Accepted
@FirstRound
public class PartionArray {

    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] < k) {
                ++start;
            } else {
                if (nums[end] < k) {
                    swap(start, end, nums);
                    ++start;
                    --end;
                } else {
                    --end;
                }
            }
        }


        return nums[start] >= k ? start : end + 1;
    }

    private void swap(int start, int end, int[] nums) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[start] = temp;
    }
}
