package org.black.lotus.kata;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class FindAllNumbersDisappearedInAnArrayTest {

  @Test
  public void should_find_all_disappeared_number() {
    int[] s = {4, 3, 2, 7, 8, 2, 3, 1};
    FindAllNumbersDisappearedInAnArray fa = new FindAllNumbersDisappearedInAnArray();
    List<Integer> res = fa.findDisappearedNumbers(s);
    List<Integer> expectedRes = Arrays.asList(5, 6);
    assertEquals(expectedRes, res);
  }
}
