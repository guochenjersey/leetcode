package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * Given a string and an integer k, you need to reverse the first k characters for every 2k
 * characters counting from the start of the string. If there are less than k characters left,
 * reverse all of them. If there are less than 2k but greater than or equal to k characters, then
 * reverse the first k characters and left the other as original. Example: Input: s = "abcdefg", k =
 * 2 Output: "bacdfeg" Restrictions: The string consists of lower English letters only. Length of
 * the given string and k will in the range [1, 10000] Accepted 52,416 Submissions 116,942
 */
@LeetCode
@Easy
@FirstRound
@Accepted
public class ReverseStringII {
  public String reverseStr(String s, int k) {
    if (s == null) {
      return null;
    }

    if (s.length() == 0) {
      return "";
    }

    char[] chars = s.toCharArray();
    for (int i = 0; i < s.length(); ) {
      reverse(chars, i, i + k - 1);
      i += 2 * k;
    }

    return new String(chars);
  }

  private void reverse(char[] source, int start, int end) {
    if (end > source.length - 1) {
      end = source.length - 1;
    }
    for (int i = start, j = end; i < j; ++i, --j) {
      char temp = source[i];
      source[i] = source[j];
      source[j] = temp;
    }
  }
}
