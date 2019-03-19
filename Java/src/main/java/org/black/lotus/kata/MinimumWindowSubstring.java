package org.black.lotus.kata;

import java.util.HashMap;
import java.util.Map;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

/** TODO need to fully understand and redo */
@LintCode
@FirstRound
@Medium
@NoIdeaOrBadIdeaInitially
public class MinimumWindowSubstring {

  private String min;

  public String minWindow(String s, String t) {
    if (s == null || s.length() == 0 || t == null || t.length() == 0) {
      return "";
    }
    // Init map based on t
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      if (!map.containsKey(c)) {
        map.put(c, 0);
      }
      map.put(c, map.get(c) + 1);
    }

    int count = 0;
    int start = 0;
    int end = 0;
    int lengS = s.length();
    int leng = Integer.MAX_VALUE;
    String rst = "";

    for (; end < lengS; end++) {
      char c = s.charAt(end);
      map.computeIfPresent(c, (k, v) -> v - 1);
      if (map.get(c) == 0) {
        ++count;
      }

      while (start < lengS) {
        char cs = s.charAt(start);
        if (map.containsKey(cs)) {
          // If >= 0 still being used in map, not ready yet: can't move
          if (map.get(cs) >= 0) {
            break;
          } else { // less than 0, so we can skip previous cs, move start++
            map.put(cs, map.get(cs) + 1);
          }
        }
        // skip non-t chars
        start++;
      }

      if (count == map.size() && (end - start + 1) < leng) {
        rst = s.substring(start, end + 1);
        leng = rst.length();
      }
    } // end for

    return rst;
  }

  /** The algorithm is correct but too slow. */
  public String lfsMinWindow(String source, String target) {
    if (target == null || target.length() == 0) {
      return "";
    }

    min = source;

    find(source, target, 0);

    return min;
  }

  private void find(String source, String target, int startIndex) {
    if (startIndex > source.length()) {
      return;
    }

    for (int i = startIndex + 1; i <= source.length(); ++i) {
      String subString = source.substring(startIndex, i);
      if (subString.length() >= min.length()) {
        return;
      } else if (contains(subString, target)) {
        min = subString;
      }

      find(source, target, startIndex + 1);
    }
  }

  private boolean contains(String source, String target) {
    Map<Character, Integer> sourceMap = new HashMap<>();
    char[] chars = source.toCharArray();
    for (Character c : chars) {
      sourceMap.putIfAbsent(c, 0);
      sourceMap.computeIfPresent(c, (k, v) -> v + 1);
    }
    char[] chars1 = target.toCharArray();
    for (Character c : chars1) {
      if (!sourceMap.containsKey(c)) {
        return false;
      }
      sourceMap.compute(c, (k, v) -> v - 1);
      if (sourceMap.get(c) < 0) {
        return false;
      }
    }
    return true;
  }
}
