package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindNoDuplicationTest {

  @Test
  public void should_find_duplicate() {
    int[] source = {1, 1, 2, 2, 3};
    FindNoDuplication findNoDuplication = new FindNoDuplication();
    int res = findNoDuplication.findNoDuplication(source);
    assertEquals(3, res);
  }
}
