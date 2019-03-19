package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class JewelsAndStonesTest {

  @Test
  public void should_find_even_in_unicode() {
    String stones = "你好我好大家都好";
    String jewels = "你我";
    JewelsAndStones jewelsAndStones = new JewelsAndStones();
    int counter = jewelsAndStones.numJewelsInStones(jewels, stones);
    assertEquals(2, counter);
  }
}
