package org.black.lotus;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * <pre>
 * What if duplicates are allowed at most twice?
 *
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 * </pre>
 */
public class Kata80 {

  public static int removeDuplicate(int[] input) {
    if (input == null || input.length == 0) {
      return 0;
    }
    int size = 0;
    Map<Integer, Integer> seenTimes = new HashMap<Integer, Integer>();
    for (int current = 0, next = 1; current < input.length; ++current, ++next) {
      if (seenTimes.get(input[current]) == null || seenTimes.get(input[current]) < 2) {
        int counter;
        if (seenTimes.get(input[current]) == null) {
          counter = 1;
        } else {
          counter = seenTimes.get(input[current]);
          ++counter;
        }
        seenTimes.put(input[current], counter);
        input[size++] = input[current];
      }

      if (next < input.length && input[current] != input[next]) {
        seenTimes.clear();
      }
    }
    return size;
  }
}
