package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinimumAddToMakeParenthesesValidTest {

  @Test
  public void should_find_minium() {
    MinimumAddToMakeParenthesesValid min = new MinimumAddToMakeParenthesesValid();
    assertEquals(1, min.minAddToMakeValid("())"));

    assertEquals(3, min.minAddToMakeValid("((("));
  }
}
