package org.black.lotus.kata;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;

@FirstRound
@LintCode
@Accepted
public class LongestPalindrome {

  public int longestPalindrome(String source) {
    return (source == null || source.length() == 0)
        ? 0
        : calculateLongestPalindrome(findCharsOccurance(source));
  }

  private int calculateLongestPalindrome(Map<Character, Integer> charsOccuranceMap) {
    Collection<Integer> values = charsOccuranceMap.values();
    boolean havingOddNumber = false;
    int res = 0;
    for (Integer v : values) {
      if (v % 2 != 0) {
        if (!havingOddNumber) {
          havingOddNumber = true;
        }
        res = v - 1 > 0 ? res + v - 1 : res;
      } else {
        res += v;
      }
    }

    if (havingOddNumber) {
      res++;
    }
    return res;
  }

  private Map<Character, Integer> findCharsOccurance(String source) {
    Map<Character, Integer> charOccuranceMap = new HashMap<>();
    char[] sourceCharArray = source.toCharArray();
    for (char c : sourceCharArray) {
      charOccuranceMap.putIfAbsent(c, 0);
      charOccuranceMap.computeIfPresent(c, (k, v) -> ++v);
    }

    return charOccuranceMap;
  }
}
