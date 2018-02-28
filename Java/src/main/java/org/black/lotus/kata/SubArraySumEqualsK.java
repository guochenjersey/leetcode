package org.black.lotus.kata;

class Result {
  int res;
}

/**
 * !important
 * TODO
 * */
public class SubArraySumEqualsK {

  public int subarraySum(int[] nums, int target) {
    Result result = new Result();
    search(result, 0, nums.length - 1, nums, target);
    return result.res;
  }

  private void search(Result result,
      int startIndex,
      int endIndex,
      int[] nums,
      int target) {

    if (startIndex > nums.length - 1) {
      return;
    }

    for (int end = startIndex; end < nums.length; ++end) {
      if (sumOfSubArray(startIndex, endIndex, nums) == target) {
        ++result.res;
      }
      search(result, startIndex + 1, end, nums, target);
    }
  }

  private int sumOfSubArray(int i, int j, int[] nums) {
    int sum = 0;
    for (int k = i; k <= j; ++k) {
      sum += nums[k];
    }

    return sum;
  }

  public static void main(String... args) {
    int[] nums = {1, 2,1, 2, 1};
    SubArraySumEqualsK subArraySumEqualsK = new SubArraySumEqualsK();
    int i = subArraySumEqualsK.subarraySum(nums, 3);
    System.out.println(i);
  }
}
