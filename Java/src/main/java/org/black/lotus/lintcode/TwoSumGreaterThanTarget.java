package org.black.lotus.lintcode;

import java.util.Arrays;
import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Google;
import org.black.lotus.marker.HaveNotCheckAnswer;

@Google @Accepted @HaveNotCheckAnswer
public class TwoSumGreaterThanTarget {

  public int twoSum2TwoPointer(int[] nums, int target) {
    if (nums == null || nums.length < 2) {
      return 0;
    }

    Arrays.sort(nums);

    int left = 0, right = nums.length - 1;
    int count = 0;
    while (left < right) {
      if (nums[left] + nums[right] <= target) {
        left++;
      } else {
        count += right - left;
        right--;
      }
    }

    return count;
  }

  public int twoSum2(int[] nums, int target) {
    Integer[] sortedNums = Arrays.stream(nums)
        .boxed()
        .sorted((o1, o2) -> o2 - o1)
        .toArray(Integer[]::new);

    int result = 0;

    for (int i = 0; i < sortedNums.length; ++i) {
      for (int j = i + 1; j < sortedNums.length; ++j) {
        if (sortedNums[i] + sortedNums[j] <= target) {
          break;
        }
        ++result;
      }
    }
    return result;
  }

}
