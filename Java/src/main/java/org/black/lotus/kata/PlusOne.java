package org.black.lotus.kata;

import org.black.lotus.marker.*;

import java.util.ArrayList;

/**
 *
 */
@LeetCode
@Easy
@FirstRound
@Important
@NeedToSubmit
public class PlusOne {

    public int[] digits(int[] nums) {
        // you can't convert o integer and add because it will overflow.
        int carry = (nums[nums.length - 1] + 1) / 10 ;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(((nums[nums.length - 1] + 1) % 10));
        for (int i = nums.length - 2; i >= 0; --i) {
            int n = carry + nums[i];
            res.add(0, n % 10);
            carry = n / 10;
        }

        if (carry == 1) {
            res.add(0, carry);
        }

        // !important List to primitive array
        return res.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
