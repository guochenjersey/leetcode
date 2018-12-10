package org.black.lotus.kata;


import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

@LeetCode
@FirstRound
@Easy
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = (end + start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }

        if (target < nums[start]) {
            return start;
        } else if (target > nums[start] && target < nums[end]) {
            return start + 1;
        } else {
            return end;
        }
    }
}
