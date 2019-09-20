package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return
 * the length of last word in the string.
 *
 * <p>If the last word does not exist, return 0.
 *
 * <p>Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * <p>Example:
 *
 * <p>Input: "Hello World" Output: 5
 */
@LeetCode
@FirstRound
@Easy
@Accepted
public class LengthOfLastWord {

  public int lengthOfLastWord(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    String[] strings = s.split(" ");
    if (strings != null && strings.length > 0) {
      return strings[strings.length -1].length();
    }

    return 0;
  }
}
