package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestCommonPrefixTest {

  @Test
  public void should_find_longest_common_prefix() {
    String[] source = {"flower", "flow", "flight"};
    LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
    String res = longestCommonPrefix.longestCommonPrefix(source);

    assertEquals("fl", res);
  }
}
