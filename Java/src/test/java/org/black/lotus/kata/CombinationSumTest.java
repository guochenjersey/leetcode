package org.black.lotus.kata;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;

public class CombinationSumTest {

  @Test
  public void should_combinate_sum() {
    int[] source = {2, 3, 6, 7};
    CombinationSum combinationSum = new CombinationSum();
    List<List<Integer>> res = combinationSum.combinationSum(source, 7);
    assertEquals(res.size(), 2);
  }
}
