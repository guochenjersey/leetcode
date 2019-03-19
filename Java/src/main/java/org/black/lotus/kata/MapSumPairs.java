package org.black.lotus.kata;

import java.util.TreeMap;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

/**
 * Implement a MapSum class with insert, and sum methods.
 *
 * <p>For the method insert, you'll be given a pair of (string, integer). The string represents the
 * key and the integer represents the value. If the key already existed, then the original key-value
 * pair will be overridden to the new one.
 *
 * <p>For the method sum, you'll be given a string representing the prefix, and you need to return
 * the sum of all the pairs' value whose key starts with the prefix.
 *
 * <p>Example 1: Input: insert("apple", 3), Output: Null Input: sum("ap"), Output: 3 Input:
 * insert("app", 2), Output: Null Input: sum("ap"), Output: 5
 */
@LeetCode
@Medium
public class MapSumPairs {

  private TreeMap<String, Integer> treeMap;
  /** Initialize your data structure here. */
  public MapSumPairs() {
    treeMap = new TreeMap<>();
  }

  public void insert(String key, int val) {
    treeMap.put(key, val);
  }

  public int sum(String prefix) {
    String key = treeMap.ceilingKey(prefix);
    int sum = 0;
    while (key != null) {
      if (key.startsWith(prefix)) {
        sum += treeMap.get(key);
        key = treeMap.higherKey(key);
      } else {
        break;
      }
    }

    return sum;
  }
}
