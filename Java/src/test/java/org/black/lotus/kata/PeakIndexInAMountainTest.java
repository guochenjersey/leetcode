package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class PeakIndexInAMountainTest {

  @Test
  public void should_find_peak() {
    int[] source1 = {0, 1, 0};
    int[] source2 = {0, 2, 1, 0};
    int[] source3 = {24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
    PeakIndexInAMountain peakIndexInAMountain = new PeakIndexInAMountain();
    int res1 = peakIndexInAMountain.peakIndexInMountainArray(source1);
    assertEquals(1, res1);
    int res2 = peakIndexInAMountain.peakIndexInMountainArray(source2);
    assertEquals(1, res2);
  }
}
