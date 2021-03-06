package org.black.lotus.kata;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;

public class CombinationSumIITest {

  @Test
  public void should_combine_sum() {
    int[] nums = {10, 1, 2, 7, 6, 1, 5};
    CombinationSumII combinationSumII = new CombinationSumII();
    List<List<Integer>> res = combinationSumII.combinationSum2(nums, 8);

    assertEquals(4, res.size());
  }
}
