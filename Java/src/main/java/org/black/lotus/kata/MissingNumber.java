package org.black.lotus.kata;

import java.util.Arrays;
import org.black.lotus.marker.Accepted;

@Accepted
public class MissingNumber {

  public int missingNumber(int[] nums) {
    long target = targetSum(nums);
    long l = target - Arrays.stream(nums).sum();
    return (int)l;
  }

  private long targetSum(int[] nums) {
    long end = nums.length;
    long sum = end * (end + 1) >> 1;
    return sum;
  }
}
