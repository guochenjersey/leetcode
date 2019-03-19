package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseStringIITest {

  @Test
  public void reverse_string_ii_test() {
    String s = "abcdefg";
    ReverseStringII reverseStringII = new ReverseStringII();
    String res = reverseStringII.reverseStr(s, 2);

    assertEquals("bacdfeg", res);
  }
}
