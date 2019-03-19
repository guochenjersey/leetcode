package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

/**
 * Description Write an algorithm which computes the number of trailing zeros in n factorial.
 *
 * <p>Have you met this question in a real interview? Example 11! = 39916800, so the out should be 2
 *
 * <p>Challenge O(log N) time
 *
 * <p>n = 5: There is one 5 and 3 2s in prime factors of 5! (2 * 2 * 2 * 3 * 5). So count of
 * trailing 0s is 1.
 *
 * <p>n = 11: There are two 5s and three 2s in prime factors of 11! (2 8 * 34 * 52 * 7). So count of
 * trailing 0s is 2.
 *
 * <p>We can easily observe that the number of 2s in prime factors is always more than or equal to
 * the number of 5s. So if we count 5s in prime factors, we are done. How to count total number of
 * 5s in prime factors of n!? A simple way is to calculate floor(n/5). For example, 7! has one 5,
 * 10! has two 5s. It is done yet, there is one more thing to consider. Numbers like 25, 125, etc
 * have more than one 5. For example if we consider 28!, we get one extra 5 and number of 0s become
 * 6. Handling this is simple, first divide n by 5 and remove all single 5s, then divide by 25 to
 * remove extra 5s and so on. Following is the summarized formula for counting trailing 0s.
 */
@LintCode
@FirstRound
@Easy
@NoIdeaOrBadIdeaInitially
public class TrailingZeros {

  /*
   * @param n: An integer
   * @return: An integer, denote the number of trailing zeros in n!
   */
  public long trailingZeros(long n) {
    long count = 0;

    // Keep dividing n by powers
    // of 5 and update count
    for (long i = 5; n / i >= 1; i *= 5) count += n / i;

    return count;
  }
}
