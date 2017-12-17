package org.black.lotus;

import static org.black.lotus.Kata80.removeDuplicate;
import static org.junit.Assert.*;

import org.junit.Test;

public class Kata80Test {

  @Test
  public void should_return_0_if_no_input() {
    assertEquals(0, removeDuplicate(null));
    assertEquals(0, removeDuplicate(new int[0]));
  }

  @Test
  public void should_return_no_more_2_times_duplicate_size() {
    int[] input = new int[] {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5};
    int actualSize = removeDuplicate(input);
    assertEquals(9, actualSize);
  }
}
