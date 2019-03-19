package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinCostClimbingStairsTest {

  @Test
  public void should_find_min_cost_climbing_stairs() {
    MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
    int[] stairs = {10, 15, 20};
    int minCost = minCostClimbingStairs.minCostClimbingStairs(stairs);
    assertEquals(15, minCost);

    int[] stairs2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
    assertEquals(6, minCostClimbingStairs.minCostClimbingStairs(stairs2));
  }
}
