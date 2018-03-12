package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;

import java.util.ArrayList;
import java.util.List;

@FirstRound
@Easy
@LintCode
@Accepted
public class WindowSum {

    public int[] winSum(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }

        if (k > nums.length) {
            return nums;
        }

        List<Integer> res = new ArrayList<>();
        int start = 0;
        while (start <= (nums.length - k)) {
            int sum = 0;
            for (int i = start; i < start + k; ++i) {
                sum += nums[i];
            }
            res.add(sum);
            ++start;
        }

        // look how we convert from List<Integer> to int[] here.
        return res.stream().mapToInt(i->i).toArray();
    }
}
