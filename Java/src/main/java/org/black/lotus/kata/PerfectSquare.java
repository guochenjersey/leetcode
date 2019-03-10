package org.black.lotus.kata;

import org.black.lotus.marker.*;

import java.util.*;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 Example 1:

 Input: n = 12
 Output: 3
 Explanation: 12 = 4 + 4 + 4.
 Example 2:

 Input: n = 13
 Output: 2
 Explanation: 13 = 4 + 9.
 * */
@LeetCode
@Medium
@FirstRound
@Accepted
@BFS
public class PerfectSquare {

    public int numSquares(int n) {
        if (n < 1) {
            return 0;
        }
        int res = 1;
        int sqrtN = (int) Math.sqrt(n);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= sqrtN; ++i) {
            queue.offer(n - (i * i));
        }
        while (queue.size() != 0) {
            int size = queue.size();
            Set<Integer> numSet = new HashSet<>();
            while (size != 0) {
                Integer diff = queue.poll();
                if (diff == 0) {
                    return res;
                }
                if (diff < 0) {
                    continue;
                }

                int sqrt = (int) Math.sqrt(diff);
                for (int i = 1; i <= sqrt; ++i) {
                    numSet.add(diff - (i * i));
                }
                --size;
            }
            queue.addAll(numSet);
            ++res;
        }
        return res;
    }
}
