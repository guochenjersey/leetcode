package org.black.lotus.kata;

public class SearchForARange {
  private static int[] NOT_FOUND = {-1, -1};

  public int[] searchRange(int[] nums, int target) {
    int[] res = new int[2];
    System.arraycopy(NOT_FOUND, 0, res, 0, 2);
    if (nums == null || nums.length == 0) {
      return NOT_FOUND;
    }

    boolean found = false;
    int start = 0;
    int end = nums.length - 1;
    while (start + 1 < end) {
      int middle = start + (end - start) / 2;
      if (nums[middle] > target) {
        end = middle;
      } else if (nums[middle] < target) {
        start = middle;
      } else if (nums[middle] == target) {
        found = true;
        res[0] = searchLower(nums, start, middle, target);
        res[1] = searchUpper(nums, middle, end, target);

        break;
      }
    }

    if (found) {
      return res;
    } else {
      if (nums[start] == target) {
        res[0] = start;
      }
      if (nums[end] == target) {
        res[1] = end;
      }

      if (res[0] != -1 && res[1] == -1) {
        res[1] = res[0];
      }

      if (res[0] == -1 && res[1] != -1) {
        res[0] = res[1];
      }
      return res;
    }

  }

  private int searchUpper(int[] nums, int start, int end, int target) {
    int copyStart = start;
    while (start + 1 < end) {
      int middle = start + (end - start) / 2;
      if (nums[middle] == target) {
        start = middle;
      } else if (nums[middle] > target) {
        end = middle;
      }
    }
    if (nums[end] == target) {
      return end;
    }
    if (nums[start] == target) {
      return start;
    }

    return copyStart;
  }

  private int searchLower(int[] nums, int start, int end, int target) {
    int copyEnd = end;
    while (start + 1 < end) {
      int middle = start + (end - start) / 2;
      if (nums[middle] == target) {
        end = middle;
      } else if (nums[middle] < target) {
        start = middle;
      }
    }
    if (nums[start] == target) {
      return start;
    }
    if (nums[end] == target) {
      return end;
    }

    return copyEnd;
  }
}
