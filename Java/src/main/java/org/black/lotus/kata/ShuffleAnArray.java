package org.black.lotus.kata;

import java.util.Arrays;
import java.util.Random;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.Important;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

/**
 * Shuffle a set of numbers without duplicates.
 *
 * <p>Example:
 *
 * <p>// Init an array with set 1, 2, and 3. int[] nums = {1,2,3}; Solution solution = new
 * Solution(nums);
 *
 * <p>// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally
 * likely to be returned. solution.shuffle();
 *
 * <p>// Resets the array back to its original configuration [1,2,3]. solution.reset();
 *
 * <p>// Returns the random shuffling of array [1,2,3]. solution.shuffle();
 */
@LeetCode
@FirstRound
@Medium
@Important
public class ShuffleAnArray {
  private int[] original;
  private int[] shuffled;
  private Random random;

  public ShuffleAnArray(int[] nums) {
    this.original = nums;
    this.shuffled = Arrays.copyOf(nums, nums.length);
    this.random = new Random(System.currentTimeMillis());
  }

  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    return Arrays.copyOf(original, original.length);
  }

  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
    for (int i = 0; i < original.length; ++i) {
      // Note how we construct shuffle rules here
      int idx = random.nextInt(original.length - i);
      int temp = shuffled[i];
      shuffled[i] = shuffled[idx];
      shuffled[idx] = temp;
    }

    return shuffled;
  }
}
