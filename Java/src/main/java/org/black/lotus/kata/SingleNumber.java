package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;

@FirstRound
@LintCode @Accepted
@Medium
public class SingleNumber {
  public int singleNumber(int[] A) {
    int i = A[0];
    for (int j = 1; j < A.length; ++j) {
      i ^= A[j];
    }

    return i;
  }
}
