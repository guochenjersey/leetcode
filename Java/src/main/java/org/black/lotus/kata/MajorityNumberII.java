package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

import java.util.List;

/**
 *
 * Given an array of integers, the majority number is the number that occurs more than 1/3 of the size of the array.

 Find it.

 Notice
 There is only one majority number in the array.

 Example
 Given [1, 2, 1, 2, 1, 3, 3], return 1.

 Challenge
 O(n) time and O(1) extra space.
 *
 *
 * */
@FirstRound
@LintCode
@NoIdeaOrBadIdeaInitially
public class MajorityNumberII {

    public int majorityNumber(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return -1;
        }

        int a = 0, b = 0, counterA = 0, counterB = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (counterA == 0 || nums.get(i) == a) {
                a = nums.get(i);
                ++counterA;
            } else if (counterB == 0 || nums.get(i) == b) {
                b = nums.get(i);
                ++counterB;
            } else {
                --counterA;
                --counterB;
                if (counterA == 0) {
                    counterA = 1;
                    a = nums.get(i);
                } else if (counterB == 0) {
                    counterB = 1;
                    b = nums.get(i);
                }
            }
        }

        counterA = 0;
        counterB = 0;
        for (int num : nums) {
            counterA += num == a ? 1 : 0;
            counterB += num == b ? 1 : 0;
        }
        return counterA > counterB ? a : b;
    }
}
