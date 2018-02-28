package org.black.lotus.kata;

public class MaxNumberInMountainSequence {

  public int mountainSequence(int[] source) {
    int start = 0;
    int end = source.length - 1;

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (isPeak(mid, source)) {
        return source[mid];
      }

      if (source[start] < source[mid]) {
        if (source[mid] < source[mid + 1]) {
          start = mid;
        } else {
          end = mid;
        }
      } else if (source[mid] < source[end]) {
        if (source[mid] > source[mid + 1]) {
          end = mid;
        } else {
          start = mid;
        }
      } else if (source[mid] > source[end]) {
        if (source[mid] > source[mid + 1]) {
          end = mid;
        }
      }
    }

    return Math.max(source[start], source[end]);
  }

  private boolean isPeak(int mid, int[] nums) {
    return nums.length == 1
        || (nums.length == 2 && nums[mid] > nums[mid + 1])
        || (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]);
  }

  public static void main(String... args) {
    MaxNumberInMountainSequence maxNumberInMountainSequence = new MaxNumberInMountainSequence();
    int[] source = {10, 9, 8, 7, 6};
    int i = maxNumberInMountainSequence.mountainSequence(source);
    System.out.println(i);
  }
}
