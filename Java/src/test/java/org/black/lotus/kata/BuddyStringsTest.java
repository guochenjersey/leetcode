package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class BuddyStringsTest {

  @Test
  public void should_find_buddy_string_1() {
    String s1 = "aaaaaaabc", s2 = "aaaaaaacb";
    BuddyStrings buddyStrings = new BuddyStrings();
    boolean res = buddyStrings.buddyStrings(s1, s2);
    assertTrue(res);
  }
}
