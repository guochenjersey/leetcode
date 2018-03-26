package org.black.lotus.kata;


import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

import java.util.BitSet;


/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * Given input array A = [1,1,2],
 * <p>
 * Your function should return length = 2, and A is now [1,2].
 */
@FirstRound
@LintCode
@Medium
@NoIdeaOrBadIdeaInitially
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int size = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != nums[size]) {
                nums[++size] = nums[i];
            }
        }

        return size + 1;
    }
}
