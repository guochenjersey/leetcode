package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotateStringTest {

  @Test
  public void should_test_abc() {
    char[] nums = "abcdefg".toCharArray();
    RotateString rotateString = new RotateString();
    rotateString.rotateString(nums, 3);
  }
}
