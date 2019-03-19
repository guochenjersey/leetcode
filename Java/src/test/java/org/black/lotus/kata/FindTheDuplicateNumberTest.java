package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindTheDuplicateNumberTest {

  @Test
  public void should_find_duplicate() {
    int[] source = {1, 3, 4, 2, 2};
    FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();
    int duplicate = findTheDuplicateNumber.findDuplicate(source);
    assertEquals(2, duplicate);
  }
}
