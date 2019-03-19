package org.black.lotus.kata;

import java.util.HashMap;
import java.util.Map;
import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * <p>Here follow means a full match, such that there is a bijection between a letter in pattern and
 * a non-empty word in str.
 *
 * <p>Example 1:
 *
 * <p>Input: pattern = "abba", str = "dog cat cat dog" Output: true Example 2:
 *
 * <p>Input:pattern = "abba", str = "dog cat cat fish" Output: false Example 3:
 *
 * <p>Input: pattern = "aaaa", str = "dog cat cat dog" Output: false Example 4:
 *
 * <p>Input: pattern = "abba", str = "dog dog dog dog" Output: false
 *
 * <p>Two way hash
 */
@LeetCode
@FirstRound
@Easy
@Accepted
public class WordPattern {

  public boolean wordPattern(String pattern, String str) {
    if (str == null) {
      return false;
    }
    String[] splittedStr = str.split(" ");
    if (splittedStr.length != pattern.length()) {
      return false;
    }
    Map<Character, String> rulesFromPatternToStr = new HashMap<>();
    Map<String, Character> rulesFromStrToPattern = new HashMap<>();
    for (int i = 0; i < pattern.length(); ++i) {
      char patn = pattern.charAt(i);
      String s = splittedStr[i];

      if (rulesFromPatternToStr.get(patn) == null && rulesFromStrToPattern.get(s) == null) {
        rulesFromPatternToStr.put(patn, s);
        rulesFromStrToPattern.put(s, patn);
        continue;
      }

      if (rulesFromPatternToStr.get(patn) != null
          && !rulesFromPatternToStr.get(patn).equals(splittedStr[i])) {
        return false;
      }

      if (rulesFromStrToPattern.get(s) != null && !rulesFromStrToPattern.get((s)).equals(patn)) {
        return false;
      }
    }
    return true;
  }
}
