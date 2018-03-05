package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

import java.util.Arrays;

@FirstRound
@Accepted
@LeetCode
public class RemoveDuplicateInArray {

    public int duplication(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Integer prev = null;
        int nextAvailPos = 0;
        for (int i : nums) {
            if (prev == null) {
                prev = i;
                ++nextAvailPos;
                continue;
            }
            if (!Integer.valueOf(i).equals(prev)) {
                nums[nextAvailPos] = i;
                prev = i;
                ++nextAvailPos;
            }
        }

        return nextAvailPos;
    }
}
