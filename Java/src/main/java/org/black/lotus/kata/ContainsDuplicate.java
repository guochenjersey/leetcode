package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;

import java.util.Arrays;

@FirstRound
@Easy
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Arrays.sort(nums);
        int current = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (current == nums[i]) {
                return false;
            } else {
                current = nums[i];
            }
        }

        return true;
    }
}
