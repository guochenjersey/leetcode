package org.black.lotus.kata;

import java.util.Stack;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.Important;
import org.black.lotus.marker.LeetCode;

/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells
 * you how many days you would have to wait until a warmer temperature. If there is no future day
 * for which this is possible, put 0 instead.
 *
 * <p>For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output
 * should be [1, 1, 4, 2, 1, 1, 0, 0].
 *
 * <p>Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an
 * integer in the range [30, 100].
 *
 * <p>It's a O(n) solution for next greater val in array
 */
@LeetCode
@Easy
@Important
public class DailyTemperatures {

  public int[] dailyTemperatures(int[] T) {
    if (T == null || T.length == 0) {
      return null;
    }

    int[] res = new int[T.length];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < T.length; ++i) {
      // descending stack is used to track the passed array elements.
      while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
        Integer idx = stack.pop();
        res[idx] = i - idx;
      }
      stack.push(i);
    }

    return res;
  }
}
