package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThreeSumClosestTest {

  @Test
  public void should_find_closest() {
    int[] nums = {
      -17, -12, -28, 77, -28, -63, -88, 40, 70, -97, -57, 15, 45, 37, -85, -74, 29, -80, 92, -62,
      44, 26, -46, 54, 74, 11, 16, -64, -58, 56, 23, -77, 48, 7, -44, 92, -25, 85, -16, -87, 22, 52,
      57, 66, 83, -90, 84, -56, -54, -2, -98, -52, 78, 93, 7, 49, -10, -34, 49, -14, 87, -69, 1,
      -67, 53, -85, 29, -4, -39, 66, 8, 42, -48, -18, -41, 94, -1, 64, 52, 90, 32, 53, -10, 0, -86,
      -94, -13, 45, 43, -23, 61, -78, -44, -30, -3, 32, 94, 30, 74, 51, 63, -87, 46, 3, 61, -39, 9,
      50, -23, 82, -100, -95, -31, -62, 88, -98, 22, 93, -81, 57, -56, 96, 78, -51, 24, -59, -80,
      82, 77, 48, 88, -81, -61, 44, -1, -15, 62, -89, 21, -72, -4, -1, -84, 61, -59, -91, -87, 23,
      -9, -55, 34, 34, -13, 68, -95, -80, -36, -49, 97, 80, -50, -35, -6, -16, 91, 59, 74, 53, -48,
      -55, -25, -74, 81, -47, -98, -66, -62, -83, 24, -16, -35, 38
    };

    int target = -132;
    ThreeSumClosest threeSumClosest = new ThreeSumClosest();
    int i = threeSumClosest.dfsSolution(nums, target);
    assertEquals(-132, i);
  }

  @Test
  public void should_find_sum_closet() {
    int[] nums = {-1, 2, 1, -4};
    int target = 1;
    ThreeSumClosest threeSumClosest = new ThreeSumClosest();
    int res = threeSumClosest.threeSumClosest(nums, target);
    assertEquals(2, res);
  }
}
