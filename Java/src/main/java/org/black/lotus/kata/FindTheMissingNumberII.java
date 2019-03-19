package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

/**
 * Giving a string with number from 1-n in random order, but miss 1 number.Find that number.
 *
 * <p>Notice n <= 30
 *
 * <p>Example Given n = 20, str = 19201234567891011121314151618
 *
 * <p>return 17
 *
 * <p>TODO
 */
@LintCode
@FirstRound
@Medium
@NoIdeaOrBadIdeaInitially
public class FindTheMissingNumberII {
  public int findMissing2(int n, String str) {
    boolean[] happen = new boolean[n + 1];
    return -1;
  }
}
