package org.black.lotus.kata;

import org.black.lotus.marker.*;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a
 * palindrome.
 *
 * <p>Example 1: Input: "aba" Output: True Example 2: Input: "abca" Output: True
 * Explanation: You
 * could delete the character 'c'.
 */
@LeetCode
@Easy
@Accepted("faster than 99%")
public class ValidPalindromeII {

  public boolean validPalindrome(String s) {
    if (s == null) {
      return false;
    }

    if (s.length() == 0) {
      return true;
    }

    for (int i = 0, j = s.length() - 1; i < j; ) {
        if (s.charAt(i) == s.charAt(j)) {
            ++i;
            --j;
            continue;
        }

        if (i + 1 == j) {
            return true;
        }

        return isValidPalindrome(s.substring(i + 1, j + 1))
                || isValidPalindrome(s.substring(i, j));
    }

    return true;
  }

  private boolean isValidPalindrome(String s) {
    for (int i = 0, j = s.length() - 1; i < j;) {
        if (s.charAt(i) != s.charAt(j)) {
            return false;
        }
        ++i;
        --j;
    }

    return true;
  }
}
