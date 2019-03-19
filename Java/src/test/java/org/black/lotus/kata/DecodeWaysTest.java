package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class DecodeWaysTest {

  @Test
  public void should_decode_ways() {
    DecodeWays decodeWays = new DecodeWays();
    assertEquals(2, decodeWays.numDecodings("12"));
    assertEquals(3, decodeWays.numDecodings("226"));
    assertEquals(0, decodeWays.numDecodings("0"));
    assertEquals(1, decodeWays.numDecodings("10"));
    assertEquals(0, decodeWays.numDecodings("50"));
    assertEquals(0, decodeWays.numDecodings("01"));
  }
}
