package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * Implement int sqrt(int x).
 *
 * <p>Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * <p>Since the return type is an integer, the decimal digits are truncated and only the integer
 * part of the result is returned.
 *
 * <p>Example 1:
 *
 * <p>Input: 4 Output: 2 Example 2:
 *
 * <p>Input: 8 Output: 2 Explanation: The square root of 8 is 2.82842..., and since the decimal part
 * is truncated, 2 is returned.
 */
@LeetCode
@Easy
@FirstRound
@Accepted
public class SqrtX {

  public int mySqrt(int x) {
    long low = 0;
    long high = x;
    // converted into a binary search
    long mid = (high + low) / 2;
    for (; ; ) {
      long midProduct = mid * mid;
      long midPlusOneProduct = (mid + 1) * (mid + 1);
      if (midProduct == x) {
        return (int) mid;
      }

      if (midPlusOneProduct * midPlusOneProduct == x) {
        return (int) (mid + 1);
      }

      if (midProduct < x && midPlusOneProduct > x) {
        return (int) mid;
      }

      if (midProduct > x) {
        high = mid;
        mid = (high + low) / 2;
        continue;
      }

      if (midProduct < x) {
        low = mid;
        mid = (high + low) / 2;
        continue;
      }
    }
  }
}
