package org.black.lotus.kata;

import java.util.HashMap;
import java.util.Map;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the
 * stones you have. Each character in S is a type of stone you have. You want to know how many of
 * the stones you have are also jewels.
 *
 * <p>The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters
 * are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * <p>Example 1:
 *
 * <p>Input: J = "aA", S = "aAAbbbb" Output: 3 Example 2:
 *
 * <p>Input: J = "z", S = "ZZ" Output: 0 Note:
 *
 * <p>S and J will consist of letters and have length at most 50. The characters in J are distinct.
 * TODO
 */
@LeetCode
@Easy
@FirstRound
public class JewelsAndStones {

  public int numJewelsInStones(String jewels, String stones) {
    if (stones == null || stones.length() == 0) {
      return 0;
    }

    Map<Character, Integer> jewelsMap = new HashMap<>();
    for (char c : stones.toCharArray()) {
      jewelsMap.putIfAbsent(c, 0);
      jewelsMap.computeIfPresent(c, (Character k, Integer v) -> ++v);
    }

    int counter = 0;
    for (char c : jewels.toCharArray()) {
      counter += jewelsMap.getOrDefault(c, 0);
    }

    return counter;
  }
}
