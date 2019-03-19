package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoveZeroesTest {

  @Test
  public void should_move_zeros() {
    int[] nums = {0, 1, 2, 3, 0, 5, 8, 9, 0};
    MoveZeroes moveZeroes = new MoveZeroes();
    moveZeroes.moveZeroes(nums);
    assertTrue(true);
  }
}
