package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidMountainArrayTest {

  @Test
  public void should_validate_moutain_array() {
    int[] array = {3, 5, 5};
    ValidMountainArray validMountainArray = new ValidMountainArray();
    boolean res = validMountainArray.validMountainArray(array);

    assertFalse(res);

    int[] array1 = {0, 3, 2, 1};
    boolean res1 = validMountainArray.validMountainArray(array1);

    assertTrue(res1);
  }
}
