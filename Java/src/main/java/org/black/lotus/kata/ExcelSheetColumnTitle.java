package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * <p>For example:
 *
 * <p>1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB ... Example 1: Input: 1 Output: "A"
 *
 * <p>Example 2: Input: 28 Output: "AB"
 *
 * <p>Example 3: Input: 701 Output: "ZY" 注意这个题目不是标准的进制,它没有0的表示.
 */
@LeetCode
@Easy
@FirstRound
@NoIdeaOrBadIdeaInitially
public class ExcelSheetColumnTitle {

  public String convertToTitle(int n) {
    String res = "";
    while (n > 0) {
      res = (char) ((n - 1) % 26 + 'A') + res;
      n = (n - 1) / 26;
    }

    return res;
  }
}
