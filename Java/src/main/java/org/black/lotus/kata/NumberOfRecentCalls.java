package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.NotAccepted;

/**
 * Write a class RecentCounter to count recent requests.
 *
 * <p>It has only one method: ping(int t), where t represents some time in milliseconds.
 *
 * <p>Return the number of pings that have been made from 3000 milliseconds ago until now.
 *
 * <p>Any ping with time in [t - 3000, t] will count, including the current ping.
 *
 * <p>It is guaranteed that every call to ping uses a strictly larger value of t than before.
 *
 * <p>Example 1:
 *
 * <p>Input: inputs = ["RecentCounter","ping","ping","ping","ping"], inputs =
 * [[],[1],[100],[3001],[3002]] Output: [null,1,2,3,3]
 *
 * <p>Note:
 *
 * <p>Each test case will have at most 10000 calls to ping. Each test case will call ping with
 * strictly increasing values of t. Each call to ping will have 1 <= t <= 10^9.
 */
@LeetCode
@Easy
@FirstRound
@NotAccepted
public class NumberOfRecentCalls {

  public NumberOfRecentCalls() {}

  public int ping(int t) {
    return 0;
  }
}
