package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class FirstPositionOfTargetTest {

  @Test
  public void should_find_taget() {
    int[] nums = {2, 6, 8, 13, 15, 17, 17, 18, 19, 20};
    int target = 15;
    FirstPositionOfTarget firstPositionOfTarget = new FirstPositionOfTarget();
    int position = firstPositionOfTarget.binarySearch(nums, target);
    assertEquals(4, position);
  }

  @Test
  public void should_find_target() {
    int[] nums = {3, 4, 5, 8, 8, 8, 8, 10, 13, 14};
    int target = 8;
    FirstPositionOfTarget firstPositionOfTarget = new FirstPositionOfTarget();
    int position = firstPositionOfTarget.binarySearch(nums, target);
    assertEquals(3, position);
  }
}
