package org.black.lotus.kata;

import java.math.BigInteger;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

/**
 * Find the largest palindrome made from the product of two n-digit numbers.
 *
 * <p>Since the result could be very large, you should return the largest palindrome mod 1337.
 *
 * <p>Example:
 *
 * <p>Input: 2
 *
 * <p>Output: 987
 *
 * <p>Explanation: 99 x 91 = 9009, 9009 % 1337 = 987
 *
 * <p>Note:
 *
 * <p>The range of n is [1,8].
 *
 * <p>TODO
 */
@LeetCode
@FirstRound
@Easy
@NoIdeaOrBadIdeaInitially
public class LargestPalindromeProduct {

  public int largestPalindrome(int n) {
    BigInteger biggestNdigitLeft = findBiggestNdigit(n);
    BigInteger right = new BigInteger(biggestNdigitLeft.toString());
    while (biggestNdigitLeft.compareTo(BigInteger.ZERO) > 0) {
      while (right.compareTo(BigInteger.ZERO) > 0) {
        BigInteger numToCheck = biggestNdigitLeft.multiply(right);
        if (isPalindrome(numToCheck.toString())) {
          System.out.println("right " + right.toString());
          System.out.println("left " + biggestNdigitLeft);

          return numToCheck.mod(new BigInteger("1337")).intValue();
        }
      }
      biggestNdigitLeft = biggestNdigitLeft.subtract(BigInteger.ONE);
    }

    return -1;
  }

  private BigInteger findBiggestNdigit(int n) {
    BigInteger num = new BigInteger("1");
    while (n > 0) {
      num = num.multiply(BigInteger.TEN);
      --n;
    }

    return num.subtract(BigInteger.ONE);
  }

  private boolean isPalindrome(String s) {
    int start = 0;
    int end = s.length() - 1;
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      ++start;
      --end;
    }
    return true;
  }
}
