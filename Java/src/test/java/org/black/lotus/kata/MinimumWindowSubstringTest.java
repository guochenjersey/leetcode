package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinimumWindowSubstringTest {

  @Test
  public void should_find_minimum_window_string() {
    String source = "asblasdbladjbadjab";
    String target = "asb";
    MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
    String res = minimumWindowSubstring.minWindow(source, target);
    assertEquals("asb", res);
  }

  @Test
  public void should_find_minimized_substring() {
    String source = "ABBCDDDDD";
    String target = "CD";
    MinimumWindowSubstring miniumWindowSubString = new MinimumWindowSubstring();
    String minFound = miniumWindowSubString.minWindow(source, target);
    assertEquals("CD", minFound);
  }

  @Test
  public void should_find_minimized_substring_today() {
    String source = "ABCED";
    String target = "CD";
    MinimumWindowSubstring miniumWindowSubString = new MinimumWindowSubstring();
    String minFound = miniumWindowSubString.minWindow(source, target);
    assertEquals("CED", minFound);
  }
}
