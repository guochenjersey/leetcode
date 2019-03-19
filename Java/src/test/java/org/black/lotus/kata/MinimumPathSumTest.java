package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinimumPathSumTest {

  @Test
  public void should_find_min_path_sum() {
    int[][] nums = {
      {
        1, 3, 1,
      },
      {1, 5, 1},
      {4, 2, 1}
    };
    MinimumPathSum minimumPathSum = new MinimumPathSum();
    int res = minimumPathSum.minPathSum(nums);

    assertEquals(7, res);
  }
}
