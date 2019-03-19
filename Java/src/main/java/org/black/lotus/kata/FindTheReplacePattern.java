package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

/**
 * You have a list of words and a pattern, and you want to know which words in words matches the
 * pattern.
 *
 * <p>A word matches the pattern if there exists a permutation of letters p so that after replacing
 * every letter x in the pattern with p(x), we get the desired word.
 *
 * <p>(Recall that a permutation of letters is a bijection from letters to letters: every letter
 * maps to another letter, and no two letters map to the same letter.)
 *
 * <p>Return a list of the words in words that match the given pattern.
 *
 * <p>You may return the answer in any order.
 *
 * <p>
 *
 * <p>
 *
 * <p>Example 1:
 *
 * <p>Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb" Output: ["mee","aqq"]
 * Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
 * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and
 * b map to the same letter.
 *
 * <p>
 *
 * <p>Note:
 *
 * <p>1 <= words.length <= 50 1 <= pattern.length = words[i].length <= 20
 */
@LeetCode
@Medium
@FirstRound
public class FindTheReplacePattern {

  public List<String> findAndReplacePattern(String[] words, String pattern) {
    List<String> res = new ArrayList<>();
    if (words == null || words.length == 0) {
      return res;
    }

    for (String s : words) {
      if (pattern.length() != s.length()) {
        continue;
      }

      char[] toCheck = s.toCharArray();
      char[] pattrn = pattern.toCharArray();
      boolean isValid = true;
      Map<Character, Character> sToPMap = new HashMap<>(256);
      Map<Character, Character> pToSMap = new HashMap<>(256);
      for (int i = 0; i < toCheck.length; ++i) {
        Character c = toCheck[i];
        Character p = pattrn[i];
        if (pToSMap.get(p) == null) {
          sToPMap.putIfAbsent(c, p);
          if (!sToPMap.get(c).equals(p)) {
            isValid = false;
            break;
          }
          pToSMap.put(p, c);
        } else {
          Character expectedC = pToSMap.get(p);
          if (!expectedC.equals(c)) {
            isValid = false;
            break;
          }
        }
      }

      if (isValid) res.add(s);
    }
    return res;
  }
}
