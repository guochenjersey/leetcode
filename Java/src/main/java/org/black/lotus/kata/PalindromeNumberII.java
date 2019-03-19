package org.black.lotus.kata;

import org.black.lotus.marker.Amazon;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.Important;

/**
 * Determines whether a binary representation of a non-negative integer n is a palindrome
 *
 * <p>Notice 0 <= n <= 2^32 - 1 Have you met this question in a real interview? Example Given n = 0,
 * return True
 *
 * <p>Explanation: The binary representation of 0 is: 0 Given n = 3, return True
 *
 * <p>Explanation: The binary representation of 3 is: 11 Given n = 4, return False
 *
 * <p>Explanation: The binary representation of 4 is: 100 Given n = 6, return False
 *
 * <p>Explanation: The binary representation of 6 is: 110
 */
@Easy
@Amazon
@Important
@FirstRound
public class PalindromeNumberII {

  public boolean isPalindrome(int n) {
    StringBuilder sb = new StringBuilder();
    int mask = 1;
    for (int i = 0; i < 32; ++i) {
      int x = (n >> i) & mask;
      sb.insert(0, x);
    }
    String binaryFormatN = sb.toString();

    return isPalindrome(binaryFormatN);
  }

  private boolean isPalindrome(String toCheck) {
    int start = 0;
    int end = toCheck.length() - 1;
    while (start <= end && toCheck.charAt(start) == '0') {
      ++start;
    }

    for (; start < end; ++start, --end) {
      if (toCheck.charAt(start) != toCheck.charAt(end)) {
        return false;
      }
    }

    return true;
  }
}
