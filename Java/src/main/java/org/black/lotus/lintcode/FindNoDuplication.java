package org.black.lotus.lintcode;

import java.util.Arrays;
import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Amazon;

/**
 * Array with 2n+1 element, n element got duplication
 * and only 1 not. Please find it out.
 * */
@Amazon @Accepted
public class FindNoDuplication {

  public int findNoDuplication(int[] nums) {
    int result = 0;
    for (int i = 0; i<nums.length; ++i) {
      result ^= nums[i];
    }

    return result;
  }

  public static void main(String... args) {
    int[] nums = {1, 1, 2, 2, 3};
    System.out.println(new FindNoDuplication().findNoDuplication(nums));
    System.out.println(2 ^ 3);
    System.out.println(2 ^ 40);
  }
}
