package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such
 * that a2 + b2 = c.
 *
 * <p>Example 1: Input: 5 Output: True Explanation: 1 * 1 + 2 * 2 = 5 Example 2: Input: 3 Output:
 * False
 */
@LeetCode
@FirstRound
@Easy
@Accepted
public class SumOfSquareNumbers {

  public boolean judgeSquareSum(int c) {
    if (c == 0) {
      return true;
    }
    // key part to avoid overflow
    long num = (long) c;
    boolean res = false;
    for (long i = 0; i * i < num; ++i) {
      long j = c - i * i;
      long sqrt = (int) Math.sqrt(j);
      long sqrt1 = sqrt + 1;
      long iSquare = i * i;
      if (sqrt * sqrt + iSquare == c || sqrt1 * sqrt1 + iSquare == c) {
        return true;
      }
    }

    return res;
  }
}
