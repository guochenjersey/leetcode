package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class TheThirdMaximumNumberTest {

  @Test
  public void should_find_1() {
    int[] src = {3, 2, 1};
    TheThirdMaximumNumber theThirdMaximumNumber = new TheThirdMaximumNumber();
    int res = theThirdMaximumNumber.thirdMax(src);
    assertEquals(1, res);
  }

  @Test
  public void should_find_2() {
    int[] src = {1, 2};
    TheThirdMaximumNumber theThirdMaximumNumber = new TheThirdMaximumNumber();
    int res = theThirdMaximumNumber.thirdMax(src);
    assertEquals(2, res);
  }

  @Test
  public void should_find_3() {
    int[] src = {1, 2, 2, 3};
    TheThirdMaximumNumber theThirdMaximumNumber = new TheThirdMaximumNumber();
    int res = theThirdMaximumNumber.thirdMax(src);
    assertEquals(1, res);
  }

  @Test
  public void should_find_4() {
    int[] src = {-2147483648, 1, 1};
    TheThirdMaximumNumber theThirdMaximumNumber = new TheThirdMaximumNumber();
    int res = theThirdMaximumNumber.thirdMax(src);
    assertEquals(1, res);
  }

  @Test
  public void should_find_5() {
    int[] src = {1, 2};
    TheThirdMaximumNumber theThirdMaximumNumber = new TheThirdMaximumNumber();
    int res = theThirdMaximumNumber.thirdMax(src);
    assertEquals(2, res);
  }
}
