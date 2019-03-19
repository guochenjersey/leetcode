package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

@LeetCode
@Easy
@FirstRound
public class FibonacciNumber {

  public int fib(int N) {
    int nMinus2 = 0, nMinus1 = 1;
    if (N == 0) {
      return 0;
    }
    if (N == 1) {
      return 1;
    }

    int s = 2, n = (nMinus1 + nMinus2);
    while (s != N) {
      ++s;
      int tmp = n;
      n += nMinus1;
      nMinus1 = tmp;
    }

    return n;
  }
}
