package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchInsertPositionTest {

  @Test
  public void should_insert_position() {
    int[] source = {1, 3, 5, 6};
    int target = 5;
    SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
    int pos = searchInsertPosition.searchInsert(source, target);
    assertEquals(2, pos);
  }

  @Test
  public void should_handle_overflow() {
    int[] source = {1, 3, 5, 6};
    int target = 7;
    SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
    int pos = searchInsertPosition.searchInsert(source, 7);
    assertEquals(4, pos);
  }
}
