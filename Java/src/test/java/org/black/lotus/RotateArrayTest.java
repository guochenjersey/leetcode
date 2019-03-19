package org.black.lotus;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class RotateArrayTest {

  private RotateArray rotateArray;

  @Before
  public void setup() {
    rotateArray = new RotateArray();
  }

  @Test
  public void should_rotate() {
    int[] nums = {1, 2, 3, 4, 5, 6, 7};
    rotateArray.rotate(nums, 3);
    Arrays.stream(nums).forEach(System.out::println);
  }

  @Test
  public void should_o1_rotate() {
    int[] nums = {1, 2, 3, 4, 5, 6, 7};
    rotateArray.o1Rotate(nums, 3);
    Arrays.stream(nums).forEach(System.out::println);
  }
}
