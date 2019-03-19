package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContainsDuplicateIITest {

  @Test
  public void should_find_duplicate() {
    int[] nums = {1, 2, 3, 1, 2, 3};
    ContainsDuplicateII containsDuplicateII = new ContainsDuplicateII();
    boolean res = containsDuplicateII.containsNearbyDuplicate(nums, 2);
    assertFalse(res);

    int[] nums1 = {1, 0, 1, 1};
    boolean res1 = containsDuplicateII.containsNearbyDuplicate(nums1, 1);
    assertTrue(res1);
  }
}
