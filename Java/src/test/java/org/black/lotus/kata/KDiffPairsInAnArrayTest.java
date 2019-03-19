package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class KDiffPairsInAnArrayTest {

  @Test
  public void should_find_k_diff() {
    int[] source = {3, 1, 4, 1, 5};
    KDiffPairsInAnArray kDiffPairsInAnArray = new KDiffPairsInAnArray();
    int res = kDiffPairsInAnArray.findPairs(source, 2);
    assertEquals(2, res);

    source = new int[] {1, 2, 3, 4, 5};
    int res2 = kDiffPairsInAnArray.findPairs(source, 1);
    assertEquals(4, res2);

    source = new int[] {1, 3, 1, 5, 4};
    int res3 = kDiffPairsInAnArray.findPairs(source, 0);
    assertEquals(1, res3);

    source = new int[] {1, 2, 3, 4, 5};
    int res4 = kDiffPairsInAnArray.findPairs(source, 2);
    assertEquals(3, res4);

    source = new int[] {1, 1, 1, 1, 1};
    int res5 = kDiffPairsInAnArray.findPairs(source, 0);
    assertEquals(1, res5);
  }
}
