package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

/**
 * Today, the bookstore owner has a store open for customers.length minutes.  Every minute, some number of customers (customers[i]) enter the store, and all those customers leave after the end of that minute.
 *
 * On some minutes, the bookstore owner is grumpy.  If the bookstore owner is grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0.  When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.
 *
 * The bookstore owner knows a secret technique to keep themselves not grumpy for X minutes straight, but can only use it once.
 *
 * Return the maximum number of customers that can be satisfied throughout the day.
 *
 * Example 1:
 *
 * Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * Output: 16
 * Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes.
 * The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 * */
@LeetCode
@Medium
@FirstRound
@Accepted("85%")
public class GrumpyStoreOwner {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        if (customers == null || customers.length == 0) {
            return 0;
        }

        int[] grumpyAffectedCustomers = new int[customers.length];
        for (int i = 0; i < grumpy.length; ++i) {
            if (grumpy[i] == 1) {
                grumpyAffectedCustomers[i] = customers[i];
            }
        }
        int startIdx = maxConsecutiveVal(X, grumpyAffectedCustomers);

        int maxVal = 0;
        for (int i = 0; i < customers.length; ++i) {
            if ((grumpy[i] == 1) && ((i < startIdx) || (i >= startIdx + X)))
                continue;
            else
                maxVal += customers[i];
        }

        return maxVal;
    }

    private int maxConsecutiveVal(int x, int[] grumpyAffectedCustomers) {
        int maxStartIdx = 0;
        int maxVal = 0;
        for (int i = 0; i < x; ++i) {
            maxVal += grumpyAffectedCustomers[i];
        }
        int max = maxVal;
        for (int i = x; i < grumpyAffectedCustomers.length; ++i) {
            max = max + grumpyAffectedCustomers[i] - grumpyAffectedCustomers[i - x];
            if (max > maxVal) {
                maxStartIdx = i - x + 1;
                maxVal = max;
            }
        }

        return maxStartIdx;
    }
}
