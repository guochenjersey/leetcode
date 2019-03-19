package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeetCodeFindPeakElementTest {

  @Test
  public void should_find_peak_element() {
    int[] source = {1, 2, 3, 1};
    int[] source1 = {1, 2, 1, 3, 5, 6, 4};
    int[] source2 = {5, 4, 3, 2, 1};
    int[] source3 = {3};
    int[] source4 = {1, 2, 3};
    int[] source5 = {1, 2, 1, 2, 1};

    LeetCodeFindPeakElement findPeakElement = new LeetCodeFindPeakElement();
    assertEquals(2, findPeakElement.findPeakElement(source));
    assertEquals(5, findPeakElement.findPeakElement(source1));
    assertEquals(0, findPeakElement.findPeakElement(source2));
    assertEquals(0, findPeakElement.findPeakElement(source3));
    assertEquals(2, findPeakElement.findPeakElement(source4));
    assertEquals(3, findPeakElement.findPeakElement(source5));
  }
}
