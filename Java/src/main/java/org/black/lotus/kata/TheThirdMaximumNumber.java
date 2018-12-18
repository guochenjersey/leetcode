package org.black.lotus.kata;


import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

import java.util.*;

/**
 * Example 1:
 Input: [3, 2, 1]

 Output: 1

 Explanation: The third maximum is 1.
 Example 2:
 Input: [1, 2]

 Output: 2

 Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 Example 3:
 Input: [2, 2, 3, 1]

 Output: 1

 Explanation: Note that the third maximum here means the third maximum distinct number.
 Both numbers with value 2 are both considered as second maximum.
 *
 * */
@LeetCode
@Easy
@FirstRound
public class TheThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        // note one value Integer.Min_VAL and another is 1. and hence the comparator should be written like below.
        PriorityQueue<Long> pq = new PriorityQueue<>((o1, o2) -> {
            if (o2 - o1 == 0) {
                return 0;
            }

            return o2 - o1 > 0 ? 1 : -1;
        });

        for (int i = 0; i < nums.length; ++i) {
            pq.offer((long)nums[i]);
        }
        long maxVal = pq.peek();
        long res = pq.peek();
        int count = 2;
        while(!pq.isEmpty()) {
            if (pq.peek() < res) {
                --count;
                res = pq.poll();
                if (count == 0) {
                    return (int)res;
                }
            } else {
                pq.poll();
            }
        }

        return (int)maxVal;
    }
}
