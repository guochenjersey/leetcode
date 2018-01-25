package org.black.lotus.lintcode;

/**
 *
 * TODO No idea how to do that. Should be binary search.
 * */
public class MedianOfTwoSortedArray {

  public double findMedianSortedArray(int[] nums1, int[] nums2) {
    int num1Start = 0;
    int num1End = nums1.length - 1;

    int num2Start = 0;
    int num2End = nums2.length - 1;

    while (num1Start + 1 < num1End) {
      int num1Middle = num1Start + (num1End - num1Start) / 2;
      int num2Middle = num2Start + (num2End - num2Start) / 2;
      if (nums1[num1Middle] >= nums2[num2Middle]) {

      }
    }

    return 0.0d;
  }

  private boolean isEven(int[] nums1, int[] nums2) {
    int nums = nums1.length + nums2.length;
    return nums % 2 == 0;
  }
}
