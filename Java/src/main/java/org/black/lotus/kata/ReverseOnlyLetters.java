package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in
 * the same place, and all letters reverse their positions.
 *
 * <p>Example 1:
 *
 * <p>Input: "ab-cd" Output: "dc-ba" Example 2:
 *
 * <p>Input: "a-bC-dEf-ghIj" Output: "j-Ih-gfE-dCba" Example 3:
 *
 * <p>Input: "Test1ng-Leet=code-Q!" Output: "Qedo1ct-eeLg=ntse-T!"
 */
@LeetCode
@FirstRound
@Easy
public class ReverseOnlyLetters {
  public String reverseOnlyLetters(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }

    char[] res = new char[s.length()];
    System.arraycopy(s.toCharArray(), 0, res, 0, s.length());
    int i = 0;
    int j = s.length() - 1;
    for (; i < j; ) {
      if (shouldChange(s.charAt(i)) && shouldChange(s.charAt(j))) {
        res[i] = s.charAt(j);
        res[j] = s.charAt(i);
        ++i;
        --j;
        continue;
      }
      if (!shouldChange(s.charAt(i))) {
        res[i] = s.charAt(i);
        ++i;
      }

      if (!shouldChange(s.charAt(j))) {
        res[j] = s.charAt(j);
        --j;
      }
    }

    return new String(res);
  }

  private boolean shouldChange(char c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
  }
}
