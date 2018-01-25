package org.black.lotus.lintcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchForARangeTest {

  @Test
  public void should_return_1_1() {
    int[] nums = {1};
    int target = 1;
    SearchForARange searchForARange = new SearchForARange();
    int[] res = searchForARange.searchRange(nums, target);
    assertEquals(res[0], 0);
    assertEquals(res[0], 0);
  }

  @Test
  public void should_return_2_1() {
    int[] nums = {2, 2};
    int target = 2;
    SearchForARange searchForARange = new SearchForARange();
    int[] res = searchForARange.searchRange(nums, target);
    assertEquals(0, res[0] );
    assertEquals(1, res[1]);
  }

  @Test
  public void should_return_1_3() {
    int[] nums = {1, 2, 3};
    int target = 1;
    SearchForARange searchForARange = new SearchForARange();
    int[] res = searchForARange.searchRange(nums, target);
    assertEquals(0, res[0] );
    assertEquals(0, res[1]);
  }
}