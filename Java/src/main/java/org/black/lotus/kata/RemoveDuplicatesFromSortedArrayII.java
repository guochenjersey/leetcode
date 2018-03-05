package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 * */
@LeetCode
@FirstRound
public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> occurrenceCounterMap = new HashMap<>();
        int nextAvailPos = 0;
        for (int i = 0; i < nums.length; ++i) {
            occurrenceCounterMap.putIfAbsent(nums[i], 0);
            occurrenceCounterMap.put(nums[i], occurrenceCounterMap.get(nums[i]) + 1);
            if (occurrenceCounterMap.get(nums[i]) <= 2) {
                nums[nextAvailPos] = nums[i];
                ++nextAvailPos;
            }
        }

        return nextAvailPos;
    }
}
