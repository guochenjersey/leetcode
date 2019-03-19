package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class SqrtXTest {

  @Test
  public void should_find_sqrt() {
    SqrtX sqrtX = new SqrtX();
    int res = sqrtX.mySqrt(8);
    assertEquals(2, res);

    assertEquals(3, sqrtX.mySqrt(9));
    System.out.println(sqrtX.mySqrt(Integer.MAX_VALUE));
  }
}
