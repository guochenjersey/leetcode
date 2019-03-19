package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.NotAccepted;

/**
 * Given an array of characters, compress it in-place.
 *
 * <p>The length after compression must always be smaller than or equal to the original array.
 *
 * <p>Every element of the array should be a character (not int) of length 1.
 *
 * <p>After you are done modifying the input array in-place, return the new length of the array.
 *
 * <p>
 *
 * <p>Follow up: Could you solve it using only O(1) extra space?
 *
 * <p>
 *
 * <p>Example 1:
 *
 * <p>Input: ["a","a","b","b","c","c","c"]
 *
 * <p>Output: Return 6, and the first 6 characters of the input array should be:
 * ["a","2","b","2","c","3"]
 *
 * <p>Explanation: "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 *
 * <p>
 *
 * <p>Example 2:
 *
 * <p>Input: ["a"]
 *
 * <p>Output: Return 1, and the first 1 characters of the input array should be: ["a"]
 *
 * <p>Explanation: Nothing is replaced.
 *
 * <p>
 *
 * <p>Example 3:
 *
 * <p>Input: ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 *
 * <p>Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 *
 * <p>Explanation: Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is
 * replaced by "b12". Notice each digit has it's own entry in the array.
 *
 * <p>
 *
 * <p>Note:
 *
 * <p>All characters have an ASCII value in [35, 126]. 1 <= len(chars) <= 1000.
 */
@LeetCode
@Easy
@FirstRound
@NotAccepted
public class StringCompression {

  public int compress(char[] chars) {
    if (chars == null || chars.length == 0) {
      return 0;
    }

    if (chars.length == 1) {
      return 1;
    }

    StringBuilder res = new StringBuilder();
    char c = chars[0];
    int count = 1;
    res.append(chars[0]);
    for (int i = 1; i < chars.length; ++i) {
      if (c == chars[i]) {
        ++count;
      } else {
        if (count != 1) {
          res.append(String.valueOf(count));
        }
        c = chars[i];
        res.append(c);
        count = 1;
      }
    }

    if (count != 1) {
      res.append(String.valueOf(count));
    }

    return res.toString().length();
  }
}
