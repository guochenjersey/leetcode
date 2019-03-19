package org.black.lotus.kata;

import java.util.*;
import org.black.lotus.marker.*;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * <p>insert(val): Inserts an item val to the set if not already present. remove(val): Removes an
 * item val from the set if present. getRandom: Returns a random element from current set of
 * elements. Each element must have the same probability of being returned. Example:
 *
 * <p>// Init an empty set. RandomizedSet randomSet = new RandomizedSet();
 *
 * <p>// Inserts 1 to the set. Returns true as 1 was inserted successfully. randomSet.insert(1);
 *
 * <p>// Returns false as 2 does not exist in the set. randomSet.remove(2);
 *
 * <p>// Inserts 2 to the set, returns true. Set now contains [1,2]. randomSet.insert(2);
 *
 * <p>// getRandom should return either 1 or 2 randomly. randomSet.getRandom();
 *
 * <p>// Removes 1 from the set, returns true. Set now contains [2]. randomSet.remove(1);
 *
 * <p>// 2 was already in the set, so return false. randomSet.insert(2);
 *
 * <p>// Since 2 is the only number in the set, getRandom always return 2. randomSet.getRandom();
 */
@LeetCode
@Medium
@FirstRound
@NotAccepted
@NoIdeaOrBadIdeaInitially
public class InsertDeleteGetRandomO1 {

  private HashSet<Integer> valueSet;
  private Random random;

  public InsertDeleteGetRandomO1() {
    random = new Random(System.currentTimeMillis());
    valueSet = new LinkedHashSet<>();
  }

  /**
   * Inserts a value to the set. Returns true if the set did not already contain the specified
   * element.
   */
  public boolean insert(int val) {
    return valueSet.add(val);
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    return valueSet.remove(val);
  }

  /** Get a random element from the set. */
  public int getRandom() {
    int nextRandom = random.nextInt(valueSet.size());
    Iterator<Integer> iterator = valueSet.iterator();

    for (int i = 0; i < nextRandom; ++i) {
      Integer res = iterator.next();
      if (i == nextRandom - 1) {
        return res;
      }
    }

    return 0;
  }
}
