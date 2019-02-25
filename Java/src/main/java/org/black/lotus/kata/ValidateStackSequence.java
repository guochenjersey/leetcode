package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Given two sequences pushed and popped with distinct values, return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * Output: true
 * Explanation: We might do the following sequence:
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * Example 2:
 * <p>
 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * Output: false
 * Explanation: 1 cannot be popped before 2.
 */
@LeetCode
@Medium
@FirstRound
public class ValidateStackSequence {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null && popped == null) {
            return true;
        }
        if (pushed.length == 0 && popped.length == 0) {
            return true;
        }

        int visited = 0;
        Deque<Integer> deque = new LinkedList<>();
        int firstPopped = popped[0];
        for (int i = 0; i < pushed.length; ++i) {
            if (pushed[i] != firstPopped) {
                deque.offerFirst(pushed[i]);
                visited = i;
            } else {
                visited = i;
                break;
            }
        }

        for (int j = 1; j < popped.length; ) {

            if (deque.isEmpty() || popped[j] != deque.peekFirst()) {
                ++visited;
                if (visited > pushed.length - 1) {
                    return false;
                }

                deque.offerFirst(pushed[visited]);
            } else {
                deque.pollFirst();
                ++j;
            }
        }

        return true;
    }
}
