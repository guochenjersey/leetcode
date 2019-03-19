package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.List;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * Given a string S and a character C, return an array of integers representing the shortest
 * distance from the character C in the string.
 *
 * <p>Example 1:
 *
 * <p>Input: S = "loveleetcode", C = 'e' Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 *
 * <p>Note:
 *
 * <p>S string length is in [1, 10000]. C is a single character, and guaranteed to be in string S.
 * All letters in S and C are lowercase.
 */
@LeetCode
@Easy
@FirstRound
public class ShortestDistanceToACharacter {
  public int[] shortestToChar(String s, char c) {
    int[] res = new int[s.length()];
    List<Integer> cPos = new ArrayList<>();
    for (int i = 0; i < s.length(); ++i) {
      char c1 = s.charAt(i);
      if (c == c1) {
        cPos.add(i);
      }
    }

    for (int i = 0; i < s.length(); ++i) {
      int d = Integer.MAX_VALUE;
      for (int j : cPos) {
        d = Math.min(d, Math.abs(j - i));
      }
      res[i] = d;
    }

    return res;
  }
}
