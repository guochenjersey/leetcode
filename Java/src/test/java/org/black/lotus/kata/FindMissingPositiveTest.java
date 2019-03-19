package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindMissingPositiveTest {

  @Test
  public void should_find_3() {
    int[] source = {0, 1, 2};
    FindMissingPositive findMissingPositive = new FindMissingPositive();
    int res = findMissingPositive.firstMissingPositive(source);
    assertEquals(3, res);
  }
}
