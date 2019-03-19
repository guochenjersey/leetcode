package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.List;
import org.black.lotus.marker.*;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 *
 * <p>Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to
 * reach the top of the floor, and you can either start from the step with index 0, or the step with
 * index 1.
 *
 * <p>Example 1: Input: cost = [10, 15, 20] Output: 15 Explanation: Cheapest is start on cost[1],
 * pay that cost and go to the top. Example 2: Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6 Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 */
@LeetCode
@Easy
@FirstRound
@DP
public class MinCostClimbingStairs {

  public int minCostClimbingStairs(int[] cost) {
    int[] dp = new int[cost.length];
    if (cost.length == 1) {
      return cost[0];
    }

    dp[0] = cost[0];
    dp[1] = cost[1];

    for (int i = 2; i < cost.length; ++i) {
      dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
    }

    return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
  }

  @TLESolution
  public int minCostClimbingStairsTLE(int[] cost) {
    int startFrom0 = minCost(new ArrayList<>(), 0, Integer.MAX_VALUE, cost);
    int startFrom1 = minCost(new ArrayList<>(), 1, Integer.MAX_VALUE, cost);

    return Math.min(startFrom0, startFrom1);
  }

  private int minCost(List<Integer> paths, int currentStep, int currentMinCost, int[] cost) {
    if (currentStep >= cost.length) {
      int c = paths.stream().mapToInt(i -> i).sum();
      return Math.min(c, currentMinCost);
    }

    paths.add(cost[currentStep]);
    int stepOneMinCost = minCost(new ArrayList<>(paths), currentStep + 1, currentMinCost, cost);
    int stepTwoMinCost = minCost(new ArrayList<>(paths), currentStep + 2, currentMinCost, cost);
    currentMinCost = Math.min(Math.min(stepOneMinCost, stepTwoMinCost), currentMinCost);

    return currentMinCost;
  }
}
