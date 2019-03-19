package org.black.lotus.kata;

import org.black.lotus.marker.Amazon;
import org.black.lotus.marker.Important;
import org.black.lotus.marker.NotAccepted;

/** Array with 2n + 2, n has duplicate, find those 2 having no duplicate */
@Amazon
@NotAccepted
@Important
public class FindNoDuplicationII {

  public int[] findNoDuplication(int[] nums) {
    int[] result = new int[2];
    int temp = 0;
    for (int i = 0; i < nums.length; ++i) {
      temp ^= nums[i];
    }

    return result;
  }
}
