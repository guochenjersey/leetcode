package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * Given two strings A and B of lowercase letters, return true if and only if we can swap two
 * letters in A so that the result equals B.
 *
 * <p>Example 1:
 *
 * <p>Input: A = "ab", B = "ba" Output: true Example 2:
 *
 * <p>Input: A = "ab", B = "ab" Output: false
 *
 * <p>Example 3: Input: A = "aa", B = "aa" Output: true
 *
 * <p>Example 4: Input: A = "aaaaaaabc", B = "aaaaaaacb" Output: true
 *
 * <p>Example 5: Input: A = "", B = "aa" Output: false Note:
 *
 * <p>0 <= A.length <= 20000 0 <= B.length <= 20000 A and B consist only of lowercase letters.
 */
@LeetCode
@FirstRound
@Easy
public class BuddyStrings {

  public boolean buddyStrings(String s1, String s2) {
    boolean anyNull = s1 == null || s2 == null;
    if (anyNull) {
      return false;
    }

    if (s1.length() != s2.length()) {
      return false;
    }

    if (s1.equals(s2)) {
      Set<Character> set = new HashSet<>();
      for (int i = 0; i < s1.length(); ++i) {
        set.add(s1.charAt(i));
      }
      return set.size() != s1.length();
    }

    List<Integer> diffPos = new ArrayList<>();
    for (int i = 0; i < s1.length(); ++i) {
      if (s1.charAt(i) != s2.charAt(i)) {
        diffPos.add(i);
      }
    }

    if (diffPos.size() != 2) {
      return false;
    }

    return (s1.charAt(diffPos.get(0)) == s2.charAt(diffPos.get(1)))
        && (s1.charAt(diffPos.get(1)) == s2.charAt(diffPos.get(0)));
  }
}
