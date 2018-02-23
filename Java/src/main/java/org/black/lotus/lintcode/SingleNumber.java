package org.black.lotus.lintcode;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;

@FirstRound
@LintCode
public class SingleNumber {
  public int singleNumber(int[] A) {
    int i = A[0];
    for (int j = 1; j < A.length; ++j) {
      i ^= A[j];
    }

    return i;
  }
}
