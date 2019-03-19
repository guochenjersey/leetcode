package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindMinimumInRotatedSortedArrayTest {

  @Test
  public void should_find_minimum() {
    int[] source = {3, 4, 5, 1, 2};
    FindMinimumInRotatedSortedArray find = new FindMinimumInRotatedSortedArray();
    int min = find.findMin(source);
    assertEquals(1, min);

    int[] source1 = {4, 5, 6, 7, 0, 1, 2};
    int min1 = find.findMin(source1);
    assertEquals(0, min1);

    int[] source2 = {1};
    int min2 = find.findMin(source2);
    assertEquals(1, min2);

    int[] source3 = {2, 1};
    int min3 = find.findMin(source3);
    assertEquals(1, min3);

    int[] source4 = {2, 3, 1};
    int min4 = find.findMin(source4);
    assertEquals(1, min4);

    int[] source5 = {5, 1, 2, 3, 4};
    int min5 = find.findMin(source5);
    assertEquals(1, min5);
  }
}
