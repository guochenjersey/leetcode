package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReachANumberTest {

  @Test
  public void should_find_min_steps() {
    int target = 1;
    ReachANumber reachANumber = new ReachANumber();
    int res = reachANumber.reachNumber(target);
    assertEquals(1, res);
  }
}
