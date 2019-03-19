package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class DailyTemperaturesTest {

  @Test
  public void should_find_temp_res() {
    int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
    int[] expectedRes = {1, 1, 4, 2, 1, 1, 0, 0};
    DailyTemperatures dailyTemperatures = new DailyTemperatures();
    int[] res = dailyTemperatures.dailyTemperatures(temp);

    assertArrayEquals(expectedRes, res);
  }
}
