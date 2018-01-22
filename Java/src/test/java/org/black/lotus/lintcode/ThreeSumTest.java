package org.black.lotus.lintcode;

import static org.junit.Assert.*;

import java.util.List;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class ThreeSumTest {

  @Test
  public void should_find_all_combinations() {
    int[] nums = {-1,0,1,2,-1,-4};
    ThreeSum threeSum = new ThreeSum();
    List<List<Integer>> lists = threeSum.threeSum(nums);
    System.out.println("test");
  }
}