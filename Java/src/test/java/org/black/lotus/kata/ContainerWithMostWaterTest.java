package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContainerWithMostWaterTest {

  @Test
  public void should_find_max_container() {
    int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
    int area = containerWithMostWater.maxArea(height);
    assertEquals(area, 49);
  }
}
