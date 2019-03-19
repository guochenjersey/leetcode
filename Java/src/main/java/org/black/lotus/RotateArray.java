package org.black.lotus;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Amazon;
import org.black.lotus.marker.LeetCode;

@LeetCode
@Amazon
@Accepted
public class RotateArray {

  public void rotate(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return;
    }

    // be careful here
    k = k % nums.length;

    int[] res = new int[nums.length];
    for (int i = nums.length - k, j = 0; i < nums.length; ++i, ++j) {
      res[j] = nums[i];
    }
    System.arraycopy(nums, 0, res, k, nums.length - k);
    System.arraycopy(res, 0, nums, 0, res.length);
  }

  public void o1Rotate(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return;
    }

    int numsLength = nums.length;
    k = k % numsLength;

    for (int i = numsLength - k, j = 0; i < numsLength; ++i, ++j) {
      toTargetPos(j, i, nums);
    }
  }

  private void toTargetPos(int targetPos, int sourcePos, int[] nums) {
    while (sourcePos != targetPos) {
      int temp = nums[sourcePos];
      nums[sourcePos] = nums[sourcePos - 1];
      nums[sourcePos - 1] = temp;
      --sourcePos;
    }
  }
}
