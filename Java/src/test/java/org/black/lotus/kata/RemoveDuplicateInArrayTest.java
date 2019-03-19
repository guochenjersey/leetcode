package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveDuplicateInArrayTest {

  @Test
  public void should_find_correct() {
    int[] nums = {
      -3, 8, -3, -5, -8, 1, 4, -5, -6, -10, 2, 10, 9, 10, 5, -1, -6, 5, 1, -1, -4, 9, 0, 9, -4, -5,
      -4, 8, 0, -3, 6, 8, 5, -8, -7, -6, -6, -1, 6, -3, -7, 2, -4, 1, 8, -1, 6, 0, -9, -8, -3, -10,
      0, -5, -2, 10, -6, -4, -1, 4, -3, -10, -8, 3, 7, 4, 10, -6, 4, -1, 7, -9, 7, 0, 5, 7, -5, -7,
      -6, -3
    };

    RemoveDuplicateInArray removeDuplicateInArray = new RemoveDuplicateInArray();
    removeDuplicateInArray.deduplication(nums);
  }
}
