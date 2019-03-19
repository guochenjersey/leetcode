package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * Given an integer, write a function to determine if it is a power of three.
 *
 * <p>Example 1:
 *
 * <p>Input: 27 Output: true Example 2:
 *
 * <p>Input: 0 Output: false Example 3:
 *
 * <p>Input: 9 Output: true Example 4:
 *
 * <p>Input: 45 Output: false Follow up: Could you do it without using any loop / recursion?
 */
@LeetCode
@Easy
@FirstRound
public class PowerOfThree {
  public boolean isPowerOfThree(int n) {
    if (n == 1) {
      return true;
    }
    long product = 3;
    for (; product <= n; ) {
      if (product == n) {
        return true;
      }

      product *= 3;
    }

    return false;
  }
}
